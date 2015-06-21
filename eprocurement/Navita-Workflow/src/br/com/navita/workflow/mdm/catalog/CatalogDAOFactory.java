/**
 * 
 */
package br.com.navita.workflow.mdm.catalog;

import org.apache.log4j.Logger;

import com.web2doctors.commons.properties.Propriedades;

/**
 * returns the current implementation of CatalogDAO
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class CatalogDAOFactory {
	
	/** a logger for this class */
	private final Logger logger = Logger.getLogger(CatalogDAOFactory.class);
	/** singleton instance to be returned */
	private static final CatalogDAOFactory instance = new CatalogDAOFactory();
	/** the implementation to be returned */
	private String implementation = null;
	/** possible values for the database **/
	@SuppressWarnings("unused")
	private final String INVENTORY = "INVENTORY";
	private final String MYSQL = "MYSQL";
	
	
	private CatalogDAOFactory() {
		super();
		implementation = Propriedades.getProperty("persistenceCatalog", "navita", MYSQL);
		logger.debug("found implementation: " + implementation);
	}
	
	/**
	 * returns always the same instance of the class
	 * @return
	 */
	public static CatalogDAOFactory getInstance() {
		return instance;
	}
	
	/**
	 * returns an implementation of CatalogDAO
	 * @return
	 */
	public CatalogDAO getimplementation() {
		if (implementation.equalsIgnoreCase(MYSQL))
			return new CatalogDAOMySQLImpl();
		//else if (implementation.equalsIgnoreCase(INVENTORY))
		//return new CatalogDAOInventoryImpl();
		// defaults to null
		else return null;
		
	}

}
