package org.jobjects.jdbc.pool.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Vector;

public class JDCConnectionPool {

  private Vector<Connection> connections;
  private String url, user, password;
  final private long timeout=JDCConstantes.timeout;
  private java.util.Timer timer;

  public JDCConnectionPool(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
    connections = new Vector<Connection>();

    timer=new java.util.Timer(true) ;
    java.util.TimerTask task= new java.util.TimerTask() {
                                public void run() {
                                  reapConnections();
                                }
                              };
    timer.schedule(task, 0, JDCConstantes.delay);
  }
  //---------------------------------------------------------------------------

  public synchronized void reapConnections() {
    long stale = System.currentTimeMillis() - timeout;
    Enumeration<Connection> connlist = connections.elements();
    while((connlist != null) && (connlist.hasMoreElements())) {
      JDCConnection conn = (JDCConnection)connlist.nextElement();
      if((conn.inUse()) && (stale >conn.getLastUse()) &&  (!conn.validate())) {
       removeConnection(conn);
      }
    }
  }
  //---------------------------------------------------------------------------

  public synchronized void closeConnections() {
    Enumeration<Connection> connlist = connections.elements();
    while((connlist != null) && (connlist.hasMoreElements())) {
      JDCConnection conn = (JDCConnection)connlist.nextElement();
      removeConnection(conn);
    }
  }
  //---------------------------------------------------------------------------

  private synchronized void removeConnection(JDCConnection conn) {
    connections.removeElement(conn);
  }
  //---------------------------------------------------------------------------

  public synchronized Connection getConnection() throws SQLException {
    JDCConnection c=null;
    for(int i = 0; i < connections.size(); i++) {
      c = (JDCConnection)connections.elementAt(i);
      if (c.lease()) {
        return c;
      }
    }
    Connection conn = DriverManager.getConnection(url, user, password);
    c = new JDCConnection(conn, this);
    c.lease();
    connections.addElement(c);
    Statement stmt = c.createStatement();
    stmt.executeUpdate("ALTER SESSION SET NLS_SORT = BINARY");
    stmt.executeUpdate("ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS'");
    stmt.executeUpdate("ALTER SESSION SET NLS_NUMERIC_CHARACTERS = '. '");
    stmt.close();
    return c;
  }
  //---------------------------------------------------------------------------

  public synchronized void returnConnection(JDCConnection conn) {
    conn.expireLease();
  }
  //---------------------------------------------------------------------------
}
