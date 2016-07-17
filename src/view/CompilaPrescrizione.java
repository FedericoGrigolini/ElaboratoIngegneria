package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.MedicControl;
import model.Farmaco;
import model.Ricovero;
import model.Somministrazione;
import model.Tabella;
import model.Terapia;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CompilaPrescrizione extends JFrame {
	private static Ricovero ric;
	private static Terapia ter;
	private JPanel contentPane;
	private JTextField campoInizio;
	private JTextField campoFine;
	private JTextField campoDosaggio;
	private JTextPane textPane;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JButton btnCompila;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompilaPrescrizione frame = new CompilaPrescrizione();
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
	public CompilaPrescrizione() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 535, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCompilaPrescrizioneTerapia = new JLabel("Compila Prescrizione Terapia");
		lblCompilaPrescrizioneTerapia.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCompilaPrescrizioneTerapia.setBounds(10, 11, 230, 22);
		contentPane.add(lblCompilaPrescrizioneTerapia);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(control.MedicControl.getRicoveriMedico(Login.id)));
		comboBox.setBounds(170, 40, 215, 22);
		contentPane.add(comboBox);
		
		JLabel lblSelezionareRicovero = new JLabel("Selezionare Ricovero");
		lblSelezionareRicovero.setBounds(20, 44, 140, 14);
		contentPane.add(lblSelezionareRicovero);
		
		JButton btnSeleziona = new JButton("Seleziona");
		btnSeleziona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ric=(Ricovero)comboBox.getSelectedItem();
				ter=control.MedicControl.esisteTerapia(ric);
				if(ter==null){
					campoInizio.setEnabled(true);
					campoFine.setEnabled(true);
				}
				campoDosaggio.setEnabled(true);
				textPane.setEditable(true);
				comboBox_1.setEnabled(true);
				btnCompila.setEnabled(true);
			}
		});
		btnSeleziona.setBounds(395, 40, 89, 23);
		contentPane.add(btnSeleziona);
		
		JLabel lblDataInizio = new JLabel("Data Inizio");
		lblDataInizio.setBounds(20, 86, 68, 14);
		contentPane.add(lblDataInizio);
		
		JLabel lblDataFine = new JLabel("Data Fine");
		lblDataFine.setBounds(194, 86, 55, 14);
		contentPane.add(lblDataFine);
		
		campoInizio = new JTextField();
		campoInizio.setEnabled(false);
		campoInizio.setBounds(98, 83, 86, 20);
		contentPane.add(campoInizio);
		campoInizio.setColumns(10);
		
		campoFine = new JTextField();
		campoFine.setEnabled(false);
		campoFine.setBounds(258, 83, 86, 20);
		contentPane.add(campoFine);
		campoFine.setColumns(10);
		
		JLabel lblFarmaco = new JLabel("Farmaco");
		lblFarmaco.setBounds(20, 123, 51, 14);
		contentPane.add(lblFarmaco);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setModel(new DefaultComboBoxModel(MedicControl.listaFarmaci()));
		comboBox_1.setBounds(81, 122, 121, 17);
		contentPane.add(comboBox_1);
		
		JLabel lblDosaggio = new JLabel("Dosaggio:");
		lblDosaggio.setBounds(233, 123, 48, 14);
		contentPane.add(lblDosaggio);
		
		JLabel lblModalitDiSomministrazione = new JLabel("Modalit\u00E0 di Somministrazione");
		lblModalitDiSomministrazione.setBounds(20, 148, 136, 14);
		contentPane.add(lblModalitDiSomministrazione);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(20, 173, 398, 71);
		contentPane.add(textPane);
		
		campoDosaggio = new JTextField();
		campoDosaggio.setEnabled(false);
		campoDosaggio.setBounds(291, 120, 86, 20);
		contentPane.add(campoDosaggio);
		campoDosaggio.setColumns(10);
		
		btnCompila = new JButton("Compila");
		btnCompila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ter == null){
					ter=new Terapia(ric.getCodiceUnivoco(), campoInizio.getText(), campoFine.getText());
					new Tabella().insertTerapia(ter);
				}
				Farmaco f=(Farmaco)comboBox_1.getSelectedItem();
				Somministrazione s=new Somministrazione(ter, f, "" ,textPane.getText() , Integer.parseInt(campoDosaggio.getText()));
				new Tabella().insertSomministrazione(s);
				MenùMedico.occupato=false;
				dispose();
			}
		});
		btnCompila.setEnabled(false);
		btnCompila.setBounds(20, 273, 89, 23);
		contentPane.add(btnCompila);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenùMedico.occupato=false;
				dispose();
			}
		});
		btnEsci.setBounds(130, 273, 89, 23);
		contentPane.add(btnEsci);
	}

	protected JTextPane getTextPane() {
		return textPane;
	}
	protected JComboBox getComboBox_1() {
		return comboBox_1;
	}
	protected JComboBox getComboBox() {
		return comboBox;
	}
	protected JButton getBtnCompila() {
		return btnCompila;
	}
}
