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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link org.jobjects.jdbc.pool.simple.JDCConnectionDriver#JDCConnectionDriver(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long)}.
	 */
	@Test
	public void testJDCConnectionDriver() {
		String driver=null;
		String url=null;
		String user=null;
		String password=null;
		long timeout=0;
		long delay=0;
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
