package br.com.dicarte.seleniummantis.ejb.model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "responsaveis_projeto")
public class ResponsavelProjeto extends ModelImplem {

	private static final long	serialVersionUID	= -4786297022821802086L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer				identificador;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projeto")
	private Projeto				projeto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="usuario")
	private UsuarioMantis responsavel;

	@Override
	public Integer getIdentificador() {
		return tratarValorZero(identificador);
	}

	@Override
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	@Override
	public String[] getNomeColecoes() {
		return new String[]{""};
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	
	public UsuarioMantis getResponsavel() {
		return responsavel;
	}

	
	public void setResponsavel(UsuarioMantis responsavel) {
		this.responsavel = responsavel;
	}
}
