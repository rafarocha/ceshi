package br.edu.curso.util;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.io.IOUtils;
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;

public class Util {

	public static String carregarArquivo(Class<?> klazz, String name) throws IOException {
		try {
			InputStream is = klazz.getResourceAsStream(name);
			assertNotNull( "não conseguiu carregar o arquivo", is );
			
			StringWriter writer = new StringWriter();
			IOUtils.copy(is, writer);
			return writer.toString();
		} catch (IOException e) {
			throw new IOException( "verifique também permissão diretório/arquivo", e );
		}
	}

	public static String getName(Class<?> klazz) {
		return klazz.getSimpleName().toLowerCase();
	}

	public static String formatarSQL(String sql) {
		return new BasicFormatterImpl().format(sql);
	}

	public static String hash(Algoritmo algo, String palavra) {
		try {
			MessageDigest md = MessageDigest.getInstance(algo.toString());
			md.update(palavra.getBytes());
			return hexaToString( md.digest() );
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public enum Algoritmo {
		MD5;
	}

	private static String hexaToString(byte[] bytes) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
			int parteBaixa = bytes[i] & 0xf;
			if (parteAlta == 0)
				s.append('0');
			s.append(Integer.toHexString(parteAlta | parteBaixa));
		}
		return s.toString();
	}

}