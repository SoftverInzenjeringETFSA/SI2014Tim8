package ba.tim8.kvizbiz.forme;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KvizBiz extends JFrame {

	private JFrame frame;
	
	public JFrame get_frame () {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public KvizBiz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{35, 0, 0};
		gridBagLayout.rowHeights = new int[]{35, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnRegistrujSeKao = new JButton("Registruj se kao korisnik");
		btnRegistrujSeKao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistracijaKlijenta noviFrame = new RegistracijaKlijenta();
				noviFrame.frmRegistracijaKlijenta.setVisible(true);
				frame.dispose();
			}
		});
		GridBagConstraints gbc_btnRegistrujSeKao = new GridBagConstraints();
		gbc_btnRegistrujSeKao.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegistrujSeKao.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegistrujSeKao.gridx = 1;
		gbc_btnRegistrujSeKao.gridy = 1;
		frame.getContentPane().add(btnRegistrujSeKao, gbc_btnRegistrujSeKao);
		
		JButton btnRegistrujSeKao_1 = new JButton("Registruj se kao administrator");
		btnRegistrujSeKao_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmina noviFrame = new LoginAdmina();
				noviFrame.setVisible(true);			
				frame.dispose();
			}
		});
		GridBagConstraints gbc_btnRegistrujSeKao_1 = new GridBagConstraints();
		gbc_btnRegistrujSeKao_1.gridx = 1;
		gbc_btnRegistrujSeKao_1.gridy = 2;
		frame.getContentPane().add(btnRegistrujSeKao_1, gbc_btnRegistrujSeKao_1);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnPomo = new JMenu("Pomo\u0107");
		menuBar.add(mnPomo);
	}

}
