package br.com.dicarte.seleniummantis.ejb.model.entidades;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe Responsavel por exibir o historico de erros do mantis
 * @author eduardo.dicarte
 *
 */

@Entity
@Table(name = "mantis_bug_history_table", catalog = "bugtracker")
public class Historico extends ModelImplem {

	private static final long serialVersionUID = 5114319535655449749L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer identificador;
		
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UsuarioMantis usuarioMantisHistorico;
		
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="bug_id")
	private MantisBD mantis;
		
	@Column(name = "field_name", nullable = false, length = 64)
	private String nomeCampo;
	
	@Column(name = "old_value", nullable = false)
	private String valorAntigo;
		
	@Column(name = "new_value", nullable = false)
	private String novoValor;
		
	@Column(name = "type", nullable = false)
	private Short tipo;
	
	@Column(name = "date_modified", nullable = false)
	private Integer dataAlteracao;

	public String getNomeCampo() {
		return nomeCampo;
	}

	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}

	public String getValorAntigo() {
		return valorAntigo;
	}

	public void setValorAntigo(String valorAntigo) {
		this.valorAntigo = valorAntigo;
	}

	public String getNovoValor() {
		return novoValor;
	}

	public void setNovoValor(String novoValor) {
		this.novoValor = novoValor;
	}

	public Short getTipo() {
		return tipo;
	}

	public void setTipo(Short tipo) {
		this.tipo = tipo;
	}

	public Integer getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Integer dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public MantisBD getMantis() {
		return mantis;
	}

	public void setMantis(MantisBD mantis) {
		this.mantis = mantis;
	}

	public UsuarioMantis getUsuarioMantisHistorico() {
		return usuarioMantisHistorico;
	}

	public void setUsuarioMantisHistorico(UsuarioMantis usuarioMantisHistorico) {
		this.usuarioMantisHistorico = usuarioMantisHistorico;
	}

	@Override
	public String[] getNomeColecoes() {
		return new String[]{"usuarioMantisHistorico","mantis"};
	}

	
	public Integer getIdentificador() {
		return identificador;
	}

	
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAlteracao == null) ? 0 : dataAlteracao.hashCode());
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result + ((mantis == null) ? 0 : mantis.hashCode());
		result = prime * result + ((nomeCampo == null) ? 0 : nomeCampo.hashCode());
		result = prime * result + ((novoValor == null) ? 0 : novoValor.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((usuarioMantisHistorico == null) ? 0 : usuarioMantisHistorico.hashCode());
		result = prime * result + ((valorAntigo == null) ? 0 : valorAntigo.hashCode());
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
		Historico other = (Historico) obj;
		if (dataAlteracao == null) {
			if (other.dataAlteracao != null)
				return false;
		} else if (!dataAlteracao.equals(other.dataAlteracao))
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
		if (nomeCampo == null) {
			if (other.nomeCampo != null)
				return false;
		} else if (!nomeCampo.equals(other.nomeCampo))
			return false;
		if (novoValor == null) {
			if (other.novoValor != null)
				return false;
		} else if (!novoValor.equals(other.novoValor))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (usuarioMantisHistorico == null) {
			if (other.usuarioMantisHistorico != null)
				return false;
		} else if (!usuarioMantisHistorico.equals(other.usuarioMantisHistorico))
			return false;
		if (valorAntigo == null) {
			if (other.valorAntigo != null)
				return false;
		} else if (!valorAntigo.equals(other.valorAntigo))
			return false;
		return true;
	}
}
