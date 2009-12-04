package net.anotheria.tags;

import javax.servlet.jsp.JspException;

public class PresentTag extends ConditionalTagBase {

	private static final long serialVersionUID = 1L;

	@Override protected boolean condition() throws JspException {
		return (condition(true));
	}

	protected boolean condition(boolean desired) throws JspException {
		boolean present = false;

		if (getName() != null) {
			try {
				Object value = lookup();
				present = (value != null);
			} catch (JspException e) {
			}
		} else {
			throw new JspException("Attribute 'name' was not specified");
		}

		return (present == desired);

	}
}
