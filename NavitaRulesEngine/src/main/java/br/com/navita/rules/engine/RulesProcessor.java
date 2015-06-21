package br.com.navita.rules.engine;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import br.com.navita.workflow.mdm.model.impl.RulesTO;

/**
 * This is a sample class to launch a rule.
 */
public class RulesProcessor {

	public void startProcess(RulesTO rulesTO) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");

			// -- Seta Regras E-Procurement --
			// --------------------------
			ValidationData validation = new ValidationData();

			// -- RN001 - Elegibilidade Perfil
			validation.setGrupo(rulesTO.isGrupo());
			validation.setProduto(rulesTO.getProduto());

			// -- RN002 - Eligibilidade Motivo Compra
			validation.setVencimentoComodato(rulesTO.getVencimentoComodato());
			validation.setMotivoDeCompra(rulesTO.getMotivoDeCompra());

			// -- RN003 - Verifica Perfil Cliente
			validation.setMultiplosAparelhos(rulesTO.isMultiplosAparelhos());
			validation.setStatusRecebimento(rulesTO.getStatusRecebimento());

			// -- RN004 - Comunicacao Pedido Operadora
			validation.setInformarCompraOperadora(rulesTO
					.isInformarCompraOperadora());

			// -- RN005 - Indentificacao recebimento grupo
			validation.setPessoaSolicitante(rulesTO.getPessoaSolicitante());
			validation.setPessoaResponsavel(rulesTO.getPessoaResponsavel());

			// -- RN006 - Envio Email E-Procurement
			validation.setEnviarRespostaEmailPedido(rulesTO
					.getEnviarRespostaEmailPedido());

			// / -- RN007 - Regra para Assinatura Digital por Empresa
			validation.setAceiteAssinaturaDigital(rulesTO
					.isAceiteAssinaturaDigital());

			// -- RN008 - Multa Comodato
			validation.setValorAparelho(rulesTO.getValorAparelho());
			// vencimentoComodato; -- Ja declaro em RN002

			// -- RN009 - Manter Setup Tenant - Empresa
			validation.setRetiraOperadoraListaContrato(rulesTO
					.isRetiraOperadoraListaContrato());

			// -- RN010 - Manter Setup Tenant - Grupos
			validation.setRegrasCatalogoEmpresaGrupos(rulesTO
					.getRegrasCatalogo());

			// -- RN011 - Manter Setup Tenant - Precificacao
			validation.setRegrasCatalogoEmpresaPrecificacao(rulesTO
					.getRegrasCatalogoEmpresaPrecificacao());

			// -- RN012 - Manter Setup Tenant - Elegibilidade
			validation.setRegrasCatalogoEmpresaElegibilidade(rulesTO
					.getRegrasCatalogoEmpresaElegibilidade());

			// -- RN013 - Manter Setup Tenant - Hierarquia Aprovacao
			validation.setRegrasHierarquiaAprovacao(rulesTO
					.getRegrasHierarquiaAprovacao());

			// -- RN014 - Gravar Setup Tenant
			validation.setRegrasCatalogo(rulesTO.getRegrasCatalogo());

			// -- Inicia processamento de regras --
			kSession.insert(validation);
			kSession.fireAllRules();

			// -- Retorna por referencia resultados --
			rulesTO.setMapReturnRulesValidation(validation
					.getMapReturnRulesValidation());
			
				
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static class ValidationData {

		private final int YEARS_OF_LIMIT_LENDING = 2;

		// -- Util --
		private Date limitDateLending; // Data limite comodato

		// -- RN001 - Elegibilidade Perfil
		private boolean grupo;
		private String produto;

		// -- RN002 - Eligibilidade Motivo Compra
		private Date vencimentoComodato;
		private List<String> motivoDeCompra;

		// -- RN003 - Verifica Perfil Cliente
		private boolean multiplosAparelhos;
		private String statusRecebimento;

		// -- RN004 - Comunicacao Pedido Operadora
		private boolean informarCompraOperadora;

		// -- RN005 - Indentificacao recebimento grupo
		private String pessoaSolicitante;
		private String pessoaResponsavel;

		// -- RN006 - Envio Email E-Procurement
		private String enviarRespostaEmailPedido;

		// / -- RN007 - Regra para Assinatura Digital por Empresa
		private boolean aceiteAssinaturaDigital;

		// -- RN008 - Multa Comodato
		private long valorAparelho;
		// private Calendar vencimentoComodato; -- Ja declaro em RN002

		// -- RN009 - Manter Setup Tenant - Empresa
		private boolean retiraOperadoraListaContrato;

		// -- RN010 - Manter Setup Tenant - Grupos
		private String regrasCatalogoEmpresaGrupos;

		// -- RN011 - Manter Setup Tenant - Precificacao
		private String regrasCatalogoEmpresaPrecificacao;

		// -- RN012 - Manter Setup Tenant - Elegibilidade
		private String regrasCatalogoEmpresaElegibilidade;

		// -- RN013 - Manter Setup Tenant - Hierarquia Aprovacao
		private String regrasHierarquiaAprovacao;

		// -- RN014 - Gravar Setup Tenant
		private String regrasCatalogo;

		private String status; // Status Elegibilidade  
		
		// -- Map with return of rules validation
		private Map<String, String> mapReturnRulesValidationTemp;

		public ValidationData() {
			super();
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.YEAR, -this.YEARS_OF_LIMIT_LENDING);
			this.limitDateLending = calendar.getTime();
		}

		public Date getLimitDateLending() {
			return limitDateLending;
		}

		public void setLimitDateLending(Date limitDateLending) {
			this.limitDateLending = limitDateLending;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		public boolean isGrupo() {
			return grupo;
		}

		public void setGrupo(boolean grupo) {
			this.grupo = grupo;
		}

		public String getProduto() {
			return produto;
		}

		public void setProduto(String produto) {
			this.produto = produto;
		}

		public Date getVencimentoComodato() {
			return vencimentoComodato;
		}

		public void setVencimentoComodato(Date vencimentoComodato) {
			this.vencimentoComodato = vencimentoComodato;
		}

		public List<String> getMotivoDeCompra() {
			return motivoDeCompra;
		}

		public void setMotivoDeCompra(List<String> motivoDeCompra) {
			this.motivoDeCompra = motivoDeCompra;
		}

		public boolean isMultiplosAparelhos() {
			return multiplosAparelhos;
		}

		public void setMultiplosAparelhos(boolean multiplosAparelhos) {
			this.multiplosAparelhos = multiplosAparelhos;
		}

		public String getStatusRecebimento() {
			return statusRecebimento;
		}

		public void setStatusRecebimento(String statusRecebimento) {
			this.statusRecebimento = statusRecebimento;
		}

		public boolean isInformarCompraOperadora() {
			return informarCompraOperadora;
		}

		public void setInformarCompraOperadora(boolean informarCompraOperadora) {
			this.informarCompraOperadora = informarCompraOperadora;
		}

		public String getPessoaSolicitante() {
			return pessoaSolicitante;
		}

		public void setPessoaSolicitante(String pessoaSolicitante) {
			this.pessoaSolicitante = pessoaSolicitante;
		}

		public String getPessoaResponsavel() {
			return pessoaResponsavel;
		}

		public void setPessoaResponsavel(String pessoaResponsavel) {
			this.pessoaResponsavel = pessoaResponsavel;
		}

		public String getEnviarRespostaEmailPedido() {
			return enviarRespostaEmailPedido;
		}

		public void setEnviarRespostaEmailPedido(
				String enviarRespostaEmailPedido) {
			this.enviarRespostaEmailPedido = enviarRespostaEmailPedido;
		}

		public boolean isAceiteAssinaturaDigital() {
			return aceiteAssinaturaDigital;
		}

		public void setAceiteAssinaturaDigital(boolean aceiteAssinaturaDigital) {
			this.aceiteAssinaturaDigital = aceiteAssinaturaDigital;
		}

		public long getValorAparelho() {
			return valorAparelho;
		}

		public void setValorAparelho(long valorAparelho) {
			this.valorAparelho = valorAparelho;
		}

		public boolean isRetiraOperadoraListaContrato() {
			return retiraOperadoraListaContrato;
		}

		public void setRetiraOperadoraListaContrato(
				boolean retiraOperadoraListaContrato) {
			this.retiraOperadoraListaContrato = retiraOperadoraListaContrato;
		}

		public String getRegrasCatalogoEmpresaGrupos() {
			return regrasCatalogoEmpresaGrupos;
		}

		public void setRegrasCatalogoEmpresaGrupos(
				String regrasCatalogoEmpresaGrupos) {
			this.regrasCatalogoEmpresaGrupos = regrasCatalogoEmpresaGrupos;
		}

		public String getRegrasCatalogoEmpresaPrecificacao() {
			return regrasCatalogoEmpresaPrecificacao;
		}

		public void setRegrasCatalogoEmpresaPrecificacao(
				String regrasCatalogoEmpresaPrecificacao) {
			this.regrasCatalogoEmpresaPrecificacao = regrasCatalogoEmpresaPrecificacao;
		}

		public String getRegrasCatalogoEmpresaElegibilidade() {
			return regrasCatalogoEmpresaElegibilidade;
		}

		public void setRegrasCatalogoEmpresaElegibilidade(
				String regrasCatalogoEmpresaElegibilidade) {
			this.regrasCatalogoEmpresaElegibilidade = regrasCatalogoEmpresaElegibilidade;
		}

		public String getRegrasHierarquiaAprovacao() {
			return regrasHierarquiaAprovacao;
		}

		public void setRegrasHierarquiaAprovacao(
				String regrasHierarquiaAprovacao) {
			this.regrasHierarquiaAprovacao = regrasHierarquiaAprovacao;
		}

		public String getRegrasCatalogo() {
			return regrasCatalogo;
		}

		public void setRegrasCatalogo(String regrasCatalogo) {
			this.regrasCatalogo = regrasCatalogo;
		}

		public Map<String, String> getMapReturnRulesValidation() {
			return mapReturnRulesValidationTemp;
		}

		public void setMapReturnRulesValidation(String key, String value) {
			this.mapReturnRulesValidationTemp.put(key, value);
		}

	}
}
