/**
 * 
 */
package br.com.navita.workflow.mdm.model;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * todos os transfer objects extendem esta classe.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public abstract class BaseTO implements Serializable {
	
	// uses Google Gson to serialize/deserialize this object to JSON format.
	protected transient Gson gson = new Gson();
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = -69003188521458540L;

	/**
	 * retorna esta instância de BaseTO em um documento JSON.
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toJSON() {
		return gson.toJson(this);
	}


}
