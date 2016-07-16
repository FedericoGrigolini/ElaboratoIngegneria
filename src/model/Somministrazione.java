package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Somministrazione {
	protected static Connection c = null;
    protected static Statement stmt = null;
    
	private Integer dose;
	private String modalità;
	private Terapia terapia;//chiave
	private Farmaco farmaco;//chiave
	private Infermiere infermiere;//chiave
	
	public Somministrazione(Terapia t, Farmaco f, Infermiere i,String m, Integer d) {
		this.terapia=t;
		this.farmaco=f;
		this.infermiere=i;
		this.modalità=m;
		this.dose=d;	
	}
	public Somministrazione(String t, String f,String i) {
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Somministrazione;" );
		      while ( rs.next() ) {
		         if(t==rs.getString(1) && f==rs.getString(2) && i==rs.getString(3)){
		        	 this.terapia = new Terapia(t);
		        	 this.farmaco = new Farmaco(f);
		        	 this.infermiere = new Infermiere(i);
		        	 this.modalità=rs.getString(5);
		        	 this.dose=new Integer(rs.getInt(4));
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
	
	public String getModalità(){
		return modalità;
	}
	public Integer getDosaggio(){
		return dose;
	}
	public Terapia getTerapia(){
		return this.terapia;
	}
	public Farmaco getFarmaco(){
		return this.farmaco;
	}
	public Infermiere getInfermiere(){
		return this.infermiere;
	}
	
	public void setTerapia(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Somministrazione "
		      		+ "SET Terapia='"+ k +"' WHERE Dosaggio='"+ this.getDosaggio()+"' AND Terapia="+ terapia.getRicovero() +";" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.terapia=new Terapia(k);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	public void setFarmaco(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Somministrazione "
		      		+ "SET Farmaco='"+ k +"' WHERE Farmaco='"+ this.getFarmaco()+"' AND Terapia="+ terapia.getRicovero() +"' AND Infermiere="+ infermiere.codiceFiscale +";" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.farmaco=new Farmaco(k);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	public void setInfermiere(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Somministrazione "
		      		+ "SET Infermiere='"+ k +"' WHERE Farmaco='"+ this.getFarmaco()+"' AND Terapia="+ terapia.getRicovero() +"' AND Infermiere="+ infermiere.codiceFiscale +";" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.infermiere= new Infermiere(k);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	public void setDosaggio(Integer k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Somministrazione "
		      		+ "SET Dosaggio='"+ k +"' WHERE Farmaco='"+ this.getFarmaco()+"' AND Terapia="+ terapia.getRicovero() +"' AND Infermiere="+ infermiere.codiceFiscale +";" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.dose= k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	public void setModalità(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Somministrazione "
		      		+ "SET Modalità='"+ k +"' WHERE Farmaco='"+ this.getFarmaco()+"' AND Terapia="+ terapia.getRicovero() +"' AND Infermiere="+ infermiere.codiceFiscale +";" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.modalità= k;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
