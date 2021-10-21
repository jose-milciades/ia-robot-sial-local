package com.edi.ia.robotsial.util;

import java.math.BigDecimal;

public class VariablesGlobales {
	
	public static String TIPO_REEMBOLSO_SANEAMIENTO = "Saneamientos";
	public static String OPTION = "option";
	public static String TIPO_COMPROBANTE_RECIBO = "Recibo";
	public static String FILTRO_FECHA_DOCUMENTO = "Fecha documento";
	public static String FILTRO_SUBTOTAL = "Subtotal";
	public static int INTENTOS_FALLIDOS = 5;
	public static int T1 = 1000;
	public static int T2 = 2000;
	public static int T3 = 3000;
	public static int T4 = 20000;
	public static String CODIGO_ERROR_03 = "ERROR_03";
	public static String MENSAJE_ERROR_03 = "El elemento no se encontró en la página Web: ";
	public static String CODIGO_ERROR_04 = "ERROR_04";
	public static String MENSAJE_ERROR_04 = "El dato no existe en la lista de selección. Dato: ";
	public static String CODIGO_ERROR_05 = "ERROR_05";
	public static String MENSAJE_ERROR_05 = "Error al autenticarse: ";
	public static String CODIGO_ERROR_06 = "ERROR_06";
	public static String MENSAJE_ERROR_06 = "Error al cargar la pagina Web: ";
	public static String CODIGO_ERROR_07 = "ERROR_06";
	public static String MENSAJE_ERROR_07 = "Error al descargar el archivo: ";
	public static String CODIGO_ERROR_08 = "ERROR_08";
	public static String MENSAJE_ERROR_08 = "Georrefencia no corresponde a Mexico: ";
	public static String CODIGO_ERROR_09 = "ERROR_09";
	public static String MENSAJE_ERROR_09 = "Ya existe un dictamen de vivienda";
	public static String END_POINT = "robotSial/cargarExpediente";
	public static String PROCESO_TERMINADO_CARGA_SIAL = "carga_sial";
	public static String TIPO_CARGA_DICTAMEN_VIVIENDA = "dictamenVivienda";
	public static BigDecimal LATITUD_SUPERIOR = new BigDecimal("33");
	public static BigDecimal LATITUD_INFERIOR = new BigDecimal("14");
	public static BigDecimal LONGITUD_SUPERIOR = new BigDecimal("-86");
	public static BigDecimal LONGITUD_INFERIOR = new BigDecimal("-118");
	public static String RUTA_PARAMETROS_CONFIGURACION = "src/main/resources/parametrosConfiguracion.json";
	public static String RESPUESTA_EXITOSA = "EXITOSO";
	public static String RESPUESTA_FALLIDA = "FALLIDO";
	
}

