package com.mercadolibre.xmen.validate.mutant.detectmutant;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.mercadolibre.xmen.validate.mutant.detectmutant.controllers.StatsMutantHandler;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.Stats;

public class StatsTest {

    @BeforeClass
    public static void createInput() throws IOException {   	
    	
    	
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testStats() {
        StatsMutantHandler handler = new StatsMutantHandler();
        Context ctx = createContext();

        Stats output = handler.handleRequest(null, ctx);

        Assert.assertNotNull(output);
    }
    
   
}
