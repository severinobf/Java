/**
 * 
 */
package br.com.navita.workflow.mdm.gesture;

/**
 * Desacopla a implementação NoSQL da persistência de gestos do usuário.
 * A implementação desta interface é um receptor de uma fila.
 * 2015/05/17: A persistência usada aqui é Cassandra.
 * 2015/05/17: Teremos apenas inserção de dados.  As leituras serão feitas via MAP/REDUCE, fora do escopo deste componente.
 * 
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface GestureDAO {
	
	/**
	 * apenas insere um gesto na base.
	 * todas as operações sobre gestos serão casos de map-reduce, fora desta interface.
	 * @param umGesto
	 * @throws GestureException
	 */
	public abstract void insereGesto(GestureTO umGesto) throws GestureException;

}
