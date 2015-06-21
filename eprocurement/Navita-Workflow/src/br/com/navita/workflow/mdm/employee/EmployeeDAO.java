/**
 * 
 */
package br.com.navita.workflow.mdm.employee;

import java.util.List;

import br.com.navita.workflow.mdm.model.Person;
import br.com.navita.workflow.mdm.model.ProductOrService;
import br.com.navita.workflow.mdm.model.impl.DAOException;

/**
 * Data access object for an Employee
 * Maps an Employee to a Person for workflow purposes.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface EmployeeDAO {
	
	/**
	 * gets an Employee from the backend services and uses data from there.
	 * There are some data used from backend, and other from local database.  This method is used to merge both
	 * 
	 * @param aPerson:Person a populated Person with local database data, that will be complemented.
	 * @return aPerson:Person populated object.
	 * @throws DAOException
	 */
	public Person getEmployee(Person aPerson) throws DAOException;
	
	/**
	 * gets all the devices owned by an Employee from the backend services.
	 * 
	 * @param aPerson:Person
	 * @return
	 * @throws DAOException
	 */
	public Person getDevices(Person aPerson) throws DAOException;
	
	/**
	 * adds a device in an employee record.
	 * @param uuID
	 * @param aDevice
	 * @throws DAOException
	 */
	public void addDevice(Person aPerson, ProductOrService aDevice) throws DAOException;
	
	/**
	 * gets all backseats of a given person.
	 * 
	 * @param aPerson
	 * @return
	 * @throws DAOException
	 */
	public List<Person> getEmployeeStructure(Person aPerson) throws DAOException;

}
