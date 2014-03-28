package br.edu.curso.dubles.stub.exemplo.facebook;

import facebook4j.User;

public class MailerStub implements IMailer {

	public static final String sendmsg = 
			"sending email stubber :) to %s";
	public boolean sendMail(User user) {
		System.out.println( String.format(sendmsg, user.getName()) );
		return true;
	}

}