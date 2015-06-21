/**
 * 
 */
package br.com.navita.workflow.mdm.model;

import java.io.Serializable;
import java.util.List;

/**
 * A group is a collection of people that has a unique role in a workflow.
 * @see Person
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface Group extends Serializable {
	
	public abstract Long getID();
	
	public abstract void setID(Long id);
	
	public abstract String getDescription();
	
	public abstract void setDescription(String descricao);
	
	public abstract List<Person> getPeople();
	
	public abstract void addRole(Role aRole);
	
	public abstract List<Role> getRoles();
	
	/**
	 * adiciona uma pessoa a este grupo.
	 * @param umaPessoa
	 */
	public abstract void addPerson(Person umaPessoa);

}
