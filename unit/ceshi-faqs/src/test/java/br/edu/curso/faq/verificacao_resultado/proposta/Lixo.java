package br.edu.curso.faq.verificacao_resultado.proposta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static br.edu.curso.faq.verificacao_resultado.proposta.Oportunidade.Situacao.ACEITA;

import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.Stubber;

@SuppressWarnings(value={"unchecked","unused"})
public class Lixo {
	
	@Mock private OportunidadeDAO oportunidadeDAOMock;
	@Mock private ContratacaoDAO contratacaoDAOMock;
	@Mock private VagaDAO vagaDAOMock;
	@Mock private TrabalhadorDAO trabalhadorDAOMock;
	
	private void checarTrabalhadorQuandoEmpregado() {
		doAnswer( new Answer<Trabalhador>() {
			public Trabalhador answer(InvocationOnMock invocation) throws Throwable {
				Trabalhador trabalhador = (Trabalhador) invocation.getArguments()[0];
				assertEquals(Trabalhador.Situacao.EMPREGADO, trabalhador.situacao);
				return null;
			}
		}).when( trabalhadorDAOMock ).atualizar(any(Trabalhador.class) );
	}

	private void checarVagaQuandoPreenchida() {
		new TemplateStub<Vaga>() {
			@Override public void checar(Vaga vaga) {
				assertEquals(Vaga.Situacao.PREENCHIDA, vaga.situacao);
			}
		}.execute().when( vagaDAOMock ).atualizar( any(Vaga.class) );
	}

	private void checarOportunidadeAceitaQuandoInserir(final Carta carta) {
		new TemplateStub<Oportunidade>() {
			@Override public void checar(Oportunidade oportunidade) {
				assertEquals(ACEITA, oportunidade.situacao);
				assertEquals(carta, oportunidade.carta);
			}
		}.execute().when( oportunidadeDAOMock ).inserir( any(Oportunidade.class) );
	}

	private void checarContratacaoPreenchidaQuandoAtualizar() {
		new TemplateStub<Contratacao>() {
			@Override public void checar(Contratacao contratacao) {
				assertTrue( contratacao.preenchida() );
			}
		}.execute().when( contratacaoDAOMock ).atualizar( any(Contratacao.class) );
	}

	abstract class TemplateStub<T> {
		public abstract void checar(T t);
		public Stubber execute() {
			return doAnswer( new Answer<T>() {
				public T answer(InvocationOnMock invocation) throws Throwable {
					T algo = (T) invocation.getArguments()[0];
					checar( algo );
					return null;
				}
			});
		}
	}

}