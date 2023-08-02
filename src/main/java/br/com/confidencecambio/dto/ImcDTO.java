package br.com.confidencecambio.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ImcDTO {	
	private BigDecimal imc;
}
