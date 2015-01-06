package br.edu.curso.dubles.stub.exemplo.facebook;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import facebook4j.FacebookException;
import facebook4j.User;

@RunWith(MockitoJUnitRunner.class) // apenas para desintegrar API facebook 
public class StubFacebookTest {
	
	private FacebookBroker broker;
	
	@Before public void before() {
		this.broker = this.configuraBroker();
	}
	
	@Test public void shouldPostFeedSuccessFully() throws FacebookException {
		String contact = "Megan Fox";
		User user = broker.getContact(contact);
		boolean sucess = broker.sendEmail( user );
		assertTrue( sucess );
	}
	
	public FacebookBroker configuraBroker() {
		return FacebookBroker.builder()
				.facebook( new FacebookStub() )
				.mailer( new MailerStub() )
				.build();
	}
	
}