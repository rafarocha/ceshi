package br.edu.curso.mockito.exemplo.spy.basico;

public class OrderDao {
	
	public Order getOrder(int irderId){
		throw new UnsupportedOperationException("Fail is not mocked!");
	}

}