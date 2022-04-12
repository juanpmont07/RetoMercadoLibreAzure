package com.meli.xmen.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.meli.xmen.detector.MutantDetector;
import com.meli.xmen.model.Dna;
import com.meli.xmen.model.MetricModel;
import com.meli.xmen.repository.MetricRepository;
import com.meli.xmen.validator.MutantValidator;


class MutantServicelTest {

	
	@InjectMocks
    private MutantServiceImpl mutantService;
	
	@Mock
	private MutantValidator validatorMutant;
	
	@Mock
	private MutantDetector mutantDetect;
	
	@Mock
	private MetricRepository metricRepo;
	
	 private String[] test1Human = new String[]{"tTGCGA",
             "CAGTaC",
             "TTAagT",
             "AcBAGG",
             "cBCCTc",
             "TCACTG"};
	 
	 private String[] test23Mutant = new String[]{"tTGCGA",
             "CAGTgC",
             "TTAagT",
             "AcBAGG",
             "ccCCgc",
             "TCACTG"};
	 
	 
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	

	 @Test
	 public void whenCallIsMutantShouldReturnFalseIsHuman() {
	    
		 MetricModel metric = new MetricModel("CAGTaC", true);
		 
		 when(metricRepo.save(any(MetricModel.class))).thenReturn(metric);
		 when(validatorMutant.validateMinimumSize(anyInt())).thenReturn(true);
		 when(validatorMutant.validateSizeRow(anyString(), anyInt())).thenReturn(true);
		 when(validatorMutant.validatePatternDna(anyString())).thenReturn(true);
		 
	     boolean isHuman = mutantService.isMutant(new Dna(Arrays.asList(test1Human)));
	     assertFalse(isHuman);
	      	
	 }
	 
	 @Test
	 public void whenCallIsMutantShouldReturnFalseIsMutant() {
	    
		 MetricModel metric = new MetricModel("CAGTaC", true);
		 System.out.print(metric.toString());
		 
		 when(metricRepo.save(any(MetricModel.class))).thenReturn(metric);
		 when(validatorMutant.validateMinimumSize(anyInt())).thenReturn(true);
		 when(validatorMutant.validateSizeRow(anyString(), anyInt())).thenReturn(true);
		 when(validatorMutant.validatePatternDna(anyString())).thenReturn(true);
		 
	     boolean isMutant = mutantService.isMutant(new Dna(Arrays.asList(test23Mutant)));
	     assertFalse(isMutant);
	      	
	 }
	 
	 @Test
	 public void shouldReturnFalseWhenSizeNoIsMinimum() {
		 when(validatorMutant.validateMinimumSize(anyInt())).thenReturn(false);
		 boolean isHuman = mutantService.isMutant(new Dna(Arrays.asList(test1Human)));
	     assertFalse(isHuman);
	 }
	 
	 
	 @Test
	 public void shouldReturnFalseWhenPatternOrSizeIsIconrrect() {
		 when(validatorMutant.validateMinimumSize(anyInt())).thenReturn(true);
		 when(validatorMutant.validateSizeRow(anyString(), anyInt())).thenReturn(false);
		 when(validatorMutant.validatePatternDna(anyString())).thenReturn(false);
		 
		 boolean isHuman = mutantService.isMutant(new Dna(Arrays.asList(test1Human)));
	     assertFalse(isHuman);
	 }

}
