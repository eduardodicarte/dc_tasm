package br.com.dicarte.seleniummantis.ejb.enums.models;

public enum EnumResolucao implements EnumIf {

	NENHUM_SELECIONADO(0),
	ABERTO(10),
	CORRIGIDO(20),
	DUPLICADO(60);

	private Integer	codigoEnum;

	private EnumResolucao(Integer codigoEnum) {
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
		return EnumResolucao.values();
	}
}
