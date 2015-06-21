/**
 * 
 */
package br.com.navita.workflow.mdm.model;

import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Um conteúdo é um anexo a um passo de um processo.
 * Um anexo pode ser anexado, desanexado, assinado e consultado.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface Content extends Serializable {
	
	public static final boolean ACTIVE = true;
	
	public abstract byte[] getContent();
	
	public abstract void setContent(byte[] content) throws Exception;
	
	public abstract void signContent(PrivateKey aKey) throws Exception;
	
	public abstract boolean checkSignature(PublicKey aKey) throws Exception;
	
	public abstract Person getProprietario();
	
	public abstract void setProprietario(Person person);

}
