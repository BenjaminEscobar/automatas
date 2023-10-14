package com.analizador.demo.dto;

import java.util.List;

public class Respuesta {

	private List<TokenAnalizador> listaToken;
	private List<AttributeAnalizador> listaAtributo;
	private String nombreClase;
	
	
	public List<TokenAnalizador> getListaToken() {
		return listaToken;
	}
	public void setListaToken(List<TokenAnalizador> listaToken) {
		this.listaToken = listaToken;
	}
	public List<AttributeAnalizador> getListaAtributo() {
		return listaAtributo;
	}
	public void setListaAtributo(List<AttributeAnalizador> listaAtributo) {
		this.listaAtributo = listaAtributo;
	}
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	
	
}
