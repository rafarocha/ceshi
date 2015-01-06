package br.edu.curso.hamcrest.exemplo.basico;

import java.util.List;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import com.google.common.collect.Lists;

public class CombinaMatcher<T> extends BaseMatcher<T> {
	
	private final List<Matcher<? super T>> matchers = Lists.newArrayList();
	private final List<Matcher<? super T>> failed = Lists.newArrayList();

	private CombinaMatcher(final Matcher<? super T> matcher) {
		matchers.add(matcher);
	}

	public CombinaMatcher<T> and(final Matcher<? super T> matcher) {
		matchers.add(matcher);
		return this;
	}

	public boolean matches(final Object obj) {
		for (final Matcher<? super T> matcher : matchers) {
			if (!matcher.matches(obj)) {
				failed.add(matcher);
				return false;
			}
		}
		return true;
	}

	public void describeTo(Description description) {
		description.appendList("(", " " + "e" + " ", ")", matchers);
	}

	public void describeMismatch(final Object item, final Description desc) {
		for (final Matcher<? super T> matcher : failed) {
			desc.appendDescriptionOf(matcher).appendText(""); // poderia colocar 'mas' aqui
			matcher.describeMismatch(item, desc);
		}
	}
	
	public static <U> CombinaMatcher<U> all(final Matcher<? super U> matcher) {
		return new CombinaMatcher<U>(matcher);
	}

}