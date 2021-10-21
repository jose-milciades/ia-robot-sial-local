package com.edi.ia.robotsial;

import java.util.ArrayList;

import com.edi.ia.robotsial.controlador.ControladorRobotSial;
import com.edi.ia.robotsial.modelo.ExpedienteVO;
import com.edi.ia.robotsial.modelo.ExpedientesVO;

public class Principal {

	public static void main(String[] args) {
		ControladorRobotSial controladorRobotSial = new ControladorRobotSial();
		try {
			ExpedientesVO expedientesVO = new ExpedientesVO();
			expedientesVO.setTipoCarga("dictamenVivienda");
			ExpedienteVO expedienteVO = new ExpedienteVO();
			ArrayList<ExpedienteVO> list = new ArrayList<ExpedienteVO>();
			list.add(expedienteVO);
			expedientesVO.setExpedientes(list);
			
			
			expedienteVO.setNumeroCredito("206067681");
			expedienteVO.setNombreArchivo("206067681.jpeg");
			expedienteVO.setUrlExpediente("https://cardmin.frion.mx/credito/8493/visita/2633/RUBDXt6sYfr5tq1W9mrs3VaY3SoqcRCeePCIzt0F.jpeg");
				expedienteVO.setDomicilioLocalizado("SI");
				expedienteVO.setEstadoVivienda("Malo");
				expedienteVO.setHabitada("x");
				expedienteVO.setVentanas("x");
				expedienteVO.setMuebles("");
				expedienteVO.setMedidor_de_luz("");
				expedienteVO.setMedidor_de_agua("");
				expedienteVO.setAutos("");

				expedienteVO.setPersonaContactada("Sin contacto");
				expedienteVO.setMotivoNoPago("");
				expedienteVO.setQuiereMantenerHogar("");
				expedienteVO.setCapacidadDePago("");

				expedienteVO.setComentario("Mal Estado");
				expedienteVO.setLatitud("32.586699");
				expedienteVO.setLongitud("-115.492157722222");
			
			controladorRobotSial.cargarExpediente(expedientesVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
