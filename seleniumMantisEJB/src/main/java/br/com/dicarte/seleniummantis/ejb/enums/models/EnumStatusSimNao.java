package br.com.dicarte.seleniummantis.ejb.enums.models;


public enum EnumStatusSimNao implements EnumIf {

	NENHUM_SELECIONADO(3),
	SIM(0),
	NAO(1);

	private Integer	codigoEnum;

	private EnumStatusSimNao(Integer codigoEnum) {
		this.codigoEnum = codigoEnum;
	}

	@Override
	public Integer getCodigoEnum() {
		return codigoEnum;
	}

	@Override
	public void setCodigoEnum(Integer codigoEnum) {
		this.codigoEnum = codigoEnum;
	}

	@Override
	public EnumIf[] toArray() {
		return EnumStatusSimNao.values();
	}
}