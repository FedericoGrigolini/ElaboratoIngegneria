package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Tabella;
import model.PrenotazionePostRicovero;
import model.Ricovero;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrenotazionePost extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<Ricovero> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrenotazionePost frame = new PrenotazionePost();
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
	public PrenotazionePost() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 405, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox<Ricovero>();
		comboBox.setModel(new DefaultComboBoxModel(control.SegreterieControl.listaRicoveriComboBox()));
		comboBox.setBounds(20, 44, 204, 20);
		contentPane.add(comboBox);
		
		JLabel lblPrenotazionePostRicovero = new JLabel("Prenotazione Post Ricovero");
		lblPrenotazionePostRicovero.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrenotazionePostRicovero.setBounds(10, 11, 248, 22);
		contentPane.add(lblPrenotazionePostRicovero);
		
		textField = new JTextField();
		textField.setBounds(77, 75, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(77, 106, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(20, 75, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblOra = new JLabel("Ora");
		lblOra.setBounds(20, 109, 46, 14);
		contentPane.add(lblOra);
		
		JButton btnPrenota = new JButton("Prenota");
		btnPrenota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ricovero r = (Ricovero)comboBox.getSelectedItem();
				PrenotazionePostRicovero p=new PrenotazionePostRicovero(r, textField.getText(), textField_1.getText());
				new Tabella().insertPrenotazionePostRicovero(p);
			}
		});
		btnPrenota.setBounds(257, 74, 89, 23);
		contentPane.add(btnPrenota);
		
		JButton btnEsci = new JButton("esci");
		btnEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenùReparto.occupato=false;
				dispose();
			}
		});
		btnEsci.setBounds(257, 105, 89, 23);
		contentPane.add(btnEsci);
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
}
