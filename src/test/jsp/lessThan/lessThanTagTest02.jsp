<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/etc/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", new TestBean());
%>
<ano:lessThan name="testBean" property="123StringValue" value="124">OK</ano:lessThan>
<ano:lessThan name="testBean" property="123StringValue" value="123">NO</ano:lessThan>
<ano:lessThan name="testBean" property="123StringValue" value="122">NO</ano:lessThan>

