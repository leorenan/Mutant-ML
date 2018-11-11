package com.mercadolibre.xmen.validate.mutant.detectmutant;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mercadolibre.xmen.validate.mutant.detectmutant.data.elk.MutantElkData;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.Human;
import com.mercadolibre.xmen.validate.mutant.detectmutant.model.Stats;

public class DataELKTest {

    private static Human mutant;
    private static Human human;
    private static MutantElkData elkData;
    
    @BeforeClass
    public static void createInput() throws IOException {    	
    	mutant = new Human();
    	mutant.setDna(new String[] {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
    	
    	human = new Human();
    	human.setDna(new String[] {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"});
    	
    	elkData = new MutantElkData();
    }


    @Test
    public void testSave() throws Exception {
    	elkData.save(human.toString(), false);
    	elkData.save(mutant.toString(), true);

    }
    
    @Test
    public void testResult() throws Exception{
    	Stats stats = elkData.result();
    	System.out.println("Human " + stats.getCountHumanDna());
    	System.out.println("Mutant " + stats.getCountMutantDna());
    	System.out.println("Ratio " + stats.getRatio());
    }
}
