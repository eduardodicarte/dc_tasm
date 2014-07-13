package br.com.dicarte.seleniummantis.ejb.enums.models;

public enum EnumVisibilidade implements EnumIf {

	NENHUM_SELECIONADO(0),
	PUBLICO(10),
	PRIVADO(50);

	private Integer	codigoEnum;

	private EnumVisibilidade(Integer codigoEnum) {
		this.codigoEnum = codigoEnum;
	}

	public Integer getCodigoEnum() {
		return codigoEnum;
	}

	public void setCodigoEnum(Integer codigoEnum) {
		this.codigoEnum = codigoEnum;
	}

	public EnumIf[] toArray() {
		return EnumVisibilidade.values();
	}
}
