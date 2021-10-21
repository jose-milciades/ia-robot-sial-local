package com.edi.ia.robotsial.modelo;

import java.util.ArrayList;

public class RecibosVO {
	
	private ArrayList<ReciboVO> recibosVO;
	private String enlaceSial; 
	private String login; 
	private String clave;
	public ArrayList<ReciboVO> getRecibosVO() {
		return recibosVO;
	}
	public void setRecibosVO(ArrayList<ReciboVO> recibosVO) {
		this.recibosVO = recibosVO;
	}
	public String getEnlaceSial() {
		return enlaceSial;
	}
	public void setEnlaceSial(String enlaceSial) {
		this.enlaceSial = enlaceSial;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	} 
	

}
