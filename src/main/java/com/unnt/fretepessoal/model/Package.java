package com.unnt.fretepessoal.model;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Entity
@Table(name = "package")
@Data
public class Package {

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
	
	
	public Package() {
		super();
	}

	public Package(
		Long id,
	   	String icone,
	   	String destino,
	   	Date dataSaida,
	   	Date dataChegada,
	   	String destinatario,
	   	String status,
	  	Long peso,
	   	Long preco
	) {
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
		Package other = (Package) obj;
		return Objects.equals(id, other.id);
	}





	
	
	
}
