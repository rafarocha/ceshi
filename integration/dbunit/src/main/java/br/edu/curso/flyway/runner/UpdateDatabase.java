package br.edu.curso.flyway.runner;

import static br.edu.curso.flyway.runner.UpdateDatabase.Configuration.driver;
import static br.edu.curso.flyway.runner.UpdateDatabase.Configuration.pswd;
import static br.edu.curso.flyway.runner.UpdateDatabase.Configuration.url;
import static br.edu.curso.flyway.runner.UpdateDatabase.Configuration.user;

import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.googlecode.flyway.core.Flyway;

public class UpdateDatabase {
	
	public static void main(String[] args) throws Exception {
		Flyway flyway = new Flyway();
		flyway.setDataSource( getDatasource() );
		flyway.setLocations( locations );
		flyway.clean();        
		flyway.migrate();
		
		System.out.println( "sucess" ); // TODO appender logging
	}
	
	private interface ResourcePath {
		String Java = "br.edu.curso.flyway.migrations";
		String SQL = "db.migration";
	}
	
	private static final String[] locations = new String[] {
		ResourcePath.Java, ResourcePath.SQL };
	
	private static DataSource getDatasource() {
		return new SimpleDriverDataSource( driver, url, user, pswd );
	}	
	
	public interface Configuration {
		String user   = "sa";
		String pswd   = "";
		String url    = "jdbc:h2:~/Documents/workspace/curso/ceshi/target/h2";
		String dname  = "org.h2.Driver";
		Driver driver = new org.h2.Driver();
	}

}