package com.cabralme.cadastropix.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_chavepix")
public class ChavePix implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String tipochave;
	private String valorchave;
	private String tipoconta;
	private Integer numeroagencia;
	private Integer numeroconta;
	private String nomecorrentista;
	private String sobrenomecorrentista;
	private Instant datahorainclusaodachave;
	private Instant datahorainativacaodachave;
	
	
	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;
	
	public ChavePix() {		
	}

	public ChavePix(UUID id, String tipochave, String valorchave, String tipoconta, Integer numeroagencia,
			Integer numeroconta, String nomecorrentista, String sobrenomecorrentista, Instant datahorainclusaodachave,
			Instant datahorainativacaodachave, Conta conta) {
		super();
		this.id = id;
		this.tipochave = tipochave;
		this.valorchave = valorchave;
		this.tipoconta = tipoconta;
		this.numeroagencia = numeroagencia;
		this.numeroconta = numeroconta;
		this.nomecorrentista = nomecorrentista;
		this.sobrenomecorrentista = sobrenomecorrentista;
		this.datahorainclusaodachave = datahorainclusaodachave;
		this.datahorainativacaodachave = datahorainativacaodachave;
		this.conta = conta;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTipochave() {
		return tipochave;
	}

	public void setTipochave(String tipochave) {
		this.tipochave = tipochave;
	}

	public String getValorchave() {
		return valorchave;
	}

	public void setValorchave(String valorchave) {
		this.valorchave = valorchave;
	}

	public String getTipoconta() {
		return tipoconta;
	}

	public void setTipoconta(String tipoconta) {
		this.tipoconta = tipoconta;
	}

	public Integer getNumeroagencia() {
		return numeroagencia;
	}

	public void setNumeroagencia(Integer numeroagencia) {
		this.numeroagencia = numeroagencia;
	}

	public Integer getNumeroconta() {
		return numeroconta;
	}

	public void setNumeroconta(Integer numeroconta) {
		this.numeroconta = numeroconta;
	}

	public String getNomecorrentista() {
		return nomecorrentista;
	}

	public void setNomecorrentista(String nomecorrentista) {
		this.nomecorrentista = nomecorrentista;
	}

	public String getSobrenomecorrentista() {
		return sobrenomecorrentista;
	}

	public void setSobrenomecorrentista(String sobrenomecorrentista) {
		this.sobrenomecorrentista = sobrenomecorrentista;
	}

	public Instant getDatahorainclusaodachave() {
		return datahorainclusaodachave;
	}

	public void setDatahorainclusaodachave(Instant datahorainclusaodachave) {
		this.datahorainclusaodachave = datahorainclusaodachave;
	}

	public Instant getDatahorainativacaodachave() {
		return datahorainativacaodachave;
	}

	public void setDatahorainativacaodachave(Instant datahorainativacaodachave) {
		this.datahorainativacaodachave = datahorainativacaodachave;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(valorchave);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChavePix other = (ChavePix) obj;
		return Objects.equals(valorchave, other.valorchave);
	}
	
	
	
}
