package br.edu.curso.sample.repositorio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.edu.curso.dbunit.helper.DBUnitHelper;
import br.edu.curso.sample.model.Usuario;

public class UsuarioRepositorioTest {
	
	private DBUnitHelper helper;
	
	private IDataSet getDataSet(String relativePath) throws DataSetException {
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		builder.setColumnSensing(true);
		URL url = UsuarioRepositorioTest.class.getResource( relativePath );
		return builder.build( url );
	}
	
	private void limparTodos(IDatabaseConnection connection) throws DatabaseUnitException, SQLException {
		IDataSet deleteAll = this.getDataSet( DatasetUsuarios.DELETE_ALL );
		DatabaseOperation.DELETE_ALL.execute( connection, deleteAll );
	}
	
	private void popular(IDatabaseConnection connection) throws DatabaseUnitException, SQLException {
		IDataSet menores18 = this.getDataSet( DatasetUsuarios.MENORES_18 );
		DatabaseOperation.INSERT.execute( connection, menores18);
	}
	
	@Before public void before() throws ClassNotFoundException, MalformedURLException, DatabaseUnitException, SQLException {
		//configurando dados
		this.helper = new DBUnitHelper();
		IDatabaseConnection connection = getConnection();			
		this.limparTodos( connection );
		this.popular( connection );

		// configurando repositorio
		EntityManager em = getEntityManager();
		assertNotNull( em );
		this.repositorio = UsuarioRepositorio.builder().em( em ).build();
	}
	
	private IDatabaseConnection getConnection() {
		IDatabaseConnection connection = null;
		try {
			connection = helper.getConnection();
			this.configure( connection.getConfig() );
		} catch (Exception e) {
			throw new RuntimeException("verifique se o banco está sendo usado", e);
		}
		return connection;
	}
	
	private void configure(DatabaseConfig config) {
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory() );
		config.setProperty(DatabaseConfig.FEATURE_SKIP_ORACLE_RECYCLEBIN_TABLES, true);
		config.setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);
	}
	
	interface DatasetUsuarios {
		String DELETE_ALL = "/dbunit/usuarios_limpar.xml";
		String MENORES_18 = "/dbunit/usuarios_menores_18.xml";
	}
	
	private UsuarioRepositorio repositorio;
	
	@Test public void obterPorId() {		
		Usuario usuario = repositorio.obterPorId(4);
		assertThat(usuario, is( michaelJackson() ));
	}
	
	private TypeSafeDiagnosingMatcher<Usuario> michaelJackson() {
		return new TypeSafeDiagnosingMatcher<Usuario>() {
			public void describeTo(Description desc) {
				desc.appendText(" deveria retornar ");
			}

			@Override
			protected boolean matchesSafely(Usuario usuario, Description desc) {
				return usuario.nome.equals("Michael Jackson");
			}
		};
	}

	private EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("PUBLIC").createEntityManager();
	}

}