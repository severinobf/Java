/**
 * 
 */
package br.com.navita.workflow.mdm.process.procurement;

import java.util.List;

import br.com.navita.workflow.mdm.catalog.SkuTO;
import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.Process;
import br.com.navita.workflow.mdm.pedido.OrderTO;

/**
 * Transfer Object para o Processo de solicitação de produto/servico.
 * Uma Pessoa solicita um produto ou serviço descrito em ItemDeCatalogoTO.
 * 
 * @see Process
 * @see SkuTO
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class ProcurementTO extends BaseTO {
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = -913649735522989908L;

	private List<OrderTO> pedidosRealizados = null;

	public List<OrderTO> getPedidosRealizados() {
		return pedidosRealizados;
	}

	public void setPedidosRealizados(List<OrderTO> pedidosRealizados) {
		this.pedidosRealizados = pedidosRealizados;
	}
	
}
