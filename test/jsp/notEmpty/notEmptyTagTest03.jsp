<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/etc/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", new TestBean());
%>
<ano:notEmpty name="testBean" property="emptyMapValue" >NO</ano:notEmpty>
<ano:notEmpty name="testBean" property="notEmptyMapValue">OK</ano:notEmpty>
