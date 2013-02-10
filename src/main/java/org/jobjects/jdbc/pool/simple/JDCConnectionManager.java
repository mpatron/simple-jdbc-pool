package org.jobjects.jdbc.pool.simple;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDCConnectionManager {
	private static Logger LOGGER = Logger.getLogger(JDCConnectionManager.class
			.getCanonicalName());
	private static JDCConnectionDriver jdriver = null;
	private static JDCConnectionManager instance = null;
	// ---------------------------------------------------------------------------

	private JDCConnectionManager() {

		try {
			Properties properties = getJdbcSimpleProperties();
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			long timeout = Integer.parseInt(properties.getProperty("timeout"));
			long delay = Integer.parseInt(properties.getProperty("delay"));

			StringBuffer sb = new StringBuffer();
			sb.append("Driver simple propriétés : [ ");
			sb.append(" driver=" + driver);
			sb.append(" url=" + url);
			sb.append(" user=" + user);
			sb.append(" password=" + password);
			sb.append(" timeout=" + timeout);
			sb.append(" delay=" + delay);
			sb.append("]");
			LOGGER.log(Level.INFO, sb.toString());
			
			jdriver = new JDCConnectionDriver(driver, url, user, password, timeout, delay);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Erreur dans le chargement des propriétés du driver.", e);
		}
	}
	// ---------------------------------------------------------------------------

	public static JDCConnectionManager getInstance() {
		if (instance == null)
			instance = new JDCConnectionManager();
		return instance;
	}
	// ---------------------------------------------------------------------------

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:jdc:jdcpool");
	}
	// ---------------------------------------------------------------------------

	public Driver getDriver() {
		return jdriver;
	}
	// ---------------------------------------------------------------------------

	private Properties getJdbcSimpleProperties() throws Exception {
		String FILE_NAME = "jdbcSimple.properties";
		Properties returnValue = new Properties();

		if (returnValue.size() == 0) {
			URL url = ClassLoader.getSystemResource(FILE_NAME);
			LOGGER.log(Level.INFO, "url "+ url);
			if (url != null) {
				File f = new File(url.toURI());
				if (f.exists()) {
					InputStream is = new FileInputStream(f);
					returnValue.load(is);
					LOGGER.log(Level.INFO, "Chargement des propriétés de "
							+ url.toURI());
					is.close();
				}
			}
		}

		if (returnValue.size() == 0) {
			String pathName = System.getProperty("user.home") + File.separator
					+ FILE_NAME;
			File f = new File(pathName);
			if (f.exists()) {
				InputStream is = new FileInputStream(f);
				returnValue.load(is);
				LOGGER.log(Level.INFO, "Chargement des propriétés de "
						+ pathName);
				is.close();
			}
		}		
		

		if (returnValue.size() == 0) {
			LOGGER.log(Level.SEVERE, "Chargement impossible des propriétés de "
					+ FILE_NAME);
		}

		return returnValue;
	}
	// ---------------------------------------------------------------------------

}