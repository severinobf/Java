/**
 * 
 */
package br.com.navita.workflow.mdm.model;

import java.io.Serializable;


/**
 * Documento de uma Pessoa
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface PersonalDocument extends Serializable {
	
	public abstract int compareTo(PersonalDocument doc);

	public abstract String getPais();

	public abstract void setPais(String pais);

	public abstract String getNumero();

	public abstract void setNumero(String numero);

	public abstract String getSerie();

	public abstract void setSerie(String serie);

	public abstract String getOrgaoEmissor();

	public abstract void setOrgaoEmissor(String orgaoEmissor);

}
