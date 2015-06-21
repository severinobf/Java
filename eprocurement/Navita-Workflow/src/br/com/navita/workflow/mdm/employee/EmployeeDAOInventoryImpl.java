/**
 * 
 */
package br.com.navita.workflow.mdm.employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import model.inventory.Employee;
import model.inventory.InventoryItem;

import org.apache.log4j.Logger;

import scala.Option;
import br.com.navita.inventory.consumer.InventoryConsumer;
import br.com.navita.inventory.service.EmployeeService;
import br.com.navita.inventory.service.InventoryItemService;
import br.com.navita.inventory.utils.PageWrapper;
import br.com.navita.inventory.utils.SearchRequest;
import br.com.navita.workflow.mdm.model.Email;
import br.com.navita.workflow.mdm.model.Person;
import br.com.navita.workflow.mdm.model.ProductOrService;
import br.com.navita.workflow.mdm.model.impl.DAOException;
import br.com.navita.workflow.mdm.model.impl.EmailTO;
import br.com.navita.workflow.mdm.model.impl.PersonTO;
import br.com.navita.workflow.mdm.model.impl.ProductOrServiceTO;

/**
 * Inplementation of the interface EmployeeDAO for backend services.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class EmployeeDAOInventoryImpl implements EmployeeDAO {
	
	//a logger for this class
	private final Logger logger = Logger.getLogger(EmployeeDAOInventoryImpl.class);

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.employee.EmployeeDAO#getEmployee(java.lang.String)
	 */
	@Override
	public Person getEmployee(Person person) throws DAOException {
		EmployeeService employeeService = InventoryConsumer.instantiateInventory(EmployeeService.class);
		Employee e = employeeService.getEmployee(person.getUUID());
		Email anEmail = new EmailTO();
		anEmail.setEmail(e.email().get());
		person.addEmailAddress(anEmail);
		person.setIdCompany(e.companyId().get().toString());
		logger.debug("returning person from backend services");
		return person;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.employee.EmployeeDAO#getDevices(java.lang.String)
	 */
	@Override
	public Person getDevices(Person person) throws DAOException {
		EmployeeService employeeService = InventoryConsumer.instantiateInventory(EmployeeService.class);
		InventoryItemService inventoryItemService = InventoryConsumer.instantiateInventory(InventoryItemService.class);
		Employee e = employeeService.getEmployee(person.getUUID());
		@SuppressWarnings("unchecked")
		Iterator<UUID> iterator = (Iterator<UUID>) e.inventoryItems().get().iterator();
		while (iterator.hasNext()) {
			InventoryItem ii = inventoryItemService.getInventoryItem(iterator.next().toString());
			ProductOrService ps = new ProductOrServiceTO();
			ps.setUUID(ii.id().get().toString());
			ps.setImei(ii.imei().get());
			ps.setModel(ii.model().get());
			ps.setName(ii.brand().get());
			ps.setDataSolicitacao(ii.registerDate().get().toCalendar(Locale.getDefault()));
			person.addProductOrService(ps);
		}
		return person;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.employee.EmployeeDAO#addDevice(java.lang.String, br.com.navita.workflow.mdm.model.ProductOrService)
	 */
	@Override
	public void addDevice(Person person, ProductOrService aDevice)
			throws DAOException {
		// TODO Auto-generated method stub

	}
	
	
	
	public static void main(String[] args) {
		Person aPerson = new PersonTO();
		aPerson.setUUID("f277de20-c405-11e4-9220-8f7251fd9065");
		EmployeeDAO dao = new EmployeeDAOInventoryImpl();
		try {
			@SuppressWarnings("unused")
			Person employee = dao.getEmployee(aPerson);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Person> getEmployeeStructure(Person aPerson) throws DAOException {
		EmployeeService employeeService = InventoryConsumer.instantiateInventory(EmployeeService.class);
		List<Person> ret = new ArrayList<Person>();
		Option<Object> start = Option.apply((Object) 0l); // página
		Option<Object> limit = Option.apply((Object) 50L);// quantidade por página
		Option<String> sort = Option.apply("asc");//sort
		String query = String.format("boss:\"%s\"", aPerson.getUUID()); // query que vai ser executado no elastic search no formato  campo1:valor-int,campo2:\"valor-string\" , ou seja campo e valor separado por (:) e quando precisar de mais de um parametro separar por (,). Obs campos string precisam ser escapados (\")
		PageWrapper<Employee> employeePageWrapper = employeeService.searchEmployee(new SearchRequest(query, start, limit, sort));
		// Page page = employeePageWrapper.page(); // retorno da busca
		// page.size(); // tamanho da página
		// page.totalElements(); // total de elementos
		// page.totalPages(); //total de páginas 
		Iterator<Employee> iterator = employeePageWrapper.content().iterator();
		while (iterator.hasNext()) {
			Employee e = iterator.next();
			Person p = new PersonTO();
			p.setIdCompany(e.companyId().get().toString());
			p.setName(e.name().get());
			p.setUUID(e.id().get().toString());
			Email anEmail = new EmailTO();
			anEmail.setEmail(e.email().get());
			p.addEmailAddress(anEmail);
			ret.add(p);
		}
		return ret;
	}

}
