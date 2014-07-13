package br.com.dicarte.seleniummantis.ejb.model.entidades;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Classe que representa a categoria do projeto, embora um usuario possa ter categorias, a categoria esta relacionado ao projeto e nao diretamente ao
 * usuario
 * 
 * @author eduardo.dicarte
 * 
 */

@Entity
@Table(name = "mantis_category_table", catalog = "bugtracker")
public class Categoria extends ModelImplem {

	private static final long	serialVersionUID	= 2125584802793910787L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private Integer				identificador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Projeto				projeto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UsuarioMantis		usuarioMantis;

	@Column(name = "name", nullable = false, length = 128)
	private String				nomeCategoria;

	/**
	 * Cor da Categoria do Projeto
	 */
	@Column(name = "status", nullable = false)
	private Integer				status;

	@OneToMany(mappedBy = "categoria")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<MantisBD>	collMantis;

	@Override
	public Integer getIdentificador() {
		return tratarValorZero(identificador);
	}

	@Override
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Collection<MantisBD> getCollMantis() {
		return collMantis;
	}

	public void setCollMantis(Collection<MantisBD> collMantis) {
		this.collMantis = collMantis;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public UsuarioMantis getUsuarioMantis() {
		return usuarioMantis;
	}

	public void setUsuarioMantis(UsuarioMantis usuarioMantis) {
		this.usuarioMantis = usuarioMantis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collMantis == null) ? 0 : collMantis.hashCode());
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result + ((nomeCategoria == null) ? 0 : nomeCategoria.hashCode());
		result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((usuarioMantis == null) ? 0 : usuarioMantis.hashCode());
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
		Categoria other = (Categoria) obj;
		if (collMantis == null) {
			if (other.collMantis != null)
				return false;
		} else if (!collMantis.equals(other.collMantis))
			return false;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		if (nomeCategoria == null) {
			if (other.nomeCategoria != null)
				return false;
		} else if (!nomeCategoria.equals(other.nomeCategoria))
			return false;
		if (projeto == null) {
			if (other.projeto != null)
				return false;
		} else if (!projeto.equals(other.projeto))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (usuarioMantis == null) {
			if (other.usuarioMantis != null)
				return false;
		} else if (!usuarioMantis.equals(other.usuarioMantis))
			return false;
		return true;
	}

	@Override
	public String[] getNomeColecoes() {
		return new String[] {"projeto", "usuarioMantis", "collMantis"};
	}
}
