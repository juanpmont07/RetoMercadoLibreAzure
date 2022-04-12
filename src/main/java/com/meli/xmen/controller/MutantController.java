package com.meli.xmen.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meli.xmen.model.Dna;
import com.meli.xmen.service.MutantService;

/**
 * Se crea servicio rest para validar si un humano es un mutante dandome una cadena de adn
 * @author User
 *
 */
@RestController
@RequestMapping("/mutant")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class MutantController {

	
	@Autowired
	MutantService mutantServiceImpl;
	
	private static final Logger log = LoggerFactory.getLogger(MutantController.class);
	
	/**
	 * Detecta si un humano es un mutante
	 * @param dna Adn ingresado
	 * @return 200 si es mutante y sino 403
	 */
	@PostMapping("/")
	public ResponseEntity<Void> isMutant(@RequestBody Dna dna) {
		log.debug("Controller - se inicia la detencion si un humano es mutante", dna);
		boolean isMutant = mutantServiceImpl.isMutant(dna);
		if (isMutant) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
	
}
