package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import model.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Ricovero;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class StampaCartella extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JComboBox comboBox;
	private JButton btnEsci;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StampaCartella frame = new StampaCartella();
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
	public StampaCartella() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 503, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblStampaCartellaClinica = new JLabel("Stampa cartella Clinica");
		lblStampaCartellaClinica.setBounds(15, 16, 211, 22);
		lblStampaCartellaClinica.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		comboBox = new JComboBox<Ricovero>();
		comboBox.setBounds(15, 45, 217, 21);
		comboBox.setModel(new DefaultComboBoxModel(control.AccettazioneControl.listaRicoveriComboBox()) {
		});
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 94, 450, 453);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		contentPane.add(lblStampaCartellaClinica);
		contentPane.add(comboBox);
		
		panel = new JPanel();
		panel.setBounds(259, 44, 97, 23);
		contentPane.add(panel);
		
		JButton btnStampa = new JButton("Stampa");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(btnStampa, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnStampa)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		btnStampa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ricovero r=(Ricovero) comboBox.getSelectedItem();
				textArea.setText(control.AccettazioneControl.CartellaClinica(r));
			}
		});
		
		panel_1 = new JPanel();
		panel_1.setBounds(15, 557, 78, 23);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnEsci = new JButton("Esci");
		btnEsci.setBounds(0, 0, 78, 23);
		panel_1.add(btnEsci);
		btnEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenùAccettazione.occupato=false;
				dispose();
			}
		});
	}
	protected JTextArea getTextArea() {
		return textArea;
	}
	protected JComboBox getComboBox() {
		return comboBox;
	}
}
