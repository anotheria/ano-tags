package net.anotheria.tags;

import jakarta.servlet.jsp.tagext.TagData;
import jakarta.servlet.jsp.tagext.TagExtraInfo;
import jakarta.servlet.jsp.tagext.VariableInfo;

public class DefineTei extends TagExtraInfo {

    public VariableInfo[] getVariableInfo(TagData data) {
        String type = data.getAttributeString("type");
        Object name = data.getAttribute("name");
        if (type == null) {
        	if (name==null) {
                type = "java.lang.String";
        	} else { 
                type = "java.lang.Object";
        	}
        }
        return new VariableInfo[] {
          new VariableInfo(data.getAttributeString("id"), type, true, VariableInfo.AT_END )
        };
    }

}

