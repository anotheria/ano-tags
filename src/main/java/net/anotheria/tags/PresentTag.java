package net.anotheria.tags;

import jakarta.servlet.jsp.JspException;

public class PresentTag extends ConditionalTagBase {

	private static final long serialVersionUID = 1L;

	@Override protected boolean condition() throws JspException {
		return (condition(true));
	}

	protected boolean condition(boolean desired) throws JspException {
		return (lookup() != null) == desired;

	}
}
