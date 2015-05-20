package ba.tim8.kvizbiz.forme;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PocetnaKlijent_v1 extends JFrame {
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
					PocetnaKlijent_v1 frame = new PocetnaKlijent_v1();
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
	public PocetnaKlijent_v1() {
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
		lblStatus = new JLabel("Statusna traka");
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
	}
}
