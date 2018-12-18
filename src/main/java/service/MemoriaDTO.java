package service;

import java.io.Serializable;

public class MemoriaDTO implements Serializable{
	
	private String estado;
	private double mediaPorcentagem;
	
	public MemoriaDTO(String estado, double l) {
		this.estado = estado;
		this.mediaPorcentagem = l;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getMediaPorcentagem() {
		return mediaPorcentagem;
	}
	public void setMediaPorcentagem(double mediaPorcentagem) {
		this.mediaPorcentagem = mediaPorcentagem;
	}
	
	

}
