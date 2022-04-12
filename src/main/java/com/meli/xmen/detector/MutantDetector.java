package com.meli.xmen.detector;

public interface MutantDetector {

	/**
	 * Encargado de realizar las repectivas validaciones de adn para comprobar si es mutante o no.
	 * @param dna Matriz de adn
	 * @return verdadero si es mutante
	 */
	public boolean isMutant(char[][] dna);
}
