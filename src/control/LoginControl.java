package control;

public class LoginControl {
	public static int autenticazione(String user, String pass){
		switch(user){
		case "S.Accettazione":{
			System.out.println("1");
			
			if(pass.equals("admin")){
				System.out.println("2");
				return 0;
			}
			else return -1;
		}
		case "S.Reparto":{
			if(pass.equals("admin")){
				return 1;
			}
			else return -1;
		}
		case "M.Responsabile":{
			for(model.Ricovero r: new model.Tabella().getListaRicoveri()){
				if(r.getMedicoResponsabile().getCodiceFiscale().equals(pass)){
					return 2;
				}
			}
			return -1;
		}
		case "M.Anestesia":{
			for(model.Medico r: new model.Tabella().getListaMedici()){
				if(r.getCodiceFiscale()==pass ){
					if(r.getSpecialità()=="Anestesia"){
						for(model.Intervento i: new model.Tabella().getListaInterventi()){
							for(model.Operatore o: i.getOperatoriSala()){
								if(r.getCodiceFiscale()==o.getCodiceFiscale()){
									return 4;
								}
							}
						}
					}
				}
			}
			return -1;
		}
		case "O.Sala":{
			for(model.Operatore o: new model.Tabella().getListaOperatori()){
				if(o.getCodiceFiscale().equals(pass)){
					return 3;
				}
			}
			return -1;
		}
		case "Infermiere":{
			for(model.Infermiere i: new model.Tabella().getListaInfermieri()){
				if(i.getCodiceFiscale()==pass){
					return 5;
				}
				else return -1;
			}
		}
		default:{
			return -1;
		}
		}
	}
}
