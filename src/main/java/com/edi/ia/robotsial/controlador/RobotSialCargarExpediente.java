package com.edi.ia.robotsial.controlador;



import org.openqa.selenium.By;
import com.edi.ia.robotsial.modelo.ExpedienteVO;
import com.edi.ia.robotsial.util.Utilidad;
import com.edi.ia.robotsial.util.VariablesGlobales;

public class RobotSialCargarExpediente {

	boolean adicionar = false;
	Utilidad utilidad = new Utilidad();
	
	By menuItemBuscar = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[1]");
	By inputBuscar = By.cssSelector("input[data-name='credito'][type='text']");
	
	By listResultado = By.cssSelector("div[class='bc-menu list-group']");
	By consultarJuicioButton = By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/p/button[2]");
	By editarButton = By.xpath(
			"/html/body/div[1]/div[3]/div/div/div[2]/section[1]/div/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[1]/button[2]/i");
	
	By adicionarButton = By.cssSelector("button[class='button-add btn btn-primary']");
	By guardarParaAgregarArchivoButton = By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/section[1]/div/div[2]/div[2]/div[2]/div[2]/section/div/div[2]/div/div/div[1]/div[5]/div[2]/button");
	
	
	By dropdownListEtapa = By.cssSelector("select[name='etapa']");
	By inputFecha = By.cssSelector("input[name='fecha'][type='text']");
	By dropdownListEstatus = By.cssSelector("select[name='estatus']");
	By editarArchivoButton = By.cssSelector("button[class='btn btn-sm button-edit']");
	By seleccionarArchivo = By.cssSelector("input[class='form-control FieldFile']");
	By dropdownListTipoProcesoDemanda = By.cssSelector("select[name='tipo_de_proceso_de_demanda']");
	By inputNumExpediente = By.cssSelector("input[name='expediente'][type='text']");
	By dropdownListEstadoJuzgado = By.cssSelector("select[name='estado_juzgado']");
	By dropdownListMunicipioJuzgado = By.cssSelector("select[name='municipio_juzgado']");
	By dropdownListTipoJuicio = By.cssSelector("select[name='tipo_de_juicio']");
	By dropdownListJuzgado = By.cssSelector("select[name='juzgado']");
	
	
	By inputMontoTotalSentencia = By.cssSelector("input[name='monto_total_sentencia'][type='text']");
	By dropdownListMonedaSentencia = By.cssSelector("select[name='moneda_sentencia']");
	By inputTipoCambioSentencia = By.cssSelector("input[name='tipo_de_cambio_sentencia'][type='text']");
	
	By inputMontoAjudicacion = By.cssSelector("input[name='monto_adjudicacion'][type='text']");
	
	By inputMontoAvaluo = By.cssSelector("input[name='monto_avaluo'][type='text']");
	By inputFechaAvaluo = By.cssSelector("input[name='fecha_avaluo'][type='text']");
	By dropdownListEstadoNotaria = By.cssSelector("select[name='estado_notaria']");
	By dropdownListMunicipioNotaria = By.cssSelector("select[name='municipio_notaria']");
	By inputNombreNotario = By.cssSelector("input[name='nombre_notario'][type='text']");
	By inputNumNotario = By.cssSelector("input[name='num_notaria'][type='text']");
	By inputFechaExpiraSentencia = By.cssSelector("input[name='fecha_expira_sentencia'][type='text']");

	By inputFechaSentencia = By.cssSelector("input[name='fecha_sentencia'][type='text']");
	By inputUnidadAvaluoPredio = By.cssSelector("input[name='unidad_de_valuacion_o_perito'][type='text']");
	By inputFechaVencimientoAvaluo = By.cssSelector("input[name='fecha_vencimiento_avaluo'][type='text']");
	By inputSuperficieConstruccion = By.cssSelector("input[name='superficie_contstruccion'][type='text']");
	By dropdownListEntidadInmuebleGarantia = By.cssSelector("select[name='entidad_ubicacion_inmueble']");
	By dropdownListMunicipioInmuebleGarantia = By.cssSelector("select[name='municipio_ubicacion_inmueble']");
	By inputColoniaInmuebleGarantia = By.cssSelector("input[name='colonia_inmueble'][type='text']");
	By inputCalleNumeroInmuebleGarantia = By.cssSelector("input[name='calle_y_numero_inmueble'][type='text']");
	By inputCPInmuebleGarantia = By.cssSelector("input[name='CP_inmueble'][type='text']");
	By inputFechaAprobacionRemate = By.cssSelector("input[name='fecha_aprobacion_remate'][type='text']");
	By inputFechaRemateFirme = By.cssSelector("input[name='fecha_remate_firme'][type='text']");
	By inputCantidadPostuaraLegal = By.cssSelector("input[name='cantidad_postura_legal_pesos'][type='text']");
	By inputFechaSentenciaLiquidacion = By
			.cssSelector("input[name='fecha_sentencia_interlocutoria_incidente_liquidacion'][type='text']");
	By inputSaldoReconocido = By.cssSelector("input[name='saldo_total_reconocido_pesos'][type='text']");
	By inputFechaAdminisioDemanda = By.cssSelector("input[name='fecha_admision_demanda'][type='text']");
	
	By inputFechaEmplazamiento = By.cssSelector("input[name='fecha_emplazamiento'][type='text']");
	
	By inputNumeroPleitosCobranza = By.cssSelector("input[name='num_poder_pleitos_cobranzas'][type='text']");
	By inputNombreApoderadoInfonavit = By.cssSelector("input[name='nombre_apoderado_infonavit'][type='text']");
	
	By dropdownListNumAlmoneda = By.cssSelector("select[name='num_almoneda']");
	
	By guardarGestionButton = By
			.cssSelector("button[class='button-save btn btn-success pull-right'][data-parent='gestion']");
	By descargarArchivoField = By.cssSelector("div[data-field='descarga_archivo']");
	By guardarJuicioButton = By
			.cssSelector("button[class='button-save btn btn-success pull-right'][data-parent='juicio']");
	
	
	By listEtapas = By
			.cssSelector("div[class='list-header Search'][data-field='juicio']");
	

	public void cargarExpediente(RobotSial robotSial ,ExpedienteVO expedienteVO, String rutaArchivo) throws Exception {

		

		robotSial.click(menuItemBuscar, 0, VariablesGlobales.T3);
		robotSial.sendKeys(inputBuscar, expedienteVO.getNumeroCredito(), 0, VariablesGlobales.T2);
		
		robotSial.selectFirstDropdownList(listResultado, 0, VariablesGlobales.T2);
		
		robotSial.click(consultarJuicioButton, 0, VariablesGlobales.T3);
		boolean adicionar = robotSial.click(editarButton, adicionarButton, 0, VariablesGlobales.T3);
		
		robotSial.selectDropdownList(dropdownListEtapa, expedienteVO.getEtapa(), 0, VariablesGlobales.T3);
		robotSial.sendKeys(inputFecha, expedienteVO.getFecha(), 0, VariablesGlobales.T1);
		robotSial.selectDropdownList(dropdownListEstatus, expedienteVO.getEstatus(), 0, VariablesGlobales.T2);
		if(adicionar) {
			robotSial.click(guardarParaAgregarArchivoButton, 0, VariablesGlobales.T3);
		}
		
		robotSial.click(editarArchivoButton, 0, VariablesGlobales.T1);
		robotSial.sendKeys(seleccionarArchivo, rutaArchivo, 0, VariablesGlobales.T3);
		robotSial.selectDropdownList(dropdownListTipoProcesoDemanda, expedienteVO.getTipoDeProcesoDemanda(), 0,
				VariablesGlobales.T3);
		robotSial.sendKeys(inputNumExpediente, expedienteVO.getNumExpediente(), 0, VariablesGlobales.T1);
		robotSial.selectDropdownList(dropdownListEstadoJuzgado, expedienteVO.getEstadoJuzgado(), 0, VariablesGlobales.T2);
		robotSial.selectDropdownList(dropdownListMunicipioJuzgado, expedienteVO.getMunicipioJuzgado(), 0,
				VariablesGlobales.T2);
		robotSial.selectDropdownList(dropdownListTipoJuicio, expedienteVO.getTipoDeJuicio(), 0, VariablesGlobales.T2);
		robotSial.selectDropdownList(dropdownListJuzgado, expedienteVO.getJuzgado(), 0, VariablesGlobales.T2);
		
		robotSial.sendKeys(inputMontoTotalSentencia, expedienteVO.getMontoTotalSentencia(), 0, VariablesGlobales.T1);
		robotSial.selectDropdownList(dropdownListMonedaSentencia, expedienteVO.getMonedaSentencia(), 0, VariablesGlobales.T2);
		robotSial.sendKeys(inputTipoCambioSentencia, expedienteVO.getTipoCambioSentencia(), 0, VariablesGlobales.T1);
		
		robotSial.sendKeys(inputMontoAjudicacion, expedienteVO.getMontoAdjudicacion(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputMontoAvaluo, expedienteVO.getMontoAvaluoPesos(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputFechaAvaluo, expedienteVO.getFechaAvaluo(), 0, VariablesGlobales.T1);
		robotSial.selectDropdownList(dropdownListEstadoNotaria, expedienteVO.getEstadoNotaria(), 0, VariablesGlobales.T2);
		robotSial.selectDropdownList(dropdownListMunicipioNotaria, expedienteVO.getMunicipioNotaria(), 0,
				VariablesGlobales.T2);
		robotSial.sendKeys(inputNombreNotario, expedienteVO.getNombreDeNotario(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputNumNotario, expedienteVO.getNumNotaria(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputFechaExpiraSentencia, expedienteVO.getFechaExpiraSentencia(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputFechaSentencia, expedienteVO.getFechaSentencia(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputUnidadAvaluoPredio, expedienteVO.getUnidadDeValuacionOPerito(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputFechaVencimientoAvaluo, expedienteVO.getFechaVencimientoAvaluo(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputSuperficieConstruccion, expedienteVO.getSuperficieConstruccion(), 0, VariablesGlobales.T1);
		robotSial.selectDropdownList(dropdownListEntidadInmuebleGarantia, expedienteVO.getEntidadUbicacionInmuebleGarantia(),
				0, VariablesGlobales.T2);
		robotSial.selectDropdownList(dropdownListMunicipioInmuebleGarantia,
				expedienteVO.getMunicipioUbicacionInmuebleGarantia(), 0, VariablesGlobales.T2);
		robotSial.sendKeys(inputColoniaInmuebleGarantia, expedienteVO.getColoniaInmuebleGarantia(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputCalleNumeroInmuebleGarantia, expedienteVO.getCalleYNumeroInmuebleGarantia(), 0,
				VariablesGlobales.T1);
		robotSial.sendKeys(inputCPInmuebleGarantia, expedienteVO.getCpInmuebleGarantia(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputFechaAprobacionRemate, expedienteVO.getFechaAprobacionRemate(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputFechaRemateFirme, expedienteVO.getFechaRemateFirme(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputCantidadPostuaraLegal, expedienteVO.getCantidadPosturaLegalPesos(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputFechaSentenciaLiquidacion,
				expedienteVO.getFechaSentenciaInterlocutoriaIncidenteLiquidacion(), 0, VariablesGlobales.T1);
		robotSial.sendKeys(inputSaldoReconocido, expedienteVO.getSaldoTotalReconocidoAFavorInfonavitALaFechaPesos(), 0,
				VariablesGlobales.T1);
		robotSial.sendKeys(inputFechaAdminisioDemanda, expedienteVO.getFechaAdmisionDemanda(), 0, VariablesGlobales.T1);
		
		robotSial.sendKeys(inputFechaEmplazamiento, expedienteVO.getFechaEmplazamiento(), 0, VariablesGlobales.T1);
		
		robotSial.sendKeys(inputNumeroPleitosCobranza, expedienteVO.getNumeroPoderPleitosYCobranzas(), 0,
				VariablesGlobales.T1);
		robotSial.sendKeys(inputNombreApoderadoInfonavit, expedienteVO.getNombreApoderadoInfonavit(), 0,
				VariablesGlobales.T1);
		
		robotSial.selectDropdownList(dropdownListNumAlmoneda,
				expedienteVO.getNumAlmoneda(), 0, VariablesGlobales.T2);
		

		robotSial.click(guardarGestionButton, 0, VariablesGlobales.T3);
		robotSial.click(descargarArchivoField, 0, VariablesGlobales.T4);
		robotSial.click(guardarJuicioButton, 0, VariablesGlobales.T3);
		//Evento al final para darle tiempo al nevegador de guardar
		robotSial.click(listEtapas, 0, VariablesGlobales.T2);



	}
}
