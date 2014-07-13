package br.com.dicarte.seleniummantis.ejb.model.entidades;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.capgemini.seleniummantis.ejb.enums.models.EnumFaseProjeto;
import com.capgemini.seleniummantis.ejb.enums.models.EnumNivelAcesso;
import com.capgemini.seleniummantis.ejb.enums.models.EnumStatusAtivoInativo;
import com.capgemini.seleniummantis.ejb.enums.models.EnumVisibilidade;


/**
 * Classe responsavel em representar o model de Projeto
 * @author eduardo.dicarte
 *
 */
@Entity
@Table(name = "mantis_project_table", catalog = "bugtracker", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Projeto extends ModelImplem {

	private static final long serialVersionUID = 2406195499746282935L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private Integer identificador;
		
	@Column(name = "name", unique = true, nullable = false, length = 128)
	private String nome;
	
	@Column(name = "status", columnDefinition="smallint")
	private Integer faseProjetoBD;
	
	@Column(name = "enabled",columnDefinition="tinyint")
	private Integer statusProjetoBD;
	
	@Column(name = "view_state", columnDefinition="smallint")
	private Integer visibilidadeBD;
	
	@Column(name = "access_min", columnDefinition="smallint")
	private Integer nivelAcessoBD;
	
	@Transient
	@Enumerated
	private EnumFaseProjeto faseProjeto;
	
	@Transient
	@Enumerated
	private EnumStatusAtivoInativo statusProjeto;
	
	@Transient
	@Enumerated
	private EnumVisibilidade visibilidade;
	
	@Transient
	@Enumerated
	private EnumNivelAcesso nivelAcesso;
		
	@Column(name = "file_path", nullable = false, length = 250)
	private String localizacaoArquivo;
	
	@Column(name = "description", columnDefinition="longtext")
	private String descricao;
	
	@OneToMany(mappedBy="projeto")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<Categoria> categoria;
	
	@OneToMany(mappedBy="projeto")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<MantisBD> collMantis;
	
	/**
	 * Caso o projeto tenha alguma heranca.
	 */
	@Column(name = "inherit_global", nullable = false)
	private Integer herancasGlobais;
	
	public Projeto() {
		this.faseProjeto = EnumFaseProjeto.NENHUM_SELECIONADO;
		this.nivelAcesso = EnumNivelAcesso.NENHUM_SELECIONADO;
		this.statusProjeto = EnumStatusAtivoInativo.NENHUM_SELECIONADO;
		this.visibilidade = EnumVisibilidade.NENHUM_SELECIONADO;
	}
	

	@Override
	public Integer getIdentificador() {
		return tratarValorZero(identificador);
	}

	@Override
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacaoArquivo() {
		return localizacaoArquivo;
	}

	public void setLocalizacaoArquivo(String localizacaoArquivo) {
		this.localizacaoArquivo = localizacaoArquivo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getHerancasGlobais() {
		return herancasGlobais;
	}

	public void setHerancasGlobais(Integer herancasGlobais) {
		this.herancasGlobais = herancasGlobais;
	}

	public Collection<MantisBD> getCollMantis() {
		return collMantis;
	}

	public void setCollMantis(Collection<MantisBD> collMantis) {
		this.collMantis = collMantis;
	}

	public Collection<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(Collection<Categoria> categoria) {
		this.categoria = categoria;
	}

	public EnumFaseProjeto getFaseProjeto() {
		this.faseProjeto = (EnumFaseProjeto) converterValorParaEnum(faseProjeto, faseProjetoBD);
		return faseProjeto;
	}

	public void setFaseProjeto(EnumFaseProjeto faseProjeto) {
		setFaseProjetoBD(converterEnumParaValor(faseProjeto));
		this.faseProjeto = faseProjeto;
	}

	public EnumStatusAtivoInativo getStatusProjeto() {
		this.statusProjeto = (EnumStatusAtivoInativo) converterValorParaEnum(statusProjeto, statusProjetoBD);
		return statusProjeto;
	}

	public void setStatusProjeto(EnumStatusAtivoInativo statusProjeto) {
		setStatusProjetoBD(converterEnumParaValor(statusProjeto));
		this.statusProjeto = statusProjeto;
	}

	public EnumVisibilidade getVisibilidade() {
		this.visibilidade = (EnumVisibilidade) converterValorParaEnum(visibilidade, visibilidadeBD);
		return visibilidade;
	}

	public void setVisibilidade(EnumVisibilidade visibilidade) {
		setVisibilidadeBD(converterEnumParaValor(visibilidade));
		this.visibilidade = visibilidade;
	}

	public EnumNivelAcesso getNivelAcesso() {
		this.nivelAcesso = (EnumNivelAcesso) converterValorParaEnum(nivelAcesso, nivelAcessoBD);
		return nivelAcesso;
	}

	public void setNivelAcesso(EnumNivelAcesso nivelAcesso) {
		setNivelAcessoBD(converterEnumParaValor(nivelAcesso));
		this.nivelAcesso = nivelAcesso;
	}

	Integer getFaseProjetoBD() {
		return faseProjetoBD;
	}

	void setFaseProjetoBD(Integer faseProjetoBD) {
		this.faseProjetoBD = faseProjetoBD;
	}

	Integer getStatusProjetoBD() {
		return statusProjetoBD;
	}

	void setStatusProjetoBD(Integer statusProjetoBD) {
		this.statusProjetoBD = statusProjetoBD;
	}

	Integer getVisibilidadeBD() {
		return visibilidadeBD;
	}

	void setVisibilidadeBD(Integer visibilidadeBD) {
		this.visibilidadeBD = visibilidadeBD;
	}

	Integer getNivelAcessoBD() {
		return nivelAcessoBD;
	}

	void setNivelAcessoBD(Integer nivelAcessoBD) {
		this.nivelAcessoBD = nivelAcessoBD;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result
				+ ((collMantis == null) ? 0 : collMantis.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((faseProjeto == null) ? 0 : faseProjeto.hashCode());
		result = prime * result
				+ ((faseProjetoBD == null) ? 0 : faseProjetoBD.hashCode());
		result = prime * result
				+ ((herancasGlobais == null) ? 0 : herancasGlobais.hashCode());
		result = prime * result
				+ ((identificador == null) ? 0 : identificador.hashCode());
		result = prime
				* result
				+ ((localizacaoArquivo == null) ? 0 : localizacaoArquivo
						.hashCode());
		result = prime * result
				+ ((nivelAcesso == null) ? 0 : nivelAcesso.hashCode());
		result = prime * result
				+ ((nivelAcessoBD == null) ? 0 : nivelAcessoBD.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((statusProjeto == null) ? 0 : statusProjeto.hashCode());
		result = prime * result
				+ ((statusProjetoBD == null) ? 0 : statusProjetoBD.hashCode());
		result = prime * result
				+ ((visibilidade == null) ? 0 : visibilidade.hashCode());
		result = prime * result
				+ ((visibilidadeBD == null) ? 0 : visibilidadeBD.hashCode());
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
		Projeto other = (Projeto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
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
		if (faseProjeto != other.faseProjeto)
			return false;
		if (faseProjetoBD == null) {
			if (other.faseProjetoBD != null)
				return false;
		} else if (!faseProjetoBD.equals(other.faseProjetoBD))
			return false;
		if (herancasGlobais == null) {
			if (other.herancasGlobais != null)
				return false;
		} else if (!herancasGlobais.equals(other.herancasGlobais))
			return false;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		if (localizacaoArquivo == null) {
			if (other.localizacaoArquivo != null)
				return false;
		} else if (!localizacaoArquivo.equals(other.localizacaoArquivo))
			return false;
		if (nivelAcesso != other.nivelAcesso)
			return false;
		if (nivelAcessoBD == null) {
			if (other.nivelAcessoBD != null)
				return false;
		} else if (!nivelAcessoBD.equals(other.nivelAcessoBD))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (statusProjeto != other.statusProjeto)
			return false;
		if (statusProjetoBD == null) {
			if (other.statusProjetoBD != null)
				return false;
		} else if (!statusProjetoBD.equals(other.statusProjetoBD))
			return false;
		if (visibilidade != other.visibilidade)
			return false;
		if (visibilidadeBD == null) {
			if (other.visibilidadeBD != null)
				return false;
		} else if (!visibilidadeBD.equals(other.visibilidadeBD))
			return false;
		return true;
	}

	@Override
	public String[] getNomeColecoes() {
		return new String[]{"categoria","collMantis"};
	}
}