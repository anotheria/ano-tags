package net.anotheria.tags;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.jsp.JspException;

import org.apache.commons.beanutils.PropertyUtils;

public abstract class CompareTagBase extends ConditionalTagBase {

	private static final long serialVersionUID = 1L;
	
	protected static final int DOUBLE_COMPARE = 0;
	protected static final int LONG_COMPARE = 1;
	protected static final int STRING_COMPARE = 2;

	private String value = null;
	
	private String name2 =null;
	
	private String property2 = null;


	/**
	 * This is the value which should be compared to the value provided by the bean specified using
	 * name and property attribute.
	 */
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * If value is not set you can use name2 and property2 to specify a second bean which provides the value
	 */
	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	/**
	 * If value is not set you can use name2 and property2 to specify a second bean which provides the value
	 */
	public String getProperty2() {
		return property2;
	}

	public void setProperty2(String property2) {
		this.property2 = property2;
	}

	public void release() {
		super.release();
		value = null;
		name2 = null;
		property2 = null;
	}

	protected boolean condition(int desired1, int desired2) throws JspException {

		// if value is not specified try to use name2 and property2
		if(value == null) {
			Object valueObject = TagUtils.lookup(pageContext, getScope(), name2, property2);
			if(valueObject == null) {
				throw new JspException("Value could not be set using name2 and property2 (bean not found or property returned null)");
			}
			value = valueObject + "";
		}
		
		// Acquire the value and determine the test type
		int type = -1;
		double doubleValue = 0.0;
		long longValue = 0;
		if ((type < 0) && (value.length() > 0)) {
			try {
				doubleValue = Double.parseDouble(value);
				type = DOUBLE_COMPARE;
			} catch (NumberFormatException e) {
			}
		}
		if ((type < 0) && (value.length() > 0)) {
			try {
				longValue = Long.parseLong(value);
				type = LONG_COMPARE;
			} catch (NumberFormatException e) {
			}
		}
		if (type < 0) {
			type = STRING_COMPARE;
		}

		String name = getName();
		String property = getProperty();
		
		Object variable = null;
		if (name != null) {
			Object bean = pageContext.findAttribute(name);
			if (property != null) {
				if (bean == null) {
					throw new JspException("No bean found under attribute key "	+ name);
				}
				try {
					variable = PropertyUtils.getProperty(bean, property);
				} catch (InvocationTargetException e) {
					Throwable t = e.getCause();
					if (t == null)
						t = e;
					throw new JspException("Exception accessing property "
							+ property + " for bean " + name + ": "
							+ t.toString());
				} catch (Throwable t) {
					throw new JspException("Exception accessing property "
							+ property + " for bean " + name + ": "
							+ t.toString());
				}
			} else {
				variable = bean;
			}
		} else {
			throw new JspException("Attribute 'name' was not specified");
		}
		if (variable == null) {
			variable = ""; // Coerce null to a zero-length String
		}
		
		// Perform the appropriate comparison
		int result = 0;
		if (type == DOUBLE_COMPARE) {
			try {
				result = Double.compare(
						Double.parseDouble(variable.toString()), doubleValue);
			} catch (NumberFormatException e) {
				result = variable.toString().compareTo(value);
			}
		} else if (type == LONG_COMPARE) {
			try {
				long longVariable = Long.parseLong(variable.toString());
				if (longVariable < longValue)
					result = -1;
				else if (longVariable > longValue)
					result = +1;
			} catch (NumberFormatException e) {
				result = variable.toString().compareTo(value);
			}
		} else {
			result = variable.toString().compareTo(value);
		}

		if (result < 0)
			result = -1;
		else if (result > 0)
			result = +1;

		// Return true if the result matches either desired value
		return ((result == desired1) || (result == desired2));

	}

}
