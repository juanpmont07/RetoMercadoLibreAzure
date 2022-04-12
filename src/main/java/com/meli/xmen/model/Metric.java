package com.meli.xmen.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Data;

@Data
public class Metric {
	
	private Long count_mutant_dna = 0L;
	private Long count_human_dna = 0L;
	private BigDecimal ratio;
	
	
	public Metric(Long mutantCount, Long humanCount) {
		super();
		this.count_mutant_dna = mutantCount;
		this.count_human_dna = humanCount;
		calculateRatio();
	}
	
	
	private void calculateRatio() {
				
		if(this.count_mutant_dna != 0 && this.count_human_dna == 0) {
			//el ratio es 1 ya que el 100% son mutantes
			ratio = BigDecimal.ONE;
			return;
		}
		
		BigDecimal mutant_dna = BigDecimal.valueOf(this.count_mutant_dna);
		BigDecimal human_dna = BigDecimal.valueOf(this.count_human_dna);
		
		this.ratio = (mutant_dna.compareTo(BigDecimal.ZERO) != 0) 
				   ? mutant_dna.divide(human_dna, 2, RoundingMode.HALF_UP): new BigDecimal("0.00");
		// HALF_UP Modo de redondeo para redondear hacia el "vecino más cercano" a menos que ambos vecinos sean equidistantes,
	}
/**
 * divisor : valor por el que se dividirá este BigDecimal. 
 * scale − Escala del cociente BigDecimal que se devolverá.
 * roundingMode − Modo de redondeo a aplicar.
 */
	
}
