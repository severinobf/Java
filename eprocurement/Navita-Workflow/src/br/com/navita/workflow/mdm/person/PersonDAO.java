/**
 * 
 */
package br.com.navita.workflow.mdm.person;

import br.com.navita.workflow.mdm.model.Person;
import br.com.navita.workflow.mdm.model.impl.DAOException;

/**
 * DAO for a person in the Navita's integration
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface PersonDAO {
	
	/**
	 * returns an instance of Person from the backend database.
	 * 2015-06 -> Uses MySQL as the principal backend
	 * 2015-? -> LDAP planned.  TBD
	 * 
	 * @param userID
	 * @return
	 * @throws DAOException
	 */
	public abstract Person getPerson(String userID) throws DAOException;
	
	/**
	 * returns a lazy list of ProductsAndServices inside a Person from the backend database.
	 * 2015-06 -> Uses MySQL as the principal backend
	 * 
	 * @param userID
	 * @return
	 * @throws DAOException
	 */
	public abstract Person getProductsAndServices(String userID) throws DAOException;
	

}
