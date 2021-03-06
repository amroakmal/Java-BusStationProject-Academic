import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class ShowTripsFrame extends AbstractClass {
			
	
	
	/*public ShowTripsFrame(JPanel contentPane, JTable table) {
		super();
		this.contentPane = contentPane;
		this.table = table;
	}
*/
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowTripsFrame frame = new ShowTripsFrame();
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
	
	
	
	
	public ShowTripsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { "UserID", "To", "From" }, },
				new String[] { "New column", "New column", "New column" }));
		table.setBounds(70, 60, 471, 199);
		contentPane.add(table);
		String filepath = "showCurrentTrips.txt";
		File file = new File(filepath);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String firstLine = br.readLine().trim();
			String[] coloumnsName = firstLine.split(",");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setColumnIdentifiers(coloumnsName);
			Object[] tableLines = br.lines().toArray();

			for (int i = 0; i < tableLines.length; i++) {
				String line = tableLines[i].toString().trim();
				String[] dataRow = line.split(" ");
				model.addRow(dataRow);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
