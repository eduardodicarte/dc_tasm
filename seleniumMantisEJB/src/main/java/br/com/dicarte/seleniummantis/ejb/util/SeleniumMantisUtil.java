package br.com.dicarte.seleniummantis.ejb.util;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.dicarte.seleniummantis.ejb.enums.EnumTipoLookup;
import br.com.dicarte.seleniummantis.ejb.exceptions.AmbienteSeleniumMantisException;

public class SeleniumMantisUtil {

	private static Properties		seleniumMantisProperties;
	private static InitialContext	context;
	private static Calendar cal = Calendar.getInstance(new Locale("pt-br"));

	private static Properties obterPropriedadesContexto() throws IOException {
		seleniumMantisProperties = new Properties();
		seleniumMantisProperties.load(SeleniumMantisUtil.class.getClassLoader().getResourceAsStream("seleniumMantis.properties"));
		return seleniumMantisProperties;
	}

	/**
	 * M�todo para obter a fachada, buscando inicialmente a fachada local, caso n�o encontre ent�o busca a fachada remota
	 * 
	 * @param <T>
	 *            Tipo Gen�rico da Fachada
	 * @param interfaceEJB
	 *            Recebe a interface da fachada da qual se deseja fazer lookup
	 * @return Retorna a fachada
	 * @throws AmbienteSeleniumMantisException
	 *             Exce��o para erros de ambiente
	 */
	@SuppressWarnings("unchecked")
	public <T> T obterFachada(Class<T> interfaceEJB) throws AmbienteSeleniumMantisException {
		try {
			return (T) obterContexto().lookup(obterNomeFachadaLocal(interfaceEJB.getSimpleName()));
		} catch (Exception exceptionFachadaLocal) {
			try {
				return (T) obterContexto().lookup(obterNomeFachadaRemota(interfaceEJB.getClass().getSimpleName()));
			} catch (Exception exceptionFachadaRemota) {
				throw new AmbienteSeleniumMantisException(exceptionFachadaRemota, NegocioConstantesIf.ERRO_OBTER_FACHADA);
			}
		} finally {
			try {
				obterContexto().close();
			} catch (NamingException exception) {
				exception.printStackTrace();
			}
		}
	}

	/**
	 * M�todo para obter a fachada, a busca � feita conforme o parametro tipoLookup
	 * 
	 * @param <T>
	 *            Tipo Gen�rico da Fachada
	 * @param interfaceEJB
	 *            Recebe a interface da fachada da qual se deseja fazer lookup
	 * @param tipoLookup
	 *            Tipo do lookup, Local ou Remoto
	 * @return Retorna a fachada
	 * @throws AmbienteSeleniumMantisException
	 *             Exce��o para erros de ambiente
	 */
	@SuppressWarnings("unchecked")
	public static synchronized <T> T obterFachada(Class<T> interfaceEJB, EnumTipoLookup tipoLookup) throws AmbienteSeleniumMantisException {
		try {
			if (EnumTipoLookup.LOCAL.equals(tipoLookup)) {
				return (T) obterContexto().lookup(obterNomeFachadaLocal(interfaceEJB.getSimpleName()));
			} else {
				return (T) obterContexto().lookup(obterNomeFachadaRemota(interfaceEJB.getSimpleName()));
			}
		} catch (NamingException namingException) {
			throw new AmbienteSeleniumMantisException(namingException, NegocioConstantesIf.ERRO_OBTER_FACHADA);
		}
	}

	private static InitialContext obterContexto() throws AmbienteSeleniumMantisException {
		if (context == null) {
			try {
				context = new InitialContext(SeleniumMantisUtil.obterPropriedadesContexto());
			} catch (NamingException namingException) {
				throw new AmbienteSeleniumMantisException(namingException);
			} catch (IOException exception) {
				throw new AmbienteSeleniumMantisException(exception, NegocioConstantesIf.ERRO_OBTER_CONTEXTO);
			}
		}

		return context;
	}

	private static String obterNomeFachadaLocal(String nomeInterface) {
		return NegocioConstantesIf.NOME_EAR + NegocioConstantesIf.BARRA + nomeInterface + NegocioConstantesIf.BEAN + NegocioConstantesIf.BARRA
				+ NegocioConstantesIf.LOCAL;
	}

	private static String obterNomeFachadaRemota(String nomeInterface) {
		return NegocioConstantesIf.NOME_EAR + NegocioConstantesIf.BARRA + nomeInterface + NegocioConstantesIf.BEAN + NegocioConstantesIf.BARRA
				+ NegocioConstantesIf.REMOTE;
	}
	
	public static Integer obterDataAtualBD(){
		cal.setTime(new Date());
		String strDate = String.valueOf(cal.getTime().getTime());
		strDate = strDate.substring(0, strDate.length() - 3);
		
		return Integer.parseInt(strDate);
	}
	
	public static Date obterDataAtual(){
		cal.setTime(new Date());
		return cal.getTime();
	}
	
	public static Calendar obterCalendar(){
		cal.setTime(new Date());
		return cal;
	}
}
