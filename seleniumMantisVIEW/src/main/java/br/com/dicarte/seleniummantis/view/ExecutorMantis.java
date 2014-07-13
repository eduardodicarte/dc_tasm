package br.com.dicarte.seleniummantis.view;

import java.util.ArrayList;
import java.util.Collection;

import com.capgemini.seleniummantis.ejb.enums.EnumTipoLookup;
import com.capgemini.seleniummantis.ejb.enums.models.EnumFrequencia;
import com.capgemini.seleniummantis.ejb.enums.models.EnumGravidade;
import com.capgemini.seleniummantis.ejb.enums.models.EnumPrioridade;
import com.capgemini.seleniummantis.ejb.exceptions.AmbienteSeleniumMantisException;
import com.capgemini.seleniummantis.ejb.exceptions.NegocioSeleniumMantisException;
import com.capgemini.seleniummantis.ejb.facade.mantis.MantisFacade;
import com.capgemini.seleniummantis.ejb.facade.mantis.MantisFacadeRemote;
import com.capgemini.seleniummantis.ejb.facade.tabela.TabelaFacadeLocal;
import com.capgemini.seleniummantis.ejb.facade.tabela.TabelaFacadeRemote;
import com.capgemini.seleniummantis.ejb.model.entidades.Mantis;
import com.capgemini.seleniummantis.ejb.util.SeleniumMantisUtil;

public class ExecutorMantis {

	static TabelaFacadeRemote	tabelaRemote;
	static TabelaFacadeLocal	tabelaFacadeLocal;
	static MantisFacadeRemote   mantisFacade;

	public static void main(String[] args) throws NegocioSeleniumMantisException {
		
		try {
			Mantis mantis = new Mantis();
			Collection<String> anotacoes = new ArrayList<String>();
			anotacoes.add("Primeiro Teste de anotacoes");
			anotacoes.add("Segundo Teste de anotacoes");
			mantis.setAnotacoes(anotacoes);
			mantis.setDescricao("Descrição Teste para abertura do mantis");
			mantis.setEnumFrequencia(EnumFrequencia.AS_VEZES);
			mantis.setEnumGravidade(EnumGravidade.OBSTACULO);
			mantis.setBuild("SMEF001");
			mantis.setEnumPrioridade(EnumPrioridade.ALTA);
			mantis.setInformacoesAdicionais("Informacoes Adicionais para teste de abertura do mantis");
			mantis.setPassosParaReproduzir("Acessar o sistema, clicar no botão enviar");
			mantis.setProjeto("Testes Integrados");
			mantis.setResumo("Resumo para teste de abertura de mantis");
			mantis.setCategoriaMantis("Testes Integração Contínua");
			
			mantisFacade = (MantisFacadeRemote)SeleniumMantisUtil.obterFachada(MantisFacade.class, EnumTipoLookup.REMOTA);
			mantisFacade.reportarMantis(mantis);
			
		} catch (AmbienteSeleniumMantisException ambienteSeleniumMantisException) {
			ambienteSeleniumMantisException.printStackTrace();
		}catch(NegocioSeleniumMantisException negocioSeleniumMantisException){
			negocioSeleniumMantisException.printStackTrace();
		}
	}

}
