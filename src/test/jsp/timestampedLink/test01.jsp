<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"%>

<ano:tslink>link1?p1=1</ano:tslink>

<ano:tslink>link2?p1=1&p2=2</ano:tslink>

<ano:tslink>link3?</ano:tslink>

<ano:tslink>link3</ano:tslink>
