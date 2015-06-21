/**
 * 
 */
package br.com.navita.workflow.mdm.model.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.Group;
import br.com.navita.workflow.mdm.model.Person;
import br.com.navita.workflow.mdm.model.Role;

/**
 * Implementation of the Group interface in a Transfer Object.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class GroupTO extends BaseTO implements Group {

	/**
	 * generated
	 */
	private static final long serialVersionUID = 1L;

	private Long ID = null;
	
	private String description = null;
	
	private List<Role> roles = null;
	
	private List<Person> people = null;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void addRole(Role aRole) {
		if (this.roles == null)
			roles = new ArrayList<Role>();
		roles.add(aRole);
	}

	public List<Person> getPeople() {
		return people;
	}

	public void addPerson(Person aPerson) {
		if (this.people == null)
			people = new ArrayList<Person>();
		people.add(aPerson);
	}
	
	
}
