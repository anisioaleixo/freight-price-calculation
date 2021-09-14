package br.com.anisioaleixo.freightpricecalculation.data.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "cepOrigem", "cepDestino", "peso", "nomeDestinatario", "dataConsulta", "dataPrevistaEntrega",
		"vlTotalFrete" })
public class FreteResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal peso;
	private String cepOrigem;
	private String cepDestino;
	private String nomeDestinatario;
	private BigDecimal vlTotalFrete;
	private LocalDate dataPrevistaEntrega;
	private LocalDate dataConsulta;

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
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

	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cepDestino, cepOrigem, dataConsulta, dataPrevistaEntrega, nomeDestinatario, peso,
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
		FreteResponseDTO other = (FreteResponseDTO) obj;
		return Objects.equals(cepDestino, other.cepDestino) && Objects.equals(cepOrigem, other.cepOrigem)
				&& Objects.equals(dataConsulta, other.dataConsulta)
				&& Objects.equals(dataPrevistaEntrega, other.dataPrevistaEntrega)
				&& Objects.equals(nomeDestinatario, other.nomeDestinatario) && Objects.equals(peso, other.peso)
				&& Objects.equals(vlTotalFrete, other.vlTotalFrete);
	}	

}
