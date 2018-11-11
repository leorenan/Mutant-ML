package com.mercadolibre.xmen.validate.mutant.detectmutant.model;

import java.io.Serializable;

public class Stats implements Serializable {

	private static final long serialVersionUID = 3234074373461532508L;

	public Stats(int countMutantDna, int countHumanDna, double ratio) {
		setCountMutantDna(countMutantDna);
		setCountHumanDna(countHumanDna);
		setRatio(ratio);
	}
	
	private int countMutantDna;
	private int countHumanDna;
	private double ratio;
	
	public int getCountMutantDna() {
		return countMutantDna;
	}
	public void setCountMutantDna(int countMutantDna) {
		this.countMutantDna = countMutantDna;
	}
	public int getCountHumanDna() {
		return countHumanDna;
	}
	public void setCountHumanDna(int countHumanDna) {
		this.countHumanDna = countHumanDna;
	}
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	
	
	
}
