package com.meli.xmen.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.meli.xmen.repository.MetricRepository;

class MutantMetricServiceTest {

	
	@InjectMocks
    private MutantMetricServiceImpl mutantMeService;
	
	@Mock
	private MetricRepository metricRepo;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void test() {
		when(metricRepo.countByMutant(anyBoolean())).thenReturn(4l);
		assertNotNull(mutantMeService.getStatistics());
	}
	
	@Test
	void testWhenHumanIsZero() {
		when(metricRepo.countByMutant(true)).thenReturn(8L);
		when(metricRepo.countByMutant(false)).thenReturn(0L);
		assertNotNull(mutantMeService.getStatistics());
	}

}
