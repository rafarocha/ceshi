package br.edu.curso.faq.verificacao_resultado.proposta;

import static org.mockito.Matchers.any;
import junitx.util.PrivateAccessor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmpregadorServiceRefatoradoTest {
	
	private EmpregadorServiceRefatorado service;
	private Empregador empregador;
	
	@Mock private OportunidadeDAO oportunidadeDAOMock;
	@Mock private ContratacaoDAO contratacaoDAOMock;
	@Mock private VagaDAO vagaDAOMock;
	@Mock private TrabalhadorDAO trabalhadorDAOMock;
	
	@Before public void before() throws NoSuchFieldException {
		this.service = new EmpregadorServiceRefatorado();
		this.empregador = new Empregador();
		
		PrivateAccessor.setField(service, "oportunidadeDAO", oportunidadeDAOMock);
		PrivateAccessor.setField(service, "contratacaoDAO", contratacaoDAOMock);
		PrivateAccessor.setField(service, "vagaDAO", vagaDAOMock);
		PrivateAccessor.setField(service, "trabalhadorDAO", trabalhadorDAOMock);
	}
	
	@Test public void contratarQuandoHouverApenasUmaVaga() {
		final Carta carta = Maker.criaCartaTrabalhadorDesempregadoComSelecaoApenasUmaVaga();
		
		service.contratar( this.empregador, carta );
		
		InOrder inOrder = Mockito.inOrder( oportunidadeDAOMock, vagaDAOMock, trabalhadorDAOMock, contratacaoDAOMock );
		inOrder.verify( oportunidadeDAOMock ).inserir( any(Oportunidade.class) );
		inOrder.verify( vagaDAOMock ).atualizar( any(Vaga.class) );
		inOrder.verify( trabalhadorDAOMock ).atualizar( any(Trabalhador.class) );		
		inOrder.verify( contratacaoDAOMock ).atualizar( any(Contratacao.class) );
	}
	
}