package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.dao.PitanjeDao;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Pitanje;

public class PocetnaKlijent extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblAnkete;
	private JComboBox<Long> cbbID;
	
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
		
		pnlPregled.add(new JLabel("Odaberi ID: "), "cell 1 0,alignx left");
		
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
	}
	
	
	private void sortirajPoNazivu(Collection<Kviz> kviz)
	{
		Comparator<Kviz> comparator = new Comparator<Kviz>() {
		    public int compare(Kviz f1, Kviz f2) {
		        return f1.get_naziv().compareTo(f2.get_naziv());
		    }
		};

		Collections.sort((ArrayList<Kviz>) kviz, comparator);
		
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



