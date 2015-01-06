package br.edu.curso.faq.equals_hashcode;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

import com.google.common.base.Objects;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Pessoa {

	public String nome;
	public String sobrenome;

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass() ) {
			return false;
		}
		
		final Pessoa pessoa = (Pessoa) obj;		
		return 
			Objects.equal( this.nome, pessoa.nome ) &&
			Objects.equal( this.sobrenome, pessoa.sobrenome );
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode( this.nome, this.sobrenome );
	}

}