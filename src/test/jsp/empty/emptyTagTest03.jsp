<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", new TestBean());
%>
<ano:empty name="testBean" property="emptyMapValue" >OK</ano:empty>
<ano:empty name="testBean" property="notEmptyMapValue">NO</ano:empty>
