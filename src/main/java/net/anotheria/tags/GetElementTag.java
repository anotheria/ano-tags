package net.anotheria.tags;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

public class GetElementTag extends BaseTagSupport {

	/**
	 *	Serial Version ID 
	 */
	private static final long serialVersionUID = -808848857807480351L;

	/**
	 * Writes size of a specified collection to page contest.
	 * 
	 * @exception if
	 *                collection not found or class is not supported
	 */
	
	private int index;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public int doStartTag() throws JspException {
		
		Object collectionObj = lookup();

		if (collectionObj == null)
			throw new JspException("Collection not found: " + toString());

		// Identify the number of elements, based on the collection type
		Object element = null;
		if (collectionObj.getClass().isArray()) {
			element = Array.get(collectionObj, index);
		}

		else if (collectionObj instanceof List) {
			element = ((List<?>) collectionObj).get(index);
		} else if (collectionObj instanceof Map) {
			element = ((Map<?, ?>) collectionObj).get(index);
		} else {
			throw new JspException("Unsupported collection class: " + collectionObj.getClass());
		}

		pageContext.setAttribute(getId(), element, PageContext.PAGE_SCOPE);
		return (SKIP_BODY);

	}

}
