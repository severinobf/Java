/**
 * 
 */
package br.com.navita.workflow.mdm.catalog.sku;

import java.util.List;

import br.com.navita.workflow.mdm.catalog.SkuTO;
import br.com.navita.workflow.mdm.model.impl.DAOException;

/**
 * DAO for Sku.
 * Defines database operations for a SKU.
 * 
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface SkuDAO {
	
	/**
	 * adds a Sku to the database
	 * 
	 * @param aSku
	 * @throws DAOException
	 */
	public abstract void addSku(SkuTO aSku) throws DAOException;
	
	/**
	 * gets a Sku by ID
	 * 
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public abstract SkuTO getSku(Long id) throws DAOException;
	
	/**
	 * returns a List of SkuTO according to given parameters.
	 * 
	 * @param parameters
	 * @return
	 * @throws DAOException
	 */
	public abstract List<SkuTO> getSkus(SkuTO parameters) throws DAOException;
	
	/**
	 * gets a sku by its model.
	 * 
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public abstract SkuTO getByModel(String model) throws DAOException;

}
