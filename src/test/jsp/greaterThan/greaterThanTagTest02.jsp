<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", new TestBean());
%>
<ano:greaterThan name="testBean" property="123StringValue" value="122">OK</ano:greaterThan>
<ano:greaterThan name="testBean" property="123StringValue" value="123">NO</ano:greaterThan>
<ano:greaterThan name="testBean" property="123StringValue" value="124">NO</ano:greaterThan>

