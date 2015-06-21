/**
 * 
 */
package br.com.navita.workflow.mdm.carrier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.inventory.Carrier;
import br.com.navita.inventory.consumer.InventoryConsumer;
import br.com.navita.inventory.service.CarrierService;
import br.com.navita.inventory.utils.PageWrapper;
import br.com.navita.workflow.mdm.model.impl.CarrierTO;
import br.com.navita.workflow.mdm.model.impl.DAOException;

/**
 * Implementation of CarrierDAO for Navita's inventory services.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class CarrierDAOInventoryImpl implements CarrierDAO {

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.carrier.CarrierDAO#getCarrier(java.lang.String)
	 */
	@Override
	public CarrierTO getCarrier(String shortName) throws DAOException {
		CarrierService CarrierService = InventoryConsumer.instantiateInventory(CarrierService.class);
		Carrier e = CarrierService.getCarrier(shortName);
		CarrierTO carrier = new CarrierTO();
		carrier.setUuid(e.id().get());
		carrier.setName(e.name().get());
		carrier.setShortName(e.name().get());
		return carrier;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.carrier.CarrierDAO#getAll()
	 */
	@Override
	public List<CarrierTO> getAll() throws DAOException {
		List<CarrierTO> ret = new ArrayList<CarrierTO>();
		CarrierService CarrierService = InventoryConsumer.instantiateInventory(CarrierService.class);
		int start = 1;
		int limit = 50;
		String sort = "asc";
		PageWrapper<Carrier> CarrierPageWrapper = CarrierService.findAllCarrier(start, limit, sort);
		Iterator<Carrier> iterator = CarrierPageWrapper.content().iterator();
		while (iterator.hasNext()) {
			Carrier e = iterator.next();
			CarrierTO to = new CarrierTO();
			to.setUuid(e.id().get());
			to.setName(e.name().get());
			ret.add(to);
		}
		return ret;
	}

}
