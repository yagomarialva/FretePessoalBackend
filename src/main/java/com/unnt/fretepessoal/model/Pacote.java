package com.unnt.fretepessoal.model;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Pacote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String icone;
	private String destino;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dataSaida;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dataChegada;
	private String destinatario;
	private String status;
	private Long peso;
	private Long preco;
	
	
	public Pacote() {
		super();
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getIcone() {
		return icone;
	}




	public void setIcone(String icone) {
		this.icone = icone;
	}




	public String getDestino() {
		return destino;
	}




	public void setDestino(String destino) {
		this.destino = destino;
	}




	public Date getDataSaida() {
		return dataSaida;
	}




	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}




	public Date getDataChegada() {
		return dataChegada;
	}




	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}




	public String getDestinatario() {
		return destinatario;
	}




	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public Long getPeso() {
		return peso;
	}




	public void setPeso(Long peso) {
		this.peso = peso;
	}




	public Long getPreco() {
		return preco;
	}




	public void setPreco(Long preco) {
		this.preco = preco;
	}




	public Pacote(Long id, String icone, String destino, Date dataSaida, Date dataChegada, String destinatario,
			String status, Long peso, Long preco) {
		super();
		this.id = id;
		this.icone = icone;
		this.destino = destino;
		this.dataSaida = dataSaida;
		this.dataChegada = dataChegada;
		this.destinatario = destinatario;
		this.status = status;
		this.peso = peso;
		this.preco = preco;
	}




	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacote other = (Pacote) obj;
		return Objects.equals(id, other.id);
	}





	
	
	
}
