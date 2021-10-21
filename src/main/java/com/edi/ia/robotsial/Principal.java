package com.edi.ia.robotsial;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.edi.ia.robotsial.controlador.ControladorRobotSial;
import com.edi.ia.robotsial.modelo.ExpedienteVO;
import com.edi.ia.robotsial.modelo.ExpedientesVO;
import com.edi.ia.robotsial.modelo.ParametrosConfiguracionVO;
import com.edi.ia.robotsial.modelo.Respuesta;
import com.edi.ia.robotsial.util.Utilidad;
import com.edi.ia.robotsial.util.VariablesGlobales;

public class Principal {

	public static void main(String[] args) {
		
		try {
		ControladorRobotSial controladorRobotSial = new ControladorRobotSial();
		
		Utilidad utilidad = new Utilidad();
		ParametrosConfiguracionVO parametrosConfiguracionVO = utilidad.leerConfiguracion(VariablesGlobales.RUTA_PARAMETROS_CONFIGURACION.replaceAll("/", System.getProperty("file.separator")));
		
		Date date = new Date();
		DateFormat formateadorFechaMedia = DateFormat.getDateInstance(DateFormat.MEDIUM);
		
		DateFormat formateadorHoraMedia = DateFormat.getTimeInstance(DateFormat.MEDIUM);
		
		String pathArchivoResultado = parametrosConfiguracionVO.getPathArchivoRespuesta() + formateadorFechaMedia.format(date)+" "+formateadorHoraMedia.format(date) + " Resultado.csv";
		
		utilidad.crearArchivoResultado(pathArchivoResultado);
		Respuesta respuesta = new Respuesta();
		respuesta.setCuentaSial("Cliente");
		respuesta.setMensajeError("Mensaje Error");
		respuesta.setNumeroCredito("Credito");
		respuesta.setResultado("Resultado carga");
		utilidad.agregarLineaResultado(respuesta.getRespuesta(), pathArchivoResultado);
		
		ExpedientesVO expedientesVO = new ExpedientesVO();
		expedientesVO.setTipoCarga("dictamenVivienda");
		ArrayList<ExpedienteVO> listExpedienteVO = utilidad.leerExpedientes(parametrosConfiguracionVO.getPathArchivoCarga());
			
		for (ExpedienteVO expedienteVO : listExpedienteVO) {	
			ArrayList<ExpedienteVO> list = new ArrayList<ExpedienteVO>();
			list.add(expedienteVO);
			expedientesVO.setExpedientes(list);
			controladorRobotSial.cargarExpediente(expedientesVO, parametrosConfiguracionVO, pathArchivoResultado);
		}
			expedientesVO.setTipoCarga("dictamenVivienda");
			ExpedienteVO expedienteVO = new ExpedienteVO();
			ArrayList<ExpedienteVO> list = new ArrayList<ExpedienteVO>();
			list.add(expedienteVO);
			expedientesVO.setExpedientes(list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
