package br.com.dicarte.seleniummantis.ejb.model.entidades;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.capgemini.seleniummantis.ejb.enums.models.EnumVisibilidade;

/**
 * Classe que representa o conjunto das anotacoes do mantis, cada anotacao e referenciada pela classe <class>DescricaoAnotacaoMantis</class>
 * 
 * @author eduardo.dicarte
 * 
 */

@Entity
@Table(name = "mantis_bugnote_table", catalog = "bugtracker")
public class Anotacao extends ModelImplem {

	private static final long	serialVersionUID	= -2489783840976692796L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private Integer				identificador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bug_id")
	private MantisBD				mantis;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reporter_id")
	private UsuarioMantis		usuarioMantisReporterAnotacao;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "bugnote_text_id")
	private DescricaoAnotacao	descricaoAnotacao;

	@Column(name = "note_type")
	private Integer				tipoAnotacao;

	@Column(name = "view_state", columnDefinition = "smallint")
	private Integer				visibilidadeBD;

	@Transient
	@Enumerated
	private EnumVisibilidade	visibilidade;

	@Column(name = "note_attr", length = 250)
	private String				atributoAnotacao;

	@Column(name = "time_tracking", nullable = false)
	private Integer				tempoRastreamento;

	public Integer getTempoRastreamento() {
		return tempoRastreamento;
	}

	public void setTempoRastreamento(Integer tempoRastreamento) {
		this.tempoRastreamento = tempoRastreamento;
	}

	public Integer getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Integer ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Integer getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Integer dataEnvio) {
		this.dataEnvio = dataEnvio;
	}


	@Column(name = "last_modified", nullable = false)
	private Integer				ultimaAlteracao;

	@Column(name = "date_submitted", nullable = false)
	private Integer				dataEnvio;

	public Anotacao() {
		if (visibilidade == null) {
			visibilidade = EnumVisibilidade.NENHUM_SELECIONADO;
		}
	}

	@Override
	public Integer getIdentificador() {
		return tratarValorZero(identificador);
	}

	@Override
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public Integer getTipoAnotacao() {
		return tipoAnotacao;
	}

	public void setTipoAnotacao(Integer tipoAnotacao) {
		this.tipoAnotacao = tipoAnotacao;
	}

	public EnumVisibilidade getVisibilidade() {
		this.visibilidade = (EnumVisibilidade) converterValorParaEnum(visibilidade, visibilidadeBD);
		return visibilidade;
	}

	public void setVisibilidade(EnumVisibilidade visibilidade) {
		setVisibilidadeBD(converterEnumParaValor(visibilidade));
		this.visibilidade = visibilidade;
	}

	public String getAtributoAnotacao() {
		return atributoAnotacao;
	}

	public void setAtributoAnotacao(String atributoAnotacao) {
		this.atributoAnotacao = atributoAnotacao;
	}

	public MantisBD getMantis() {
		return mantis;
	}

	public void setMantis(MantisBD mantis) {
		this.mantis = mantis;
	}

	public void setUsuarioMantisReporterAnotacao(UsuarioMantis usuarioMantisReporterAnotacao) {
		this.usuarioMantisReporterAnotacao = usuarioMantisReporterAnotacao;
	}

	public DescricaoAnotacao getDescricaoAnotacao() {
		return descricaoAnotacao;
	}

	public void setDescricaoAnotacao(DescricaoAnotacao descricaoAnotacao) {
		this.descricaoAnotacao = descricaoAnotacao;
	}

	Integer getVisibilidadeBD() {
		return visibilidadeBD;
	}

	void setVisibilidadeBD(Integer visibilidadeBD) {
		this.visibilidadeBD = visibilidadeBD;
	}

	@Override
	public String[] getNomeColecoes() {
		return new String[] {"mantis", "usuarioMantisReporterAnotacao", "descricaoAnotacao"};
	}

	
	public UsuarioMantis getUsuarioMantisReporterAnotacao() {
		return usuarioMantisReporterAnotacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((atributoAnotacao == null) ? 0 : atributoAnotacao.hashCode());
		result = prime * result
				+ ((dataEnvio == null) ? 0 : dataEnvio.hashCode());
		result = prime
				* result
				+ ((descricaoAnotacao == null) ? 0 : descricaoAnotacao
						.hashCode());
		result = prime * result
				+ ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result + ((mantis == null) ? 0 : mantis.hashCode());
		result = prime
				* result
				+ ((tempoRastreamento == null) ? 0 : tempoRastreamento
						.hashCode());
		result = prime * result
				+ ((tipoAnotacao == null) ? 0 : tipoAnotacao.hashCode());
		result = prime * result
				+ ((ultimaAlteracao == null) ? 0 : ultimaAlteracao.hashCode());
		result = prime
				* result
				+ ((usuarioMantisReporterAnotacao == null) ? 0
						: usuarioMantisReporterAnotacao.hashCode());
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
		Anotacao other = (Anotacao) obj;
		if (atributoAnotacao == null) {
			if (other.atributoAnotacao != null)
				return false;
		} else if (!atributoAnotacao.equals(other.atributoAnotacao))
			return false;
		if (dataEnvio == null) {
			if (other.dataEnvio != null)
				return false;
		} else if (!dataEnvio.equals(other.dataEnvio))
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
		if (mantis == null) {
			if (other.mantis != null)
				return false;
		} else if (!mantis.equals(other.mantis))
			return false;
		if (tempoRastreamento == null) {
			if (other.tempoRastreamento != null)
				return false;
		} else if (!tempoRastreamento.equals(other.tempoRastreamento))
			return false;
		if (tipoAnotacao == null) {
			if (other.tipoAnotacao != null)
				return false;
		} else if (!tipoAnotacao.equals(other.tipoAnotacao))
			return false;
		if (ultimaAlteracao == null) {
			if (other.ultimaAlteracao != null)
				return false;
		} else if (!ultimaAlteracao.equals(other.ultimaAlteracao))
			return false;
		if (usuarioMantisReporterAnotacao == null) {
			if (other.usuarioMantisReporterAnotacao != null)
				return false;
		} else if (!usuarioMantisReporterAnotacao
				.equals(other.usuarioMantisReporterAnotacao))
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
}
