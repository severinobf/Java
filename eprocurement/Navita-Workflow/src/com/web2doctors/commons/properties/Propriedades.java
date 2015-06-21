package com.web2doctors.commons.properties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Singleton que mant�m todas as propriedades de v�rios "m�dulos", em um HashMap, e disponibiliza m�todos de 
 * acesso a propriedades de v�rios m�dulos.
 * <p>Um "m�dulo" pode ser definido como um arquivo de propriedades relativos a um determinado grupo de servicos 
 * que pode ser configur�vel por aquivos de propriedades. Por exemplo, podemos ter o m�dulo de 
 * clientes, que ter� as consultas e propriedades espec�ficas para o m�dulo de clientes. Podemos ter o m�dulo 
 * de TEF (transfer�ncia eletr�nica de fundos) e teremos todas as propriedades do TEF como timeout, endere�o
 * do servidor, etc, no m�dulo de propriedades do TEF. Ou seja, o nome do m�dulo se resumo ao nome do arquivo 
 * de properties e a um nome que abstraia o grupo de servi�os a que se refere.  
 * <p>Conforme este Singleton passa a ser utilizado, vai carregando as diversas propriedades dos m�dulos de 
 * neg�cios at� que em um momento tenha em cache todas as propriedades dos m�dulos por ele utilizados evitando
 * que a aplica��o fa�a muitas opera��es de IO em disco.
 * 
 * @author Rodrigo Morales (rodrigo@morales.com)
 *
 * @author Severino Bento Ferreira Junior (severino.ferreira@web2doctors.com)
 * @see http://www.web2doctors.com.br
 *
 * Severino Bento Ferreira Junior keeps the intellectual property of this source file.
 * Its usage can be made by all of the former customers without charge, including the modification of functionalities and design,
 * since this copyright note being maintained.
 *
 * (c) 2006 Severino Bento Ferreira Junior.
 * All rights reserved
 */
public class Propriedades {
	/** logger do Log4j para a classe **/
	private static Logger logger = Logger.getLogger(Propriedades.class);
	/** HashMap que ira conter todas as Properties requisitadas para o Singleton � o cache de properties **/
	private static Map<String, Properties> modulosPropriedades = new HashMap<String, Properties>();
	/** Inst�ncia �nica do Singleton **/
	private static Propriedades instancia = new Propriedades();

	/**
	 * Construtor privado para implementar o Pattern Singleton	 
	 */
	private Propriedades() {
	}

	/**
	 * Retorna a inst�ncia �nica do Singleton com LazyInstantiation 
	 * 
	 * @return Uma inst�ncia da Classe Propriedades
	 */
	public static Propriedades getInstancia() {
		if (instancia == null)
			instancia = new Propriedades();
		return instancia;
	}

	/**
	 * Retorna uma propriedade do modulo de propriedades, no formato da primitiva int 
	 *  
	 * @param chave String com o nome da chave a ser buscada
	 * @param modulo Nome do "m�dulo" de propriedades em que a chave ser� buscada
	 * @return Um int com o valor da propriedade a ser buscada no m�dulo
	 * @throws Exception 
	 */
	public static int getIntProperty(String chave, String modulo) throws NumberFormatException, IOException {
		return Integer.parseInt(getProperty(chave, modulo));
	}

	/**
	 * Retorna uma propriedade do modulo de propriedades, caso a propriedade n�o exista ou 
	 * o arquivo de propriedades n�o seja encontrada, retorna o valor default. 
	 * Como em caso de erros retorna sempre o valor Default, n�o h� exceptions sendo lan�adas 
	 * pelo m�todo. 
	 *  
	 * @param chave String com o nome da chave a ser buscada
	 * @param modulo Nome do "m�dulo" de propriedades em que a chave ser� buscada	  
	 * @param valorDefault valor defualt a ser retornado caso tenha problemas em encontrar a propriedade
	 */
	public static int getIntProperty(String chave, String modulo, int valorDefault) {		
		try {
			return Integer.parseInt(getProperty(chave, modulo, Integer.toString(valorDefault)));
		} catch (Exception e) {
			logger.debug("GetIntProperty: excecao retornada pelo m�dulo " + modulo + " na chave " + chave + ": " + e.getMessage());
			return valorDefault;
		} 
	}

	/**
	 * Retorna uma propriedade do modulo de propriedades 
	 *  
	 * @param chave String com o nome da chave a ser buscada
	 * @param modulo Nome do "m�dulo" de propriedades em que a chave ser� buscada
	 * @throws Exception 
	 */
	public static String getProperty(String chave, String modulo) throws IOException {
		Properties propriedades = (Properties) modulosPropriedades.get(modulo.toLowerCase());
		if (propriedades == null) {
			logger.debug("Adicionando as propriedades para o HashMap "+modulo.toLowerCase());
            propriedades = new PropriedadesFactory().carregaPropriedades(modulo.toLowerCase());
			modulosPropriedades.put(modulo.toLowerCase(), propriedades);
			return propriedades.getProperty(chave);
		} else {
			logger.debug("Propriedades j� adicionadas no HashMap "+modulo.toLowerCase());
			return propriedades.getProperty(chave);
		}
	}

	/**
	 * Retorna uma propriedade do modulo de propriedades, caso a propriedade n�o exista ou 
	 * o arquivo de propriedades n�o seja encontrada, retorna o valor default. 
	 * Como em caso de erros retorna sempre o valor Default, n�o h� exceptions sendo lan�adas 
	 * pelo m�todo. 
	 *  
	 * @param chave String com o nome da chave a ser buscada
	 * @param modulo Nome do "m�dulo" de propriedades em que a chave ser� buscada	  
	 */
	public static String getProperty(String chave, String modulo, String valorDefault) {
		try {
			Properties propriedades = (Properties) modulosPropriedades.get(modulo.toLowerCase());
			if (propriedades == null) {
				logger.debug("Adicionando as propriedades para o HashMap "+modulo.toLowerCase());
				propriedades = new PropriedadesFactory().carregaPropriedades(modulo.toLowerCase());
				modulosPropriedades.put(modulo.toLowerCase(), propriedades);
				return propriedades.getProperty(chave);
			} else {
				logger.debug("Propriedades j� adicionadas no HashMap "+modulo.toLowerCase());
				return propriedades.getProperty(chave);
			}
		} catch (IOException e) {
			logger.debug("excecao retornada pelo m�dulo " + modulo + " na chave " + chave + ": " + e.getMessage());
			return valorDefault;
		}
	}
	
	/**
	 * Retorna uma classe Properties relativa ao nome do modulo passado
	 *  
	 * @param modulo String com o nome do m�dulo a ser buscado
	 * @return Properties com as propriedades do m�dulo
	 * @throws IOException
	 */
	public Properties getProperties(String modulo) throws IOException {
		Properties propriedades = (Properties) modulosPropriedades.get(modulo.toLowerCase());
		if (propriedades == null) {
			logger.debug("Adicionando as propriedades para o HashMap"+modulo.toLowerCase());
			propriedades = new PropriedadesFactory().carregaPropriedades(modulo.toLowerCase());
			modulosPropriedades.put(modulo, propriedades);
			return propriedades;
		} else {
			logger.debug("propriedades j� presentes no HashMap"+modulo.toLowerCase());
			return propriedades;
		}
	}
}