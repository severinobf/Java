/**
 * 
 */
package br.com.navita.workflow.mdm.tenant;

import java.util.UUID;

import br.com.navita.workflow.mdm.catalog.SkuTO;
import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.impl.CarrierTO;

/**
 * Parameters of a Tenant for the e-Procurement.
 * Defines which skus will be elegible for a person within given groups and with given roles.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class TenantEprocurementParametersTO extends BaseTO {
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = 8140847292334061737L;
	/* parameters belong for this tenant */
	private UUID tenantUUID = null;
	/* better use short names when importing parameters */
	private String tenantShortName = null;
	/* parameters should work for either role or group */
	private String roleName = null;
	/* parameters should work for either role or group */
	private String groupName = null;
	/* for which Carrier these parameters apply? */
	private CarrierTO carrier = null;
	/* what is the price of this sku */
	private Double price = null;
	/* how many days left for this sku commodatum */
	private Integer daysOfCommodatum = null;
	/* what is the remaining base price for this sku's commodatum */
	private Double basePriceForCommodatum = null;
	/* what is the current fine for exchange this sku */
	private Double fine = null;
	/* these devices should work for either a role or a group in eProcurement */
	private SkuTO sku = null;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public CarrierTO getCarrier() {
		return carrier;
	}
	public void setCarrier(CarrierTO carrier) {
		this.carrier = carrier;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
	public Double getFine() {
		return fine;
	}
	public void setFine(Double fine) {
		this.fine = fine;
	}
	public SkuTO getSku() {
		return sku;
	}
	public void setSku(SkuTO sku) {
		this.sku = sku;
	}
	public UUID getTenantUUID() {
		return tenantUUID;
	}
	public void setTenantUUID(UUID tenantUUID) {
		this.tenantUUID = tenantUUID;
	}
	public String getTenantShortName() {
		return tenantShortName;
	}
	public void setTenantShortName(String tenantShortName) {
		this.tenantShortName = tenantShortName;
	}

}
