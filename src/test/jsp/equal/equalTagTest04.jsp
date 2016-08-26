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
<ano:equal name="testBean" property="123StringValue" name2="testBean2" property2="another123StringValue">OK</ano:equal>
<ano:equal name="testBean" property="123StringValue" name2="testBean2" property2="456StringValue">NO</ano:equal>
