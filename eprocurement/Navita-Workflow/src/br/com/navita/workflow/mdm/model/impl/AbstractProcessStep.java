/**
 * 
 */
package br.com.navita.workflow.mdm.model.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import br.com.navita.workflow.mdm.model.Annex;
import br.com.navita.workflow.mdm.model.Content;
import br.com.navita.workflow.mdm.model.Group;
import br.com.navita.workflow.mdm.model.ProcessStep;
import br.com.navita.workflow.mdm.model.Person;

/**
 * Implementação Navita de um passo de processo.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public abstract class AbstractProcessStep implements ProcessStep {
	
	/**
	 * generated
	 */
	protected static final long serialVersionUID = 3539176436915919577L;

	protected Long id = null;
	
	protected Timestamp inicio = null;
	
	protected Timestamp termino = null;
	
	protected Group grupo = null;
	
	protected Person pessoa = null;
	
	protected Group grupoIniciador = null;
	
	protected Person pessoaIniciadora = null;
	
	protected Collection<Content> conteudo = null;
	
	protected Collection<Annex> anexos = null;

	protected Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	public Timestamp getInicio() {
		return inicio;
	}

	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}

	public Timestamp getTermino() {
		return termino;
	}

	public void setTermino(Timestamp termino) {
		this.termino = termino;
	}

	public Group getGrupo() {
		return grupo;
	}

	public void setGrupo(Group grupo) {
		this.grupo = grupo;
	}

	public Person getPessoa() {
		return pessoa;
	}

	public void setPessoa(Person pessoa) {
		this.pessoa = pessoa;
	}

	public Collection<Content> getConteudo() {
		return conteudo;
	}

	public void setConteudo(Collection<Content> conteudo) {
		this.conteudo = conteudo;
	}
	
	public void addConteudo(Content aContent) {
		
	}

	public Group getGrupoIniciador() {
		return grupoIniciador;
	}

	public void setGrupoIniciador(Group grupoIniciador) {
		this.grupoIniciador = grupoIniciador;
	}

	public Person getPessoaIniciadora() {
		return pessoaIniciadora;
	}

	public void setPessoaIniciadora(Person pessoaIniciadora) {
		this.pessoaIniciadora = pessoaIniciadora;
	}

	@Override
	public Collection<Annex> getAnexos() {
		return this.anexos;
	}

	@Override
	public void setAnexos(Collection<Annex> anexos) {
		this.anexos = anexos;
	}

	@Override
	public void addAnexo(Annex umAnexo) {
		if (anexos == null)
			anexos = new ArrayList<Annex>();
		anexos.add(umAnexo);
	}
	

}
