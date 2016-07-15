package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Ricovero {
	private String codiceUnivoco;
	private String divisione;
	private String dataInizio;
	private String dataFine;
	private String paziente;
	private String motivo;
	private String medicoRes;
	private Integer letto;
	private Boolean dayHospital;
	
	
	
	public Ricovero(String cu, String div,String di,String df,String p,String mo,String me,int l,boolean h ){
		this.codiceUnivoco=cu;
		this.divisione=div;
		this.dataInizio=di;
		this.dataFine=df;
		this.paziente=p;
		this.motivo=mo;
		this.medicoRes=me;
		this.letto=l;
		this.dayHospital=h;	
	}
	
	protected static LinkedList<Ricovero> getRicoveri(){
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
	
	
	//mancano le foreign key.
	
	
}
