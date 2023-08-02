package br.com.confidencecambio.controller;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.dto.ImcDTO;
import br.com.confidencecambio.service.CalculoImcService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/imc")
@Validated
public class CalculoImcController {
	@Autowired
	private CalculoImcService service;
	
	@Operation(summary = "Calcula o IMC de acordo com o peso e altura")	 
	@PostMapping	
	public ImcDTO calculoImc(@RequestParam("peso") BigDecimal peso,
			@Valid @RequestParam("altura") @DecimalMin(value = "0.01", inclusive = false) BigDecimal altura) {		
		return service.calculoImc(peso, altura);		
	}

}
