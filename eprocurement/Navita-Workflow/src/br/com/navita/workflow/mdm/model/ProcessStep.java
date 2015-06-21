/**
 * 
 */
package br.com.navita.workflow.mdm.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Um processo é composto por passos, que têm um responsável, data e hora de início e fim
 * e todos os dados trafegados.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface ProcessStep extends Serializable {
	
	abstract ProcessStatus getStatus();
	
	abstract void setStatus(ProcessStatus status);
	
	abstract Timestamp getInicio();

	abstract void setInicio(Timestamp inicio);

	abstract Timestamp getTermino();

	abstract void setTermino(Timestamp termino);

	abstract Group getGrupo();

	abstract void setGrupo(Group grupo);

	abstract Person getPessoa();

	abstract void setPessoa(Person pessoa);
	
	public abstract void setGrupoIniciador(Group grupo);
	
	public abstract Group getGrupoIniciador();
	
	public abstract Person getPessoaIniciadora();
	
	public abstract void setPessoaIniciadora(Person umaPessoa);

	abstract Collection<Content> getConteudo();

	abstract void setConteudo(Collection<Content> conteudo);
	
	abstract void addConteudo(Content aContent);
	
	abstract Collection<Annex> getAnexos();
	
	abstract void setAnexos(Collection<Annex> anexos);
	
	abstract void addAnexo(Annex umAnexo);

}
