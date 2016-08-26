<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", "123");
request.setAttribute("testBean2","123");
request.setAttribute("testBean3","456");
%>
<ano:equal name="testBean" name2="testBean2">OK</ano:equal>
<ano:equal name="testBean" name2="testBean3">NO</ano:equal>