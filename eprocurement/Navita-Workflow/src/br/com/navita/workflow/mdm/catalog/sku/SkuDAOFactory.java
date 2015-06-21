/**
 * 
 */
package br.com.navita.workflow.mdm.catalog.sku;

import org.apache.log4j.Logger;

import com.web2doctors.commons.properties.Propriedades;

/**
 * returns the current implementation for SkuDAO.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class SkuDAOFactory {

	/** a logger for this class */
	private final Logger logger = Logger.getLogger(SkuDAOFactory.class);
	/** singleton instance to be returned */
	private static final SkuDAOFactory instance = new SkuDAOFactory();
	/** the implementation to be returned */
	private String implementation = null;
	/** possible values for the database **/
	private final String INVENTORY = "INVENTORY";
	private final String MYSQL = "MYSQL";
	
	
	private SkuDAOFactory() {
		super();
		implementation = Propriedades.getProperty("persistenceSku", "navita", MYSQL);
		logger.debug("found implementation: " + implementation);
	}
	
	/**
	 * returns always the same instance of the class
	 * @return
	 */
	public static SkuDAOFactory getInstance() {
		return instance;
	}
	
	/**
	 * returns an implementation of SkuDAO
	 * @return
	 */
	public SkuDAO getimplementation() {
		if (implementation.equalsIgnoreCase(INVENTORY))
			return new SkuDAOInventoryImpl();
		else if (implementation.equalsIgnoreCase(MYSQL))
			return new SkuDAOMySQLImpl();
		// defaults to null
		else return null;
		
	}
}
