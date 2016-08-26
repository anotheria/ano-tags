package net.anotheria.tags;

import net.anotheria.util.StringUtils;

import javax.servlet.jsp.JspException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * WriteTag for printing out value of a variable.
 */
public class WriteTag extends BaseTagSupport{

	/**
	 * SerialUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Bean name.
	 */
	private String name;
	/**
	 * Bean property.
	 */
	private String property;
	/**
	 * Ignore flag. If true a missing bean/property will be skipped.
	 */
	private boolean ignore;
	/**
	 * Filter. If true the content should be filtered by the TagUtils and replace special characters with their html encoded equivalents.
	 * This serves as anti-xss measure because it prevents content from being interpreted as html.
	 */
    private boolean filter;
	/**
	 * If true the single and double quotes will be escaped with backslashes.
	 */
    private boolean escape;
	/**
	 * If true replace textlinebreaks (\r\n) with &lt;br&gt; html tag.
	 */
    private boolean replaceLinebreaks;
    
    private interface Translator {
    	String translate(Object src, String params);
    }
    
    private enum TranslationFormat implements Translator {
		/**
		 * Moves everything to lowercase.
		 */
		LOWER_CASE {
    		@Override
    		public String translate(Object src, String params) {
    			return src.toString().toLowerCase().replace('_', ' ');
    		}
    	},
		/**
		 * Moves everything to uppercase..
		 */
    	UPPER_CASE {
    		@Override
    		public String translate(Object src, String params) {
    			return src.toString().toUpperCase().replace('_', ' ');
    		}
    	},
		/**
		 * Handles the either as java.lang.Date object or as Long (timestamp).
		 */
    	DATE {
    		@Override
    		public String translate(Object src, String params) {
    			if (src == null) {
    				return null;
    			}
    			Date date = null;
    			if (src instanceof Date) {
    				date = (Date) src;
    			} else if (src instanceof Long) {
    				date = new Date((Long) src);
    			} else if (src instanceof String) {
        			try {
        				long time = Long.parseLong(src.toString());
        				date = new Date(time);
        			} catch (Throwable e) {
        				return null;
        			}
    			}
    			return new SimpleDateFormat(params).format(date);
    		}
    	};	
    }

	/**
	 * Value translator.
	 */
	private String translator;
	/**
	 * Parameters for the translator.
	 */
    private String translatorParams;
    
    /**
	 * Allows to format a timestamp value as date.
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
	
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getTranslatorParams() {
		return translatorParams;
	}
	public void setTranslatorParams(String params) {
		this.translatorParams = params;
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
		if(filter){
			message = TagUtils.filter(message);
		}
		if(escape){
			message = StringUtils.escape(message, '\'','"');
		}
		if (replaceLinebreaks){
			message = StringUtils.removeChar(message, '\r');
			message = StringUtils.replace(message, '\n', "<br>");
		}
		if (translator == null) {
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
		} else {
			message = TranslationFormat.valueOf(translator).translate(message, translatorParams);
		}
			
		write(message);
		return SKIP_BODY;
	}
	public boolean isReplaceLinebreaks() {
		return replaceLinebreaks;
	}
	public void setReplaceLinebreaks(boolean replaceLinebreaks) {
		this.replaceLinebreaks = replaceLinebreaks;
	}
	

}
