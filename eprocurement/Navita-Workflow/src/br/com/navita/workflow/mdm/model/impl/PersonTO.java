/**
 * 
 */
package br.com.navita.workflow.mdm.model.impl;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.Email;
import br.com.navita.workflow.mdm.model.Gender;
import br.com.navita.workflow.mdm.model.Group;
import br.com.navita.workflow.mdm.model.MaritalStatus;
import br.com.navita.workflow.mdm.model.Person;
import br.com.navita.workflow.mdm.model.PersonalDocument;
import br.com.navita.workflow.mdm.model.ProductOrService;
import br.com.navita.workflow.mdm.model.Role;

/**
 * Um workflow típico é composto por pessoas (papéis), processos e políticas.
 * Esta classe implementa a interface Pessoa e atende ao primeiro ítem.
 * 
 * 
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class PersonTO extends BaseTO implements Person {
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = 9220641007968331264L;
	
	private Long id = null;
	
	private String idCompany = null;

	private KeyPair keyPair = null;
	
	private String name = null;
	
	private Gender gender = null;
	
	private MaritalStatus maritalStatus = null;
	
	private Calendar birthDate = null;
	
	private String UUID = null;
	
	private List<PersonalDocument> documents = null;
	
	private List<Email> emailAddresses = null;
	
	private List<ProductOrService> productsAndServices = null;
	
	private List<Role> roles = null;
	
	private List<Group> groups = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(String idCompany) {
		this.idCompany = idCompany;
	}

	public KeyPair getKeyPair() {
		return keyPair;
	}

	public void setKeyPair(KeyPair keyPair) {
		this.keyPair = keyPair;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public List<PersonalDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(List<PersonalDocument> documents) {
		this.documents = documents;
	}

	public List<Email> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(List<Email> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public List<ProductOrService> getProductsAndServices() {
		return productsAndServices;
	}

	public void setProductsAndServices(List<ProductOrService> productsAndServices) {
		this.productsAndServices = productsAndServices;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@Override
	public void addEmailAddress(Email anEmail) {
		if (emailAddresses == null)
			emailAddresses = new ArrayList<Email>();
		emailAddresses.add(anEmail);
		
	}

	@Override
	public void addGroup(Group aGroup) {
		if (groups == null)
			groups = new ArrayList<Group>();
		groups.add(aGroup);
		
	}

	@Override
	public void addRole(Role aRole) {
		if (roles==null)
			roles = new ArrayList<Role>();
		roles.add(aRole);
		
	}

	@Override
	public void addProductOrService(ProductOrService productorservice) {
		if (productsAndServices == null)
			productsAndServices = new ArrayList<ProductOrService>();
		productsAndServices.add(productorservice);
		
	}
		
}
