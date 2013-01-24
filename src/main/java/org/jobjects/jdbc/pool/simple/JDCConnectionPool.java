package org.jobjects.jdbc.pool.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JDCConnectionPool {

	private List<JDCConnection> connections;
	private String url, user, password;
	private long timeout;
	private long delay;
	private java.util.Timer timer;

	public JDCConnectionPool(String url, String user, String password,
			long timeout, long delay) {
		this.url = url;
		this.user = user;
		this.password = password;
		this.timeout = timeout;
		this.delay = delay;
		connections = Collections
				.synchronizedList(new ArrayList<JDCConnection>());

		timer = new java.util.Timer(true);
		java.util.TimerTask task = new java.util.TimerTask() {
			public void run() {
				reapConnections();
			}
		};
		timer.schedule(task, 0, this.delay);
	}

	// ---------------------------------------------------------------------------

	public synchronized void reapConnections() {
		long stale = System.currentTimeMillis() - timeout;
		for (JDCConnection conn : connections) {
			if ((conn.inUse()) && (stale > conn.getLastUse())
					&& (!conn.validate())) {
				removeConnection(conn);
			}
		}
	}

	// ---------------------------------------------------------------------------

	public synchronized void closeConnections() {
		for (JDCConnection conn : connections) {
			removeConnection(conn);
		}
	}

	// ---------------------------------------------------------------------------

	private synchronized void removeConnection(JDCConnection conn) {
		connections.remove(conn);
	}

	// ---------------------------------------------------------------------------

	public synchronized Connection getConnection() throws SQLException {
		for (JDCConnection conn : connections) {
			if (conn.lease()) {
				return conn;
			}
		}

		Connection conn = DriverManager.getConnection(url, user, password);
		JDCConnection c = new JDCConnection(conn, this);
		c.lease();
		connections.add(c);

		if (url.contains("oracle")) {
			Statement stmt = c.createStatement();
			stmt.executeUpdate("ALTER SESSION SET NLS_SORT = BINARY");
			stmt.executeUpdate("ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS'");
			stmt.executeUpdate("ALTER SESSION SET NLS_NUMERIC_CHARACTERS = '. '");
			stmt.close();
		}

		return c;
	}

	// ---------------------------------------------------------------------------

	public synchronized void returnConnection(JDCConnection conn) {
		conn.expireLease();
	}
	// ---------------------------------------------------------------------------
	
	public synchronized int getConnectionInUse() {
		return connections.size();
	}
}
