/**
 * 
 */
package br.com.navita.workflow.mdm.model;

import java.io.Serializable;

/**
 * A role is assigned to a person or group, determining rules in the workflow.
 * A role is mapped to an Authority in the database.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface Role extends Serializable {
	
	public abstract Long getID();
	
	public abstract void setID(Long ID);
	
	public abstract String getName();
	
	public abstract void setName(String name);
	
	public abstract String getDescription();
	
	public abstract void setDescription(String description);

}
