package com.meli.xmen.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.meli.xmen.model.Metric;
import com.meli.xmen.service.MutantMetricService;

class MutantMetricControllerTest {

	
	@InjectMocks
    private MutantMetricController mutantCtr;
	
    @Mock
    private MutantMetricService mutantsServ;
    private MockMvc mockMvc;

	 private String CONTENT_TYPE_JSON = "application/json";
	 private String URI = "/stats/";
    
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(mutantCtr)
                .build();
	}

	@Test
	void whenRequestStatsShouldReturnOk()  throws Exception {
		 
		when(mutantsServ.getStatistics()).thenReturn(new Metric(18L, 100L));
		 
	     ResultActions result = mockMvc.perform(get(URI).contentType(CONTENT_TYPE_JSON));
         
	     MvcResult result2 = result.andExpect(status().isOk()).andReturn();
	     assertTrue(result2.getResponse().getStatus() == 200);

	}
}
