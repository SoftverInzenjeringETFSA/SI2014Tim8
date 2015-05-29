package ba.tim8.kvizbiz.forme;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import ba.tim8.kvizbiz.dao.AdministratorDao;
import ba.tim8.kvizbiz.entiteti.Administrator;
import net.miginfocom.swing.MigLayout;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PromjenaPassworda extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(PromjenaLicnihPodataka.class);

	private JFrame frmPromjenaPassworda;
	private JTextField username;
	private JPasswordField trenutniPassword;
	private JPasswordField noviPassword;
	private JPasswordField potvrdiPassword;
	private JLabel lblStatus;

	
	public JFrame get_frmPromjenaPassworda () {
		return frmPromjenaPassworda;
	}

	
	
	/**
	 * Create the application.
	 */
	public PromjenaPassworda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPromjenaPassworda = new JFrame();
		frmPromjenaPassworda.setTitle("Promjena passworda");
		frmPromjenaPassworda.setLocationRelativeTo(null);
		frmPromjenaPassworda.setBounds(100, 100, 600, 500);
		frmPromjenaPassworda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPromjenaPassworda.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		lblStatus = new JLabel("Uredu");
		lblStatus.setForeground(Color.BLUE);
		lblStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmPromjenaPassworda.getContentPane().add(lblStatus, BorderLayout.SOUTH);
		
		// Kreiranje menija
		Menu menu = new Menu();
		menu.NapraviMenu(frmPromjenaPassworda);
		
		JPanel panel = new JPanel();
		frmPromjenaPassworda.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow]", "[grow][20px]"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o korisni\u010Dkom ra\u010Dunu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new MigLayout("", "[grow][fill][220px][grow]", "[fill][fill][fill][fill]"));
		
		JLabel lblTrenutniPassword = new JLabel("Trenutni password:");
				lblTrenutniPassword.setHorizontalAlignment(JLabel.RIGHT);
		panel_2.add(lblTrenutniPassword, "cell 1 1,growx,aligny center");
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(JLabel.RIGHT);
		panel_2.add(lblUsername, "cell 1 0,growx,aligny center");
		
		username = new JTextField();
		username.setEditable(false);
		username.setColumns(10);
		panel_2.add(username, "cell 2 0,growx,aligny top");
		
		JLabel lblPonoviteNoviPassword = new JLabel("Ponovite novi password:");
		lblPonoviteNoviPassword.setHorizontalAlignment(JLabel.RIGHT);
		panel_2.add(lblPonoviteNoviPassword, "cell 1 3,growx,aligny center");
		
		trenutniPassword = new JPasswordField();
		trenutniPassword.setColumns(10);
		panel_2.add(trenutniPassword, "cell 2 1,growx,aligny top");
		
		noviPassword = new JPasswordField();
		noviPassword.setColumns(10);
		panel_2.add(noviPassword, "cell 2 3,growx,aligny top");
		
		JLabel lblNoviPassword = new JLabel("Novi password:");
		lblNoviPassword.setHorizontalAlignment(JLabel.RIGHT);
		panel_2.add(lblNoviPassword, "cell 1 2,growx,aligny center");
		
		potvrdiPassword = new JPasswordField();
		potvrdiPassword.setColumns(10);
		panel_2.add(potvrdiPassword, "cell 2 2,growx,aligny top");
		
		String neki = LoginAdmina.usernameLogiranogAdmina;
		username.setText(neki);
		
		JButton btnPromjeniLinePodatke = new JButton("Promjeni password");
		btnPromjeniLinePodatke.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				boolean dodaj=true;
			    AdministratorDao administratordao = AdministratorDao.get();
				String neki = LoginAdmina.usernameLogiranogAdmina;
				Collection<Administrator> administrator = administratordao.dajPoUsernamu(neki);
		        Administrator trazeniAdministrator = new Administrator();
		         for (Iterator<Administrator> iterator = administrator.iterator(); iterator
				      .hasNext();) {
			       trazeniAdministrator = (Administrator) iterator.next();
		        }
                
		         
		         
					if(!potvrdiPassword.getText().equals(noviPassword.getText())){
						dodaj = false;
						lblStatus.setText("Polja Novi password i Ponovite novi password se ne poklapaju !");
						lblStatus.setForeground(Color.red);
					}
		         
		         
			 // potvrda password validacija
				if (noviPassword.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Polje Ponovite novi password mora biti popunjeno!");
					lblStatus.setForeground(Color.red);

				}
				else{
					String pom=noviPassword.getText();
					char[] niz=noviPassword.getText().toCharArray();					
					for(int i=0;i<pom.length();i++){
						if(niz [i]=='ć' || niz [i]=='č' || niz [i]=='ž' || niz [i]=='š' || niz [i]=='đ' ||niz [i]=='Ć' || niz [i]=='Č' || niz [i]=='Ž' || niz [i]=='Š' || niz [i]=='Đ'){
							dodaj = false;
							lblStatus.setText("Polje Ponovite novi password ne može sadržavati afrikate(čćšđž)!");
							lblStatus.setForeground(Color.red);

						}
							
						
					}
				}
				
				
				     // novi password validacija

					 if (potvrdiPassword.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Novi password mora biti popunjeno!");
						lblStatus.setForeground(Color.red);

					}
					 else{
							String pom=potvrdiPassword.getText();
							char[] niz=potvrdiPassword.getText().toCharArray();					
							for(int i=0;i<pom.length();i++){
								if(niz [i]=='ć' || niz [i]=='č' || niz [i]=='ž' || niz [i]=='š' || niz [i]=='đ' ||niz [i]=='Ć' || niz [i]=='Č' || niz [i]=='Ž' || niz [i]=='Š' || niz [i]=='Đ'){
									dodaj = false;
									lblStatus.setText("Polje Novi password ne može sadržavati afrikate(čćšđž)!");
									lblStatus.setForeground(Color.red);

								}
									
								
							}
						}
						
					 // trenutni password validacija
					char[] c=trenutniPassword.getPassword();
					
					 if(!administratordao.pretraziAdmina(neki,c)){
						dodaj = false;
						lblStatus.setText("Unijeli ste pogrešan password u polje Trenutni password!");
						lblStatus.setForeground(Color.red);
					}
					if (trenutniPassword.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Trenutni Password mora biti popunjeno!");
						lblStatus.setForeground(Color.red);
                       
					}
					
					
					if(dodaj==true){
						trazeniAdministrator.set_password(noviPassword.getText());
						try {
							administratordao.updatePass(trazeniAdministrator);
							}
							catch (Exception e1) {
								lblStatus.setText("Došlo je do greško prilikom upisa u bazu");
								lblStatus.setForeground(Color.red);
								
								logger.error("Greska: ", e1);
								
								return;
							}
						administratordao.updatePass(trazeniAdministrator);
						lblStatus.setText("Uredu");
						lblStatus.setForeground(Color.blue);
						JOptionPane.showMessageDialog(null,
								"Password je uspješno promijenjen!",
								"Promjena passworda",
								JOptionPane.INFORMATION_MESSAGE);
						PromjenaPassworda noviProzor = new PromjenaPassworda();
						JFrame noviFrame = noviProzor.get_frmPromjenaPassworda();
						noviFrame.setVisible(true);
						frmPromjenaPassworda.dispose();
					}
								
				
			}
		});
		panel.add(btnPromjeniLinePodatke, "cell 0 1,alignx right,aligny bottom");
			
		/*JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setEnabled(false);
		frmPromjenaPassworda.getContentPane().add(btnNewButton, BorderLayout.SOUTH);*/
	
	}
}
