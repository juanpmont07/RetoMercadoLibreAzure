package com.meli.xmen.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;


/**
 * Clase encargada de realizar las validaciones basicas sobre el adn array 
 * @author User
 *
 */
@Service
public class MutantValidator {

	/**
	 * Minimo tamano de un arreglo dado que se debe de encontrar dos secuencias de adn como minimo.
	 */
	final int MINIMUM_SIZE = 4;
	Pattern pattern = Pattern.compile("[atcg]+", Pattern.CASE_INSENSITIVE);
	
	/**
	 * Comprueba que el tamano minimo del arreglo debe de ser 4
	 * @param dnaSize Tamano del string
	 * @return verdadero si el tamano es el minimo permitido.
	 */
	public boolean validateMinimumSize(int dnaSize) {
		return dnaSize >= MINIMUM_SIZE;
	}
	
	/**
	 * Comprueba el tamano de una fila si es acorde al tamano de la matriz
	 * @param dnaRow Cadena de Adn
	 * @param sizeArray Tamano del array
	 * @return verdadero si el tamano es igual
	 */
    public boolean validateSizeRow(String dnaRow, int sizeArray) {
		return dnaRow.length() == sizeArray;
	}
    
    
    /**
     * Comprueba que la cadena de adn si tenga solo las letras A, T, C Y G
     * @param dnaRow cadena de adn
     * @return
     */
    public boolean validatePatternDna(String dnaRow) {
    	 return pattern.matcher(dnaRow).matches();
    }
}
