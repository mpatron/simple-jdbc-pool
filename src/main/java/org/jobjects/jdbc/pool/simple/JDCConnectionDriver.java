package org.jobjects.jdbc.pool.simple;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Logger;

public class JDCConnectionDriver implements Driver {

	public static final String URL_PREFIX = "jdbc:jdc:";
	private static final int MAJOR_VERSION = 1;
	private static final int MINOR_VERSION = 0;
	private JDCConnectionPool pool;
	
	private String driverClassName;
	private String url;
	private String user;
	private String password;
	private long timeout;
	private long delay;
	
	private Logger LOGGER = Logger.getLogger(getClass().getName());
	
	// ---------------------------------------------------------------------------

	public JDCConnectionDriver(String driverClassName, String url, String user,
			String password, long timeout, long delay) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException {
		if((driverClassName==null)||("".equals(driverClassName))) {
			throw new ClassNotFoundException("Le driver "+driverClassName+" est introuvable.");
		}
		this.driverClassName=driverClassName;
		this.url=url;
		this.user=user;
		this.password=password;
		this.timeout=timeout;
		this.delay=delay;
		
		boolean flag=false;
		Enumeration<Driver> drivers= DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver driver = (Driver) drivers.nextElement();
			if(JDCConnectionDriver.class.equals(driver.getClass())) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			DriverManager.registerDriver(this);
			Class.forName(driverClassName).newInstance();
		}
		pool = new JDCConnectionPool(url, user, password, timeout, delay);
	}
	// ---------------------------------------------------------------------------

	/**
	 * @return the driverClassName
	 */
	protected String getDriverClassName() {
		return driverClassName;
	}
	// ---------------------------------------------------------------------------

	/**
	 * @param driverClassName the driverClassName to set
	 */
	protected void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	// ---------------------------------------------------------------------------

	/**
	 * @return the url
	 */
	protected String getUrl() {
		return url;
	}
	// ---------------------------------------------------------------------------

	/**
	 * @param url the url to set
	 */
	protected void setUrl(String url) {
		this.url = url;
	}
	// ---------------------------------------------------------------------------

	/**
	 * @return the user
	 */
	protected String getUser() {
		return user;
	}
	// ---------------------------------------------------------------------------

	/**
	 * @param user the user to set
	 */
	protected void setUser(String user) {
		this.user = user;
	}
	// ---------------------------------------------------------------------------

	/**
	 * @return the password
	 */
	protected String getPassword() {
		return password;
	}
	// ---------------------------------------------------------------------------

	/**
	 * @param password the password to set
	 */
	protected void setPassword(String password) {
		this.password = password;
	}
	// ---------------------------------------------------------------------------

	/**
	 * @return the timeout
	 */
	protected long getTimeout() {
		return timeout;
	}
	// ---------------------------------------------------------------------------

	/**
	 * @param timeout the timeout to set
	 */
	protected void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	// ---------------------------------------------------------------------------

	/**
	 * @return the delay
	 */
	protected long getDelay() {
		return delay;
	}
	// ---------------------------------------------------------------------------

	/**
	 * @param delay the delay to set
	 */
	protected void setDelay(long delay) {
		this.delay = delay;
	}
	// ---------------------------------------------------------------------------

	/**
	 * @return the pool
	 */
	protected JDCConnectionPool getPool() {
		return pool;
	}
	// ---------------------------------------------------------------------------

	/**
	 * @param pool the pool to set
	 */
	protected void setPool(JDCConnectionPool pool) {
		this.pool = pool;
	}
	// ---------------------------------------------------------------------------

	/* (non-Javadoc)
	 * @see java.sql.Driver#connect(java.lang.String, java.util.Properties)
	 */
	@Override
	public Connection connect(String url, Properties props) throws SQLException {
		Connection returnValue=null;
		if(acceptsURL(url)) {
			returnValue=pool.getConnection();
		}
		return returnValue;
	}
	// ---------------------------------------------------------------------------

	/* (non-Javadoc)
	 * @see java.sql.Driver#acceptsURL(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see java.sql.Driver#getMajorVersion()
	 */
	@Override
	public int getMajorVersion() {
		return MAJOR_VERSION;
	}
	// ---------------------------------------------------------------------------

	/* (non-Javadoc)
	 * @see java.sql.Driver#getMinorVersion()
	 */
	@Override
	public int getMinorVersion() {
		return MINOR_VERSION;
	}
	// ---------------------------------------------------------------------------

	/* (non-Javadoc)
	 * @see java.sql.Driver#getPropertyInfo(java.lang.String, java.util.Properties)
	 */
	@Override
	public DriverPropertyInfo[] getPropertyInfo(String str, Properties props) {
		return new DriverPropertyInfo[0];
	}
	// ---------------------------------------------------------------------------

	/* (non-Javadoc)
	 * @see java.sql.Driver#jdbcCompliant()
	 */
	@Override
	public boolean jdbcCompliant() {
		return false;
	}
	// ---------------------------------------------------------------------------

	/* (non-Javadoc)
	 * @see java.sql.Driver#getParentLogger()
	 */
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}
	// ---------------------------------------------------------------------------
	
}
