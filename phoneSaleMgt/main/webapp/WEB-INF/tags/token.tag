<%@ tag language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%@attribute name="tokenName" required="false"%>

<%
	String ranStr=UUID.randomUUID().toString();
	String key=(tokenName==null?"myToken":tokenName);
	session.setAttribute(key,ranStr);
%>

<input type='hidden' name='<%=key%>' value='<%=ranStr %>'/>