package net.anotheria.tags;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.jsp.JspException;

/**
 * This tag works like the <jsp:include> tag extended it by the possibility
 * to get the pagename dynamically from a bean (specifing its name with 'name' and 'property' attributes)
 * 
 * @author oliver
 */
public class IncludeTag extends BaseTagSupport {

	private static final long serialVersionUID = 2189196541512959012L;

	private String page;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public int doEndTag() throws JspException {
		
		if(page == null) {
			page = lookup()+"";
		}
		ServletRequest request = pageContext.getRequest();
		ServletResponse response = pageContext.getResponse();
		RequestDispatcher rd = request.getRequestDispatcher(page);
		try {
			rd.include(request, response);
		} catch (ServletException e) {
			throw new JspException("Error dispatching to page " + page);
		} catch (IOException e) {
			throw new JspException("Error dispatching to page " + page);
		}
		
		page = null;
		return super.doEndTag();
	}
	

}
