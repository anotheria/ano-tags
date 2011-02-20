package net.anotheria.tags;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;

import net.anotheria.util.StringUtils;



public class WriteTag extends BaseTagSupport{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String property;
	private boolean ignore;
    private boolean filter;
    private boolean escape;
    
    /**
     *{@link Deprecated} WriteTag must be simple. Formating is not the part of it. Most formatting must be done while preparing bean or by other tags.
     */
    @Deprecated 
    private String dateFormat;

    public boolean getFilter() {
        return filter;
    }
    public void setFilter(boolean filter) {
        this.filter = filter;
    }
    public boolean isEscape() {
		return escape;
	}
	public void setEscape(boolean escape) {
		this.escape = escape;
	}
	
	@Deprecated 
	public String getDateFormat() {
		return dateFormat;
	}
	
	@Deprecated 
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
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
		//lookup() works with ignoring null bean and null property
		Object toWrite = lookup();
		if(toWrite == null)
			return SKIP_BODY; //Nothing to write
		String message = ""+toWrite;
		if(filter)
			message = TagUtils.filter(message);
		if(escape)
			message = StringUtils.escape(message, '\'','"');
		if (dateFormat != null) {
			try {
				long time = Long.parseLong(message);
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
				message = sdf.format(new Date(time));
				// write as formatted date
			} catch (Throwable e) {
				// write as is
			}
		}
		write(message);
		return SKIP_BODY;
	}
	

}
