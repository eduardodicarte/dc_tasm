package br.com.dicarte.seleniummantis.ejb.enums;

public enum EnumMensagemException {
	OBJETO_NULO(EnumMensagensLabel.EXCECAO_OBJETO_NULO.getCodigoMensagem()),
	ERRO_PARAMETRO(EnumMensagensLabel.ERRO_PARAMETRO.getCodigoMensagem()),
	VALOR_NAO_PREENCHIDO(EnumMensagensLabel.EXCECAO_VALOR_NAO_PREENCHIDO.getCodigoMensagem()),
	USUARIO_MANTIS_NAO_ENCONTRADO(EnumMensagensLabel.EXCECAO_USUARIO_MANTIS_NAO_ENCONTRADO.getCodigoMensagem()),
	MANTIS_NAO_ENCONTRADO(EnumMensagensLabel.EXCECAO_MANTIS_NAO_ENCONTRADO.getCodigoMensagem()),
	MANTIS_JA_EXISTE(EnumMensagensLabel.EXCECAO_MANTIS_JA_EXISTE.getCodigoMensagem()),
	PROJETO_NAO_ENCONTRADO(EnumMensagensLabel.EXCECAO_PROJETO_NAO_ENCONTRADO.getCodigoMensagem()),
	CATEGORIA_NAO_ENCONTRADA(EnumMensagensLabel.EXCECAO_CATEGORIA_NAO_ENCONTRADA.getCodigoMensagem()),
	NENHUM_RESULTADO(EnumMensagensLabel.NENHUM_RESULTADO.getCodigoMensagem());

	private String	mensagem;

	private EnumMensagemException(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
