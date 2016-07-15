package model;

import java.sql.*;
import java.util.LinkedList;

public class Esame implements Tabella {
	protected static Connection c = null;
    protected static Statement stmt = null;
    
    protected String tipo;
    protected Ricovero ricovero;
    protected String risultati;
	
	public Esame(String t, String ric, String ris) {
		this.tipo=t;
		this.ricovero=new Ricovero(ric);
		this.risultati=ris;
	}
	
	public Esame(String kt,String kr ){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Esame;" );
		      while ( rs.next() ) {
		    	  if(rs.getString("TipoEsame")==kt && rs.getString("Ricovero")==kr){
		    		  this.tipo= kt;
				      this.ricovero=new Ricovero(kr);
				      this.risultati=rs.getString("Risultati");
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
	
	public String getTipo(){
		return this.tipo;
	}
	
	public Ricovero getRicovero(){
		return this.ricovero;
	}
	
	public String getRisultati(){
		return this.risultati;
	}
	
	public LinkedList<Esame> getListaEsami(){
		return getEsami();
	}
	
	public void setTipo(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Esame "
		      		+ "SET Tipo='"+ k +"' WHERE Tipo='"+ this.tipo +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.tipo=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		
	}
	
	public void setRicovero(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Esame "
		      		+ "SET Ricovero='"+ k +"' WHERE Tipo='"+ this.tipo +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.ricovero=new Ricovero(k);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setRisultati(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Esame "
			      		+ "SET Risultati='"+ k +"' WHERE Tipo='"+ this.tipo +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"';" );
			      rs.close();
		      stmt.close();
		      c.close();
		      this.risultati=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		
	}
	
	protected static LinkedList<Esame> getEsami(){
		LinkedList<Esame> result = new LinkedList<Esame>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Esame;" );
		      while ( rs.next() ) {
		         String  tipo = rs.getString("Tipo");
		         String  ricovero = rs.getString("Ricovero");
		         result.add(new Esame(tipo, ricovero));
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
		if(t instanceof Esame){
			Esame p=(Esame)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Esame (Tipo,Ricovero,Risultati) " +
			                   "VALUES ('"+p.tipo + "','"+p.ricovero.getCodiceUnivoco() + "','" + p.risultati + "');"; 
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
		if(t instanceof Esame){
			Esame p=(Esame) t;
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Esame WHERE Tipo='"+ p.tipo +"' AND Ricovero='"+p.ricovero.getCodiceUnivoco()+"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
		}
	}

	public void delete(String k, String kr){
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Esame WHERE Tipo='"+ k +"' AND Ricovero='"+kr+"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	
	public String toString(){
		return "Tipo Esame: "+tipo+
				"\nCodice Ricovero: "+ricovero.getCodiceUnivoco()+
				"\nRisultati: "+risultati+"\n";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}