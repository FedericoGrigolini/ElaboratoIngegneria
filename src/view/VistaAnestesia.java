package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.GenericControl;
import control.Tabella;
import model.*;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaAnestesia extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JTextPane textPane;
	private JButton btnAggiorna;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAnestesia frame = new VistaAnestesia();
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
	public VistaAnestesia() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 367, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenAnestesista = new JLabel("Men\u00F9 Anestesista");
		lblMenAnestesista.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMenAnestesista.setBounds(10, 11, 213, 22);
		contentPane.add(lblMenAnestesista);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel( new Vector<String>(GenericControl.getVeraListaInterventi() )));
		comboBox.setBounds(10, 62, 213, 22);
		contentPane.add(comboBox);
		
		JLabel lblSelezionareIntervento = new JLabel("Selezionare Intervento");
		lblSelezionareIntervento.setBounds(10, 37, 129, 14);
		contentPane.add(lblSelezionareIntervento);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 100, 313, 72);
		contentPane.add(textPane);
		
		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tabella tab=new Tabella();
				String a=textPane.getText();
				String s=(String)comboBox.getSelectedItem();
				Vector<Intervento> v= new Vector<Intervento>();
				for(Intervento i: new Tabella().getListaInterventi()){
					if(i.getCodiceIntervento().equals(s)){
						v.addElement(i);
					}
				}
				for(Intervento j:v){
					for(Intervento i: new Tabella().getListaInterventi()){
						if(i.getCodiceIntervento().equals(j.getCodiceIntervento())){
							j.setAnestesia(a);
							tab.deleteIntervento(i.getRicovero().getCodiceUnivoco(), i.getCodiceIntervento(),i.getOperatore());
							tab.insertIntervento(j);
							break;
						}
					}
				}
				
			}
		});
		btnAggiorna.setEnabled(false);
		btnAggiorna.setBounds(10, 183, 89, 23);
		contentPane.add(btnAggiorna);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.occupato=false;
				dispose();
			}
		});
		btnEsci.setBounds(106, 183, 89, 23);
		contentPane.add(btnEsci);
		
		JButton btnSeleziona = new JButton("Seleziona");
		btnSeleziona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Intervento temp;
				boolean x=true;
				String s = (String) comboBox.getSelectedItem();
				for(Intervento i: new Tabella().getListaInterventi() ){	
					System.out.println(i.getCodiceIntervento());
					if(i.getCodiceIntervento().equals(s)){
						System.out.println(Login.id+" "+i.getOperatore());
						if(i.getOperatore().equals((String)Login.id)){
							System.out.println("Paperino");
							temp=i;
							textPane.setEditable(true);
							textPane.setText(i.getAnestesia());
							btnAggiorna.setEnabled(true);
							x=false;
							break;
						}
						x=true;
					}
				}
				if(x){
					textPane.setEditable(false);
					btnAggiorna.setEnabled(false);
				}

				for(Intervento i: new Tabella().getListaInterventi() ){
					if(i.getCodiceIntervento().equals(s)){
						temp=i;
						textPane.setText(i.getAnestesia());
						break;
					}
				}
			}
		});
		btnSeleziona.setBounds(234, 62, 89, 23);
		contentPane.add(btnSeleziona);
	}

	protected JComboBox getComboBox() {
		return comboBox;
	}
	protected JTextPane getTextPane() {
		return textPane;
	}
	public JButton getBtnAggiorna() {
		return btnAggiorna;
	}
}
