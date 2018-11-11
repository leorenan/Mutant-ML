package com.mercadolibre.xmen.validate.mutant.detectmutant.model;

public class HumanDataJson {

	public HumanDataJson(String dna, boolean isMutant) {
		setDna(dna);
		setMutant(isMutant);
	}
	
	private String dna;
	private boolean isMutant;
	
	public String getDna() {
		return dna;
	}
	public void setDna(String dna) {
		this.dna = dna;
	}
	public boolean isMutant() {
		return isMutant;
	}
	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}
	
	
	
}
