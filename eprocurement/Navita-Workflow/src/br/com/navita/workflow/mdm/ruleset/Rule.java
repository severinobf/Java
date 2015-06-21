/**
 * 
 */
package br.com.navita.workflow.mdm.ruleset;

import java.io.Serializable;

/**
 * Decouples a Rule in Navita's workflow from the underlying implementation.
 * 2015-06: Implementation for JBoss Drools.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface Rule extends Serializable {
	
	public abstract Object execute() throws RuleException;

}
