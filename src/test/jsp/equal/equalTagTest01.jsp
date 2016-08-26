<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean","123");
%>
<ano:equal name="testBean" value="123">OK</ano:equal>
<ano:equal name="testBean" value="345">NO</ano:equal>
