package br.edu.curso.junit.faq.equals_hashcode;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Produto {
	
	public int codigo;

}