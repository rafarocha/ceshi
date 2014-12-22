package br.edu.curso.mockito.powermock.exemplo.basico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.exceptions.verification.TooLittleActualInvocations;
import org.mockito.exceptions.verification.junit.ArgumentsAreDifferent;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest( { StaticService.class, SimpleStaticService.class })
public class PowerMockBasicoTest {

	@Test
	public void testMockStaticNoExpectations() throws Exception {
		
		mockStatic(StaticService.class);
		assertNull(StaticService.say("hello"));

		// Verification is done in two steps using static methods.
		verifyStatic();
		StaticService.say("hello");
	}

	@Test
	public void testMockStaticWithExpectations() throws Exception {
		final String expected = "Hello world";
		final String argument = "hello";

		mockStatic(StaticService.class);

		when(StaticService.say(argument)).thenReturn(expected);

		assertEquals(expected, StaticService.say(argument));

		// Verification is done in two steps using static methods.
		verifyStatic();
		StaticService.say(argument);
	}

	@Test(expected = IllegalStateException.class)
	public void testMockStaticThatThrowsException() throws Exception {
		final String argument = "hello";

		mockStatic(StaticService.class);

		when(StaticService.say(argument))
				.thenThrow(new IllegalStateException());

		StaticService.say(argument);
	}

	@Test(expected = ArgumentsAreDifferent.class)
	// TODO Fix error message!!
	public void testMockStaticVerificationFails() throws Exception {
		mockStatic(StaticService.class);
		assertNull(StaticService.say("hello"));

		// Verification is done in two steps using static methods.
		verifyStatic();
		StaticService.say("Hello");
	}

	@Test
	public void testMockStaticAtLeastOnce() throws Exception {
		mockStatic(StaticService.class);
		assertNull(StaticService.say("hello"));
		assertNull(StaticService.say("hello"));

		// Verification is done in two steps using static methods.
		verifyStatic(atLeastOnce());
		StaticService.say("hello");
	}

	@Test
	public void testMockStaticCorrectTimes() throws Exception {
		mockStatic(StaticService.class);
		assertNull(StaticService.say("hello"));
		assertNull(StaticService.say("hello"));

		// Verification is done in two steps using static methods.
		verifyStatic(times(2));
		StaticService.say("hello");
	}

	@Test(expected = TooLittleActualInvocations.class)
	public void testMockStaticIncorrectTimes() throws Exception {
		mockStatic(StaticService.class);
		assertNull(StaticService.say("hello"));
		assertNull(StaticService.say("hello"));

		// Verification is done in two steps using static methods.
		verifyStatic(times(3));
		StaticService.say("hello");
	}

	@Test
	public void testMockStaticVoidWithNoExpectations() throws Exception {
		mockStatic(StaticService.class);

		StaticService.sayHello();

		verifyStatic();
		StaticService.sayHello();
	}

	@Test
	public void mockStatic_uses_var_args_to_create_multiple_static_mocks()
			throws Exception {
		mockStatic(StaticService.class, SimpleStaticService.class);

		when(SimpleStaticService.say("Something")).thenReturn("other");

		StaticService.sayHello();
		final String said = SimpleStaticService.say("Something");

		verifyStatic();
		StaticService.sayHello();
		verifyStatic();
		SimpleStaticService.say("Something");

		assertEquals(said, "other");
	}

	@Test
	public void spyingUsingArgumentCaptor() throws Exception {
		// Given
		mockStatic(StaticService.class);
		final ArgumentCaptor<String> captor = ArgumentCaptor
				.forClass(String.class);

		StaticService.say("something");

		verifyStatic();
		StaticService.say(captor.capture());

		assertEquals("something", captor.getValue());
	}
	
	// ----
	// TODO baixar fontes powermock e entender problema dos casos ignorados abaixo
	// ----
	
	@Test(expected = ArrayStoreException.class) @Ignore 
	public void testMockStaticVoidWhenThrowingException() throws Exception {
		mockStatic(StaticService.class);

		// Expectations
		doThrow(new ArrayStoreException("Mock error"))
				.when(StaticService.class);
		StaticService.sayHello();

		// Test
		StaticService.sayHello();
	}
	
	@Test @Ignore
	public void testSpyOnStaticMethods() throws Exception {
		spy(StaticService.class);

		String expectedMockValue = "expected";
		when(StaticService.say("world")).thenReturn(expectedMockValue);

		assertEquals(expectedMockValue, StaticService.say("world"));
		assertEquals("Hello world2", StaticService.say("world2"));
	}

	@Test @Ignore
	public void errorousVerificationOfStaticMethodsGivesANonMockitoStandardMessage()
			throws Exception {
		final String expected = "Hello world";
		final String argument = "hello";

		mockStatic(StaticService.class);

		when(StaticService.say(argument)).thenReturn(expected);

		assertEquals(expected, StaticService.say(argument));

		// Verification is done in two steps using static methods.
		verifyStatic(times(2));
		try {
			StaticService.say(argument);
			fail("Should throw assertion error");
		} catch (MockitoAssertionError e) {
			assertEquals(
					"\nsamples.singleton.StaticService.say(\"hello\");\nWanted 2 times but was 1 time.",
					e.getMessage());
		}
	}

}