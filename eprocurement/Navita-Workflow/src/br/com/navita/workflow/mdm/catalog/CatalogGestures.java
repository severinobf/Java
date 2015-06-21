/**
 * 
 */
package br.com.navita.workflow.mdm.catalog;

import br.com.navita.workflow.mdm.model.Gesture;

/**
 * Gestos do Usuário possíveis no Catálogo.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public enum CatalogGestures implements Gesture {
	
	CONSULTA, CONSULTA_PRECO, INFORMACOES_TECNICAS, DESCRICAO_LONGA, ADICIONA_CARRINHO, REMOVE_CARRINHO, CANCELA_CARRINHO;

}
