/**
 * 
 */
package br.com.navita.workflow.mdm.catalog;

import java.util.Calendar;

import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.ProductOrServiceType;
import br.com.navita.workflow.mdm.model.impl.CarrierTO;

/**
 * Transfer Object para um produto no MDM Navita.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class SkuTO extends BaseTO {
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = 5597107007913997022L;

	private Long id = null;
	
	private String UUID = null;
	
	private String manufacturer = null;
	
	private String model = null;
	
	private String shortDescription = null;
	
	private String longDescription = null;
	
	private String technicalCharacteristics = null;
	
	private String warranty = null;
	
	private String dual = null;
	
	private String platform = null;
	
	private String urlThumbnail = null;
	
	private String urlImage = null;
	
	private ProductOrServiceType productType = null;
	/* what is the current price of this sku.  rule came from rules engine */
	private Double price = null;
	
	private Calendar lastModificationTime = null;
	
	private CarrierTO carrier = null;
	/* how many days left for this sku commodatum. rule came from rules engine */
	private Integer daysOfCommodatum = null;
	/* what is the remaining base price for this sku's commodatum.  rule came from rules engine */
	private Double basePriceForCommodatum = null;
	/* what is the current fine for exchange this sku.  rule came from rules engine */
	private Double fine = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrlThumbnail() {
		return urlThumbnail;
	}

	public void setUrlThumbnail(String urlThumbnail) {
		this.urlThumbnail = urlThumbnail;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getTechnicalCharacteristics() {
		return technicalCharacteristics;
	}

	public void setTechnicalCharacteristics(String technicalCharacteristics) {
		this.technicalCharacteristics = technicalCharacteristics;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public ProductOrServiceType getProductType() {
		return productType;
	}

	public void setProductType(ProductOrServiceType productType) {
		this.productType = productType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Calendar getLastModificationTime() {
		return lastModificationTime;
	}

	public void setLastModificationTime(Calendar lastModificationTime) {
		this.lastModificationTime = lastModificationTime;
	}

	public CarrierTO getCarrier() {
		return carrier;
	}

	public void setCarrier(CarrierTO carrier) {
		this.carrier = carrier;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDual() {
		return dual;
	}

	public void setDual(String dual) {
		this.dual = dual;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
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


}
