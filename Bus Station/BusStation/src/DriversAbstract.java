import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public abstract class DriversAbstract extends JFrame{
	
	private JPanel contentPane1;
	private JTable table1;
	
	private JPanel contentPane;
	public JTable table;

	
	public void showDrivers()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);


		/*JButton btnShowTrips = new JButton("Show Trips");

		btnShowTrips.setBounds(131, 76, 89, 23);
		contentPane.add(btnShowTrips);*/
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { "To", "From", "Departure Time", "Arrival Time", "Ticket kind", "Tickes left","Driver Name" }, },
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column","New column"}));
		table.setBounds(50, 50, 350, 205);
		contentPane.add(table);
	}
	

	public void showSuitableDriverData(String k) throws IOException {
		
		FileReader reader = new FileReader("Drivers.txt");
		BufferedReader buffer = new BufferedReader(reader);
		String line = buffer.readLine();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		ArrayList <String> ArrayListData = new ArrayList<>();
		while (buffer.ready()) {
			 line = buffer.readLine();
			String[] tokens = line.split(" ");
			for (String token : tokens) {
				int i =0;
				if (token.trim().equals(k))
					{
						ArrayListData.add(line);
						String line1 = ArrayListData.get(i);
						String[] dataRow = line.split(" ");
						model.addRow(dataRow);
					}
			}
		}
			
		buffer.close();
	
	
	}
}