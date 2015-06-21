/*
 * Criado em Jun 8, 2004
 *
 */
package br.com.navita.workflow.mdm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.web2doctors.commons.properties.Propriedades;
/**
 * Define o contrato de utilizacao para o Pool de conexoes.
 * Possui metodos de finalizacao de estruturas JDBC, que devem ser utilizadas nas classes 
 * que fizerem uso do Pool de conexoes.
 * Para que o pool de conexoes funcione, o arquivo de propriedades <code>navita.properties</code>
 * deve estar no Path, no seguinte padrao:
 * 
 * 
 * @author Rodrigo Morales
 * (c) 2015 Severino Bento Ferreira Junior. Todos os direitos reservados
 */
public abstract class ConnectionPool {
	/** Logger do Log4j para a classe **/
	private Logger logger = Logger.getLogger(ConnectionPool.class);
	/** Nome do DataSource que sera utilizado **/
	protected String nomeDataSource;
	/** Driver JDBC que sera utilizado **/
	protected String driver;
	/** URL de conexao do driver **/
	protected String url;
	/** nome do usuario do banco de dados **/
	protected String usuario;
	/** senha do usuario do banco de dados **/
	protected String senha;
	/** DataSource para a criacao de conexoes **/
	protected DataSource dataSource;

	/**
	 * Construtor da classe Abstrata que somente define o nome do DataSource e carrega as propriedades 
	 * de conex�o do Driver JDBC
	 * 
	 * @param nomeDataSource nome do DataSource para o Pool de conex�es
	 */
	public ConnectionPool(String nomeDataSource) {
		this.nomeDataSource = nomeDataSource;
		driver = Propriedades.getProperty("jdbc_driver." + nomeDataSource, "navita", "");
		url = Propriedades.getProperty("url." + nomeDataSource, "navita", "");
		usuario = Propriedades.getProperty("usuario." + nomeDataSource, "navita", "");
		senha = Propriedades.getProperty("senha." + nomeDataSource, "navita", "");
	}

	public abstract Connection getConnection() throws SQLException;

	/**
	 * Fecha um Statement e uma Connection
	 * 
	 * @param statement o Statement a ser fechado
	 * @param conn uma Connection a ser fechada
	 */
	public void close(Statement statement, Connection conn) {
		try {
			statement.close();
		} catch (SQLException e) {
			logger.error("Erro ao fechar o Statement:", e);
		}
		try {
			conn.close();
		} catch (SQLException e) {
			logger.error("Erro ao fechar conexao:", e);
		}
	}

	/**
	 * Fecha um Statement e um ResultSet
	 * 
	 * @param statement o Statement a ser fechado
	 * @param conn uma Connection a ser fechada
	 */
	public void close(Statement statement, ResultSet resultSet) {
		try {
			statement.close();
		} catch (SQLException e) {
			logger.error("Erro ao fechar o Statement:", e);
		}
		try {
			resultSet.close();
		} catch (SQLException e) {
			logger.error("Erro ao fechar ResultSet:", e);
		}
	}

	/**
	 * Fecha um Statement um ResultSet e uma conexao JDBC
	 * 
	 * @param statement um Statement a ser fechado
	 * @param resultSet um ResultSet a ser fechado
	 * @param conn a Connection a ser fechada
	 */
	public void close(Statement statement, ResultSet resultSet, Connection conn) {
		try {
			statement.close();
		} catch (SQLException e) {
			logger.error("Erro ao fechar o ResultSet:", e);
		}
		try {
			resultSet.close();
		} catch (SQLException e) {
			logger.error("Erro ao fechar o ResultSet:", e);
		}
		try {
			conn.close();
		} catch (SQLException e) {
			logger.error("Erro ao fechar conexao:", e);
		}
	}

	/**
	 * Fecha um Statement
	 * 
	 * @param statement o Statement a ser fechado
	 */
	public void close(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			logger.error("Erro ao fechar o ResultSet:", e);
		}
	}

	/**
	 * Fecha um ResultSet
	 * 
	 * @param resultSet o ResultSet a ser fechado
	 */
	public void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			logger.error("Erro ao fechar o ResultSet:", e);
		}
	}

	/**
	 * Fecha uma conexao JDBC
	 * 
	 * @param conn uma Connection a ser fechada
	 */
	public void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			logger.error("Erro ao fechar conexao:", e);
		}
	}

}
