package ba.tim8.kvizbiz.forme;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import net.miginfocom.swing.MigLayout;

public class frmDodavanjePitanja_v2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDodavanjePitanja_v2 frame = new frmDodavanjePitanja_v2();
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
	public frmDodavanjePitanja_v2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		JPanel kontejner = new JPanel(new MigLayout("", "[grow]", "[grow,fill][grow,bottom][][::100px,fill]"));
		kontejner.setBorder(null);
		contentPane.add(kontejner, BorderLayout.CENTER);
		
		JPanel pnlPodaci = new JPanel();
		pnlPodaci.setBorder(new TitledBorder("Unesite podatke o pitanju:"));
		kontejner.add(pnlPodaci, "cell 0 0,growx,aligny top");
		
		JPanel pnlOdgovor = new JPanel();
		kontejner.add(pnlOdgovor, "cell 0 1,grow");
		
		JButton btnOk = new JButton("OK");
		kontejner.add(btnOk, "flowx,cell 0 2,alignx right,aligny bottom");
		
		JButton btnNewButton = new JButton("New button");
		kontejner.add(btnNewButton, "cell 0 2,alignx right");
		
		JButton btnNewButton_1 = new JButton("New button");
		kontejner.add(btnNewButton_1, "cell 0 3,growx,aligny bottom");
		
		JButton btnStatus = new JButton("Statusna traka");
		btnStatus.setEnabled(false);
		btnStatus.setHorizontalAlignment(SwingConstants.LEFT);
		btnStatus.setForeground(SystemColor.textHighlight);
		contentPane.add(btnStatus, BorderLayout.SOUTH);
		
		/*
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow,fill][grow,bottom][][::100px,fill]"));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 0,grow");
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 0 1,grow");
		
		JButton btnOk = new JButton("OK");
		contentPane.add(btnOk, "flowx,cell 0 2,alignx right");
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton, "cell 0 2,alignx right");
		
		JButton btnNewButton_1 = new JButton("New button");
		contentPane.add(btnNewButton_1, "cell 0 3,growx,aligny bottom");
		*/	
	}

}
