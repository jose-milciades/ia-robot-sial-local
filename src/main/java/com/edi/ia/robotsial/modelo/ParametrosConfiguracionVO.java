package com.edi.ia.robotsial.modelo;


public class ParametrosConfiguracionVO {
	public  String webDriver;
	public  String pathArchivo;
	public  String pathWebDriver;
	public  String urlSial;
	public  String login;
	public  String password;
	public  String pathArchivoCarga;
	public  String pathArchivoRespuesta;
	public  String fileSeparator;
	
public  ParametrosConfiguracionVO() {
		this.fileSeparator = System.getProperty("file.separator");
		
	}
	
	public String getFileSeparator() {
		return fileSeparator;
	}



	public void setFileSeparator(String fileSeparator) {
		this.fileSeparator = fileSeparator;
	}



	



	public String getPathArchivo() {
		return pathArchivo.replaceAll("/", fileSeparator);
	}



	public void setPathArchivo(String pathArchivo) {
		
		this.pathArchivo = pathArchivo;
	}



	public String getPathArchivoCarga() {
		return pathArchivoCarga.replaceAll("/", fileSeparator);
	}



	public void setPathArchivoCarga(String pathArchivoCarga) {
		this.pathArchivoCarga = pathArchivoCarga;
	}



	public String getPathArchivoRespuesta() {
		return pathArchivoRespuesta.replaceAll("/", fileSeparator);
	}



	public void setPathArchivoRespuesta(String pathArchivoRespuesta) {
		this.pathArchivoRespuesta = pathArchivoRespuesta;
	}



	public String getUrlSial() {
		return urlSial;
	}



	public String getWebDriver() {
		return webDriver;
	}



	public void setWebDriver(String webDriver) {
		this.webDriver = webDriver;
	}




	public String getPathWebDriver() {
		return pathWebDriver.replaceAll("/", fileSeparator);
	}



	public void setPathWebDriver(String pathWebDriver) {
		this.pathWebDriver = pathWebDriver;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setUrlSial(String urlSial) {
		this.urlSial = urlSial;
	}

	
	
	
}
