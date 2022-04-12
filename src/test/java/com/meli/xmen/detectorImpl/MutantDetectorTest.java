package com.meli.xmen.detectorImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class MutantDetectorTest {

	@InjectMocks
	MutantDetectorImpl mutantDetector;
	
	private String[] test1Human = new String[]{"tTGCGA",
            "CAGTaC",
            "TTAagT",
            "AcBAGG",
            "cBCCTc",
            "TCACTG"};
	 
	 private String[] test2Mutant = new String[]{"tTGCGA",
            "CAGTgC",
            "TTAagT",
            "AcBAGG",
            "ccCCgc",
            "TCACTG"};
	 
	 private String[] testMutantHorVer = new String[]{"tTGCGA",
	            "aAGTgC",
	            "TaAagT",
	            "AcaAGG",
	            "ccCagc",
	            "TCACTG"};
	 private String[] testMutantObliqueLR = new String[]{"tTGCGA",
	            "aagtca",
	            "taacat",
	            "acaagg",
	            "acaagc",
	            "tccctg"};
	 
	 private String[] testMutantHuge = new String[]{
			    "ataTgCaggc",
	            "aAaTgCagcc",
	            "aaAggTacct",
	            "ccaAGGaacc",
	            "ccCagcagcc",
	            "TCACTGtgct",
	            "AcaAGGtacc",
	            "ccCcgcaacc",
	            "TCACTGatct",
	            "AcaAGGabcc",
	            "ccCagcaacc"};
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void whenCallIsMutantShouldReturnTrue() {
		char[][] dna = createMockDna(test2Mutant, 6);
		assertTrue(mutantDetector.isMutant(dna));
	}
	
	@Test
	void whenCallIsHumanShouldReturnFalse() {
		char[][] dna = createMockDna(test1Human, 6);
		assertFalse(mutantDetector.isMutant(dna));
	}
	
	
	@Test
	void whenCallIsMutantShouldReturnTrue_Horizontal_Vertical() {
		char[][] dna = createMockDna(testMutantHorVer,6);
		assertTrue(mutantDetector.isMutant(dna));
	}
	
	@Test
	void whenCallIsMutantShouldReturnTrue_Oblique() {
		char[][] dna = createMockDna(testMutantObliqueLR, 6);
		assertTrue(mutantDetector.isMutant(dna));
	}
	
	@Test
	void whenCallIsMutantShouldReturnTrueHuge() {
		char[][] dna = createMockDna(testMutantHuge, 10);
		assertTrue(mutantDetector.isMutant(dna));
	}
	
	private char[][] createMockDna(String[] dnaString,int size) {
		char[][] dnaArray = new char[size][size];
		List<String> dna = Arrays.asList(dnaString);
		
		for (int i = 0; i < size; i++)
		{
			dnaArray[i] = dna.get(i).toUpperCase().toCharArray();
		}
		
		return dnaArray;
	}

}
