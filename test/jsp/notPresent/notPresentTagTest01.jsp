<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/etc/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", new TestBean());
%>
<ano:notPresent name="testBean">NO</ano:notPresent>
<ano:notPresent name="testBean2">OK</ano:notPresent>
