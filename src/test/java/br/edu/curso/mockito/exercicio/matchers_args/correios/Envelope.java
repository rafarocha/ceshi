package br.edu.curso.mockito.exercicio.matchers_args.correios;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Envelope {
	
	public Remetente remetente;
	public Endereco endereco;
	
	class Remetente {}
	class Endereco {}

}