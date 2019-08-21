<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="java.util.Calendar" %>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException"%>
<%@page import="com.liferay.util.mail.MailEngineException"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>


<portlet:defineObjects />
<liferay-theme:defineObjects />

<% 
//	PortletPreferences prefs = renderRequest.getPreferences(); 	

String nombre = (String)request.getAttribute("nombre");
String apellido = (String)request.getAttribute("apellido");
String email = (String)request.getAttribute("email");

Calendar cal = Calendar.getInstance();
int yearValue= GetterUtil.getInteger(portletPreferences.getValue("year", "" + cal.get(Calendar.YEAR)));
int monthValue= GetterUtil.getInteger(portletPreferences.getValue("month", "" + cal.get(Calendar.MONTH)));
int dayValue= GetterUtil.getInteger(portletPreferences.getValue("day", "" + cal.get(Calendar.DAY_OF_MONTH)));


%>
	<liferay-ui:success key="correo.curso.envio.realizado" message="correo.curso.envio.realizado"/>

	
	<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="formulario.error.texto.verificacion" />
	<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="formulario.error.texto.intentos" />
	<liferay-ui:error exception="<%= MailEngineException.class %>" message="formulario.error.envio.email" />
	<liferay-ui:error key="formulario.error.fecha" message="formulario.error.fecha"/>


	<portlet:actionURL var="enviarMailURL" name="altaMail">
		<portlet:param name="mvcPath" value="/view.jsp"/>
	</portlet:actionURL>
	
	<aui:form action="<%=enviarMailURL %>" method="post" >
		<aui:input name="nombre" label="formulario.alta.nombre" type="text" size="48" value="<%=nombre %>">
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="apellido" label="formulario.alta.apellido" type="text" size="48" value="<%=apellido %>">
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="email" label="formulario.alta.email" type="text" size="48" value="<%=email %>">
			<aui:validator name="required" />
			<aui:validator name="email" />
		</aui:input>
		
		<aui:fieldset>
			<liferay-ui:message key="formulario.alta.fecha"/>
			<liferay-ui:input-date yearValue="<%= yearValue %>" monthValue="<%= monthValue %>"
				dayValue="<%= dayValue %>" dayParam="day"
				monthParam="month" yearParam="year" />
		</aui:fieldset>
		
		<portlet:resourceURL var="captchaURL"/><liferay-ui:captcha url="<%=captchaURL%>" />
		<aui:button type="submit" value="formulario.alta.enviar"/> 
	</aui:form>

	
	
	