package br.com.dicarte.seleniummantis.view.util;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import br.com.dicarte.seleniummantis.view.enums.EnumBrowsers;
import br.com.dicarte.seleniummantis.view.enums.EnumInfoSelenium;
import br.com.dicarte.seleniummantis.view.enums.EnumTipoElemento;

import com.capgemini.seleniummantis.ejb.enums.EnumMensagemException;
import com.capgemini.seleniummantis.ejb.exceptions.AmbienteSeleniumMantisException;

public class SeleniumUtil {

	private static Properties	seleniumProperties;
	private static WebDriver	driver;

	private static Properties obterSeleniumProperties() throws AmbienteSeleniumMantisException {
		if (seleniumProperties == null) {
			seleniumProperties = obterArquivo("selenium.properties");
		}
		return seleniumProperties;
	}

	private static String obterInfoWebDriver(EnumBrowsers browser) throws AmbienteSeleniumMantisException {
		if (browser.equals(EnumBrowsers.INTERNET_EXPLORER)) {
			return obterSeleniumProperties().getProperty("selenium-driver-ie");
		} else {
			throw new AmbienteSeleniumMantisException(EnumInfoSelenium.BROWSER_NAO_SUPORTADO.getMensagem());
		}
	}

	private static Properties obterArquivo(String arquivo) throws AmbienteSeleniumMantisException {
		try {
			Properties properties = new Properties();

			InputStream stream = SeleniumUtil.class.getClassLoader().getResourceAsStream(arquivo);

			if (stream == null) {
				throw new AmbienteSeleniumMantisException(EnumInfoSelenium.ARQUIVO_NAO_ENCONTRADO.getMensagem());
			}

			properties.load(stream);

			return properties;

		} catch (Exception exception) {
			if (exception instanceof AmbienteSeleniumMantisException) {
				throw new AmbienteSeleniumMantisException(((AmbienteSeleniumMantisException) exception).getMensagem());
			}
			throw new AmbienteSeleniumMantisException(exception);
		}
	}

	public static String obterMensagem(String codigoMensagem) throws AmbienteSeleniumMantisException {
		return obterArquivo("dicionario.properties").getProperty(codigoMensagem);
	}

	public static void iniciarServidor(String usuarioAplicacao, String senhaAplicacao, String sistema, String dominio) throws AmbienteSeleniumMantisException {
		

		/*SeleniumUtil.login();*/
	}
	
	public static void iniciarServidor(String usuarioAplicacao, String senhaAplicacao, String sistema) throws AmbienteSeleniumMantisException {
		obterInfoConexao(sistema);

		/*SeleniumUtil.login();*/
	}

	/*private static void login(String login) {
		obterElemento("", login);
	}*/
	
	private static void obterInfoConexao(String sistema) throws AmbienteSeleniumMantisException{
		System.setProperty("webdriver.ie.driver", obterInfoWebDriver(EnumBrowsers.INTERNET_EXPLORER));
		driver = new InternetExplorerDriver();

		driver.get(obterSeleniumProperties().getProperty("url") + sistema);
	}

	/**
	 * Método recebe o nome, id, class, link do atributo ou title do button e retorna um webelement
	 * 
	 * @param elemento
	 *            Recebe como string o nome do atributo
	 * @return retorna um webelement
	 * @throws AmbienteSeleniumMantisException
	 *             erros de ambiente
	 */
	public static WebElement obterElemento(String atributo, EnumTipoElemento enumTipoElemento) throws AmbienteSeleniumMantisException {

		if (enumTipoElemento.equals(EnumTipoElemento.ID)) {
			return driver.findElement(By.id(atributo));
		}

		if (enumTipoElemento.equals(EnumTipoElemento.NAME)) {
			return driver.findElement(By.name(atributo));
		}

		if (enumTipoElemento.equals(EnumTipoElemento.CLASSE)) {
			return driver.findElement(By.className(atributo));
		}

		if (enumTipoElemento.equals(EnumTipoElemento.TITULO_DO_BOTAO)) {
			return driver.findElement(By.xpath("//button[@title='" + atributo + "']"));
		}

		if (enumTipoElemento.equals(EnumTipoElemento.NOME_DO_ELEMENTO)) {
			return driver.findElement(By.name(atributo));
		}

		if (enumTipoElemento.equals(EnumTipoElemento.LINK)) {
			return driver.findElement(By.linkText(atributo));
		}

		throw new AmbienteSeleniumMantisException(EnumInfoSelenium.ATRIBUTO_NAO_ENCONTRADO.getMensagem());
	}

}
