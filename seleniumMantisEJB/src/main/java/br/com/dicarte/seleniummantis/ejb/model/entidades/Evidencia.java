package br.com.dicarte.seleniummantis.ejb.model.entidades;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.File;

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
 * 
 * @author eduardo.dicarte 
 * Classe Responsavel pelo gerenciamento de evidencias dos
 *         mantis
 * 
 */

@Entity
@Table(name = "mantis_bug_file_table", catalog = "bugtracker")
public class Evidencia extends ModelImplem {

	private static final long serialVersionUID = 863399476980927166L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer identificador;

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="bug_id")
	private MantisBD mantis;

	@Column(name = "title", nullable = false, length = 250)
	private String tituloEvidencia;

	@Column(name = "description", nullable = false, length = 250)
	private String descricaoEvidencia;

	@Column(name = "diskfile", nullable = false, length = 250)
	private String diskfile;

	@Column(name = "filename", nullable = false, length = 250)
	private String nomeArquivo;

	@Column(name = "folder", nullable = false, length = 250)
	private String nomePasta;

	@Column(name = "filesize", nullable = false)
	private Integer tamanhoArquivo;

	@Column(name = "file_type", nullable = false, length = 250)
	private String tipoArquivo;

	@Column(name = "content",columnDefinition="longblob")
	private File arquivo;

	@Column(name = "date_added", nullable = false)
	private Integer dataCriacao;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private UsuarioMantis usuarioMantisEvidencia;

	@Override
	public Integer getIdentificador() {
		return tratarValorZero(identificador);
	}

	@Override
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getTituloEvidencia() {
		return tituloEvidencia;
	}

	public void setTituloEvidencia(String tituloEvidencia) {
		this.tituloEvidencia = tituloEvidencia;
	}

	public String getDescricaoEvidencia() {
		return descricaoEvidencia;
	}

	public void setDescricaoEvidencia(String descricaoEvidencia) {
		this.descricaoEvidencia = descricaoEvidencia;
	}

	public String getDiskfile() {
		return diskfile;
	}

	public void setDiskfile(String diskfile) {
		this.diskfile = diskfile;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getNomePasta() {
		return nomePasta;
	}

	public void setNomePasta(String nomePasta) {
		this.nomePasta = nomePasta;
	}

	public Integer getTamanhoArquivo() {
		return tamanhoArquivo;
	}

	public void setTamanhoArquivo(Integer tamanhoArquivo) {
		this.tamanhoArquivo = tamanhoArquivo;
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public Integer getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Integer dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public MantisBD getMantis() {
		return mantis;
	}

	public void setMantis(MantisBD mantis) {
		this.mantis = mantis;
	}

	public UsuarioMantis getUsuarioMantisEvidencia() {
		return usuarioMantisEvidencia;
	}

	public void setUsuarioMantisEvidencia(UsuarioMantis usuarioMantisEvidencia) {
		this.usuarioMantisEvidencia = usuarioMantisEvidencia;
	}

	public File getArquivo() {
		return arquivo;
	}

	public void setArquivo(File arquivo) {
		this.arquivo = arquivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arquivo == null) ? 0 : arquivo.hashCode());
		result = prime * result
				+ ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime
				* result
				+ ((descricaoEvidencia == null) ? 0 : descricaoEvidencia
						.hashCode());
		result = prime * result
				+ ((diskfile == null) ? 0 : diskfile.hashCode());
		result = prime * result
				+ ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result + ((mantis == null) ? 0 : mantis.hashCode());
		result = prime * result
				+ ((nomeArquivo == null) ? 0 : nomeArquivo.hashCode());
		result = prime * result
				+ ((nomePasta == null) ? 0 : nomePasta.hashCode());
		result = prime * result
				+ ((tamanhoArquivo == null) ? 0 : tamanhoArquivo.hashCode());
		result = prime * result
				+ ((tipoArquivo == null) ? 0 : tipoArquivo.hashCode());
		result = prime * result
				+ ((tituloEvidencia == null) ? 0 : tituloEvidencia.hashCode());
		result = prime
				* result
				+ ((usuarioMantisEvidencia == null) ? 0
						: usuarioMantisEvidencia.hashCode());
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
		Evidencia other = (Evidencia) obj;
		if (arquivo == null) {
			if (other.arquivo != null)
				return false;
		} else if (!arquivo.equals(other.arquivo))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (descricaoEvidencia == null) {
			if (other.descricaoEvidencia != null)
				return false;
		} else if (!descricaoEvidencia.equals(other.descricaoEvidencia))
			return false;
		if (diskfile == null) {
			if (other.diskfile != null)
				return false;
		} else if (!diskfile.equals(other.diskfile))
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
		if (nomeArquivo == null) {
			if (other.nomeArquivo != null)
				return false;
		} else if (!nomeArquivo.equals(other.nomeArquivo))
			return false;
		if (nomePasta == null) {
			if (other.nomePasta != null)
				return false;
		} else if (!nomePasta.equals(other.nomePasta))
			return false;
		if (tamanhoArquivo == null) {
			if (other.tamanhoArquivo != null)
				return false;
		} else if (!tamanhoArquivo.equals(other.tamanhoArquivo))
			return false;
		if (tipoArquivo == null) {
			if (other.tipoArquivo != null)
				return false;
		} else if (!tipoArquivo.equals(other.tipoArquivo))
			return false;
		if (tituloEvidencia == null) {
			if (other.tituloEvidencia != null)
				return false;
		} else if (!tituloEvidencia.equals(other.tituloEvidencia))
			return false;
		if (usuarioMantisEvidencia == null) {
			if (other.usuarioMantisEvidencia != null)
				return false;
		} else if (!usuarioMantisEvidencia.equals(other.usuarioMantisEvidencia))
			return false;
		return true;
	}

	@Override
	public String[] getNomeColecoes() {
		return new String[]{"mantis","usuarioMantisEvidencia"};
	}
}
