package br.com.dicarte.seleniummantis.ejb.model.entidades;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe referencia as anotacoes especificas de cada anotacao que esta relacionada ao mantis
 * @author eduardo.dicarte
 *
 */

@Entity
@Table(name = "mantis_bugnote_text_table", catalog = "bugtracker")
public class DescricaoAnotacao extends ModelImplem {

	private static final long serialVersionUID = 1827133551335973403L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private Integer identificador;
		
	@Column(name = "note",columnDefinition="longtext")
	private String descricaoAnotacao;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="descricaoAnotacao")
	private Anotacao anotacao;

	@Override
	public Integer getIdentificador() {
		this.identificador = tratarValorZero(identificador); 
		return identificador;
	}

	@Override
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getDescricaoAnotacao() {
		return descricaoAnotacao;
	}

	public void setDescricaoAnotacao(String descricaoAnotacao) {
		this.descricaoAnotacao = descricaoAnotacao;
	}

	public Anotacao getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(Anotacao anotacao) {
		this.anotacao = anotacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((anotacao == null) ? 0 : anotacao.hashCode());
		result = prime
				* result
				+ ((descricaoAnotacao == null) ? 0 : descricaoAnotacao
						.hashCode());
		result = prime * result
				+ ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DescricaoAnotacao other = (DescricaoAnotacao) obj;
		if (anotacao == null) {
			if (other.anotacao != null)
				return false;
		} else if (!anotacao.equals(other.anotacao))
			return false;
		if (descricaoAnotacao == null) {
			if (other.descricaoAnotacao != null)
				return false;
		} else if (!descricaoAnotacao.equals(other.descricaoAnotacao))
			return false;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}

	@Override
	public String[] getNomeColecoes() {
		return new String[]{"anotacao"};
	}
}
