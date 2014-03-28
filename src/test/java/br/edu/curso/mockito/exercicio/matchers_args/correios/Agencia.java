package br.edu.curso.mockito.exercicio.matchers_args.correios;

import java.util.Date;

import br.edu.curso.mockito.exercicio.matchers_args.correios.Telegrama.Despachador;
import br.edu.curso.mockito.exercicio.matchers_args.correios.Telegrama.Funcionario;

import com.google.common.collect.Ranges;

public class Agencia {
	
	private Funcionario funcionario;
	private Despachador despachador;
	private Inspetoria[] inspetores;
	
	public Agencia(Funcionario func, Despachador desp, Inspetoria ... ins) {
		this.funcionario = func;
		this.despachador = desp;
		this.inspetores = ins;
	}
	
	boolean enviar(String texto, Date data, Envelope envelope) {
		Telegrama telegrama = funcionario.preparar( texto, data, envelope );
		this.inspecao( telegrama );
		this.despachador.entregar( telegrama );
		return true;
	}
	void inspecao(Telegrama telegrama) {
		this.validar(telegrama);
		for (Inspetoria inspetor : inspetores) {
			inspetor.validar( telegrama );							
		}
	}
	private void validar(Telegrama telegrama) {
		int tamanhoTexto = telegrama.texto.length();
		boolean valido = Ranges.closed(10, 200).apply( tamanhoTexto );
		if ( !valido ) {
			throw new IllegalStateException("deve ter de 10 a 100 caracteres");
		}
	}

}