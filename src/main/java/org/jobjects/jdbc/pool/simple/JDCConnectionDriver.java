package org.jobjects.jdbc.pool.simple;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class JDCConnectionDriver implements Driver {

	public static final String URL_PREFIX = "jdbc:jdc:";
	private static final int MAJOR_VERSION = 1;
	private static final int MINOR_VERSION = 0;
	private JDCConnectionPool pool;
	
	private static Logger LOGGER = Logger.getLogger(JDCConnectionDriver.class.getCanonicalName());
	
	// ---------------------------------------------------------------------------

	public JDCConnectionDriver(String driver, String url, String user,
			String password, long timeout, long delay) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException {
		if((driver==null)||("".equals(driver))) {
			throw new ClassNotFoundException("Le driver "+driver+" est introuvable.");
		}
		DriverManager.registerDriver(this);
		Class.forName(driver).newInstance();
		pool = new JDCConnectionPool(url, user, password, timeout, delay);
	}
	// ---------------------------------------------------------------------------

	@Override
	public Connection connect(String url, Properties props) throws SQLException {
		Connection returnValue=null;
		if(acceptsURL(url)) {
			returnValue=pool.getConnection();
		}
		return returnValue;
	}
	// ---------------------------------------------------------------------------

	@Override
	public boolean acceptsURL(String url) {		
		boolean returnValue=false;
		if((url!=null) && (!"".equals(url.trim()))) {
			returnValue =url.trim().startsWith(URL_PREFIX);	
		}
		if(!returnValue) {
			LOGGER.warning("L' url suivante n'est pas accepté : "+url);
		}
		return returnValue;
	}
	// ---------------------------------------------------------------------------

	@Override
	public int getMajorVersion() {
		return MAJOR_VERSION;
	}
	// ---------------------------------------------------------------------------

	@Override
	public int getMinorVersion() {
		return MINOR_VERSION;
	}
	// ---------------------------------------------------------------------------

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String str, Properties props) {
		return new DriverPropertyInfo[0];
	}
	// ---------------------------------------------------------------------------

	@Override
	public boolean jdbcCompliant() {
		return false;
	}
	// ---------------------------------------------------------------------------

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}
	// ---------------------------------------------------------------------------
	
	public JDCConnectionPool getPool() {
		return pool;
	}
	// ---------------------------------------------------------------------------
}
