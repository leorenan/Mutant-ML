package com.mercadolibre.xmen.validate.mutant.detectmutant.business;

public class CantidadValidateBusiness {

	private int count = 0;

	public boolean isMutant(Character[][] dna) {

		if (dna != null && dna.length > 3 && dna[0].length > 3) {

			for (int i = 0; i < dna.length; i++) {
				for (int j = 0; j < dna[i].length; j++) {

					// Validate Sequence Column
					if (dna[i].length - 3 > i) {
						if (validateSequence(dna[i][j], dna[i + 1][j], dna[i + 2][j], dna[i + 3][j])) {
							count++;
							if (count == 2)
								return true;
						}
					}

					// Validate Sequence Row
					if (dna[i].length - 3 > j) {
						if (validateSequence(dna[i][j], dna[i][j + 1], dna[i][j + 2], dna[i][j + 3])) {
							count++;
							if (count == 2)
								return true;
						}
					}

					// Validate Sequence Right Diagonal
					if (dna[i].length - 3 > j && dna[i].length - 3 > i) {
						if (validateSequence(dna[i][j], dna[i + 1][j + 1], dna[i + 2][j + 2], dna[i + 3][j + 3])) {
							count++;
							if (count == 2)
								return true;
						}

					}

					// Validate Sequence Length Diagonal
					if (dna[i].length - 3 > j && dna[i].length - 3 > i) {
						if (validateSequence(dna[i][j + 3], dna[i + 1][j + 2], dna[i + 2][j + 1], dna[i + 3][j])) {
							count++;
							if (count == 2)
								return true;
						}
					}

				}
			}
		}

		return false;
	}	

	private boolean validateSequence(char dnaC1, char dnaC2, char dnaC3, char dnaC4) {
		return dnaC1 == dnaC2 && dnaC2 == dnaC3 && dnaC3 == dnaC4;
	}
}
