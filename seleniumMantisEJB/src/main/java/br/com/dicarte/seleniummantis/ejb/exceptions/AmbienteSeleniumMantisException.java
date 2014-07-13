package br.com.dicarte.seleniummantis.ejb.exceptions;

/**
 * Classe de exceções para erro de configuração de ambiente
 * 
 * @author eduardo.dicarte
 */

public class AmbienteSeleniumMantisException extends Exception {

	private static final long	serialVersionUID	= 4036383174876728541L;

	private String				mensagem;
	private Throwable			causaExcecao;
	private Exception			exception;
	private RuntimeException	runtimeException;

	public AmbienteSeleniumMantisException(String mensagem) {
		this.mensagem = mensagem;
	}

	public AmbienteSeleniumMantisException(Throwable causaExcecao, String mensagem) {
		this.mensagem = mensagem;
		this.causaExcecao = causaExcecao;
	}

	public AmbienteSeleniumMantisException(Exception exception) {
		this.exception = exception;
	}

	public AmbienteSeleniumMantisException(RuntimeException runtimeException) {
		this.runtimeException = runtimeException;
	}

	public Throwable getCausaExcecao() {
		return causaExcecao;
	}

	public void setCausaExcecao(Throwable causaExcecao) {
		this.causaExcecao = causaExcecao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public RuntimeException getRuntimeException() {
		return runtimeException;
	}

	public void setRuntimeException(RuntimeException runtimeException) {
		this.runtimeException = runtimeException;
	}
}
