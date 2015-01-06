package br.edu.curso.mockito.exemplo.geral;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class LoginInfo {
	
	public String user; 
	public String pswd;
	public RedeSocial rede;

}