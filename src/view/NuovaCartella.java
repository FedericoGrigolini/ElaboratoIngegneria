package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ExtraRegionale;
import model.Paziente;
import model.Ricovero;
import model.Tabella;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class NuovaCartella extends JFrame {
	private Paziente paziente;
	private Ricovero ricovero;
	public static String Ulss;
	public static String Regione;
	private boolean esiste;
	
	private JPanel contentPane;
	private JTextField campoCodice;
	private JTextField campoNome;
	private JTextField campocCognome;
	private JTextField campoDataN;
	private JTextField campoLuogo;
	private JTextField campoProvincia;
	private JTextField campoRicovero;
	private JTextField campoDataI;
	private JTextField campoDataF;
	private JTextField campoMotivo;
	private JTextField campoDivisione;
	private JButton btnVerificaReg;
	private JButton btnCreaCartellaClinica;
	private JButton buttonCartellaExtra;
	private JRadioButton rdbtnDayHospital ;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuovaCartella frame = new NuovaCartella();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NuovaCartella() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 512, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNuovaCartellaClinica = new JLabel("Nuova cartella Clinica");
		lblNuovaCartellaClinica.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblCodiceSanitario = new JLabel("Codice Sanitario");
		
		campoCodice = new JTextField();
		campoCodice.setColumns(10);

		JButton btnVerifica = new JButton("Verifica");
		btnVerifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(control.AccettazioneControl.pazientePresente(campoCodice.getText())){
					System.out.println("Esiste");
					String s=campoCodice.getText();
					paziente = new model.Paziente(s);
					esiste=true;
					campoNome.setText(paziente.getNome());
					campocCognome.setText(paziente.getCognome());
					campoDataN.setText(paziente.getDataNascita());
					campoLuogo.setText(paziente.getLuogaNascita());
					campoProvincia.setText(paziente.getProvincia());
					btnVerificaReg.setEnabled(true);
				}else{
					esiste=false;
					System.out.println("Non Esiste");
					campoNome.setEnabled(true);
					campocCognome.setEnabled(true);
					campoDataN.setEnabled(true);
					campoLuogo.setEnabled(true);
					campoProvincia.setEnabled(true);
					btnVerificaReg.setEnabled(true);
				}
			}
		});
		
		JLabel lblNome = new JLabel("Nome");
		
		JLabel lblCognome = new JLabel("Cognome");
		
		JLabel lblDataNascita = new JLabel("Data Nascita");
		
		JLabel lblLuogoNascita = new JLabel("Luogo Nascita");
		
		JLabel lblProvincia = new JLabel("Provincia");
		
		campoNome = new JTextField();
		campoNome.setEnabled(false);
		campoNome.setColumns(10);
		
		campocCognome = new JTextField();
		campocCognome.setEnabled(false);
		campocCognome.setColumns(10);
		
		campoDataN = new JTextField();
		campoDataN.setEnabled(false);
		campoDataN.setColumns(10);
		
		campoLuogo = new JTextField();
		campoLuogo.setEnabled(false);
		campoLuogo.setColumns(10);
		
		campoProvincia = new JTextField();
		campoProvincia.setEnabled(false);
		campoProvincia.setColumns(10);
		
		 btnVerificaReg = new JButton("Verifica");
		 btnVerificaReg.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		if(campoProvincia.getText().equals("Verona")||campoProvincia.getText().equals("Venezia")||campoProvincia.getText().equals("Padova")
		 				||campoProvincia.getText().equals("Vicenza")||campoProvincia.getText().equals("Treviso")||campoProvincia.getText().equals("Belluno")
		 				||campoProvincia.getText().equals("Rovigo")){
		 			btnCreaCartellaClinica.setEnabled(true);
		 			buttonCartellaExtra.setEnabled(false);
		 		}else{
		 			cartellaExtraRegione.main(null);
		 			btnCreaCartellaClinica.setEnabled(false);
		 			buttonCartellaExtra.setEnabled(true);
		 		}
		 	}
		 });
		btnVerificaReg.setEnabled(false);
		
		JLabel lblCodicePerIl = new JLabel("Codice per il ricovero");
		
		campoRicovero = new JTextField();
		campoRicovero.setText("R"+String.format("%04d", new model.Tabella().getListaRicoveri().size()+1));
		campoRicovero.setColumns(10);
		campoRicovero.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Data Inizio");
		
		campoDataI = new JTextField();
		campoDataI.setColumns(10);
		
		JLabel lblDataFine = new JLabel("Data Fine");
		
		campoDataF = new JTextField();
		campoDataF.setColumns(10);
		
		JLabel lblMedicoDiRiferimeto = new JLabel("Medico di Riferimeto");
		

		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(40);
		comboBox.setModel(new DefaultComboBoxModel(control.AccettazioneControl.listaMediciComboBox()));
		
		JLabel lblNewLabel_1 = new JLabel("Motivo");
		
		campoMotivo = new JTextField();
		campoMotivo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Divisione");
		
		campoDivisione = new JTextField();
		campoDivisione.setColumns(10);
		
		rdbtnDayHospital = new JRadioButton("Day Hospital");
		
		btnCreaCartellaClinica = new JButton("Crea cartella Clinica");
		btnCreaCartellaClinica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tabella temp=new Tabella();
				if(!esiste){
					paziente=new Paziente(campoCodice.getText(), campoNome.getText(), campocCognome.getText(), campoDataN.getText(), campoLuogo.getText(), campoProvincia.getText());
					temp.insertPaziente(paziente);
					temp.insertRegionale((model.Regionale)paziente);
				}
				ricovero=new Ricovero(campoRicovero.getText(), campoDivisione.getText(), campoDataI.getText(), campoDataF.getText(), paziente.getCodiceFiscale(), campoMotivo.getText(), comboBox.getSelectedItem().toString(), null, rdbtnDayHospital.isSelected() ); 
				temp.insertRicovero(ricovero);
				MenùAccettazione.occupato=false;
				dispose();
			}
		});
		btnCreaCartellaClinica.setEnabled(false);
		
		buttonCartellaExtra = new JButton("Crea Cartella Extra Regione");
		buttonCartellaExtra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tabella temp=new Tabella();
				if(!esiste){
					paziente=new Paziente(campoCodice.getText(), campoNome.getText(), campocCognome.getText(), campoDataN.getText(), campoLuogo.getText(), campoProvincia.getText());
					temp.insertPaziente(paziente);
					ExtraRegionale ex=new ExtraRegionale(paziente.getCodiceFiscale(), paziente.getNome(), paziente.getCognome(), paziente.getDataNascita(), paziente.getDataNascita(), paziente.getProvincia(), Ulss, Regione);
					temp.insertExtraRegionale(ex);
				}
				ricovero=new Ricovero(campoRicovero.getText(), campoDivisione.getText(), campoDataI.getText(), campoDataF.getText(), paziente.getCodiceFiscale(), campoMotivo.getText(), comboBox.getSelectedItem().toString(), null, rdbtnDayHospital.isSelected() ); 
				temp.insertRicovero(ricovero);
				MenùAccettazione.occupato=false;
				dispose();
			}
		});
		buttonCartellaExtra.setEnabled(false);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenùAccettazione.occupato=false;
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNuovaCartellaClinica)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblCodiceSanitario)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(campoCodice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNome)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblDataNascita)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(campoDataN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(6)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblLuogoNascita)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(campoLuogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblCognome)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(campocCognome))
										.addComponent(btnVerifica)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblProvincia)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(campoProvincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnVerificaReg))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCodicePerIl)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(campoRicovero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(campoDataI, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblDataFine)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(campoDataF, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(rdbtnDayHospital))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(campoMotivo, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(campoDivisione, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblMedicoDiRiferimeto)
									.addGap(18)
									.addComponent(comboBox, 0, 311, Short.MAX_VALUE)))
							.addGap(51))
						.addComponent(btnCreaCartellaClinica)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(buttonCartellaExtra)
							.addContainerGap(309, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnEsci)
							.addContainerGap(387, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNuovaCartellaClinica)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodiceSanitario)
						.addComponent(campoCodice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVerifica))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(lblCognome)
						.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(campocCognome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataNascita)
						.addComponent(lblLuogoNascita)
						.addComponent(campoDataN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(campoLuogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProvincia)
						.addComponent(campoProvincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVerificaReg))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodicePerIl)
						.addComponent(campoRicovero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(campoDataI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataFine)
						.addComponent(campoDataF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnDayHospital))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMedicoDiRiferimeto)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(campoMotivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(campoDivisione, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnCreaCartellaClinica)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonCartellaExtra)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEsci)
					.addContainerGap(136, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	public JButton getBtnVerificaReg() {
		return btnVerificaReg;
	}
	public JButton getBtnCreaCartellaClinica() {
		return btnCreaCartellaClinica;
	}
	public JButton getButtonCartellaExtra() {
		return buttonCartellaExtra;
	}
	public void update(){
		setVisible(false);
		setVisible(true);
	}
	
}
