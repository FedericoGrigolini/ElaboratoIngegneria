package control;

import java.util.Vector;

import model.Ricovero;

public class RepartoControl {
	public static Vector<Ricovero> listaRicoveriReparto(String r){
		Vector<Ricovero> res=control.AccettazioneControl.listaRicoveriComboBox();
		for(Ricovero i:res){
			if(!i.getDivisione().equals(r))
				res.remove(i);
		}
		return res;
	}
}
