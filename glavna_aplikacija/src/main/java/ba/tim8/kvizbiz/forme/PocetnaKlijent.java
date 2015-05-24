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
import java.util.Collection;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.dao.PitanjeDao;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Pitanje;

public class PocetnaKlijent extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblAnkete;
	private JComboBox<Long> cbbID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PocetnaKlijent frame = new PocetnaKlijent();
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
	public PocetnaKlijent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		setTitle("Pregled anketa");
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0,0));
		
		Menu menu = new Menu();
		menu.NapraviMenu(this);
		
		JPanel pnlGlavna = new JPanel(new MigLayout("", "[grow]", "[fill][grow]"));
		pnlGlavna.setBorder(new TitledBorder("Odaberite anketu koju želite pregledati ili odaberite drugu akciju kroz meni:"));
		contentPane.add(pnlGlavna, BorderLayout.CENTER);
		
		JPanel pnlPregled = new JPanel(new MigLayout("", "[grow][fill][grow]", "[fill][fill]"));
		pnlGlavna.add(pnlPregled, "cell 0 0,growx");
		
		pnlPregled.add(new JLabel("Odabeire ID: "), "cell 1 0,alignx left");
		
		cbbID = new JComboBox<Long>();
		pnlPregled.add(cbbID, "cell 1 0,growx");
		
		JButton btnPregledaj = new JButton("Pregledaj odabranu anketu");
		btnPregledaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				PitanjeDao pdao = PitanjeDao.get();
				Collection<Pitanje> pitanja = pdao.DajSveZaKviz((Long)cbbID.getSelectedItem());
				String izvjestaj = "Pitanja odabranog kviza:\n\n";
				int brojac = 1;
				for(Pitanje pitanje : pitanja) {
					izvjestaj += brojac + ". pitanje: " + pitanje.get_tekstPitanja() + "\n";
					brojac++;
				}
				JOptionPane.showMessageDialog(null, izvjestaj);
			}
		});
		pnlPregled.add(btnPregledaj, "cell 1 2");
		
		tblAnkete = new JTable();
		tblAnkete.setModel(new DefaultTableModel(
				new Object[][] { },
				new String[] {
					"ID", "Naziv ankete", "Broj pitanja", "Vrijeme", "Aktivnosti", "Arhiviranosti"
				}
			));
		KvizDao kv= KvizDao.get();
		List<Long> l1 = (List<Long>) kv.ispisSvihAnketa();
		IscitajSveAktivneTabele(l1);
		
		JScrollPane scroll = new JScrollPane(tblAnkete);
		pnlGlavna.add(scroll, "cell 0 1,growx");
		
		JLabel lblStatus = new JLabel("Statusna traka");
		lblStatus.setBounds(10, 401, 574, 50);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		
		/* Stara forma
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Pregled anketa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 29, 574, 377);
		contentPane.add(panel);
		panel.setLayout(null);
		
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
		
		JButton btnNewButton_2 = new JButton("Pregledaj anketu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id= comboBox.getSelectedItem().toString();
				OdgovaranjeNaPitanje o= new OdgovaranjeNaPitanje(id);
				
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
	
	
		KvizDao kv= KvizDao.get();
		List<Long> l1 = (List<Long>) kv.ispisSvihAnketa();
		IscitajSveAktivneTabele(l1);


	    */
	}
	
	
	private void IscitajSveAktivneTabele(List<Long> lista)
	{
		KvizDao k= KvizDao.get();
		
		for(Long id:lista)
		{
			DefaultTableModel model = (DefaultTableModel) tblAnkete.getModel();
			Kviz kviz = k.read(id);
			
			model.addRow(new Object[]{kviz.get_id(), kviz.get_naziv(), kviz.get_pitanja().size(), kviz.get_vremenskoOgranicenje(), (kviz.is_aktivan() == true) ? "Aktivan" : "Neaktivan", (kviz.is_arhiviran() == true) ? "Arhiviran" : "Nearhiviran"});
			cbbID.addItem(id);
		}
		
	}
}



