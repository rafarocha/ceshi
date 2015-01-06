package br.edu.curso.dubles.stub.exemplo.facebook;

import javax.mail.Message.RecipientType;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;

import com.google.common.base.Preconditions;

import facebook4j.User;

public class MailerImpl implements IMailer {

	private Mailer mailer;

	public boolean sendMail(User user) {
		Preconditions.checkArgument( user != null );
		Email email = new Email();
		email.setFromAddress("Eu", "eu@mail.com");
		email.setSubject("Convite para jantar");
		email.addRecipient(user.getName(), user.getEmail(), RecipientType.TO);
		email.setText("Olá Megan, gostaria de jantar comigo hoje à noite?");
		
		this.mailer.sendMail(email);
		return true;
	}
	
}