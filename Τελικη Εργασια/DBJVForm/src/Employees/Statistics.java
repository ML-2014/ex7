package Employees;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

public class Statistics extends JFrame {

	private JPanel contentPane;
	Connection con;
	Statement stmt;
	ResultSet rs,rs1;
	int curRow = 0;
	private JTextField textUsername;
	private JTextField textOnoma;
	private JTextField textEpitheto;
	private JTextField textFortia1;
	private JTextField textFortia2;
	public Statistics() {
		setTitle("\u03A3\u03C4\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03AC \u03B5\u03C1\u03B3\u03B1\u03B6\u03BF\u03BC\u03AD\u03BD\u03C9\u03BD");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 478, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUsername = new JTextField();
		textUsername.setBounds(192, 11, 133, 22);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnNewButton = new JButton("\u0395\u03C0\u03B9\u03BB\u03BF\u03B3\u03AE");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql = textUsername.getText();
				System.out.println("onoma "+ sql);
				try{
					curRow = rs.getRow();
					String n = Integer.toString(curRow);
					System.out.println("row "+ n);
				rs1 = stmt.executeQuery("Select * from logistics where FirstName = '"+ sql +"'");
					
				rs1.next();
				
				int fr1= rs1.getInt("fortia1");
				String fortia1 = Integer.toString(fr1);
				
				int fr2= rs1.getInt("fortia2");
				String fortia2 = Integer.toString(fr2);
				
				String first1 = rs1.getString("FirstName");
				
				String last1 = rs1.getString("LastName");
			
				//Display them
				textOnoma.setText(first1);
				textEpitheto.setText(last1);
				textFortia1.setText(fortia1);
				textFortia2.setText(fortia2);
				
				rs = stmt.executeQuery("Select * from logistics");
				}catch ( SQLException err1){
					JOptionPane.showMessageDialog(Statistics.this, err1.getMessage());
				}
				
			}
		});
		btnNewButton.setBounds(335, 10, 117, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5 \u03CC\u03BD\u03BF\u03BC\u03B1 \u03B5\u03C1\u03B3\u03B1\u03B6\u03BF\u03BC\u03AD\u03BD\u03BF\u03C5......");
		label.setBounds(10, 14, 172, 14);
		contentPane.add(label);
		
		textOnoma = new JTextField();
		textOnoma.setBounds(192, 52, 133, 20);
		contentPane.add(textOnoma);
		textOnoma.setColumns(10);
		
		textEpitheto = new JTextField();
		textEpitheto.setBounds(192, 83, 133, 20);
		contentPane.add(textEpitheto);
		textEpitheto.setColumns(10);
		
		textFortia1 = new JTextField();
		textFortia1.setBounds(192, 114, 133, 20);
		contentPane.add(textFortia1);
		textFortia1.setColumns(10);
		
		textFortia2 = new JTextField();
		textFortia2.setBounds(192, 145, 133, 20);
		contentPane.add(textFortia2);
		textFortia2.setColumns(10);
		
		JLabel label_1 = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1 \u03B5\u03C1\u03B3\u03B1\u03B6\u03BF\u03BC\u03AD\u03BD\u03BF\u03C5");
		label_1.setBounds(10, 55, 172, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF \u03B5\u03C1\u03B3\u03B1\u03B6\u03BF\u03BC\u03AD\u03BD\u03BF\u03C5");
		label_2.setBounds(10, 86, 172, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u03A6\u03BF\u03C1\u03C4\u03AF\u03B1 \u03C4\u03C1\u03AD\u03C7\u03C9\u03BD \u03BC\u03AE\u03BD\u03B1");
		label_3.setBounds(10, 117, 172, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u03A6\u03BF\u03C1\u03C4\u03AF\u03B1 \u03C0\u03C1\u03BF\u03B7\u03B3\u03BF\u03CD\u03BC\u03B5\u03BD\u03BF\u03C5 \u03BC\u03AE\u03BD\u03B1");
		label_4.setBounds(10, 148, 172, 14);
		contentPane.add(label_4);
		
		JButton buttonNext = new JButton("-------->");
		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(rs.next()){
						
						String first = rs.getString("FirstName");
						
						
						
						textUsername.setText(first);
						
					}else{
						rs.previous();
						JOptionPane.showMessageDialog(Statistics.this, "End of File");
					}
				}catch(SQLException err){
					JOptionPane.showMessageDialog(Statistics.this, err.getMessage());
				}
			}
		});
		buttonNext.setBounds(93, 30, 89, 14);
		contentPane.add(buttonNext);
		
		JButton buttonPrev = new JButton("<--------");
		buttonPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(rs.previous()){
						
						String first = rs.getString("FirstName");
						textUsername.setText(first);
						
					}else{
						rs.next();
						JOptionPane.showMessageDialog(Statistics.this, "Start of File");
					}
				}catch(SQLException err){
					JOptionPane.showMessageDialog(Statistics.this, err.getMessage());
				}
			}
		});
		buttonPrev.setBounds(10, 30, 73, 14);
		contentPane.add(buttonPrev);
		
		JButton btnClear = new JButton("\u0395\u03BA\u03BA\u03B1\u03B8\u03AC\u03C1\u03B9\u03C3\u03B7");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.absolute(curRow);
					String first = rs.getString("FirstName");
					textUsername.setText(first);
					textOnoma.setText(" ");
					textEpitheto.setText(" ");
					textFortia1.setText(" ");
					textFortia2.setText(" ");
				} catch (SQLException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnClear.setBounds(335, 51, 117, 23);
		contentPane.add(btnClear);
		
		JButton btnBack = new JButton("\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Window) getRootPane().getParent()).dispose();
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setBounds(335, 114, 117, 51);
		contentPane.add(btnBack);
	
		DoConnect();
		
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
		String first1 = rs.getString("FirstName");
		System.out.println(first1);
		
		//Display them
		
		textUsername.setText(first1);
		
		t=true;
			
		}catch ( SQLException err){
			JOptionPane.showMessageDialog(Statistics.this, err.getMessage());
		}
		return t;
		}
}
