package net.anotheria.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * Parent Tag for a if/if/if/else construct.
 * Every Tag inherited by <code>ConditionalTagBase</code> may be a child-tag without
 * any changing result. But you may use as last tag within the ChooseTag the OtherwiseTag
 * to output its body only when all other conditions within the ChooseTag were false.
 * 
 * @author oliver
 */
public class ChooseTag extends BodyTagSupport {
	
	private static final long serialVersionUID = 1L;
	
	private boolean oneConditionTrue = false;
	
	public int doStartTag() throws JspException {
		oneConditionTrue = false;
		return EVAL_BODY_INCLUDE;
	}

	public boolean isOneConditionTrue() {
		return oneConditionTrue;
	}
	
	public void setCondition(boolean condition) {
		if(condition) {
			oneConditionTrue = true;
		}
	}
	
	public int doAfterBody() throws JspException {
		oneConditionTrue = false;
		return super.doAfterBody();
	}
}
