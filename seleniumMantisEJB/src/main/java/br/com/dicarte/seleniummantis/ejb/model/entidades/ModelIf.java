package br.com.dicarte.seleniummantis.ejb.model.entidades;

import java.io.Serializable;

public interface ModelIf extends Serializable  {
	
	public Integer getIdentificador();
	
	public void setIdentificador(Integer identificador);
	
	public String[] getNomeColecoes();
}
