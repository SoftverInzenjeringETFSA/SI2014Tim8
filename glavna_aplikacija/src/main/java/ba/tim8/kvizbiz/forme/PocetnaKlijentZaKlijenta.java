package ba.tim8.kvizbiz.forme;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.*;

import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.entiteti.Kviz;
import ba.tim8.kvizbiz.entiteti.Pitanje;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.List;

public class PocetnaKlijentZaKlijenta extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblStatus;

	/**
	 * Create the frame.
	 */
	public PocetnaKlijentZaKlijenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Menu menu = new Menu();
		menu.NapraviMenu(this);
		
		JPanel pnlKvizovi = new JPanel(new FlowLayout());
		pnlKvizovi.setBorder(new TitledBorder("Odaberite anketu na koji želite popuniti:"));
		contentPane.add(pnlKvizovi, BorderLayout.CENTER);
		
		KvizDao kdao = KvizDao.get();
		List<Long> listaAnketa = (List<Long>) kdao.ispisAktivnihAnketa();
		
		for(Long id:listaAnketa) {
			final Kviz kviz = kdao.read(id);
			
			final JPanel novaPanela = new JPanel(new BorderLayout(0, 0));
			novaPanela.setSize(120, 160);
			novaPanela.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5 ,5 ,5 ,5), BorderFactory.createRaisedBevelBorder()));
			
			final JLabel labela = new JLabel(kviz.get_naziv());
			labela.setHorizontalAlignment(SwingConstants.CENTER);
			novaPanela.add(labela, BorderLayout.SOUTH);
			
			ImageIcon slika = new ImageIcon("slike/slika" + (kviz.get_id()%6+1) + ".jpg");
			BufferedImage bi = new BufferedImage(120, 120, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = (Graphics2D) bi.createGraphics();
	        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	        g2d.drawImage(slika.getImage(), 0, 0, 120, 120, null);
	        novaPanela.add(new JLabel(new ImageIcon(bi)), BorderLayout.CENTER);
			
			novaPanela.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					KvizDao kdao = KvizDao.get();
					Kviz kviz1 = kdao.read((long)kviz.get_id());
					Collection<Pitanje> pitanja = kviz1.get_pitanja();
					if(pitanja.size()==0){
						lblStatus.setText("Anketa koju ste odabrali jos nema pitanja!");
						lblStatus.setForeground(Color.red);
						return;
					}
					int rezultatDijaloga = JOptionPane.showConfirmDialog(novaPanela, "Jeste li sigurni da zelite odabrati anketu " + labela.getText() + " ?", "Provjera izbora kviza", JOptionPane.YES_NO_OPTION);
					if (rezultatDijaloga == JOptionPane.YES_OPTION) {
						odgovaranje forma = new odgovaranje((long)kviz.get_id());
						forma.getFrmPopunjavanjeAnkete().setVisible(true);
						dispose();
					}
				}
			});
			
			pnlKvizovi.add(novaPanela);
		}
		
		lblStatus = new JLabel("Statusna traka");
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
	}
}
