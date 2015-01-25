package Employees;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Panel;

import javax.swing.ImageIcon;

import java.awt.Font;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField passwordField;
	Connection con;
	Statement stmt;
	ResultSet rs1;
	int curRow = 0;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					LogIn frame = new LogIn();
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
	public LogIn() {
		setTitle("Log In Page");
		setIcon();
		DoConnect();
		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		if (day == 1){
			try{
			int rs2 = stmt.executeUpdate("update logistics set fortia2=fortia1");
			int rs3 = stmt.executeUpdate("update logistics set fortia1=0"); 
			}catch ( SQLException err1){
				JOptionPane.showMessageDialog(LogIn.this, err1.getMessage());
			}
			
			}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(26, 34, 63, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(26, 66, 63, 14);
		contentPane.add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setBounds(99, 32, 196, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(99, 63, 196, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					
				String sql = txtUser.getText();
				
				rs1 = stmt.executeQuery("Select * from gm where Username = '"+ sql +"'");
		
				
				//First record
				if(rs1.next()){
				int idcol= rs1.getInt("id");
				String id = Integer.toString(idcol);
				String user = rs1.getString("Username");
				String pass = rs1.getString("Password");
				String name = rs1.getString("FirstName");
				int kwd = rs1.getInt("code");
				
				String test = String.copyValueOf(passwordField.getPassword());
				if (pass.equals(test)){
					if(kwd ==1){
						try {
							
							Choice1 frame1 = new Choice1(name);
							frame1.setVisible(true);
						} catch (Exception err) {
							err.printStackTrace();
						}
					}else if(kwd == 2){
						try {
							
							Choice2 frame2 = new Choice2(name);
							frame2.setVisible(true);
						} catch (Exception err) {
							err.printStackTrace();
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Wrong password! Please check your input!");
				}
				}else{
					JOptionPane.showMessageDialog(null, "Wrong username! Please check your input!");
				}
				}catch ( SQLException err1){
					JOptionPane.showMessageDialog(LogIn.this, err1.getMessage());
				}
				
			}
		});
		btnLogin.setBounds(205, 94, 89, 23);
		contentPane.add(btnLogin);
		
		lblNewLabel = new JLabel("\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u03B5\u03B9\u03C3\u03AC\u03B3\u03B5\u03C4\u03B5 \u03C4\u03B1 \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03C3\u03B1\u03C2");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(26, 9, 268, 14);
		contentPane.add(lblNewLabel);
		
		
		
	}
	
	
	
	
	//Change Java Icon
	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogInIcon.png")));
		
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
		
		t=true;
			
		}catch ( SQLException err){
			JOptionPane.showMessageDialog(LogIn.this, err.getMessage());
		}
		return t;
		}
}


