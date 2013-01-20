package org.jobjects.jdbc.pool.simple;

import java.io.File;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDCConnectionManager {
	public static String fileproperties = System.getProperty("user.home")
			+ File.separator + "fdc.properties";
	private static JDCConnectionDriver jdriver = null;

	// ---------------------------------------------------------------------------

	private static JDCConnectionManager instance = null;

	private JDCConnectionManager() {
		
		try {
			Properties properties = new Properties();
			java.io.File f = new java.io.File(fileproperties);
			if (!f.exists()) {
				java.io.FileOutputStream fos = new java.io.FileOutputStream(
						fileproperties);

				writeln(fos,
						"#Tous les 5 minutes (300000 millisecondes), thread �teint les connections inactives.");
				writeln(fos, "delay=300000");
				writeln(fos,
						"#Une connection devient inactive si elle n'a pas �t� utilis� depuis 1 minutes (60000 millisecondes).");
				writeln(fos, "timeout=60000");
				writeln(fos, "driver=oracle.jdbc.driver.OracleDriver");
				writeln(fos, "url=jdbc:oracle:thin:@LOCALHOST:1521:EDI");
				writeln(fos, "user=b4one");
				writeln(fos, "password=b4one");
				writeln(fos, "owner=%");

				fos.close();
			}
			java.io.FileInputStream fis = new java.io.FileInputStream(
					fileproperties);
			properties.load(fis);
			fis.close();

			JDCConstantes.delay = Integer.parseInt(properties
					.getProperty("delay"));
			JDCConstantes.timeout = Integer.parseInt(properties
					.getProperty("timeout"));
			JDCConstantes.driver = properties.getProperty("driver");
			JDCConstantes.url = properties.getProperty("url");
			JDCConstantes.user = properties.getProperty("user");
			JDCConstantes.password = properties.getProperty("password");
			JDCConstantes.owner = properties.getProperty("owner");

			jdriver = new JDCConnectionDriver(JDCConstantes.driver,
					JDCConstantes.url, JDCConstantes.user,
					JDCConstantes.password);
		} catch (Exception e) {
			e.printStackTrace();
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

	private static void writeln(java.io.FileOutputStream fos, String chaine) {
		try {
			fos.write(chaine.getBytes());
			fos.write(System.getProperty("line.separator").getBytes());
		} catch (java.io.IOException ex) {
			ex.printStackTrace();
		}
	}
	// ---------------------------------------------------------------------------
}