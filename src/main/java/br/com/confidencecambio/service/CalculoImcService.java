package br.com.confidencecambio.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import br.com.confidencecambio.dto.ImcDTO;

@Service
public class CalculoImcService {
	public ImcDTO calculoImc(BigDecimal peso, BigDecimal altura) {		
		BigDecimal alturaCalc = altura.multiply(altura);
		BigDecimal imc =  peso.divide(alturaCalc, 2, RoundingMode.HALF_UP);				
		return ImcDTO.builder().imc(imc).build();		
	}

}
