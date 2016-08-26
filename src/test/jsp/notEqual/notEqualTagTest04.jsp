<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", new TestBean());
request.setAttribute("testBean2", new TestBean());
%>
<ano:notEqual name="testBean" property="123StringValue" name2="testBean2" property2="123StringValue">NO</ano:notEqual>
<ano:notEqual name="testBean" property="123StringValue" name2="testBean2" property2="456StringValue">OK</ano:notEqual>
