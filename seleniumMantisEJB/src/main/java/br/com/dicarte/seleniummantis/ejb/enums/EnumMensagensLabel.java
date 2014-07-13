package br.com.dicarte.seleniummantis.ejb.enums;

import com.capgemini.seleniummantis.ejb.enums.models.EnumIf;
import com.capgemini.seleniummantis.ejb.util.NegocioConstantesIf;

public enum EnumMensagensLabel implements EnumIf {

	TIPO_FACHADA_LOCAL(NegocioConstantesIf.LOCAL),
	TIPO_FACHADA_REMOTA(NegocioConstantesIf.REMOTE),
	EXCECAO_OBJETO_NULO(NegocioConstantesIf.OBJETO_NULO),
	ERRO_PARAMETRO(NegocioConstantesIf.ERRO_PARAMETRO),
	EXCECAO_VALOR_NAO_PREENCHIDO(NegocioConstantesIf.VALOR_OBRIGATORIO_NAO_PREENCHIDO),
	EXCECAO_USUARIO_MANTIS_NAO_ENCONTRADO(NegocioConstantesIf.USUARIO_MANTIS_NAO_ENCONTRADO),
	EXCECAO_MANTIS_NAO_ENCONTRADO(NegocioConstantesIf.MANTIS_NAO_ENCONTRADO),
	EXCECAO_MANTIS_JA_EXISTE(NegocioConstantesIf.MANTIS_JA_EXISTE),
	EXCECAO_PROJETO_NAO_ENCONTRADO(NegocioConstantesIf.PROJETO_NAO_ENCONTRADO),
	EXCECAO_CATEGORIA_NAO_ENCONTRADA(NegocioConstantesIf.CATEGORIA_NAO_ENCONTRADA),
	NENHUM_VALOR_TIPO_STRING(NegocioConstantesIf.NENHUM_VALOR_TIPO_STRING),
	NENUM_VALOR_TIPO_INTEGER(NegocioConstantesIf.NENHUM_VALOR_TIPO_INTEGER),
	NOME_SISTEMA_OPERACIONAL(NegocioConstantesIf.SISTEMA_OPERACIONAL),
	NENHUM_RESULTADO(NegocioConstantesIf.NENHUM_RESULTADO);

	private String	codigoMensagem;
	private Integer	codigo;

	private EnumMensagensLabel(String codigoMensagem) {
		this.codigoMensagem = codigoMensagem;
	}

	private EnumMensagensLabel(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCodigoMensagem() {
		return codigoMensagem;
	}

	public void setCodigoMensagem(String codigoMensagem) {
		this.codigoMensagem = codigoMensagem;

	}

	@Override
	public Integer getCodigoEnum() {
		// ND
		return null;
	}

	@Override
	public void setCodigoEnum(Integer codigoEnum) {
		// ND
	}

	@Override
	public EnumIf[] toArray() {
		return EnumMensagensLabel.values();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
