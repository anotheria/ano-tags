package net.anotheria.tags;

import jakarta.servlet.jsp.JspException;
import java.util.Collection;

public class ContainsTag extends CompareTagBase {

	@Override
	protected boolean condition() throws JspException {
		// if value is not specified try to use name2 and property2
		Object valueObject = getValue();
		if(valueObject == null) {
			valueObject = TagUtils.lookup(pageContext, getScope(), getName2(), getProperty2());
			if(valueObject == null) {
				throw new JspException("Value could not be set using name2 and property2 (bean not found or property returned null)");
			}
		}
		Object variable = evaluateVariable(getName(), getProperty());
		if (variable == null) {
			throw new JspException("'contains' tag must be provided with name/property that matches collection not null");
		}
		if (!(variable instanceof Collection)) {
			throw new JspException("'contains' tag must be provided with name/property that matches collection");
		}
		Collection c = (Collection) variable;
		return c.contains(valueObject);
	}
	
}
