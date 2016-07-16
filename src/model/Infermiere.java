package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Infermiere extends Operatore implements Tabella{

	
	public Infermiere(String codice, String nome2, String cognome2, String dataN, String luogoN, String dataS) {
		super(codice, nome2, cognome2, dataN, luogoN, dataS);
		// TODO Auto-generated constructor stub
	}
	
	public Infermiere(String key) {
		super(key);
		// TODO Auto-generated constructor stub
	}
	
	
	public static LinkedList<Infermiere> getListaInfermieri(){
		return getInfermieri();
	}
	
	private static LinkedList<Infermiere> getInfermieri(){
		LinkedList<Infermiere> result = new LinkedList<Infermiere>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Infermiere;" );
		      while ( rs.next() ) {
		         String  operatore = rs.getString("Operatore");
		         
		         result.add(new Infermiere(operatore));
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
		if(t instanceof Infermiere){
			Infermiere p=(Infermiere)t;
			LinkedList<Operatore> temp = getListaOperatori();
			for(Operatore o:temp){
				if(o.getCodiceFiscale()==p.codiceFiscale){
					try {
						Class.forName("org.sqlite.JDBC");
						c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
						c.setAutoCommit(false);
						stmt = c.createStatement();
						String sql = "INSERT INTO Infermiere (Operatore) " +
								"VALUES ('"+p.codiceFiscale + "');"; 
						stmt.executeUpdate(sql);
						stmt.close();
						c.commit();
						c.close();
					} catch ( Exception e ) {
						System.err.println( e.getClass().getName() + ": " + e.getMessage() );
						System.exit(0);
					}
					break;
				}
			}
		}	
	}

	@Override
	public void delete(Object t) {
		if(t instanceof Infermiere){
			Infermiere p=(Infermiere) t;
			String key = p.getCodiceFiscale();
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Infermiere WHERE Operatore='"+ key +"';";
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
			    String sql = "DELETE FROM Infermiere WHERE Operatore='"+ key +"';";
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
