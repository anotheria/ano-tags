package net.anotheria.tags;

import jakarta.servlet.jsp.JspException;

public class NotEqualTag extends CompareTagBase {

	private static final long serialVersionUID = 1L;

	@Override protected boolean condition() throws JspException {
		return (condition(1, -1));
	}

}
