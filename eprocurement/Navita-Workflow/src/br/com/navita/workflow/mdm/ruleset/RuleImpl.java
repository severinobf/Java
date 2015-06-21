package br.com.navita.workflow.mdm.ruleset;

import br.com.navita.rules.engine.RulesProcessor;
import br.com.navita.workflow.mdm.catalog.CatalogTO;
import br.com.navita.workflow.mdm.catalog.SkuTO;
import br.com.navita.workflow.mdm.model.impl.PersonTO;
import br.com.navita.workflow.mdm.model.impl.ProductOrServiceTO;
import br.com.navita.workflow.mdm.model.impl.RulesTO;

public class RuleImpl implements Rule {

	private static final long serialVersionUID = 1L;

	@Override
	public Object execute() throws RuleException {
		
		// O que precisa ser passado ...
		CatalogTO catalogTO = new CatalogTO();
		PersonTO apersonTO = new PersonTO();
		SkuTO skuTO = new SkuTO();
		ProductOrServiceTO productOrServiceTO = new ProductOrServiceTO();		
		RulesTO rulesTO = new RulesTO();
	
		// -- RN001 - Elegibilidade Perfil
    	rulesTO.setGrupo(apersonTO.getGroups().isEmpty()); 
    	rulesTO.setProduto(skuTO.getModel());

		// -- RN002 - Eligibilidade Motivo Compra
		rulesTO.setVencimentoComodato(productOrServiceTO.getDataVencimentoComodato().getTime());
		rulesTO.setMotivoDeCompra(catalogTO.getBuyingMotives());
		
		// -- RN003 - Verifica Perfil Cliente
		rulesTO.setMultiplosAparelhos(false);
		rulesTO.setStatusRecebimento(null);
		
		// -- RN004 - Comunicacao Pedido Operadora
		rulesTO.setInformarCompraOperadora(false);
		
		// -- RN005 - Indentificacao recebimento grupo
		rulesTO.setPessoaSolicitante(null);
		rulesTO.setPessoaResponsavel(null);
		
		// -- RN006 - Envio Email E-Procurement
		rulesTO.setEnviarRespostaEmailPedido(null);
		
		/// -- RN007 - Regra para Assinatura Diital por Empresa
		rulesTO.setAceiteAssinaturaDigital(false);
		
		// -- RN008 - Multa Comodato
		rulesTO.setValorAparelho(0);
		//vencimentoComodato; -- Ja declaro em RN002
		
		// -- RN009 - Manter Setup Tenant - Empresa
		rulesTO.setRetiraOperadoraListaContrato(false);
		
		// -- RN010 - Manter Setup Tenant - Grupos
		rulesTO.setRegrasCatalogoEmpresaGrupos(null);
		
		// -- RN011 - Manter Setup Tenant - Precificacao
		rulesTO.setRegrasCatalogoEmpresaPrecificacao(null); 
		
		// -- RN012 - Manter Setup Tenant - Elegibilidade
		rulesTO.setRegrasCatalogoEmpresaElegibilidade(null);
		
		// -- RN013 - Manter Setup Tenant - Hierarquia Aprovacao
		rulesTO.setRegrasHierarquiaAprovacao(null);
		
		// -- RN014 - Gravar Setup Tenant
		rulesTO.setRegrasCatalogo(null);
		
		RulesProcessor processor = new RulesProcessor();
		processor.startProcess(rulesTO);
		return null;
	}
}
