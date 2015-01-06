package br.edu.curso.refactoring.exemplo.design_oo;

/**
 * Nesta classe veja o m�todo <code>go(Chave):void </code> <br>
 * Neste m�todo, imagine que cada <code>case</code> possui 30 linhas<br>
 * Avalie a necessidade de refatorar de forma que:
 * 
 * <ul>
 * <li>N�o utilize ou adicione nenhuma condi��o, inclusive o pr�prio <code>switch</code> </li>
 * <li>O comportamento deve ser preservado, ent�o para se certificar rode <code>ComandoTest</code></li>
 * </ul> 
 * 
 * Este exerc�cio tem uma pegadinha :) <br>
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