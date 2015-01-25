package Employees;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fill extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Connection con;
	Statement stmt;
	ResultSet rs1;

	
	public Fill() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 706, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("\u039F\u03BD\u03BF\u03BC\u03B1");
		label.setBounds(10, 12, 121, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel(
				"\u03A6\u03BF\u03C1\u03C4\u03AF\u03B1 \u03A4\u03C1\u03AD\u03C7\u03C9\u03BD \u039C\u03AE\u03BD\u03B1");
		label_1.setBounds(10, 37, 121, 14);
		contentPane.add(label_1);

		textField = new JTextField();
		textField.setBounds(141, 9, 129, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(141, 34, 129, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		DoConnect();

		// Dokimi
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();
		try {
			String sql = "SELECT FirstName,LastName,oxima,fortia1 FROM logistics";
			Statement stmt1 = con.createStatement();
			ResultSet rs = stmt1.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();

			// Get column names
			for (int i = 1; i <= columns; i++) {
				columnNames.add(md.getColumnName(i));
			}

			// Get row data
			while (rs.next()) {
				ArrayList row = new ArrayList(columns);

				for (int i = 1; i <= columns; i++) {
					row.add(rs.getObject(i));
				}

				data.add(row);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// Create Vectors and copy over elements from ArrayLists to them
		// Vector is deprecated but I am using them in this example to keep
		// things simple - the best practice would be to create a custom defined
		// class which inherits from the AbstractTableModel class
		Vector columnNamesVector = new Vector();
		Vector dataVector = new Vector();

		for (int i = 0; i < data.size(); i++) {
			ArrayList subArray = (ArrayList) data.get(i);
			Vector subVector = new Vector();
			for (int j = 0; j < subArray.size(); j++) {
				subVector.add(subArray.get(j));
			}
			dataVector.add(subVector);
		}

		for (int i = 0; i < columnNames.size(); i++)
			columnNamesVector.add(columnNames.get(i));
		setPreferredSize(new Dimension(450, 170));
		contentPane.setLayout(null);

		// Create table with database data
		JTable table = new JTable(dataVector, columnNamesVector) {
			public Class getColumnClass(int column) {
				for (int row = 0; row < getRowCount(); row++) {
					Object o = getValueAt(row, column);

					if (o != null) {
						return o.getClass();
					}
				}

				return Object.class;
			}
		};
		table.setEnabled(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setBounds(280, 11, 405, 109);
		contentPane.add(scrollPane);

		this.revalidate();
		this.repaint();
		// telos

		JButton btnNewButton = new JButton(
				"\u039A\u03B1\u03C4\u03B1\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				try {
					System.out.println(name);
					Statement stmt = con.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					// rs1 =
					// stmt.executeQuery("Select * from logistics where FirstName = '"+
					// name +"'");
					String for1 = textField_1.getText();
					int newID = Integer.parseInt(for1);
					String s = "Update logistics set fortia1=" + newID
							+ " where FirstName = '" + name + "'";
					stmt.executeUpdate(s);
					Refresh();
					
					
					JOptionPane.showMessageDialog(Fill.this, "Updated");
				} catch (SQLException err1) {
					JOptionPane.showMessageDialog(Fill.this, err1.getMessage());

				}

			}
		});
		btnNewButton.setBounds(48, 65, 168, 23);
		contentPane.add(btnNewButton);

	}
	public void Refresh(){
		
		this.dispose();
		Fill frame = new Fill();
		frame.setVisible(true);
	}
	public void DoConnect() {
		try {
			String connectionUrl = "jdbc:mysql://localhost:3306/my_db";
			String connectionUser = "root";
			String connectionPassword = "root";
			con = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);

		} catch (SQLException err) {
			JOptionPane.showMessageDialog(Fill.this, err.getMessage());
		}
	}

}
