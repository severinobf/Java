/**
 * 
 */
package br.com.navita.workflow.mdm.employee;

import org.apache.log4j.Logger;

import com.web2doctors.commons.properties.Propriedades;

/**
 * returns the right instance of EmployeeDAO
 * @see EmployeeDAO
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class EmployeeDAOFactory {

	/** a logger for this class */
	private final Logger logger = Logger.getLogger(EmployeeDAOFactory.class);
	/** singleton instance to be returned */
	private static final EmployeeDAOFactory instance = new EmployeeDAOFactory();
	/** the implementation to be returned */
	private String implementation = null;
	/** possible values for the database **/
	private final String INVENTORY = "INVENTORY";
	@SuppressWarnings("unused")
	private final String MYSQL = "MYSQL";
	
	
	private EmployeeDAOFactory() {
		super();
		implementation = Propriedades.getProperty("persistenceEmployee", "navita", INVENTORY);
		logger.debug("found implementation: " + implementation);
	}
	
	/**
	 * returns always the same instance of the class
	 * @return
	 */
	public static EmployeeDAOFactory getInstance() {
		return instance;
	}
	
	/**
	 * returns an implementation of EmployeeDAO
	 * @return
	 */
	public EmployeeDAO getimplementation() {
		if (implementation.equalsIgnoreCase(INVENTORY))
			return new EmployeeDAOInventoryImpl();
		// other implementations here
		return null;
		
	}


}
