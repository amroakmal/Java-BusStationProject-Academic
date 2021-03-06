import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class EmployeeWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EmployeeWindow frame = new EmployeeWindow();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public EmployeeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 237, 351);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(249, 105, 14));
		panel.setBounds(0, 0, 237, 31);
		contentPane.add(panel);
		
		JLabel label = new JLabel("X");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		label.setBounds(209, 0, 17, 31);
		panel.add(label);
		
		JLabel label_1 = new JLabel("-");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		label_1.setBounds(186, -5, 13, 37);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 31, 237, 320);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Edit Trips");
		btnNewButton_1.setBounds(10, 39, 215, 42);
		btnNewButton_1.setBackground(new Color(82,179,217));
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				
		JButton btnNewButton_2 = new JButton("Show Reservations");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(82,179,217));
		btnNewButton_2.setBounds(10, 92, 215, 42);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));

				
		JButton btnNewButton_3 = new JButton("Edit Cost");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(82,179,217));
		btnNewButton_3.setBounds(10, 145, 215, 42);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(btnNewButton_3);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBounds(10, 251, 217, 42);
		btnLogout.setBackground(new Color(82,179,217));
		panel_1.add(btnLogout);
		
		JButton btnShowDrivers = new JButton("Show Drivers");
		btnShowDrivers.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnShowDrivers.setForeground(Color.WHITE);
		btnShowDrivers.setBounds(10, 198, 215, 42);
		panel_1.add(btnShowDrivers);
		btnShowDrivers.setBackground(new Color(82,179,217));
		btnShowDrivers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowDriversFrame ShowDriversObject = new ShowDriversFrame();
				ShowDriversObject.setVisible(true);
				ShowDriversObject.pack();
				ShowDriversObject.setLocationRelativeTo(null);
				ShowDriversObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ShowDriversObject.setBounds(200, 200, 500, 400);
				dispose();
			}

		});
		btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				ShowCostFrame ShowCostObject = new ShowCostFrame();
				ShowCostObject.setVisible(true);
				ShowCostObject.pack();
				ShowCostObject.setLocationRelativeTo(null);
				ShowCostObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ShowCostObject.setBounds(90, 90, 352, 359);
				dispose();
						
				}
				});
		btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			ShowReservationFrame ShowReservationObject = new ShowReservationFrame();
			ShowReservationObject.setVisible(true);
			ShowReservationObject.pack();
			ShowReservationObject.setLocationRelativeTo(null);
			ShowReservationObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ShowReservationObject.setBounds(100, 90, 900, 300);
			dispose();
				}
				});
		
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				ShowBusesFrame ShowBusesObject =new ShowBusesFrame();
				ShowBusesObject.setVisible(true);
				ShowBusesObject.pack();
				ShowBusesObject.setLocationRelativeTo(null);
				ShowBusesObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ShowBusesObject.setBounds(100, 50, 640, 600);
				dispose();

			}
		});

	}
}