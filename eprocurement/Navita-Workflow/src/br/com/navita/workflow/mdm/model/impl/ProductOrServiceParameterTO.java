/**
 * 
 */
package br.com.navita.workflow.mdm.model.impl;

import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.ProductOrService;

/**
 * This bean is used to back configurations of Carriers and Tenants.
 * Each tenant has a price for a product or a service from a Carrier.
 * Each tenant has a fine policy for each product in case of termination of contract
 * with the final user.
 * 
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class ProductOrServiceParameterTO extends BaseTO {
	
	/**
	 * generated.
	 */
	private static final long serialVersionUID = -4005676064078721340L;

	private ProductOrService productOrService = null;
	
	private Double price = null;
	
	private Double fine = null;
	
	private Integer daysOfCommodatum = null;
	
	private Double basePriceForCommodatum = null;

	public ProductOrService getProductOrService() {
		return productOrService;
	}

	public void setProductOrService(ProductOrService productOrService) {
		this.productOrService = productOrService;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getFine() {
		return fine;
	}

	public void setFine(Double fine) {
		this.fine = fine;
	}

	public Integer getDaysOfCommodatum() {
		return daysOfCommodatum;
	}

	public void setDaysOfCommodatum(Integer daysOfCommodatum) {
		this.daysOfCommodatum = daysOfCommodatum;
	}

	public Double getBasePriceForCommodatum() {
		return basePriceForCommodatum;
	}

	public void setBasePriceForCommodatum(Double basePriceForCommodatum) {
		this.basePriceForCommodatum = basePriceForCommodatum;
	}

}
