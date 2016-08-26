package net.anotheria.tags;

import javax.servlet.jsp.JspException;

public class GreaterThanTag extends CompareTagBase{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5588186496703977667L;

	protected boolean condition() throws JspException {

        return (condition(+1, +1));

    }

}
