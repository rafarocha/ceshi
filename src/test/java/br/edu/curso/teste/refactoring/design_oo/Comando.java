package br.edu.curso.teste.refactoring.design_oo;

/**
 * Nesta classe veja o método <code>go(Chave):void </code> <br>
 * Neste método, imagine que cada <code>case</code> possui 30 linhas<br>
 * Avalie a necessidade de refatorar de forma que:
 * 
 * <ul>
 * <li>Não utilize ou adicione nenhuma condição, inclusive o próprio <code>switch</code> </li>
 * <li>O comportamento deve ser preservado, então para se certificar rode <code>ComandoTest</code></li>
 * </ul> 
 * 
 * Este exercício tem uma pegadinha :) <br>
 * http://www.refactoring.com/catalog/replaceConditionalWithPolymorphism.html
 * http://www.refactoring.com/catalog/replaceTypeCodeWithStateStrategy.html
 */
public class Comando {
	
	private ServicoA servicoA;
	private ServicoB servicoB;
	
	public void go(Chave chave) {
		if (chave == null) return;
			
		switch (chave) {
			case ALFA: {
				servicoA.acaoX();
				servicoB.acaoH();
				break;
			}
			case DELTA: {
				servicoA.acaoY();
				servicoB.acaoI();
				break;
			}
			case GAMA: {
				servicoA.acaoZ();
				servicoB.acaoJ();
				break;
			}
		}
	}
	
	interface ServicoA {
		void acaoX();
		void acaoY();
		void acaoZ();
	}
	
	interface ServicoB {
		void acaoH();
		void acaoI();
		void acaoJ();
	}
	
	enum Chave {
		DELTA, ALFA, GAMA
	}
	
} 