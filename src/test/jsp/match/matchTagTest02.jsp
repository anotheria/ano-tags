<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/etc/tld/ano-tags.tld" prefix="ano"%>
<%
request.setAttribute("stringAttr", "string1");
request.setAttribute("stringAttr2", "stri");
request.setAttribute("stringAttr3", "sahgdf");
%>

<ano:match name="stringAttr" name2="stringAttr2">OK</ano:match>

<ano:match name="stringAttr" name2="stringAttr3">OK</ano:match>

<ano:match name="stringAttr" name2="stringAttr2" location="end">OK</ano:match>