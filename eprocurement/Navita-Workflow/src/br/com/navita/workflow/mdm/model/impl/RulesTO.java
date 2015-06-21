package br.com.navita.workflow.mdm.model.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RulesTO {

	private final int YEARS_OF_LIMIT_LENDING = 2;
	
	// -- Util --
	private Calendar limitDateLending; // Data limite comodato
	private boolean reproved;

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

	// / -- RN007 - Regra para Assinatura Diital por Empresa
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

	// -- Map with return of rules validation
	private Map<String, String> mapReturnRulesValidation;

	public RulesTO() {
		super();
		this.reproved = false;
		this.limitDateLending = Calendar.getInstance();
		this.limitDateLending.add(Calendar.YEAR, -this.YEARS_OF_LIMIT_LENDING);
	}

	public Calendar getLimitDateLending() {
		return limitDateLending;
	}

	public void setLimitDateLending(Calendar limitDateLending) {
		this.limitDateLending = limitDateLending;
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

	public void setEnviarRespostaEmailPedido(String enviarRespostaEmailPedido) {
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

	public void setRegrasHierarquiaAprovacao(String regrasHierarquiaAprovacao) {
		this.regrasHierarquiaAprovacao = regrasHierarquiaAprovacao;
	}

	public String getRegrasCatalogo() {
		return regrasCatalogo;
	}

	public void setRegrasCatalogo(String regrasCatalogo) {
		this.regrasCatalogo = regrasCatalogo;
	}

	public Map<String, String> getMapReturnRulesValidation() {
		return mapReturnRulesValidation;
	}

	public void setMapReturnRulesValidation(
			Map<String, String> mapReturnRulesValidation) {
		this.mapReturnRulesValidation = mapReturnRulesValidation;
	}

	public boolean isReproved() {
		return reproved;
	}

	public void setReproved(boolean reproved) {
		this.reproved = reproved;
	}

}
