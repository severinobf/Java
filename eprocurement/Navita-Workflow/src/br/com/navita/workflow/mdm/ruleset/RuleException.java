/**
 * 
 */
package br.com.navita.workflow.mdm.ruleset;

/**
 * Generic Exception for a Rule
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class RuleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3951247316380933020L;

	/**
	 * 
	 */
	public RuleException() {

	}

	/**
	 * @param message
	 */
	public RuleException(String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public RuleException(Throwable cause) {
		super(cause);

	}

	/**
	 * @param message
	 * @param cause
	 */
	public RuleException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public RuleException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
