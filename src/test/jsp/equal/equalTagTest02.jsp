<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", new TestBean());
%>
<ano:equal name="testBean" property="123StringValue" value="123">OK</ano:equal>
<ano:equal name="testBean" property="123StringValue" value="345">NO</ano:equal>
