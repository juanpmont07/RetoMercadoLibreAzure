package com.meli.xmen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meli.xmen.model.Metric;
import com.meli.xmen.service.MutantMetricService;

@RestController
@RequestMapping("/stats")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class MutantMetricController {

	
	private static final Logger log = LoggerFactory.getLogger(MutantMetricController.class);

	@Autowired
	private MutantMetricService mutantMetricServ;

	/**
	 * retorna las estadisticas de cuantos son mutantes y cuantos no.
	 * 
	 * @return estado
	 */
	@GetMapping("/")
	public ResponseEntity<Metric> stats() {
		log.debug("Controller - se inicia la consulta de metricas de mutante.");
		Metric status = mutantMetricServ.getStatistics();
		return ResponseEntity.ok(status);
	}
}
