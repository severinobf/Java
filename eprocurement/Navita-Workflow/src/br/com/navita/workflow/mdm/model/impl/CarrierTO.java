/**
 * 
 */
package br.com.navita.workflow.mdm.model.impl;

import java.util.ArrayList;
import java.util.Collection;

import br.com.navita.workflow.mdm.model.AbstractCompanyTO;
import br.com.navita.workflow.mdm.model.Email;

/**
 * Defines a carrier for the Navita's workflow.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class CarrierTO extends AbstractCompanyTO {
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = 3302928900608641427L;

	private Email integrationEmailAddress = null;
	
	private String integrationServicesURL = null;
	
	private Collection<ProductOrServiceParameterTO> parameters = null;

	public Email getIntegrationEmailAddress() {
		return integrationEmailAddress;
	}

	public void setIntegrationEmailAddress(Email integrationEmailAddress) {
		this.integrationEmailAddress = integrationEmailAddress;
	}

	public String getIntegrationServicesURL() {
		return integrationServicesURL;
	}

	public void setIntegrationServicesURL(String integrationServicesURL) {
		this.integrationServicesURL = integrationServicesURL;
	}
	
	public Collection<ProductOrServiceParameterTO> getParameters() {
		return parameters;
	}

	public void setParameters(Collection<ProductOrServiceParameterTO> parameters) {
		this.parameters = parameters;
	}
	
	public void addParameter(ProductOrServiceParameterTO parameter) {
		if (parameters == null)
			parameters = new ArrayList<ProductOrServiceParameterTO>();
		parameters.add(parameter);
	}

}
