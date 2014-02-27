package br.edu.curso.teste.experimentos.junit.theory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.experimental.theories.ParametersSuppliedBy;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(value=PositiveIntegerParameterSupplier.class)
public @interface AnyPositive {

}