/*
 * Criado em Jun 8, 2004
 *
 */
package br.com.navita.workflow.mdm.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import com.web2doctors.commons.properties.Propriedades;

/**
 * Pool de conexoes utilizando o DBCP (DataBase Connection Pool) do grupo Jakarta
 * Somente utiliza o BasicDataSource do DBCP e carrega as propriedades do Pool 
 * de um arquivo de propriedades <code>dbcp.properties</code> sendo que as propriedades
 * sao:<br>
 * <p><br>;indica quantas conexoes serao criadas inicialmente no pool<br>tamanho_inicial=10 </p>
 * <p><br>;indica o maximo de conexoes que serao criadas no pool <br>max_conexoes_ativas=100 </p>
 * <p><br>;indica o maximo de conexoes que podem ficar inativas sem que o pool as feche <br>max_conexoes_inativas=10 </p>
 * 
 * 2015: Atualizacao para DBCP 2 EM JDK 7.
 * 
 * @author Rodrigo Morales
 * (c) 2015 Severino Bento Ferreira Junior. Todos os direitos reservados
 */
public class DBCPool extends ConnectionPool {

	private BasicDataSource basicDataSource;

	public DBCPool(String nomeDataSource) {
		super(nomeDataSource);
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUsername(usuario);
		basicDataSource.setPassword(senha);
		basicDataSource.setUrl(url);
		basicDataSource.setInitialSize(Propriedades.getIntProperty("tamanho_inicial." + nomeDataSource, "navita", 2));
		basicDataSource.setMaxTotal(Propriedades.getIntProperty("max_conexoes_ativas." + nomeDataSource, "navita", 10));
		basicDataSource.setMaxIdle(Propriedades.getIntProperty("max_conexoes_inativas." + nomeDataSource, "navita", 5));
	}

	/**
	 * Retorna uma conexao com o banco de dados utilizando o Pool de conecoes DBCP do projeto jakarta.
	 *  
	 */
	public Connection getConnection() throws SQLException {
		return basicDataSource.getConnection();
	}
}
