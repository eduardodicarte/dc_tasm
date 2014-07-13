package br.com.dicarte.seleniummantis.ejb.enums.models;


public enum EnumPrioridade implements EnumIf {

	NENHUM_SELECIONADO(0),
	NENHUMA(10),
	BAIXA(20),
	NORMAL(30),
	ALTA(40),
	URGENTE(50),
	IMEDIATO(60);

	private Integer	codigoEnum;

	private EnumPrioridade(Integer codigoEnum) {
		this.codigoEnum = codigoEnum;
	}

	public Integer getCodigoEnum() {
		return codigoEnum;
	}

	public void setCodigoEnum(Integer codigoEnum) {
		this.codigoEnum = codigoEnum;
	}

	@Override
	public EnumIf[] toArray() {
		return EnumPrioridade.values();
	}

}
