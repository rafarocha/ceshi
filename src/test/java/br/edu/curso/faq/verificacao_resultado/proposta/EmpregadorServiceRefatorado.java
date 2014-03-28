package br.edu.curso.faq.verificacao_resultado.proposta;

import static br.edu.curso.faq.verificacao_resultado.proposta.Oportunidade.Situacao.ACEITA;
import static br.edu.curso.faq.verificacao_resultado.proposta.Trabalhador.Situacao.EMPREGADO;
import static br.edu.curso.faq.verificacao_resultado.proposta.Vaga.Situacao.PREENCHIDA;

import java.util.Queue;

import com.google.common.base.Objects;

public class EmpregadorServiceRefatorado {
	
	private OportunidadeDAO oportunidadeDAO;
	private VagaDAO vagaDAO;
	private TrabalhadorDAO trabalhadorDAO;
	private ContratacaoDAO contratacaoDAO;

	public void contratar( Empregador empregador, Carta carta ) {
		// tratar quando nao houver mais vagas, o quadro estiver completo

		Oportunidade oportunidade = empregador.contratar( carta );
		
		oportunidadeDAO.inserir( oportunidade );
		vagaDAO.atualizar( carta.vaga );
		trabalhadorDAO.atualizar( carta.trabalhador );
		
		Contratacao contratacao = carta.getContratacao();
		contratacaoDAO.atualizar( contratacao );
	}
	
}

class Trabalhador {
	public Situacao situacao;
	
	public Trabalhador() {
		this.situacao = Situacao.DESEMPREGADO;
	}
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
	
	public Vaga(Funcao funcao) {
		this.funcao = funcao;
		this.situacao = Situacao.ABERTA;
	}
	enum Situacao {
		ABERTA, PREENCHIDA;
	}
	enum Funcao {
		Cozinheiro, Programador;
	}
	public Vaga set(Situacao sit) {
		this.situacao = sit; return this;
	}
	@Override public boolean equals(Object obj) {
		if(obj == this) return true;
		if(obj == null) return false;
		if ( !(obj instanceof Vaga) ) return false;
		
		Vaga vaga = (Vaga) obj;
		return Objects.equal(vaga.funcao, this.funcao); 
	}
}
class Oportunidade {
	public Carta carta;
	public Situacao situacao;
	
	enum Situacao {
		ESPERA, ACEITA, NEGADA, CANCELADA
	}
	public Oportunidade(Carta enc) {
		this.carta = enc;
		this.situacao = Situacao.ESPERA;
	}
	public Oportunidade set(Situacao sit) {
		this.situacao = sit; return this;
	}
	public Oportunidade set(Carta enc) {
		this.carta = enc; return this;
	}
}
class Carta {
	public int codigo;
	
	public Trabalhador trabalhador;
	public Vaga vaga;
	
	private Selecao selecao;
	
	public Carta(Selecao sel, Vaga vaga, Trabalhador trab) {
		this.vaga = vaga;
		this.trabalhador = trab;
		this.selecao = sel;
		this.codigo = (int) Math.random();
	}
	@Override public boolean equals(Object obj) {
		if(obj == this) return true;
		if(obj == null) return false;
		if ( !(obj instanceof Carta) ) return false;
		
		Carta enc = (Carta) obj;
		return Objects.equal(enc.codigo, this.codigo); 
	}
	public Contratacao getContratacao() {
		for (Contratacao contratacao : this.selecao.quadro) {
			if ( contratacao.vaga.equals( this.vaga ) ) {
				return contratacao;
			}
		}
		return null;
	}
}
class Selecao {
	public Queue<Contratacao> quadro;
	public Situacao situacao;
	
	enum Situacao {
		ABERTA, EXPIRADO, CANCELADA, LOTADO 
	}
}
class Contratacao {
	public Vaga vaga;
	public int quantidade;

	public boolean preenchida() {
		if ( quantidade == 0 ) return true;
		return false;
	}
}
class Empregador {
	public Oportunidade contratar(Carta carta) {
		Oportunidade oportunidade = new Oportunidade( carta ).set( ACEITA );
		Vaga vaga = carta.vaga;
		
		Contratacao quadro = carta.getContratacao();
		quadro.quantidade -= 1;
		if ( quadro.quantidade == 0 ) {
			vaga.set( PREENCHIDA );
		}

		carta.trabalhador.set( EMPREGADO );		
		return oportunidade;
		
	}
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