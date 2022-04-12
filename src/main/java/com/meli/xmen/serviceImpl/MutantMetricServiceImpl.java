package com.meli.xmen.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.xmen.model.Metric;
import com.meli.xmen.repository.MetricRepository;
import com.meli.xmen.service.MutantMetricService;

@Service
public class MutantMetricServiceImpl implements MutantMetricService {

	@Autowired
	private MetricRepository metricRepo;
	
	@Override
	public Metric getStatistics() {
		return new Metric(metricRepo.countByMutant(true), metricRepo.countByMutant(false));
	}

}
