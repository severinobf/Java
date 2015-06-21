/**
 * 
 */
package br.com.navita.workflow.mdm.model;

import java.io.Serializable;
import java.util.Collection;

import br.com.navita.workflow.mdm.model.impl.TenantTO;

/**
 * Defines a ruleset for each use case.
 * a ruleset depends on Tenant, Process and Person that initiates it.
 * a ruleset should have annexes (attachments)
 * 
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface RuleSet extends Serializable {
	
	public abstract TenantTO getTenant();
	
	public abstract Process getProcess();
	
	public abstract Person getResponsible();
	
	public abstract String getRuleName();
	
	public abstract void setRuleName(String ruleName);
	
	public abstract Collection<Annex> getAnnexes();
	
	public abstract void setAnnexes(Collection<Annex> annexes);

}
