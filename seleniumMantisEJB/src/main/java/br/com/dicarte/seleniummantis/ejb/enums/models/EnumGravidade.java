package br.com.dicarte.seleniummantis.ejb.enums.models;

public enum EnumGravidade implements EnumIf {

	NENHUM_SELECIONADO(0),
	RECURSO(10),
	TRIVIAL(20),
	TEXTO(30),
	MINIMO(40),
	PEQUENO(50),
	GRANDE(60),
	TRAVAMENTO(70),
	OBSTACULO(80);

	private Integer	codigoEnum;

	private EnumGravidade(Integer codigoEnum) {
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
		return EnumGravidade.values();
	}
}
