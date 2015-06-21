/**
 * 
 */
package br.com.navita.workflow.mdm.model.impl;

import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.Email;

/**
 * Implementação de um e-mail pertencente a uma pessoa.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class EmailTO extends BaseTO implements Email {
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = 8476263755746057897L;
	
	private Long id = null;

	private String email = null;
	
	private Integer tipoEmail = null;

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.model.impl.Email#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.model.impl.Email#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.model.impl.Email#getTipoEmail()
	 */
	@Override
	public Integer getTipoEmail() {
		return tipoEmail;
	}

	/* (non-Javadoc)
	 * @see br.com.navita.workflow.mdm.model.impl.Email#setTipoEmail(java.lang.Integer)
	 */
	@Override
	public void setTipoEmail(Integer tipoEmail) {
		this.tipoEmail = tipoEmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
