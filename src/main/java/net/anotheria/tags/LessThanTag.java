package net.anotheria.tags;

import jakarta.servlet.jsp.JspException;

public class LessThanTag extends CompareTagBase{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5588186496703977667L;

    protected boolean condition() throws JspException {

        return (condition(-1, -1));

    }

}
