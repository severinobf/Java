/**
 * 
 */
package br.com.navita.workflow.mdm.model;

import java.util.UUID;

/**
 * Describes the basic characterists of a company for the Navita's workflow.
 * 
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public abstract class AbstractCompanyTO extends BaseTO {
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = -6377278159123362430L;

	protected String name = null;
	
	protected Long id = null;
	
	protected UUID uuid = null;
	
	protected String shortName = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	

}
