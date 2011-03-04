<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/etc/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean","123");
%>
<ano:notEqual name="testBean" value="123">NO</ano:notEqual>
<ano:notEqual name="testBean" value="345">OK</ano:notEqual>
