package control;

import java.sql.*;

public class Insert
{
  public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "INSERT INTO PrenotazioniPostRicovero (Ricovero,Data,Orario) " +
                   "VALUES ('R0002', 2016-02-24, '15:45' );"; 
      stmt.executeUpdate(sql);

      

      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  }
}