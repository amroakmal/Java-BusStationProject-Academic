import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class ShowCustomerTripsWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	CancelReservationInformation CancelReservationInformationObject = new CancelReservationInformation();
	private JLabel label_2;
	
	public ShowCustomerTripsWindow(String customerName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CancelReservationInformationObject.readFile();
		CancelReservationInformationObject.userFiletoArray();
		String[] cutomerTrips = CancelReservationInformationObject.showTripsForCancelation(customerName);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(249, 105, 14));
		panel.setBounds(0, 0, 389, 31);
		contentPane.add(panel);
		
		JLabel label = new JLabel("X");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		label.setBounds(365, 2, 24, 26);
		panel.add(label);
		
		JLabel label_1 = new JLabel("-");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		label_1.setBounds(342, 6, 13, 14);
		panel.add(label_1);
		
		label_2 = new JLabel("Return");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CustomerMainWindow CustomerMainWindowObject = new CustomerMainWindow(customerName);
				CustomerMainWindowObject.setVisible(true);
				CustomerMainWindowObject.pack();
				CustomerMainWindowObject.setLocationRelativeTo(null);
				CustomerMainWindowObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				CustomerMainWindowObject.setBounds(100, 100, 240, 434);
				dispose();
			}
		});
		label_2.setBounds(10, 6, 79, 22);
		panel.add(label_2);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(44, 62, 80));
		panel_1.setBounds(0, 30, 389, 330);
		contentPane.add(panel_1);
		
		textField = new JTextField();
		textField.setText("No reservations");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(82, 179, 217));
		textField.setBounds(10, 24, 369, 48);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("No reservations");
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(82, 179, 217));
		textField_1.setBounds(10, 101, 369, 48);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("No reservations");
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(82, 179, 217));
		textField_2.setBounds(10, 178, 369, 48);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("No reservations");
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(82, 179, 217));
		textField_3.setBounds(10, 254, 369, 48);
		panel_1.add(textField_3);
		setUndecorated(true);
		
		
		
		try {
			if(!cutomerTrips[0].equals(null))
				textField.setText(cutomerTrips[1]+" "+cutomerTrips[2]+" "+cutomerTrips[3]+" "+cutomerTrips[4]+" "+cutomerTrips[5]+" "+cutomerTrips[6]+" "+cutomerTrips[7]+" "+cutomerTrips[8]);
			if(!cutomerTrips[10].equals(null))
				textField_1.setText(cutomerTrips[10]+" "+cutomerTrips[11]+" "+cutomerTrips[12]+" "+cutomerTrips[13]+" "+cutomerTrips[14]+" "+cutomerTrips[15]+" "+cutomerTrips[16]+" "+cutomerTrips[17]);
			if(!cutomerTrips[19].equals(null))
				textField_2.setText(cutomerTrips[19]+" "+cutomerTrips[20]+" "+cutomerTrips[21]+" "+cutomerTrips[22]+" "+cutomerTrips[23]+" "+cutomerTrips[24]+" "+cutomerTrips[25]+" "+cutomerTrips[26]);
			if(!cutomerTrips[28].equals(null))
				textField_3.setText(cutomerTrips[28]+" "+cutomerTrips[29]+" "+cutomerTrips[30]+" "+cutomerTrips[31]+" "+cutomerTrips[32]+" "+cutomerTrips[33]+" "+cutomerTrips[34]+" "+cutomerTrips[35]);
			}
			catch(Exception e6)
			{
				
			}
		
	}
}
