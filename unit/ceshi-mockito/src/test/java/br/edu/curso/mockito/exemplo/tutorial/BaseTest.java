package br.edu.curso.mockito.exemplo.tutorial;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

public class BaseTest {

	@Mock 	protected Repository repositoryMock;
//	@Spy 	protected Repository repositorySpy;
	@InjectMocks protected Service service;
	
}