package br.com.confidencecambio.controller;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.confidencecambio.service.CalculoImcService;

@WebMvcTest({CalculoImcController.class, CalculoImcService.class})
class CalculoImcControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testDoisValoresValidos() throws Exception {
		URI uri = new URI("/imc");
		String peso = "140.0";
		String altura = "1.55";
		
		MvcResult result = mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.param("peso", peso)
				.param("altura", altura)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200)
				)
		.andReturn();
		
		String json = result.getResponse().getContentAsString();
		assertEquals("{\"imc\":58.27}", json);
	}
	
	@Test
	void testAlturaZeroStatus400() throws Exception {
		URI uri = new URI("/imc");
		String peso = "140.0";
		String altura = "0";
		
		MvcResult result = mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.param("peso", peso)
				.param("altura", altura)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400)
				)
		.andReturn();
		
		String json = result.getResponse().getContentAsString();
		assertEquals("calculoImc.altura: must be greater than 0.01", json);
	}
	
	@Test
	void testPesoZero() throws Exception {
		URI uri = new URI("/imc");
		String peso = "0";
		String altura = "150";
		
		MvcResult result = mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.param("peso", peso)
				.param("altura", altura)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200)
				)
		.andReturn();
		
		String json = result.getResponse().getContentAsString();
		assertEquals("{\"imc\":0.00}", json);
	}


}

