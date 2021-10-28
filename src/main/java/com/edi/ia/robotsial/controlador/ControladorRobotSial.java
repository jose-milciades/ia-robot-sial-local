package com.edi.ia.robotsial.controlador;

import java.io.IOException;



import org.openqa.selenium.chrome.ChromeDriver;



import com.edi.ia.robotsial.modelo.ErrorVO;
import com.edi.ia.robotsial.modelo.ExpedienteVO;
import com.edi.ia.robotsial.modelo.ExpedientesVO;
import com.edi.ia.robotsial.modelo.ParametrosConfiguracionVO;
import com.edi.ia.robotsial.modelo.ReciboVO;
import com.edi.ia.robotsial.modelo.RecibosVO;
import com.edi.ia.robotsial.modelo.Respuesta;
import com.edi.ia.robotsial.modelo.RespuestaCargaSialVO;
import com.edi.ia.robotsial.util.Utilidad;
import com.edi.ia.robotsial.util.VariablesGlobales;
import com.google.gson.Gson;


public class ControladorRobotSial  {

	
	
	Utilidad utilidad = new Utilidad();
	
	

	public void cargarReciboReembolsoSial(RecibosVO recibosVO) {
		
		try {
			ParametrosConfiguracionVO parametrosConfiguracionVO = utilidad.leerConfiguracion(VariablesGlobales.RUTA_PARAMETROS_CONFIGURACION);
			Navegador navegador = new Navegador();
			ChromeDriver driver = navegador.configurarNavegador(parametrosConfiguracionVO);
			RobotSial robotSial = new RobotSial(driver,parametrosConfiguracionVO);
			robotSial.cargarPagina(false);
			robotSial.autenticarse();
			robotSial.opcionCargarRecibo();
			for (ReciboVO reciboVO : recibosVO.getRecibosVO()) {
				utilidad.descargarArchivo(reciboVO.getOrigenURL(), parametrosConfiguracionVO.pathArchivo,
						reciboVO.getNombreArchivo(), null);
				robotSial.cargarRecibo(reciboVO, 1);
				robotSial.filtrarRecibos(reciboVO);
			}
		} catch (IllegalArgumentException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargarExpediente(ExpedientesVO expedientesVO, ParametrosConfiguracionVO parametrosConfiguracionVO,  String pathArchivoResultado) throws Exception {

		String rutaArchivo = "";
		RobotSial robotSial = null;
		Respuesta respuesta = new Respuesta();

		try {
			
			Navegador navegador = new Navegador();
			ChromeDriver driver = navegador.configurarNavegador(parametrosConfiguracionVO);
			robotSial = new RobotSial(driver, parametrosConfiguracionVO);
			
			//robotSial.cargarPagina(utilidad.equals(expedientesVO.getTipoCarga(), VariablesGlobales.TIPO_CARGA_DICTAMEN_VIVIENDA));
			robotSial.cargarPagina(false);
			robotSial.autenticarse();
			for (ExpedienteVO expedienteVO : expedientesVO.getExpedientes()) {
				try {

					rutaArchivo = utilidad.descargarArchivo(expedienteVO.getUrlExpediente(),
							parametrosConfiguracionVO.pathArchivo, expedienteVO.getNombreArchivo(), expedientesVO.getTipoCarga());
					
					if(utilidad.isEmpty(expedientesVO.getTipoCarga())) {
						RobotSialCargarExpediente robotSialCargarExpediente = new RobotSialCargarExpediente();
						robotSialCargarExpediente.cargarExpediente(robotSial, expedienteVO, rutaArchivo);
						
					}

					else if (expedientesVO.getTipoCarga().equals(VariablesGlobales.TIPO_CARGA_DICTAMEN_VIVIENDA)) {
						CargarDictamenVivienda cargarDictamenVivienda = new CargarDictamenVivienda();
						robotSial.iniciarSesionDevTools();
						cargarDictamenVivienda.cargarDictamenVivienda(robotSial, expedienteVO, rutaArchivo);
						robotSial.salirDevTools();

					} 
					utilidad.borrarDirectorio(rutaArchivo);

					respuesta.setCuentaSial(parametrosConfiguracionVO.getLogin());
					respuesta.setMensajeError("");
					respuesta.setNumeroCredito(expedienteVO.getNumeroCredito());
					respuesta.setResultado(VariablesGlobales.RESPUESTA_EXITOSA);
					utilidad.agregarLineaResultado(respuesta.getRespuesta(), pathArchivoResultado);
					
					RespuestaCargaSialVO respuestaCargaSialVO = new RespuestaCargaSialVO();
					respuestaCargaSialVO.setIdCargaDemanda(expedienteVO.getIdCargaDemanda());
					respuestaCargaSialVO.setIdExpediente(expedienteVO.getIdExpediente());
					respuestaCargaSialVO.setProcesoTerminado(VariablesGlobales.PROCESO_TERMINADO_CARGA_SIAL);
					//this.restTemplate.postForEntity(ParametrosConfiguracionVO.wsRegistrarIntegracionExpediente,
					//		respuestaCargaSialVO, null);
				}

				catch (IOException e) {
					e.printStackTrace();
					utilidad.borrarDirectorio(rutaArchivo);
					
					respuesta.setCuentaSial(parametrosConfiguracionVO.getLogin());
					respuesta.setMensajeError(replaceBreakPoints(VariablesGlobales.MENSAJE_ERROR_07 + e.getMessage()));
					respuesta.setNumeroCredito(expedienteVO.getNumeroCredito());
					respuesta.setResultado(VariablesGlobales.RESPUESTA_FALLIDA);
					utilidad.agregarLineaResultado(respuesta.getRespuesta(), pathArchivoResultado);
					
					this.registrarError(expedienteVO, VariablesGlobales.CODIGO_ERROR_07,
							VariablesGlobales.MENSAJE_ERROR_07 + e.getMessage());

				} catch (Exception e) {
					e.printStackTrace();
					utilidad.borrarDirectorio(rutaArchivo);
					
					respuesta.setCuentaSial(parametrosConfiguracionVO.getLogin());
					respuesta.setMensajeError(replaceBreakPoints(e.getMessage()));
					respuesta.setNumeroCredito(expedienteVO.getNumeroCredito());
					respuesta.setResultado(VariablesGlobales.RESPUESTA_FALLIDA);
					utilidad.agregarLineaResultado(respuesta.getRespuesta(), pathArchivoResultado);
					
					this.registrarError(expedienteVO, VariablesGlobales.CODIGO_ERROR_03, e.getMessage());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			for (ExpedienteVO expedienteVO : expedientesVO.getExpedientes()) {
				e.printStackTrace();
				
				respuesta.setCuentaSial(parametrosConfiguracionVO.getLogin());
				respuesta.setMensajeError(replaceBreakPoints(VariablesGlobales.MENSAJE_ERROR_06 + e.getMessage()));
				respuesta.setNumeroCredito(expedienteVO.getNumeroCredito());
				respuesta.setResultado(VariablesGlobales.RESPUESTA_FALLIDA);
				utilidad.agregarLineaResultado(respuesta.getRespuesta(), pathArchivoResultado);
				
				this.registrarError(expedienteVO, VariablesGlobales.CODIGO_ERROR_06,
						VariablesGlobales.MENSAJE_ERROR_06 + e.getMessage());
			}
			throw e;
		}

		finally {

			try {
				this.salir(robotSial, rutaArchivo);
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	public String replaceBreakPoints(final String mensajeError) {
		String cadenaComas = mensajeError.replaceAll(";", ",");
		return cadenaComas.replaceAll("\n", " ");
	}

	public void salir(RobotSial robotSial, String rutaArchivo) throws IOException {
		if (robotSial != null) {
			robotSial.salir();
		}
		try {
			utilidad.borrarDirectorio(rutaArchivo);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	public void registrarError(ExpedienteVO expedienteVO, String codigoError, String MensajeError) {
		ErrorVO errorVO = new ErrorVO();
		Gson gson = new Gson();
		String json = gson.toJson(expedienteVO);
		errorVO.setServicioEndpoint(VariablesGlobales.END_POINT);
		errorVO.setIdCargaDemanda(expedienteVO.getIdCargaDemanda());
		errorVO.setCodigoError(codigoError);
		errorVO.setMensajeError(MensajeError);
		errorVO.setPeticion(json);
		System.out.println("Mensaje de error: "+errorVO.getMensajeError());
		//this.restTemplate.postForEntity(ParametrosConfiguracionVO.wsError, errorVO, null);

	}
}
