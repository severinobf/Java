/**
 * 
 */
package br.com.navita.workflow.mdm.process.procurement;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.Person;
import br.com.navita.workflow.mdm.model.ProductOrService;
import br.com.navita.workflow.mdm.model.impl.TenantTO;

/**
 * Abstracao de um carrinho de compras para o e-Procurement Navita.
 * 
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class ShoppingCartTO extends BaseTO {
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = -6271754530812614735L;

	private Collection<ProductOrService> itens = null;
	
	private Timestamp dataSubmissao = null;
	
	private String numeroDoPedido = null;
	
	private Person solicitante = null;
	
	private Person receptor = null;
	
	private TenantTO cliente = null;
	
	public void addProduto(ProductOrService umProduto) {
		if (itens == null)
			itens = new ArrayList<ProductOrService>();
		itens.add(umProduto);
	}


	public Collection<ProductOrService> getitens() {
		return itens;
	}

	public void setitens(Collection<ProductOrService> itens) {
		this.itens = itens;
	}

	public Timestamp getDataSubmissao() {
		return dataSubmissao;
	}

	public void setDataSubmissao(Timestamp dataSubmissao) {
		this.dataSubmissao = dataSubmissao;
	}

	public String getNumeroDoPedido() {
		return numeroDoPedido;
	}

	public void setNumeroDoPedido(String numeroDoPedido) {
		this.numeroDoPedido = numeroDoPedido;
	}

	public Person getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Person solicitante) {
		this.solicitante = solicitante;
	}

	public Person getReceptor() {
		return receptor;
	}

	public void setReceptor(Person receptor) {
		this.receptor = receptor;
	}

	public TenantTO getCliente() {
		return cliente;
	}

	public void setCliente(TenantTO cliente) {
		this.cliente = cliente;
	}
	
	

}
