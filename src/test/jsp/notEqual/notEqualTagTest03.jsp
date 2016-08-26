<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/etc/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean","123");
request.setAttribute("testBean2","123");
request.setAttribute("testBean3","345");

%>
<ano:notEqual name="testBean" name2="testBean2">NO</ano:notEqual>
<ano:notEqual name="testBean" name2="testBean3">OK</ano:notEqual>
