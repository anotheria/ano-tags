package net.anotheria.tags;

import javax.servlet.jsp.JspException;

public class NotEmptyTag extends EmptyTag {

	private static final long serialVersionUID = 1L;

	@Override protected boolean condition() throws JspException {
		return !isEmpty();
	}
}
