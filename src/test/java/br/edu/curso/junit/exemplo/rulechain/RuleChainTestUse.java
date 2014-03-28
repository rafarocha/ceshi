package br.edu.curso.junit.exemplo.rulechain;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

import br.edu.curso.junit.exemplo.rulesclass.ActionRule;

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