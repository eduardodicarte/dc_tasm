package br.com.dicarte.seleniummantis.ejb.model.entidades;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.capgemini.seleniummantis.ejb.enums.models.EnumFrequencia;
import com.capgemini.seleniummantis.ejb.enums.models.EnumGravidade;
import com.capgemini.seleniummantis.ejb.enums.models.EnumPrioridade;
import com.capgemini.seleniummantis.ejb.enums.models.EnumResolucao;
import com.capgemini.seleniummantis.ejb.enums.models.EnumStatusMantis;
import com.capgemini.seleniummantis.ejb.enums.models.EnumVisibilidade;


/**
 * Classe que representa o mantis
 * 
 * @author eduardodicarte
 * 
 */
@Entity
@Table(name = "mantis_bug_table", catalog = "bugtracker")
public class MantisBD extends ModelImplem {

	private static final long		serialVersionUID	= -2872354630644554415L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer					identificador;

	@Column(name = "version", nullable = false, length = 64)
	private String					versao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Projeto					projeto;

	@Column(name = "priority", columnDefinition = "smallint")
	private Integer					prioridadeBD;

	@Column(name = "severity", columnDefinition = "smallint")
	private Integer					gravidadeBD;

	@Column(name = "reproducibility", columnDefinition = "smallint")
	private Integer					frequenciaBD;

	@Column(name = "status", columnDefinition = "smallint")
	private Integer					statusBD;

	@Column(name = "resolution", columnDefinition = "smallint")
	private Integer					resolucaoBD;

	@Column(name = "view_state", columnDefinition = "smallint")
	private Integer					visibilidadeBD;

	@Transient
	@Enumerated
	private EnumPrioridade			prioridade;

	@Transient
	@Enumerated
	private EnumGravidade			gravidade;

	@Transient
	@Enumerated
	private EnumFrequencia			frequencia;

	@Transient
	@Enumerated
	private EnumStatusMantis		status;

	@Transient
	@Enumerated
	private EnumResolucao			resolucao;

	@Transient
	@Enumerated
	private EnumVisibilidade		visibilidade;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="bug_text_id")
	private Descricao				descricao;

	@Column(name = "os", nullable = false, length = 32)
	private String					sistemaOperacional;

	@Column(name = "os_build", nullable = false, length = 32)
	private String					versaoSistemaOperacional;

	@Column(name = "platform", nullable = false, length = 32)
	private String					plataforma;

	@Column(name = "fixed_in_version", nullable = false, length = 64)
	private String					corrigidoNaVersao;

	@Column(name = "build", nullable = false, length = 32)
	private String					build;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profile_id")
	private PerfilUsuario			perfil;

	@Column(name = "summary", nullable = false, length = 128)
	private String					resumo;

	@Column(name = "target_version", nullable = false, length = 64)
	private String					versaoEntregaPrevista;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Categoria				categoria;

	@Column(name = "date_submitted", nullable = false)
	private Integer					dataEnvio;

	@Column(name = "due_date", nullable = false)
	private Integer					dataVencimento;

	@Column(name = "last_updated", nullable = false)
	private Integer					dataUltimaAtualizacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reporter_id")
	private UsuarioMantis			usuarioMantisReporter;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "handler_id")
	private UsuarioMantis			usuarioMantisAtribuido;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "duplicate_id")
	private MantisBD					referenciaMantisDuplicado;

	@OneToMany(mappedBy = "referenciaMantisDuplicado")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<MantisBD>		collReferenciaMantisDuplicado;

	@OneToMany(mappedBy = "mantis")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<Anotacao>	collAnotacoes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "mantis")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<Evidencia>	collEvidencias;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "mantis")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<Historico>	collHistoricos;

	public MantisBD() {
		this.frequencia = EnumFrequencia.NENHUM_SELECIONADO;
		this.gravidade = EnumGravidade.NENHUM_SELECIONADO;
		this.prioridade = EnumPrioridade.NENHUM_SELECIONADO;
		this.resolucao = EnumResolucao.NENHUM_SELECIONADO;
		this.status = EnumStatusMantis.NENHUM_SELECIONADO;
		this.visibilidade = EnumVisibilidade.NENHUM_SELECIONADO;
	}

	@Override
	public Integer getIdentificador() {
		return identificador;
	}

	@Override
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Descricao getDescricao() {
		return descricao;
	}

	public void setDescricao(Descricao descricao) {
		this.descricao = descricao;
	}

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public String getVersaoSistemaOperacional() {
		return versaoSistemaOperacional;
	}

	public void setVersaoSistemaOperacional(String versaoSistemaOperacional) {
		this.versaoSistemaOperacional = versaoSistemaOperacional;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getCorrigidoNaVersao() {
		return corrigidoNaVersao;
	}

	public void setCorrigidoNaVersao(String corrigidoNaVersao) {
		this.corrigidoNaVersao = corrigidoNaVersao;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public PerfilUsuario getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilUsuario perfil) {
		this.perfil = perfil;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getVersaoEntregaPrevista() {
		return versaoEntregaPrevista;
	}

	public void setVersaoEntregaPrevista(String versaoEntregaPrevista) {
		this.versaoEntregaPrevista = versaoEntregaPrevista;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Integer dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Integer getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Integer dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Integer dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public UsuarioMantis getUsuarioMantisReporter() {
		return usuarioMantisReporter;
	}

	public void setUsuarioMantisReporter(UsuarioMantis usuarioMantisReporter) {
		this.usuarioMantisReporter = usuarioMantisReporter;
	}

	public UsuarioMantis getUsuarioMantisAtribuido() {
		return usuarioMantisAtribuido;
	}

	public void setUsuarioMantisAtribuido(UsuarioMantis usuarioMantisAtribuido) {
		this.usuarioMantisAtribuido = usuarioMantisAtribuido;
	}

	public MantisBD getReferenciaMantisDuplicado() {
		return referenciaMantisDuplicado;
	}

	public void setReferenciaMantisDuplicado(MantisBD referenciaMantisDuplicado) {
		this.referenciaMantisDuplicado = referenciaMantisDuplicado;
	}

	public Collection<MantisBD> getCollReferenciaMantisDuplicado() {
		return collReferenciaMantisDuplicado;
	}

	public void setCollReferenciaMantisDuplicado(Collection<MantisBD> collReferenciaMantisDuplicado) {
		this.collReferenciaMantisDuplicado = collReferenciaMantisDuplicado;
	}

	public Collection<Anotacao> getCollAnotacoes() {
		return collAnotacoes;
	}

	public void setCollAnotacoes(Collection<Anotacao> collAnotacoes) {
		this.collAnotacoes = collAnotacoes;
	}

	public Collection<Evidencia> getCollEvidencias() {
		return collEvidencias;
	}

	public void setCollEvidencias(Collection<Evidencia> collEvidencias) {
		this.collEvidencias = collEvidencias;
	}

	public Collection<Historico> getCollHistoricos() {
		return collHistoricos;
	}

	public void setCollHistoricos(Collection<Historico> collHistoricos) {
		this.collHistoricos = collHistoricos;
	}

	Integer getPrioridadeBD() {
		return prioridadeBD;
	}

	void setPrioridadeBD(Integer prioridadeBD) {
		this.prioridadeBD = prioridadeBD;
	}

	Integer getGravidadeBD() {
		return gravidadeBD;
	}

	void setGravidadeBD(Integer gravidadeBD) {
		this.gravidadeBD = gravidadeBD;
	}

	Integer getFrequenciaBD() {
		return frequenciaBD;
	}

	void setFrequenciaBD(Integer frequenciaBD) {
		this.frequenciaBD = frequenciaBD;
	}

	Integer getStatusBD() {
		return statusBD;
	}

	void setStatusBD(Integer statusBD) {
		this.statusBD = statusBD;
	}

	Integer getResolucaoBD() {
		return resolucaoBD;
	}

	void setResolucaoBD(Integer resolucaoBD) {
		this.resolucaoBD = resolucaoBD;
	}

	Integer getVisibilidadeBD() {
		return visibilidadeBD;
	}

	void setVisibilidadeBD(Integer visibilidadeBD) {
		this.visibilidadeBD = visibilidadeBD;
	}

	public EnumPrioridade getPrioridade() {
		this.prioridade = (EnumPrioridade) converterValorParaEnum(prioridade, prioridadeBD);
		return prioridade;
	}

	public void setPrioridade(EnumPrioridade prioridade) {
		setPrioridadeBD(converterEnumParaValor(prioridade));
		this.prioridade = prioridade;
	}

	public EnumGravidade getGravidade() {
		this.gravidade = (EnumGravidade) converterValorParaEnum(gravidade, gravidadeBD);
		return gravidade;
	}

	public void setGravidade(EnumGravidade gravidade) {
		setGravidadeBD(converterEnumParaValor(gravidade));
		this.gravidade = gravidade;
	}

	public EnumFrequencia getFrequencia() {
		this.frequencia = (EnumFrequencia) converterValorParaEnum(frequencia, frequenciaBD);
		return frequencia;
	}

	public void setFrequencia(EnumFrequencia frequencia) {
		setFrequenciaBD(converterEnumParaValor(frequencia));
		this.frequencia = frequencia;
	}

	public EnumStatusMantis getStatus() {
		this.status = (EnumStatusMantis) converterValorParaEnum(status, statusBD);
		return status;
	}

	public void setStatus(EnumStatusMantis status) {
		setStatusBD(converterEnumParaValor(status));
		this.status = status;
	}

	public EnumResolucao getResolucao() {
		this.resolucao = (EnumResolucao) converterValorParaEnum(resolucao, resolucaoBD);
		return resolucao;
	}

	public void setResolucao(EnumResolucao resolucao) {
		setResolucaoBD(converterEnumParaValor(resolucao));
		this.resolucao = resolucao;
	}

	public EnumVisibilidade getVisibilidade() {
		this.visibilidade = (EnumVisibilidade) converterValorParaEnum(visibilidade, visibilidadeBD);
		return visibilidade;
	}

	public void setVisibilidade(EnumVisibilidade visibilidade) {
		setVisibilidadeBD(converterEnumParaValor(visibilidade));
		this.visibilidade = visibilidade;
	}

	@Override
	public String[] getNomeColecoes() {
		return new String[] {"projeto", "descricao", "perfil", "categoria", "usuarioMantisReporter", "usuarioMantisAtribuido",
				"referenciaMantisDuplicado", "collReferenciaMantisDuplicado", "collAnotacoes", "collEvidencias", "collHistoricos"};
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((build == null) ? 0 : build.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((collAnotacoes == null) ? 0 : collAnotacoes.hashCode());
		result = prime * result + ((collEvidencias == null) ? 0 : collEvidencias.hashCode());
		result = prime * result + ((collHistoricos == null) ? 0 : collHistoricos.hashCode());
		result = prime * result + ((collReferenciaMantisDuplicado == null) ? 0 : collReferenciaMantisDuplicado.hashCode());
		result = prime * result + ((corrigidoNaVersao == null) ? 0 : corrigidoNaVersao.hashCode());
		result = prime * result + ((dataEnvio == null) ? 0 : dataEnvio.hashCode());
		result = prime * result + ((dataUltimaAtualizacao == null) ? 0 : dataUltimaAtualizacao.hashCode());
		result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((frequenciaBD == null) ? 0 : frequenciaBD.hashCode());
		result = prime * result + ((gravidadeBD == null) ? 0 : gravidadeBD.hashCode());
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		result = prime * result + ((prioridadeBD == null) ? 0 : prioridadeBD.hashCode());
		result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
		result = prime * result + ((referenciaMantisDuplicado == null) ? 0 : referenciaMantisDuplicado.hashCode());
		result = prime * result + ((resolucaoBD == null) ? 0 : resolucaoBD.hashCode());
		result = prime * result + ((resumo == null) ? 0 : resumo.hashCode());
		result = prime * result + ((sistemaOperacional == null) ? 0 : sistemaOperacional.hashCode());
		result = prime * result + ((statusBD == null) ? 0 : statusBD.hashCode());
		result = prime * result + ((usuarioMantisAtribuido == null) ? 0 : usuarioMantisAtribuido.hashCode());
		result = prime * result + ((usuarioMantisReporter == null) ? 0 : usuarioMantisReporter.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
		result = prime * result + ((versaoEntregaPrevista == null) ? 0 : versaoEntregaPrevista.hashCode());
		result = prime * result + ((versaoSistemaOperacional == null) ? 0 : versaoSistemaOperacional.hashCode());
		result = prime * result + ((visibilidadeBD == null) ? 0 : visibilidadeBD.hashCode());
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
		MantisBD other = (MantisBD) obj;
		if (build == null) {
			if (other.build != null)
				return false;
		} else if (!build.equals(other.build))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (collAnotacoes == null) {
			if (other.collAnotacoes != null)
				return false;
		} else if (!collAnotacoes.equals(other.collAnotacoes))
			return false;
		if (collEvidencias == null) {
			if (other.collEvidencias != null)
				return false;
		} else if (!collEvidencias.equals(other.collEvidencias))
			return false;
		if (collHistoricos == null) {
			if (other.collHistoricos != null)
				return false;
		} else if (!collHistoricos.equals(other.collHistoricos))
			return false;
		if (collReferenciaMantisDuplicado == null) {
			if (other.collReferenciaMantisDuplicado != null)
				return false;
		} else if (!collReferenciaMantisDuplicado.equals(other.collReferenciaMantisDuplicado))
			return false;
		if (corrigidoNaVersao == null) {
			if (other.corrigidoNaVersao != null)
				return false;
		} else if (!corrigidoNaVersao.equals(other.corrigidoNaVersao))
			return false;
		if (dataEnvio == null) {
			if (other.dataEnvio != null)
				return false;
		} else if (!dataEnvio.equals(other.dataEnvio))
			return false;
		if (dataUltimaAtualizacao == null) {
			if (other.dataUltimaAtualizacao != null)
				return false;
		} else if (!dataUltimaAtualizacao.equals(other.dataUltimaAtualizacao))
			return false;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (frequenciaBD == null) {
			if (other.frequenciaBD != null)
				return false;
		} else if (!frequenciaBD.equals(other.frequenciaBD))
			return false;
		if (gravidadeBD == null) {
			if (other.gravidadeBD != null)
				return false;
		} else if (!gravidadeBD.equals(other.gravidadeBD))
			return false;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		if (prioridadeBD == null) {
			if (other.prioridadeBD != null)
				return false;
		} else if (!prioridadeBD.equals(other.prioridadeBD))
			return false;
		if (projeto == null) {
			if (other.projeto != null)
				return false;
		} else if (!projeto.equals(other.projeto))
			return false;
		if (referenciaMantisDuplicado == null) {
			if (other.referenciaMantisDuplicado != null)
				return false;
		} else if (!referenciaMantisDuplicado.equals(other.referenciaMantisDuplicado))
			return false;
		if (resolucaoBD == null) {
			if (other.resolucaoBD != null)
				return false;
		} else if (!resolucaoBD.equals(other.resolucaoBD))
			return false;
		if (resumo == null) {
			if (other.resumo != null)
				return false;
		} else if (!resumo.equals(other.resumo))
			return false;
		if (sistemaOperacional == null) {
			if (other.sistemaOperacional != null)
				return false;
		} else if (!sistemaOperacional.equals(other.sistemaOperacional))
			return false;
		if (statusBD == null) {
			if (other.statusBD != null)
				return false;
		} else if (!statusBD.equals(other.statusBD))
			return false;
		if (usuarioMantisAtribuido == null) {
			if (other.usuarioMantisAtribuido != null)
				return false;
		} else if (!usuarioMantisAtribuido.equals(other.usuarioMantisAtribuido))
			return false;
		if (usuarioMantisReporter == null) {
			if (other.usuarioMantisReporter != null)
				return false;
		} else if (!usuarioMantisReporter.equals(other.usuarioMantisReporter))
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		if (versaoEntregaPrevista == null) {
			if (other.versaoEntregaPrevista != null)
				return false;
		} else if (!versaoEntregaPrevista.equals(other.versaoEntregaPrevista))
			return false;
		if (versaoSistemaOperacional == null) {
			if (other.versaoSistemaOperacional != null)
				return false;
		} else if (!versaoSistemaOperacional.equals(other.versaoSistemaOperacional))
			return false;
		if (visibilidadeBD == null) {
			if (other.visibilidadeBD != null)
				return false;
		} else if (!visibilidadeBD.equals(other.visibilidadeBD))
			return false;
		return true;
	}
}
