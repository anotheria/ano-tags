package net.anotheria.tags;

import net.anotheria.util.IdCodeGenerator;
import net.anotheria.util.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

public class RandomTag extends BaseTagSupport {

	/**
	 *	Serial Version ID 
	 */
	private static final long serialVersionUID = -808848857807480451L;
	
	private int length = IdCodeGenerator.CODE_LENGTH;

	/**
	 * Writes size of a specified collection to page contest.
	 * 
	 * exception if collection not found or class is not supported
	 */
	@Override
	public int doStartTag() throws JspException {
		String rnd = IdCodeGenerator.generateCode(length);
		if(StringUtils.isEmpty(getId()))
			write(rnd);
		else
			pageContext.setAttribute(getId(), rnd, PageContext.PAGE_SCOPE);
		return (SKIP_BODY);
	}

	public void setLength(int length) {
		this.length = length;
	}

}
