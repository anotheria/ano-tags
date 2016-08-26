package net.anotheria.tags;

import net.anotheria.util.StringUtils;
import net.anotheria.util.xml.XMLNode;

import javax.servlet.jsp.JspException;

/**
 * XMLWriteTag - for writing net.anotheria.util.xml.XMLNode.
 *
 * @author h3llka
 */
public class XMLWriteTag extends BaseTagSupport {

	/**
	 * XMLWriteTag  name - name of page attribute - to get.
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int doEndTag() throws JspException {
		if (StringUtils.isEmpty(name))
			throw new JspException("Illegal node parameter!!!");

		Object obj = pageContext.findAttribute(name);
		if (obj instanceof XMLNode)
			((XMLNode) obj).write(pageContext.getOut(), 0);
		else
			throw new JspException("XMLNode " + name + " not founded in page context");

		return SKIP_BODY;
	}
}
