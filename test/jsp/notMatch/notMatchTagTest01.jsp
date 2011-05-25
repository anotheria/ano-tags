<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/etc/tld/ano-tags.tld" prefix="ano"%>
<%
request.setAttribute("stringAttr", "string1");
%>
<ano:notMatch name="stringAttr" value="str">OK</ano:notMatch>
<ano:notMatch name="stringAttr" value="string1">OK</ano:notMatch>

<ano:notMatch name="stringAttr" value="str2">OK</ano:notMatch>
<ano:notMatch name="stringAttr" value="ng" location="end">OK</ano:notMatch>
<ano:notMatch name="stringAttr" value="trin" location="start">OK</ano:notMatch>