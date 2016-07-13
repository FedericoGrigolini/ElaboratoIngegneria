package control;
import java.sql.*;
import java.text.*;

public class Select
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
      ResultSet rs = stmt.executeQuery( "SELECT * FROM Paziente;" );
      while ( rs.next() ) {
         String  codice = rs.getString("Codice");
         String  name = rs.getString("Nome");
         String  cognome = rs.getString("Cognome");
         String dataNascita =rs.getString("Data_N");
         String  luogoNascita = rs.getString("Luogo_N");
         String  address = rs.getString("Provincia_R");
         System.out.println( "ID = " + codice );
         System.out.println( "NAME = " + name +" "+cognome );
         System.out.println( "DATA NASCITA = " + dataNascita );
         System.out.println( "LUOGO NASCITA = " + luogoNascita );
         System.out.println( "PROVINCIA RESIDENZA = " + address );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }
}