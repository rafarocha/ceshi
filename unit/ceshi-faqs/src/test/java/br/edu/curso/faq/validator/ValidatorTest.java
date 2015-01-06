package br.edu.curso.faq.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {
	
	private Validator validator;
	
	@Before public void before() {
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Test public void validaGrupoNaoNulo() {
		assertFalse( validar(new Produto(), Grupo.class).isEmpty() );
		assertTrue ( validar(new Categoria()).isEmpty() );
	}
	
	private <O> Set<ConstraintViolation<O>> validar(O obj, Class<?> group) {
		return validator.validate( obj, group);
	}
	
	private <O> Set<ConstraintViolation<O>> validar(O obj) {
		return validator.validate( obj );
	}
	
	class Produto {
		@NotNull(message=Mensagem.MSG_OBJ_NULO, groups=Grupo.class)
		public String nome;
	}
	
	class Categoria {
		@NotNull(message=Mensagem.MSG_OBJ_NULO, groups=Grupo.class)
		public String nome;
		
		@Size(min=2,max=5,message=Mensagem.MSG_LISTA_2_5_ELEMENTOS)
		public List<String> lista;
	}
	
	interface Grupo {}
	interface Mensagem {
		String MSG_OBJ_NULO = "não pode ser nulo";		
		String MSG_LISTA_2_5_ELEMENTOS = "lista deve ter de 2 a 5 elementos";		
	}

}