package net.anotheria.tags;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import jakarta.servlet.jsp.JspException;
import net.anotheria.util.Date;

public class DateFormatTag extends BaseTagSupport {

	private static final long serialVersionUID = 1L;

	private long date = -1;
	private String format;

	public void setDate(Object date) throws JspException {
		this.date = resolveDate(date);
	}

	public void setFormat(String format) {
		this.format = format;
	}

	private long resolveDate(Object dateObj) throws JspException {
		if (dateObj == null)
			return -1;
		if (dateObj instanceof Long)
			return (Long) dateObj;
		if (dateObj instanceof Date)
			return ((Date) dateObj).toMill();
		if (dateObj instanceof java.util.Date)
			return ((java.util.Date) dateObj).getTime();
		if (dateObj instanceof Calendar)
			return ((Calendar) dateObj).getTimeInMillis();
		throw new JspException("Could not determine Date from object of class " + dateObj.getClass());
	}

	@Override
	public int doEndTag() throws JspException {
		// lookup() works with ignoring null bean and null property
		if (date == -1)
			date = resolveDate(lookup());

		if (date == -1)
			throw new JspException("Date object is not set!");

		write(format());
		return SKIP_BODY;
	}

	private String format() {
		return new SimpleDateFormat(format).format(new java.util.Date(date));

	}

}
