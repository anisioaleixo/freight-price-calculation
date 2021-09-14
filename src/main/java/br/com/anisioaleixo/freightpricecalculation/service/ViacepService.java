package br.com.anisioaleixo.freightpricecalculation.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.anisioaleixo.freightpricecalculation.data.dto.ViacepDTO;

@Service
public class ViacepService {

	public static ViacepDTO buscaCep(String cep) throws Exception {
		try {
			RestTemplate restTemplate = new RestTemplate();

			String uri = "https://viacep.com.br/ws/{cep}/json/";

			Map<String, String> params = new HashMap<String, String>();
			params.put("cep", cep);

			ViacepDTO cepInfo = restTemplate.getForObject(uri, ViacepDTO.class, params);

			return cepInfo;

		} catch (Exception e) {
			throw new Exception("Erro: " + e);
		}

	}

}
