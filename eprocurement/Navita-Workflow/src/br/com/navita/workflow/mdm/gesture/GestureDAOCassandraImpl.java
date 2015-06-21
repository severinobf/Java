/**
 * 
 */
package br.com.navita.workflow.mdm.gesture;

import org.apache.log4j.Logger;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;

/**
 * Implementação da persistência de gestos para a base NoSQL Cassandra.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class GestureDAOCassandraImpl extends AbstractCassandraDAOImpl implements GestureDAO {
	
	private final Logger logger = Logger.getLogger(GestureDAOCassandraImpl.class);
	
	private final String insertGesto = "insert into NAVITA_GESTOS.GESTOS (descricao_produto, estado_civil, datahora, sexo, idade, id_produto, papel, descricao_gesto values (?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public void insereGesto(GestureTO umGesto) throws GestureException {
		 	PreparedStatement ps = null;
		    Session session = null;
			try {
				session = getSession();
				ps = session.prepare(insertGesto);
				BoundStatement bs = new BoundStatement(ps);
				bs.bind(umGesto.getProductOrServicedescription());
				bs.bind(umGesto.getMaritalStatus());
				bs.bind(sdf.format(umGesto.getEventHour()));
				bs.bind(umGesto.getGender().name());
				bs.bind(umGesto.getAge());
				bs.bind(umGesto.getProductOrServiceID());
				bs.bind(umGesto.getRole());
				session.execute(bs);
			} catch (Exception e) {
				logger.error("Erro executando um PreparedStatement: " + insertGesto);
				throw new GestureException("Erro ao executar uma insercao em dados");
			} finally {
				if (session != null)
					session.close();
			}
	}
	
	

}
