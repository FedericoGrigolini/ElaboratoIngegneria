package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Ricovero;
import model.Tabella;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestioneLetti extends JFrame {

	private JPanel contentPane;
	private JTextField textLetto;
	private JTextField textReparto;
	private JComboBox<Ricovero> comboBox;
	private JButton btnCambia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneLetti frame = new GestioneLetti();
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
	public GestioneLetti() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox<Ricovero>();
		comboBox.setModel(new DefaultComboBoxModel(control.SegreterieControl.listaRicoveriComboBox()));
		comboBox.setBounds(78, 38, 179, 20);
		contentPane.add(comboBox);
		
		JLabel lblRicovero = new JLabel("Ricovero");
		lblRicovero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRicovero.setBounds(14, 38, 54, 17);
		contentPane.add(lblRicovero);
		
		JLabel lblNewLabel = new JLabel("Assegnamento Letti");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(14, 11, 178, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnSeleziona = new JButton("Seleziona");
		btnSeleziona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ricovero reparto=(Ricovero)comboBox.getSelectedItem();
				textReparto.setText(reparto.getDivisione());
				textLetto.setText(reparto.getLetto().toString());
				btnCambia.setEnabled(true);
			}
		});
		btnSeleziona.setBounds(267, 37, 89, 23);
		contentPane.add(btnSeleziona);
		
		JLabel lblLetto = new JLabel("Numero Letto");
		lblLetto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLetto.setBounds(14, 111, 91, 15);
		contentPane.add(lblLetto);
		
		textLetto = new JTextField();
		textLetto.setBounds(115, 109, 86, 20);
		contentPane.add(textLetto);
		textLetto.setColumns(10);
		
		btnCambia = new JButton("Cambia Letto");
		btnCambia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ricovero reparto=(Ricovero)comboBox.getSelectedItem();
				reparto.setLetto(Integer.parseInt(textLetto.getText()));
				new Tabella().deleteRicovero(reparto.getCodiceUnivoco());
				new Tabella().insertRicovero(reparto);
			}
		});
		btnCambia.setEnabled(false);
		btnCambia.setBounds(267, 88, 89, 23);
		contentPane.add(btnCambia);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menùReparto.occupato=false;
				dispose();
			}
		});
		btnEsci.setBounds(267, 136, 89, 23);
		contentPane.add(btnEsci);
		
		JLabel lblReparto = new JLabel("Reparto");
		lblReparto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblReparto.setBounds(10, 69, 91, 15);
		contentPane.add(lblReparto);
		
		textReparto = new JTextField();
		textReparto.setEditable(false);
		textReparto.setColumns(10);
		textReparto.setBounds(115, 69, 86, 20);
		contentPane.add(textReparto);
	}
	protected JComboBox getComboBox() {
		return comboBox;
	}
	protected JButton getBtnCambia() {
		return btnCambia;
	}
}
