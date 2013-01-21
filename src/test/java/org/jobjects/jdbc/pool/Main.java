package org.jobjects.jdbc.pool;

import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	/**
	 * Conserve la categorie de login.
	 */
	private static Logger LOGGER = Logger.getLogger(Main.class
			.getCanonicalName());

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		URL rul = ClassLoader.getSystemResource("logging.properties");
		System.out.println("" + rul);
		File f = new File(rul.toURI());
		System.out.println(f.exists());
		LOGGER.log(Level.INFO, "Chargement des propriétés de " + rul);
	}

}
