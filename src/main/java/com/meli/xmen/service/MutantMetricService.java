package com.meli.xmen.service;

import com.meli.xmen.model.Metric;

public interface MutantMetricService {

	/**
	 * Obtiene las estadisticas de cuantos son mutantes y humanos
	 * @return estado
	 */
	public Metric getStatistics();
	
}
