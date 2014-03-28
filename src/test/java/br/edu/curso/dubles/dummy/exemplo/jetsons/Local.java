package br.edu.curso.dubles.dummy.exemplo.jetsons;

import br.edu.curso.dubles.dummy.exemplo.jetsons.Objeto.Nave;

import com.google.common.base.Preconditions;

public class Local {
	
	double latitude;
	double longitude;
	double altitude;
	
	public Local(int lat, int lng, int alt) {
		this.latitude = lat;
		this.longitude = lng;
		this.altitude = alt;
	}
	
	public static class ValidateLocal {
		public static void validate(Local local) {
			String msg = "todos valores devem ser validos e não zeros";
			Preconditions.checkArgument( local != null, msg );
			Preconditions.checkArgument( local.altitude  != 0, msg );
			Preconditions.checkArgument( local.latitude  != 0, msg );
			Preconditions.checkArgument( local.longitude != 0, msg );			
		}
		public static void validate(Nave air) {
			String msg = "a nave deve ser informada";
			Preconditions.checkArgument( air != null, msg );
		}
	}

}