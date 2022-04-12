package com.meli.xmen.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class MutantValidatorTest {

	
	
	@InjectMocks
    private MutantValidator validator;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testValidateSizeRowIsTrue() {
		assertTrue(validator.validateSizeRow("CAGTaC", 6));
	}
	@Test
	void testValidateSizeRowIsFalse() {
		assertFalse(validator.validateSizeRow("CAGTaC", 7));
	}
	
	@Test
	void testvalidateMinimumSizeiSTrue() {
		assertTrue(validator.validateMinimumSize(6));
	}
	
	@Test
	void testvalidateMinimumSizeiSFalse() {
		assertFalse(validator.validateMinimumSize(2));
	}
	
	@Test
	void testValidatePatternDna() {
		assertTrue(validator.validatePatternDna("CAGTaC"));
	}
	
	@Test
	void testFailedValidatePatternDna() {
		assertFalse(validator.validatePatternDna("oAGTaC"));
	}

}
