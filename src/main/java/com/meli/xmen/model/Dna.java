package com.meli.xmen.model;

import java.util.List;

import lombok.Data;

@Data
public class Dna {

	private List<String> dna;
	
	@Override
	public String toString() {
		return "DNA (dna=" + dna + ")";
	}

	public Dna(List<String> dna) {
		super();
		this.dna = dna;
	}

	public Dna() {
		super();
	}
}
