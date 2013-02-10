package org.jobjects.jdbc.pool.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Mickael
 * 
 */
public class JDCConnectionManagerTest {
	private static Logger LOGGER = Logger.getLogger(JDCConnectionManagerTest.class.getCanonicalName());
	


	/**
	 * Test method for
	 * {@link org.jobjects.jaas.persistance.jdbc.UserRoleInformationJDBC#UserRoleInformationJDBC()}
	 * .
	 */
	@Test
	public void testUserRoleInformationJDBC() {
		JDCConnectionManager instance = JDCConnectionManager.getInstance();
		Assert.assertNotNull(instance);
	}

	@Test
	public void testUserRoleInformationJDBC2() {
		JDCConnectionManager instance = JDCConnectionManager.getInstance();
		try {
			Connection connection=instance.getConnection();
			Assert.assertNotNull(connection);
			connection.close();
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		Assert.assertNotNull(instance);
	}
	
//	/**
//	 * Test method for
//	 * {@link org.jobjects.jaas.persistance.jdbc.UserRoleInformationJDBC#init(java.util.Map)}
//	 * .
//	 */
//	@Test
//	public void testInit() {
//		HashMap<String, String> options = new HashMap<String, String>();
//		options.put("dbDriver", "org.apache.derby.jdbc.EmbeddedDriver");
//		options.put("dbURL", "jdbc:derby:memory:MyDerbyDB;upgrade=true");
//		options.put("dbUser", "sa");
//		options.put("dbPassword", "manager");
//		options.put(
//				"userQuery",
//				"select username from MyDerbyDB.secu_user u where u.username=? and u.password=?");
//		options.put(
//				"roleQuery",
//				"select r.rolename from MyDerbyDB.secu_user u, MyDerbyDB.secu_user_role r where u.username=r.username and u.username=?");
//		options.put("debug", "true");
//
//		JDCConnectionManager instance = JDCConnectionManager.getInstance();
//		Assert.assertTrue(instance.init(options));
//
//	}
//
//	/**
//	 * Test method for
//	 * {@link org.jobjects.jaas.persistance.jdbc.UserRoleInformationJDBC#isValidUser(java.lang.String, char[])}
//	 * .
//	 */
//	@Test
//	public void testIsValidUserTrue() {
//		HashMap<String, String> options = new HashMap<String, String>();
//		options.put("dbDriver", "org.apache.derby.jdbc.EmbeddedDriver");
//		options.put("dbURL", "jdbc:derby:memory:MyDerbyDB;upgrade=true");
//		options.put("dbUser", "sa");
//		options.put("dbPassword", "manager");
//		options.put(
//				"userQuery",
//				"select username from MyDerbyDB.secu_user u where u.username=? and u.password=?");
//		options.put(
//				"roleQuery",
//				"select r.rolename from MyDerbyDB.secu_user u, MyDerbyDB.secu_user_role r where u.username=r.username and u.username=?");
//		options.put("debug", "true");
//
//		JDC instance = new UserRoleInformationJDBC();
//		Assert.assertTrue(instance.init(options));
//		Assert.assertTrue(instance.isValidUser("myName",
//				"myPassword".toCharArray()));
//	}
//
//	/**
//	 * Test method for
//	 * {@link org.jobjects.jaas.persistance.jdbc.UserRoleInformationJDBC#isValidUser(java.lang.String, char[])}
//	 * .
//	 */
//	@Test
//	public void testIsValidUserFalse() {
//		HashMap<String, String> options = new HashMap<String, String>();
//		options.put("dbDriver", "org.apache.derby.jdbc.EmbeddedDriver");
//		options.put("dbURL", "jdbc:derby:memory:MyDerbyDB;upgrade=true");
//		options.put("dbUser", "sa");
//		options.put("dbPassword", "manager");
//		options.put(
//				"userQuery",
//				"select username from MyDerbyDB.secu_user u where u.username=? and u.password=?");
//		options.put(
//				"roleQuery",
//				"select r.rolename from MyDerbyDB.secu_user u, MyDerbyDB.secu_user_role r where u.username=r.username and u.username=?");
//		options.put("debug", "true");
//
//		UserRoleInformationJDBC instance = new UserRoleInformationJDBC();
//		Assert.assertTrue(instance.init(options));
//		Assert.assertFalse(instance.isValidUser("myNameFalse",
//				"myPassword".toCharArray()));
//	}
//
//	/**
//	 * Test method for
//	 * {@link org.jobjects.jaas.persistance.jdbc.UserRoleInformationJDBC#getRoles(java.lang.String)}
//	 * .
//	 */
//	@Test
//	public void testGetRoles() {
//		HashMap<String, String> options = new HashMap<String, String>();
//		options.put("dbDriver", "org.apache.derby.jdbc.EmbeddedDriver");
//		options.put("dbURL", "jdbc:derby:memory:MyDerbyDB;upgrade=true");
//		options.put("dbUser", "sa");
//		options.put("dbPassword", "manager");
//		options.put(
//				"userQuery",
//				"select username from MyDerbyDB.secu_user u where u.username=? and u.password=?");
//		options.put(
//				"roleQuery",
//				"select r.rolename from MyDerbyDB.secu_user u, MyDerbyDB.secu_user_role r where u.username=r.username and u.username=?");
//		options.put("debug", "true");
//
//		UserRoleInformationJDBC instance = new UserRoleInformationJDBC();
//		Assert.assertTrue(instance.init(options));
//		Assert.assertTrue(instance.getRoles("myName").size() > 0);
//	}

}
