/**
 * 
 */
package br.com.navita.workflow.mdm.model.impl;

import br.com.navita.workflow.mdm.model.Annex;

/**
 * Implementação de um Anexo como um Transfer Object
 * @see Annex
 * @see "Transfer Object SJC"
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class AnnexTO implements Annex {
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = 1L;

	private String name = null;
	
	private String path = null;
	
	private Boolean signable = false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean isSignable() {
		return signable;
	}

	public void setSignable(Boolean signable) {
		this.signable = signable;
	}

}
