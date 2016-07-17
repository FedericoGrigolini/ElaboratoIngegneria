package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Vector;

import model.ExtraRegionale;
import model.Farmaco;
import model.Intervento;
import model.Ricovero;
import model.Somministrazione;
import model.Terapia;

public class GenericControl {
	private static Connection c = null;
    private static Statement stmt = null;
    
    
    public static Vector<Ricovero> getRicoveriExtraRegione(){
    	Tabella tab= new Tabella();
    	Vector<Ricovero> res=new Vector<Ricovero>();
    	for(ExtraRegionale e: tab.getListaExtraRegionali()){
    		for(Ricovero r: tab.getListaRicoveri()){
    			if(e.getCodiceFiscale().equals(r.getPaziente().getCodiceFiscale())){
    				res.addElement(r);
    			}
    		}
    	}
    	return res;
    }
	
    public static LinkedList<String> getVeraListaInterventi(){
    	LinkedList<String> res= new LinkedList<String>();
    	try {
			c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		    c.setAutoCommit(false);
		    stmt = c.createStatement();
		    ResultSet rs = stmt.executeQuery( "SELECT Ricovero, Codice_Intervento FROM Intervento INNER JOIN Ricovero ON Intervento.Ricovero=Ricovero.Codice;" );
		    while ( rs.next() ) {
		    	boolean temp =true;
		    	if(res.isEmpty()){
		    		res.add(rs.getString("Codice_Intervento"));
		    	}else{
		    		for(String s:res){
		    			if(s.equals(rs.getString("Codice_Intervento"))){
		    				temp=false;
		    			}
		    		}
		    		if(temp){
		    			res.add(rs.getString("Codice_Intervento"));
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
    	return res;
    }
    
    public static String getCodiceIntervento(){
		int cod=1;
		try {
			c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		    c.setAutoCommit(false);
		    stmt = c.createStatement();
		    ResultSet rs = stmt.executeQuery( "SELECT Ricovero, Codice_Intervento FROM Intervento INNER JOIN Ricovero ON Intervento.Ricovero=Ricovero.Codice;" );
		    while ( rs.next() ) {
		       cod++;
		    }
		    rs.close();
		    stmt.close();
		    c.close();
		} catch ( Exception e ) {
		   	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   	return null;
		}
		String res="I"+String.format("%04d", cod);
		return res;
	}
	
	public static Vector<Ricovero> getRicoveriMedico(String key){
		Vector<Ricovero> res = new Vector<Ricovero>() ;
		for(Ricovero r:new Tabella().getListaRicoveri()){
			if(r.getMedicoResponsabile().getCodiceFiscale().equals(key)){
				res.add(r);
			}
		}
		return res;
	}
	
	public static Vector<Farmaco> listaFarmaci(){
		return new Vector<Farmaco>(new Tabella().getListaFarmaci());
	}
	
	public static Terapia esisteTerapia(Ricovero r){
		for(Terapia t:new Tabella().getListaTerapie()){
			if(t.getRicovero().getCodiceUnivoco().equals(r.getCodiceUnivoco())){
				return t;
			}	
		}
		return null;
	}
	
	public static Vector<String> getListaSomministrazioniVera(){
		Vector<String> res= new Vector<String>();
    	for(Somministrazione s:new Tabella().getListaSomministrazioni()){
    		res.addElement(s.getTerapia().getRicovero().getCodiceUnivoco()+" "+s.getFarmaco().getNome());
    	}
    	return res;
	}
	
}
