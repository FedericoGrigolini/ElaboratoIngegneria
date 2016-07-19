package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class PrenotazionePostRicovero{
	protected static Connection c = null;
    protected static Statement stmt = null;
	
    private Ricovero ricovero;
	private String data;
	private String orario;
	
	public PrenotazionePostRicovero(Ricovero R,String d,String o) {
		ricovero=R;
		data=d;
		orario=o;
		// TODO Auto-generated constructor stub
	}

	public PrenotazionePostRicovero(String key){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM PrenotazioniPostRicovero;" );
		      while ( rs.next() ) {
		         if(rs.getString(1).equals(key)){
		        	 this.ricovero=new Ricovero(key);
		        	 this.data=rs.getString(2);
		        	 this.orario=rs.getString(3);
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
	
	public Ricovero getRicovero(){return this.ricovero;}
	public String getData(){return this.data;}
	public String getOrario(){return this.orario;}
	
	public void setRicovero(String k){this.ricovero=new Ricovero(k);	}	
	public void setData(String k){this.data=k;		    }
	public void setOrario(String k){this.orario=k;	}
	
	
}
