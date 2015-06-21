/**
 * 
 */
package br.com.navita.workflow.mdm.model.impl;

import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.Role;

/**
 * Implementation of the interface Role as a Transfer Object.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class RoleTO extends BaseTO implements Role {

	private Long ID = null;
	
	private String name = null;
	
	private String description = null;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
