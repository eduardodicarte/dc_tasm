package br.com.dicarte.seleniummantis.ejb.enums.mantis;

import com.capgemini.seleniummantis.ejb.enums.EnumMensagensLabel;

public enum EnumInfoMantis {
	NENHUM_VALOR_TIPO_STRING(EnumMensagensLabel.NENHUM_VALOR_TIPO_STRING.getCodigoMensagem()),
	NENHUM_VALOR_TIPO_INTEGER(EnumMensagensLabel.NENUM_VALOR_TIPO_INTEGER.getCodigo()),
	NOME_SISTEMA_OPERACIONAL(EnumMensagensLabel.NOME_SISTEMA_OPERACIONAL.getCodigoMensagem());

	private String	mensagem;
	private Integer codigo;

	private EnumInfoMantis(String mensagem) {
		this.mensagem = mensagem;
	}
	
	private EnumInfoMantis(Integer codigo){
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	
	public Integer getCodigo() {
		return codigo;
	}

	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
