package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Vector;

import model.*;

public class SegreterieControl {
	
	private static String ricoveroCartella(Ricovero r){
		String res="Reparto: "+r.getDivisione()+" Letto: "+ r.getLetto()+" Day Hospital: "+r.getDayHospital()+
				"\nData Inizio: "+r.getDataInizio()+"  Data Dismissione: "+r.getDataFine()+
				"\nMotivo: "+r.getMotivo()+"\n";
		return res;
	}
	
	public static String CartellaClinica(Ricovero r){
		Paziente p=r.getPaziente();
		
		String result="Cartella Clinica Ricovero: "+r.getCodiceUnivoco()+" Paziente: "+p.getCodiceFiscale()+""
				+ "\nDati Paziente:"
				+ "\n"+p.toString()
				+ "\n\nDati Ricovero:"
				+ "\n"+ricoveroCartella(r)
				+ "\nDati Esami svolti:\n";
		System.out.println("pippo");
		LinkedList<Esame> listaEsami=new Tabella().getListaEsami();;
		for(Esame e:listaEsami){
			if(e.getRicovero().getCodiceUnivoco().equals(r.getCodiceUnivoco())){
				result+="____________________\nTipo: "+e.getTipo()+"\nRisultati:"+e.getRisultati()+"\n";
			}
		}
		result+="\n___________________\n\nDati Interventi:\n";
		for(Intervento i:new Tabella().getListaInterventi()){
			if(i.getRicovero().getCodiceUnivoco().equals(r.getCodiceUnivoco())){
				result+="Codice Intervento: "+i.getCodiceIntervento()+" Urgenza: "+i.getLivelloUrgenza()+
						"\nData: "+i.getData()+"  Orario: "+i.getOrario()+"  Durata(min): "+i.getDurata()+
						"\nTipo: "+i.getTipo()+
						"\nAnestesia: "+i.getAnestesia()+
						"\n___________________\n";
			}
		}
		result+="\nDati Terapia Svolta:\n";
		for(Terapia t: new Tabella().getListaTerapie()){
			if(t.getRicovero().getCodiceUnivoco().equals(r.getCodiceUnivoco())){
				result+="Data Inizio Terapia: " +t.getDataInizio()+"   Data Fine Terapia"+t.getDataFine()+"\n";
				break;
			}
		}
		for(Somministrazione s: new Tabella().getListaSomministrazioni()){
			if(s.getTerapia().getRicovero().getCodiceUnivoco().equals(r.getCodiceUnivoco())){
				result+="Farmaco: "+s.getFarmaco().getNome()+"Modalità: "+s.getModalità()+" Dosaggio"+s.getDosaggio()+"\n\n";
			}
		}
		return result;
	}
	
	
	
	public static Vector<Ricovero> listaRicoveriComboBox(){
		LinkedList<Ricovero> temp = new Tabella().getListaRicoveri();
		Vector<Ricovero> res = new Vector<Ricovero>(temp);
		return res;
		
	}
	
	public static Vector<Paziente> listaPazientiComboBox(){
		LinkedList<Paziente> temp = new Tabella().getListaPazienti();
		Vector<Paziente> res = new Vector<Paziente>(temp);
		return res;
		
	}
	
	public static Vector<Medico> listaMediciComboBox(){
		LinkedList<Medico> temp = new Tabella().getListaMedici();
		Vector<Medico> res = new Vector<Medico>();
		for(Medico m:temp){
			res.addElement(m);
		}
		return res;
	}
	
	
	public static boolean pazientePresente(String s){
		for(Paziente p:new Tabella().getListaPazienti()){
			if(p.getCodiceFiscale().equals(s) ){
				return true;
			}	
		}
		System.out.println("Diversi");
		return false;
	}
	
}
