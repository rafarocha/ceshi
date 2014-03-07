package br.edu.curso.teste.experimentos.junit.classrules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ActionRule implements TestRule {
	
	public String name;
	
	public ActionRule(String name) {
		this.name = name;
	}

	public Statement apply(Statement base, Description description) {
		System.out.println(String.format( "regra aplicada # %s", name ) );
		return base;
	}

}
