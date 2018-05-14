import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OptionsForTheCustomerWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionsForTheCustomerWindow frame = new OptionsForTheCustomerWindow();
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
	public OptionsForTheCustomerWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Start a new trip");
		//btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				CustomerWindow CustomerWindowObject = new CustomerWindow();
//				CustomerWindowObject.setVisible(true);
//				CustomerWindowObject.pack();
//				CustomerWindowObject.setLocationRelativeTo(null);
//				CustomerWindowObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				CustomerWindowObject.setBounds(100, 100, 420, 262);
//				dispose();
//			}
//			
			
			
		//});
		btnNewButton.setBounds(48, 47, 121, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View your trip Info");
		btnNewButton_1.setBounds(48, 81, 121, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel your trip");
		btnNewButton_2.setBounds(48, 119, 121, 23);
		contentPane.add(btnNewButton_2);
	}
}