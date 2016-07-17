package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.GenericControl;
import model.Ricovero;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class RichiestaRimborsi extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RichiestaRimborsi frame = new RichiestaRimborsi();
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
	public RichiestaRimborsi() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Prenotazione Post Ricovero");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(10, 11, 248, 22);
		contentPane.add(label);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel( new Vector<Ricovero>(GenericControl.getRicoveriExtraRegione())));
		comboBox.setBounds(20, 67, 183, 20);
		contentPane.add(comboBox);
		
		JLabel lblSelezionareUnRicovero = new JLabel("Selezionare un ricovero");
		lblSelezionareUnRicovero.setBounds(20, 44, 112, 14);
		contentPane.add(lblSelezionareUnRicovero);
		
		JButton btnInviaRichiesta = new JButton("Invia Richiesta");
		btnInviaRichiesta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("Richiesta Inviata per il Ricovero Selezionato ");
			}
		});
		btnInviaRichiesta.setBounds(220, 66, 131, 23);
		contentPane.add(btnInviaRichiesta);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenùAccettazione.occupato=false;
				dispose();
			}
		});
		btnEsci.setBounds(262, 100, 89, 23);
		contentPane.add(btnEsci);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 98, 236, 103);
		contentPane.add(textPane);
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
	public JTextPane getTextPane() {
		return textPane;
	}
}
