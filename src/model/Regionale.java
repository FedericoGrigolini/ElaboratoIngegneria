package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Regionale extends Paziente {

	public Regionale(String key) {
		super(key);
		// TODO Auto-generated constructor stub
	}
	
	public void setPaziente(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE InRegione "
		      		+ "SET Paziente='"+ k +"' WHERE Paziente='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.codiceFiscale=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public LinkedList<Regionale> getListaRegionali(){
		LinkedList<Regionale> result = new LinkedList<Regionale>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM InRegione;" );
		      while ( rs.next() ) {
		         String  paziente = rs.getString(1);
		         result.add(new Regionale(paziente));
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
	public void insertRegionale(Object t) {
		if(t instanceof Regionale){
			Regionale p=(Regionale)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO InRegione (Paziente) " +
			                   "VALUES ('"+p.getCodiceFiscale() +"');"; 
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
	public void deleteRegionale(String key) {
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM InRegione WHERE Paziente='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}

}
