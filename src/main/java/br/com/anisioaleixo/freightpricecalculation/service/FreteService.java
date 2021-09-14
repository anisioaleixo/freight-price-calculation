package br.com.anisioaleixo.freightpricecalculation.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anisioaleixo.freightpricecalculation.converter.DozeConverter;
import br.com.anisioaleixo.freightpricecalculation.data.dto.FreteDTO;
import br.com.anisioaleixo.freightpricecalculation.data.dto.FreteResponseDTO;
import br.com.anisioaleixo.freightpricecalculation.data.dto.ViacepDTO;
import br.com.anisioaleixo.freightpricecalculation.data.model.Frete;
import br.com.anisioaleixo.freightpricecalculation.exception.BeanNotFoundException;
import br.com.anisioaleixo.freightpricecalculation.repository.FreteRepossitory;

@Service
public class FreteService {

	@Autowired
	private FreteRepossitory freteRepossitory;

	public FreteResponseDTO calcOrcamento(FreteDTO fInput) throws Exception {

		Frete frete = DozeConverter.parseObject(fInput, Frete.class);

		ViacepDTO cepOrigem = ViacepService.buscaCep(frete.getCepOrigem());
		ViacepDTO cepDestino = ViacepService.buscaCep(frete.getCepDestino());

		try {

			int days = 0;
			BigDecimal desconto;
			if (cepOrigem.getDdd() == null || cepDestino.getDdd() == null) {
				throw new BeanNotFoundException(cepOrigem.getDdd() == null ? "Cep de origem não encontrado!"
						: "Cep de destino não encontrado!");

			}

			if (cepOrigem.getDdd().equals(cepDestino.getDdd())) {
				days = 1;
				desconto = new BigDecimal(1 - 0.5);
			} else if (cepOrigem.getUf().equals(cepDestino.getUf())) {
				days = 3;
				desconto = new BigDecimal(1 - 0.75);

			} else {
				days = 10;
				desconto = new BigDecimal(1);
			}

			LocalDate data = LocalDate.now();

			frete.setDataConsulta(data);
			frete.setDataPrevistaEntrega(data.plusDays(days));
			frete.setVlTotalFrete(calcVlFrete(fInput.getPeso(), desconto));

		} catch (Exception e) {
			throw new Exception(e);
		}

		FreteResponseDTO fOutput = DozeConverter.parseObject(freteRepossitory.save(frete), FreteResponseDTO.class);

		return fOutput;
	}

	private BigDecimal calcVlFrete(BigDecimal peso, BigDecimal desconto) {

		BigDecimal vlKilo = new BigDecimal(1.0);

		return peso.multiply(vlKilo).multiply(desconto);
	}
}
