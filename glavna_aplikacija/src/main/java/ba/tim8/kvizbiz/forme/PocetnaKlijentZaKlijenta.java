package ba.tim8.kvizbiz.forme;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.entiteti.Kviz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class PocetnaKlijentZaKlijenta extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PocetnaKlijentZaKlijenta frame = new PocetnaKlijentZaKlijenta();
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
	public PocetnaKlijentZaKlijenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Menu menu = new Menu();
		menu.NapraviMenu(this);
		
		JPanel pnlKvizovi = new JPanel(new FlowLayout());
		pnlKvizovi.setBorder(new TitledBorder("Odaberite kviz na koji želite odgovarati:"));
		contentPane.add(pnlKvizovi, BorderLayout.CENTER);
		
		/*
		for (int i = 0; i < 8; i++) {
			final JPanel pnlTest1 = new JPanel(new BorderLayout(0, 0));
			pnlTest1.setSize(120, 160);
			pnlTest1.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5 ,5 ,5 ,5), BorderFactory.createRaisedBevelBorder()));
			
			final JLabel labela = new JLabel("Naslov kviza " + i);
			labela.setHorizontalAlignment(SwingConstants.CENTER);
			pnlTest1.add(labela, BorderLayout.SOUTH);
			
			ImageIcon slika = new ImageIcon("slike/slika1.jpg");
			BufferedImage bi = new BufferedImage(120, 120, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = (Graphics2D) bi.createGraphics();
	        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	        g2d.drawImage(slika.getImage(), 0, 0, 120, 120, null);
			pnlTest1.add(new JLabel(new ImageIcon(bi)), BorderLayout.CENTER);
			
			pnlTest1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					JOptionPane.showConfirmDialog(pnlTest1, "Jeste li sigurni da zelite odabrati kviz " + labela.getText() + " ?");
				}
			});
			
			pnlKvizovi.add(pnlTest1);
		}
		*/
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
					int rezultatDijaloga = JOptionPane.showConfirmDialog(novaPanela, "Jeste li sigurni da zelite odabrati kviz " + labela.getText() + " ?", "Provjera izbora kviza", JOptionPane.YES_NO_OPTION);
					if (rezultatDijaloga == JOptionPane.YES_OPTION) {
						//TODO: Odvesti na Muhamedovu formu
						JOptionPane.showMessageDialog(null, "Id kviza: " + kviz.get_id());
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
