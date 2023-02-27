package net.anotheria.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

import net.anotheria.util.StringUtils;


/**
 * Base class for tags without body.
 * @author another
 *
 */
public class BaseTagSupport extends TagSupport{
	
	private static final long serialVersionUID = 1L;
	/**
	 * Target scope.
	 */
	private String scope;
	/**
	 * Id of the object to create.
	 */
	private String id;
	/**
	 * Name of the attribute in the scope.
	 */
	private String name;
	/**
	 * Property of the attribute under 'name'.
	 */
	private String property;
	
	protected Object lookup() throws JspException{
		return TagUtils.lookup(pageContext, getScope(), getName(), getProperty());
	}
	
	protected void write(String s) throws JspException{
		TagUtils.write(pageContext, s);		
	}
	
	protected void writeLn(String s) throws JspException{
		TagUtils.write(pageContext, s+"\n");		
	}

	protected String quote(String s){
		return TagUtils.quote(s);
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public String toString(){
		String ret = "name: " + name;

		if(!StringUtils.isEmpty(property))
			ret += ", property: " + property;
		
		if(!StringUtils.isEmpty(scope))
			ret += ", scope: " + scope;
		
		return ret;
	}

	public void release() {
		super.release();
		name = null;
		property = null;
		id = null;
		scope = null;
	}



}
