/**
 * 
 */
package br.com.navita.workflow.mdm.process.procurement;

import java.util.List;

import br.com.navita.workflow.mdm.catalog.CatalogTO;
import br.com.navita.workflow.mdm.catalog.SkuTO;
import br.com.navita.workflow.mdm.model.Gesture;
import br.com.navita.workflow.mdm.model.Person;

/**
 * Facade for procurement processes.
 * Implementations of this interface will also be exposed as services: RESTFUL and others, on demand.
 * 
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface ProcurementFacade {
	
	/**
	 * checks out a shopping cart, and inserts a process in the backend.
	 * this will end a stateful cycle.
	 * 
	 * @param aSolicitacao
	 * @return
	 * @throws ProcurementException
	 */
	public abstract ProcurementTO checkout(ShoppingCartTO carrinho) throws ProcurementException;
	
	/**
	 * gets a catalog from the backend according to the person's roles, privileges and groups.
	 * A manager can call a procurement for her backseats.
	 * 
	 *  
	 * @see "Solicitar_Dispositivo.doc e outros documentos associados a requisitos e regras de negócio"
	 *  
	 * 
	 * @return
	 * @throws ProcurementException com a mensagem de erro referente às regras de negócio FA*
	 */
	public abstract CatalogTO getCatalog(Person finalReceiver) throws ProcurementException;
	
	/**
	 * Adds a Sku to the shopping cart.
	 * This method also adds a gesture to a NoSQL database.
	 * 
	 *  
	 * @see "Solicitar_Dispositivo.doc e outros documentos associados a requisitos e regras de negócio"
	 * @param umProduto
	 * @throws ProcurementException
	 */
	public abstract void addItemToCart(ShoppingCartTO cart, SkuTO sku, Gesture theGesture) throws ProcurementException;
	
	/**
	 * removes a sku from shopping cart.
	 * this method also adds a gesture to a NoSQL database.
	 * 
	 * @param carrinho
	 * @param umItem
	 * @param oGesto
	 * @throws ProcurementException
	 */
	public abstract void removeItemFromCart(ShoppingCartTO cart, SkuTO sku, Gesture theGesture) throws ProcurementException;
	
	/**
	 * adds a gesture to a NoSQL database.
	 * 
	 * @see Gesture
	 * @param umItem
	 * @param oGesto
	 * @throws ProcurementException
	 */
	public abstract void addGesture(Person aPerson, SkuTO sku, Gesture theGesture) throws ProcurementException;
	
	/**
	 * returns all Person's backseats.
	 * People can begin a procurement process for all their backseats.
	 * 
	 * @param aPessoa
	 * @return
	 * @throws ProcurementException
	 */
	public abstract List<Person> getBackseats(Person aPerson) throws ProcurementException;

}
