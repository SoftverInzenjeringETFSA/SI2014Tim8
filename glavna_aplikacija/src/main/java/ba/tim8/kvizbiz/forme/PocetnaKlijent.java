package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PocetnaKlijent extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public PocetnaKlijent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		setTitle("Pregled anketa");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Pregled anketa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 574, 408);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Popuni");
		btnNewButton_1.setBounds(37, 186, 120, 23);
		panel.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(37, 85, 120, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Odaberi id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(37, 47, 120, 14);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(197, 85, 367, 256);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{65, "pokusaj"},
				{44, "Test"},
				{22, "test"},
				{11, "proba"},
				
			},
			new String[] {
				"ID", "Naziv ankete"
			}
		));
		table.setBounds(197, 47, 367, 256);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		Menu menu = new Menu();
		menu.NapraviMenu(this);
		
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setLocation(0, 409);
		btnNewButton.setSize(574, 42);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setEnabled(false);
	contentPane.add(btnNewButton);
	}
}
