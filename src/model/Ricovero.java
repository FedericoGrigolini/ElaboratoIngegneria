package model;

import java.util.LinkedList;
import java.util.List;

public class Ricovero {
	private String codiceUnivoco;
	private String divisione;
	private String dataInizio;
	private String dataFine;
	private String motivo;
	private int letto;
	private List Esami;
	
	Ricovero(String cu, String div,String di,String df,String m,int l){
		this.codiceUnivoco=cu;
		this.divisione=div;
		this.dataInizio=di;
		this.dataFine=df;
		this.motivo=m;
		this.letto=l;
	}
	
	//mancano le foreign key.
	
	
}
