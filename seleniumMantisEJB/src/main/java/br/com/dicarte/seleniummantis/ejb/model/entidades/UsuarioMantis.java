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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.com.dicarte.seleniummantis.ejb.enums.models.EnumNivelAcesso;
import br.com.dicarte.seleniummantis.ejb.enums.models.EnumStatusSimNao;

/**
 * Classe Responsavel pelo gerenciamento de usuarios dos mantis
 * 
 * @author eduardo.dicarte
 * 
 */

@Entity
@Table(name = "mantis_user_table")
public class UsuarioMantis extends ModelImplem {

	private static final long				serialVersionUID	= 5308823710288733316L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private Integer							identificador;

	@Column(name = "username", unique = true)
	private String							login;

	@Column(name = "realname")
	private String							nome;

	@Column(name = "email")
	private String							email;

	@Column(name = "password")
	private String							senha;

	@Column(name = "enabled", columnDefinition = "TINYINT")
	private Integer							statusContaBD;

	@Column(name = "protected", columnDefinition = "TINYINT")
	private Integer							protegidoBD;

	@Column(name = "access_level", columnDefinition = "smallint")
	private Integer							nivelAcessoBD;

	@Transient
	@Enumerated
	private EnumStatusSimNao				statusConta;

	@Transient
	@Enumerated
	private EnumStatusSimNao				protegido;

	@Transient
	@Enumerated
	private EnumNivelAcesso					nivelAcesso;

	@Column(name = "login_count")
	private Integer							logins;

	@Column(name = "lost_password_request_count", columnDefinition = "smallint")
	private Integer							solicitacoesSenhaPerdida;

	@Column(name = "failed_login_count", columnDefinition = "smallint")
	private Integer							falhaLogin;

	@Column(name = "cookie_string")
	private String							cookie;

	@Column(name = "last_visit")
	private Integer							ultimoAcesso;

	@Column(name = "date_created")
	private Integer							dataCriacao;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "usuario")
	private PerfilUsuario					perfilUsuarioMantis;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuarioMantisReporterAnotacao")
	private Collection<Anotacao>			collAnotacoes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioMantisEvidencia")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<Evidencia>			collEvidencias;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioMantisHistorico")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<Historico>			collHistorico;

	@OneToMany(mappedBy = "usuarioMantis")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<Categoria>			collCategorias;

	@OneToMany(mappedBy = "usuarioMantisReporter")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<MantisBD>			collMantisReporter;

	@OneToMany(mappedBy = "usuarioMantisAtribuido")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Collection<MantisBD>			collMantisAtribuido;

	public UsuarioMantis() {
		this.nivelAcesso = EnumNivelAcesso.NENHUM_SELECIONADO;
		this.protegido = EnumStatusSimNao.NENHUM_SELECIONADO;
		this.statusConta = EnumStatusSimNao.NENHUM_SELECIONADO;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	@Override
	public Integer getIdentificador() {
		return tratarValorZero(identificador);
	}

	public PerfilUsuario getPerfilUsuarioMantis() {
		return perfilUsuarioMantis;
	}

	public void setPerfilUsuarioMantis(PerfilUsuario perfilUsuarioMantis) {
		this.perfilUsuarioMantis = perfilUsuarioMantis;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getLogins() {
		return logins;
	}

	public void setLogins(Integer logins) {
		this.logins = logins;
	}

	public Integer getSolicitacoesSenhaPerdida() {
		return solicitacoesSenhaPerdida;
	}

	public void setSolicitacoesSenhaPerdida(Integer solicitacoesSenhaPerdida) {
		this.solicitacoesSenhaPerdida = solicitacoesSenhaPerdida;
	}

	public Integer getFalhaLogin() {
		return falhaLogin;
	}

	public void setFalhaLogin(Integer falhaLogin) {
		this.falhaLogin = falhaLogin;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public Integer getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Integer ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public Integer getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Integer dataCriacao) {
		this.dataCriacao = dataCriacao;
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

	public Collection<Historico> getCollHistorico() {
		return collHistorico;
	}

	public void setCollHistorico(Collection<Historico> collHistorico) {
		this.collHistorico = collHistorico;
	}

	public Collection<MantisBD> getCollMantisReporter() {
		return collMantisReporter;
	}

	public void setCollMantisReporter(Collection<MantisBD> collMantisReporter) {
		this.collMantisReporter = collMantisReporter;
	}

	public Collection<MantisBD> getCollMantisAtribuido() {
		return collMantisAtribuido;
	}

	public void setCollMantisAtribuido(Collection<MantisBD> collMantisAtribuido) {
		this.collMantisAtribuido = collMantisAtribuido;
	}

	public Collection<Categoria> getCollCategorias() {
		return collCategorias;
	}

	public void setCollCategorias(Collection<Categoria> collCategorias) {
		this.collCategorias = collCategorias;
	}

	public EnumStatusSimNao getStatusConta() {
		this.statusConta = (EnumStatusSimNao) converterValorParaEnum(statusConta, statusContaBD);
		return statusConta;
	}

	public void setStatusConta(EnumStatusSimNao statusConta) {
		setStatusContaBD(converterEnumParaValor(statusConta));
		this.statusConta = statusConta;
	}

	public EnumStatusSimNao getProtegido() {
		this.protegido = (EnumStatusSimNao) converterValorParaEnum(protegido, protegidoBD);
		return protegido;
	}

	public void setProtegido(EnumStatusSimNao protegido) {
		setProtegidoBD(converterEnumParaValor(protegido));
		this.protegido = protegido;
	}

	Integer getStatusContaBD() {
		return statusContaBD;
	}

	void setStatusContaBD(Integer statusContaBD) {
		this.statusContaBD = statusContaBD;
	}

	public EnumNivelAcesso getNivelAcesso() {
		this.nivelAcesso = (EnumNivelAcesso) converterValorParaEnum(nivelAcesso, nivelAcessoBD);
		return nivelAcesso;
	}

	public void setNivelAcesso(EnumNivelAcesso nivelAcesso) {
		setNivelAcessoBD(converterEnumParaValor(nivelAcesso));
		this.nivelAcesso = nivelAcesso;
	}

	Integer getProtegidoBD() {
		return protegidoBD;
	}

	void setProtegidoBD(Integer protegidoBD) {
		this.protegidoBD = protegidoBD;
	}

	Integer getNivelAcessoBD() {
		return nivelAcessoBD;
	}

	void setNivelAcessoBD(Integer nivelAcessoBD) {
		this.nivelAcessoBD = nivelAcessoBD;
	}

	@Override
	public String[] getNomeColecoes() {
		return new String[] {"perfilUsuarioMantis", "collEvidencias", "perfilUsuarioMantis", "collAnotacoes", "collHistorico", "collCategorias",
				"collMantisReporter", "collMantisAtribuido", "collResponsavelProjetos"};
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collAnotacoes == null) ? 0 : collAnotacoes.hashCode());
		result = prime * result + ((collCategorias == null) ? 0 : collCategorias.hashCode());
		result = prime * result + ((collEvidencias == null) ? 0 : collEvidencias.hashCode());
		result = prime * result + ((collHistorico == null) ? 0 : collHistorico.hashCode());
		result = prime * result + ((collMantisAtribuido == null) ? 0 : collMantisAtribuido.hashCode());
		result = prime * result + ((collMantisReporter == null) ? 0 : collMantisReporter.hashCode());
		result = prime * result + ((cookie == null) ? 0 : cookie.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((falhaLogin == null) ? 0 : falhaLogin.hashCode());
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((logins == null) ? 0 : logins.hashCode());
		result = prime * result + ((nivelAcessoBD == null) ? 0 : nivelAcessoBD.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((perfilUsuarioMantis == null) ? 0 : perfilUsuarioMantis.hashCode());
		result = prime * result + ((protegidoBD == null) ? 0 : protegidoBD.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((solicitacoesSenhaPerdida == null) ? 0 : solicitacoesSenhaPerdida.hashCode());
		result = prime * result + ((statusContaBD == null) ? 0 : statusContaBD.hashCode());
		result = prime * result + ((ultimoAcesso == null) ? 0 : ultimoAcesso.hashCode());
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
		UsuarioMantis other = (UsuarioMantis) obj;
		if (collAnotacoes == null) {
			if (other.collAnotacoes != null)
				return false;
		} else if (!collAnotacoes.equals(other.collAnotacoes))
			return false;
		if (collCategorias == null) {
			if (other.collCategorias != null)
				return false;
		} else if (!collCategorias.equals(other.collCategorias))
			return false;
		if (collEvidencias == null) {
			if (other.collEvidencias != null)
				return false;
		} else if (!collEvidencias.equals(other.collEvidencias))
			return false;
		if (collHistorico == null) {
			if (other.collHistorico != null)
				return false;
		} else if (!collHistorico.equals(other.collHistorico))
			return false;
		if (collMantisAtribuido == null) {
			if (other.collMantisAtribuido != null)
				return false;
		} else if (!collMantisAtribuido.equals(other.collMantisAtribuido))
			return false;
		if (collMantisReporter == null) {
			if (other.collMantisReporter != null)
				return false;
		} else if (!collMantisReporter.equals(other.collMantisReporter))
			return false;
		if (cookie == null) {
			if (other.cookie != null)
				return false;
		} else if (!cookie.equals(other.cookie))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (falhaLogin == null) {
			if (other.falhaLogin != null)
				return false;
		} else if (!falhaLogin.equals(other.falhaLogin))
			return false;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (logins == null) {
			if (other.logins != null)
				return false;
		} else if (!logins.equals(other.logins))
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
		if (perfilUsuarioMantis == null) {
			if (other.perfilUsuarioMantis != null)
				return false;
		} else if (!perfilUsuarioMantis.equals(other.perfilUsuarioMantis))
			return false;
		if (protegidoBD == null) {
			if (other.protegidoBD != null)
				return false;
		} else if (!protegidoBD.equals(other.protegidoBD))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (solicitacoesSenhaPerdida == null) {
			if (other.solicitacoesSenhaPerdida != null)
				return false;
		} else if (!solicitacoesSenhaPerdida.equals(other.solicitacoesSenhaPerdida))
			return false;
		if (statusContaBD == null) {
			if (other.statusContaBD != null)
				return false;
		} else if (!statusContaBD.equals(other.statusContaBD))
			return false;
		if (ultimoAcesso == null) {
			if (other.ultimoAcesso != null)
				return false;
		} else if (!ultimoAcesso.equals(other.ultimoAcesso))
			return false;
		return true;
	}
}