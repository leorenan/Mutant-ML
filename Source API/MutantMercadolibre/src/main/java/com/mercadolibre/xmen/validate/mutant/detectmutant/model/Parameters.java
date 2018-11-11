package com.mercadolibre.xmen.validate.mutant.detectmutant.model;

public class Parameters {

	static {
		setENDPOINT_ELK("https://search-mutant-ml-5ozua2ea5mae5vmea4sssopqmm.us-east-1.es.amazonaws.com/mutant_ml/prd");
	}
	
	private static String ENDPOINT_ELK;

	public static String getENDPOINT_ELK() {
		return ENDPOINT_ELK;
	}

	public static void setENDPOINT_ELK(String eNDPOINT_ELK) {
		ENDPOINT_ELK = eNDPOINT_ELK;
	}
	
	
	
}
