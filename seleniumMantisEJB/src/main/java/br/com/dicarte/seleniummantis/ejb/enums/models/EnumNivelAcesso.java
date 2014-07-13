package br.com.dicarte.seleniummantis.ejb.enums.models;


public enum EnumNivelAcesso implements EnumIf {

	NENHUM_SELECIONADO(0),
	ADMINISTRADOR(90),
	GERENTE(70),
	DESENVOLVEDOR(55),
	ATUALIZADOR(40),
	RELATOR(25),
	VISUALIZADOR(10);

	private Integer	codigoEnum;

	private EnumNivelAcesso(Integer codigoEnum) {
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
		return EnumNivelAcesso.values();
	}
}