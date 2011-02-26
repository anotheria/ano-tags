package net.anotheria.tags;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

import javax.servlet.jsp.JspException;

public class EmptyTag extends ConditionalTagBase {

	private static final long serialVersionUID = 1L;

	@Override protected boolean condition() throws JspException {
		return isEmpty();
	}

	protected boolean isEmpty() throws JspException {
		Object value = lookup();

        if (value == null)
            return true;
        if (value instanceof String) 
        	return ((String)value).length() == 0;
        if (value instanceof Collection) 
        	return ((Collection<?>)value).isEmpty();
        if (value instanceof Map)
        	return ((Map<?,?>)value).isEmpty();
        if (value.getClass().isArray())
        	return Array.getLength(value) == 0;
        
        return false;
	}
}
