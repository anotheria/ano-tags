<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/etc/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean","123");
request.setAttribute("testBean2","122");
request.setAttribute("testBean3","123");
request.setAttribute("testBean4","124");
%>
<ano:greaterThan name="testBean" name2="testBean2">OK</ano:greaterThan>
<ano:greaterThan name="testBean" name2="testBean3">NO</ano:greaterThan>
<ano:greaterThan name="testBean" name2="testBean4">NO</ano:greaterThan>

