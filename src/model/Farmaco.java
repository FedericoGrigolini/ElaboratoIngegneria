package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class Farmaco implements Tabella {
	protected static Connection c = null;
    protected static Statement stmt = null;
    
	private String nome;
	private String azienda;
	private Integer dosaggioRaccomandato;
	
	public Farmaco(String n,String a,Integer d){
		nome=n;
		azienda=a;
		dosaggioRaccomandato=d;
	}
	
	public Farmaco(String nome){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Farmaco;" );
		      while ( rs.next() ) {
		         if(nome==rs.getString(1)){
		        	 this.nome=nome;
		        	 this.azienda=rs.getString(2);
		        	 this.dosaggioRaccomandato= new Integer(rs.getInt(3));
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
	public String getAzienda(){
		return azienda;
	}
	public Integer getDosaggioRaccomandato(){
		return dosaggioRaccomandato;
	}
	public LinkedList<Farmaco> getListaFarmaci(){
		return getFarmaci();
	}
	public LinkedList<PrincipioAttivo> getListaPrincipiattivi(){
		LinkedList<PrincipioAttivo> res = new LinkedList<PrincipioAttivo>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Composizione_Farmaco;" );
		      while ( rs.next() ) {
		         if(nome==rs.getString(1)){
		        	 res.add(new PrincipioAttivo(rs.getString(2)));
		         }
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      return null;
		    }
		return res;
	}
	public Integer getQuantit‡Principio(PrincipioAttivo p){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Composizione_Farmaco;" );
		      while ( rs.next() ) {
		         if(nome==rs.getString(1)&&p.getNome()==rs.getString(2)){
		        	 return new Integer(rs.getInt(3));
		         }
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      return null;
		    }
		return null;
	}	
	protected static LinkedList<Farmaco> getFarmaci(){
	LinkedList<Farmaco> result = new LinkedList<Farmaco>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Farmaco;" );
		      while ( rs.next() ) {
		         String  nome = rs.getString(1); 
		         result.add(new Farmaco(nome));
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
	
	public void setNome(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE PrincipioAttivo "
		      		+ "SET Nome_Comm='"+ k +"' WHERE Nome_Comm='"+ this.nome +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.nome=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setAzienda(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE PrincipioAttivo "
		      		+ "SET Azienda='"+ k +"' WHERE Nome_Comm='"+ this.nome +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.azienda=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setDoseR(Integer i){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE PrincipioAttivo "
		      		+ "SET Dose_R='"+ i +"' WHERE Nome_Comm='"+ this.nome +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.dosaggioRaccomandato=i;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	
	
	@Override
	public void insert(Tabella t) {
		if(t instanceof Farmaco){
			Farmaco p=(Farmaco)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Farmaco (Nome_Comm,Azienda,Dose_R) " +
			                   "VALUES ('"+p.getNome() +"','"+ p.getAzienda() +"','"+ p.getDosaggioRaccomandato() +"');"; 
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
		if(t instanceof Farmaco){
			Farmaco p=(Farmaco) t;
			String key = p.getNome();
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Farmaco WHERE Nome_Comm='"+ key +"';";
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
			    String sql = "DELETE FROM Farmaco WHERE Nome_Comm='"+ key +"';";
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
