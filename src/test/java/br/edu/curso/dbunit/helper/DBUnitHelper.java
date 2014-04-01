package br.edu.curso.dbunit.helper;

import static br.edu.curso.dbunit.helper.DBUnitHelper.Configuration.dname;
import static br.edu.curso.dbunit.helper.DBUnitHelper.Configuration.pswd;
import static br.edu.curso.dbunit.helper.DBUnitHelper.Configuration.url;
import static br.edu.curso.dbunit.helper.DBUnitHelper.Configuration.user;

import java.sql.Driver;

import org.dbunit.JdbcDatabaseTester;

public class DBUnitHelper extends JdbcDatabaseTester {

	private DBUnitHelper(String driver, String url, String user, String pswd) 
			throws ClassNotFoundException {
		super(driver, url, user, pswd);
	}
	
	public DBUnitHelper() throws ClassNotFoundException {
		this(dname, url, user, pswd);
	}
	
	public interface Configuration {
		String user   = "sa";
		String pswd   = "";
		String url    = "jdbc:h2:~/Documents/workspace/curso/ceshi/target/h2";
		String dname  = "org.h2.Driver";
		Driver driver = new org.h2.Driver();
	}

}