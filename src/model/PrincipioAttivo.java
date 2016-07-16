package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class PrincipioAttivo implements Tabella {
	protected static Connection c = null;
    protected static Statement stmt = null;
	private String nome;
	
	public PrincipioAttivo(String nome){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM PrincipioAttivo;" );
		      while ( rs.next() ) {
		         if(nome==rs.getString(1)){
		        	 this.nome=nome;
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
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE PrincipioAttivo "
		      		+ "SET Nome='"+ k +"' WHERE Nome='"+ this.nome +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.nome=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public static LinkedList<PrincipioAttivo> getListaPrinciAttivi(){
		return getPrincipiAttivi();
	}
	
	protected static LinkedList<PrincipioAttivo> getPrincipiAttivi(){
		LinkedList<PrincipioAttivo> result = new LinkedList<PrincipioAttivo>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM PrincipioAttivo;" );
		      while ( rs.next() ) {
		         String  nome = rs.getString("Nome");

		         result.add(new PrincipioAttivo(nome));
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
		if(t instanceof PrincipioAttivo){
			PrincipioAttivo p=(PrincipioAttivo)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO PrincipioAttivo (Nome) " +
			                   "VALUES ('"+p.nome +  "');"; 
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
		if(t instanceof PrincipioAttivo){
			PrincipioAttivo p=(PrincipioAttivo) t;
			String key = p.getNome();
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM PrincipioAttivo WHERE Nome='"+ key +"';";
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
			    String sql = "DELETE FROM PrincipioAttivo WHERE Nome='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	
	public String toString(){
		return "Principio Attivo"+this.nome;
	}
	
	public static void main(String[] args) {
		

	}

}
