package net.anotheria.tags;

import javax.servlet.jsp.JspException;

public abstract class ConditionalTagBase extends BaseTagSupport {

	private static final long serialVersionUID = 1L;

	protected abstract boolean condition() throws JspException;
	
    public int doStartTag() throws JspException {
        return condition() ? EVAL_BODY_INCLUDE : SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

}