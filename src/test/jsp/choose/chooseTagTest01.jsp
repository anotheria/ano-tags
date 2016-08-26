<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/src/main/resources/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", new TestBean());
%>
<ano:choose>
OK
<ano:empty name="testBean" property="emptyStringValue" >OK</ano:empty>
<ano:empty name="testBean" property="notEmptyStringValue">NO</ano:empty>

<ano:equal name="testBean" value="123">OK</ano:equal>
<ano:equal name="testBean" value="345">NO</ano:equal>

<ano:greaterThan name="testBean" value="122">OK</ano:greaterThan>
<ano:greaterThan name="testBean" value="123">NO</ano:greaterThan>

<ano:lessThan name="testBean" value="124">OK</ano:lessThan>
<ano:lessThan name="testBean" value="123">NO</ano:lessThan>

<ano:notEmpty name="testBean" property="notEmptyStringValue">OK</ano:notEmpty>
<ano:notEmpty name="testBean" property="emptyStringValue" >NO</ano:notEmpty>

<ano:notEqual name="testBean" value="345">OK</ano:notEqual>
<ano:notEqual name="testBean" value="123">NO</ano:notEqual>

<ano:notPresent name="testBean2">OK</ano:notPresent>
<ano:notPresent name="testBean">NO</ano:notPresent>

<ano:present name="testBean">OK</ano:present>
<ano:present name="testBean2">NO</ano:present>
OK
</ano:choose>

