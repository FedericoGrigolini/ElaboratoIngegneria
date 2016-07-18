package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.GenericControl;
import control.Tabella;
import model.Intervento;
import model.Ricovero;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class CompilaIntervento extends JFrame {
	private static Ricovero questo;
	private JPanel contentPane;
	private JTextField campoCodice;
	private JTextField campoData;
	private JTextField campoOrario;
	private JTextField campoDurata;
	private JButton btnCompila;
	private JSpinner spinnerUrgenza;
	private JTextPane campoTipo;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompilaIntervento frame = new CompilaIntervento();
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
	public CompilaIntervento() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 558, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCompilaSchedaIntervento = new JLabel("Compila Scheda Intervento");
		lblCompilaSchedaIntervento.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCompilaSchedaIntervento.setBounds(10, 11, 215, 22);
		contentPane.add(lblCompilaSchedaIntervento);
		
		comboBox = new JComboBox();
		comboBox.setBounds(149, 44, 215, 22);
		comboBox.setModel(new DefaultComboBoxModel(control.GenericControl.getRicoveriMedico(Login.id)));
		contentPane.add(comboBox);
		
		JButton btnScelta = new JButton("Scelta");
		btnScelta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				questo=(Ricovero)comboBox.getSelectedItem();
				campoData.setEnabled(true);
				campoDurata.setEnabled(true);
				campoOrario.setEnabled(true);
				btnCompila.setEnabled(true);
				campoTipo.setEnabled(true);
				spinnerUrgenza.setEnabled(true);

			}
		});
		btnScelta.setBounds(392, 44, 89, 23);
		contentPane.add(btnScelta);
		
		JLabel lblScegliereIlRicovero = new JLabel("Scegliere il ricovero");
		lblScegliereIlRicovero.setBounds(20, 48, 119, 14);
		contentPane.add(lblScegliereIlRicovero);
		
		JLabel lblCodiceIntervento = new JLabel("Codice Intervento");
		lblCodiceIntervento.setBounds(21, 96, 102, 14);
		contentPane.add(lblCodiceIntervento);
		
		campoCodice = new JTextField();
		campoCodice.setText(GenericControl.getCodiceIntervento());
		campoCodice.setEditable(false);
		campoCodice.setBounds(122, 93, 86, 20);
		contentPane.add(campoCodice);
		campoCodice.setColumns(10);
		
		JLabel lblDataIntervento = new JLabel("Data Intervento");
		lblDataIntervento.setBounds(20, 134, 103, 14);
		contentPane.add(lblDataIntervento);
		
		campoData = new JTextField();
		campoData.setEnabled(false);
		campoData.setBounds(122, 131, 86, 20);
		contentPane.add(campoData);
		campoData.setColumns(10);
		
		campoOrario = new JTextField();
		campoOrario.setEnabled(false);
		campoOrario.setBounds(294, 131, 86, 20);
		contentPane.add(campoOrario);
		campoOrario.setColumns(10);
		
		spinnerUrgenza = new JSpinner();
		spinnerUrgenza.setEnabled(false);
		spinnerUrgenza.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinnerUrgenza.setBounds(491, 131, 29, 20);
		contentPane.add(spinnerUrgenza);
		
		JLabel lblOrario = new JLabel("Orario ");
		lblOrario.setBounds(242, 134, 42, 14);
		contentPane.add(lblOrario);
		
		JLabel lblLivelloUrgenza = new JLabel("Livello Urgenza");
		lblLivelloUrgenza.setBounds(392, 134, 89, 14);
		contentPane.add(lblLivelloUrgenza);
		
		JLabel lblTipoIntervento = new JLabel("Tipo Intervento");
		lblTipoIntervento.setBounds(20, 173, 89, 14);
		contentPane.add(lblTipoIntervento);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(20, 198, 502, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		campoTipo = new JTextPane();
		campoTipo.setBounds(0, 0, 502, 57);
		panel.add(campoTipo);
		campoTipo.setEnabled(false);
		
		JLabel lblDurataPrevista = new JLabel("Durata Prevista");
		lblDurataPrevista.setBounds(20, 266, 103, 14);
		contentPane.add(lblDurataPrevista);
		
		campoDurata = new JTextField();
		campoDurata.setEnabled(false);
		campoDurata.setBounds(122, 266, 86, 20);
		contentPane.add(campoDurata);
		campoDurata.setColumns(10);
		
		btnCompila = new JButton("Compila");
		btnCompila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Intervento nuovo=new Intervento(campoCodice.getText(), questo.getCodiceUnivoco(),
						Login.id, campoTipo.getText(), Integer.parseInt(spinnerUrgenza.getValue().toString()) ,
						campoData.getText(), campoOrario.getText(), Integer.parseInt(campoDurata.getText()),"Nessuna");
				new Tabella().insertIntervento(nuovo);
				MenùMedico.occupato=false;
				dispose();
			}
		});
		btnCompila.setEnabled(false);
		btnCompila.setBounds(20, 309, 89, 23);
		contentPane.add(btnCompila);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			MenùMedico.occupato=false;
			dispose();
			}
		});
		btnEsci.setBounds(136, 309, 89, 23);
		contentPane.add(btnEsci);
	}
	protected JButton getBtnCompila() {
		return btnCompila;
	}
	protected JSpinner getSpinnerUrgenza() {
		return spinnerUrgenza;
	}
	protected JTextPane getCampoTipo() {
		return campoTipo;
	}
	protected JComboBox getComboBox() {
		return comboBox;
	}
}
