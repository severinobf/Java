/**
 * 
 */
package br.com.navita.workflow.mdm.model;

import java.io.Serializable;
import java.security.KeyPair;
import java.util.Calendar;
import java.util.List;

/**
 * Uma pessoa em um workflow possui:
 *  - papéis, que representam alçadas dentro de processos.
 *  - grupos aos quais pertence, que também possuem alçadas, dos quais pode assumir passos de processo.
 *  - documentos e e-mails, que a diferenciam de outras pessoas;
 *  - um par de chaves que usa para assinar conteúdo dentro de passos de processo.
 *  - [lazy] uma pessoa no workflow pode ou não pertencer ao quadro de um cliente.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface Person extends Serializable {
	
	public abstract String getName();

	public abstract void setName(String nome);
	
	public abstract Gender getGender();
	
	public abstract void setGender(Gender sexo);
	
	public abstract MaritalStatus getMaritalStatus();
	
	public abstract void setMaritalStatus(MaritalStatus estadoCivil);
	
	public abstract Calendar getBirthDate();
	
	public abstract void setBirthDate(Calendar dataDeNascimento);
	
	public abstract void setIdCompany(String idCliente);
	
	public abstract String getIdCompany();
	
	public abstract void setUUID(String uuid);
	
	public abstract String getUUID();
	
	public abstract List<PersonalDocument> getDocuments();

	public abstract void setDocuments(List<PersonalDocument> documents);

	public abstract List<Email> getEmailAddresses();

	public abstract void setEmailAddresses(List<Email> emails);
	
	public abstract void addEmailAddress(Email anEmail);
	
	public abstract List<Group> getGroups();
	
	public abstract void setGroups(List<Group> groups);
	
	public abstract void addGroup(Group aGroup);
	
	public abstract List<Role> getRoles();
	
	public abstract void setRoles(List<Role> roles);
	
	public abstract void addRole(Role aRole);
	
	public abstract List<ProductOrService> getProductsAndServices();
	
	public abstract void addProductOrService(ProductOrService productorservice);
	
	public KeyPair getKeyPair();

	public void setKeyPair(KeyPair keyPair);

}
