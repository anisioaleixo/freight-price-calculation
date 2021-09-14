package br.com.anisioaleixo.freightpricecalculation.data.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FreteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Valid
	@NotBlank(message = "Cep origem não informado!")
	@Pattern(regexp = "\\d{8}", message = "Cep destino mau formado!")
	private String cepOrigem;

	@Valid
	@NotBlank(message = "Cep destino não informado!")
	@Pattern(regexp = "\\d{8}", message = "Cep destino mau formado!")
	private String cepDestino;
	
	@Valid
	@DecimalMin(value = "0.0", inclusive = true, message = "Pesso minimo 0.0")
    @Digits(integer=8, fraction=3)
	private BigDecimal peso;

	@Valid
	@Size(min = 3, max = 60 , message = "Nome destinatario deve ter entre 3 e 60 caracteres")
	private String nomeDestinatario;

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

	@Override
	public int hashCode() {
		return Objects.hash(cepDestino, cepOrigem, nomeDestinatario, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FreteDTO other = (FreteDTO) obj;
		return Objects.equals(cepDestino, other.cepDestino) && Objects.equals(cepOrigem, other.cepOrigem)
				&& Objects.equals(nomeDestinatario, other.nomeDestinatario) && Objects.equals(peso, other.peso);
	}	

}
