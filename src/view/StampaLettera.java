package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Tabella;
import model.Medico;
import model.Ricovero;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StampaLettera extends JFrame {

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
					StampaLettera frame = new StampaLettera();
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
	public StampaLettera() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 408, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLetteraDiDimissione = new JLabel("Lettera di Dimissione");
		lblLetteraDiDimissione.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLetteraDiDimissione.setBounds(10, 11, 248, 22);
		contentPane.add(lblLetteraDiDimissione);
		
		JLabel label_1 = new JLabel("Selezionare un ricovero");
		label_1.setBounds(20, 44, 213, 14);
		contentPane.add(label_1);
		
		JButton btnScriviLettera = new JButton("Scrivi Lettera");
		btnScriviLettera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ricovero r=(Ricovero)comboBox.getSelectedItem();
				Medico m = r.getMedicoResponsabile();
				String s="Il paziente: " +r.getPaziente().getCognome()+" "+r.getPaziente().getCognome()+" è dimesso dal reparto di "+r.getDivisione()+
						"\n le auguriamo buona salute\n Dottor " + m.getCognome() +" "+m.getNome();
				textPane.setText(s);
			}
		});
		btnScriviLettera.setBounds(216, 66, 131, 23);
		contentPane.add(btnScriviLettera);
		
		JButton buttonEsc = new JButton("Esci");
		buttonEsc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenùMedico.occupato=false;
				dispose();
			}
		});
		buttonEsc.setBounds(10, 453, 89, 23);
		contentPane.add(buttonEsc);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel<Ricovero>(new Vector<Ricovero>(control.GenericControl.getRicoveriMedico(Login.id))));
		comboBox.setBounds(10, 67, 189, 22);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 337, 342);
		contentPane.add(scrollPane);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
	protected JTextPane getTextPane() {
		return textPane;
	}
}
