<%@ page 
contentType="text/html;charset=utf-8" 
session="true"
import="net.anotheria.tags.TestBean"
isELIgnored ="false"
%><%@ taglib uri="/etc/tld/ano-tags.tld" prefix="ano"
%><%
request.setAttribute("testBean", new TestBean());
request.setAttribute("testBean2", new TestBean());
%>
<ano:greaterThan name="testBean" property="123StringValue" name2="testBean2" property2="122StringValue">OK</ano:greaterThan>
<ano:greaterThan name="testBean" property="123StringValue" name2="testBean2" property2="123StringValue">NO</ano:greaterThan>
<ano:greaterThan name="testBean" property="123StringValue" name2="testBean2" property2="124StringValue">NO</ano:greaterThan>

