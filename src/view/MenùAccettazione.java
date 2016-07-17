package view;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MenùAccettazione extends JFrame {
	public static boolean occupato=false;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenùAccettazione frame = new MenùAccettazione();
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
	public MenùAccettazione() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 282, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Segreteria Accettazione");
		label.setBounds(15, 16, 236, 48);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		JLabel label_1 = new JLabel("Scegliere un opzione");
		label_1.setBounds(25, 70, 116, 17);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JButton button = new JButton("Nuova Cartella Clinica");
		button.setBounds(53, 98, 141, 23);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!MenùAccettazione.occupato){
					occupato=true;
					NuovaCartella.main(null);	
				}
			}
		});
		
		JButton button_1 = new JButton("Stampa Cartella Clinica");
		button_1.setBounds(53, 127, 141, 23);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!MenùAccettazione.occupato){
					MenùAccettazione.occupato=true;
					StampaCartella.main(null);
				}	
			}
		});
		
		JButton button_2 = new JButton("Logout");
		button_2.setBounds(53, 185, 141, 23);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.occupato=false;
				dispose();
			}
		});
		
		JButton btnRimborsi = new JButton("Richiesta Rimborsi");
		btnRimborsi.setBounds(53, 156, 141, 23);
		btnRimborsi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!MenùAccettazione.occupato){
					MenùAccettazione.occupato=true;
					RichiestaRimborsi.main(null);
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(button);
		contentPane.add(button_1);
		contentPane.add(btnRimborsi);
		contentPane.add(button_2);
	}
}
