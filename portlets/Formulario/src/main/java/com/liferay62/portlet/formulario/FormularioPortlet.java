package com.liferay62.portlet.formulario;


import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.mail.MailEngineException;
import com.liferay.util.portlet.PortletProps;
import com.liferay62.servicio.model.Registro;
import com.liferay62.servicio.service.RegistroLocalServiceUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;




public class FormularioPortlet extends MVCPortlet{
	
	
	

	/**
	 * Método llamado desde el botón "enviar" del portlet que recoge los datos
	 * de las preferencias y realiza el envío con estas.
	 */
	public void altaMail(
			ActionRequest actionRequest, ActionResponse actionResponse)
					throws IOException, PortletException, AddressException{
		
		
		String nombre = ParamUtil.getString(actionRequest, "nombre");
		String apellido = ParamUtil.getString(actionRequest, "apellido");
		String email = ParamUtil.getString(actionRequest, "email");
		Integer year = GetterUtil.getInteger(ParamUtil.getString(actionRequest, "year"));
		Integer month = GetterUtil.getInteger(ParamUtil.getString(actionRequest, "month"));
		Integer day = GetterUtil.getInteger(ParamUtil.getString(actionRequest, "day"));
			
		
		try {
			CaptchaUtil.check(actionRequest);
			Calendar cal = Calendar.getInstance();	
			if (!validarFecha(year, month, day, Calendar.getInstance())) {
				SessionErrors.add(actionRequest, "formulario.error.fecha");
				conservarForm(actionRequest, nombre, apellido, email);
			} else {
				// Servicio para la persistencia
				registroFormulario(nombre, apellido, email, year, month, day);
				// Mail para confirmar
				notificacionEmail(actionRequest, nombre, email);
				SessionMessages.add(actionRequest,"success");
			}
		}catch (CaptchaException e) {
			_log.error("Error al validar el captcha");
			SessionErrors.add(actionRequest, CaptchaTextException.class.getName());
			conservarForm(actionRequest, nombre, apellido, email);
		} catch (SystemException e) {
			_log.error("Error en el proceso de alta");
			_log.error(e.getMessage());
			SessionErrors.add(actionRequest, SystemException.class.getName());
		} catch (MailEngineException e) {
			_log.error("Error en el proceso de alta. Envío de email");
			_log.error(e.getMessage());
			SessionErrors.add(actionRequest, MailEngineException.class.getName());
		}
				
	}

	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		try {
			CaptchaUtil.serveImage(resourceRequest, resourceResponse);
		} catch (Exception e) {
			_log.error("Error al recuperar la imagen");
		}

	}

	
	private void conservarForm(ActionRequest actionRequest, String nombre, String apellido, String email) {
		actionRequest.setAttribute("nombre", nombre);
		actionRequest.setAttribute("apellido", apellido);
		actionRequest.setAttribute("email", email);
	}
	
	
	/**
	 * Método que 
	 */
	private void registroFormulario(String nombre, String apellido, String email, Integer year, Integer month, Integer day) throws SystemException  {
		
		long tasksEntryId = CounterLocalServiceUtil.increment();
		Registro reg = RegistroLocalServiceUtil.createRegistro(tasksEntryId);
		reg.setNombre(nombre);
		reg.setApellido(apellido);
		reg.setEmail(email);
		
		Calendar cal = Calendar.getInstance();
		reg.setAlta(cal.getTime());
		
		cal.set(year, month, day);				
		reg.setNacimiento(cal.getTime());

		RegistroLocalServiceUtil.addRegistro(reg);
	}
	
	private void notificacionEmail(ActionRequest actionRequest, String nombre, String email) throws UnsupportedEncodingException, MailEngineException {

		PortletPreferences prefs = actionRequest.getPreferences();
	    String emailAdicional = prefs.getValue("formularioAltaMailAdicional",  PortletProps.get("formulario.alta.mail.adicional"));
	    String asunto = prefs.getValue("formularioAltaMailAsunto", PortletProps.get("formulario.alta.mail.asunto"));
	    String cuerpo = prefs.getValue("formularioAltaMailCuerpo", PortletProps.get("formulario.alta.mail.cuerpo"));
	    Boolean activoAvisar = GetterUtil.getBoolean(prefs.getValue("activoAvisar", StringPool.FALSE));

	    List<InternetAddress> bcc = new ArrayList<InternetAddress>();
	    InternetAddress emailAddress = new InternetAddress(email, email);
        bcc.add(emailAddress); 
        if (activoAvisar) {
        	InternetAddress emailAddressAux = new InternetAddress(emailAdicional, emailAdicional);
	        bcc.add(emailAddressAux); 
        }

        InternetAddress[] bccA = new InternetAddress[bcc.size()];
        bccA = bcc.toArray(bccA);
        
		enviarMail(bccA, asunto, cuerpo, nombre);
	}

	
	public Boolean validarFecha(Integer year, Integer month, Integer day, Calendar cal) {
		
		Boolean valido = true;
		
		//Calendar cal = Calendar.getInstance();		
		if ((year == cal.get(Calendar.YEAR)) && 
				(month == cal.get(Calendar.MONTH)) && (day == cal.get(Calendar.DAY_OF_MONTH))) {
			valido=false;
		}
		
		return valido;
	}



	public Boolean enviarMail (InternetAddress[] bcc,String asunto,String cuerpo, String nombre) throws UnsupportedEncodingException, MailEngineException{
		
		Boolean enviado = true;
		
		String fromEmail = PropsUtil.get("mail.session.mail.smtp.user");
	    if(fromEmail == null){
	    	 enviado = false;
	    }
		  	                
	    InternetAddress from = new InternetAddress(fromEmail, fromEmail);
        String cuerpoFinal = StringUtil.replace(cuerpo,
                new String[] {"[$usuario$]"},
            new String[] {nombre});
            
       MailMessage mailMessage=new MailMessage();
       mailMessage.setBCC(bcc);
       mailMessage.setFrom(from);
       mailMessage.setBody(cuerpoFinal);
       mailMessage.setSubject(asunto);
       mailMessage.setHTMLFormat(true);
       MailServiceUtil.sendEmail(mailMessage);
              
       return enviado;

	}
	
	
	private static Log _log = LogFactoryUtil.getLog(FormularioPortlet.class);
	
}
