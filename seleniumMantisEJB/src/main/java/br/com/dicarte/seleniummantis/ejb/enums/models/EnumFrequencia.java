package br.com.dicarte.seleniummantis.ejb.enums.models;

public enum EnumFrequencia implements EnumIf {

	NENHUM_SELECIONADO(0),
	SEMPRE(10),
	NAO_SE_TENTOU(20),
	AS_VEZES(30),
	ALEATORIO(50),
	INCAPAZ_DE_REPRODUZIR(90),
	ND(100);

	private Integer	codigoEnum;

	private EnumFrequencia(Integer codigoEnum) {
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
		return EnumFrequencia.values();
	}
}
