/*
 * Criado em Jun 8, 2004
 *
 */
package br.com.navita.workflow.mdm.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.web2doctors.commons.properties.Propriedades;

/**
 * Factory de Pools de conexao, este singleton busca no arquivo de propriedades o pool de connexao
 * que deve ser criado, podendo ele estar operando no servidor de aplicacoes JEE
 * ou o Pool de conexoes da Apache.org, para ser utilizado em aplicacoes swing ou StandAlone.<br>
 * Para o funcionamento correto da Factory, um arquivo de propriedades "navita.properties"
 * deve estar no ClassPath com a propriedade <code>tipo_conexao</code> no padrao:
 * <p><code>;para pool do servidor de aplicacao<br>tipo_conexao=1</code></p><br>  
 * <p><code>;para pool utilizando dbcp<br>tipo_conexao=2</code></p>
 * 
 * 
 * @author Rodrigo Morales
 * (c) 2015 Severino Bento Ferreira Junior. Todos os direitos reservados
 */
public class ConnectionPoolFactory {
    /** Logger do Log4j **/
    private static Logger logger = Logger.getLogger(ConnectionPoolFactory.class);
	/** contem a instancia do Singleton **/
	private static ConnectionPoolFactory connectionPoolFactory = new ConnectionPoolFactory();
	/** contem todos os pools de connexao ja criados, para fazer cache de pools **/
	private Map<String, ConnectionPool> connectionPool = new HashMap<String, ConnectionPool>();
	/** valor final que define se o pool utilizado esta no servidor JEE **/
	private final int POOL_SERVIDOR_JEE = 1;
	/** valor final que indica se o pool utilizado e local (jakarta dbcp **/
	private final int POOL_LOCAL = 2;
	/**
	 * Construtor privado para forcar o Pattern singleton	 	 
	 */
	private ConnectionPoolFactory() {
	}

	/**
	 * Retorna a instancia do Singleton
	 * 
	 * @return um ConnectionPoolFactory representando a instancia unica do Singleton
	 */
	public static ConnectionPoolFactory getInstance() {
		return connectionPoolFactory;
	}

	/**
	 * Fabrica o pool de conexao de acordo com o arquivo de propriedades, caso o pool ja tenha sido criado 
     * e esteja em cache, retorna o Pool para o cliente
	 * 
	 * @return um ConnectionPool de acordo com a propriedade lida
	 */
	public ConnectionPool getConnectionPool(String nomeDataSource) {
		ConnectionPool retorno = null;
		retorno = (ConnectionPool) connectionPool.get(nomeDataSource.toLowerCase()); 
		if (retorno != null) {
			return retorno;
		} else {
			/** fabricando o pool de conexoes **/			
			int tipoPool = Propriedades.getIntProperty("tipo_pool", "navita", 1);
			switch (tipoPool) {
				case POOL_SERVIDOR_JEE :
                    logger.debug("Criando um pool de conexoes J2EE");
					retorno = new JEEPool(nomeDataSource);
					break;
				case POOL_LOCAL :
                    logger.debug("Criando um pool de conexoes com JDBC");
					retorno = new DBCPool(nomeDataSource);
					break;
			}
			connectionPool.put(nomeDataSource.toLowerCase(), retorno);
			return retorno;
		}
	}

}
