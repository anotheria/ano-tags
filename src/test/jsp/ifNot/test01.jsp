<%@ page
contentType="text/html;charset=utf-8"
session="true"
isELIgnored ="false"
%>
<%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"%>

<%
request.setAttribute("attributeTrue", true);
request.setAttribute("attributeFalse", false);
%>
<ano:iFNot test="true">false</ano:iFNot>
<ano:iFNot test="false">OK</ano:iFNot>

<ano:iFNot test="${2==2}">false</ano:iFNot>
<ano:iFNot test="${2==3}">OK</ano:iFNot>

<ano:iFNot test="${attributeTrue}">false</ano:iFNot>
<ano:iFNot test="${attributeFalse}">OK</ano:iFNot>
<ano:iFNot test="jchvdchjds cdshj">OK</ano:iFNot>