/**
 * 
 */
package br.com.navita.workflow.mdm.catalog;

import br.com.navita.workflow.mdm.model.Person;
import br.com.navita.workflow.mdm.model.impl.DAOException;
import br.com.navita.workflow.mdm.tenant.TenantEprocurementParametersTO;

/**
 * Abstração para desacoplamento dos objetos de acesso a dados do Catalogo Navita.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface CatalogDAO {
	
	/**
	 * retorna o catalogo de produtos disponíveis para uma pessoa.
	 * Checa os papéis e privilégios na implementação desta interface. 
	 * 
	 * @param umaPessoa
	 * @return
	 * @throws CatalogException
	 */
	public abstract CatalogTO getCatalog(Person umaPessoa) throws DAOException;
	
	/**
	 * adds parameters to database.
	 * 
	 * @param parameters
	 * @throws DAOException
	 */
	public abstract void addParameters(TenantEprocurementParametersTO parameters) throws DAOException;

}
