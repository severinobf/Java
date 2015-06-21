/**
 * 
 */
package br.com.navita.workflow.mdm.model.impl;

import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.PersonalDocument;

/**
 * Implementacao de um documento de uma pessoa.
 * Documento identifica uma pessoa em um pais.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class PersonalDocumentTO extends BaseTO implements PersonalDocument, Comparable<PersonalDocument> {
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = -3656612172789009687L;
	
	private Long id = null;

	private String pais = "Brazil";
	
	private String numero = null;
	
	private String serie = null;
	
	private String orgaoEmissor = null;

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.model.impl.Documento#compareTo(br.com.navita.workflow.mdm.model.Documento)
	 */
	@Override
	public int compareTo(PersonalDocument doc) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.model.impl.Documento#getPais()
	 */
	@Override
	public String getPais() {
		return pais;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.model.impl.Documento#setPais(java.lang.String)
	 */
	@Override
	public void setPais(String pais) {
		this.pais = pais;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.model.impl.Documento#getNumero()
	 */
	@Override
	public String getNumero() {
		return numero;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.model.impl.Documento#setNumero(java.lang.String)
	 */
	@Override
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.model.impl.Documento#getSerie()
	 */
	@Override
	public String getSerie() {
		return serie;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.model.impl.Documento#setSerie(java.lang.String)
	 */
	@Override
	public void setSerie(String serie) {
		this.serie = serie;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.model.impl.Documento#getOrgaoEmissor()
	 */
	@Override
	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.model.impl.Documento#setOrgaoEmissor(java.lang.String)
	 */
	@Override
	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
