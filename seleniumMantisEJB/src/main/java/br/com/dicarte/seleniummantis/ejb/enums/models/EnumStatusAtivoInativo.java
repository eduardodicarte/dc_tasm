package br.com.dicarte.seleniummantis.ejb.enums.models;


public enum EnumStatusAtivoInativo implements EnumIf {
	NENHUM_SELECIONADO(2),
	INATIVO(0),
	ATIVO(1);

	private Integer	codigoEnum;

	private EnumStatusAtivoInativo(Integer codigoEnum) {
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
		return EnumStatusAtivoInativo.values();
	}
}
