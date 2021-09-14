package br.com.anisioaleixo.freightpricecalculation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.anisioaleixo.freightpricecalculation.data.dto.FreteDTO;
import br.com.anisioaleixo.freightpricecalculation.data.dto.FreteResponseDTO;
import br.com.anisioaleixo.freightpricecalculation.service.FreteService;

@RestController
public class FreteController {
	@Autowired
	private FreteService freteService;

	@PostMapping("/calcular-frete")
	public ResponseEntity<FreteResponseDTO> calcularFrete(@RequestBody @Valid FreteDTO freteInput) throws Exception {
		FreteResponseDTO frete = freteService.calcOrcamento(freteInput);
		return new ResponseEntity<FreteResponseDTO>(frete, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
