package br.edu.curso.faq.metodo_privado;

import java.lang.reflect.Method;

import net.vidageek.mirror.dsl.Mirror;

public class ReflexaoMirrorHelper {
	
	private static Mirror mirror = new Mirror();
	
	public static <T> Method getMetodo(String nome, Class<T> target, Class<?> param ) {
		return mirror.on( target ).reflect().method( nome ).withArgs( param );
	}
	
	@SuppressWarnings("unchecked")
	public static <T, U> U invoke(Method metodo, Class<?> target, Object arg) {
		return (U) mirror.on( target ).invoke().method( metodo ).withArgs( arg );		
	}
	
}