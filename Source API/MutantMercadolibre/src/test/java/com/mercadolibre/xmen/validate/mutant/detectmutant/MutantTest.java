package com.mercadolibre.xmen.validate.mutant.detectmutant;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.Human;
import com.mercadolibre.xmen.validate.mutant.detectmutant.service.ValidateMutantService;

public class MutantTest {


    private static Human mutantRow;
    private static Human mutantCol;
    private static Human mutantRightDiagonal;
    private static Human mutantLengthDiagonal;
    private static Human mutant;
    private static Human human;

    @BeforeClass
    public static void createInput() throws IOException {   	
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
        Context ctx = createContext();

        boolean output = ValidateMutantService.isMutant(human, ctx);

        Assert.assertEquals(false, output);
    }
    
    @Test
    public void testMutant() {
        Context ctx = createContext();

        boolean output = ValidateMutantService.isMutant(mutant, ctx);

        Assert.assertEquals(true, output);
    }
    
    @Test
    public void testMutantRow() {
        Context ctx = createContext();

        boolean output = ValidateMutantService.isMutant(mutantRow, ctx);

        Assert.assertEquals(true, output);
    }
    
    @Test
    public void testMutantRightDiagonal() {
        Context ctx = createContext();

        boolean output = ValidateMutantService.isMutant(mutantRightDiagonal, ctx);

        Assert.assertEquals(true, output);
    }
    
    @Test
    public void testMutantLengthDiagonal() {
        Context ctx = createContext();

        boolean output = ValidateMutantService.isMutant(mutantLengthDiagonal, ctx);

        Assert.assertEquals(true, output);
    }
}
