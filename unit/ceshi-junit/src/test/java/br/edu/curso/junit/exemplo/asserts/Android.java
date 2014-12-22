package br.edu.curso.junit.exemplo.asserts;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

import com.google.common.base.Objects;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Android {
	
	public String serie;
	public String lote;
	public String ano;
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass() ) {
			return false;
		}
		
		final Android android = (Android) obj;
		
		return Objects.equal(this.serie, android.serie) 
				&& Objects.equal(this.lote, android.lote)
				&& Objects.equal(this.ano, android.ano);
	}

}