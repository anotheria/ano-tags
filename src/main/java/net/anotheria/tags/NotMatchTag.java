package net.anotheria.tags;

import jakarta.servlet.jsp.JspException;

/**
 * Tag that shows it's content if matching condition is false.
 *
 * @author dsilenko
 */
public class NotMatchTag extends MatchTag {

	/**
	 * Serial uid version.
	 */
	private static final long serialVersionUID = 4185449287282355376L;

	@Override
	protected boolean condition() throws JspException {
		return !isMatch();
	}
}
