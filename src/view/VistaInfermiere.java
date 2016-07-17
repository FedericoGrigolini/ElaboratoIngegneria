package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Somministrazione;
import model.Tabella;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaInfermiere extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInfermiere frame = new VistaInfermiere();
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
	public VistaInfermiere() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 291, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenSomministrazioneTerapia = new JLabel("Men\u00F9 somministrazione Terapia");
		lblMenSomministrazioneTerapia.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMenSomministrazioneTerapia.setBounds(10, 11, 295, 22);
		contentPane.add(lblMenSomministrazioneTerapia);
		
		JLabel lblSelezionareLaTerapia = new JLabel("Selezionare la Terapia da seguire");
		lblSelezionareLaTerapia.setBounds(10, 44, 195, 14);
		contentPane.add(lblSelezionareLaTerapia);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel( new Vector<Somministrazione>(new Tabella().getListaSomministrazioni() )));
		comboBox.setBounds(10, 69, 175, 20);
		contentPane.add(comboBox);
		
		JButton btnSeguire = new JButton("Seguire");
		btnSeguire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tabella tab = new Tabella();
				Somministrazione s=(Somministrazione)comboBox.getSelectedItem();
				tab.deleteSomministrazione(s.getTerapia().getRicovero().getCodiceUnivoco(), s.getFarmaco().getNome(), s.getInfermiereAux());
				s.setInfermiere(Login.id);
				tab.insertSomministrazione(s);
			}
		});
		btnSeguire.setBounds(10, 103, 89, 23);
		contentPane.add(btnSeguire);
		
		JButton btnUscire = new JButton("uscire");
		btnUscire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.occupato=false;
				dispose();
			}
		});
		btnUscire.setBounds(10, 137, 89, 23);
		contentPane.add(btnUscire);
	}

	protected JComboBox getComboBox() {
		return comboBox;
	}
}
