
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.util.portlet.PortletProps" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<%  

String formularioAltaMailAdicional = portletPreferences.getValue("formularioAltaMailAdicional", PortletProps.get("formulario.alta.mail.adicional"));
String formularioAltaMailAsunto = portletPreferences.getValue("formularioAltaMailAsunto", PortletProps.get("formulario.alta.mail.asunto"));
String formularioAltaMailCuerpo = portletPreferences.getValue("formularioAltaMailCuerpo", PortletProps.get("formulario.alta.mail.cuerpo"));
Boolean activoAvisar = GetterUtil.getBoolean(portletPreferences.getValue("activoAvisar", StringPool.FALSE));

%>

<aui:form action="<%= configurationURL %>" method="post" name="fm">
<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
 
 <h1><liferay-ui:message key="formulario.configuracion" /></h1>
 
  <liferay-ui:panel title="formulario.configuracion.email.adicional" collapsible="true">
     <aui:fieldset>
			<aui:input type="checkbox" label="formulario.alta.mail.adicional" name="preferences--activoAvisar--" value='<%= activoAvisar %>'></aui:input>
           	<aui:input label="formulario.alta.mail.adicional" name="preferences--formularioAltaMailAdicional--" value='<%= formularioAltaMailAdicional %>' >
           		<aui:validator name="email" />
           	</aui:input>
     </aui:fieldset>  
    
  </liferay-ui:panel>
 
                    


 <liferay-ui:panel title="formulario.configuracion.email.personalizar" collapsible="true">
      <aui:fieldset>
	     	<aui:input label="formulario.alta.mail.asunto" name="preferences--formularioAltaMailAsunto--" value='<%= formularioAltaMailAsunto %>' ></aui:input>
	       	<aui:input type="textarea" label="formulario.alta.mail.cuerpo" name="preferences--formularioAltaMailCuerpo--" value='<%= formularioAltaMailCuerpo %>' ></aui:input>	       
      </aui:fieldset>
  </liferay-ui:panel>   
  
  
    <aui:button-row>
       <aui:button type="submit" value="save"/>
    </aui:button-row>
</aui:form>
