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

public class ShowDriversFrame extends JFrame {

	private JPanel contentPane;
	public JTable table;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShowDriversFrame frame = new ShowDriversFrame();
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
	public ShowDriversFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 90, 755, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);


		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { "To", "From", "Departure Time", "Arrival Time", "Ticket kind", "Tickes left","Driver Name" }, },
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column","New column"}));

		JButton btnSave = new JButton("Save changes");
		btnSave.setVisible(true);
		btnSave.setBackground(new Color(82,179,217));
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBounds(589, 44, 150, 50);
		contentPane.add(btnSave);
		
		/*JButton btnAdd = new JButton("Add Trip");
		btnAdd.setVisible(true);
		btnAdd.setForeground(Color.RED);
		btnAdd.setFont(new Font("Swis721 BlkCn BT", Font.PLAIN, 13));
		btnAdd.setBounds(470, 100, 150, 55);
		contentPane.add(btnAdd);*/
		
		
		
		
		

		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					BufferedWriter bfw = new BufferedWriter(
							new FileWriter("Drivers.txt"));
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
		table.setBounds(0, 44, 579, 395);
		contentPane.add(table);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(249, 105, 14));
		panel.setBounds(0, 2, 755, 31);
		contentPane.add(panel);
		String filepath = "Drivers.txt";
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
			
			
			/*btnAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						try(PrintWriter output = new PrintWriter(new FileWriter("Drivers.txt",true))) {
							  output.printf("\n", " "); } catch (Exception e1) {}

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});*/

		} catch (Exception e) {

			e.printStackTrace();
		}
		JButton returnAdd = new JButton("Return");
		returnAdd.setVisible(true);
		returnAdd.setBounds(589, 112, 150, 50);
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
	}

}