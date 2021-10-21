package com.edi.ia.robotsial.modelo;

import java.util.ArrayList;

public class ExpedientesVO {
	private int idCarga;
	private String numeroCredito;
	private String tipoCarga;
	private ArrayList<ExpedienteVO> expedientes;
	public int getIdCarga() {
		return idCarga;
	}

	public String getTipoCarga() {
		return tipoCarga;
	}

	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}

	public void setIdCarga(int idCarga) {
		this.idCarga = idCarga;
	}

	public String getNumeroCredito() {
		return numeroCredito;
	}

	public void setNumeroCredito(String numeroCredito) {
		this.numeroCredito = numeroCredito;
	}

	public ArrayList<ExpedienteVO> getExpedientes() {
		return expedientes;
	}

	public void setExpedientes(ArrayList<ExpedienteVO> expedientes) {
		this.expedientes = expedientes;
	}

	

	
}

