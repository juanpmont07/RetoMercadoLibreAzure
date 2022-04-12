package com.meli.xmen.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import com.meli.xmen.model.Dna;
import com.meli.xmen.service.MutantService;

class MutantControllerTest {

	@InjectMocks
    private MutantController mutantCtr;
	
    @Mock
    private MutantService mutantsServ;
    private MockMvc mockMvc;

    
    private String[] testMutant = new String[]{"tTGCGA",
            "CAGTgC",
            "TTAagT",
            "AcBAGG",
            "ccCCgc",
            "TCACTG"};
	 
    private Dna dna = new Dna();
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(mutantCtr)
                .build();
		dna.setDna(Arrays.asList(testMutant));
	}
	
	 private String CONTENT_TYPE_JSON = "application/json";
	 private String URI = "/mutant/";


	@Test
	void whenRequestMutantShouldReturnOk()  throws Exception {
		 String mockRequest = "{\"dna\":[\"tTGCGA\",\"CAGTgC\",\"TTAagT\",\"AcBAGG\",\"ccCCgc\",\"TCACTG\"]}";

		 when(mutantsServ.isMutant(dna)).thenReturn(true);
		 
	     ResultActions result = mockMvc.perform(post(URI).contentType(CONTENT_TYPE_JSON).content(mockRequest));
         
	     MvcResult result2 = result.andExpect(status().isOk()).andReturn();
	     assertTrue(result2.getResponse().getStatus() == 200);

	}
	
	
	@Test
	void whenRequestMutantShouldReturnForbidden()  throws Exception {
		String mockRequest = "{\"dna\":[\"tTGCGA\",\"CAGTgC\",\"TTAagT\",\"AcBAGG\",\"ccCCgc\",\"TCACTG\"]}";

		 when(mutantsServ.isMutant(dna)).thenReturn(false);
		 
	     ResultActions result = mockMvc.perform(post(URI).contentType(CONTENT_TYPE_JSON).content(mockRequest));
         
	     MvcResult result2 = result.andExpect(status().isForbidden()).andReturn();
	     assertTrue(result2.getResponse().getStatus() == 403);

	}

}
