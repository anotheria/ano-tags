<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/etc/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", new TestBean());
%>
<ano:notPresent name="testBean" property="123StringValue">NO</ano:notPresent>
<ano:notPresent name="testBean" property="nullValue">OK</ano:notPresent>
