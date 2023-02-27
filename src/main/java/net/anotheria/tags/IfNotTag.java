package net.anotheria.tags;

import jakarta.servlet.jsp.JspException;

public class IfNotTag extends IfTag {

	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = -7055901139823614776L;

	@Override
	protected boolean condition() throws JspException {
		return !test();
	}

}
