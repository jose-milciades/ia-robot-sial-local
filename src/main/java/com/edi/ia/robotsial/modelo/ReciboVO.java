package com.edi.ia.robotsial.modelo;

public class ReciboVO {
	
	private String nombreArchivo;
	private String fechaDocumento;
	private String subtotal;
	private String origenURL;
	
	
	
	public String getOrigenURL() {
		return origenURL;
	}

	public void setOrigenURL(String origenURL) {
		this.origenURL = origenURL;
	}

	public String getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(String fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	

}
