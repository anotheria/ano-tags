package net.anotheria.tags;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;

import net.anotheria.tags.util.EnumerationIterator;

public class IterateTag extends BaseBodyTagSupport {

	private static Logger log = Logger.getLogger(IterateTag.class);
	
	private static final long serialVersionUID = 1L;
	protected String indexId = null;
	protected String type = null;
	protected int limit;
	protected int offset;
	protected String lastId = null;

	protected Iterator<?> iterator = null;
	protected int lengthCount = 0;
	protected boolean started = false;

	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public int getIndex() {
		return started ? lengthCount - 1 : 0;
	}
	public String getIndexId() {
		return indexId;
	}
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	public String getType() {
		return (this.type);
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLastId() {
		return lastId;
	}
	public void setLastId(String last) {
		this.lastId = last;
	}

	@SuppressWarnings({"unchecked", "deprecation"})
	public int doStartTag() throws JspException {
		Object collection = lookup();
		if (collection == null) {
			log.warn("No collection found! name=" + getName() + ", property=" + getProperty());
			return (SKIP_BODY);
		}

		if (collection.getClass().isArray()) {
			try {
				iterator = Arrays.asList((Object[]) collection).iterator();
			} catch (ClassCastException e) {
				int length = Array.getLength(collection);
				ArrayList c = new ArrayList(length);
				for (int i = 0; i < length; i++) {
					c.add(Array.get(collection, i));
				}
				iterator = c.iterator();
			}
		} else if (collection instanceof Collection) {
			iterator = ((Collection) collection).iterator();
		} else if (collection instanceof Iterator) {
			iterator = (Iterator) collection;
		} else if (collection instanceof Map) {
			iterator = ((Map) collection).entrySet().iterator();
		} else if (collection instanceof Enumeration) {
			iterator = new EnumerationIterator((Enumeration) collection);
		} else {
			log.warn("No collection found! name=" + getName() + ", property=" + getProperty());
			return (SKIP_BODY);
		}

		lengthCount = 0;
		
		for(int i = 0; i < offset && iterator.hasNext(); i++)
			iterator.next();

		// Store the first value and evaluate, or skip the body if none
		if (iterator.hasNext()) {
			Object element = iterator.next();
			if (element == null) {
				pageContext.removeAttribute(getId());
			} else {
				pageContext.setAttribute(getId(), element);
			}
			lengthCount++;
			started = true;
			if (indexId != null) {
				pageContext.setAttribute(indexId, Integer.valueOf(getIndex()));
			}
			if (lastId != null) {
				pageContext.setAttribute(lastId, !iterator.hasNext());
			}
			return (EVAL_BODY_TAG);
		} else {
			return (SKIP_BODY);
		}

	}

	@SuppressWarnings("deprecation")
	public int doAfterBody() throws JspException {

		// Render the output from this iteration to the output stream
		if (bodyContent != null) {
			TagUtils.writePrevious(pageContext, bodyContent.getString());
			bodyContent.clearBody();
		}
		
		// Decide whether to iterate or quit
        if ((limit > 0) && (lengthCount >= limit))
            return (SKIP_BODY);

		if (iterator.hasNext()) {
			Object element = iterator.next();
			if (element == null) {
				pageContext.removeAttribute(getId());
			} else {
				pageContext.setAttribute(getId(), element);
			}
			lengthCount++;
			if (indexId != null) {
				pageContext.setAttribute(indexId, Integer.valueOf(getIndex()));
			}
			return (EVAL_BODY_TAG);
		} else {
			return (SKIP_BODY);
		}

	}

	public int doEndTag() throws JspException {
		started = false;
		iterator = null;
		return (EVAL_PAGE);
	}

	public void release() {
		super.release();
		iterator = null;
		lengthCount = 0;
		started = false;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}

}
