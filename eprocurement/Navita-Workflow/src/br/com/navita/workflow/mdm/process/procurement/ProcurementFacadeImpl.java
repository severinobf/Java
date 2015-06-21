/**
 * 
 */
package br.com.navita.workflow.mdm.process.procurement;

import java.util.List;

import br.com.navita.workflow.mdm.catalog.CatalogDAO;
import br.com.navita.workflow.mdm.catalog.CatalogDAOFactory;
import br.com.navita.workflow.mdm.catalog.CatalogTO;
import br.com.navita.workflow.mdm.catalog.SkuTO;
import br.com.navita.workflow.mdm.model.Gesture;
import br.com.navita.workflow.mdm.model.Person;
import br.com.navita.workflow.mdm.model.impl.DAOException;

/**
 * Implementacao POJO da interface SolicitacaoFacade
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class ProcurementFacadeImpl implements ProcurementFacade {

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.process.solicitacoes.SolicitacaoFacade#checkout()
	 */
	@Override
	public ProcurementTO checkout(ShoppingCartTO carrinho) throws ProcurementException {
		/**
		 * 
		 */
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.process.solicitacoes.SolicitacaoFacade#getCatalogo(br.com.navita.workflow.mdm.model.Pessoa)
	 */
	@Override
	public CatalogTO getCatalog(Person finalReceiver) throws ProcurementException {
		CatalogDAO catalogDAO = CatalogDAOFactory.getInstance().getimplementation();
		try {
			return catalogDAO.getCatalog(finalReceiver);
		} catch (DAOException daoe) {
			throw new ProcurementException(daoe.getMessage());
		}
	}

	@Override
	public void addItemToCart(ShoppingCartTO carrinho, SkuTO sku, Gesture oGesto) throws ProcurementException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGesture(Person aPessoa, SkuTO sku, Gesture oGesto) throws ProcurementException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Person> getBackseats(Person aPessoa) throws ProcurementException {
		return null;
	}

	@Override
	public void removeItemFromCart(ShoppingCartTO cart, SkuTO sku,	Gesture theGesture) throws ProcurementException {
		// TODO Auto-generated method stub
		
	}

}
