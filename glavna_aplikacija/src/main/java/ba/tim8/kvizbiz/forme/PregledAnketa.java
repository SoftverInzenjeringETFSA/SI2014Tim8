package ba.tim8.kvizbiz.forme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.tim8.kvizbiz.dao.KvizDao;
import ba.tim8.kvizbiz.entiteti.Kviz;

public class PregledAnketa extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PregledAnketa frame = new PregledAnketa();
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
	public PregledAnketa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 579, 404);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPregledSvihAnketa = new JLabel("Pregled svih anketa");
		lblPregledSvihAnketa.setBounds(48, 21, 143, 21);
		panel.add(lblPregledSvihAnketa);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Id", "Naziv ankete"
			}
		));
		table.setBounds(48, 68, 200, 50);
		panel.add(table);
		
		
		JButton btnNewButton = new JButton("Statusna traka");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setLocation(0, 409);
		btnNewButton.setSize(584, 42);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setEnabled(false);
	contentPane.add(btnNewButton);
	
	KvizDao k= KvizDao.get();
	List<Long> l = (List<Long>) k.ispisSvihAnketa();
	IscitajSveTabele(l);

	}
	private void IscitajSveTabele(List<Long> lista)
	{
		KvizDao k= KvizDao.get();

		
		for(Long id:lista)
			
		{
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Kviz kviz = k.read(id);
			
			model.addRow(new Object[]{kviz.get_id(),kviz.get_naziv()});
			
			
			
		}
		
	}
}
