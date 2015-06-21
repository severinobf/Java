/**
 * 
 */
package br.com.navita.workflow.mdm.model.impl;


/**
 * Excecao para a camada DAO da Navita.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class DAOException extends Exception {

	/**
	 * generated
	 * 
	 */
	private static final long serialVersionUID = 1394371815226174553L;

	public DAOException() {
		super();
	}

	public DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}



}
