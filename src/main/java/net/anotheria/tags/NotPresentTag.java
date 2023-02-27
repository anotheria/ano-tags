package net.anotheria.tags;

import jakarta.servlet.jsp.JspException;

public class NotPresentTag extends PresentTag {

	private static final long serialVersionUID = 1L;

	@Override protected boolean condition() throws JspException {
		return (condition(false));
	}
}
