package com.edi.ia.robotsial.modelo;

public class Respuesta {
	
	private String resultado;
	private String numeroCredito;
	private String cuentaSial;
	private String mensajeError;
	private String respuesta;
	
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getNumeroCredito() {
		return numeroCredito;
	}
	public void setNumeroCredito(String numeroCredito) {
		this.numeroCredito = numeroCredito;
	}
	public String getCuentaSial() {
		return cuentaSial;
	}
	public void setCuentaSial(String cuentaSial) {
		this.cuentaSial = cuentaSial;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	public String getRespuesta() {
		return resultado+";"+cuentaSial+";"+numeroCredito+";"+mensajeError;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
}
