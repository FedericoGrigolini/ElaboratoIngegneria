package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class Terapia implements Tabella {
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
		         if(k==rs.getString(1)){
		        	 this.ricovero=new Ricovero(k);
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
	
	public LinkedList<Terapia> getListaTerapie(){return getTerapie();}
	
	protected static LinkedList<Terapia> getTerapie(){
		LinkedList<Terapia> result = new LinkedList<Terapia>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Terapia;" );
		      while ( rs.next() ) {
		         result.add(new Terapia(rs.getString(1)));
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      return null;
		    }
		return result;
	}
	
	@Override
	public void insert(Tabella t) {
		if(t instanceof Terapia){
			Terapia p=(Terapia)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Terapia (Ricovero,Data_I,Data_F) " +
			                   "VALUES ('"+p.ricovero.getCodiceUnivoco() + "','"+ p.dataInizio +"','"+ p.dataFine+"');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}
	}

	@Override
	public void delete(Tabella t) {
		if(t instanceof Terapia){
			Terapia p=(Terapia) t;
			String key = p.getRicovero().getCodiceUnivoco();
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Terapia WHERE Ricovero='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
		}
	}
	
	public void delete(String key) {	
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Terapia WHERE Ricovero='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
