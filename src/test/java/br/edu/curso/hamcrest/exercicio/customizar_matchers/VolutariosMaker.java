package br.edu.curso.hamcrest.exercicio.customizar_matchers;

import static br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Escolaridade.Analfabeto;
import static br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Escolaridade.Medio;
import static br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Escolaridade.Superior;
import static br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Nacionalidade.Brasileira;
import static br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Sexo.Feminino;
import static br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Sexo.Masculino;

import java.util.List;

import com.google.common.collect.Lists;

public class VolutariosMaker {
	
	public static List<Cidadao> voluntarios() {
		Cidadao c1 = comEnsinoMedio().but().idade(17).build();
		Cidadao c2 = comEnsinoMedio().but().idade(18).build();
		Cidadao c3 = comEnsinoMedio().but().idade(21).sexo(Feminino).build();
		Cidadao c4 = semEnsino().but().idade( 19 ).build();
		Cidadao c5 = brasileiro().but().idade( 20 ).escolaridade(Superior).build();
		return Lists.newArrayList( c1, c2, c3, c4, c5 );
	}
	
	private static Cidadao comEnsinoMedio() {
		return brasileiro().but().escolaridade(Medio).build();
	}
	
	private static Cidadao semEnsino() {
		return brasileiro().but().escolaridade(Analfabeto).build();
	}
	
	private static Cidadao brasileiro() {
		return Cidadao.builder().sexo(Masculino).nacionalidade(Brasileira).build();		
	}

}