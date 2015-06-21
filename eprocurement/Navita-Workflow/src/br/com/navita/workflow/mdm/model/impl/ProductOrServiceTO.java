/**
 * 
 */
package br.com.navita.workflow.mdm.model.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.Content;
import br.com.navita.workflow.mdm.model.ProductOrService;
import br.com.navita.workflow.mdm.model.ProductOrServiceType;

/**
 * Transfer Object para um produto ou serviço.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class ProductOrServiceTO extends BaseTO implements ProductOrService {

	/**
	 * generated
	 */
	private static final long serialVersionUID = 3814967328449322775L;

	private Long id = null;
	
	private String UUID = null;
	
	private Collection<Content> conteudoAssinado = null;
	
	private Calendar dataSolicitacao = null;
	
	private Calendar dataVencimentoComodato = null;
	
	private String motivoDeCompra = null;
	
	private ProductOrServiceType type = null;
	
	private String name = null;
	
	private String imei = null;
	
	private String model = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Content> getConteudoAssinado() {
		return conteudoAssinado;
	}

	public void addConteudoAssinado(Content documento) {
		if (conteudoAssinado == null)
			conteudoAssinado = new ArrayList<Content>();
		conteudoAssinado.add(documento);
	}

	public Calendar getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Calendar dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Calendar getDataVencimentoComodato() {
		return dataVencimentoComodato;
	}

	public void setDataVencimentoComodato(Calendar dataVencimentoComodato) {
		this.dataVencimentoComodato = dataVencimentoComodato;
	}

	public String getMotivoDeCompra() {
		return motivoDeCompra;
	}

	public void setMotivoDeCompra(String motivoDeCompra) {
		this.motivoDeCompra = motivoDeCompra;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setType(ProductOrServiceType type) {
		this.type = type;
	}

	public ProductOrServiceType getType() {
		return type;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

}
