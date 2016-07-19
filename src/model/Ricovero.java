package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Ricovero {
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
	
	public Ricovero(String cu, String div,String di,String df,String p,String mo,String me,Integer l,boolean h ){
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
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Ricovero;" );
		      while ( rs.next() ) {
		    	  
		    	  if(rs.getString("Codice").equals(key)){
		    		  
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
	
	public void setCodiceUnivoco(String k){
		      this.codiceUnivoco=k;	
	}
	
	public void setDivisione(String k){		
		      this.divisione=k;
	}
	
	public void setDataInizio(String k){
		      this.dataInizio=k;
	}
	
	public void setDataFine(String k){
		      this.dataFine=k;
		}
	
	public void setPaziente(String k){
		      this.paziente.setCodice(k);
		}
	
	public void setMotivo(String k){
		      this.motivo=k;
		      }
	
	public void setMedicoResponsabile(String k){
		      this.medicoRes.setCodice(k);
	}
	
	public void setLetto(Integer k){
		      this.letto=k.intValue();
	}
	
	public void setDayHospital(boolean k){
		      this.dayHospital=k;
	}
	
	public String toString(){
		return " "+this.codiceUnivoco+" "+paziente.getNome()+" "+paziente.getCognome(); 
	}
	
	public String stampa(){
		return "Codice Univoco: "+this.codiceUnivoco+"  Divisione: "+this.divisione+
				"\nData Inizio: "+this.dataInizio+"   Data Fine: "+this.dataFine+
				"\nPaziente: "+this.paziente+
				"\nMotivo: "+this.motivo+
				"\nMedico Responsabile: "+this.medicoRes+
				"\nLetto: "+letto+"   Day Hospital: "+this.dayHospital+"\n";
	}
		
	public static void main( String args[] ){

	}
	
	


	
	
	//mancano le foreign key.
	
	
}
