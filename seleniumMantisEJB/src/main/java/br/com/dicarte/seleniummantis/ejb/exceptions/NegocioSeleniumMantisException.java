package br.com.dicarte.seleniummantis.ejb.exceptions;

/**
 * Classe de exce��o para erros de sistema, relacionado a camada de neg�cios
 * @author eduardo.dicarte
 *
 */

public class NegocioSeleniumMantisException extends Exception {

	private static final long	serialVersionUID	= -4179308944366447098L;

	private String				mensagem;
	private Throwable			causaExcecao;
	private Exception			exception;
	private RuntimeException	runTimeException;

	public NegocioSeleniumMantisException(String mensagem) {
		this.mensagem = mensagem;
	}

	public NegocioSeleniumMantisException(Throwable causaExcecao, String mensagem) {
		this.mensagem = mensagem;
		this.causaExcecao = causaExcecao;
	}

	public NegocioSeleniumMantisException(Exception exception) {
		this.exception = exception;
	}

	public NegocioSeleniumMantisException(RuntimeException runtimeException) {
		this.runTimeException = runtimeException;
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

	public RuntimeException getRunTimeException() {
		return runTimeException;
	}

	public void setRunTimeException(RuntimeException runTimeException) {
		this.runTimeException = runTimeException;
	}
}
