package br.edu.curso.hamcrest.exercicio.customizar_matchers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Cidadao {
	
	public Sexo sexo;
	public int idade;
	public Escolaridade escolaridade;
	public Nacionalidade nacionalidade;
	
	@SuppressWarnings("static-access")
	public CidadaoBuilder but() {
		return Cidadao.this.builder()
				.sexo( this.sexo )
				.idade( this.idade )
				.escolaridade( this.escolaridade )
				.nacionalidade( this.nacionalidade );
	}
	
	enum Sexo { Masculino, Feminino };
	enum Escolaridade { Analfabeto, Fundamental, Medio, Superior; } 
	enum Nacionalidade { Brasileira, Chilena, Boliviano }
	
}