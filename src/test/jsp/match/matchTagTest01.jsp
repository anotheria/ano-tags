<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"%>
<%
request.setAttribute("stringAttr", "string1");
%>
<ano:match name="stringAttr" value="str">OK</ano:match>
<ano:match name="stringAttr" value="string1">OK</ano:match>
<ano:match name="stringAttr" value="str2">OK</ano:match>

<ano:match name="stringAttr" value="ng" location="end">OK</ano:match>
<ano:match name="stringAttr" value="trin" location="start">OK</ano:match>