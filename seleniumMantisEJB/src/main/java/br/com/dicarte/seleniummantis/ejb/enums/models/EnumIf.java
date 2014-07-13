package br.com.dicarte.seleniummantis.ejb.enums.models;

public interface EnumIf{
	
	/**
	 * 
	 * @return Retorna o codigo do enum
	 */
	public Integer getCodigoEnum();
	
	/**
	 * 
	 * @param codigoEnum Atribui um codigo para o enum, o c�digo deve ser o mesmo do banco, tabela mantis_project_table 
	 */
	public void setCodigoEnum(Integer codigoEnum);
	
	
	/**
	 * 
	 * @return Retorna os valores do enum, equivalente a .values()
	 */
	public EnumIf[] toArray();
}
