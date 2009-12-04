package net.anotheria.tags;

import javax.servlet.jsp.JspException;

public class WriteTag extends BaseTagSupport{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String property;
	private boolean ignore;
    private boolean filter;

    public boolean getFilter() {
        return filter;
    }
    public void setFilter(boolean filter) {
        this.filter = filter;
    }
	public boolean isIgnore() {
		return ignore;
	}
	public void setIgnore(boolean ignore) {
		this.ignore = ignore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	
	@Override public int doEndTag() throws JspException {
		
		Object toWrite = lookup();
		String message = toWrite==null ? 
				(ignore? "": "null") : ""+toWrite;
		write(filter ? TagUtils.filter(message) : message);
		return SKIP_BODY;
	}

}
