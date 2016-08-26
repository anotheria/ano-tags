package net.anotheria.tags;

import javax.servlet.jsp.JspException;

/**
 * Tag that shows it's content if matching condition is true.
 *
 * @author dsilenko
 */
public class MatchTag extends CompareTagBase {

	/**
	 * Serial uid version.
	 */
	private static final long serialVersionUID = 4860545220769296487L;
	/**
	 * The location where the match must exist (<code>start</code> or
	 * <code>end</code>), or <code>null</code> for anywhere.
	 */
	private String location = null;

	public String getLocation() {
		return (this.location);
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	protected boolean condition() throws JspException {
		return isMatch();
	}

	/**
	 * Determines if property matched with value or second property if value is null.
	 *
	 * @return true if matched, otherwise - false.
	 * @throws JspException
	 */
	protected boolean isMatch() throws JspException {
		String value = getValue();
		if (value == null) {
			Object valueObject = TagUtils.lookup(pageContext, getScope(), getName2(), getProperty2());
			try {
				value = String.class.cast(valueObject);
			} catch (ClassCastException e) {
				throw new JspException("Value could not be set using name2 and property2 (bean not found or property returned null)");
			}
		}

		String variable;
		try {
			variable = String.class.cast(evaluateVariable(getName(), getProperty()));
		} catch (ClassCastException e) {
			throw new JspException("'match' tag must be provided with name/property that matches string and not null");
		}

		if (location == null)
			return (variable.indexOf(value) >= 0);

		if (location.equals("start"))
			return variable.startsWith(value);

		if (location.equals("end")) {
			return variable.endsWith(value);
		}

		throw new JspException("Value could not be set using name2 and property2 (bean not found or property returned null)");
	}

}
