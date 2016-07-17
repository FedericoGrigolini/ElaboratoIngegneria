package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.MedicControl;
import model.Intervento;
import model.Tabella;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaOperatore extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaOperatore frame = new VistaOperatore();
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
	public VistaOperatore() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 291, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenOperatore = new JLabel("Men\u00F9 Operatore di Sala");
		lblMenOperatore.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMenOperatore.setBounds(22, 11, 213, 22);
		contentPane.add(lblMenOperatore);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel( new Vector<String>(MedicControl.getVeraListaInterventi() )));
		comboBox.setBounds(22, 67, 213, 22);
		contentPane.add(comboBox);
		
		JLabel lblSelezionareInterventoIn = new JLabel("Selezionare Intervento in cui partecipare");
		lblSelezionareInterventoIn.setBounds(20, 42, 215, 14);
		contentPane.add(lblSelezionareInterventoIn);
		
		JButton btnAggiungiti = new JButton("Aggiungiti");
		btnAggiungiti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Intervento temp;
				for(Intervento i: new Tabella().getListaInterventi() ){
					String s = (String) comboBox.getSelectedItem();
					if(i.getCodiceIntervento().equals(s)){
						temp=i;
						temp.setOperatore(Login.id);
						new Tabella().insertIntervento(temp);
						break;
					}	
				}
				Login.occupato=false;
				dispose();
			}
		});
		btnAggiungiti.setBounds(20, 100, 116, 23);
		contentPane.add(btnAggiungiti);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.occupato=false;
				dispose();
			}
		});
		btnEsci.setBounds(146, 100, 89, 23);
		contentPane.add(btnEsci);
	}

	protected JComboBox getComboBox() {
		return comboBox;
	}
}
