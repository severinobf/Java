/*
 * Criado em Jun 8, 2004
 *
 */
package br.com.navita.workflow.mdm.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.web2doctors.commons.properties.Propriedades;

/**
 * Implementacao da Interface ConnectionPool para Pools de conexao utilizados em ambiente JEE,
 * 
 * @author Rodrigo Morales
 * (c) 2005 Severino Bento Ferreira Junior. Todos os direitos reservados
 */
public class JEEPool extends ConnectionPool {
	/** Logger do Log4J **/
	private transient static Logger logger = Logger.getLogger(JEEPool.class);

	private DataSource dataSource;

	public JEEPool(String nomeDataSource) {
		super(nomeDataSource);
		Context context = null;
		try {
			context = (Context) new InitialContext();
            String dsName = Propriedades.getProperty("data_source_jndi_prefix", "navita") + nomeDataSource;
            logger.debug("Tentando lookup o datasource " + dsName);			
			dataSource = (DataSource) context.lookup(dsName);
		} catch (NamingException e) {
			logger.error("Erro ao efetuar busca JNDI:",e);			
		} catch (IOException e) {
			logger.error("Erro ao efetuar busca de propriedades:",e);
		}
	}

	/**
	 * Retorna uma Connection do pool de conexao do servidor de aplicacoes 
	 * 
	 */
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
