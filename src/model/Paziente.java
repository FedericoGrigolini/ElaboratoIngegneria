//modificare anche gli attributi nei setAttributo

package model;

import java.sql.*;
import java.util.LinkedList;

public class Paziente implements Tabella {
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
		    	  if(rs.getString("Codice")==key){
		    		  this.codiceFiscale= rs.getString("Codice");
				      this.nome = rs.getString("Nome");
				      this.cognome= rs.getString("Cognome");
				      this.dataNascita= rs.getString("Data_N");
				      this.luogoNascita= rs.getString("Luogo_N");
				      this.provinciaResidenza= rs.getString("Provincia_R");
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
	
	static public LinkedList<Paziente> getListaPazienti(){
		return getPazienti();
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
	
	
	private static LinkedList<Paziente> getPazienti(){
		LinkedList<Paziente> result = new LinkedList<Paziente>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Paziente;" );
		      while ( rs.next() ) {
		         String  codice = rs.getString("Codice");
		         String  nome = rs.getString("Nome");
		         String  cognome = rs.getString("Cognome");
		         String  dataN = rs.getString("Data_N");
		         String luogoN = rs.getString("Luogo_N");
		         String provincia = rs.getString("Provincia_R");
		         result.add(new Paziente(codice,nome,cognome,dataN,luogoN,provincia));
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
		if(t instanceof Paziente){
			Paziente p=(Paziente)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Paziente (Codice,Nome,Cognome,Data_N,Luogo_N,Provincia_N) " +
			                   "VALUES ('"+p.codiceFiscale + "','"+p.nome + "','" + p.cognome + "','" +p.dataNascita+
			                   "','"+ p.luogoNascita + "','"+ p.provinciaResidenza + "');"; 
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
		if(t instanceof Paziente){
			Paziente p=(Paziente) t;
			String key = p.nome;
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Paziente WHERE Codice='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
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
