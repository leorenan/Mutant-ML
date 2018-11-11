package com.mercadolibre.xmen.validate.mutant.detectmutant.data;

import com.mercadolibre.xmen.validate.mutant.detectmutant.model.Stats;

public interface IMutantData {

	String save(String dna, boolean isMutant) throws Exception;
	
	Stats result() throws Exception;
	
}
