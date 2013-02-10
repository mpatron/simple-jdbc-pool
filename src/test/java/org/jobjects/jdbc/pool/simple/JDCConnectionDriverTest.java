/**
 * 
 */
package org.jobjects.jdbc.pool.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Mickael
 * 
 */
public class JDCConnectionDriverTest {

	private static Logger LOGGER = Logger
			.getLogger(JDCConnectionDriverTest.class.getCanonicalName());


	/**
	 * Test method for
	 * {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#JDCConnectionDriver(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long)}
	 * .
	 */
	@Test
	public void testJDCConnectionDriver() {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		String url = "jdbc:derby:memory:MyDerbyDB;upgrade=true";
		String user = "sa";
		String password = "manager";
		long timeout = 60000;
		long delay = 300000;
		try {
			try {
				new JDCConnectionDriver(null, url, user, password, timeout, delay);
				Assert.assertTrue(false, "Code inaxessible, il doit y avoir un exception avant.");
			} catch (Throwable t) {
				Assert.assertTrue(true, "Bonne exception.");
			}
			
			JDCConnectionDriver jdriver = new JDCConnectionDriver(driver, url, user, password, timeout, delay);
			
			DriverManager.registerDriver(jdriver);
			DriverManager.deregisterDriver(jdriver);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Erreur non prévu", e);
		}
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#connect(java.lang.String, java.util.Properties)}
	 * .
	 */
	@Test
	public void testConnect() {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		String url = "jdbc:derby:memory:MyDerbyDB;upgrade=true";
		String user = "sa";
		String password = "manager";
		long timeout = 60000;
		long delay = 300000;
		try {
			JDCConnectionDriver jdriver = new JDCConnectionDriver(driver, url,
					user, password, timeout, delay);
			Properties props = new Properties();
			props.setProperty("user", "sa");
			props.setProperty("password", "manager");
			props.setProperty("timeout", "60000");
			props.setProperty("delay", "300000");

			DriverManager.registerDriver(jdriver);
			Connection connection= jdriver.connect(url, props);
			Assert.assertNull(connection);
			
			connection= jdriver.connect(JDCConnectionDriver.URL_PREFIX, props);
			Assert.assertNotNull(connection);
			
			if(connection!=null) {
				connection.close();
			}
			DriverManager.deregisterDriver(jdriver);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Erreur non prévu", e);
		}
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#acceptsURL(java.lang.String)}
	 * .
	 */
	@Test
	public void testAcceptsURL() {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		String url = "jdbc:derby:memory:MyDerbyDB;upgrade=true";
		String user = "sa";
		String password = "manager";
		long timeout = 60000;
		long delay = 300000;
		try {
			JDCConnectionDriver jdriver = new JDCConnectionDriver(driver, url,
					user, password, timeout, delay);
			
			Assert.assertTrue(jdriver.acceptsURL("jdbc:jdc:"));
			Assert.assertTrue(jdriver.acceptsURL(" jdbc:jdc:"));
			Assert.assertTrue(jdriver.acceptsURL(" jdbc:jdc:  "));
			Assert.assertFalse(jdriver.acceptsURL("jdbc:toto:"));
			Assert.assertFalse(jdriver.acceptsURL(null));
			Assert.assertFalse(jdriver.acceptsURL(""));
			Assert.assertFalse(jdriver.acceptsURL(" "));
			
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Erreur non prévu", e);
		}
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#getMajorVersion()}
	 * .
	 */
	@Test
	public void testGetMajorVersion() {
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#getMinorVersion()}
	 * .
	 */
	@Test
	public void testGetMinorVersion() {
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#getPropertyInfo(java.lang.String, java.util.Properties)}
	 * .
	 */
	@Test
	public void testGetPropertyInfo() {
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#jdbcCompliant()}
	 * .
	 */
	@Test
	public void testJdbcCompliant() {
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#getParentLogger()}
	 * .
	 */
	@Test
	public void testGetParentLogger() {
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#getPool()}.
	 */
	@Test
	public void testGetPool() {
		LOGGER.info("Not yet implemented");
	}

}
