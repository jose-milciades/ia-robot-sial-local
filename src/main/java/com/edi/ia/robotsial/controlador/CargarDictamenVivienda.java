package com.edi.ia.robotsial.controlador;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import com.edi.ia.robotsial.modelo.ExpedienteVO;
import com.edi.ia.robotsial.util.Utilidad;
import com.edi.ia.robotsial.util.VariablesGlobales;

public class CargarDictamenVivienda {
	
	Utilidad utilidad = new Utilidad();
	
	By menuItemBuscar = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[1]");
	By imputBuscar = By.cssSelector("input[data-name='credito'][type='text']");
	By listResultado = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div/div/div/div[1]/div/a");
	By consultarJuicioButton = By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/p/button[2]");
	
	By tabDictamenVivienda = By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/section[1]/div/div[1]/div[3]/div[2]");
	By adicionarButton = By.cssSelector("button[class='button-add btn btn-primary']");
	By dropdownListDomicilioLocalizado = By.cssSelector("select[name='domicilio_localizado']");
	By dropdownListMotivoNoLocalizado = By.cssSelector("select[name='motivo_no_localizado']");
	By seleccionarImagen = By.cssSelector("input[class='form-control FieldPicture']");
	By dropdownListEstado = By.cssSelector("select[name='estado'][class='form-control FieldOptions']");
	By dropdownListInvadidaPor = By.cssSelector("select[name='invadida_por'][class='form-control FieldReference']");

	By checkBoxHabitada = By.cssSelector("label[class='habitada']");
	By checkBoxVandalizada = By.cssSelector("label[class='vandalizada']");
	By checkBoxInvasores = By.cssSelector("label[class='invasores']");	
	By checkBoxVentanas = By.cssSelector("label[class='ventanas']");
	By checkBoxMuebles = By.cssSelector("label[class='muebles']");
	By checkBoxMedidor_de_luz = By.cssSelector("label[class='medidor_de_luz']");
	By checkBoxMedidor_de_agua = By.cssSelector("label[class='medidor_de_agua']");
	By checkBoxAutos = By.cssSelector("label[class='autos']");
	//
	
	By dropdownListPersonaContactada = By.cssSelector("select[name='persona_contactada']");
	By dropdownListMotivoNoPago = By.cssSelector("select[name='motivo_no_pago']");
	By dropdownListQuiereMantenerHogar = By.cssSelector("select[name='quiere_mantener_hogar']");
	By inputCapacidadDePago = By.cssSelector("input[name='capacidad_de_pago'][type='text']");
	By texAreaComentarios = By.cssSelector("textarea[name='comentarios']");
	By saveButton = By.cssSelector("button[class='button-save btn btn-success pull-right']");
	
	By listDictamen = By.cssSelector("tr[class='list-row']");
	By listFiterAnio = By.cssSelector("select[class='ListFilter'][data-field='anio']");
	
	
	public void cargarDictamenVivienda(RobotSial robotSial, ExpedienteVO expedienteVO, String rutaArchivo) throws Exception {
		
		if (!expedienteVO.getLatitud().equals("") && !expedienteVO.getLongitud().equals("")) {
			if(utilidad.georrefenciaSeEncuentraEnMexico(new BigDecimal(expedienteVO.getLatitud()), new BigDecimal(expedienteVO.getLongitud()))) {		
				robotSial.setGeolocalización(new BigDecimal(expedienteVO.getLatitud()), new BigDecimal(expedienteVO.getLongitud()), new BigDecimal("10"));
			} else {
				throw new Exception(VariablesGlobales.MENSAJE_ERROR_08);
			}
		}
		
		robotSial.click(menuItemBuscar, 0, VariablesGlobales.T3);
		robotSial.sendKeys(imputBuscar, expedienteVO.getNumeroCredito(), 0, VariablesGlobales.T1);
		robotSial.click(listResultado, 0, VariablesGlobales.T3);
		robotSial.click(consultarJuicioButton, 0, VariablesGlobales.T3); 
		
		robotSial.click(tabDictamenVivienda, 0, VariablesGlobales.T1); 
		// if bandera no
		if (expedienteVO.getCargarDictamenAdicional().equals("NO")) {
			if(robotSial.elementoPresente(listFiterAnio, 0, VariablesGlobales.T3)) {
				throw new Exception(VariablesGlobales.MENSAJE_ERROR_09);
			}
		}
		
		robotSial.click(adicionarButton, 0, VariablesGlobales.T1);
		robotSial.selectDropdownList(dropdownListDomicilioLocalizado, expedienteVO.getDomicilioLocalizado(), 0,
				VariablesGlobales.T3);
		robotSial.selectDropdownList(dropdownListMotivoNoLocalizado, expedienteVO.getMotivoNoLocalizado(), 0,
				VariablesGlobales.T3);
		robotSial.sendKeys(seleccionarImagen, rutaArchivo, 0, VariablesGlobales.T3);
		robotSial.selectDropdownList(dropdownListEstado, expedienteVO.getEstadoVivienda(), 0,
				VariablesGlobales.T2);
		
		
		robotSial.click(checkBoxHabitada,expedienteVO.getHabitada(), 0, VariablesGlobales.T1);
		robotSial.click(checkBoxVandalizada,expedienteVO.getVandalizada(), 0, VariablesGlobales.T1);
		robotSial.click(checkBoxInvasores,expedienteVO.getInvasores(), 0, VariablesGlobales.T1);
		robotSial.selectDropdownList(dropdownListInvadidaPor,expedienteVO.getInvadidaPor() , 0, VariablesGlobales.T1);
		robotSial.click(checkBoxVentanas,expedienteVO.getVentanas(), 0, VariablesGlobales.T1);
		robotSial.click(checkBoxMuebles,expedienteVO.getMuebles(), 0, VariablesGlobales.T1);
		robotSial.click(checkBoxMedidor_de_luz,expedienteVO.getMedidor_de_luz(), 0, VariablesGlobales.T1);
		robotSial.click(checkBoxMedidor_de_agua,expedienteVO.getMedidor_de_agua(), 0, VariablesGlobales.T1);
		robotSial.click(checkBoxAutos,expedienteVO.getAutos(), 0, VariablesGlobales.T1);
		
		robotSial.selectDropdownList(dropdownListPersonaContactada, expedienteVO.getPersonaContactada(), 0,
				VariablesGlobales.T1);
		robotSial.selectDropdownList(dropdownListMotivoNoPago, expedienteVO.getMotivoNoPago(), 0,
				VariablesGlobales.T1);
		robotSial.selectDropdownList(dropdownListQuiereMantenerHogar, expedienteVO.getQuiereMantenerHogar(), 0,
				VariablesGlobales.T1);
		robotSial.sendKeys(inputCapacidadDePago, expedienteVO.getCapacidadDePago(), 0,
				VariablesGlobales.T1);
		
		robotSial.sendKeys(texAreaComentarios, expedienteVO.getComentario(), 0, VariablesGlobales.T1);
		robotSial.click(saveButton, 0, VariablesGlobales.T1); 
		robotSial.switchToAlert(VariablesGlobales.T3);
		
		//Evento al final para darle tiempo al nevegador de guardar
		robotSial.click(listFiterAnio, 0, VariablesGlobales.T3); 
		
	}
	

}


