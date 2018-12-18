package service;

import java.io.Serializable;

public class Filtro implements Serializable{

	private String nome;
	private String estado;
	private String modelo;
	private String cidade;
	private Double porcentagemMax;
	private Double porcentagemMin;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPorcentagemMax() {
		return porcentagemMax;
	}
	public void setPorcentagemMax(Double porcentagemMax) {
		this.porcentagemMax = porcentagemMax;
	}
	public Double getPorcentagemMin() {
		return porcentagemMin;
	}
	public void setPorcentagemMin(Double porcentagemMin) {
		this.porcentagemMin = porcentagemMin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	
}
