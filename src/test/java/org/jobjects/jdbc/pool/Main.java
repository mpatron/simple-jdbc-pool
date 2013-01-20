package org.jobjects.jdbc.pool;

import java.io.File;
import java.net.URL;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		URL rul = ClassLoader.getSystemResource("logging.properties");
		System.out.println(""+rul);
		File f = new File(rul.toURI());
		System.out.println(f.exists());
	}

}
