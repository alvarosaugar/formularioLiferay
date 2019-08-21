package com.liferay62.portlet.formulario;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Test;



public class FormularioTest {

	
	private final FormularioPortlet formularioTest = new FormularioPortlet();
	
	
	@Test
	public void testValidateDateNotToday() {
		
		Integer year = 2019;
		Integer month = 8;
		Integer day = 20;
		
		Calendar cal = mock(Calendar.class);
		when(cal.get(Calendar.YEAR)).thenReturn(year);
		when(cal.get(Calendar.MONTH)).thenReturn(month);
		when(cal.get(Calendar.DAY_OF_MONTH)).thenReturn(day+1);
		
		Boolean ok = formularioTest.validarFecha(year, month, day, Calendar.getInstance());
		assertTrue(ok);
		
	}
	
	
	@Test
	public void testValiDateToday() {
		
		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		Integer month = Calendar.getInstance().get(Calendar.MONTH);
		Integer day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		
		Calendar cal = mock(Calendar.class);
		when(cal.get(Calendar.YEAR)).thenReturn(year);
		when(cal.get(Calendar.MONTH)).thenReturn(month);
		when(cal.get(Calendar.DAY_OF_MONTH)).thenReturn(day);
		
		Boolean ok = formularioTest.validarFecha(year, month, day, Calendar.getInstance());
		System.out.println(ok);
		assertFalse(ok);
		
	}
	
		 
}
