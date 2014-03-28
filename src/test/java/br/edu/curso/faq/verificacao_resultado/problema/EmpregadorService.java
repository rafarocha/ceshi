package br.edu.curso.faq.verificacao_resultado.problema;

import static br.edu.curso.faq.verificacao_resultado.problema.Oportunidade.Situacao.ACEITA;
import static br.edu.curso.faq.verificacao_resultado.problema.Trabalhador.Situacao.EMPREGADO;
import static br.edu.curso.faq.verificacao_resultado.problema.Vaga.Situacao.PREENCHIDA;

import java.util.Queue;

public class EmpregadorService {
	
	private OportunidadeDAO oportunidadeDAO;
	private TrabalhadorDAO trabalhadorDAO;
	private ContratacaoDAO contratacaoDAO;
	private VagaDAO vagaDAO;

	public void contratar( Encaminhamento enc ) {
		Oportunidade oportunidade = new Oportunidade( enc ).set( ACEITA );
		oportunidadeDAO.inserir( oportunidade );
		
		Contratacao quadro = enc.selecao.get( enc.vaga );
		quadro.quantidade -= 1;
		if ( quadro.quantidade == 0 ) {
			enc.vaga.set( PREENCHIDA );
		}
		vagaDAO.atualizar( enc.vaga );
		contratacaoDAO.atualizar( quadro );

		enc.trabalhador.set( EMPREGADO );
		trabalhadorDAO.atualizar( enc.trabalhador );
	}
}

class Trabalhador {
	public Situacao situacao;
	
	enum Situacao {
		DESEMPREGADO, EMPREGADO;
	}
	public Trabalhador set(Situacao sit) {
		this.situacao = sit; return this;
	}
}
class Vaga {
	public Funcao funcao;
	public Situacao situacao;
	
	enum Situacao {
		ABERTA, PREENCHIDA;
	}
	enum Funcao {
		Cozinheiro, Atendente;
	}
	public Vaga set(Situacao sit) {
		this.situacao = sit; return this;
	}
}
class Oportunidade {
	public Encaminhamento encaminhamento;
	public Situacao situacao;
	
	enum Situacao {
		ESPERA, ACEITA, NEGADA, CANCELADA
	}
	public Oportunidade(Encaminhamento enc) {
		this.encaminhamento = enc;
		this.situacao = Situacao.ESPERA;
	}
	public Oportunidade set(Situacao sit) {
		this.situacao = sit; return this;
	}
	public Oportunidade set(Encaminhamento enc) {
		this.encaminhamento = enc; return this;
	}
}
class Encaminhamento {
	public Vaga vaga;
	public Trabalhador trabalhador;
	public Selecao selecao;
	public Encaminhamento(Selecao sel, Vaga vaga, Trabalhador trab) {
		this.vaga = vaga;
		this.trabalhador = trab;
		this.selecao = sel;
	}
}
class Selecao {
	public Queue<Contratacao> quadro;
	public Situacao situacao;
	
	enum Situacao {
		ABERTA, EXPIRADO, CANCELADA, LOTADO 
	}
	public Contratacao get(Vaga vaga) {
		for (Contratacao contratacao : this.quadro) {
			if ( contratacao.vaga.equals( vaga ) ) {
				return contratacao;
			}
		}
		return null;
	}
}
class Contratacao {
	public Vaga vaga;
	public int quantidade;

	// enviar até 5 trabalhadores para entrevista ao empregador
	public static final int encaminhamentos = 5; 
}

// -------- DAOs
class OportunidadeDAO {
	public void inserir(Oportunidade o) {}
}
class VagaDAO {
	public void atualizar(Vaga v) {}
}
class TrabalhadorDAO {
	public void atualizar(Trabalhador trab) {}
}
class ContratacaoDAO {
	public void atualizar(Contratacao cont) {}	
}