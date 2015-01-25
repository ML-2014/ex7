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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

public class Vehicle extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String Choice[] = { "Συνεργείο", "Έτοιμο", "Εκτός"};
	Connection con;
	Statement stmt;
	ResultSet rs;
	ResultSet rs2;
	int curRow = 0;
	private JTextField textID;
	private JButton btnUpdateRecord;
	private JButton btnDeleteRecord;
	private JButton btnNewRecord;
	private JButton btnSaveNewRecord;
	private JButton btnCancelNewRecord;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vehicle frame = new Vehicle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	
	public Vehicle() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 11, 25, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					rs.first();
					int id_col= rs.getInt("id");
					String id = Integer.toString(id_col);
					String pin = rs.getString("pinakida");
					String odi = rs.getString("odigos");
					String kat = rs.getString("katastasi");
					
					//Display them
					textID.setText(id);
					textField.setText(pin);
					textField_1.setText(odi);
					textField_2.setText(kat);
					
				}catch(SQLException err){
					JOptionPane.showMessageDialog(Vehicle.this, err.getMessage());
				}
			}
		});
		btnFirst.setBounds(10, 60, 89, 23);
		contentPane.add(btnFirst);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(rs.next()){
						int id_col= rs.getInt("id");
						String id = Integer.toString(id_col);
						String pin = rs.getString("pinakida");
						String odi = rs.getString("odigos");
						String kat = rs.getString("katastasi");
						
						//Display them
						textID.setText(id);
						textField.setText(pin);
						textField_1.setText(odi);
						textField_2.setText(kat);
					}else{
						rs.previous();
						JOptionPane.showMessageDialog(Vehicle.this, "End of File");
					}
				}catch(SQLException err){
					JOptionPane.showMessageDialog(Vehicle.this, err.getMessage());
				}
			}
		});
		btnNext.setBounds(10, 94, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(rs.previous()){
						int id_col= rs.getInt("id");
						String id = Integer.toString(id_col);
						String pin = rs.getString("pinakida");
						String odi = rs.getString("odigos");
						String kat = rs.getString("katastasi");
						
						//Display them
						textID.setText(id);
						textField.setText(pin);
						textField_1.setText(odi);
						textField_2.setText(kat);
					}else{
						rs.next();
						JOptionPane.showMessageDialog(Vehicle.this, "Start of File");
					}
				}catch(SQLException err){
					JOptionPane.showMessageDialog(Vehicle.this, err.getMessage());
				}
			}
		});
		btnPrevious.setBounds(10, 128, 89, 23);
		contentPane.add(btnPrevious);
		
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					rs.last();
					int id_col= rs.getInt("id");
					String id = Integer.toString(id_col);
					String pin = rs.getString("pinakida");
					String odi = rs.getString("odigos");
					String kat = rs.getString("katastasi");
					
					//Display them
					textID.setText(id);
					textField.setText(pin);
					textField_1.setText(odi);
					textField_2.setText(kat);
				}catch(SQLException err){
					JOptionPane.showMessageDialog(Vehicle.this, err.getMessage());
				}
			}
		});
		btnLast.setBounds(10, 162, 89, 23);
		contentPane.add(btnLast);
		JList list = new JList(Choice);
		list.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		list.setBounds(226, 131, 186, 54);
		contentPane.add(list);
		JButton btnUpdateRecord = new JButton("Update Record");
		btnUpdateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pin =textField.getText( );
				String odi = textField_1.getText( );
				
				String ID = textID.getText( );
				int newID = Integer.parseInt(ID);
				int idx = list.getSelectedIndex();
				String kat = null;
				if (idx != -1)
		        	 kat = Choice[idx];
		         
		        else
		        	JOptionPane.showMessageDialog(Vehicle.this, "Επιλέξτε Κατάσταση");
		      
				try {
					rs.updateInt( "id", newID );
					rs.updateString( "pinakida", pin );
					rs.updateString( "odigos", odi );
					rs.updateString( "katastasi", kat );
					rs.updateRow( );
					JOptionPane.showMessageDialog(Vehicle.this, "Updated");
					}
					catch (SQLException err) {
					System.out.println(err.getMessage() );
					}
				textField_2.setText(kat);
				
			}
		});
		btnUpdateRecord.setBounds(28, 217, 130, 23);
		contentPane.add(btnUpdateRecord);
		
		btnDeleteRecord = new JButton("Delete Record");
		btnDeleteRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					rs.deleteRow();
					stmt.close();
					rs.close();
					stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
					String sql = "Select * from vehicle";
					rs = stmt.executeQuery(sql);
				
					//First record
					rs.next();
					int id_col= rs.getInt("id");
					String id = Integer.toString(id_col);
					String first1 = rs.getString("pinakida");
					String last1 = rs.getString("odigos");
					String oxima1 = rs.getString("katastasi");
					
					//Display them
					textID.setText(id);
					textField.setText(first1);
					textField_1.setText(last1);
					textField_2.setText(oxima1);
					
				}catch(SQLException err){
					JOptionPane.showMessageDialog(Vehicle.this, err.getMessage());
				}
			}
		});
		btnDeleteRecord.setBounds(168, 217, 117, 23);
		contentPane.add(btnDeleteRecord);
		btnSaveNewRecord = new JButton("Save New Record");
		btnSaveNewRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pin = textField.getText();
				String odi = textField_1.getText();
				int idx = list.getSelectedIndex();
				String kat = null;
				if (idx != -1)
		        	 kat = Choice[idx];
		         
		        else
		        	JOptionPane.showMessageDialog(Vehicle.this, "Επιλέξτε Κατάσταση");
				try{
					rs.last();
					int id_col= rs.getInt("id");
					id_col = id_col + 1;
					rs.moveToInsertRow();
					rs.updateInt("id", id_col);
					rs.updateString("pinakida", pin);
					rs.updateString("odigos", odi);
					rs.updateString("katastasi",kat);
					
					rs.insertRow();
					
					stmt.close();
					rs.close();
					
					stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
					String sql = "Select * from vehicle";
					rs = stmt.executeQuery(sql);
					
					//First record
					rs.next();
					int id_col1= rs.getInt("id");
					String id = Integer.toString(id_col1);
					String pin1 = rs.getString("pinakida");
					String odi1 = rs.getString("odigos");
					String kat1 = rs.getString("katastasi");
					
					//Display them
					textID.setText(id);
					textField.setText(pin1);
					textField_1.setText(odi1);
					textField_2.setText(kat1);
					btnFirst.setEnabled( true );
					btnPrevious.setEnabled( true ) ;
					btnNext.setEnabled( true );
					btnLast.setEnabled( true );
					btnUpdateRecord.setEnabled( true );
					btnDeleteRecord.setEnabled( true );
					btnNewRecord.setEnabled( true );
					
					btnSaveNewRecord.setEnabled( false );
					btnCancelNewRecord.setEnabled( false );
					
				}catch(SQLException err){
					System.out.println(err.getMessage());
				}
				
			}
		});
		btnSaveNewRecord.setEnabled(false);
		btnSaveNewRecord.setBounds(70, 251, 146, 23);
		contentPane.add(btnSaveNewRecord);
		
		btnCancelNewRecord = new JButton("Cancel New Record");
		btnCancelNewRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFirst.setEnabled( true );
				btnPrevious.setEnabled( true ) ;
				btnNext.setEnabled( true );
				btnLast.setEnabled( true );
				btnUpdateRecord.setEnabled( true );
				btnDeleteRecord.setEnabled( true );
				btnNewRecord.setEnabled( true );
				
				btnSaveNewRecord.setEnabled( false );
				btnCancelNewRecord.setEnabled( false );
				try {
					rs.absolute(curRow);
					textField.setText(rs.getString("pinakida"));
					textField_1.setText(rs.getString("odigos"));
					textField_2.setText(rs.getString("katastasi"));
					textID.setText(Integer.toString(rs.getInt("id")));
					
				} catch (SQLException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnCancelNewRecord.setEnabled(false);
		btnCancelNewRecord.setBounds(226, 251, 146, 23);
		contentPane.add(btnCancelNewRecord);
		
		btnNewRecord = new JButton("New Record");
		btnNewRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnUpdateRecord.setEnabled(false);
				btnDeleteRecord.setEnabled( false );
				btnNewRecord.setEnabled( false );
				btnSaveNewRecord.setEnabled( true );
				btnCancelNewRecord.setEnabled( true );
				btnFirst.setEnabled(false);
				btnNext.setEnabled(false);
				btnPrevious.setEnabled(false);
				btnLast.setEnabled(false);
				try {
					
					curRow = rs.getRow();
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					
				} catch (SQLException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnNewRecord.setBounds(295, 217, 117, 23);
		contentPane.add(btnNewRecord);
		
		
		
		JLabel label = new JLabel("\u03A0\u0399\u039D\u0391\u039A\u0399\u0394\u0391");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(136, 11, 80, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u039F\u0394\u0397\u0393\u039F\u03A3");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setBounds(136, 64, 80, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u039A\u0391\u03A4\u0391\u03A3\u03A4\u0391\u03A3\u0397");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setBounds(133, 98, 83, 14);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(226, 8, 186, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(226, 61, 186, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(226, 95, 186, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textID = new JTextField();
		textID.setText("0");
		textID.setEditable(false);
		textID.setBounds(40, 8, 86, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		DoConnect();
		
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();
		try {
			String sql = "SELECT FirstName,Oxima FROM logistics";
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
								scrollPane.setBounds(422, 11, 215, 263);
								contentPane.add(scrollPane);
								
								JLabel label_3 = new JLabel("\u0391\u039B\u039B\u0391\u0393\u0397");
								label_3.setHorizontalAlignment(SwingConstants.LEFT);
								label_3.setBounds(136, 132, 86, 14);
								contentPane.add(label_3);
								
								JLabel lblNewLabel_1 = new JLabel(" \u039A\u0391\u03A4\u0391\u03A3\u03A4\u0391\u03A3\u0397\u03A3");
								lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
								lblNewLabel_1.setBounds(133, 145, 89, 14);
								contentPane.add(lblNewLabel_1);
								
	}
	public void DoConnect(){
		try{
		String connectionUrl = "jdbc:mysql://localhost:3306/my_db";
		String connectionUser = "root";
		String connectionPassword = "root";
		con = DriverManager.getConnection(connectionUrl, connectionUser,connectionPassword);
		
		//Load Data
		stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
		String sql = "Select * from vehicle";
		rs = stmt.executeQuery(sql);
		
		//First record
		rs.next();
		int id_col= rs.getInt("id");
		String id = Integer.toString(id_col);
		String pin = rs.getString("pinakida");
		String odi = rs.getString("odigos");
		String kat = rs.getString("katastasi");
		
		//Display them
		textID.setText(id);
		textField.setText(pin);
		textField_1.setText(odi);
		textField_2.setText(kat);
		
		
		}catch ( SQLException err){
			JOptionPane.showMessageDialog(Vehicle.this, err.getMessage());
		}
		}
	}

