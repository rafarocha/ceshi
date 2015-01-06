package br.edu.curso.mockito.exemplo.basico;

import static org.apache.commons.lang.StringUtils.isEmpty;
import static org.apache.commons.lang.StringUtils.strip;

public class ComecandoMockitoTest {

	/*
	 * vamos experimentar
	 * -------------
	 * 1. mock   > basico
	 * 2. mock   > com MockingSettings (extra interface)
	 * 3. stub   > entrada externa
	 * 4. verify > asserções
	 * ---
	 * 5. dummy  > anyXXX
	 * 6. spy    > espia ou permite saber/interagir comportamento real 
	 */
	
	class PortaoEletronico {
		private Dispositivo dispositivo;		
		public PortaoEletronico(Dispositivo dispositivo) {
			this.dispositivo = dispositivo;
		}
		public boolean abrir(String chave) {
			return dispositivo.destravar(chave);
		}
	}
	class Dispositivo {
		private String chave;
		public Dispositivo() {
			this.chave = String.valueOf(Math.random());
		}
		public boolean destravar(String chave) {
			if (isEmpty( strip(chave) )) throw new IllegalArgumentException();
			return chave.equals(this.chave); 
		}
	}

}