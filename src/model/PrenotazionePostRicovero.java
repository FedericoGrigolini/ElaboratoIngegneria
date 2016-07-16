package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class PrenotazionePostRicovero{
	protected static Connection c = null;
    protected static Statement stmt = null;
	
    private Ricovero ricovero;
	private String data;
	private String orario;
	
	public PrenotazionePostRicovero(String key){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM PrenotazioniPostRicovero;" );
		      while ( rs.next() ) {
		         if(key==rs.getString(1)){
		        	 this.ricovero=new Ricovero(key);
		        	 this.data=rs.getString(2);
		        	 this.orario=rs.getString(3);
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
	
	public Ricovero getRicovero(){return this.ricovero;}
	public String getData(){return this.data;}
	public String getOrario(){return this.orario;}
	
	public void setRicovero(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE PrenotazioniPostRicovero "
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
	public void setData(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE PrenotazioniPostRicovero "
		      		+ "SET Data='"+ k +"' WHERE Ricovero='"+ this.ricovero.getCodiceUnivoco() +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.data=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	public void setOrario(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE PrenotazioniPostRicovero "
		      		+ "SET Orario='"+ k +"' Ricovero='"+ this.ricovero.getCodiceUnivoco() +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.orario=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	public LinkedList<PrenotazionePostRicovero> getListaPrenotazioniPostRicovero(){
		LinkedList<PrenotazionePostRicovero> result = new LinkedList<PrenotazionePostRicovero>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM PrenotazioniPostRicovero;" );
		      while ( rs.next() ) {
		         String  ricovero = rs.getString(1);

		         result.add(new PrenotazionePostRicovero(ricovero));
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
	public void insertPrenotazionePostRicovero(Object t) {
		if(t instanceof PrenotazionePostRicovero){
			PrenotazionePostRicovero p=(PrenotazionePostRicovero)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO PrenotazionePostRicovero (Ricovero,Data,Orario) " +
			                   "VALUES ('"+p.getRicovero().getCodiceUnivoco() +"','"+p.getData() +"','"+p.getOrario() +"');"; 
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
	public void deletePrenotazionePostRicovero(String key) {
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM PrenotazionePostRicovero WHERE Nome='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}	
	
	
	
}
