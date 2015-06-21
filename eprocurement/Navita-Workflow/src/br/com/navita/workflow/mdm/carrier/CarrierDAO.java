/**
 * 
 */
package br.com.navita.workflow.mdm.carrier;

import java.util.List;

import br.com.navita.workflow.mdm.model.impl.CarrierTO;
import br.com.navita.workflow.mdm.model.impl.DAOException;

/**
 * DAO for Carriers in Navita eprocurement's system.
 * 
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface CarrierDAO {
	
	/**
	 * gets a Carrier from the default database.
	 * 
	 * @param shortName
	 * @return
	 * @throws DAOException
	 */
	public abstract CarrierTO getCarrier(String shortName) throws DAOException;
	
	/**
	 * gets all carriers from the default database.
	 * @return
	 * @throws DAOException
	 */
	public abstract List<CarrierTO> getAll() throws DAOException;

}
