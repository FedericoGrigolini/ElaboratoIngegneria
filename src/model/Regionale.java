package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Regionale extends Paziente {

	public Regionale(String key) {
		super(key);
		// TODO Auto-generated constructor stub
	}
	
	public void setPaziente(String k){
		      this.codiceFiscale=k;
	}

}
