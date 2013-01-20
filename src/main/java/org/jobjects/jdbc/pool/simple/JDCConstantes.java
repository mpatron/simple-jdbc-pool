package org.jobjects.jdbc.pool.simple;

public class JDCConstantes {

  //Temps en miliseconde avant qu'il y ait �puration dans le pool de connection
  public static long delay=300000;//5 minutes (300000)

  //Temps en miliseconde pour qu'il est supression de la connection dans le pool
  public static long timeout=60000; //1 minutes (60000)

  public static String driver="oracle.jdbc.driver.OracleDriver";
  public static String url="jdbc:oracle:thin:@localhost:1521:EDI";
  public static String user="catalog";
  public static String password="catalog";
  public static String owner="%";
}