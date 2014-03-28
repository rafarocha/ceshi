package br.edu.curso.mockito.exemplo.geral;

import java.util.Map;

import br.edu.curso.mockito.exemplo.geral.Social.FacebookClient;
import br.edu.curso.mockito.exemplo.geral.Social.TwitterClient;

import com.google.common.collect.Maps;

public class Suporte {
	
	private static Map<RedeSocial, Social> servicos = Maps.newHashMap();
	static {
		servicos.put(RedeSocial.Twitter, new TwitterClient() );
		servicos.put(RedeSocial.Facebook, new FacebookClient() );
	}
	
	public static Social obter(RedeSocial rede) {
		return servicos.get( rede );
	}

}