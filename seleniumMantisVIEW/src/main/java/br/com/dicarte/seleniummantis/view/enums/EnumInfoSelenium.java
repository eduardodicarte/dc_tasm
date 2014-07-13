package br.com.dicarte.seleniummantis.view.enums;

import br.com.dicarte.seleniummantis.view.util.SeleniumUtil;

import com.capgemini.seleniummantis.ejb.exceptions.AmbienteSeleniumMantisException;

public enum EnumInfoSelenium {
	ARQUIVO_NAO_ENCONTRADO("arquivo.inexistente"),
	BROWSER_NAO_SUPORTADO("browser.nao.suportado"),
	ATRIBUTO_NAO_ENCONTRADO("atributo.nao.encontrado");

	private String	codigoMensagem;

	private EnumInfoSelenium(String codigoMensagem) {
		this.codigoMensagem = codigoMensagem;
	}

	public String getMensagem() throws AmbienteSeleniumMantisException {
		return SeleniumUtil.obterMensagem(codigoMensagem);
	}

	public void setMensagem(String codigoMensagem) {
		this.codigoMensagem = codigoMensagem;
	}
}
