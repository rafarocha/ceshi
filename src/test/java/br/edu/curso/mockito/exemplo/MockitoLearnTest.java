package br.edu.curso.mockito.exemplo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import junitx.util.PrivateAccessor;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.InstanceOf;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@SuppressWarnings("unchecked")
@RunWith(MockitoJUnitRunner.class)
public class MockitoLearnTest extends BaseTest {
	
	@Before
	public void before() {
//		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void _1letsVerifySomeBehavior() {
		// mock creation
		List<String> mockedList = mock(List.class);

		// using mock object
		mockedList.add("one");
		mockedList.clear();

		// verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}

	@Test
	public void _2howAboutSomeStubbing() {
		// You can mock concrete classes, not only interfaces
		LinkedList<String> mockedList = mock(LinkedList.class);

		// stubbing
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());

		// following prints "first"
		System.out.println(mockedList.get(0));

		try {
			// following throws runtime exception
			System.out.println(mockedList.get(1));
			fail();
		} catch (Exception e) {
			// sucess
		}

		// following prints "null" because get(999) was not stubbed
		System.out.println(mockedList.get(999));

		// Although it is possible to verify a stubbed invocation, usually it's
		// just redundant
		// If your code cares what get(0) returns then something else breaks
		// (often before even verify() gets executed).
		// If your code doesn't care what get(0) returns then it should not be
		// stubbed. Not convinced? See here.
		verify(mockedList).get(0);

		/**
		 * By default, for all methods that return value, mock returns null, an
		 * empty collection or appropriate primitive/primitive wrapper value
		 * (e.g: 0, false, ... for int/Integer, boolean/Boolean, ...).
		 * 
		 * Stubbing can be overridden: for example common stubbing can go to
		 * fixture setup but the test methods can override it. Please note that
		 * overridding stubbing is a potential code smell that points out too
		 * much stubbing
		 * 
		 * Once stubbed, the method will always return stubbed value regardless
		 * of how many times it is called.
		 * 
		 * Last stubbing is more important - when you stubbed the same method
		 * with the same arguments many times. Other words: the order of
		 * stubbing matters but it is only meaningful rarely, e.g. when stubbing
		 * exactly the same method calls or sometimes when argument matchers are
		 * used, etc.
		 */
	}

	@Test
	public void _3argumentMatchers() {
		LinkedList<String> mockedList = mock(LinkedList.class);

		// stubbing using built-in anyInt() argument matcher
		when(mockedList.get(anyInt())).thenReturn("element");

		/**
		 * descobrir abaixo de onde vem o m�todo isValid()
		 */
		// stubbing using hamcrest (let's say isValid() returns your own
		// hamcrest matcher):
		// when(mockedList.contains(argThat(isValid()))).thenReturn("element");

		// following prints "element"
		System.out.println(mockedList.get(999));

		// you can also verify using an argument matcher
		verify(mockedList).get(anyInt());

		assertEquals(mockedList.get(anyInt()), "element");

		/**
		 * Custom argument matchers
		 * http://docs.mockito.googlecode.com/hg/latest/
		 * org/mockito/ArgumentMatcher.html
		 * 
		 * ArgumentCaptor is a special implementation of an argument matcher
		 * that captures argument values for further assertions Warning: it is
		 * recommended to use ArgumentCaptor with verification but not with
		 * stubbing. Using ArgumentCaptor with stubbing may decrease test
		 * readability because captor is created outside of assert (aka verify
		 * or 'then') block. Also it may reduce defect localization because if
		 * stubbed method was not called then no argument is captured.
		 * http://docs
		 * .mockito.googlecode.com/hg/latest/org/mockito/ArgumentCaptor.html
		 * 
		 * Warning on argument matchers: verify(mock).someMethod(anyInt(),
		 * anyString(), eq("third argument")); --> above is correct - eq() is
		 * also an argument matcher
		 * 
		 * verify(mock).someMethod(anyInt(), anyString(), "third argument"); -->
		 * above is incorrect - exception will be thrown because third argument
		 * is given without an argument matcher.
		 * 
		 * Importante: Matcher methods like anyObject(), eq() do not return
		 * matchers. Internally, they record a matcher on a stack and return a
		 * dummy value (usually null). This implementation is due static type
		 * safety imposed by java compiler. The consequence is that you cannot
		 * use anyObject(), eq() methods outside of verified/stubbed method.
		 */
	}

	@Test
	public void _4verifyingNumberOfInvocations() {
		LinkedList<String> mockedList = mock(LinkedList.class);

		// using mock
		mockedList.add("once");

		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		// following two verifications work exactly the same - times(1) is used
		// by default
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");

		// exact number of invocations verification
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");

		// verification using never(). never() is an alias to times(0)
		verify(mockedList, never()).add("never happened");

		// verification using atLeast()/atMost()
		verify(mockedList, atLeastOnce()).add("three times"); // pelo menos uma
																// vez
		verify(mockedList, atLeast(2)).add("three times"); // pelo menoz X vezes
		verify(mockedList, atMost(5)).add("three times"); // no m�ximo X vezes

		/**
		 * times(1) is the default. Therefore using times(1) explicitly can be
		 * omitted � o mesmo que nada informar
		 */
	}

	@Test(expected = RuntimeException.class)
	public void _5stubbingVoidMethodsWithExceptions() {
		LinkedList<String> mockedList = mock(LinkedList.class);

		doThrow(new RuntimeException()).when(mockedList).clear();

		// following throws RuntimeException:
		mockedList.clear();

		/**
		 * Read more about doThrow|doAnswer family of methods in paragraph 12.
		 * 
		 * Initially, stubVoid(Object) was used for stubbing voids. Currently
		 * stubVoid() is deprecated in favor of doThrow(Throwable). This is
		 * because of improved readability and consistency with the family of
		 * doAnswer(Answer) methods.
		 */
	}

	@Test
	public void _6verificationInOrder() {

		// A. Single mock whose methods must be invoked in a particular order
		List<String> singleMock = mock(List.class);

		// using a single mock
		singleMock.add("was added first");
		singleMock.add("was added second");

		// create an inOrder verifier for a single mock
		InOrder inOrder = inOrder(singleMock);

		// following will make sure that add is first called with
		// "was added first, then with "was added second"
		inOrder.verify(singleMock).add("was added first");
		inOrder.verify(singleMock).add("was added second");

		// B. Multiple mocks that must be used in a particular order
		List<String> firstMock = mock(List.class);
		List<String> secondMock = mock(List.class);

		// using mocks
		firstMock.add("was called first");
		secondMock.add("was called second");

		// create inOrder object passing any mocks that need to be verified in
		// order
		InOrder otherOrder = inOrder(firstMock, secondMock);

		// following will make sure that firstMock was called before secondMock
		otherOrder.verify(firstMock).add("was called first");
		otherOrder.verify(secondMock).add("was called second");

		// Oh, and A + B can be mixed together at will

		/**
		 * Verification in order is flexible - you don't have to verify all
		 * interactions one-by-one but only those that you are interested in
		 * testing in order.
		 * 
		 * Also, you can create InOrder object passing only mocks that are
		 * relevant for in-order verification.
		 */
	}

	@Test
	public void _7makingSureInteractionsNeverHappenedOnMock() {
		List<String> mockOne = mock(List.class);
		List<String> mockTwo = mock(List.class);
		List<String> mockThree = mock(List.class);

		// using mocks - only mockOne is interacted
		mockOne.add("one");

		// ordinary verification
		verify(mockOne).add("one");

		// verify that method was never called on a mock
		verify(mockOne, never()).add("two");

		// verify that other mocks were not interacted
		verifyZeroInteractions(mockTwo, mockThree);
	}

	@Test
	public void _8findingRedundantInvocations() {
		List<String> mockedList = mock(List.class);

		// using mocks
		mockedList.add("one");
		// mockedList.add("two");

		verify(mockedList).add("one");

		// following verification will fail
		verifyNoMoreInteractions(mockedList);

		/**
		 * A word of warning: Some users who did a lot of classic,
		 * expect-run-verify mocking tend to use verifyNoMoreInteractions() very
		 * often, even in every test method. verifyNoMoreInteractions() is not
		 * recommended to use in every test method. verifyNoMoreInteractions()
		 * is a handy assertion from the interaction testing toolkit. Use it
		 * only when it's relevant. Abusing it leads to overspecified, less
		 * maintainable tests. You can find further reading here.
		 * http://monkeyisland
		 * .pl/2008/07/12/should-i-worry-about-the-unexpected/
		 * 
		 * See also never() - it is more explicit and communicates the intent
		 * well.
		 * http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito
		 * .html#never()
		 */
	}

	class ArticleCalculator {
	}

	class ArticleDatabase {
	}

	class UserProvider {
	}

	@Mock
	private ArticleCalculator calculator;
	@Mock
	private ArticleDatabase database;
	@Mock
	private UserProvider userProvider;

	@Test
	public void _9shorthandForMocksCreation() {
		MockitoAnnotations.initMocks(this);
		assertNotNull(calculator);
		assertNotNull(database);
		assertNotNull(userProvider);

		/**
		 * Important! This needs to be somewhere in the base class or a test
		 * runner: MockitoAnnotations.initMocks(testClass);
		 * 
		 * You can use built-in runner: MockitoJUnitRunner.
		 * http://docs.mockito.googlecode
		 * .com/hg/latest/org/mockito/runners/MockitoJUnitRunner.html
		 * 
		 * Read more here: MockitoAnnotations
		 * http://docs.mockito.googlecode.com/
		 * hg/latest/org/mockito/MockitoAnnotations.html
		 */
	}

	@Test
	public void _10stubbingConsecutiveCalls() {
		Service mocked = mock(Service.class);

		String in = "some arg";
		String out = "foo";
		Model model = new Model(in);

		when(mocked.get(in)).thenThrow(new RuntimeException())
				.thenReturn(model);

		try {
			// First call: throws runtime exception:
			mocked.get(in);
			fail();
		} catch (Exception e) {
			// sucess
		}

		// Second call: prints "foo"
		assertEquals(model, mocked.get(in));

		// Any consecutive call: prints "foo" as well (last stubbing wins).
		assertEquals(model, mocked.get(in));

		// an alternative ...
		reset(mocked);

		when(mocked.get(in)).thenReturn(new Model("one"), new Model("two"),
				new Model("three"));

		assertEquals(new Model("one"), mocked.get(in));
		assertEquals(new Model("two"), mocked.get(in));
		assertEquals(new Model("three"), mocked.get(in));
		assertEquals(new Model("three"), mocked.get(in));

		/**
		 * Sometimes we need to stub with different return value/exception for
		 * the same method call. Typical use case could be mocking iterators.
		 * Original version of Mockito did not have this feature to promote
		 * simple mocking. For example, instead of iterators one could use
		 * Iterable or simply collections. Those offer natural ways of stubbing
		 * (e.g. using real collections). In rare scenarios stubbing consecutive
		 * calls could be useful, above code!
		 */
	}

	@Test
	public void _11stubbingWithCallbacks() {

		Service mocked = mock(Service.class);
		final String cal = "called: ";
		final String var = "foo";
		when(mocked.get(var)).thenAnswer(new Answer<Model>() {
			public Model answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				return new Model(cal.concat(args[0].toString()));
			}
		});

		assertEquals(new Model(cal.concat(var)), mocked.get(var));

		/**
		 * Allows stubbing with generic Answer interface. Yet another
		 * controversial feature which was not included in Mockito originally.
		 * We recommend using simple stubbing with thenReturn() or thenThrow()
		 * only. Those two should be just enough to test/test-drive any clean &
		 * simple code.
		 */
	}

	@Test(expected = RuntimeException.class)
	public void _12doFamilyOfMethods_doThrow() { // doReturn()|doThrow()|
		// doAnswer()|doNothing()|doCallRealMethod()
		List<String> mockedList = mock(List.class);
		doThrow(new RuntimeException()).when(mockedList).clear();

		// ou passanda o tipo da classe
		// doThrow(RuntimeException.class).when(mockedList).clear();
		mockedList.clear();
	}

	@Test
	public void _12doFamilyOfMethods_doReturn() {
		List<String> list = new LinkedList<String>();
		List<String> spy = spy(list);

		try {
			when(spy.get(0)).thenReturn("foo");
			fail();
		} catch (IndexOutOfBoundsException e) {
			// sucess and expected
		}

		doReturn("foo").when(spy).get(0);
		assertEquals(spy.get(0), "foo");
	}

	@Test
	public void _12doFamilyOfMethods_doReturn_TradeOff_OverriddingStubbing() {
		List<String> mockedList = mock(List.class);
		when(mockedList.get(0)).thenThrow(NullPointerException.class);

		// faz alguma coisa e necessita reconfigurar

		try {
			when(mockedList.get(0)).thenReturn("bar");
			fail();
		} catch (NullPointerException e) {
			// sucess and expected
		}

		doReturn("bar").when(mockedList).get(0);
		assertEquals("bar", mockedList.get(0));
	}

	@Test
	public void _12doFamilyOfMethods_doAnswer_Simple()
			throws NoSuchFieldException {
		// criando cen�rio
		Service anyServiceReal = new Service();
		Repository anyRepositoryMock = mock(Repository.class);
		final String var = "bom dia";

		// injetando mock no objeto real que est� sendo testado
		PrivateAccessor.setField(anyServiceReal, "repository",
				anyRepositoryMock);

		// answer configurado retorna o objeto model j� criado
		doAnswer(new Answer<Model>() {
			public Model answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				assertEquals(var, args[0].toString());
				return new Model(var);
			}
		}).when(anyRepositoryMock).get(anyString());

		// exercitando
		Model model = anyServiceReal.get(var);

		// checando estado
		assertEquals(new Model(var), model);

		// verificando comportamento
		verify(anyRepositoryMock).get(anyString());
	}

	@Test
	public void _12doFamilyOfMethods_doAnswer_ManyAnswers()
			throws NoSuchFieldException {
		// criando cen�rio
		Service anyServiceReal = new Service();
		Repository anyRepositoryMock = mock(Repository.class);
		final String var = "bom dia";
		final Model model = new Model(var);

		// injetando mock no objeto real que est� sendo testado
		PrivateAccessor.setField(anyServiceReal, "repository",
				anyRepositoryMock);

		// answer configurado retorna o objeto model j� criado
		doAnswer(new Answer<Model>() {
			public Model answer(InvocationOnMock invocation) throws Throwable {
				return model;
			}
		}).when(anyRepositoryMock).get(anyString());

		// answer que checa se o objeto recebido foi o mesmo vindo do m�todo get
		// acima
		doAnswer(new Answer<Model>() {
			public Model answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				Model retriveModel = (Model) args[0];
				assertEquals(model, retriveModel);
				return retriveModel;
			}
		}).when(anyRepositoryMock).save(any(Model.class));

		// exercitando
		anyServiceReal.getAndUpdate(var);

		// verificando comportamento
		verify(anyRepositoryMock).get(anyString());
		verify(anyRepositoryMock).save(any(Model.class));
	}

	@Test
	public void _12doFamilyOfMethods_doNothing() {
		List<String> mockedList = mock(List.class);
		doNothing().doThrow(RuntimeException.class).when(mockedList).clear();

		// primeira vez nada faz
		try {
			mockedList.clear();
		} catch (Exception e) {
			fail();
		}

		// segunda vez
		try {
			mockedList.clear();
			fail();
		} catch (Exception e) {
			// sucess
		}
	}

	@Test
	public void _12doFamilyOfMethods_doNothing_When_Spy() {
		List<String> spy = spy(new LinkedList<String>());

		// let's make clear() do nothing
		doNothing().when(spy).clear();
		when(spy.size()).thenReturn(100);

		spy.add("one");
		spy.clear();

		assertEquals(100, spy.size());
		assertEquals("one", spy.get(0));
	}

	@Test
	public void _12doFamilyOfMethods_doCallRealMethod() {
		final String var = "hello";
		Repository repositoryMock = mock(Repository.class);
		assertNull(repositoryMock.get(var));

		doCallRealMethod().when(repositoryMock).get(anyString());
		assertEquals(new Model(var), repositoryMock.get(var));
	}

	@Test
	public void _13_spyingOnRealObjects() {
		List<String> list = new LinkedList<String>();
		List<String> spy = spy(list);

		// optionally, you can stub out some methods:
		when(spy.size()).thenReturn(100);

		// using the spy calls *real* methods
		spy.add("one");
		spy.add("two");

		// prints "one" - the first element of a list
		assertEquals("one", spy.get(0));
		assertEquals("two", spy.get(1));

		// size() method was stubbed - 100 is printed
		assertEquals(100, spy.size());

		// optionally, you can verify
		verify(spy).add("one");
		verify(spy).add("two");

		// veja tamb�m o m�todo > _12doFamilyOfMethods_doReturn

		/**
		 * Important gotcha on spying real objects! <br/>
		 * <br/>
		 * 1. Sometimes it's impossible or impractical to use when(Object) for
		 * stubbing spies. Therefore when using spies please consider
		 * doReturn|Answer|Throw() family of methods for stubbing. Veja exemplo
		 * no m�todo > _12doFamilyOfMethods_doReturn <br/>
		 * <br/>
		 * 2. Mockito *does not* delegate calls to the passed real instance,
		 * instead it actually creates a copy of it. So if you keep the real
		 * instance and interact with it, don't expect the spied to be aware of
		 * those interaction and their effect on real instance state. The
		 * corollary is that when an *unstubbed* method is called *on the spy*
		 * but *not on the real instance*, you won't see any effects on the real
		 * instance.<br/>
		 * <br/>
		 * 3. Watch out for final methods. Mockito doesn't mock final methods so
		 * the bottom line is: when you spy on real objects + you try to stub a
		 * final method = trouble. Also you won't be able to verify those method
		 * as well.
		 */
	}

	@Test
	public void _14changingDefaultReturnValuesOfUnstubbedInvocations() {
		
		Service serviceMock = mock(Service.class, Mockito.RETURNS_SMART_NULLS);
		
		final String msg = new Service().palavrao; 
		Service serviceMockTwo = mock(Service.class, new Answer<String>() {
			public String answer(InvocationOnMock invocation) throws Throwable {
				return msg;
			}
		});
		
		assertEquals( StringUtils.EMPTY, serviceMock.message() );
		assertEquals( msg, serviceMockTwo.message() );
		
		/**
		 * You can create a mock with specified strategy for its return values.
		 * It's quite advanced feature and typically you don't need it to write
		 * decent tests. However, it can be helpful for working with legacy
		 * systems. It is the default answer so it will be used only when you
		 * don't stub the method call.
		 */
	}
	
	@Test // http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html#15
	public void _15capturingArgumentsForFurtherAssertions() throws NoSuchFieldException {
		// criando cen�rio
		Service anyServiceReal = new Service();
		Repository anyRepositoryMock = mock(Repository.class);
		
		// injetando mock no objeto real que est� sendo testado
		PrivateAccessor.setField(anyServiceReal, "repository", anyRepositoryMock);
		
		// exercitando
		anyServiceReal.get("33");
		
		// checando resultados
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		verify( anyRepositoryMock ).get( argument.capture() );
		
		/**
		 * favor olhar o mesmo exemplo e seu resumo de uso 
		 * https://gist.github.com/rafarocha/8030136
		 */
	}
	
	@Test // http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html#15
	public void _15capturingArgumentsForFurtherAssertionsWithoutArgumentCaptor() throws NoSuchFieldException {
		// criando cen�rio
		Service anyServiceReal = new Service();
		Repository anyRepositoryMock = mock(Repository.class);
		
		// injetando mock no objeto real que est� sendo testado
		PrivateAccessor.setField(anyServiceReal, "repository", anyRepositoryMock);
		
		final String id = "33";

		// realizando stubbing 
		when( anyRepositoryMock.get( id )).then( new Answer<Model>() {
			public Model answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				assertEquals(id, args[0]);
				return new Model(id);
			}
		} );
		
		// exercitando
		Model model = anyServiceReal.get(id);
		
		// checagem: comportamento + valor passado ao m�todo
		verify(anyRepositoryMock).get( model.id );
	}
	
	@Test
	public void _16realPartialMocks() throws NoSuchFieldException {
		// veja tamb�m _12doFamilyOfMethods_doNothing_When_Spy		
		// exemplo abaixo arquitetura tradicional		
		Repository mock = mock(Repository.class);
		when(mock.get(anyString())).thenCallRealMethod();
		
		Service anyServiceReal = new Service();
		PrivateAccessor.setField(anyServiceReal, "repository", mock);
		
		final String id = "13";
		Model model = anyServiceReal.get(id);
		assertEquals("retorna modelo id " + id, id, model.id);
	}
	
	@Test
	public void _17resettingMocks () {
		List<Integer> mock = mock(List.class);
		when(mock.size()).thenReturn(10);
		mock.add(1);
		
		assertEquals(10,  mock.size());		
		reset(mock);
		assertEquals(0,  mock.size());
	}
	
	@Test
	public void _18troubleshootingValidatingFrameworkUsage() {
		List<Integer> mock = mock(List.class);
		
		try {
			when( mock.size() );			
		} catch (Exception e) {
			fail();
		}
		
		try {
			when( mock.size() );			
			validateMockitoUsage(); // recomendado chamar no @After, ent�o use uma su�te e herde-a colocando ele
			fail();
		} catch (Exception e) {
			// sucess
		}
	}
	
	@Test
	public void _19AliasesBDD() {
		Repository mock = mock(Repository.class);
		Service service = new Service(mock);
		
		// given 
		String id = "33";
		Model model = new Model(id);
		BDDMockito.given(mock.get(anyString())).willReturn( model );
		
		// when 
		Model found = service.get(id);
		
		// then
		assertEquals(model.id, found.id);
	}
	
	@Test @Ignore
	public void _20SerializableMocks() {}
	
	// mais sobre http://docs.mockito.googlecode.com/hg/latest/org/mockito/InjectMocks.html
	
	@Test
	public void _21Newannotations_InjectMocks_Mock() {
		service.message();
		verify(repositoryMock).message();
		// fiz apenas com @Mock mas tamb�m tem @Spy, mas d� bug 
		// tive que criar classes .java pois tem limita��es com inner classes, etc. 
		//http://docs.mockito.googlecode.com/hg/latest/org/mockito/InjectMocks.html
	}
	
	@Captor 
	private ArgumentCaptor<String> captor;
	
	@Test
	public void _21Newannotations_InjectMocks_Captor() throws NoSuchFieldException {
		// exercitando
		service.get("33");
		
		// checando resultados
		verify( repositoryMock ).get( captor.capture() );
		// existe uma falha se eu fizer a seguinte tosqueira
		// verify( repository ).get( "3" + captor.capture() );
		// acredito que o captor s� � verificado internamente ent�o nao adianta eu modificar propositalmente
		
	}
	
	@Test @Ignore
	public void _22VerificationWithTimeout() {}
	
	// ao inv�s de usar dando new, � s� injetar
	// o nome do atributo � diferente porque usei em exemplo anterior com @Mock	
//	@Mock
//	private Repository repositorySpy;
	
	@Test @Ignore
	public void _23AutomaticInstantiationOf_Spies_InjectMocks_and_ConstructorInjectionGoodness() {
//		exercitando
//		serviceSpy.get("33");
		
		// checando resultados
//		verify( repositorySpy ).get( captor.capture() );
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// O U T R O S . C E N � R I O S
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@Test
	public void howTestVoidMethod() throws NoSuchFieldException {
		// criando cen�rio
		Service anyServiceReal = new Service();
		Repository anyRepositoryMock = mock(Repository.class);
		final String var = "bom dia";

		// injetando mock no objeto real que est� sendo testado
		PrivateAccessor.setField(anyServiceReal, "repository",
				anyRepositoryMock);

		// exercitando
		anyServiceReal.save(var);

		// verificando comportamento
		verify(anyRepositoryMock).get(anyString());
		verify(anyRepositoryMock).save(any(Model.class));
	}

	@Test
	public void howCheckMessageWhenExceptionIsThrow() // sem e +1args
			throws NoSuchFieldException {
	}
	
	// TODO implementar howCheckMessageWhenExceptionIsThrow

	// TODO problema do validateMockitoUsage
	// http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html#validateMockitoUsage()
	
	// TODO entender e implementar _14changingDefaultReturnValuesOfUnstubbedInvocations
	
}