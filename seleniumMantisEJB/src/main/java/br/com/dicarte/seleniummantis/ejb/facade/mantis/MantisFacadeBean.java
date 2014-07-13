package br.com.dicarte.seleniummantis.ejb.facade.mantis;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.dicarte.seleniummantis.ejb.enums.EnumMensagemException;
import br.com.dicarte.seleniummantis.ejb.enums.mantis.EnumInfoMantis;
import br.com.dicarte.seleniummantis.ejb.enums.models.EnumResolucao;
import br.com.dicarte.seleniummantis.ejb.enums.models.EnumStatusMantis;
import br.com.dicarte.seleniummantis.ejb.enums.models.EnumVisibilidade;
import br.com.dicarte.seleniummantis.ejb.exceptions.AmbienteSeleniumMantisException;
import br.com.dicarte.seleniummantis.ejb.exceptions.NegocioSeleniumMantisException;
import br.com.dicarte.seleniummantis.ejb.facade.tabela.TabelaFacadeRemote;
import br.com.dicarte.seleniummantis.ejb.model.entidades.Anotacao;
import br.com.dicarte.seleniummantis.ejb.model.entidades.Categoria;
import br.com.dicarte.seleniummantis.ejb.model.entidades.Descricao;
import br.com.dicarte.seleniummantis.ejb.model.entidades.DescricaoAnotacao;
import br.com.dicarte.seleniummantis.ejb.model.entidades.Mantis;
import br.com.dicarte.seleniummantis.ejb.model.entidades.MantisBD;
import br.com.dicarte.seleniummantis.ejb.model.entidades.PerfilUsuario;
import br.com.dicarte.seleniummantis.ejb.model.entidades.Projeto;
import br.com.dicarte.seleniummantis.ejb.model.entidades.ResponsavelProjeto;
import br.com.dicarte.seleniummantis.ejb.model.entidades.UsuarioMantis;
import br.com.dicarte.seleniummantis.ejb.util.SeleniumMantisUtil;

@Stateless
public class MantisFacadeBean implements MantisFacadeLocal, MantisFacadeRemote {

	@EJB
	private TabelaFacadeRemote	tabelaFacade;

	@Override
	public Mantis reportarMantis(Mantis mantis) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException {
		try {
			validarMantis(mantis);
			MantisBD mantisBD = preencherModelMantis(mantis);
			gravarMantis(mantisBD);
			/*anexarAnotacoes(mantis, mantisBD.getIdentificador()); */

			mantis.setIdentificador(mantisBD.getIdentificador());

			return mantis;
		} catch (Exception exception) {
			exception.getStackTrace();
		}

		return null;
	}

	/**
	 * A anotação só será persistida após a geração do mantis
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	private Collection<Anotacao> anexarAnotacoes(Mantis mantis, Integer idMantis) throws AmbienteSeleniumMantisException,
			NegocioSeleniumMantisException {
		try {
			if (mantis.getAnotacoes() != null && mantis.getAnotacoes().size() > 0) {
				Collection<Anotacao> collAnotacao = new ArrayList<Anotacao>();
				for (String lDescricaoAnotacao : mantis.getAnotacoes()) {
					DescricaoAnotacao descricaoAnotacao = new DescricaoAnotacao();
					Anotacao anotacao = new Anotacao();
					MantisBD mantisBD = new MantisBD();
					mantisBD.setIdentificador(idMantis);
					anotacao.setMantis(mantisBD);
					descricaoAnotacao.setDescricaoAnotacao(lDescricaoAnotacao);
					tabelaFacade.gravarAtualizar(descricaoAnotacao);
					anotacao.setDescricaoAnotacao(descricaoAnotacao);
					collAnotacao.add(anotacao);
				}

				if (collAnotacao.size() > 0) {
					return gravarAnotacoes(collAnotacao);
				}
			}
		} catch (Exception exception) {
			throw new NegocioSeleniumMantisException(exception);
		}
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	private Collection<Anotacao> gravarAnotacoes(Collection<Anotacao> collAnotacao) throws AmbienteSeleniumMantisException,
			NegocioSeleniumMantisException {
		for (Anotacao lAnotacao : collAnotacao) {
			lAnotacao.setDataEnvio(0);
			lAnotacao.setVisibilidade(EnumVisibilidade.PUBLICO);
			lAnotacao.setUsuarioMantisReporterAnotacao(obterUsuarioReporterMantis());
			tabelaFacade.gravarAtualizar(lAnotacao);
		}
		return collAnotacao;
	}

	private UsuarioMantis obterUsuarioReporterMantis() throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException {
		UsuarioMantis usuarioMantis = new UsuarioMantis();
		usuarioMantis.setLogin("selenium.mantis");

		return (UsuarioMantis)tabelaFacade.obterModelUnicoComFiltro(usuarioMantis);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	private Descricao obterDescricaoMantis(Mantis mantis) throws NegocioSeleniumMantisException, AmbienteSeleniumMantisException {
		if (((mantis.getDescricao() == null || mantis.getDescricao().trim().isEmpty()) || mantis.getPassosParaReproduzir() == null || mantis
				.getPassosParaReproduzir().trim().isEmpty())
				|| (mantis.getInformacoesAdicionais() == null || mantis.getInformacoesAdicionais().trim().isEmpty())) {
			throw new NegocioSeleniumMantisException(EnumMensagemException.VALOR_NAO_PREENCHIDO.getMensagem());
		}

		Descricao descricao = new Descricao();
		descricao.setDescricao(mantis.getDescricao());
		descricao.setPassosParaReproduzir(mantis.getPassosParaReproduzir());
		descricao.setInformacoesAdicionais(mantis.getInformacoesAdicionais());
		
		descricao = (Descricao) tabelaFacade.gravarAtualizar(descricao);

		return descricao;
	}

	private void validarMantis(Mantis mantis) throws NegocioSeleniumMantisException, AmbienteSeleniumMantisException {

		boolean valorNulo = false;

		if (mantis == null) {
			valorNulo = true;
		} else {
			verificaExistenciaMantis(mantis);
		}

		if ((mantis.getDescricao() == null || mantis.getInformacoesAdicionais() == null) || mantis.getPassosParaReproduzir() == null) {
			valorNulo = true;
		}

		if ((mantis.getEnumFrequencia() == null || mantis.getEnumGravidade() == null) || mantis.getEnumPrioridade() == null) {
			valorNulo = true;
		}

		if (mantis.getBuild() == null) {
			valorNulo = true;
		}

		if (mantis.getResumo() == null) {
			valorNulo = true;
		}

		if (valorNulo) {
			throw new NegocioSeleniumMantisException(EnumMensagemException.OBJETO_NULO.getMensagem());
		}
	}

	private void verificaExistenciaMantis(Mantis mantis) throws NegocioSeleniumMantisException, AmbienteSeleniumMantisException {
		if (mantis.getIdentificador() != null) {
			MantisBD mantisBD = new MantisBD();
			mantisBD.setIdentificador(mantis.getIdentificador());
			mantisBD = (MantisBD) tabelaFacade.obterModelUnicoComFiltro(mantisBD);

			if (mantisBD == null) {
				throw new NegocioSeleniumMantisException(EnumMensagemException.MANTIS_NAO_ENCONTRADO.getMensagem());
			}
		}
	}

	private MantisBD preencherModelMantis(Mantis mantis) throws NegocioSeleniumMantisException, AmbienteSeleniumMantisException {
		MantisBD mantisBD = new MantisBD();
		mantisBD.setProjeto(obterProjeto(mantis.getProjeto()));
		mantisBD.setDescricao(obterDescricaoMantis(mantis));
		mantisBD.setFrequencia(mantis.getEnumFrequencia());
		mantisBD.setGravidade(mantis.getEnumGravidade());
		mantisBD.setPrioridade(mantis.getEnumPrioridade());
		mantisBD.setResumo(mantis.getResumo());
		mantisBD.setResolucao(EnumResolucao.ABERTO);
		mantisBD.setVisibilidade(EnumVisibilidade.PUBLICO);
		mantisBD.setStatus(EnumStatusMantis.NOVO);
		mantisBD.setCategoria(obterCategoria(mantis.getCategoriaMantis()));
		mantisBD.setBuild(mantis.getBuild());
		mantisBD.setDataEnvio(SeleniumMantisUtil.obterDataAtualBD());
		mantisBD.setDataUltimaAtualizacao(mantisBD.getDataEnvio());
		mantisBD.setUsuarioMantisReporter(obterUsuarioReporterMantis());
		mantisBD.setUsuarioMantisAtribuido(obterResponsavelProjeto(mantisBD.getProjeto()));
		mantisBD.setReferenciaMantisDuplicado(obterMantisDuplicado());
		mantisBD.setPerfil(obterPerfilUsuario());
		preencherValoresNulos(mantisBD);

		return mantisBD;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	private void gravarMantis(MantisBD mantisBD) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException {
		mantisBD = (MantisBD) tabelaFacade.gravarAtualizar(mantisBD);
	}

	private Projeto obterProjeto(String nomeProjeto) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException {
		Projeto projeto = new Projeto();
		projeto.setNome(nomeProjeto);

		return (Projeto) tabelaFacade.obterModelUnicoComFiltro(projeto);

	}

	private UsuarioMantis obterResponsavelProjeto(Projeto projeto) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException {
		ResponsavelProjeto responsavelProjeto = new ResponsavelProjeto();
		responsavelProjeto.setProjeto(projeto);

		responsavelProjeto = (ResponsavelProjeto) tabelaFacade.obterModelUnicoComFiltro(responsavelProjeto);

		return responsavelProjeto.getResponsavel();
	}

	private Categoria obterCategoria(String nomeCategoria) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException {

		Categoria categoria = new Categoria();
		categoria.setNomeCategoria(nomeCategoria);

		return (Categoria) tabelaFacade.obterModelUnicoComFiltro(categoria);

	}

	private PerfilUsuario obterPerfilUsuario() {
		PerfilUsuario perfil = new PerfilUsuario();
		perfil.setIdentificador(EnumInfoMantis.NENHUM_VALOR_TIPO_INTEGER.getCodigo());

		return perfil;
	}

	private MantisBD obterMantisDuplicado() {
		MantisBD mantisBD = new MantisBD();
		mantisBD.setIdentificador(EnumInfoMantis.NENHUM_VALOR_TIPO_INTEGER.getCodigo());

		return mantisBD;
	}
	
	private void preencherValoresNulos(MantisBD mantisBD){
		mantisBD.setCorrigidoNaVersao(EnumInfoMantis.NENHUM_VALOR_TIPO_STRING.getMensagem());
		mantisBD.setDataVencimento(EnumInfoMantis.NENHUM_VALOR_TIPO_INTEGER.getCodigo());
		mantisBD.setPlataforma(EnumInfoMantis.NENHUM_VALOR_TIPO_STRING.getMensagem());
		mantisBD.setSistemaOperacional(EnumInfoMantis.NOME_SISTEMA_OPERACIONAL.getMensagem());
		mantisBD.setVersao(EnumInfoMantis.NENHUM_VALOR_TIPO_STRING.getMensagem());
		mantisBD.setVersaoEntregaPrevista(EnumInfoMantis.NENHUM_VALOR_TIPO_STRING.getMensagem()); 
		mantisBD.setVersaoSistemaOperacional(EnumInfoMantis.NENHUM_VALOR_TIPO_STRING.getMensagem());
	}
}
