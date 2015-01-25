package Employees;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;

import java.awt.Color;
public class Workers extends JFrame {
	

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textOxima;
	Connection con;
	Statement stmt;
	ResultSet rs;
	ResultSet rs2;
	int curRow = 0;
	JScrollPane scrollPane;
	
	private JButton btnUpdateRecord;
	private JButton btnDeleteRecord;
	private JButton btnNewRecord;
	private JButton btnSaveNewRecord;
	private JButton btnCancelNewRecord;
	private JTextField txtPassword;
	private JTextField txtUsername;
	public Workers() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("\u039A\u0391\u03A4\u0391\u03A3\u03A4\u0391\u03A3\u0397 \u039F\u0394\u0397\u0393\u03A9\u039D");
		setBounds(100, 100, 724, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(57, 17, 40, 26);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(182, 17, 183, 26);
		contentPane.add(textFirstName);
		textFirstName.setColumns(10);
		
		textLastName = new JTextField();
		textLastName.setBounds(182, 54, 183, 26);
		contentPane.add(textLastName);
		textLastName.setColumns(10);
		
		textOxima = new JTextField();
		textOxima.setBounds(182, 91, 183, 26);
		contentPane.add(textOxima);
		textOxima.setColumns(10);
		
		JButton btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					rs.first();
					int id_col= rs.getInt("id");
					String id = Integer.toString(id_col);
					String first = rs.getString("FirstName");
					String last = rs.getString("LastName");
					String oxima = rs.getString("oxima");
					
					textID.setText(id);
					textFirstName.setText(first);
					textLastName.setText(last);
					textOxima.setText(oxima);
				}catch(SQLException err){
					JOptionPane.showMessageDialog(Workers.this, err.getMessage());
				}
			}
		});
		btnFirst.setBounds(10, 78, 89, 23);
		contentPane.add(btnFirst);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(rs.previous()){
						int id_col= rs.getInt("id");
						String id = Integer.toString(id_col);
						String first = rs.getString("FirstName");
						String last = rs.getString("LastName");
						String oxima = rs.getString("oxima");
						
						textID.setText(id);
						textFirstName.setText(first);
						textLastName.setText(last);
						textOxima.setText(oxima);
					}else{
						rs.next();
						JOptionPane.showMessageDialog(Workers.this, "Start of File");
					}
				}catch(SQLException err){
					JOptionPane.showMessageDialog(Workers.this, err.getMessage());
				}
			}
		});
		btnPrevious.setBounds(10, 146, 89, 23);
		contentPane.add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(rs.next()){
						int id_col= rs.getInt("id");
						String id = Integer.toString(id_col);
						String first = rs.getString("FirstName");
						String last = rs.getString("LastName");
						String oxima = rs.getString("oxima");
						
						textID.setText(id);
						textFirstName.setText(first);
						textLastName.setText(last);
						textOxima.setText(oxima);
					}else{
						rs.previous();
						JOptionPane.showMessageDialog(Workers.this, "End of File");
					}
				}catch(SQLException err){
					JOptionPane.showMessageDialog(Workers.this, err.getMessage());
				}
			
			}
		});
		btnNext.setBounds(10, 112, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					rs.last();
					int id_col= rs.getInt("id");
					String id = Integer.toString(id_col);
					String first = rs.getString("FirstName");
					String last = rs.getString("LastName");
					String oxima = rs.getString("oxima");
					
					textID.setText(id);
					textFirstName.setText(first);
					textLastName.setText(last);
					textOxima.setText(oxima);
				}catch(SQLException err){
					JOptionPane.showMessageDialog(Workers.this, err.getMessage());
				}
			}
		});
		btnLast.setBounds(10, 180, 89, 23);
		contentPane.add(btnLast);
		
		btnUpdateRecord = new JButton("Update Record");
		btnUpdateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String first = textFirstName.getText( );
				String last = textLastName.getText( );
				String job = textOxima.getText( );
				String ID = textID.getText( );
				int newID = Integer.parseInt(ID);
				try {
					rs.updateInt( "id", newID );
					rs.updateString( "FirstName", first );
					rs.updateString( "LastName", last );
					rs.updateString( "oxima", job );
					rs.updateRow( );
					JOptionPane.showMessageDialog(Workers.this, "Updated");
					}
					catch (SQLException err) {
					System.out.println(err.getMessage() );
					}
			}
		});
		btnUpdateRecord.setBounds(0, 233, 123, 23);
		contentPane.add(btnUpdateRecord);
		
		btnDeleteRecord = new JButton("Delete Record");
		btnDeleteRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					rs.deleteRow();
					stmt.close();
					rs.close();
					stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
					String sql = "Select * from logistics";
					rs = stmt.executeQuery(sql);
				
					//First record
					rs.next();
					int id_col= rs.getInt("id");
					String id = Integer.toString(id_col);
					String first1 = rs.getString("FirstName");
					String last1 = rs.getString("LastName");
					String oxima1 = rs.getString("oxima");
					
					//Display them
					textID.setText(id);
					textFirstName.setText(first1);
					textLastName.setText(last1);
					textOxima.setText(oxima1);
				}catch(SQLException err){
					JOptionPane.showMessageDialog(Workers.this, err.getMessage());
				}
			}
		});
		btnDeleteRecord.setBounds(126, 233, 124, 23);
		contentPane.add(btnDeleteRecord);
		
		btnNewRecord = new JButton("New Record");
		btnNewRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Disable Buttons that not need
				btnFirst.setEnabled( false );
				btnPrevious.setEnabled( false ) ;
				btnNext.setEnabled( false );
				btnLast.setEnabled( false );
				btnUpdateRecord.setEnabled( false );
				btnDeleteRecord.setEnabled( false );
				btnNewRecord.setEnabled( false );
				txtUsername.setEnabled(true);
				txtPassword.setEnabled(true);
				btnSaveNewRecord.setEnabled( true );
				btnCancelNewRecord.setEnabled( true );
				scrollPane.setEnabled(true);
				//Clear TextFields
				try {
						
					
					curRow = rs.getRow();
					textFirstName.setText("");
					textLastName.setText("");
					textOxima.setText("");
					textID.setText("");
					txtUsername.setText("");
					txtPassword.setText("");
				} catch (SQLException err) {
					System.out.println(err.getMessage());
				}
				
			}
		});
		btnNewRecord.setBounds(252, 233, 113, 23);
		contentPane.add(btnNewRecord);
		
		btnSaveNewRecord = new JButton("Save New Record");
		btnSaveNewRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String first = textFirstName.getText();
			String last = textLastName.getText();
			String oxima = textOxima.getText();
			String user = txtUsername.getText();
			String pass = txtPassword.getText();
			try{
				rs.last();
				int id_col= rs.getInt("id");
				id_col = id_col + 1;
				rs.moveToInsertRow();
				rs.updateInt("id", id_col);
				rs.updateString("FirstName", first);
				rs.updateString("LastName", last);
				rs.updateString("oxima",oxima);
				rs.updateString("UserName", user);
				rs.updateString("Password", pass);
				rs.insertRow();
				
				stmt.close();
				rs.close();
				
				stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
				String sql = "Select * from logistics";
				rs = stmt.executeQuery(sql);
				
				//First record
				rs.next();
				int id_col1= rs.getInt("id");
				String id = Integer.toString(id_col1);
				String first1 = rs.getString("FirstName");
				String last1 = rs.getString("LastName");
				String oxima1 = rs.getString("oxima");
				
				//Display them
				
				textID.setText(id);
				textFirstName.setText(first1);
				textLastName.setText(last1);
				textOxima.setText(oxima1);
				txtUsername.setText("");
				txtPassword.setText("");
				btnFirst.setEnabled( true );
				btnPrevious.setEnabled( true ) ;
				btnNext.setEnabled( true );
				btnLast.setEnabled( true );
				btnUpdateRecord.setEnabled( true );
				btnDeleteRecord.setEnabled( true );
				btnNewRecord.setEnabled( true );
				
				btnSaveNewRecord.setEnabled( false );
				btnCancelNewRecord.setEnabled( false );
				txtUsername.setEnabled(false);
				txtPassword.setEnabled(false);
			}catch(SQLException err){
				System.out.println(err.getMessage());
			}
			
			}
		});
		btnSaveNewRecord.setEnabled(false);
		btnSaveNewRecord.setBounds(44, 267, 145, 23);
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
				txtUsername.setEnabled(false);
				txtPassword.setEnabled(false);
				txtUsername.setText("Username");
				txtPassword.setText("Password");
				btnSaveNewRecord.setEnabled( false );
				btnCancelNewRecord.setEnabled( false );
				try {
					rs.absolute(curRow);
					textFirstName.setText(rs.getString("FirstName"));
					textLastName.setText(rs.getString("LastName"));
					textOxima.setText(rs.getString("oxima"));
					textID.setText(Integer.toString(rs.getInt("ID")));
					
				} catch (SQLException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnCancelNewRecord.setEnabled(false);
		btnCancelNewRecord.setBounds(199, 267, 145, 23);
		contentPane.add(btnCancelNewRecord);
		
		txtPassword = new JTextField();
		txtPassword.setEnabled(false);
		txtPassword.setText("Password");
		txtPassword.setBounds(182, 144, 183, 26);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setEnabled(false);
		txtUsername.setText("Username");
		txtUsername.setBounds(182, 178, 183, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 23, 19, 14);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("ONOMA");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel.setBounds(126, 23, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblE = new JLabel("E\u03A0\u0399\u0398\u0395\u03A4\u039F");
		lblE.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblE.setBounds(126, 60, 58, 14);
		contentPane.add(lblE);
		
		JLabel label = new JLabel("\u039F\u03A7\u0397\u039C\u0391");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		label.setBounds(126, 97, 46, 14);
		contentPane.add(label);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblUsername.setBounds(126, 150, 58, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblPassword.setBounds(126, 184, 58, 14);
		contentPane.add(lblPassword);
		DoConnect();
		//Dokimi
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();
		try {
			String sql = "SELECT pinakida,katastasi FROM vehicle";
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
								
										scrollPane = new JScrollPane();
										scrollPane.setViewportView(table);
										scrollPane.setEnabled(false);
										scrollPane.setBounds(376, 17, 322, 273);
										contentPane.add(scrollPane);
										revalidate();
										repaint(); 
										//telos
		
		
				
	}
	
	
	public boolean DoConnect(){
		boolean t=false;
		
		try{
		String connectionUrl = "jdbc:mysql://localhost:3306/my_db";
		String connectionUser = "root";
		String connectionPassword = "root";
		con = DriverManager.getConnection(connectionUrl, connectionUser,connectionPassword);
		
		//Load Data
		stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
		String sql = "Select * from logistics";
		rs = stmt.executeQuery(sql);
		
		//First record
		rs.next();
		int id_col= rs.getInt("id");
		String id = Integer.toString(id_col);
		String first = rs.getString("FirstName");
		String last = rs.getString("LastName");
		String oxima = rs.getString("oxima");
		
		//Display them
		textID.setText(id);
		textFirstName.setText(first);
		textLastName.setText(last);
		textOxima.setText(oxima);
		
		t=true;
		
		}catch ( SQLException err){
			JOptionPane.showMessageDialog(Workers.this, err.getMessage());
		}
		return t;
		}
}
