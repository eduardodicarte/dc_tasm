package br.com.dicarte.seleniummantis.ejb.model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe responsavel pela descricao dos erros nos mantis
 * 
 * @author eduardo.dicarte
 * 
 */

@Entity
@Table(name = "mantis_bug_text_table")
public class Descricao extends ModelImplem {

	private static final long	serialVersionUID	= -6908452267092118990L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer				identificador;

	@Column(name = "description",columnDefinition="longtext")
	private String				descricao;

	@Column(name = "steps_to_reproduce", columnDefinition = "LONGTEXT")
	private String				passosParaReproduzir;

	@Column(name = "additional_information", columnDefinition = "LONGTEXT")
	private String				informacoesAdicionais;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPassosParaReproduzir() {
		return passosParaReproduzir;
	}

	public void setPassosParaReproduzir(String passosParaReproduzir) {
		this.passosParaReproduzir = passosParaReproduzir;
	}

	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}

	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}

	@Override
	public void setIdentificador(Integer identificador) {
		this.identificador = travarValorNulo(identificador);
	}

	@Override
	public Integer getIdentificador() {
		return identificador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result + ((informacoesAdicionais == null) ? 0 : informacoesAdicionais.hashCode());
		result = prime * result + ((passosParaReproduzir == null) ? 0 : passosParaReproduzir.hashCode());
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
		Descricao other = (Descricao) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		if (informacoesAdicionais == null) {
			if (other.informacoesAdicionais != null)
				return false;
		} else if (!informacoesAdicionais.equals(other.informacoesAdicionais))
			return false;
		if (passosParaReproduzir == null) {
			if (other.passosParaReproduzir != null)
				return false;
		} else if (!passosParaReproduzir.equals(other.passosParaReproduzir))
			return false;
		return true;
	}

	@Override
	public String[] getNomeColecoes() {
		return null;
	}
}
