package br.com.modelo.fatec;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Cliente implements Serializable {
	protected String nome;
	protected String telefone;
	protected String endereco;
	protected String CPF;
	protected String revisao;
	protected String numeroPlaca;
	protected String modelo;
	protected String anoFabricacao;
	protected String valordeCompra;
	public List<String> servicos = new ArrayList<String>();
	
	public Cliente(String texto) {
		nome = texto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getRevisao() {
		return revisao;
	}
	public void setRevisao(String revisao) {
		this.revisao = revisao;
	}
	public List<String> getServicos() {
		return servicos;
	}
	public void setServicos(List<String> servicos) {
		this.servicos = servicos;
	}

	public String getNumeroPlaca() {
		return numeroPlaca;
	}
	public void setNumeroPlaca(String numeroPlaca) {
		this.numeroPlaca = numeroPlaca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getValordeCompra() {
		return valordeCompra;
	}
	public void setValordeCompra(String valordeCompra) {
		this.valordeCompra = valordeCompra;
	}
	
	
}
