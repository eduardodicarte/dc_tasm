package br.com.dicarte.seleniummantis.view;

import br.com.dicarte.seleniummantis.view.util.SeleniumUtil;

import com.capgemini.seleniummantis.ejb.exceptions.AmbienteSeleniumMantisException;

public class ExecutorSelenium {
	public static void main(String[] args) throws AmbienteSeleniumMantisException{
		SeleniumUtil.iniciarServidor("felipe.lopes", "123456", "smef");
	}
}
