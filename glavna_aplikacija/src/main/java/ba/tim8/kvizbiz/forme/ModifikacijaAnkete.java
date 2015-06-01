package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.dao.PitanjeDao;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Pitanje;

import org.apache.log4j.Logger;

public class ModifikacijaAnkete extends JFrame {
	final static Logger logger = Logger.getLogger(ModifikacijaAnkete.class);
	private JFrame frame;
	
	public JFrame get_frame () {
		return frame;
	}

	private static final long serialVersionUID = 1L;
	
	public static Kviz trenutniKviz; //NOSONAR
	
	private JPanel contentPane;
	private JTextField tbxNaslov;
	private JTextField tbxStatus;	
	private JTable tblPitanja;
	private JLabel lblStatus;
	private JSpinner spiVrijeme;
	public static Kviz kviz = null; //NOSONAR
	public String test;
	private JComboBox<Integer> cbbID;


	List<Pitanje> lk = new ArrayList<Pitanje>(); //NOSONAR

	/**
	 * Create the frame.
	 */
	public ModifikacijaAnkete(final Kviz kviz, final JFrame proslaForma) {
		this.kviz = kviz;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 520);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Menu menu = new Menu();
		menu.NapraviMenu(this);
		
		JPanel kontejner = new JPanel();
		kontejner.setBorder(null);
		contentPane.add(kontejner, BorderLayout.CENTER);
		kontejner.setLayout(null);
		
		JPanel pnlPodaci = new JPanel(new MigLayout("", "[grow][fill][220px][grow]", "[fill][fill]"));
		pnlPodaci.setBounds(7, 7, 570, 99);
		pnlPodaci.setBorder(new TitledBorder("Unesite nove podatke o anketi:"));
		kontejner.add(pnlPodaci);
		
		pnlPodaci.add(new JLabel("Naslov ankete: "), "cell 1 0,alignx right");
		pnlPodaci.add(new JLabel("Vremensko ograničenje: "), "cell 1 1,alignx right");
		pnlPodaci.add(new JLabel("Status ankete: "), "cell 1 2,alignx right");
		
		tbxNaslov = new JTextField();
		pnlPodaci.add(tbxNaslov, "cell 2 0,growx");
		tbxNaslov.setText(kviz.get_naziv());
		
		spiVrijeme = new JSpinner();
		spiVrijeme.setModel(new SpinnerNumberModel(kviz.get_vremenskoOgranicenje(), 1, 100, 1));
		pnlPodaci.add(spiVrijeme, "cell 2 1,alignx left");
		
		tbxStatus = new JTextField();
		pnlPodaci.add(tbxStatus, "cell 2 2,growx");
		tbxStatus.setText("Otvorena");
		
		
		JPanel pnlPitanja = new JPanel();
		pnlPitanja.setBounds(7, 104, 633, 308);
		pnlPitanja.setBorder(new TitledBorder("Unesite pitanja:"));
		kontejner.add(pnlPitanja);
		
		JButton btnDodaj = new JButton("Dodaj novo pitanje");
		btnDodaj.setBounds(13, 23, 180, 23);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component component = (Component) e.getSource();
				DodavanjeManipulacija forma = new DodavanjeManipulacija(kviz.get_id(), (JFrame) SwingUtilities.getRoot(component));
				forma.setVisible(true);
				dispose();
			}
		});
		pnlPitanja.setLayout(null);
		pnlPitanja.add(btnDodaj);
		
//		JLabel label = new JLabel("Odaberite ID:");
//		label.setBounds(13, 50, 97, 20);
//		pnlPitanja.add(label);
//		cbbID = new JComboBox<Integer>();
//		cbbID.setBounds(114, 50, 58, 20);
//		PitanjeDao pdao = PitanjeDao.get();
//		
//		if (kviz.get_id() != -1)
//			for(long id : pdao.DajSveIdZaKviz(kviz.get_id()))
//				cbbID.addItem((int)id);
//		
		
		
//		if (kviz.get_id() != -1){
//			List<Long> a = (List<Long>) pdao.DajSveIdZaKviz(kviz.get_id());
//			for(int i=0; i<a.size();i++)
//			{
//				long id= a.get(i);
//				cbbID.addItem((int)id);
//				
//			}
//		}
//			for(long id : pdao.DajSveIdZaKviz(kviz.get_id()))
//				cbbID.addItem((int)id);
		
		
//		pnlPitanja.add(cbbID);
		
		
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Component component = (Component) e.getSource();
				//forma.setVisible(true);
				//dispose();
			}
		});
			
		JButton btnObrisi = new JButton("Obriši odabrano pitanje");
		btnObrisi.setBounds(13, 129, 180, 23);
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pitanje selected = new Pitanje();
				int selectedRow = tblPitanja.getSelectedRow();
				
				selected = lk.get(tblPitanja.convertRowIndexToModel(selectedRow));
				
				long id = selected.get_id();
				int odabraniId = (int) id;
				PitanjeDao pdao = PitanjeDao.get();
				try {
					pdao.delete((long) odabraniId);
					lblStatus.setText("Pitanje je uspješno obrisano.");
					lblStatus.setForeground(Color.green);
					
					removeAllRows();
					ucitajSvaPitanja();
					
//					cbbID.removeAllItems();
//					for(long id : pdao.DajSveIdZaKviz(1))
//						cbbID.addItem((int)id);
					
					contentPane.revalidate();
					contentPane.repaint();
				}
				catch (Exception e1) {
					lblStatus.setText("Greska: " + e1.getMessage());
					lblStatus.setForeground(Color.red);
					
					logger.error("Greska: ", e1);
				}
			}
		});
		pnlPitanja.add(btnObrisi);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(502, 412, 100, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					kviz.set_naziv(tbxNaslov.getText());
					kviz.set_vremenskoOgranicenje((Integer)spiVrijeme.getValue());
					KvizDao kdao = KvizDao.get();
					kdao.update(kviz);
					lblStatus.setText("Uspjesan unos početnih podataka");
					lblStatus.setForeground(Color.green);
				}
				catch(Exception e1) {
					lblStatus.setText("Greska: " + e1.getMessage());
					lblStatus.setForeground(Color.red);
					
					logger.error("Greska: ", e1);
				}
			
				
				
			
			}
			
			
		});
		kontejner.add(btnOk);
		
		JButton btnOtkazi = new JButton("Nazad");
		btnOtkazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PocetnaKlijent p=new PocetnaKlijent();
				dispose();
				p.setVisible(true);
				
				
			}
		});
		btnOtkazi.setBounds(381, 412, 100, 23);
		kontejner.add(btnOtkazi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(249, 11, 356, 283);
		pnlPitanja.add(scrollPane);
			
		tblPitanja = new JTable();
		scrollPane.setViewportView(tblPitanja);
		tblPitanja.setColumnSelectionAllowed(true);
		tblPitanja.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblPitanja.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID pitanja", "Tekst pitanja", "Tip pitanja"
			}
		)
		{
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		
		
		
		
		JButton btnNewButton = new JButton("Promjena statusa ankete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kviz.set_aktivan(true);
				kviz.set_arhiviran(false);	
			tbxStatus.setText("aktivna");
					KvizDao kdao = KvizDao.get();
					try {
						kdao.update(kviz);
						lblStatus.setText("Uspjesan unos početnih podataka");
						lblStatus.setForeground(Color.green);
					}
					catch(Exception e1) {
						lblStatus.setText("Greska: " + e1.getMessage());
						lblStatus.setForeground(Color.red);
						
						logger.error("Greska: ", e1);
					}
				
			}
		});
		btnNewButton.setBounds(13, 174, 180, 23);
		pnlPitanja.add(btnNewButton);
		
		
		
		lblStatus = new JLabel("Statusna traka");
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
		
		ucitajSvaPitanja();
	}
	
	public ModifikacijaAnkete() {
		this.kviz = kviz;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 520);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Menu menu = new Menu();
		menu.NapraviMenu(this);
		
		JPanel kontejner = new JPanel();
		kontejner.setBorder(null);
		contentPane.add(kontejner, BorderLayout.CENTER);
		kontejner.setLayout(null);
		
		JPanel pnlPodaci = new JPanel(new MigLayout("", "[grow][fill][220px][grow]", "[fill][fill]"));
		pnlPodaci.setBounds(7, 7, 570, 99);
		pnlPodaci.setBorder(new TitledBorder("Unesite nove podatke o anketi:"));
		kontejner.add(pnlPodaci);
		
		pnlPodaci.add(new JLabel("Naslov ankete: "), "cell 1 0,alignx right");
		pnlPodaci.add(new JLabel("Vremensko ograničenje: "), "cell 1 1,alignx right");
		pnlPodaci.add(new JLabel("Status ankete: "), "cell 1 2,alignx right");
		
		tbxNaslov = new JTextField();
		pnlPodaci.add(tbxNaslov, "cell 2 0,growx");
		tbxNaslov.setText(kviz.get_naziv());
		
		spiVrijeme = new JSpinner();
		spiVrijeme.setModel(new SpinnerNumberModel(kviz.get_vremenskoOgranicenje(), 1, 100, 1));
		pnlPodaci.add(spiVrijeme, "cell 2 1,alignx left");
		
		tbxStatus = new JTextField();
		pnlPodaci.add(tbxStatus, "cell 2 2,growx");
		tbxStatus.setText("Otvorena");
		
		
		JPanel pnlPitanja = new JPanel();
		pnlPitanja.setBounds(7, 104, 633, 308);
		pnlPitanja.setBorder(new TitledBorder("Unesite pitanja:"));
		kontejner.add(pnlPitanja);
		
		JButton btnDodaj = new JButton("Dodaj novo pitanje");
		btnDodaj.setBounds(13, 23, 180, 23);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component component = (Component) e.getSource();
				DodavanjeManipulacija forma = new DodavanjeManipulacija(kviz.get_id(), (JFrame) SwingUtilities.getRoot(component));
				forma.setVisible(true);
				dispose();
			}
		});
		pnlPitanja.setLayout(null);
		pnlPitanja.add(btnDodaj);
		
//		JLabel label = new JLabel("Odaberite ID:");
//		label.setBounds(13, 50, 97, 20);
//		pnlPitanja.add(label);
//		cbbID = new JComboBox<Integer>();
//		cbbID.setBounds(114, 50, 58, 20);
//		PitanjeDao pdao = PitanjeDao.get();
//		
//		if (kviz.get_id() != -1)
//			for(long id : pdao.DajSveIdZaKviz(kviz.get_id()))
//				cbbID.addItem((int)id);
//		
		
		
//		if (kviz.get_id() != -1){
//			List<Long> a = (List<Long>) pdao.DajSveIdZaKviz(kviz.get_id());
//			for(int i=0; i<a.size();i++)
//			{
//				long id= a.get(i);
//				cbbID.addItem((int)id);
//				
//			}
//		}
//			for(long id : pdao.DajSveIdZaKviz(kviz.get_id()))
//				cbbID.addItem((int)id);
		
		
//		pnlPitanja.add(cbbID);
		
		
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Component component = (Component) e.getSource();
				//forma.setVisible(true);
				//dispose();
			}
		});
			
		JButton btnObrisi = new JButton("Obriši odabrano pitanje");
		btnObrisi.setBounds(13, 129, 180, 23);
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pitanje selected = new Pitanje();
				int selectedRow = tblPitanja.getSelectedRow();
				
				selected = lk.get(tblPitanja.convertRowIndexToModel(selectedRow));
				
				long id = selected.get_id();
				int odabraniId = (int) id;
				PitanjeDao pdao = PitanjeDao.get();
				try {
					pdao.delete((long) odabraniId);
					lblStatus.setText("Pitanje je uspješno obrisano.");
					lblStatus.setForeground(Color.green);
					
					removeAllRows();
					ucitajSvaPitanja();
					
//					cbbID.removeAllItems();
//					for(long id : pdao.DajSveIdZaKviz(1))
//						cbbID.addItem((int)id);
					
					contentPane.revalidate();
					contentPane.repaint();
				}
				catch (Exception e1) {
					lblStatus.setText("Greska: " + e1.getMessage());
					lblStatus.setForeground(Color.red);
					
					logger.error("Greska: ", e1);
				}
			}
		});
		pnlPitanja.add(btnObrisi);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(502, 412, 100, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					kviz.set_naziv(tbxNaslov.getText());
					kviz.set_vremenskoOgranicenje((Integer)spiVrijeme.getValue());
					KvizDao kdao = KvizDao.get();
					kdao.update(kviz);
					lblStatus.setText("Uspjesan unos početnih podataka");
					lblStatus.setForeground(Color.green);
				}
				catch(Exception e1) {
					lblStatus.setText("Greska: " + e1.getMessage());
					lblStatus.setForeground(Color.red);
					
					logger.error("Greska: ", e1);
				}
			
				
				
			
			}
			
			
		});
		kontejner.add(btnOk);
		
		JButton btnOtkazi = new JButton("Nazad");
		btnOtkazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PocetnaKlijent p=new PocetnaKlijent();
				dispose();
				p.setVisible(true);
				
				
			}
		});
		btnOtkazi.setBounds(381, 412, 100, 23);
		kontejner.add(btnOtkazi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(249, 11, 356, 283);
		pnlPitanja.add(scrollPane);
			
		tblPitanja = new JTable();
		scrollPane.setViewportView(tblPitanja);
		tblPitanja.setColumnSelectionAllowed(true);
		tblPitanja.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblPitanja.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID pitanja", "Tekst pitanja", "Tip pitanja"
			}
		)
		{
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		
		
		
		
		JButton btnNewButton = new JButton("Promjena statusa ankete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kviz.set_aktivan(true);
				kviz.set_arhiviran(false);	
			tbxStatus.setText("aktivna");
					KvizDao kdao = KvizDao.get();
					try {
						kdao.update(kviz);
						lblStatus.setText("Uspjesan unos početnih podataka");
						lblStatus.setForeground(Color.green);
					}
					catch(Exception e1) {
						lblStatus.setText("Greska: " + e1.getMessage());
						lblStatus.setForeground(Color.red);
						
						logger.error("Greska: ", e1);
					}
				
			}
		});
		btnNewButton.setBounds(13, 174, 180, 23);
		pnlPitanja.add(btnNewButton);
		
		
		
		lblStatus = new JLabel("Statusna traka");
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
		
		ucitajSvaPitanja();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// TODO Auto-generated constructor stub
	}

	private void ucitajSvaPitanja()
	{
		PitanjeDao pdao = PitanjeDao.get();
//		Collection<Pitanje> pitanja = pdao.readAll();
		Collection<Pitanje> pitanja = pdao.DajSveZaKviz(kviz.get_id());
		DefaultTableModel model = (DefaultTableModel) tblPitanja.getModel();
		
		ucitajPitanja(pitanja);
		
		lk = (List<Pitanje>) pdao.readAll();
	}	
	
	private void ucitajPitanja(Collection<Pitanje> pitanja)
	{
		DefaultTableModel model = (DefaultTableModel) tblPitanja.getModel();
		removeAllRows();
		
		for(Pitanje p : pitanja)
		{
			model.addRow(new Object[]{p.get_id(), p.get_tekstPitanja(), p.get_tipPitanja()});
		}
	}
	
	private void removeAllRows()
	{
		DefaultTableModel dm = (DefaultTableModel) tblPitanja.getModel();
		int rowCount = dm.getRowCount();
	
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
}
