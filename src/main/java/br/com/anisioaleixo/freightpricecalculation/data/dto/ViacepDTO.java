package br.com.anisioaleixo.freightpricecalculation.data.dto;

import java.io.Serializable;
import java.util.Objects;

public class ViacepDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uf;

	private String ddd;

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ddd, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViacepDTO other = (ViacepDTO) obj;
		return Objects.equals(ddd, other.ddd) && Objects.equals(uf, other.uf);
	}

	@Override
	public String toString() {
		return "ViacepOutput [uf=" + uf + ", ddd=" + ddd + "]";
	}

}
