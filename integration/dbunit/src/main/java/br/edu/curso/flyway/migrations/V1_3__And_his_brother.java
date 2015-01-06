package br.edu.curso.flyway.migrations;

import com.googlecode.flyway.core.api.migration.jdbc.JdbcMigration;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Exemplo de integração com API Jdbc para migração
 */
public class V1_3__And_his_brother implements JdbcMigration {
	
    public void migrate(Connection connection) throws Exception {
    	String sql = "INSERT INTO usuarios VALUES (4, 'Edsger Dijkstra', '1930-05-11');";
        PreparedStatement statement = connection.prepareStatement(sql);
        try {
            statement.execute();
        } finally {
            statement.close();
        }
    }
    
}