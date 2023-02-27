package net.anotheria.tags;

import jakarta.servlet.jsp.JspException;

public class EqualTag extends CompareTagBase {

	private static final long serialVersionUID = 1L;

	@Override protected boolean condition() throws JspException {
		return (condition(0, 0));
	}

}
