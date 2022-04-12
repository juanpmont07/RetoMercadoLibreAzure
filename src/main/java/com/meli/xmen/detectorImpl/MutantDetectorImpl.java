package com.meli.xmen.detectorImpl;

import org.springframework.stereotype.Service;

import com.meli.xmen.detector.MutantDetector;


@Service
public class MutantDetectorImpl implements MutantDetector {

	
	 private char[][] dna;
	 private int countDnaMutant = 0;
	 final int MINIMUM_DNA = 2;
	 
	
	@Override
	public boolean isMutant(char[][] dna) {
		this.countDnaMutant = 0;
		this.dna = dna;
		
		if(readHorizontal()) return true;
		if(readVertical()) return true;
		if(readObliqueLeftToRight()) return true;
		if(readObliqueRightToLeft()) return true;
		
		return false;
	}
	
	
	/**
	 * Comprueba de manera horizontal si se encuentra una cadena de adn
	 * @return verdadero si comprueba si es mutante
	 */
	private boolean readHorizontal() {
		
		for (int i = 0; i < this.dna[0].length; i++) {
		    for (int j = 0; j < this.dna[0].length-3; j++) {
                
		    	//Si las 4 son iguales entonces se rompe el ciclo y retorna que es mutante
		    	if (this.dna[i][j] == this.dna[i][j+1] && this.dna[i][j] == this.dna[i][j+2] &&
		    		this.dna[i][j] == this.dna[i][j+3]
		    	) {
		    		this.countDnaMutant++;
		    		if(isCompleteDna()) return true;
		    		continue;
		    	}
		    	
		    	//Comprueba que la primera posicion sea igual a siguente
		    	if (this.dna[i][j] != this.dna[i][j+1]) {
                	continue;
                }
		    	//Comprueba que la primera posicion sea igual a segundo proximo y
		    	//en caso de que no sea hacemos un salto a la segunda
		    	
		        if(this.dna[i][j] != this.dna[i][j+2]) {
		           j=j+1;
		           continue;
		        }
		        
		        //Comprueba que la primera posicion sea igual a tercero proximo y
		    	//en caso de que no sea hacemos un salto a la tercera
		        if(this.dna[i][j] != this.dna[i][j+3] )
		        {
		        	if(j+3 < this.dna[0].length-3) {
		        		j=j+2;
		        	}else {
		        		j=j+1;
		        	}
		        	continue;
		        }
		    }
		}
		
		return false;
	}
	
	
	/**
	 * Comprueba de manera horizontal si se encuentra una cadena de adn
	 * @return verdadero si comprueba si es mutante
	 */
	private boolean readVertical() {
		
		for (int i = 0; i < this.dna[0].length; i++) {
		    for (int j = 0; j < this.dna[0].length-3; j++) {
                
		    	//Si las 4 son iguales entonces se rompe el ciclo y retorna que es mutante
		    	if (this.dna[j][i] == this.dna[j+1][i] && this.dna[j][i] == this.dna[j+2][i] &&
		    		this.dna[j][i] == this.dna[j+3][i]
		    	) {
		    		this.countDnaMutant++;
		    		if(isCompleteDna()) return true;
		    		continue;
		    	}
		    	
		    	//Comprueba que la primera posicion sea igual a siguente
		    	if (this.dna[j][i] != this.dna[j+1][i]) {
                	continue;
                }
		    	//Comprueba que la primera posicion sea igual a segundo proximo y
		    	//en caso de que no sea hacemos un salto a la segunda
		    	
		        if(this.dna[j][i] != this.dna[j+2][i]) {
		           j=j+1;
		           continue;
		        }
		        
		        //Comprueba que la primera posicion sea igual a tercero proximo y
		    	//en caso de que no sea hacemos un salto a la tercera
		        if(this.dna[j][i] != this.dna[j+3][i] )
		        {
		        	if(j+3 < this.dna[0].length-3) {
		        		j=j+2;
		        	}else {
		        		j=j+1;
		        	}
		        	continue;
		        }
		    }
		}
		return false;
	}
	
	/**
	 *  Comprueba de manera vertical de izquierda a derecha si se encuentra una cadena de adn
	 * @return verdadero si comprueba si es mutante
	 */
	private boolean readObliqueLeftToRight() {
		for (int i = 0; i < this.dna[0].length-3; i++) {
		    for (int j = 0; j < this.dna[0].length-3; j++) {
		    	//Valida verticalmente si existe cadena de adn
		    	if(this.dna[i][j] == this.dna[i+1][j+1] &&
		    	   this.dna[i][j] == this.dna[i+2][j+2] &&
		    	   this.dna[i][j] == this.dna[i+3][j+3]) {
		    		this.countDnaMutant++;
		    		if(isCompleteDna()) return true;
		    		continue;
		    	}
		    }
		}
		return false;
	}
	
	
	/**
	 *  Comprueba de manera vertical de derecha a izquierda si se encuentra una cadena de adn
	 * @return verdadero si comprueba si es mutante
	 */
	private boolean readObliqueRightToLeft() {
		for (int i = 0; i < this.dna[0].length-3; i++) {
		    for (int j = this.dna[0].length-1; j > 2; j--) {
		    	
		    	//Valida verticalmente si existe cadena de adn
		    	if(this.dna[i][j] == this.dna[i+1][j-1] &&
		    	   this.dna[i][j] == this.dna[i+2][j-2] &&
		    	   this.dna[i][j] == this.dna[i+3][j-3]) {
		    		this.countDnaMutant++;
		    		if(isCompleteDna()) return true;
		    		continue;
		    	}
		    }
		}
		return false;
	}
	
	
	/**
	 * Comprueba si la cantidad de adn correctos cumplen el minimo para ser mutante
	 * @return verdadero si mutante
	 */
	private boolean isCompleteDna() {
		return MINIMUM_DNA == this.countDnaMutant;
	}

}
