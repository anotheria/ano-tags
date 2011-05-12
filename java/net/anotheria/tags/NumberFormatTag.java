package net.anotheria.tags;

import javax.servlet.jsp.JspException;

import net.anotheria.util.NumberUtils;



public class NumberFormatTag extends BaseTagSupport{
	
	private static final long serialVersionUID = 1L;
	
	private Double value;
	private Integer integral;
	private Integer fraction;
	private char delimiter = ',';
	
	public void setValue(Double value) {
		this.value = value;
	}
   

	/**
	 * @param integral the integral to set
	 */
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}


	/**
	 * @param fraction the fraction to set
	 */
	public void setFraction(Integer fraction) {
		this.fraction = fraction;
	}


	/**
	 * @param delimiter the delimiter to set
	 */
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}
	
	@Override public int doEndTag() throws JspException {
		//lookup() works with ignoring null bean and null property
		if(value == null)
			value = (Double)lookup();
		
		if(value == null)
			throw new JspException("Number is not defined. Use name/property or value attributes.");
		
		
		write(format(value));
		return SKIP_BODY;
	}
	
	private String format(double value){
		return NumberUtils.format(value, integral != null? integral: -1, fraction != null? fraction: -1, delimiter);

	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NumberFormatTag [value=" + value + ", integral=" + integral + ", fraction=" + fraction + ", delimiter=" + delimiter + "]";
	}
}
