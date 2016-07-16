package model;

import java.sql.*;
import java.util.LinkedList;

public class Operatore implements Tabella {
	protected static Connection c = null;
    protected static Statement stmt = null;
    
    protected String codiceFiscale;
    protected String nome;
    protected String cognome;
    protected String dataNascita;
    protected String luogoNascita;
    protected String dataAssunzione;
	
	public Operatore(String codice, String nome2, String cognome2, String dataN, String luogoN, String dataS) {
		this.codiceFiscale=codice;
		this.nome=nome2;
		this.cognome=cognome2;
		this.dataNascita=dataN;
		this.luogoNascita=luogoN;
		this.dataAssunzione=dataS;
	}
	
	public Operatore(String key){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Operatore;" );
		      while ( rs.next() ) {
		    	  if(rs.getString("CodiceFiscale")==key){
		    		  this.codiceFiscale= rs.getString("CodiceFiscale");
				      this.nome = rs.getString("Nome");
				      this.cognome= rs.getString("Cognome");
				      this.dataNascita= rs.getString("Data_N");
				      this.luogoNascita= rs.getString("Luogo_N");
				      this.dataAssunzione= rs.getString("Data_Ass");
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
	
	public String getDataAssunzione(){
		return this.dataAssunzione;
	}
	
	public static LinkedList<Operatore> getListaOperatori(){
		return getOperatori();
	}
	
	public void setCodice(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Operatore "
		      		+ "SET CodiceFiscale='"+ k +"' WHERE CodiceFiscale='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.codiceFiscale=k;
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
		      ResultSet rs = stmt.executeQuery( "UPDATE Operatore "
		      		+ "SET Nome='"+ k +"' WHERE CodiceFiscale='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.nome=k;
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
		      ResultSet rs = stmt.executeQuery( "UPDATE Operatore "
		      		+ "SET Cognome='"+ k +"' WHERE CodiceFiscale='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.cognome=k;
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
		      ResultSet rs = stmt.executeQuery( "UPDATE Operatore "
		      		+ "SET Data_N='"+ k +"' WHERE CodiceFiscale='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.dataNascita=k;
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
		      ResultSet rs = stmt.executeQuery( "UPDATE Operatore "
		      		+ "SET Luogo_N='"+ k +"' WHERE CodiceFiscale='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.luogoNascita=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setDataAssunzione(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Operatore "
		      		+ "SET Data_Ass='"+ k +"' WHERE CodiceFiscale='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.dataAssunzione=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	
	private static LinkedList<Operatore> getOperatori(){
		LinkedList<Operatore> result = new LinkedList<Operatore>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Operatore;" );
		      while ( rs.next() ) {
		         String  codice = rs.getString("CodiceFiscale");
		         String  nome = rs.getString("Nome");
		         String  cognome = rs.getString("Cognome");
		         String  dataN = rs.getString("Data_N");
		         String luogoN = rs.getString("Luogo_N");
		         String provincia = rs.getString("Provincia_R");
		         result.add(new Operatore(codice,nome,cognome,dataN,luogoN,provincia));
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
	public void insert(Object t) {
		if(t instanceof Operatore){
			Operatore p=(Operatore)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Operatore (CodiceFiscale,Nome,Cognome,Data_N,Luogo_N,Data_Ass) " +
			                   "VALUES ('"+p.codiceFiscale + "','"+p.nome + "','" + p.cognome + "','" +p.dataNascita+
			                   "','"+ p.luogoNascita + "','"+ p.dataAssunzione + "');"; 
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
	public void delete(Object t) {
		if(t instanceof Operatore){
			Operatore p=(Operatore) t;
			String key = p.codiceFiscale;
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Operatore WHERE CodiceFiscale='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
		}
	}

	public void delete(String key){
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Operatore WHERE CodiceFiscale='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	
	public String toString(){
		return "Codice Fiscale: "+this.codiceFiscale+
				"\nNome e Cognome: "+ this.nome +" "+this.cognome+
				"\nLuogo e Data Nascita: "+ this.luogoNascita +" "+this.dataNascita +
				"\nData Assunzione: "+ this.dataAssunzione+" ";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}