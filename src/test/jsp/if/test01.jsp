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
<ano:iF test="true">OK</ano:iF>
<ano:iF test="false">false</ano:iF>

<ano:iF test="${2==2}">OK</ano:iF>
<ano:iF test="${2==3}">false</ano:iF>

<ano:iF test="${attributeTrue}">OK</ano:iF>
<ano:iF test="${attributeFalse}">false</ano:iF>
<ano:iF test="jchvdchjds cdshj">false</ano:iF>