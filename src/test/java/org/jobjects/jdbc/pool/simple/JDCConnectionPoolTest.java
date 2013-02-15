package org.jobjects.jdbc.pool.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JDCConnectionPoolTest {

	private Logger LOGGER = Logger.getLogger(getClass().getName());
	
	@Test
	public void JDCConnectionPool() {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		String url = "jdbc:derby:memory:MyDerbyDB;upgrade=true";
		String user = "sa";
		String password = "manager";
		long timeout = 60000;
		long delay = 300000;
		try {
			JDCConnectionPool jpool = new JDCConnectionPool(url, user,
					password, timeout, delay);
			Assert.assertNotNull(jpool);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Erreur non prévu", e);
			Assert.assertFalse(true);
		}
	}

	@Test
	public void closeConnections() {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		String url = "jdbc:derby:memory:MyDerbyDB;upgrade=true";
		String user = "sa";
		String password = "manager";
		long timeout = 60000;
		long delay = 300000;
		try {
			JDCConnectionPool jpool = new JDCConnectionPool(url, user,
					password, timeout, delay);
			jpool.closeConnections();
			Assert.assertNotNull(jpool);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Erreur non prévu", e);
			Assert.assertFalse(true);
		}
	}

	@Test
	public void getConnection() {
		String url = "jdbc:derby:memory:MyDerbyDB;upgrade=true";
		String user = "sa";
		String password = "manager";
		long timeout = 60000;
		long delay = 300000;
		try {
			JDCConnectionPool jpool = new JDCConnectionPool(url, user,
					password, timeout, delay);

			Connection connection = jpool.getConnection();
			Assert.assertNotNull(connection);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Erreur non prévu", e);
			Assert.assertFalse(true);
		}
	}

	@Test
	public void getConnectionInUse() {
		String url = "jdbc:derby:memory:MyDerbyDB;upgrade=true";
		String user = "sa";
		String password = "manager";
		long timeout = 60000;
		long delay = 300000;
		try {
			JDCConnectionPool jpool = new JDCConnectionPool(url, user,
					password, timeout, delay);

			Connection connection = jpool.getConnection();
			Assert.assertNotNull(connection);
			Assert.assertTrue(jpool.getConnectionInUse() > 0);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Erreur non prévu", e);
			Assert.assertFalse(true);
		}
	}

	@Test
	public void reapConnections() {
		String url = "jdbc:derby:memory:MyDerbyDB;upgrade=true";
		String user = "sa";
		String password = "manager";
		long timeout = 500;
		long delay = 300;
		try {
			JDCConnectionPool jpool = new JDCConnectionPool(url, user,
					password, timeout, delay);

			Connection connection = jpool.getConnection();
			Assert.assertNotNull(connection);
			Thread.sleep(600);
			connection.close();
			jpool.reapConnections();
			Assert.assertTrue(jpool.getConnectionInUse() == 0);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Erreur non prévu", e);
			Assert.assertFalse(true);
		}
	}

	@Test
	public void returnConnection() {
		String url = "jdbc:derby:memory:MyDerbyDB;upgrade=true";
		String user = "sa";
		String password = "manager";
		long timeout = 500;
		long delay = 300000;
		try {
			JDCConnectionPool jpool = new JDCConnectionPool(url, user,
					password, timeout, delay);

			Connection connection = jpool.getConnection();
			Assert.assertNotNull(connection);
			Thread.sleep(600);
			connection.close();
			jpool.returnConnection((JDCConnection)connection);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Erreur non prévu", e);
			Assert.assertFalse(true);
		}
	}

}
