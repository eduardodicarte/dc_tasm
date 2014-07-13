package br.com.dicarte.seleniummantis.ejb.facade.tabela;

import java.util.Collection;

import com.capgemini.seleniummantis.ejb.exceptions.AmbienteSeleniumMantisException;
import com.capgemini.seleniummantis.ejb.exceptions.NegocioSeleniumMantisException;
import com.capgemini.seleniummantis.ejb.model.entidades.ModelIf;

public interface TabelaFacade {

	/**
	 * Mï¿½todo para obter todos os registros de um determinado model
	 * 
	 * @param Recebe
	 *            um model como parametro, a pesquisa ï¿½ feita para esse parametro
	 * @return Retorna uma coleï¿½ï¿½o de registros do model passado por parametro
	 * @throws AmbienteSeleniumMantisException
	 *             erros de ambiente
	 * @throws NegocioSeleniumMantisException
	 *             erros de sistema
	 */
	Collection<ModelIf> obterTodos(ModelIf model) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException;

	/**
	 * MÃ©todo para atualizar um model caso esteja com um cÃ³digo vÃ¡lido, ou para gravar um novo registro caso seu identificador esteja com o valor
	 * nulo
	 * 
	 * @param model
	 *            Model a ser persistido
	 * @return Retorna o model com os valores atualizados
	 * @throws AmbienteSeleniumMantisException
	 *             erros de ambiente
	 * @throws NegocioSeleniumMantisException
	 *             erros de sistema
	 */
	ModelIf gravarAtualizar(ModelIf model) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException;

	/**
	 * 
	 * @param model
	 * @return
	 * @throws AmbienteSeleniumMantisException
	 * @throws NegocioSeleniumMantisException
	 */
	Collection<ModelIf> obterModelCompleto(ModelIf model) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException;

	/**
	 * Método retorna uma collection de models conforme os filtros informados
	 * 
	 * @param model
	 *            Recebe o model com os filtros
	 * @return Retorna uma coleção de model
	 * @throws AmbienteSeleniumMantisException
	 *             Erros de Ambiente
	 * @throws NegocioSeleniumMantisException
	 *             Erros de sistema
	 */
	Collection<ModelIf> obterModelComFiltro(ModelIf model) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException;

	/**
	 * Método retorna um model conforme os filtros informados
	 * 
	 * @param model
	 *            Recebe o model com os filtros
	 * @return Retorna uma coleção de model
	 * @throws AmbienteSeleniumMantisException
	 *             Erros de Ambiente
	 * @throws NegocioSeleniumMantisException
	 *             Erros de sistema
	 */
	ModelIf obterModelUnicoComFiltro(ModelIf model) throws AmbienteSeleniumMantisException, NegocioSeleniumMantisException;
}