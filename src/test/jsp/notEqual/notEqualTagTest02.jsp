<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", new TestBean());
%>
<ano:notEqual name="testBean" property="123StringValue" value="123">NO</ano:notEqual>
<ano:notEqual name="testBean" property="123StringValue" value="345">OK</ano:notEqual>
