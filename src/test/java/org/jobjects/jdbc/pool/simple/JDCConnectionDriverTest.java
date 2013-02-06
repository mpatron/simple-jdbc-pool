/**
 * 
 */
package org.jobjects.jdbc.pool.simple;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author Mickael
 *
 */
public class JDCConnectionDriverTest {
	
	private static Logger LOGGER = Logger.getLogger(JDCConnectionDriverTest.class.getCanonicalName());

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		JDCConnectionManagerTest.setUpBeforeClass();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		JDCConnectionManagerTest.tearDownAfterClass();
	}

	/**
	 * Test method for {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#JDCConnectionDriver(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long)}.
	 */
	@Test
	public void testJDCConnectionDriver() {
		String driver="org.apache.derby.jdbc.EmbeddedDriver";
		String url="jdbc:derby:memory:MyDerbyDB;upgrade=true";
		String user="sa";
		String password="manager";
		long timeout=60000;
		long delay=300000;
		try {
			JDCConnectionDriver jdriver = new JDCConnectionDriver(driver, url, user, password, timeout, delay);
			DriverManager.registerDriver(jdriver);
			DriverManager.deregisterDriver(jdriver);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Erreur non prévu", e);
		}
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#connect(java.lang.String, java.util.Properties)}.
	 */
	@Test
	public void testConnect() {
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#acceptsURL(java.lang.String)}.
	 */
	@Test
	public void testAcceptsURL() {
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#getMajorVersion()}.
	 */
	@Test
	public void testGetMajorVersion() {
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#getMinorVersion()}.
	 */
	@Test
	public void testGetMinorVersion() {
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#getPropertyInfo(java.lang.String, java.util.Properties)}.
	 */
	@Test
	public void testGetPropertyInfo() {
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#jdbcCompliant()}.
	 */
	@Test
	public void testJdbcCompliant() {
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#getParentLogger()}.
	 */
	@Test
	public void testGetParentLogger() {
		LOGGER.info("Not yet implemented");
	}

	/**
	 * Test method for {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#getPool()}.
	 */
	@Test
	public void testGetPool() {
		LOGGER.info("Not yet implemented");
	}

}
