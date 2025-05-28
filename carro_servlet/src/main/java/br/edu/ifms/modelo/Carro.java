package br.edu.ifms.modelo;

import java.util.Date;

public class Carro {
	
	private Long id;
	private String marca;
	private String nome;
	private String modelo;
	private String cor;
	private Date fabricacao;
	private String chassi;
	private boolean ativo;
	
	public Carro() {
		super();
	}
	
	public Carro(String marca, String nome, String modelo, String cor, Date fabricacao, String chassi, boolean ativo) {
		super();
		this.marca = marca;
		this.nome = nome;
		this.modelo = modelo;
		this.cor = cor;
		this.fabricacao = fabricacao;
		this.chassi = chassi;
		this.ativo = ativo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Date getFabricacao() {
		return fabricacao;
	}
	public void setFabricacao(Date fabricacao) {
		this.fabricacao = fabricacao;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Carro [marca=" + marca + ", nome=" + nome + ", modelo=" + modelo + ", cor=" + cor + ", fabricacao="
				+ fabricacao + ", chassi=" + chassi + ", ativo=" + ativo + "]";
	}
	
	
	
}
