/**
 * 
 */
package br.com.navita.workflow.mdm.catalog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.BuyingMotive;

/**
 * Transfer Object para o catalogo do workflow da Navita MDM.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class CatalogTO extends BaseTO {
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = 8500168188042203243L;

	private Calendar dataUltimaModificacao = null;
	
	private List<SkuTO> produtos = null;
	
	/**
	 * Uma lista de motivos de compra será exigida no catálogo para alguns tipos de produto.
	 * @see "Solicitar_Dispositivo.doc e outros documentos relacionados aos casos de uso de catalogo"
	 */
	@SuppressWarnings("unused")
	private List<String> buyingMotives = null;
	
	public CatalogTO() {
		dataUltimaModificacao = Calendar.getInstance();
	}

	public Calendar getDataUltimaModificacao() {
		return dataUltimaModificacao;
	}

	public void setDataUltimaModificacao(Calendar dataUltimaModificacao) {
		this.dataUltimaModificacao = dataUltimaModificacao;
	}

	public List<SkuTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<SkuTO> produtos) {
		this.produtos = produtos;
	}
	
	public void addProduto(SkuTO umProduto) {
		if (produtos == null)
			produtos = new ArrayList<SkuTO>();
		produtos.add(umProduto);
	}

	public List<String> getBuyingMotives() {
		List<String> ret = new ArrayList<String>();
		for (BuyingMotive b: BuyingMotive.values()) {
			ret.add(b.toString());
		}
		return ret;
	}


}
