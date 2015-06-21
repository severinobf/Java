/**
 * 
 */
package br.com.navita.workflow.mdm.model;

import java.io.Serializable;

/**
 * Anexo inserido em um passo de workflow.
 * Pode ser uma política, um contrato, etc...  Normalmente um documento.
 * 
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface Annex extends Serializable {
	
	/**
	 * o nome deste anexo.  Pode ser o nome do documento físico ou um nome relativo ao workflow
	 * @return
	 */
	public abstract String getName();
	
	/**
	 * o caminho em que o anexo estará disponível no webserver.
	 * @return
	 */
	public abstract String getPath();
	
	/**
	 * indica se o anexo é ou não assinável.  Se true, requer assinatura do usuário
	 */
	public abstract Boolean isSignable();
	
	public abstract void setName(String aName);
	public abstract void setPath(String path);
	public abstract void setSignable(Boolean signable);

}
