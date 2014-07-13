package br.com.dicarte.seleniummantis.ejb.model.entidades;

import com.capgemini.seleniummantis.ejb.enums.models.EnumFaseProjeto;
import com.capgemini.seleniummantis.ejb.enums.models.EnumFrequencia;
import com.capgemini.seleniummantis.ejb.enums.models.EnumGravidade;
import com.capgemini.seleniummantis.ejb.enums.models.EnumIf;
import com.capgemini.seleniummantis.ejb.enums.models.EnumNivelAcesso;
import com.capgemini.seleniummantis.ejb.enums.models.EnumPrioridade;
import com.capgemini.seleniummantis.ejb.enums.models.EnumResolucao;
import com.capgemini.seleniummantis.ejb.enums.models.EnumStatusAtivoInativo;
import com.capgemini.seleniummantis.ejb.enums.models.EnumStatusMantis;
import com.capgemini.seleniummantis.ejb.enums.models.EnumVisibilidade;

abstract class ModelImplem implements ModelIf {

	private static final long serialVersionUID = 3586190168544735560L;

	/**
	 * M�todo para atribuir valor ao enum
	 * 
	 * @param pEnum
	 *            Recebe o enum como parametro
	 * @param valorBD
	 *            Recebe o valor que ser� atribuido ao enum, valor recuperado do
	 *            banco de dados, normalmente um inteiro
	 * @return retorna o enum, com o valor recuperado do banco
	 */
	EnumIf converterValorParaEnum(EnumIf pEnum,
			Integer valorBD) {
		if (pEnum instanceof EnumVisibilidade) {
			return atribuirValorEnum((EnumVisibilidade) pEnum, valorBD);
		} else if (pEnum instanceof EnumStatusAtivoInativo) {
			return atribuirValorEnum((EnumStatusAtivoInativo) pEnum, valorBD);
		} else if (pEnum instanceof EnumResolucao) {
			return atribuirValorEnum((EnumResolucao) pEnum, valorBD);
		} else if (pEnum instanceof EnumFrequencia) {
			return atribuirValorEnum((EnumFrequencia) pEnum, valorBD);
		} else if (pEnum instanceof EnumGravidade) {
			return atribuirValorEnum((EnumGravidade) pEnum, valorBD);
		} else if (pEnum instanceof EnumFaseProjeto) {
			return atribuirValorEnum((EnumFaseProjeto) pEnum, valorBD);
		} else if (pEnum instanceof EnumNivelAcesso) {
			return atribuirValorEnum((EnumNivelAcesso) pEnum, valorBD);
		} else if (pEnum instanceof EnumPrioridade) {
			return atribuirValorEnum((EnumPrioridade) pEnum, valorBD);
		} else if (pEnum instanceof EnumStatusMantis) {
			return atribuirValorEnum((EnumStatusMantis) pEnum, valorBD);
		}
		return null;
	}

	/**
	 * @param pEnumImplem
	 *            Superclasse dos Enums
	 * @param valor
	 *            valor retornado do banco de dados
	 * @return retorna para o model o enum configurado
	 */
	private EnumIf atribuirValorEnum(EnumIf pEnumImplem,
			Integer valor) {
		for (EnumIf lEnum : pEnumImplem.toArray()) {
			if (lEnum.getCodigoEnum() == valor) {
				return lEnum;
			}
		}
		return null;
	}

	/**
	 * M�todo que converte o enum para um valor num�rico
	 * @param pEnum Recebe o enum como parametro
	 * @return retorna um inteiro
	 */
	Integer converterEnumParaValor(EnumIf pEnum) {
		if (pEnum instanceof EnumVisibilidade) {
			return ((EnumVisibilidade) pEnum).getCodigoEnum();
		} else if (pEnum instanceof EnumStatusAtivoInativo) {
			return ((EnumStatusAtivoInativo) pEnum).getCodigoEnum();
		} else if (pEnum instanceof EnumResolucao) {
			return ((EnumResolucao) pEnum).getCodigoEnum();
		} else if (pEnum instanceof EnumFrequencia) {
			return ((EnumFrequencia) pEnum).getCodigoEnum();
		} else if (pEnum instanceof EnumGravidade) {
			return ((EnumGravidade) pEnum).getCodigoEnum();
		} else if (pEnum instanceof EnumFaseProjeto) {
			return ((EnumFaseProjeto) pEnum).getCodigoEnum();
		} else if (pEnum instanceof EnumNivelAcesso) {
			return ((EnumNivelAcesso) pEnum).getCodigoEnum();
		} else if (pEnum instanceof EnumPrioridade) {
			return ((EnumPrioridade) pEnum).getCodigoEnum();
		} else if (pEnum instanceof EnumStatusMantis) {
			return ((EnumStatusMantis) pEnum).getCodigoEnum();
		}
		return null;
	}
	
	Integer tratarValorZero(Integer valorBD){
		if (valorBD==null || valorBD==0){
			return null;
		}
		
		return valorBD;
	}
	
	Integer travarValorNulo(Integer valorBD){
		if (valorBD==null){
			return 0;
		}
		
		return valorBD;
	}
}
