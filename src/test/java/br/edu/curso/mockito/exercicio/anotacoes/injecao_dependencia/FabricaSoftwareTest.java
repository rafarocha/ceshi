package br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Processo.Analista;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Processo.Arquiteto;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Processo.Cliente;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Processo.Designer;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Processo.Programador;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Ideia;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Modelo;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Projeto;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Prototipo;

@RunWith(MockitoJUnitRunner.class)
public class FabricaSoftwareTest {
	
	@InjectMocks private Fabrica fabrica;
	
	@Mock private Analista analistaMock;
	@Mock private Designer designerMock;
	@Mock private Arquiteto arquitetoMock;
	@Mock private Cliente clienteMock;
	@Mock private Programador programadorMock;
	
	private Ideia financeiro = Ideia.Financeiro;
	
	@Test public void fabricarSucesso() {
		Sistema sistema = this.fabrica.fabricar( financeiro );
		assertNotNull( sistema );
		this.checarProcessoFabril();
	}

	private void checarProcessoFabril() {
		InOrder inOrder = this.esquematizarOrdem();
		inOrder.verify( clienteMock ).aprovar( any(Prototipo.class), any(Modelo.class) );
		inOrder.verify( designerMock ).prototipar( financeiro );
		inOrder.verify( arquitetoMock ).projetar( any(Pacote.class) );
		inOrder.verify( analistaMock ).modelar( financeiro );
		inOrder.verify( programadorMock ).desenvolver( any(Pacote.class), any(Projeto.class) );
	}
	
	private InOrder esquematizarOrdem() {
		return Mockito.inOrder( clienteMock, designerMock, 
				analistaMock, arquitetoMock, programadorMock );
	}

}