/**
 * 
 */
package br.com.navita.workflow.mdm.gesture;

import java.text.SimpleDateFormat;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.web2doctors.commons.properties.Propriedades;

/**
 * Provê métodos comuns a todas as implementações para Cassandra.
 * 
 * @author Severino Bento Ferreira Junior (severino.ferreira@adtsys.com.br)
 *
 */
public abstract class AbstractCassandraDAOImpl {
	
	private final Logger logger = Logger.getLogger(AbstractCassandraDAOImpl.class);

	private Cluster cluster = null;
	
	private String node = Propriedades.getProperty("hostCassandra", "configuracoes", "127.0.0.1");
	
	protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm");
	
	private void connect(String node) {
		cluster = Cluster.builder().addContactPoint(node).build();
		if (logger.isDebugEnabled()) {
			Metadata metadata = cluster.getMetadata();
			if (logger.isDebugEnabled()) {
				logger.debug("CASSANDRA: Conectado ao cluster: " + metadata.getClusterName());
				for (Host host : metadata.getAllHosts()) {
					StringBuilder sb = new StringBuilder("CASSANDRA: Datacenter: ").append(host.getDatacenter()).append(" address: ").append(host.getAddress()).append(" rack: ").append(host.getRack());
					logger.debug(sb.toString());
				}
			}
		}
	}

	@SuppressWarnings("unused")
	private void close() {
		if (cluster != null)
			cluster.close();
	}
	
	protected Session getSession() {
		if (cluster == null)
			connect(node);
		return cluster.connect();
	}
	
	protected String getUID() {
		return UUID.randomUUID().toString();
	}

}
