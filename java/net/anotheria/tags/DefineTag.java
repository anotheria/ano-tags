package net.anotheria.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

public class DefineTag extends BaseBodyTagSupport {

	private static final long serialVersionUID = 1L;

	private String body = null;
	private String value = null;

	private String type = null;
	private String toScope = null;


    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getToScope() {
    	return toScope;
    }
    public void setToScope(String toScope) {
    	this.toScope = toScope;
    }
    public String getValue() {
    	return value;
    }
    public void setValue(String value) {
    	this.value = value;
    }

    @SuppressWarnings("deprecation")
    public int doStartTag() throws JspException {
        return (EVAL_BODY_TAG);
    }

    public int doAfterBody() throws JspException {

        if (bodyContent != null) {
            body = bodyContent.getString();
            if (body != null) {
                body = body.trim();
            }
            if (body.length() < 1) {
                body = null;
            }
        }
        return (SKIP_BODY);

    }

    public int doEndTag() throws JspException {
        int n = 0;
        if (value != null) n++;
        if (body != null) n++;
        if (getName() != null) n++;
        if (n != 1)
            throw new JspException("Define tag should contain exactly one of value, name or body");

        Object defObject = value;
        if (body != null) {
        	defObject = body;
        }
        if (getName() != null) {
            defObject = lookup();
        }
        if (defObject == null) {
            throw new JspException("Define tag cannot set a null value");
        }
        //expose bean
        int inScope = PageContext.PAGE_SCOPE;
        if (toScope != null) {
        	try {
				inScope = TagUtils.getScope(toScope);
        	} catch (JspException e) {}
        }
            
        pageContext.setAttribute(getId(), defObject, inScope);

        return (EVAL_PAGE);
    }

    public void release() {
        super.release();
        body = null;
        type = null;
        toScope = null;
    }
    
}
