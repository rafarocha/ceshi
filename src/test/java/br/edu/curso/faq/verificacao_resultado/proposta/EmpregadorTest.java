package br.edu.curso.faq.verificacao_resultado.proposta;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EmpregadorTest {
	
	private Empregador empregador;
	
	@Before public void before() {
		this.empregador = new Empregador();
	}
	
	@Test public void contratarQuandoHouverApenasUmaVaga() {
		Carta carta = Maker.criaCartaTrabalhadorDesempregadoComSelecaoApenasUmaVaga();
		int vagasDisponiveis = carta.getContratacao().quantidade;
		
		Oportunidade oportunidade = this.empregador.contratar( carta );
		
		assertEquals(oportunidade.carta, carta);
		assertEquals(Oportunidade.Situacao.ACEITA, oportunidade.situacao);
		assertEquals( Trabalhador.Situacao.EMPREGADO, carta.trabalhador.situacao);

		assertEquals(vagasDisponiveis - 1, carta.getContratacao().quantidade );
		assertEquals( Vaga.Situacao.PREENCHIDA, carta.vaga.situacao);		
	}

}