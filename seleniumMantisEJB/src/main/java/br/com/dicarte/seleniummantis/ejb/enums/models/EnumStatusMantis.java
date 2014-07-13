package br.com.dicarte.seleniummantis.ejb.enums.models;


public enum EnumStatusMantis implements EnumIf {

	NENHUM_SELECIONADO(0),
	NOVO(10),
	RETORNO(20),
	ADMITIDO(30),
	CONFIRMADO(40),
	ATRIBUIDO(50),
	RESOLVIDO(80),
	FECHADO(90);

	private Integer	codigoEnum;

	private EnumStatusMantis(Integer codigoEnum) {
		this.codigoEnum = codigoEnum;
	}

	@Override
	public Integer getCodigoEnum() {
		return this.codigoEnum;
	}

	@Override
	public void setCodigoEnum(Integer codigoEnum) {
		this.codigoEnum = codigoEnum;
	}

	@Override
	public EnumIf[] toArray() {
		return EnumStatusMantis.values();
	}
}
