package com.meli.xmen.repository;

import org.springframework.data.repository.CrudRepository;

import com.meli.xmen.model.MetricModel;

public interface MetricRepository extends CrudRepository<MetricModel, MetricModel>{
	
	
	Long countByMutant(boolean isMutant);
	
}
