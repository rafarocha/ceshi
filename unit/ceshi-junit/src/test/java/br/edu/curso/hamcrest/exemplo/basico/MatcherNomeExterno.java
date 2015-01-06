package br.edu.curso.hamcrest.exemplo.basico;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.google.common.base.Objects;

public class MatcherNomeExterno extends TypeSafeMatcher<Pessoa> {

	private String nome;

	public MatcherNomeExterno(String nome) {
		this.nome = nome;
	}

	public void describeTo(Description desc) {
		desc.appendText(" nome deveria retornar ").appendValue(nome);
	}

	@Override
	protected boolean matchesSafely(Pessoa pessoa) {
		return Objects.equal(nome, pessoa.getNome());
	}

	@Override
	public void describeMismatchSafely(final Pessoa pessoa,
			final Description desc) {
		desc.appendText(" mas retornou ").appendValue(pessoa.getNome());
	}

}