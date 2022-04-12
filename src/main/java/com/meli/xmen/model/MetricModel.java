package com.meli.xmen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "metric")
public class MetricModel {

	public MetricModel(String dna, boolean mutant) {
		super();
		this.dna = dna;
		this.mutant = mutant;
	}

	@Column(name="iid")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long iid;
	
	
	@Column(name="dna")
	private String dna;
	
	
	@Column(name="mutant")
	private boolean mutant;
	
	@Override
	public String toString() {
		return "Metric (dna=" + dna + " - mutant=" + mutant + ")";
	}
	
}
