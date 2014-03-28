package br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia;

import java.util.List;

import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Funcionalidade;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Modelo;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Projeto;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Prototipo;

public class Pacote {

	public Modelo modelo;
	public Projeto projeto;
	public Prototipo prototipo;
	public List<Funcionalidade> funcionalidades;
	
	public Pacote(Modelo mod, Prototipo pro, List<Funcionalidade> funs) {
		this.modelo = mod;
		this.prototipo = pro;
		this.funcionalidades = funs;
	}
	
}