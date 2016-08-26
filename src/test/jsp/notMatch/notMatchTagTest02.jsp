<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"%>
<%
request.setAttribute("stringAttr", "string1");
request.setAttribute("stringAttr2", "stri");
request.setAttribute("stringAttr3", "sahgdf");
%>

<ano:notMatch name="stringAttr" name2="stringAttr2">OK</ano:notMatch>

<ano:notMatch name="stringAttr" name2="stringAttr3">OK</ano:notMatch>

<ano:notMatch name="stringAttr" name2="stringAttr2" location="end">OK</ano:notMatch>