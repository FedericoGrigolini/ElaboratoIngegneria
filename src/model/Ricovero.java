package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;


public class Ricovero implements Tabella {
	protected static Connection c = null;
    protected static Statement stmt = null;
	
	private String codiceUnivoco;
	private String divisione;
	private String dataInizio;
	private String dataFine;
	private Paziente paziente;
	private String motivo; 
	private Medico medicoRes;
	private Integer letto;
	private Boolean dayHospital;
	
	
	
	public Ricovero(String cu, String div,String di,String df,String p,String mo,String me,int l,boolean h ){
		this.codiceUnivoco=cu;
		this.divisione=div;
		this.dataInizio=di;
		this.dataFine=df;
		this.paziente=new Paziente(p);
		this.motivo=mo;
		this.medicoRes=new Medico(me);
		this.letto=l;
		this.dayHospital=h;	
	}
	
	public Ricovero(String key) {
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Medico;" );
		      while ( rs.next() ) {
		    	  if(rs.getString("Codice")==key){
		    		  this.codiceUnivoco = rs.getString("Codice");
		    		  this.dataInizio = rs.getString("Data_I");
		 	          this.dataFine = rs.getString("Data_F");
		 	          this.motivo = rs.getString("Motivo");
		 	          this.paziente = new Paziente(rs.getString("Paziente"));
		 	          this.divisione = rs.getString("Divisione");
		 	          this.letto = rs.getInt("Letto");
		 	          this.medicoRes = new Medico(rs.getString("Medico_Res"));
		 	          this.dayHospital = rs.getBoolean("DayHospital");
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
	
	public String getCodiceUnivoco(){
		return this.codiceUnivoco;
	}
	public String getDivisione(){
		return divisione;
	}
	public String getDataInizio(){
		return dataInizio;
	}
	public String getDataFine(){
		return dataFine;
	}
	public Paziente getPaziente(){
		return paziente;
	}
	public String getMotivo(){
		return motivo;
	}
	public Medico getMedicoResponsabile(){
		return medicoRes;
	}
	public Integer getLetto(){
		return letto;
	}
	public boolean getDayHospital(){
		return dayHospital;
	}
	public static LinkedList<Ricovero> getListaRicoveri(){
		return getRicoveri();
	}
	
	public void setCodiceUnivoco(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Ricovero "
		      		+ "SET Codice='"+ k +"' WHERE Codice='"+ this.codiceUnivoco +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.codiceUnivoco=k;
		} catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
	}
	
	public void setDivisione(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Ricovero "
		      		+ "SET Divisione='"+ k +"' WHERE Codice='"+ this.codiceUnivoco +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.divisione=k;
		} catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
	}
	
	public void setDataInizio(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Ricovero "
		      		+ "SET Data_I='"+ k +"' WHERE Codice='"+ this.codiceUnivoco +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.dataInizio=k;
		} catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
	}
	
	public void setDataFine(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Ricovero "
		      		+ "SET Data_F='"+ k +"' WHERE Codice='"+ this.codiceUnivoco +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.dataFine=k;
		} catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
	}
	
	public void setPaziente(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Ricovero "
		      		+ "SET Paziente='"+ k +"' WHERE Codice='"+ this.codiceUnivoco +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.paziente.setCodice(k);
		} catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
	}
	
	public void setMotivo(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Ricovero "
		      		+ "SET Motivo='"+ k +"' WHERE Codice='"+ this.codiceUnivoco +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.motivo=k;
		} catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
	}
	
	public void setMedicoResponsabile(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Ricovero "
		      		+ "SET Medico_Res='"+ k +"' WHERE Codice='"+ this.codiceUnivoco +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.medicoRes.setCodice(k);
		} catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
	}
	
	public void setLetto(Integer k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Ricovero "
		      		+ "SET Letto='"+ k.toString() +"' WHERE Codice='"+ this.codiceUnivoco +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.letto=k.intValue();
		} catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
	}
	
	public void setDayHospital(boolean k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Ricovero "
		      		+ "SET DayHospital='"+ k +"' WHERE Codice='"+ this.codiceUnivoco +"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.dayHospital=k;
		} catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
	}

	private static LinkedList<Ricovero> getRicoveri(){
		LinkedList<Ricovero> result=new LinkedList<Ricovero>();
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
	      c.setAutoCommit(false);
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM Ricovero;" );
	      while ( rs.next() ) {
	         String  codice = rs.getString("Codice");
	         String  dataInizio = rs.getString("Data_I");
	         String  dataFine = rs.getString("Data_F");
	         String  motivo = rs.getString("Motivo");
	         String paziente = rs.getString("Paziente");
	         String divisione = rs.getString("Divisione");
	         int letto = rs.getInt("Letto");
	         String medico = rs.getString("Medico_Res");
	         Boolean  dayHospital = rs.getBoolean("DayHospital");
	         result.add(new Ricovero(codice, divisione, dataInizio, dataFine, paziente, motivo, medico ,letto,dayHospital));
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
	
	public String toString(){
		return "Codice Univoco: "+this.codiceUnivoco+"  Divisione: "+this.divisione+
				"\nData Inizio: "+this.dataInizio+"   Data Fine: "+this.dataFine+
				"\nPaziente: "+this.paziente+
				"\nMotivo: "+this.motivo+
				"\nMedico Responsabile: "+this.medicoRes+
				"\nLetto: "+letto+"   Day Hospital: "+this.dayHospital+"\n";	
	}
	
	
	public static void main( String args[] ){
		LinkedList<Ricovero> ricoveri = getRicoveri();
		for(Ricovero a : ricoveri){
			System.out.println(a.toString());
		}
	}
	
	@Override
	public void insert(Tabella t) {
		if(t instanceof Ricovero){
			Ricovero p=(Ricovero)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Ricovero (CodiceFiscale,Data_I,Data_F,Motivo,Paziente,Divisione,Letto,Medico_Res,dayHospital) " +
			                   "VALUES ('"+p.codiceUnivoco + "','"+p.dataInizio + "','" + p.dataFine + "','" +p.motivo+
			                   "','"+ p.paziente.getCodiceFiscale() + "','"+ p.divisione + "','"+ p.letto + "','"+ p.medicoRes.getCodiceFiscale()+
			                   p.dayHospital +"');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Tabella t) {
		if(t instanceof Ricovero){
			Ricovero p=(Ricovero) t;
			String key = p.codiceUnivoco;
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Ricovero WHERE Codice='"+ key +"';";
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
			    String sql = "DELETE FROM Ricovero WHERE Codice='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	
	
	//mancano le foreign key.
	
	
}
