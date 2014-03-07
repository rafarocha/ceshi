package br.edu.curso.teste.experimentos.junit.rulechain;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

import br.edu.curso.teste.experimentos.junit.rulesclass.ActionRule;

/**
 * mais em 
 */
public class RuleChainTestUse {
	
	@Rule
    public TestRule chain = RuleChain
						       .outerRule(	new ActionRule("testar disponibilidade de servi�o")  ) // ultimo  
						       .around(		new ActionRule("deploy servidor") )
						       .around(		new ActionRule("iniciar servidor") )
						       .around( 	new ActionRule("gerar pacote")  ); // primeiro

    @Test
    public void example() {
    	System.out.println( "iniciando teste" );
        assertTrue(true);
    }

}