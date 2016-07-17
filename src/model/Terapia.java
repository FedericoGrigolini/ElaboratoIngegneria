package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Terapia {
	protected static Connection c = null;
    protected static Statement stmt = null;
	private Ricovero ricovero;
	private String dataInizio;
	private String dataFine;
	
	
	public Terapia(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Terapia;" );
		      while ( rs.next() ) {
		         if(rs.getString(1).equals(k)){
		        	 this.ricovero=new Ricovero(rs.getString(1));
		        	 this.dataInizio=rs.getString(2);
		        	 this.dataFine=rs.getString(3);
		        	 break;
		         }
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public String getDataInizio(){return dataInizio;}
	public String getDataFine(){return dataFine;}
	public Ricovero getRicovero(){return ricovero;}
	
	public void setRicovero(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Terapia "
		      		+ "SET Ricovero='"+ k +"' WHERE Ricovero='"+ this.ricovero.getCodiceUnivoco() +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.ricovero=new Ricovero(k);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	public void setDataInizio(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Terapia "
		      		+ "SET Data_I='"+ k +"' WHERE Ricovero='"+ this.ricovero.getCodiceUnivoco() +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.dataInizio=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	public void setDataFine(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Terapia "
		      		+ "SET Data_F='"+ k +"' WHERE Ricovero='"+ this.ricovero.getCodiceUnivoco() +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.dataFine=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public String toString(){
		return ricovero+" "+dataInizio+" "+dataFine;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
