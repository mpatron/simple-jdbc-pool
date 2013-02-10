package org.jobjects.jdbc.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DerbyStart {

	private static Logger LOGGER = Logger.getLogger(DerbyStart.class.getName());

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			String driver = "org.apache.derby.jdbc.EmbeddedDriver";
			Class.forName(driver).newInstance();
			Properties p = new Properties();
			p.setProperty("user", "sa");
			p.setProperty("password", "manager");
			p.setProperty("create", "true");

			Connection conn = DriverManager.getConnection(
					"jdbc:derby:memory:MyDerbyDB", p);

			{
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE MYDERBYDB.MYTABLE (";
				sql += " MONCHAMPSTEXTE VARCHAR(6) NOT NULL,";
				sql += " MONCHAMPSCHAR CHAR(2) NOT NULL,";
				sql += " MONCHAMPSDATE DATE,";
				sql += " MONCHAMPSDATETIME TIMESTAMP,";
				sql += " MONCHAMPSDECIMAL DOUBLE";
				sql += " )";
				stmt.execute(sql);
				stmt.execute("ALTER TABLE MYDERBYDB.MYTABLE ADD PRIMARY KEY (MONCHAMPSTEXTE, MONCHAMPSCHAR)");
				stmt.close();
			}

			{
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE MYDERBYDB.SECU_USER (";
				sql += " USERNAME VARCHAR(255) NOT NULL,";
				sql += " PASSWORD VARCHAR(255),";
				sql += " MONCHAMPSDATETIME TIMESTAMP";
				sql += " )";
				stmt.execute(sql);
				stmt.execute("ALTER TABLE MYDERBYDB.SECU_USER ADD PRIMARY KEY (username)");
				stmt.execute("INSERT INTO MYDERBYDB.SECU_USER (USERNAME, PASSWORD) VALUES ('myName', 'myPassword')");
				stmt.close();
			}

			{
				Statement stmt = conn.createStatement();
				String sql = "CREATE TABLE MYDERBYDB.SECU_USER_ROLE (";
				sql += " USERNAME VARCHAR(255) NOT NULL,";
				sql += " ROLENAME VARCHAR(255) NOT NULL,";
				sql += " MONCHAMPSDATETIME TIMESTAMP";
				sql += " )";
				stmt.execute(sql);
				stmt.execute("ALTER TABLE MyDerbyDB.secu_user_role ADD PRIMARY KEY (username, rolename)");
				stmt.execute("INSERT INTO MYDERBYDB.SECU_USER_ROLE (USERNAME, ROLENAME) VALUES ('myName', 'tomcat')");
				stmt.execute("INSERT INTO MYDERBYDB.SECU_USER_ROLE (USERNAME, ROLENAME) VALUES ('myName', 'admin')");
				stmt.execute("INSERT INTO MYDERBYDB.SECU_USER_ROLE (USERNAME, ROLENAME) VALUES ('myName', 'root')");
				stmt.execute("INSERT INTO MYDERBYDB.SECU_USER_ROLE (USERNAME, ROLENAME) VALUES ('myName', 'dieu')");
				stmt.close();
			}

			final ResultSet tables = conn.getMetaData().getTables(null, null,
					"%", new String[] { "TABLE" });
			List<String> tableNames = new ArrayList<String>();
			while (tables.next()) {
				tableNames.add(tables.getString("TABLE_NAME").toLowerCase());
			}

			conn.close();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Erreur non prévu : ", e);
		}
	}

	@Test
	public void testStart() {
		LOGGER.log(Level.INFO, "Derby Stating");
	}

}
