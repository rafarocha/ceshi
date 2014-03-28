package br.edu.curso.dubles.stub.exemplo.facebook;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.ResponseList;
import facebook4j.User;

/**
 * Mais exemplos da API Facebook e SimpleMail
 * http://facebook4j.org/en/code-examples.html
 * https://code.google.com/p/simple-java-mail/wiki/Manual 
 */
@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class FacebookBroker {
	
	public static final int FIRST = 0;
	
	private Facebook facebook;
	private IMailer mailer;
	
	public User getContact(String name) throws FacebookException {
		ResponseList<User> results = this.facebook.searchUsers("Megan Fox");
		if ( results.isEmpty() )
			throw new RuntimeException("Contact not found");
		
		User user = results.get(FIRST);
		return user;
	}
	
	public boolean sendEmail(User user) {
		return mailer.sendMail(user);
	}

}