package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class Tabella {
	private static Connection c = null;
    private static Statement stmt = null;
    //Terapia
	public LinkedList<Terapia> getListaTerapie(){
		LinkedList<Terapia> result = new LinkedList<Terapia>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Terapia;" );
		      while ( rs.next() ) {
		         result.add(new Terapia(rs.getString(1)));
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
	public void insertTerapia(Object t) {
		if(t instanceof Terapia){
			Terapia p=(Terapia)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Terapia (Ricovero,Data_I,Data_F) " +
			                   "VALUES ('"+p.getRicovero().getCodiceUnivoco() + "','"+ p.getDataInizio() +"','"+ p.getDataFine()+"');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}
	}	
	public void deleteTerapia(String key) {	
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Terapia WHERE Ricovero='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	//Ricovero
	public void insertRicovero(Object t) {
		if(t instanceof Ricovero){
			Ricovero p=(Ricovero)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Ricovero (CodiceFiscale,Data_I,Data_F,Motivo,Paziente,Divisione,Letto,Medico_Res,dayHospital) " +
			                   "VALUES ('"+p.getCodiceUnivoco() + "','"+p.getDataInizio() + "','" + p.getDataFine() + "','" +p.getMotivo()+
			                   "','"+ p.getPaziente().getCodiceFiscale() + "','"+ p.getDivisione() + "','"+ p.getLetto() + "','"+ p.getMedicoResponsabile().getCodiceFiscale()+
			                   p.getDayHospital() +"');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}
	}
	public void deleteRicovero(String key) {
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Ricovero WHERE Codice='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	public LinkedList<Ricovero> getListaRicoveri(){
	LinkedList<Ricovero> result=new LinkedList<Ricovero>();
	Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
      c.setAutoCommit(false);
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM Ricovero;" );
      while ( rs.next() ) {
         String  codice = rs.getString("Codice");
         String  dataInizio = rs.getString("Data_I");
         String  dataFine = rs.getString("Data_F");
         String  motivo = rs.getString("Motivo");
         String paziente = rs.getString("Paziente");
         String divisione = rs.getString("Divisione");
         int letto = rs.getInt("Letto");
         String medico = rs.getString("Medico_Res");
         Boolean  dayHospital = rs.getBoolean("DayHospital");
         result.add(new Ricovero(codice, divisione, dataInizio, dataFine, paziente, motivo, medico ,letto,dayHospital));
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
	//Operatore
	public LinkedList<Operatore> getListaOperatori(){
		LinkedList<Operatore> result = new LinkedList<Operatore>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Operatore;" );
		      while ( rs.next() ) {
		         String  codice = rs.getString("CodiceFiscale");
		         String  nome = rs.getString("Nome");
		         String  cognome = rs.getString("Cognome");
		         String  dataN = rs.getString("Data_N");
		         String luogoN = rs.getString("Luogo_N");
		         String provincia = rs.getString("Provincia_R");
		         result.add(new Operatore(codice,nome,cognome,dataN,luogoN,provincia));
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
	public void insertOperatore(Object t) {
		if(t instanceof Operatore){
			Operatore p=(Operatore)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Operatore (CodiceFiscale,Nome,Cognome,Data_N,Luogo_N,Data_Ass) " +
			                   "VALUES ('"+p.codiceFiscale + "','"+p.nome + "','" + p.cognome + "','" +p.dataNascita+
			                   "','"+ p.luogoNascita + "','"+ p.dataAssunzione + "');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}
	}
	public void deleteOperatore(String key){
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Operatore WHERE CodiceFiscale='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	//Medico
	public LinkedList<Medico> getListaMedici(){
		LinkedList<Medico> result= new LinkedList<Medico>();
		Tabella tab=new Tabella();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Medico;" );
		      while ( rs.next() ) {
		    	  for(Operatore o : tab.getListaOperatori()){
		  			if(o.codiceFiscale==rs.getString("Operatore")){
		  				Medico m = (Medico)o;
		  				m.Specialità=rs.getString("Specialità");
		  				result.add(m);
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
		return result;
	}	
	public void insertMedico(Object t) {
		if(t instanceof Medico){
			Medico p=(Medico)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Medico (Operatore,Specialità) " +
			                   "VALUES ('"+p.codiceFiscale + "','"+p.Specialità+ "');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}

	}
	public void deleteMedico(String key){
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Medico WHERE Operatore='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	//Infermiere
	public LinkedList<Infermiere> getListaInfermieri(){
		LinkedList<Infermiere> result = new LinkedList<Infermiere>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Infermiere;" );
		      while ( rs.next() ) {
		         String  operatore = rs.getString("Operatore");
		         
		         result.add(new Infermiere(operatore));
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
	public void insertInfermiere(Object t) {
		if(t instanceof Infermiere){
			Infermiere p=(Infermiere)t;
			LinkedList<Operatore> temp = this.getListaOperatori();
			for(Operatore o:temp){
				if(o.getCodiceFiscale()==p.codiceFiscale){
					try {
						Class.forName("org.sqlite.JDBC");
						c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
						c.setAutoCommit(false);
						stmt = c.createStatement();
						String sql = "INSERT INTO Infermiere (Operatore) " +
								"VALUES ('"+p.codiceFiscale + "');"; 
						stmt.executeUpdate(sql);
						stmt.close();
						c.commit();
						c.close();
					} catch ( Exception e ) {
						System.err.println( e.getClass().getName() + ": " + e.getMessage() );
						System.exit(0);
					}
					break;
				}
			}
		}	
	}
	public void deleteInfermiere(String key){
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Infermiere WHERE Operatore='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	//Intervento
	public LinkedList<Intervento> getListaInterventi(){
		LinkedList<Intervento> result = new LinkedList<Intervento>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Intervento;" );
		      while ( rs.next() ) {
		    	  
		    	  String ricovero = rs.getString(1);
		    	  String codice = rs.getString(2);
		    	  String operatore = rs.getString(3);
			      result.add(new Intervento(ricovero, codice, operatore));
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

	public void insertIntervento(Object t) {
		if(t instanceof Intervento){
			Intervento p=(Intervento)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Intervento (Ricovero,Codice_Intervento,Operatore,Data,Orario,Tipo,Livello_Urgenza,Durata,Anestesia) " +
			              "VALUES ('"+p.ricovero.getCodiceUnivoco() + "','"+p.getCodiceIntervento() + "','" + p.operatore.getCodiceFiscale() + "','" 
			    		  + p.getData() + "','" + p.getOrario() + "','" + p.getTipo() +"','" + p.getLivelloUrgenza().toString() +"','" 
			              + p.getDurata().toString() +"','" + p.getAnestesia() +"');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}
	}
	public void deleteIntervento(String ric, String cod ){
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Intervento WHERE Codice_Intervento='"+ cod +"' AND Ricovero='"+ric+"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	//Farmaco
	public LinkedList<Farmaco> getListaFarmaci(){
	LinkedList<Farmaco> result = new LinkedList<Farmaco>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Farmaco;" );
		      while ( rs.next() ) {
		         String  nome = rs.getString(1); 
		         result.add(new Farmaco(nome));
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
	public void insertFarmaco(Object t) {
		if(t instanceof Farmaco){
			Farmaco p=(Farmaco)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Farmaco (Nome_Comm,Azienda,Dose_R) " +
			                   "VALUES ('"+p.getNome() +"','"+ p.getAzienda() +"','"+ p.getDosaggioRaccomandato() +"');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}
		
	}	
	public void deleteFarmaco(String key) {
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Farmaco WHERE Nome_Comm='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	//Esame
	public LinkedList<Esame> getListaEsami(){
		LinkedList<Esame> result = new LinkedList<Esame>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Esame;" );
		      while ( rs.next() ) {
		         String  tipo = rs.getString("Tipo");
		         String  ricovero = rs.getString("Ricovero");
		         result.add(new Esame(tipo, ricovero));
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
	public void insertEsame(Object t) {
		if(t instanceof Esame){
			Esame p=(Esame)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Esame (Tipo,Ricovero,Risultati) " +
			                   "VALUES ('"+p.getTipo() + "','"+p.getRicovero().getCodiceUnivoco() + "','" + p.getRisultati() + "');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}
	}
	public void deleteEsame(String k, String kr){
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Esame WHERE Tipo='"+ k +"' AND Ricovero='"+kr+"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	//Paziente
	
	public LinkedList<Paziente> getListaPazienti(){
		LinkedList<Paziente> result = new LinkedList<Paziente>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Paziente;" );
		      while ( rs.next() ) {
		         String  codice = rs.getString("Codice");
		         String  nome = rs.getString("Nome");
		         String  cognome = rs.getString("Cognome");
		         String  dataN = rs.getString("Data_N");
		         String luogoN = rs.getString("Luogo_N");
		         String provincia = rs.getString("Provincia_R");
		         result.add(new Paziente(codice,nome,cognome,dataN,luogoN,provincia));
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
	public void insertPaziente(Object t) {
		if(t instanceof Paziente){
			Paziente p=(Paziente)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Paziente (Codice,Nome,Cognome,Data_N,Luogo_N,Provincia_N) " +
			                   "VALUES ('"+p.getCodiceFiscale() + "','"+p.getNome() + "','" + p.getCognome() + "','" +p.getDataNascita()+
			                   "','"+ p.getLuogaNascita() + "','"+ p.getProvincia() + "');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}
	}
	public void deletePaziente(String key) {
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Paziente WHERE Codice='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	//ExtraRegionale
	public LinkedList<ExtraRegionale> getListaExtraRegionali(){
		LinkedList<ExtraRegionale> result = new LinkedList<ExtraRegionale>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM FuoriRegione;" );
		      while ( rs.next() ) {
		         String  paziente = rs.getString(1);
		         result.add(new ExtraRegionale(paziente));
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
	public void insertExtraRegionale(Object t) {
		if(t instanceof ExtraRegionale){
			ExtraRegionale p=(ExtraRegionale)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO InRegione (Paziente,Ulss,Regione) " +
			                   "VALUES ('"+p.getCodiceFiscale() +"','"+p.getUlss() +"','"+p.getRegione() +"');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}

	}
	public void deleteExtraRegionale(String key) {
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM InRegione WHERE Paziente='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	//Regionale
	public LinkedList<Regionale> getListaRegionali(){
		LinkedList<Regionale> result = new LinkedList<Regionale>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM InRegione;" );
		      while ( rs.next() ) {
		         String  paziente = rs.getString(1);
		         result.add(new Regionale(paziente));
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
	public void insertRegionale(Object t) {
		if(t instanceof Regionale){
			Regionale p=(Regionale)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO InRegione (Paziente) " +
			                   "VALUES ('"+p.getCodiceFiscale() +"');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}

	}
	public void deleteRegionale(String key) {
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM InRegione WHERE Paziente='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}	
	//Prenotazione postRicovero
	public LinkedList<PrenotazionePostRicovero> getListaPrenotazioniPostRicovero(){
		LinkedList<PrenotazionePostRicovero> result = new LinkedList<PrenotazionePostRicovero>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM PrenotazioniPostRicovero;" );
		      while ( rs.next() ) {
		         String  ricovero = rs.getString(1);

		         result.add(new PrenotazionePostRicovero(ricovero));
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
	public void insertPrenotazionePostRicovero(Object t) {
		if(t instanceof PrenotazionePostRicovero){
			PrenotazionePostRicovero p=(PrenotazionePostRicovero)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO PrenotazionePostRicovero (Ricovero,Data,Orario) " +
			                   "VALUES ('"+p.getRicovero().getCodiceUnivoco() +"','"+p.getData() +"','"+p.getOrario() +"');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}

	}
	public void deletePrenotazionePostRicovero(String key) {
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM PrenotazionePostRicovero WHERE Nome='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	//Somministrazione
	public LinkedList<Somministrazione> getListaSomministrazioni(){
		LinkedList<Somministrazione> result = new LinkedList<Somministrazione>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Somministrazione;" );
		      while ( rs.next() ) {
		         result.add(new Somministrazione(rs.getString(1), rs.getString(2), rs.getString(3)));
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
	public void insertSomministrazione(Object t) {
		if(t instanceof Somministrazione){
			Somministrazione p=(Somministrazione)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO Somministrazione (Terapia,Farmaco,Infermiere,Dosaggio,Modalità) " +
			                   "VALUES ('"+p.getTerapia().getRicovero() +"','"+p.getFarmaco().getNome()+"','"+p.getInfermiere().getCodiceFiscale()+"','"+p.getDosaggio()+"','"+ p.getModalità() +"');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}

	}
	public void deleteSomministrazione(String t,String f, String i) {

			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM Somministrazione WHERE Terapia='"+ t +"' AND Farmaco='"+f+"'AND Infermiere='"+ i+"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	//PrincipioAttivo
	public LinkedList<PrincipioAttivo> getListaPrincipiAttivi(){
		LinkedList<PrincipioAttivo> result = new LinkedList<PrincipioAttivo>();
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM PrincipioAttivo;" );
		      while ( rs.next() ) {
		         String  nome = rs.getString("Nome");

		         result.add(new PrincipioAttivo(nome));
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
	

	public void insertPrincipioAttivo(Object t) {
		if(t instanceof PrincipioAttivo){
			PrincipioAttivo p=(PrincipioAttivo)t;
			try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			      c.setAutoCommit(false);
			      stmt = c.createStatement();
			      String sql = "INSERT INTO PrincipioAttivo (Nome) " +
			                   "VALUES ('"+p.getNome() +  "');"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			    	System.exit(0);
			    }
		}

	}
	public void deletePrincipioAttivo(String key) {
			try {
				Class.forName("org.sqlite.JDBC");
			    c = DriverManager.getConnection("jdbc:sqlite:GestioneOspedale.db");
			    c.setAutoCommit(false);
			    stmt = c.createStatement();
			    String sql = "DELETE FROM PrincipioAttivo WHERE Nome='"+ key +"';";
			    stmt.executeUpdate(sql);
			    c.commit();
			}catch ( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }			
	}
	

}
