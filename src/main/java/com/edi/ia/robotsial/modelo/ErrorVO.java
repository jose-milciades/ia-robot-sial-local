package com.edi.ia.robotsial.modelo;

public class ErrorVO {
	
	private int idCargaDemanda;
	private String codigoError;
	private String mensajeError;
	private String servicioEndpoint;
	private String peticion;
	
	public int getIdCargaDemanda() {
		return idCargaDemanda;
	}
	public void setIdCargaDemanda(int idCargaDemanda) {
		this.idCargaDemanda = idCargaDemanda;
	}
	public String getCodigoError() {
		return codigoError;
	}
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	public String getServicioEndpoint() {
		return servicioEndpoint;
	}
	public void setServicioEndpoint(String servicioEndpoint) {
		this.servicioEndpoint = servicioEndpoint;
	}
	public String getPeticion() {
		return peticion;
	}
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
}

