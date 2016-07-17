package control;

public class prova {
	public static void main( String args[] ){
		for(model.Paziente p: new Tabella().getListaPazienti()){
			System.out.println(p.getCodiceFiscale());
		}
		
		System.out.println();
		
		System.out.println();
		for(model.Medico m: new control.Tabella().getListaMedici()){
			System.out.println(m.getNome()+" "+m.getCognome());
		}
		
	}
}
