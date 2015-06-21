/**
 * 
 */
package br.com.navita.workflow.mdm.carrier;

import org.apache.log4j.Logger;

import com.web2doctors.commons.properties.Propriedades;

/**
 * returns the current default implementation of CarrierDAO.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class CarrierDAOFactory {
	
	/** a logger for this class */
	private final Logger logger = Logger.getLogger(CarrierDAOFactory.class);
	/** singleton instance to be returned */
	private static final CarrierDAOFactory instance = new CarrierDAOFactory();
	/** the implementation to be returned */
	private String implementation = null;
	/** possible values for the database **/
	private final String INVENTORY = "INVENTORY";
	@SuppressWarnings("unused")
	private final String MYSQL = "MYSQL";
	
	
	private CarrierDAOFactory() {
		super();
		implementation = Propriedades.getProperty("persistenceCarrier", "navita", INVENTORY);
		logger.debug("found implementation: " + implementation);
	}
	
	/**
	 * returns always the same instance of the class
	 * @return
	 */
	public static CarrierDAOFactory getInstance() {
		return instance;
	}
	
	/**
	 * returns an implementation of CarrierDAO
	 * @return
	 */
	public CarrierDAO getimplementation() {
		if (implementation.equalsIgnoreCase(INVENTORY))
			return new CarrierDAOInventoryImpl();
		// other implementations here
		return null;
		
	}

}
