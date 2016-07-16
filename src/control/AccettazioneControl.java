package control;

import java.util.LinkedList;

import model.*;

public class AccettazioneControl {
	public static String[] listaPazientiComboBox(){
		LinkedList<Paziente> temp = new Tabella().getListaPazienti();
		String[] res = new String[temp.size()];

		for(int i=0;i<temp.size(); i++){
			Paziente p=temp.get(i);
			String t= p.getCodiceFiscale()/*+" "+p.getNome()+" "+p.getCognome()*/;
			res[i]=t;
		}
		return res;
	}
	
	public static String[] listaMediciComboBox(){
		LinkedList<Medico> temp = new Tabella().getListaMedici();
		String[] res = new String[temp.size()];
		for(int i=0;i<temp.size(); i++){
			Medico p=temp.get(i);
			String t= p.getCodiceFiscale()/*+" "+p.getNome()+" "+p.getCognome()*/;
			res[i]=t;
		}
		return res;
	}
	
	public static boolean pazientePresente(String s){
		for(Paziente p:new Tabella().getListaPazienti()){
			System.out.println(s +" "+p.getCodiceFiscale());
			if(p.getCodiceFiscale().equals(s) ){
				System.out.println("UGUALI");
				return true;
			}	
		}
		System.out.println("Diversi");
		return false;
	}
}
