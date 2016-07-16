//modificare anche gli attributi nei setAttributo

package model;

import java.sql.*;


public class Paziente{
	protected static Connection c = null;
    protected static Statement stmt = null;
    
    protected String codiceFiscale;
    protected String nome;
    protected String cognome;
    protected String dataNascita;
    protected String luogoNascita;
    protected String provinciaResidenza;
	
	public Paziente(String codice, String nome2, String cognome2, String dataN, String luogoN, String provincia) {
		this.codiceFiscale=codice;
		this.nome=nome2;
		this.cognome=cognome2;
		this.dataNascita=dataN;
		this.luogoNascita=luogoN;
		this.provinciaResidenza=provincia;
	}
	
	public Paziente(String key){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Paziente;" );
		      while ( rs.next() ) {
		    	  if(rs.getString("Codice").equals(key)){
		    		  this.codiceFiscale= rs.getString(1);
				      this.nome = rs.getString(2);
				      this.cognome= rs.getString(3);
				      this.dataNascita= rs.getString(4);
				      this.luogoNascita= rs.getString(5);
				      this.provinciaResidenza= rs.getString(6);
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
	
	public String getCodiceFiscale(){
		return this.codiceFiscale;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getCognome(){
		return this.cognome;
	}
	
	public String getDataNascita(){
		return this.dataNascita;
	}
	
	public String getLuogaNascita(){
		return this.luogoNascita;
	}
	
	public String getProvincia(){
		return this.provinciaResidenza;
	}

	
	public void setCodice(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Paziente "
		      		+ "SET Codice='"+ k +"' WHERE Codice='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setNome(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Paziente "
		      		+ "SET Nome='"+ k +"' WHERE Codice='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setCognome(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Paziente "
		      		+ "SET Cognome='"+ k +"' WHERE Codice='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setDataNascita(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Paziente "
		      		+ "SET Data_N='"+ k +"' WHERE Codice='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setLuogoNascita(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Paziente "
		      		+ "SET Luogo_N='"+ k +"' WHERE Codice='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setProvincia(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Paziente "
		      		+ "SET Provincia_R='"+ k +"' WHERE Codice='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public String toString(){
		return "Codice Fiscale: "+this.codiceFiscale+
				"\nNome e Cognome: "+ this.nome +" "+this.cognome+
				"\nLuogo e Data Nascita: "+ this.luogoNascita +" "+this.dataNascita +
				"\nProvincia: "+ this.provinciaResidenza;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
