package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Medico extends Operatore implements Tabella {
	
	protected String Specialit�;
	
	public Medico(String codice, String nome2, String cognome2, String dataN, String luogoN, String dataS, String spec ) {
		super(codice, nome2, cognome2, dataN, luogoN, dataS);
		this.Specialit�=spec;
	}
	
	public Medico(String key) {
		super(key);
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Medico;" );
		      while ( rs.next() ) {
		    	  if(rs.getString("Operatore")==key){
		    		  this.Specialit�= rs.getString("Specialit�");
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
		// TODO Auto-generated constructor stub
	}
	
	public String getSpecialit�(){
		return this.Specialit�;
	}
	
	public LinkedList<Medico> getListaMedici(){
		return getMedici();
	}
	
	protected static LinkedList<Medico> getMedici(){
		LinkedList<Medico> result= new LinkedList<Medico>();	
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Medico;" );
		      while ( rs.next() ) {
		    	  for(Operatore o : getOperatori()){
		  			if(o.codiceFiscale==rs.getString("Operatore")){
		  				Medico m = (Medico)o;
		  				m.Specialit�=rs.getString("Specialit�");
		  				result.add(m);
		  			}
		    	  }
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
		if(t instanceof Medico){
			Medico p=(Medico)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Medico (Operatore,Specialit�) " +
			                   "VALUES ('"+p.codiceFiscale + "','"+p.Specialit�+ "');"; 
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
		if(t instanceof Medico){
			Medico p=(Medico) t;
			String key = p.nome;
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Medico WHERE Operatore='"+ key +"';";
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
			    String sql = "DELETE FROM Medico WHERE Operatore='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	
	public void setSpecialit�(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Medico "
		      		+ "SET Specialit�='"+ k +"' WHERE Operatore='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.Specialit�=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		
	}
	
	public String toString(){
		return "Codice Fiscale: "+this.codiceFiscale+
				"\nNome e Cognome: "+ this.nome +"  "+this.cognome+
				"\nLuogo e Data Nascita: "+ this.luogoNascita +"  "+this.dataNascita +
				"\nData Assunzione: "+ this.dataAssunzione+"  Specialit�: "+this.Specialit�;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
