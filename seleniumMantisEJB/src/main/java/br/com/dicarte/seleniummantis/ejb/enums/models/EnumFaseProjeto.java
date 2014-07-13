package br.com.dicarte.seleniummantis.ejb.enums.models;

public enum EnumFaseProjeto implements EnumIf {

	NENHUM_SELECIONADO(0),
	DESENVOLVIMENTO(10),
	VERSAO_ENTREGUE(30),
	ESTAVEL(50),
	OBSOLETO(70);

	private Integer	codigoEnum;

	private EnumFaseProjeto(Integer codigoEnum) {
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
		return EnumFaseProjeto.values();
	}
}
