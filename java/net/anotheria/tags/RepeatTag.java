package net.anotheria.tags;

import javax.servlet.jsp.JspException;

public class RepeatTag extends BaseBodyTagSupport {

	private static final long serialVersionUID = 1L;
	protected String id = null;
	protected String lastId = null;
	protected int count;

	protected int repeatsCount = 0;
	protected boolean started = false;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastId() {
		return lastId;
	}
	public void setLastId(String last) {
		this.lastId = last;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public int doStartTag() throws JspException {
		
		if(count == 0){
			Object countObj = lookup();
			if(countObj instanceof Integer)
				count = (Integer) countObj;
		}
		
		if(count == 0)
			return SKIP_BODY;
		
		repeatsCount = 1;
		
		if(id != null)
			pageContext.setAttribute(id, Integer.valueOf(repeatsCount - 1));
		if(lastId != null)
			pageContext.setAttribute(lastId, repeatsCount == count);
		
		return EVAL_BODY_AGAIN;
	}

	public int doAfterBody() throws JspException {

		// Render the output from this iteration to the output stream
		if (bodyContent != null) {
			TagUtils.writePrevious(pageContext, bodyContent.getString());
			bodyContent.clearBody();
		}
		
		// Decide whether to repeat
		if (repeatsCount < count) {
			repeatsCount++;
			if(id != null)
				pageContext.setAttribute(id, Integer.valueOf(repeatsCount - 1));
			if(lastId != null)
				pageContext.setAttribute(lastId, repeatsCount == count);
			return EVAL_BODY_AGAIN;
		}
		
		return SKIP_BODY;

	}

	public int doEndTag() throws JspException {
		started = false;
		return EVAL_PAGE;
	}

	public void release() {
		super.release();
		repeatsCount = 0;
		started = false;
	}

}
