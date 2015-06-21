/**
 * 
 */
package br.com.navita.workflow.mdm.pedido;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import br.com.navita.workflow.mdm.model.BaseTO;
import br.com.navita.workflow.mdm.model.ProcessStep;
import br.com.navita.workflow.mdm.model.Person;
import br.com.navita.workflow.mdm.model.Process;
import br.com.navita.workflow.mdm.model.ProductOrService;
import br.com.navita.workflow.mdm.model.ProcessStatus;
import br.com.navita.workflow.mdm.model.impl.CarrierTO;

/**
 * Transfer object referente a um pedido feito a uma operadora.
 * 
 * @author Severino Bento Ferreira Junior
 *
 */
public class OrderTO extends BaseTO implements Process {
	
	/**
	 * generated
	 */
	private static final long serialVersionUID = -3808902236654824299L;

	private Long id = null;
	
	private ProcessStatus status = null;
	
	private CarrierTO operadora = null;
	/* responsável pelo processo do pedido.  Pode não ser o solicitante */
	private Person responsavel = null;
	
	private Person solicitante = null;
	
	private Person receptor = null;
	
	private Collection<ProductOrService> produtoseservicos = null;
	
	private Calendar dataSubmissao = null;
	
	private List<ProcessStep> passosDeProcesso = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CarrierTO getOperadora() {
		return operadora;
	}

	public void setOperadora(CarrierTO operadora) {
		this.operadora = operadora;
	}

	public Person getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Person responsavel) {
		this.responsavel = responsavel;
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

	public Collection<ProductOrService> getProdutoseservicos() {
		return produtoseservicos;
	}

	public void setProdutoseservicos(Collection<ProductOrService> produtoseservicos) {
		this.produtoseservicos = produtoseservicos;
	}

	public Calendar getDataSubmissao() {
		return dataSubmissao;
	}

	public void setDataSubmissao(Calendar dataSubmissao) {
		this.dataSubmissao = dataSubmissao;
	}

	public List<ProcessStep> getPassosDeProcesso() {
		return passosDeProcesso;
	}

	public void setPassosDeProcesso(List<ProcessStep> passosDeProcesso) {
		this.passosDeProcesso = passosDeProcesso;
	}
	
	public void addPassoDeProcesso(ProcessStep umPasso) {
		if (passosDeProcesso == null) {
			passosDeProcesso = new ArrayList<ProcessStep>();
		passosDeProcesso.add(umPasso);	
		}
	}

	public ProcessStatus getStatus() {
		return status;
	}

	public void setStatus(ProcessStatus status) {
		this.status = status;
	}

}
