/**
 * 
 */
package br.com.navita.workflow.mdm.model;

import java.io.Serializable;

/**
 * um e-mail pertencente a uma pessoa.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface Email extends Serializable {

	public abstract String getEmail();
	
	public abstract void setEmail(String email);
	
	public abstract Integer getTipoEmail();
	
	public abstract void setTipoEmail(Integer tipoEmail);


}
