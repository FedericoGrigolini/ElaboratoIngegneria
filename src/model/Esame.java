package model;

import java.sql.*;
import java.util.LinkedList;

public class Esame {
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
		    	  if(rs.getString("TipoEsame").equals(kt) && rs.getString("Ricovero").equals(kr)){
		    		  this.tipo= kt;
				      this.ricovero=new Ricovero(rs.getString("Ricovero"));
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
	
	public void setTipo(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Esame "
		      		+ "SET Tipo='"+ k +"' WHERE TipoEsame='"+ this.tipo +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"';" );
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
		      		+ "SET Ricovero='"+ k +"' WHERE TipoEsame='"+ this.tipo +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"';" );
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
			      		+ "SET Risultati='"+ k +"' WHERE TipoEsame='"+ this.tipo +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"';" );
			      rs.close();
		      stmt.close();
		      c.close();
		      this.risultati=k;
		    } catch ( Exception e ) {
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