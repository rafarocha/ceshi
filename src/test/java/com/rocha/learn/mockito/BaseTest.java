package com.rocha.learn.mockito;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

public class BaseTest {

	@Mock 	protected Repository repositoryMock;
//	@Spy 	protected Repository repositorySpy;
	@InjectMocks protected Service service;
	
}