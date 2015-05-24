package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.tim8.kvizbiz.dao.BaseDao;
import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.dao.PitanjeDao;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Pitanje;
import ba.tim8.kvizbiz.konekcija.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import javafx.scene.control.Alert;
public class ManipulacijaAnketama extends JFrame {
private JFrame frame;
	
	public JFrame get_frame () {
		return frame;
	}

	public static long trenutniKvizID = -1;
	private JFrame frmManipulacijaAnketama;
	private JTable tblAnkete;
	private JPanel panel1;
	List<Kviz> lk = new ArrayList<Kviz>();
	public Kviz kviz = null;
	public JFrame get_frmManipulacijaAnketama () {
		return frmManipulacijaAnketama;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManipulacijaAnketama window = new ManipulacijaAnketama();
					window.frmManipulacijaAnketama.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManipulacijaAnketama() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManipulacijaAnketama = new JFrame();
		frmManipulacijaAnketama.setTitle("Manipulacija anketama");
		frmManipulacijaAnketama.setBounds(100, 100, 630, 430);
		frmManipulacijaAnketama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmManipulacijaAnketama);
		
		JPanel panel1 = new JPanel();
		frmManipulacijaAnketama.getContentPane().add(panel1, BorderLayout.CENTER);
		panel1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ozna\u010Dite akciju i manipuli\u0161ite anketama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 579, 282);
		panel1.add(panel);
		panel.setLayout(null);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 26, 402, 245);
		panel.add(scrollPane);
		
		// Testni podaci
		Object[] naziviKolona = new Object[]{"Broj", "Naziv", "Ograni\u010Denje", "Status"};
		Object[][] podaci = new Object[][]{
				
		};
		
		final DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(podaci, naziviKolona);
		
		
		tblAnkete = new JTable(model);
		tblAnkete.getColumnModel().getColumn(0).setPreferredWidth(20);
		scrollPane.setViewportView(tblAnkete);
		
		KvizDao k= KvizDao.get();
		List<Long> l = (List<Long>) k.ispisSvihAnketa();
		IscitajSveAnkete(l);
		
		JButton btnObriiOznaenu = new JButton("Obri\u0161i ozna\u010Denu");
		btnObriiOznaenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				BaseDao b= BaseDao.delete(tblAnkete.getSelectionModel().getSelectionMode()4
				
				Kviz selected = new Kviz();
				int selectedRow = tblAnkete.getSelectedRow();
				if(selectedRow<0){JOptionPane.showMessageDialog(null, "Morate oznaciti anketu!");}
				else{
				
				
				selected = lk.get(tblAnkete.convertRowIndexToModel(selectedRow));
				
				
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
	    
	    selected = (Kviz) session.load(Kviz.class,selected.get_id());
	    session.delete(selected);
			t.commit();
				session.close();
//				lk.remove(selected);
//				
//				model.removeRow(tblAnkete.getSelectedRow());
//				model.fireTableDataChanged();
				
				int a= model.getRowCount()-1;
				
				while(a>=0){
					
					model.removeRow(a);
					lk.remove(a);
					a--;
					
				}
				KvizDao k= KvizDao.get();
				List<Long> l = (List<Long>) k.ispisSvihAnketa();
				IscitajSveAnkete(l);
				
				tblAnkete.repaint();
				
				selected = null;
				
				}
			}
		});
		btnObriiOznaenu.setBounds(10, 92, 147, 23);
		panel.add(btnObriiOznaenu);
		
		final JButton btnModifikujOznaenu = new JButton("Modifikuj ozna\u010Denu");
		btnModifikujOznaenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int selectedRow = tblAnkete.getSelectedRow();
				if(selectedRow<0){JOptionPane.showMessageDialog(null, "Morate ozna\u010Diti anketu!");}
				else{
				kviz = lk.get(tblAnkete.convertRowIndexToModel(selectedRow));
				if(!kviz.is_aktivan() && !kviz.is_arhiviran()){
					
				
				Component component = (Component) arg0.getSource();
				ModifikacijaAnkete forma = new ModifikacijaAnkete(kviz,(JFrame) SwingUtilities.getRoot(component));
				
				forma.setVisible(true);
					
					
					
				dispose();		
				
				}else{
					JOptionPane.showMessageDialog(null, "Mozete modifikovati samo otvorenu anketu!");
				}
				}
				
			}
		});
		
		
		
		
		
		
		btnModifikujOznaenu.setBounds(10, 126, 147, 23);
		panel.add(btnModifikujOznaenu);
		
		JButton btnArhivirajOznaenu = new JButton("Arhiviraj ozna\u010Denu");
		btnArhivirajOznaenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kviz selected = new Kviz();
				int selectedRow = tblAnkete.getSelectedRow();
				if(selectedRow<0){JOptionPane.showMessageDialog(null, "Morate ozna\u010Diti anketu!");}
				else{
				
				
				selected = lk.get(tblAnkete.convertRowIndexToModel(selectedRow));
				if(selected.is_arhiviran())

					JOptionPane.showMessageDialog(null, "Vec arhivirana");
				selected.set_aktivan(false);
				selected.set_arhiviran(true);
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				session.update(selected);
				t.commit();
				session.close();
				
				model.fireTableDataChanged();
				int a= model.getRowCount()-1;
				
				while(a>=0){
					
					model.removeRow(a);
					a--;
				}
				KvizDao k= KvizDao.get();
				List<Long> l = (List<Long>) k.ispisSvihAnketa();
				IscitajSveAnkete(l);
			}
			}
		});
		btnArhivirajOznaenu.setBounds(10, 160, 147, 23);
		panel.add(btnArhivirajOznaenu);
		

		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PocetnaKlijent p= new PocetnaKlijent();
				p.setVisible(true);
				dispose();
			}
		});
		btnOk.setBounds(500, 304, 89, 23);
		panel1.add(btnOk);
		
	
		
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmManipulacijaAnketama.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		
		
		
	}
	
//	public void update(){
//		
//		
//		int a= model.getRowCount()-1;
//		
//		while(a>=0){
//			
//			model.removeRow(a);
//			lk.remove(a);
//			a--;
//			
//		}
//		KvizDao k= KvizDao.get();
//		List<Long> l = (List<Long>) k.ispisSvihAnketa();
//		IscitajSveAnkete(l);
//		
//		tblAnkete.repaint();
//	}
	
	private List<Kviz> IscitajSveAnkete(List<Long> lista)
	{
		KvizDao k= KvizDao.get();
		
		
		for(Long id:lista)
			
		{
			
			DefaultTableModel model = (DefaultTableModel) tblAnkete.getModel();
			Kviz kviz = k.read(id);
			lk.add(kviz);
			if(kviz.is_aktivan())
			{
			model.addRow(new Object[]{kviz.get_id(),kviz.get_naziv(),kviz.get_vremenskoOgranicenje(),"aktivan"});
			
			}
			else if(kviz.is_arhiviran())
			{
				model.addRow(new Object[]{kviz.get_id(),kviz.get_naziv(),kviz.get_vremenskoOgranicenje(),"arhiviran"});

			}
			else
			{
				model.addRow(new Object[]{kviz.get_id(),kviz.get_naziv(),kviz.get_vremenskoOgranicenje(),"otvoren"});

			}
			
		}
		
		return lk;
		
	}
	private void ucitajSvaPitanja()
	{
		
		KvizDao k= KvizDao.get();
		List<Long> l = (List<Long>) k.ispisSvihAnketa();
		IscitajSveAnkete(l);
	}
	
	private void removeAllRows()
	{
		DefaultTableModel dm = (DefaultTableModel) tblAnkete.getModel();
		int rowCount = dm.getRowCount();
	
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
	
	
	
	public void refresh() {
		removeAllRows();
		ucitajSvaPitanja();
		
		
		panel1.revalidate();
		panel1.repaint();
	}
	
	
	

}
