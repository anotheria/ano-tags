<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", new TestBean());
%>
<ano:notEmpty name="testBean" property="emptyCollectionValue" >NO</ano:notEmpty>
<ano:notEmpty name="testBean" property="notEmptyCollectionValue">OK</ano:notEmpty>
