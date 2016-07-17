package model;

import model.Operatore;
import java.sql.*;
import java.util.LinkedList;

public class Intervento  {
	protected static Connection c = null;
    protected static Statement stmt = null;
    
    protected String codice;
    protected Ricovero ricovero;
    protected Operatore operatore;//relativo ad una sola entry della tabella
    protected LinkedList<Operatore> listaOperatori; //relativa a tutti gli operatori di un singolo intervento;
    protected String tipo;
    protected Integer urgenza;
    protected String data;
    protected String orario;
    protected Integer durata;
    protected String anestesia;
	
    public Intervento(String c, String r,String op ,String t, Integer u, String da,String or, Integer du, String a){
    	codice=c;
    	ricovero=new Ricovero(r);
    	operatore= new Operatore(op);
    	tipo=t;
    	urgenza=u;
    	data=da;
    	orario=or;
    	durata=du;
    	anestesia=a;
    }
    
    public Intervento(String kr,String kc, String ko ){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Intervento;" );
		      while ( rs.next() ) {
		    	  if(rs.getString("Ricovero").equals(kr) && rs.getString("Codice_Intervento").equals(kc) && rs.getString("Operatore").equals(ko)){
		    		  this.codice=kc;
		    		  this.tipo= rs.getString("Tipo");
				      this.ricovero=new Ricovero(kr);
				      this.operatore=new Operatore(ko);
				      this.data=rs.getString("Data");
				      this.orario=rs.getString("Orario");
				      this.urgenza=rs.getInt("Livello_Urgenza");
				      this.durata=rs.getInt("Durata");
				      this.anestesia=rs.getString("Anestesia");
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
	
    public String getOperatore(){
		return this.codice;
	}
    public String getData(){
    	return data;
    }
    public String getOrario(){
    	return orario;
    }
    public Integer getLivelloUrgenza(){
    	return urgenza;
    }
    public Integer getDurata(){
    	return durata;
    }
    public String getAnestesia(){
    	return anestesia;
    }
	public String getTipo(){
		return this.tipo;
	}
	public Ricovero getRicovero(){
		return this.ricovero;
	}
	public String getCodiceIntervento(){
		return this.codice;
	}
	
	public LinkedList<Operatore> getOperatoriSala(){
		LinkedList<Operatore> result = new LinkedList<Operatore>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT Operatore FROM Intervento WHERE Ricovero='"+ this.getRicovero().getCodiceUnivoco() +"AND Codice_Intervento='"+ this.getCodiceIntervento() +"';" );
		      while ( rs.next() ) {
		    	  String operatore=rs.getString("Operatore");
				  result.add(new Operatore(operatore));
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
	
	public void setCodice(String key){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Intervento "
		      		+ "SET Codice_Intervento='"+ key +"' WHERE Codice_Intervento='"+ this.codice +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.codice=key;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}

	public void setData(String key){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Intervento "
		      		+ "SET Data='"+ key +"' WHERE Codice_Intervento='"+ this.codice +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.data=key;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}

	public void setOrario(String key){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Intervento "
		      		+ "SET Orario='"+ key +"' WHERE Codice_Intervento='"+ this.codice +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.orario=key;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setUrgenza(Integer key){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Intervento "
		      		+ "SET Livello_Urgenza='"+ key +"' WHERE Codice_Intervento='"+ this.codice +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.urgenza=key;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setDurata(Integer key){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Intervento "
		      		+ "SET Durata='"+ key +"' WHERE Codice_Intervento='"+ this.codice +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.durata=key;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setTipo(String key){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Intervento "
		      		+ "SET Tipo='"+ key +"' WHERE Codice_Intervento='"+ this.codice +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.tipo=key;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setRicovero(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Intervento "
		      		+ "SET Ricovero='"+ k +"' WHERE Codice_Intervento='"+ this.codice +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"';" );
		      rs.close();
		      stmt.close();
		      c.close();
		      this.ricovero=new Ricovero(k);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
	public void setOperatore(String k){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "UPDATE Intervento "
			      		+ "SET Operatore='"+ k +"' WHERE Codice_Intervento='"+ this.codice +"' AND Ricovero='"+this.ricovero.getCodiceUnivoco()+"' AND Operatore='"+this.operatore.getCodiceFiscale()+"';" );
			      rs.close();
		      stmt.close();
		      c.close();
		      this.operatore=new Operatore(k);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		
	}
	

	
	public void delete(String ric, String cod,String op ){
		try {
			Class.forName("org.sqlite.JDBC");
		    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		    c.setAutoCommit(false);
		    stmt = c.createStatement();
		    String sql = "DELETE FROM Intervento WHERE Codice_Intervento='"+ cod +"' AND Ricovero='"+"' AND Operatore='"+this.operatore.getCodiceFiscale()+"';";
		    stmt.executeUpdate(sql);
		    c.commit();
		}catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }			
}
	
	
	public String toString(){
		String p = "Codice Intervento: "+this.codice+"  Ricovero: "+this.ricovero.getCodiceUnivoco()+ "  Urgenza: " + this.urgenza +
				"\nData: "+this.data+"  Orario Inizio: "+this.orario+"  Durata: "+this.durata+
				"\nTipo: "+this.tipo+
				"\nDati Anestesia: "+this.anestesia+"\nOperatori in Sala: ";
		for(Operatore o:getOperatoriSala()){
			p = p + o.getNome()+" "+o.getCognome()+" "+o.getCodiceFiscale()+"\n";
		}
		return p;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}