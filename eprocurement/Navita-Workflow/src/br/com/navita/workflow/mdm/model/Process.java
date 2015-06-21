/**
 * 
 */
package br.com.navita.workflow.mdm.model;

import java.io.Serializable;
import java.util.List;

/**
 * Um processo é composto por Passos de processo, iniciado e mantido por pessoas.
 * 
 * Todo processo tem um responsável, cujos papéis incluem iniciar e terminar o ciclo, sinalizando
 * que há um processo pendente ou finalizado.
 * 
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface Process extends Serializable {
	
	/* ID do processo no gerenciador de workflow:  Activiti */
	public abstract String getID();
	
	public abstract void setID(String ID);
	
	public abstract String getName();
	
	public abstract void setName(String aName);
	
	public abstract ProcessStatus getStatus();
	
	public abstract void setStatus(ProcessStatus aStatus);
	
	public abstract Person getResponsavel();
	
	public abstract void setResponsavel(Person umaPessoa);
	
	public abstract Group getGroup();
	
	public abstract void setGroup(Group aGroup);
	
	public abstract List<ProcessStep> getPassosDeProcesso();
	
	public abstract void addPassoDeProcesso(ProcessStep umPasso) throws ProcessException;
	
	public abstract void setPassosDeProcesso(List<ProcessStep> passos);
	
}
