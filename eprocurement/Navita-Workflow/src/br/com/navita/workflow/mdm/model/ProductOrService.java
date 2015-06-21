/**
 * 
 */
package br.com.navita.workflow.mdm.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

/**
 * Um produto ou servico pertencente a uma pessoa.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public interface ProductOrService extends Serializable {
	
	/* remete a um ítem de catálogo */
	public abstract Long getId();
	
	public abstract void setId(Long id);
	
	public abstract String getUUID();
	
	public abstract void setUUID(String uuid);
	
	public abstract ProductOrServiceType getType();
	
	public abstract void setType(ProductOrServiceType type);
	
	public abstract Collection<Content> getConteudoAssinado();
	
	public abstract void addConteudoAssinado(Content umConteudo);
	
	public abstract Calendar getDataSolicitacao();
	
	public abstract void setDataSolicitacao(Calendar dataSolicitacao);
	
	public abstract Calendar getDataVencimentoComodato();
	
	public abstract void setDataVencimentoComodato(Calendar dataVencimentoComodato);
	
	public abstract String getMotivoDeCompra();
	
	public abstract void setMotivoDeCompra(String umMotivo);
	
	public abstract String getModel();
	
	public abstract void setModel(String model);
	
	public abstract String getImei();
	
	public abstract void setImei(String imei);
	
	public abstract String getName();
	
	public abstract void setName(String name);

}
