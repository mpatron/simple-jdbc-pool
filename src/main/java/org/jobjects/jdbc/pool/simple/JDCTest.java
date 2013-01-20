package org.jobjects.jdbc.pool.simple;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDCTest {

  public static void main(String [] args) throws Exception {

    Connection con = JDCConnectionManager.getInstance().getConnection();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("select count(*) from locations");
    while(rs.next()) {
      System.out.println(rs.getString(1));
    }
    rs.close();
    System.out.println("1");
    stmt.close();
    System.out.println("2");
    con.close();
    System.out.println("3");

    Connection[] c = new Connection[24];
    for (int i=0; i<c.length; i++) {
      c[i] = JDCConnectionManager.getInstance().getConnection();
    }
    for (int i=0; i<c.length; i++) {
      c[i].close();
    }
    System.out.println("4");
  }
  //---------------------------------------------------------------------------
}

