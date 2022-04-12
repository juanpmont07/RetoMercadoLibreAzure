package com.meli.xmen.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.xmen.detector.MutantDetector;
import com.meli.xmen.model.Dna;
import com.meli.xmen.model.MetricModel;
import com.meli.xmen.repository.MetricRepository;
import com.meli.xmen.service.MutantService;
import com.meli.xmen.validator.MutantValidator;

@Service
public class MutantServiceImpl implements MutantService{

	
	private static final Logger log = LoggerFactory.getLogger(MutantServiceImpl.class);
	
	@Autowired
	private MetricRepository metricRepo;
	
	@Autowired
	private MutantValidator validatorMutant;
	
	@Autowired
	private MutantDetector mutantDetect;
	
	@Override
	public boolean isMutant(Dna dna) {
		boolean isMutant = validateIsMutant(dna);
		register(new MetricModel(dna.toString(), isMutant));
		
		return isMutant;
    }
	
	/**
	 * Se encarga de crear la matriz y validar si es mutante
	 * @param dna Adn ingresado
	 * @return
	 */
	private boolean validateIsMutant(Dna dna)
	{
		
		if(validatorMutant.validateMinimumSize(dna.getDna().size())) {
			char[][] dnaArray = createArray(dna);
			if(dnaArray != null) {
				log.info("MutantService: Se comprueba si es mutante o no");
				return mutantDetect.isMutant(dnaArray);
			}
		}
		log.error("MutantService: No cumple con el tamano minimo de matriz para ser mutante");
		return false;
	}
	
	/**
	 * Registra en la base de datos
	 * @param metric
	 */
	private void register(MetricModel metric) {
		this.metricRepo.save(metric);
		log.info("Se guardo en base de datos el adn");
	}
	
	/**
	 * Crea una matriz M*M con el vector ingresado
	 * @param dna Array de adn
	 * @return una matriz
	 */
	private char[][] createArray(Dna dna) {
		log.info("MutantService: Se comienza la creacion de matriz M*M");
		int sizeDna = dna.getDna().size();
		char[][] dnaArray = new char[sizeDna][sizeDna];
		
		for (int i = 0; i < sizeDna; i++) {
			String dnaRow = dna.getDna().get(i);
			
			if(validatorMutant.validatePatternDna(dnaRow) && validatorMutant.validateSizeRow(dnaRow, sizeDna)) {
				dnaArray[i] = dnaRow.toUpperCase().toCharArray();
			}else {
				log.error("MutantService: No cumple con las validaciones minimas para ser mutante");
				return null;
			}
		}
		return dnaArray;
	}

}
