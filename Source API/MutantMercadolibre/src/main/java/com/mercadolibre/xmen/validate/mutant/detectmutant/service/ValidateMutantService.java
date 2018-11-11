package com.mercadolibre.xmen.validate.mutant.detectmutant.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.mercadolibre.xmen.validate.mutant.detectmutant.business.CantidadValidateBusiness;
import com.mercadolibre.xmen.validate.mutant.detectmutant.data.elk.MutantElkData;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.Human;

public class ValidateMutantService{

	public static Boolean isMutant(Human human, Context context) {
				
		if (human != null && human.getDna() != null) {
			context.getLogger().log("Input: " + human.toString());

			int col = human.getDna()[0].length();
			int row = human.getDna().length;
			Character[][] dna = new Character[row][col];

			context.getLogger().log("Valida os padrões do DNA");

			for (int i = 0; i < human.getDna().length; i++) {
				if (!human.getDna()[i].matches("[ATCG]+")) {
					context.getLogger().log("DNA esta no padrão desconhecido");
					
					
					return false;
				}
				
				if (!(col == human.getDna()[i].length())) {
					context.getLogger().log("DNA não esta em um modelo de martix");
					return false;
				}
				
				for (int j = 0; j < human.getDna()[0].length(); j++) {
					dna[i][j] = human.getDna()[i].charAt(j);
				}

			}

			context.getLogger().log("DNA esta no padrão");
			CantidadValidateBusiness cantidadValidateBusiness = new CantidadValidateBusiness();
			boolean isMutant = cantidadValidateBusiness.isMutant(dna);

			context.getLogger().log(String.format("Mutante %s", isMutant));
			
			context.getLogger().log("Envia para o ELK");
			MutantElkData data = new MutantElkData();
			try {
				data.save(human.toString(), isMutant);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				context.getLogger().log("Erroa ao Salva no ELK");
			}
			
			return  isMutant;
		} else {
			context.getLogger().log("Input: Sem informação");
			return  false;
		}
	}

}
