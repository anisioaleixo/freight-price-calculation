package br.com.anisioaleixo.freightpricecalculation.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_frete_consulta")
public class Frete implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 8)
	private String cepOrigem;
	
	@Column(nullable = false, length = 8)
	private String cepDestino;
	
	@Column(nullable = false, precision = 10, scale = 3)
	private BigDecimal peso;	

	@Column(nullable = false, length = 60)
	private String nomeDestinatario;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal vlTotalFrete;

	@Column(nullable = false)
	private LocalDate dataConsulta;

	@Column(nullable = false)
	private LocalDate dataPrevistaEntrega;
	
	
	public Frete() {		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCepOrigem() {
		return cepOrigem;
	}


	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}


	public String getCepDestino() {
		return cepDestino;
	}


	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}


	public BigDecimal getPeso() {
		return peso;
	}


	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}


	public String getNomeDestinatario() {
		return nomeDestinatario;
	}


	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}


	public BigDecimal getVlTotalFrete() {
		return vlTotalFrete;
	}


	public void setVlTotalFrete(BigDecimal vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
	}


	public LocalDate getDataConsulta() {
		return dataConsulta;
	}


	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}


	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cepDestino, cepOrigem, dataConsulta, dataPrevistaEntrega, id, nomeDestinatario, peso,
				vlTotalFrete);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frete other = (Frete) obj;
		return Objects.equals(cepDestino, other.cepDestino) && Objects.equals(cepOrigem, other.cepOrigem)
				&& Objects.equals(dataConsulta, other.dataConsulta)
				&& Objects.equals(dataPrevistaEntrega, other.dataPrevistaEntrega) && id == other.id
				&& Objects.equals(nomeDestinatario, other.nomeDestinatario) && Objects.equals(peso, other.peso)
				&& Objects.equals(vlTotalFrete, other.vlTotalFrete);
	}	
	
}
