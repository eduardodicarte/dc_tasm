package br.com.dicarte.seleniummantis.ejb.model.entidades;

/**
 * Classe responsavel em manter o perfil do usuario no mantis
 * @author eduardo.dicarte
 */

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Classe para representar a tabela de perfis de usu�rios do mantis
 * @author eduardo.dicarte
 *
 */
@Entity
@Table(name = "mantis_user_profile_table", catalog = "bugtracker")
public class PerfilUsuario extends ModelImplem {

	private static final long serialVersionUID = -5170929346101810461L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true)
	private Integer identificador;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UsuarioMantis usuario;

	@Column(name = "platform", nullable = false, length = 32)
	private String plataforma;

	@Column(name = "os", nullable = false, length = 32)
	private String sistemaOperacional;

	@Column(name = "os_build", nullable = false, length = 32)
	private String sistemaOperacionalBuild;

	@Column(name = "description", columnDefinition="longtext")
	private String descricao;
	
	@OneToMany(mappedBy="perfil")
	@LazyCollection(LazyCollectionOption.TRUE)
	Collection<MantisBD> collMantis;

	@Override
	public Integer getIdentificador() {
		return tratarValorZero(identificador);
	}

	@Override
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public String getSistemaOperacionalBuild() {
		return sistemaOperacionalBuild;
	}

	public void setSistemaOperacionalBuild(String sistemaOperacionalBuild) {
		this.sistemaOperacionalBuild = sistemaOperacionalBuild;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<MantisBD> getCollMantis() {
		return collMantis;
	}

	public void setCollMantis(Collection<MantisBD> collMantis) {
		this.collMantis = collMantis;
	}

	public UsuarioMantis getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioMantis usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((collMantis == null) ? 0 : collMantis.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result
				+ ((plataforma == null) ? 0 : plataforma.hashCode());
		result = prime
				* result
				+ ((sistemaOperacional == null) ? 0 : sistemaOperacional
						.hashCode());
		result = prime
				* result
				+ ((sistemaOperacionalBuild == null) ? 0
						: sistemaOperacionalBuild.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		PerfilUsuario other = (PerfilUsuario) obj;
		if (collMantis == null) {
			if (other.collMantis != null)
				return false;
		} else if (!collMantis.equals(other.collMantis))
			return false;
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
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		if (sistemaOperacional == null) {
			if (other.sistemaOperacional != null)
				return false;
		} else if (!sistemaOperacional.equals(other.sistemaOperacional))
			return false;
		if (sistemaOperacionalBuild == null) {
			if (other.sistemaOperacionalBuild != null)
				return false;
		} else if (!sistemaOperacionalBuild
				.equals(other.sistemaOperacionalBuild))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String[] getNomeColecoes() {
		return new String[]{"usuario","collMantis"};
	}
}