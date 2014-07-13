package br.com.dicarte.seleniummantis.ejb.model.entidades;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;

import com.capgemini.seleniummantis.ejb.enums.models.EnumFrequencia;
import com.capgemini.seleniummantis.ejb.enums.models.EnumGravidade;
import com.capgemini.seleniummantis.ejb.enums.models.EnumPrioridade;

/**
 * Classe adapter para facilitar a abertura do mantis, deve ser utilizada em conjunto com a fachada MantisFacade
 * 
 * @author eduardodicarte
 * 
 */
public class Mantis implements Serializable {

	private static final long	serialVersionUID	= 8798539529033537169L;
	private Integer				identificador;
	private String				descricao;
	private String				passosParaReproduzir;
	private String				informacoesAdicionais;
	private Collection<String>	anotacoes;
	private Collection<File>	evidencias;
	private EnumFrequencia		enumFrequencia;
	private EnumGravidade		enumGravidade;
	private EnumPrioridade		enumPrioridade;
	private String				resumo;
	private String				projeto;
	private String				categoriaMantis;
	private String				build;

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<String> getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(Collection<String> anotacoes) {
		this.anotacoes = anotacoes;
	}

	public Collection<File> getEvidencias() {
		return evidencias;
	}

	public void setEvidencias(Collection<File> evidencias) {
		this.evidencias = evidencias;
	}

	public EnumFrequencia getEnumFrequencia() {
		return enumFrequencia;
	}

	public void setEnumFrequencia(EnumFrequencia enumFrequencia) {
		this.enumFrequencia = enumFrequencia;
	}

	public EnumGravidade getEnumGravidade() {
		return enumGravidade;
	}

	public void setEnumGravidade(EnumGravidade enumGravidade) {
		this.enumGravidade = enumGravidade;
	}

	public EnumPrioridade getEnumPrioridade() {
		return enumPrioridade;
	}

	public void setEnumPrioridade(EnumPrioridade enumPrioridade) {
		this.enumPrioridade = enumPrioridade;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
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

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public String getCategoriaMantis() {
		return categoriaMantis;
	}

	public void setCategoriaMantis(String categoriaMantis) {
		this.categoriaMantis = categoriaMantis;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anotacoes == null) ? 0 : anotacoes.hashCode());
		result = prime * result + ((build == null) ? 0 : build.hashCode());
		result = prime * result + ((categoriaMantis == null) ? 0 : categoriaMantis.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((enumFrequencia == null) ? 0 : enumFrequencia.hashCode());
		result = prime * result + ((enumGravidade == null) ? 0 : enumGravidade.hashCode());
		result = prime * result + ((enumPrioridade == null) ? 0 : enumPrioridade.hashCode());
		result = prime * result + ((evidencias == null) ? 0 : evidencias.hashCode());
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result + ((informacoesAdicionais == null) ? 0 : informacoesAdicionais.hashCode());
		result = prime * result + ((passosParaReproduzir == null) ? 0 : passosParaReproduzir.hashCode());
		result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
		result = prime * result + ((resumo == null) ? 0 : resumo.hashCode());
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
		Mantis other = (Mantis) obj;
		if (anotacoes == null) {
			if (other.anotacoes != null)
				return false;
		} else if (!anotacoes.equals(other.anotacoes))
			return false;
		if (build == null) {
			if (other.build != null)
				return false;
		} else if (!build.equals(other.build))
			return false;
		if (categoriaMantis == null) {
			if (other.categoriaMantis != null)
				return false;
		} else if (!categoriaMantis.equals(other.categoriaMantis))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (enumFrequencia != other.enumFrequencia)
			return false;
		if (enumGravidade != other.enumGravidade)
			return false;
		if (enumPrioridade != other.enumPrioridade)
			return false;
		if (evidencias == null) {
			if (other.evidencias != null)
				return false;
		} else if (!evidencias.equals(other.evidencias))
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
		if (projeto == null) {
			if (other.projeto != null)
				return false;
		} else if (!projeto.equals(other.projeto))
			return false;
		if (resumo == null) {
			if (other.resumo != null)
				return false;
		} else if (!resumo.equals(other.resumo))
			return false;
		return true;
	}
}
