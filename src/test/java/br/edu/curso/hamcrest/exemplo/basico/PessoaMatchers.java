package br.edu.curso.hamcrest.exemplo.basico;

import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.hamcrest.TypeSafeMatcher;

import com.google.common.base.Objects;

public class PessoaMatchers {

	// usando BaseMatcher
	public static Matcher<Pessoa> hasIdade(final int idade) {
		return new BaseMatcher<Pessoa>() {
			public boolean matches(final Object obj) {
				return idade == getIdade(obj);
			}

			public void describeTo(final Description desc) {
				desc.appendText(" idade deveria retornar ").appendValue(idade);
			}

			public void describeMismatch(final Object obj,
					final Description desc) {
				desc.appendText(" mas retornou ").appendValue(getIdade(obj));
			}

			private int getIdade(Object obj) {
				Pessoa pessoa = (Pessoa) obj;
				return pessoa.getIdade();
			}
		};
	}
	
	// usando TypeSafeMatcher
	public static Matcher<Pessoa> hasNome(final String nome) {
		return new TypeSafeMatcher<Pessoa>() {
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
		};
	}

	
	// usando TypesafeDiagnosingMatcher
	public static Matcher<Pessoa> hasIdadeUsando_TypeSafeDiagnosingMatcher(final int idade) {
		return new TypeSafeDiagnosingMatcher<Pessoa>() {
			public void describeTo(Description desc) {
				desc.appendText(" idade deveria retornar ").appendValue(idade);
			}

			@Override
			protected boolean matchesSafely(Pessoa pessoa, Description desc) {
				return idade == pessoa.getIdade();
			}
		};
	}

	// usando FeatureMatcher
	public static Matcher<Pessoa> hasIdadeFeatureMatcher(final Integer i) {
		return new FeatureMatcher<Pessoa, Integer>(equalTo(i), "idade", "idade") {
			@Override
			protected Integer featureValueOf(Pessoa pessoa) {
				return pessoa.getIdade();
			}
		};
	}

}