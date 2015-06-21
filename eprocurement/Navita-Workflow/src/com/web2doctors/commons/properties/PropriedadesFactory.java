/*
 * Criada em Maio 13, 2004
 *
 */
package com.web2doctors.commons.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Classe respons�vel pela cria��o de inst�ncias da classe Properties de acordo com o nome 
 * do m�dulo requisitado.
 * Foi utilizado o Pattern Factory, embora sem os contratos de interface para simplificar o design, 
 * para o caso de podermos variar o processo de cria��o da Classe Properties, nesse caso inicial
 * utilizamos a cria��o por meio de arquivos de propriedades, mas podemos passar a carregar de
 * um banco de dados, ou mesmo de um servidor LDAP.  
 * 
 * Para carregar os arquivos vamos utilizar o classloader, pois desse modo o arquivo � carregado 
 * com a aplica��o estando ou n�o em um jar, ear ou war, de modo transparente.
 * 
 * @author Rodrigo Morales (rodrigo@morales.com)
 *
 * @author Severino Bento Ferreira Junior (severino.ferreira@web2doctors.com.br)
 * @see http://www.web2doctors.com.br
 *
 * Severino Bento Ferreira Junior keeps the intellectual property of this source file.
 * Its usage can be made by all of the former customers without charge, including the modification of functionalities and design,
 * since this copyright note being maintained.
 *
 * (c) 2006 Severino Bento Ferreira Junior.
 * All rights reserved
 */
public class PropriedadesFactory {
    
	private transient Logger logger = Logger.getLogger(PropriedadesFactory.class);
    
    /** 
	 * Carrega todas as propriedades de um "m�dulo" passado por par�metro, o m�dulo � o nome do 
	 * arquivo de propriedades que ser� carregado, e depende do sistema que estiver utilizando o 
	 * componente de propriedades
	 * 
	 * @param modulo String com o nome do arquivo de propriedades que ser� carregado
	 * @return Properties carregado de uma fonte de propriedades
	 * @throws Exception com a Exception caso ocorra erro ao carregar as propriedades
	 */
	public Properties carregaPropriedades(String modulo) throws IOException {
	    
		Properties propriedades = new Properties();
		logger.debug("Tentando encontrar recurso " + modulo + " pela classe");
		InputStream is =  this.getClass().getResourceAsStream("/" + modulo + ".properties");
		if (is == null) {
			logger.debug("recurso nulo.  Tentando delegar para o classloader");
			is = this.getClass().getClassLoader().getResourceAsStream("/" + modulo + ".properties");
		}
		if (is == null)
			logger.debug("recurso " + modulo + " n�o encontrado");
		else {
			propriedades.load(is);
			is.close();
		}
		return propriedades;
	}
	
}
