package net.anotheria.tags;

import jakarta.servlet.jsp.JspException;

public class IfTag extends ConditionalTagBase {

	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = 6166346216980019240L;
	/**
	 * Field with boolean expression.
	 */
	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	protected boolean condition() throws JspException {
		return test();
	}

	protected boolean test(){
		return test;
	}

	@Override
	public void release() {
		super.release();
		test = false;
	}
}
