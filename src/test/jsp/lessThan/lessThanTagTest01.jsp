<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean","123");
%>
<ano:lessThan name="testBean" value="124">OK</ano:lessThan>
<ano:lessThan name="testBean" value="123">NO</ano:lessThan>
<ano:lessThan name="testBean" value="122">NO</ano:lessThan>

