package net.anotheria.tags;

import java.util.Collection;
import javax.servlet.jsp.JspException;

public class ContainsTag extends CompareTagBase {

	@Override
	protected boolean condition() throws JspException {
		// if value is not specified try to use name2 and property2
		if(value == null) {
			Object valueObject = TagUtils.lookup(pageContext, getScope(), name2, property2);
			if(valueObject == null) {
				throw new JspException("Value could not be set using name2 and property2 (bean not found or property returned null)");
			}
			value = valueObject + "";
		}
		Object variable = evaluateVariable(getName(), getProperty());
		if (variable == null) {
			throw new JspException("'contains' tag must be provided with name/property that matches collection not null");
		}
		if (!(variable instanceof Collection)) {
			throw new JspException("'contains' tag must be provided with name/property that matches collection");
		}
		Collection c = (Collection) variable;
		return c.contains(value);
	}
	
}
