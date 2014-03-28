package br.edu.curso.dubles.stub.exemplo.facebook;

import facebook4j.User;

public interface IMailer {
	
	boolean sendMail(User user);

}