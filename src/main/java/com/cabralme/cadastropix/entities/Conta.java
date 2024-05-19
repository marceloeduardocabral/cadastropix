package com.cabralme.cadastropix.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_conta")
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private Integer numeroconta;
	private Integer numeroagencia;
	private String tipopessoaconta;
	
	public Conta() {		
	}

	public Conta(UUID id, Integer numeroconta, Integer numeroagencia, String tipopessoaconta) {
		super();
		this.id = id;
		this.numeroconta = numeroconta;
		this.numeroagencia = numeroagencia;
		this.tipopessoaconta = tipopessoaconta;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getNumeroconta() {
		return numeroconta;
	}

	public void setNumeroconta(Integer numeroconta) {
		this.numeroconta = numeroconta;
	}

	public Integer getNumeroagencia() {
		return numeroagencia;
	}

	public void setNumeroagencia(Integer numeroagencia) {
		this.numeroagencia = numeroagencia;
	}

	public String getTipopessoaconta() {
		return tipopessoaconta;
	}

	public void setTipopessoaconta(String tipopessoaconta) {
		this.tipopessoaconta = tipopessoaconta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroagencia, numeroconta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(numeroagencia, other.numeroagencia) && Objects.equals(numeroconta, other.numeroconta);
	}

	
	
	

}
