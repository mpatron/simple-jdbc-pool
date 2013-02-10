package org.jobjects.jdbc.pool;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class DerbyStop {

	private static Logger LOGGER = Logger.getLogger(DerbyStop.class.getName());

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		try {
			// DriverManager.getConnection("jdbc:derby:memory:MyDerbyDB;shutdown=true");
			LOGGER.info("Extinction de Derby");
			DriverManager.getConnection("jdbc:derby:;shutdown=true");
		} catch (Exception ignored) {
			LOGGER.log(Level.INFO, "Erreur prévu : " + ignored.getLocalizedMessage());
		}
	}

	@Test
	public void testStop() {
		LOGGER.log(Level.INFO, "Derby Stop");
	}

}
