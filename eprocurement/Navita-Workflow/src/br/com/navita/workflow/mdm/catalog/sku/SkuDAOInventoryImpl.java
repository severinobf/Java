/**
 * 
 */
package br.com.navita.workflow.mdm.catalog.sku;

import java.util.List;

import br.com.navita.workflow.mdm.catalog.SkuTO;
import br.com.navita.workflow.mdm.model.impl.DAOException;

/**
 * Implementation of SkuDAO for Inventory.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class SkuDAOInventoryImpl implements SkuDAO {

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.catalog.sku.SkuDAO#addSku(br.com.navita.workflow.mdm.catalog.SkuTO)
	 */
	@Override
	public void addSku(SkuTO aSku) throws DAOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.catalog.sku.SkuDAO#getSku(java.lang.Long)
	 */
	@Override
	public SkuTO getSku(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.catalog.sku.SkuDAO#getSkus(br.com.navita.workflow.mdm.catalog.SkuTO)
	 */
	@Override
	public List<SkuTO> getSkus(SkuTO parameters) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SkuTO getByModel(String model) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
