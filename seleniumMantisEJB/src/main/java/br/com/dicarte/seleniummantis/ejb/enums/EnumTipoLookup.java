package br.com.dicarte.seleniummantis.ejb.enums;


public enum EnumTipoLookup {

	LOCAL(0, EnumMensagensLabel.TIPO_FACHADA_LOCAL.getCodigoMensagem()),
	REMOTA(1, EnumMensagensLabel.TIPO_FACHADA_REMOTA.getCodigoMensagem());

	private String	codigoMensagem;
	private Integer	codigoEnum;

	private EnumTipoLookup(Integer codigoEnum, String codigoMensagem) {
		this.codigoEnum = codigoEnum;
		this.codigoMensagem = codigoMensagem;
	}

	public String getCodigoMensagem() {
		return codigoMensagem;
	}

	public void setCodigoMensagem(String codigoMensagem) {
		this.codigoMensagem = codigoMensagem;
	}

	public Integer getCodigoEnum() {
		return codigoEnum;
	}

	public void setCodigoEnum(Integer codigoEnum) {
		this.codigoEnum = codigoEnum;
	}

}
