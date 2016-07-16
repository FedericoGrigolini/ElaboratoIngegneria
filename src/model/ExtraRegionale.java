package model;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class ExtraRegionale extends Paziente{

	private String Ulss;
	private String regione;
	
	public ExtraRegionale(String codice, String nome2, String cognome2, String dataN, String luogoN, String provincia,String ul,String re) {
		super(codice, nome2, cognome2, dataN, luogoN, provincia);
		// TODO Auto-generated constructor stub
		Ulss=ul;
		regione=re;
	}
	public ExtraRegionale(String key) {
		super(key);
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM FuoriRegione;" );
		      while ( rs.next() ) {
		    	  if(rs.getString(1)==key){
		    		  this.Ulss=rs.getString(2);
		    		  this.regione=rs.getString(3);
		    	  }
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getUlss(){return Ulss;}
	public String getRegione(){return regione;}
	public void setUlss(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE FuoriRegione "
		      		+ "SET Ulss='"+ k +"' WHERE Paziente='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.Ulss=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	public void setRegione(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE FuoriRegione "
		      		+ "SET Regione='"+ k +"' WHERE Paziente='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.regione=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	

}
