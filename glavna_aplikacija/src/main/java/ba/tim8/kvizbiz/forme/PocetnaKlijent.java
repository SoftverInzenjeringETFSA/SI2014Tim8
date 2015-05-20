package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.entiteti.Kviz;

public class PocetnaKlijent extends JFrame {

	private JPanel contentPane;
	private JTable table;
private JComboBox comboBox;
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
		panel.setBounds(10, 29, 574, 377);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Pregled anketa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PregledAnketa p= new PregledAnketa();
				p.setVisible(true);
				
			}
		});
	
		btnNewButton_1.setBounds(37, 186, 120, 23);
		panel.add(btnNewButton_1);
		
		comboBox = new JComboBox();
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
			new Object[][] { },
			new String[] {
				"ID", "Naziv ankete"
			}
		));
		
		
		
		table.setBounds(197, 47, 367, 256);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Popuni anketu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OdgovaranjeNaPitanje o= new OdgovaranjeNaPitanje();
				o.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(37, 237, 120, 23);
		panel.add(btnNewButton_2);
		
	
		
		JLabel lblStatus = new JLabel("Statusna traka");
		lblStatus.setBounds(10, 401, 574, 50);
		contentPane.add(lblStatus);
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		
				
		
	
		
		Menu menu = new Menu();
		menu.NapraviMenu(this);
	
	KvizDao k= KvizDao.get();
	List<Long> l = (List<Long>) k.ispisAktivnihAnketa();
	IscitajSveAktivneTabele(l);


	
	}
	
	private void IscitajSveAktivneTabele(List<Long> lista)
	{
		KvizDao k= KvizDao.get();

		
		for(Long id:lista)
			
		{
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Kviz kviz = k.read(id);
			
			model.addRow(new Object[]{kviz.get_id(),kviz.get_naziv()});
			comboBox.addItem(id.toString());
			
			
		}
		
	}
}



