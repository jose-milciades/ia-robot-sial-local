package com.edi.ia.robotsial.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

import com.edi.ia.robotsial.modelo.ExpedienteVO;
import com.edi.ia.robotsial.modelo.ExpedientesVO;
import com.edi.ia.robotsial.modelo.ParametrosConfiguracionVO;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;



public class Utilidad {

	public String descargarArchivo(String origenURL, String rutaDirectorio, String nombreArchivo) throws IOException {
		URL url = new URL(origenURL);
		Path path = new File(rutaDirectorio + File.separator + nombreArchivo).toPath();
		Files.copy(url.openStream(), path, StandardCopyOption.REPLACE_EXISTING);
		File file = new File(rutaDirectorio + nombreArchivo);
		return file.getAbsolutePath();
	}

	public void borrarDirectorio(String ruta) throws IOException {
		if (!ruta.isEmpty()) {
			Path path = new File(ruta).toPath();
			Files.deleteIfExists(path);
		}
	}
	
	public boolean isEmpty(String dato) {
		boolean respuesta = true;
		if(dato != null) {
			if(!dato.trim().isEmpty()) {
				respuesta = false;
			}
		}
			return respuesta;
	}
	
	public boolean equals(String datoA, String datoB) {
		boolean respuesta = false;
		if(datoA != null && datoB != null) {
			if(datoA.equals(datoB)) {
				respuesta = true;
			}
		}
			return respuesta;
	}
	
	public boolean georrefenciaSeEncuentraEnMexico(BigDecimal latitud, BigDecimal longitud) {
		boolean resultado = true;
		if(!(latitud.compareTo(VariablesGlobales.LATITUD_SUPERIOR)==-1 && latitud.compareTo(VariablesGlobales.LATITUD_INFERIOR)==1)) {
			resultado = false;
		}
		else if(!(longitud.compareTo(VariablesGlobales.LONGITUD_SUPERIOR)==-1 && longitud.compareTo(VariablesGlobales.LONGITUD_INFERIOR)==1)) {
			resultado = false;
		}
				return resultado;
	}
	

public ParametrosConfiguracionVO leerConfiguracion(String ruta) throws IOException, JsonSyntaxException {

		Gson gson = new Gson();
		ParametrosConfiguracionVO parametrosConfiguracionVO;
		String archivoConfiguracion = "";
		try (Stream<String> stream = Files.lines(Paths.get(ruta))) {
			Iterator<String> lineas = stream.iterator();
			while (lineas.hasNext()) {
				archivoConfiguracion += lineas.next().toString().trim();
			}
			parametrosConfiguracionVO = gson.fromJson(archivoConfiguracion, ParametrosConfiguracionVO.class);
		}
		return parametrosConfiguracionVO;
	}

public ArrayList<ExpedienteVO> leerExpedientes(String ruta) throws Exception {
	
	ArrayList<ExpedienteVO> listExpedienteVO = new ArrayList<ExpedienteVO>();
	
	
	try (Stream<String> stream = Files.lines(Paths.get(ruta))) {
		Iterator<String> lineas = stream.iterator();
		String linea[];
		
		if(lineas.hasNext()) {
			//linea de encabezado
			lineas.next();
		while (lineas.hasNext()) {
			ExpedienteVO expedienteVO = new ExpedienteVO();
			linea = lineas.next().toString().split(";");
			expedienteVO.setNumeroCredito(linea[0]);
			expedienteVO.setNombreArchivo(linea[1]);
			expedienteVO.setUrlExpediente(linea[2]);
				expedienteVO.setDomicilioLocalizado(linea[3]);
				expedienteVO.setEstadoVivienda(linea[4]);
				expedienteVO.setHabitada(linea[5]);
				expedienteVO.setVentanas(linea[6]);
				expedienteVO.setMuebles(linea[7]);
				expedienteVO.setMedidor_de_luz(linea[8]);
				expedienteVO.setMedidor_de_agua(linea[9]);
				expedienteVO.setAutos(linea[10]);

				expedienteVO.setPersonaContactada(linea[11]);
				expedienteVO.setMotivoNoPago(linea[12]);
				expedienteVO.setQuiereMantenerHogar(linea[13]);
				expedienteVO.setCapacidadDePago(linea[14]);

				expedienteVO.setComentario(linea[15]);
				expedienteVO.setLatitud(linea[16].replace(",", "."));
				expedienteVO.setLongitud(linea[17].replace(",", "."));
				
				listExpedienteVO.add(expedienteVO);
		}
		}
	} catch (ArrayIndexOutOfBoundsException e) {
		throw new Exception(e.getMessage());
	}
	return listExpedienteVO;
}

public void crearArchivoResultado(String ruta) throws IOException {
	Path path = Paths.get(ruta);
	try (BufferedWriter br = Files.newBufferedWriter(path, Charset.defaultCharset(), StandardOpenOption.CREATE)) {
	}
}

public void agregarLineaResultado(String linea, String ruta) throws Exception {
	Path path = Paths.get(ruta);
	//new BufferedWriter(new FileWriter(my_file_name, true));
	try (BufferedWriter br = Files.newBufferedWriter(path, Charset.defaultCharset(), StandardOpenOption.APPEND)) {
	//try (BufferedWriter br = BufferedWriter(new FileWriter(ruta, true))){
			try {
				br.append(linea);
				br.newLine();
			} catch (IOException e) {
				throw new Exception(e.getMessage());
			}
	}
}

}
