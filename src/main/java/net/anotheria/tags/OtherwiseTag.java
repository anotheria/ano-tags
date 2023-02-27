package net.anotheria.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.BodyTagSupport;

public class OtherwiseTag extends BodyTagSupport {
	
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		
		if(getParent() instanceof ChooseTag) {
			if(((ChooseTag) getParent()).isOneConditionTrue()) {
				return SKIP_BODY;
			}
			return EVAL_BODY_INCLUDE;
		}
		return SKIP_BODY;
	}
}
