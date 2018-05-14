import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class ShowBusesFrame extends JFrame {

	private JPanel contentPane;
	public JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShowBusesFrame frame = new ShowBusesFrame();
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
	public ShowBusesFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBounds(100, 50, 640, 600);
		setUndecorated(true);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(249,105,14));
		panel_3.setBounds(0, 0, 640, 90);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { "To", "From", "Departure Time", "Arrival Time", "Ticket kind", "Tickes left","Stops number","Start time" }, },
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column","New column","New column" }));

		JButton btnSave = new JButton("Save changes");
		btnSave.setVisible(true);
		btnSave.setBounds(470, 100, 150, 50);
		contentPane.add(btnSave);
		btnSave.setBackground(new Color(82,179,217));
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnAdd = new JButton("Add Trip");
		btnAdd.setVisible(true);
		btnAdd.setBounds(470, 150, 150, 50);
		contentPane.add(btnAdd);
		btnAdd.setBackground(new Color(82,179,217));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton returnAdd = new JButton("Return");
		returnAdd.setVisible(true);
		returnAdd.setBounds(470, 200, 150, 50);
		contentPane.add(returnAdd);
		returnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EmployeeWindow EmployeeWindowObject = new EmployeeWindow();
				EmployeeWindowObject.setVisible(true);
				EmployeeWindowObject.pack();
				EmployeeWindowObject.setLocationRelativeTo(null);
				EmployeeWindowObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				EmployeeWindowObject.setBounds(100, 100, 237, 406);

				dispose();
			}
		});
		returnAdd.setBackground(new Color(82,179,217));
		returnAdd.setForeground(Color.WHITE);
		returnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		
		

		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					BufferedWriter bfw = new BufferedWriter(
							new FileWriter("Trips.txt"));
					for (int i = 0; i < table.getColumnCount(); i++) {
						bfw.write(table.getColumnName(i));
						bfw.write(" ");
					}
					bfw.newLine();
					for (int i = 1; i < table.getRowCount(); i++) {
						for (int j = 0; j < table.getColumnCount(); j++) {
							bfw.append((CharSequence) table.getValueAt(i, j));
							bfw.write(" ");
						}
						bfw.newLine();
					}
					bfw.close();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		table.getColumnModel().getColumn(3).setPreferredWidth(99);
		table.setBounds(0, 100, 450, 500);
		table.setBackground(new Color(82,179,217));
		contentPane.add(table);
		String filepath = "Trips.txt";
		File file = new File(filepath);

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String firstLine = br.readLine().trim();
			String[] coloumnsName = firstLine.split(" ");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setColumnIdentifiers(coloumnsName);
			Object[] tableLines = br.lines().toArray();

			for (int i = 0; i < tableLines.length; i++) {
				String line = tableLines[i].toString().trim();
				String[] dataRow = line.split(" ");
				model.addRow(dataRow);
			}
			
			
			btnAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						try(PrintWriter output = new PrintWriter(new FileWriter("Trips.txt",true))) {
							  output.printf("\n", " "); } catch (Exception e1) {}

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}