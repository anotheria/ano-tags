<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", new TestBean());
%>
<ano:notEmpty name="testBean" property="emptyArrayValue" >NO</ano:notEmpty>
<ano:notEmpty name="testBean" property="notEmptyArrayValue">OK</ano:notEmpty>
