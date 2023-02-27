package net.anotheria.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.PageContext;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * This tag stores size of a collection into a variable. This tag supports Collections, Maps and Arrays.
 */
public class SizeTag extends BaseTagSupport {

	/**
	 *	Serial Version ID.
	 */
	private static final long serialVersionUID = -808848857807480351L;

	/**
	 * Writes size of a specified collection to page contest.
	 * 
	 * Exception if collection not found or class is not supported.
	 */
	@Override
	public int doStartTag() throws JspException {

		Object collectionObj = lookup();

		if (collectionObj == null)
			throw new JspException("Collection not found: " + toString());

		// Identify the number of elements, based on the collection type
		int size = 0;
		if (collectionObj.getClass().isArray()) {
			size = Array.getLength(collectionObj);
		}

		else if (collectionObj instanceof Collection) {
			size = ((Collection<?>) collectionObj).size();
		} else if (collectionObj instanceof Map) {
			size = ((Map<?, ?>) collectionObj).size();
		} else {
			throw new JspException("Unsupported collection class: " + collectionObj.getClass());
		}

		pageContext.setAttribute(getId(), Integer.valueOf(size), PageContext.PAGE_SCOPE);
		return (SKIP_BODY);

	}

}
