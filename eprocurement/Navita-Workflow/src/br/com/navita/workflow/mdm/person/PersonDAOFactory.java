/**
 * 
 */
package br.com.navita.workflow.mdm.person;

import org.apache.log4j.Logger;

import com.web2doctors.commons.properties.Propriedades;

/**
 * Returns the current implementation for PersonDAO interface.
 * @see PersonDAO
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class PersonDAOFactory {

	/** a logger for this class */
	private final Logger logger = Logger.getLogger(PersonDAOFactory.class);
	/** singleton instance to be returned */
	private static final PersonDAOFactory instance = new PersonDAOFactory();
	/** the implementation to be returned */
	private String implementation = null;
	/** possible values for the database **/
	private final String MYSQL = "MYSQL";
	@SuppressWarnings("unused")
	private final String LDAP = "LDAP";
	
	
	private PersonDAOFactory() {
		super();
		implementation = Propriedades.getProperty("persistencePerson", "navita", MYSQL);
		logger.debug("found implementation: " + implementation);
	}
	
	/**
	 * returns always the same instance of the class
	 * @return
	 */
	public static PersonDAOFactory getInstance() {
		return instance;
	}
	
	/**
	 * returns an implementation of PersonDAO
	 * @return
	 */
	public PersonDAO getimplementation() {
		if (implementation.equalsIgnoreCase(MYSQL))
			return new PersonDAOMySQLImpl();
		// other implementations here
		return null;
		
	}


}
