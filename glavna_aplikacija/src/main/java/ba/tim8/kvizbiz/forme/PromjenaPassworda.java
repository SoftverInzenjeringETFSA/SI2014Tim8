package ba.tim8.kvizbiz.forme;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;


import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import ba.tim8.kvizbiz.dao.AdministratorDao;
import ba.tim8.kvizbiz.entiteti.Administrator;
import ba.tim8.kvizbiz.entiteti.Klijent;
import ba.tim8.kvizbiz.entiteti.Spol;
import net.miginfocom.swing.MigLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PromjenaPassworda extends JFrame {

	//TODO: Rename textField u smislena imena
	
	private JFrame frmPromjenaPassworda;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JLabel lblStatus;

	
	public JFrame get_frmPromjenaPassworda () {
		return frmPromjenaPassworda;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromjenaPassworda window = new PromjenaPassworda();
					window.frmPromjenaPassworda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		panel_2.add(textField, "cell 2 0,growx,aligny top");
		
		JLabel lblPonoviteNoviPassword = new JLabel("Ponovite novi password:");
		lblPonoviteNoviPassword.setHorizontalAlignment(JLabel.RIGHT);
		panel_2.add(lblPonoviteNoviPassword, "cell 1 3,growx,aligny center");
		
		passwordField = new JPasswordField();
	    passwordField.setColumns(10);
		panel_2.add(passwordField, "cell 2 1,growx,aligny top");
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(10);
		panel_2.add(passwordField_1, "cell 2 3,growx,aligny top");
		
		JLabel lblNoviPassword = new JLabel("Novi password:");
		lblNoviPassword.setHorizontalAlignment(JLabel.RIGHT);
		panel_2.add(lblNoviPassword, "cell 1 2,growx,aligny center");
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setColumns(10);
		panel_2.add(passwordField_2, "cell 2 2,growx,aligny top");
		
		String neki = LoginAdmina.usernameLogiranogAdmina;
        textField.setText(neki);
		
		JButton btnPromjeniLinePodatke = new JButton("Promjeni password");
		btnPromjeniLinePodatke.addActionListener(new ActionListener() {
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
                
			 // potvrda password validacija
				if (passwordField_1.getText().isEmpty()) {
					dodaj = false;
					lblStatus.setText("Polje password mora biti popunjeno!");
					lblStatus.setForeground(Color.red);

				} 
			    
				 // novi password validacija
					if (passwordField_2.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Novi password mora biti popunjeno!");
						lblStatus.setForeground(Color.red);

					}else if(!passwordField_2.getText().equals(passwordField_1.getText())){
						dodaj = false;
						lblStatus.setText("Polja Novi password i Potvrdi password se ne poklapaju !");
						lblStatus.setForeground(Color.red);
					}
					
					 // trenutni password validacija
					if (passwordField.getText().isEmpty()) {
						dodaj = false;
						lblStatus.setText("Polje Trenutni Password mora biti popunjeno!");
						lblStatus.setForeground(Color.red);
                       
					}
					char[] c=passwordField.getPassword();
				
					 if(!administratordao.pretraziAdmina(neki,c)){
						dodaj = false;
						lblStatus.setText("Unijeli ste pogrešan password u polje Trenutni password!");
						lblStatus.setForeground(Color.red);
					}
					
					if(dodaj==true){
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
