package com.mercadolibre.xmen.validate.mutant.detectmutant.model;

import java.io.Serializable;
import java.util.Arrays;

public class Human implements Serializable {

	private static final long serialVersionUID = 2739658741684379980L;
	
	private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}
	
	@Override
	public String toString() {
		
		return getDna() != null ? Arrays.toString(getDna()) : null ;
	}
	
}
