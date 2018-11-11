package com.mercadolibre.xmen.validate.mutant.detectmutant.controllers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.mercadolibre.xmen.validate.mutant.detectmutant.data.elk.MutantElkData;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.Stats;

public class StatsMutantHandler implements RequestHandler<Object, Stats> {

	@Override
	public Stats handleRequest(Object input, Context context) {
		context.getLogger().log("Recupara no ELK");
		MutantElkData data = new MutantElkData();
		Stats stats = null;
		try {
			stats = data.result();
			
			context.getLogger().log("Retorno");
			context.getLogger().log(String.format("CountMutant %d", stats.getCountMutantDna()));
			context.getLogger().log(String.format("CountHuman %d", stats.getCountHumanDna()));
			context.getLogger().log(String.format("Ratio %1$.3f", stats.getRatio()));
			
		} catch (Exception e) {
			e.printStackTrace();
			context.getLogger().log("Erroa ao Salva no ELK");
		}

		return stats;
	}

}
