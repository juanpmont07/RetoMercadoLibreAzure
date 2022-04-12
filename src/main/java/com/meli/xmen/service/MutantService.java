package com.meli.xmen.service;

import com.meli.xmen.model.Dna;

public interface MutantService {

	/**
	 * Servicio que valida si un humano es mutante
	 * @param dna Adn ingresado
	 * @return true si es mutante y false sino
	 */
	public boolean isMutant(Dna dna);
	
	
}
