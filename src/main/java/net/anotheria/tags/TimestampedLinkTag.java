package net.anotheria.tags;

import net.anotheria.util.StringUtils;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.BodyContent;

/**
 * Appends body of tag with parameter name "ts" and it's value of current time in milliseconds.
 *
 * @author another
 */
public class TimestampedLinkTag extends BaseBodyTagSupport{

	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = 2373693048955135316L;

	public int doEndTag() throws JspException {
		BodyContent bodyContent = getBodyContent();
		if (bodyContent == null)
			throw new JspException("TimestampedLinkTag.doEndTag(): body of tag should not be empty");

		String body = bodyContent.getString().trim();
		if (StringUtils.isEmpty(body))
			throw new JspException("TimestampedLinkTag.doEndTag(): body of tag should not be empty");

		char param = 0;
		int index = body.indexOf('?');

		if ( index == -1 )
			param = '?';

		if ( index != -1 && index != body.length()-1 )
			param = '&';

		body += param + "ts=" + System.currentTimeMillis();
		write(body);

		return EVAL_BODY_AGAIN;
	}

}
