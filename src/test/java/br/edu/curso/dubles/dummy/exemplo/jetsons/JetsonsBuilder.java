package br.edu.curso.dubles.dummy.exemplo.jetsons;

import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static com.natpryce.makeiteasy.Property.newProperty;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Maker;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

@SuppressWarnings("unchecked")
public interface JetsonsBuilder {	
	
	public static Maker<Robo> 	makerRosie  = an( RobotMakers.Rosie, with(100, RobotMakers.battery) );
	public static Maker<Jetson> makerGeorge = an( PeopleMakers.George );
	public static Maker<Dog> makerAstro = an( AnimalMakers.Astro );

	interface RobotMakers {
	    public static final Property<Robo, Integer> battery = newProperty();
	    public static final Property<Robo, String> name = newProperty();
	    
	    public static final Instantiator<Robo> Rosie = new Instantiator<Robo>() {
			public Robo instantiate(PropertyLookup<Robo> lookup) {
				return new Robo( lookup.valueOf(name, "Rosie") );
			}
	    };
	}
	
	interface AnimalMakers {
		public static final Property<Dog, String> name = newProperty();
		public static final Instantiator<Dog> Astro = new Instantiator<Dog>() {
			public Dog instantiate(PropertyLookup<Dog> lookup) {
				return new Dog( lookup.valueOf(name, "Astro") );
			}
	    };
	}
	
	interface PeopleMakers {
		public static final Property<Jetson, String> name = newProperty();
		public static final Instantiator<Jetson> George = new Instantiator<Jetson>() {
			public Jetson instantiate(PropertyLookup<Jetson> lookup) {
				return new Jetson( lookup.valueOf(name, "George") );
			}
	    };		
	}
	
}