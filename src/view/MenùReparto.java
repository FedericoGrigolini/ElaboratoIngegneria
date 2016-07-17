package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class MenùReparto extends JFrame {
	public static boolean occupato=false;
	public static String reparto;
	private JPanel contentPane;
	private JButton btnAssegnamentoLetti;
	private JButton btnPrenotazionePostRicovero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenùReparto frame = new MenùReparto();
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
	public MenùReparto() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 341, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSegreteriaReparto = new JLabel("Segreteria Reparto");
		lblSegreteriaReparto.setBounds(48, 10, 219, 27);
		lblSegreteriaReparto.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegreteriaReparto.setFont(new Font("Times New Roman", Font.BOLD, 22));
		contentPane.add(lblSegreteriaReparto);
		
		btnPrenotazionePostRicovero = new JButton("Prenotazione Post Ricovero");
		btnPrenotazionePostRicovero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!MenùReparto.occupato){
					MenùReparto.occupato=true;
					PrenotazionePost.main(null);
				}
			}
		});
		btnPrenotazionePostRicovero.setBounds(72, 94, 165, 23);
		contentPane.add(btnPrenotazionePostRicovero);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login.occupato=false;
				dispose();
			}
		});
		btnLogout.setBounds(72, 128, 165, 23);
		contentPane.add(btnLogout);
		
		btnAssegnamentoLetti = new JButton("Assegnamento Letti");
		btnAssegnamentoLetti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!MenùReparto.occupato){
					MenùReparto.occupato=true;
					GestioneLetti.main(null);
				}
			}
		});
		btnAssegnamentoLetti.setBounds(72, 60, 165, 23);
		contentPane.add(btnAssegnamentoLetti);
	}

	protected JButton getBtnAssegnamentoLetti() {
		return btnAssegnamentoLetti;
	}
	protected JButton getBtnPrenotazionePostRicovero() {
		return btnPrenotazionePostRicovero;
	}
}
