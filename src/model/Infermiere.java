package model;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class Infermiere extends Operatore {

	
	public Infermiere(String codice, String nome2, String cognome2, String dataN, String luogoN, String dataS) {
		super(codice, nome2, cognome2, dataN, luogoN, dataS);
		// TODO Auto-generated constructor stub
	}
	
	public Infermiere(String key) {
		super(key);
		// TODO Auto-generated constructor stub
	}
	
	public void setOperatore(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Infermiere "
		      		+ "SET Operatore='"+ k +"' WHERE Operatore='"+ this.codiceFiscale +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.codiceFiscale=k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
