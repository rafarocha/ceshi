package br.edu.curso.flyway.migrations;

import com.googlecode.flyway.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Exemplo de integração Spring Jdbc/SQL para migração via Java
 */
public class V1_2__Novo_Usuario implements SpringJdbcMigration {

	public static final String sql = 
			"INSERT INTO usuarios VALUES (%s, '%s', '%s');";
	
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
    	this.addUser( jdbcTemplate, "Isaac Newton" );
    }
    
    private void addUser(JdbcTemplate template, String name) {
    	template.execute( String.format(sql, 3, name, "2014-03-28") );
    }
    
}