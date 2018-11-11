package com.mercadolibre.xmen.validate.mutant.detectmutant;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;
import com.mercadolibre.xmen.validate.mutant.detectmutant.controllers.ValidateMutantHandler;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.ApiGatewayProxyRequest;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.ApiGatewayProxyResponse;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.Human;

public class ValidateMutantHandlerTest {


	private static ApiGatewayProxyRequest request;
	private static Gson gson;
    private static Human mutantRow;
    private static Human mutantCol;
    private static Human mutantRightDiagonal;
    private static Human mutantLengthDiagonal;
    private static Human mutant;
    private static Human human;

    @BeforeClass
    public static void createInput() throws IOException {   
    	request = new ApiGatewayProxyRequest();
    	/*request.setBase64Encoded(false);
    	request.setHttpMethod("POST");
    	request.setPath("/validar");*/
    	
    	gson = new Gson(); 
    	
    	mutantRow = new Human();
    	mutantRow.setDna(new String[] {"AAAAAA","CCCCCC","TGTGTG","GTGTGT","TGTGTG","GTGTGT"});
    	
    	mutantCol = new Human();
    	mutantCol.setDna(new String[] {"ACTGTG","ACGTGT","ACTGTG","ACGTGT","TGACAC","GTCACA"});
    	
    	mutantRightDiagonal = new Human();
    	mutantRightDiagonal.setDna(new String[] {"ACACGT","TACGGT","TGACTC","GTGACG","TGACAC","GTCACA"}); 
    	
    	mutantLengthDiagonal = new Human();
    	mutantLengthDiagonal.setDna(new String[] {"TGCACA", "TGGCAT","CTCAGT","GCAGTG","TGACAC","GTCACA"}); 
    	
    	mutant = new Human();
    	mutant.setDna(new String[] {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
    	
    	human = new Human();
    	human.setDna(new String[] {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"});
    	
    	
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testHuman() {
        ValidateMutantHandler handler = new ValidateMutantHandler();
        Context ctx = createContext();

        request.setBody(gson.toJson(human));
        
        ApiGatewayProxyResponse output = handler.handleRequest(request, ctx);

        Assert.assertEquals("false", output.getBody());
    }
    
    @Test
    public void testMutant() {
        ValidateMutantHandler handler = new ValidateMutantHandler();
        Context ctx = createContext();

        request.setBody(gson.toJson(mutant));
        
        ApiGatewayProxyResponse output = handler.handleRequest(request, ctx);

        Assert.assertEquals("true", output.getBody());
    }
    
    @Test
    public void testMutantRow() {
        ValidateMutantHandler handler = new ValidateMutantHandler();
        Context ctx = createContext();

        request.setBody(gson.toJson(mutantRow));
        
        ApiGatewayProxyResponse output = handler.handleRequest(request, ctx);

        Assert.assertEquals("true", output.getBody());
    }
    
    @Test
    public void testMutantRightDiagonal() {
        ValidateMutantHandler handler = new ValidateMutantHandler();
        Context ctx = createContext();

        request.setBody(gson.toJson(mutantRightDiagonal));
        
        ApiGatewayProxyResponse output = handler.handleRequest(request, ctx);

        Assert.assertEquals("true", output.getBody());
    }
    
    @Test
    public void testMutantLengthDiagonal() {
        ValidateMutantHandler handler = new ValidateMutantHandler();
        Context ctx = createContext();

        request.setBody(gson.toJson(mutantLengthDiagonal));
        
        ApiGatewayProxyResponse output = handler.handleRequest(request, ctx);

        Assert.assertEquals("true", output.getBody());
    }
}
