package br.com.dicarte.seleniummantis.ejb.facade.mantis;

import br.com.dicarte.seleniummantis.ejb.exceptions.AmbienteSeleniumMantisException;
import br.com.dicarte.seleniummantis.ejb.exceptions.NegocioSeleniumMantisException;
import br.com.dicarte.seleniummantis.ejb.model.entidades.Mantis;


public interface MantisFacade {
	
	/**
	 * Método utilizado para abertura de mantis
	 * @param mantis Recebe o model do mantis a ser aberto
	 * @return Retorna o mantis aberto
	 */
	Mantis reportarMantis(Mantis mantis) throws AmbienteSeleniumMantisException,NegocioSeleniumMantisException;
	
}
