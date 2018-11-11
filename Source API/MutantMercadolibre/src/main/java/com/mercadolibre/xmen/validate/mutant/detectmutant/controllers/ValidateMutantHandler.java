package com.mercadolibre.xmen.validate.mutant.detectmutant.controllers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.ApiGatewayProxyRequest;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.ApiGatewayProxyResponse;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.Human;
import com.mercadolibre.xmen.validate.mutant.detectmutant.service.ValidateMutantService;

public class ValidateMutantHandler implements RequestHandler<ApiGatewayProxyRequest, ApiGatewayProxyResponse> {

	@Override
	public ApiGatewayProxyResponse handleRequest(ApiGatewayProxyRequest request, Context context) {
		Gson gson = new Gson();
		
		
		Human human = 	gson.fromJson(request.getBody(), Human.class);
		
		
		boolean isMutant = ValidateMutantService.isMutant(human, context);
	
		ApiGatewayProxyResponse response =
                new ApiGatewayProxyResponse(isMutant ? 200 : 403, null, String.valueOf(isMutant), false);
                        
		
		return response;
	}

}
