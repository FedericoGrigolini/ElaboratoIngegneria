package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenùMedico extends JFrame {
	public static boolean occupato;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenùMedico frame = new MenùMedico();
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
	public MenùMedico() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 310, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Men\u00F9 Medico Responsabile");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(37, 11, 215, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnCompilaSchedaIntervento = new JButton("Compila Scheda Intervento");
		btnCompilaSchedaIntervento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!MenùMedico.occupato){
					MenùMedico.occupato=true;
					CompilaIntervento.main(null);
				}
			}
		});
		btnCompilaSchedaIntervento.setBounds(37, 44, 215, 23);
		contentPane.add(btnCompilaSchedaIntervento);
		
		JButton btnCompilaPrescrizioneTerapia = new JButton("Compila Prescrizione Terapia");
		btnCompilaPrescrizioneTerapia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!MenùMedico.occupato){
					MenùMedico.occupato=true;
					CompilaPrescrizione.main(null);
				}
			}
		});
		btnCompilaPrescrizioneTerapia.setBounds(37, 78, 215, 23);
		contentPane.add(btnCompilaPrescrizioneTerapia);
		
		JButton btnCompilaLetteraDi = new JButton("Compila Lettera di Dimissione");
		btnCompilaLetteraDi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!MenùMedico.occupato){
					MenùMedico.occupato=true;
					StampaLettera.main(null);
				}
			}
		});
		btnCompilaLetteraDi.setBounds(37, 112, 215, 23);
		contentPane.add(btnCompilaLetteraDi);
		
		JButton btnEsci = new JButton("Logout");
		btnEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.occupato=false;
				dispose();
			}
		});
		btnEsci.setBounds(37, 146, 215, 23);
		contentPane.add(btnEsci);
	}

}
