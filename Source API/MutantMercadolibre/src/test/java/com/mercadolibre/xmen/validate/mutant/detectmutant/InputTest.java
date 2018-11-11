package com.mercadolibre.xmen.validate.mutant.detectmutant;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.Human;
import com.mercadolibre.xmen.validate.mutant.detectmutant.service.ValidateMutantService;

public class InputTest {


    private static Human inputNull;
    private static Human inputNull2;
    private static Human inputColError;
    private static Human inputRegularExpression;

    @BeforeClass
    public static void createInput() throws IOException {   	
    	inputNull = null;
    	inputNull2 = new Human();
    	inputNull2.setDna(null);
    	
    	inputColError = new Human();
    	inputColError.setDna(new String[] {"ATGCGA","CAGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});  
    	
    	inputRegularExpression = new Human();
    	inputRegularExpression.setDna(new String[] {"HTGCGA","CAGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testInputNull() {
        Context ctx = createContext();

        boolean output = ValidateMutantService.isMutant(inputNull, ctx);

        Assert.assertEquals(false, output);
    }
    
    @Test
    public void testInputNull2() {
        Context ctx = createContext();
        
        inputNull2.toString();

        boolean output = ValidateMutantService.isMutant(inputNull2, ctx);

        Assert.assertEquals(false, output);
    }
    
    @Test
    public void testInputColError() {
        Context ctx = createContext();

        boolean output = ValidateMutantService.isMutant(inputColError, ctx);

        Assert.assertEquals(false, output);
    }
    
    @Test
    public void testInputRegularExpression() {
        Context ctx = createContext();

        boolean output = ValidateMutantService.isMutant(inputRegularExpression, ctx);

        Assert.assertEquals(false, output);
    }
   
}
