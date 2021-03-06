package ba.tim8.kvizbiz.forme;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.*;

import ba.tim8.kvizbiz.dao.AdministratorDao;
import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;

public class LoginAdmina extends JFrame {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(LoginAdmina.class);

	public static String usernameLogiranogAdmina = ""; //NOSONAR
	
	private JPanel contentPane;
	private JLabel lblStatus;
	private JTextField tbxUsername;
	private JPasswordField pasPassword;

	/**
	 * Create the frame.
	 */
		public LoginAdmina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
String iconURL = "slike/ikonaKviz.png";
		
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		
		JPanel glavniDio = new JPanel(new MigLayout("", "[fill][grow][90px][90px]", "[fill][fill][grow][fill]"));
		glavniDio.setBorder(new TitledBorder("Unesite podatke za logiranje:"));
		contentPane.add(glavniDio, BorderLayout.CENTER);
		
		glavniDio.add(new JLabel("Korisničko ime: "), "cell 0 0,alignx right");
		glavniDio.add(new JLabel("Lozinka:"), "cell 0 1,alignx right");
		
		tbxUsername = new JTextField();
		glavniDio.add(tbxUsername, "cell 1 0 3 1,growx");
		
		pasPassword = new JPasswordField();
		glavniDio.add(pasPassword, "cell 1 1 3 1,growx");
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String username= tbxUsername.getText();
					char[] password = pasPassword.getPassword();				
					AdministratorDao a= AdministratorDao.get();					
									
					if(a.pretraziAdmina(username,password)){					
						usernameLogiranogAdmina = username; //NOSONAR
						PocetnaKlijent forma = new PocetnaKlijent();
						forma.setVisible(true);
						dispose();
					}
					else {
						lblStatus.setText("Pogrešan unos korisničkog imena ili lozinke.");
						lblStatus.setForeground(Color.red);
					}
				}
				catch(Exception e2)
				{
					logger.error("Greska: ", e2);
				}
			}				
		});
		glavniDio.add(btnOK, "cell 3 3, growx");
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KvizBiz forma = new KvizBiz();
				forma.get_frame().repaint();
				forma.get_frame().revalidate();
				forma.get_frame().setVisible(true);
				dispose();
			}				
		});
		glavniDio.add(btnNazad, "cell 2 3,growx");
		
		lblStatus = new JLabel("Statusna traka");
		lblStatus.setForeground(Color.lightGray);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
	}

}
