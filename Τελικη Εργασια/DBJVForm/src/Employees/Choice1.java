package Employees;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Window;

public class Choice1 extends JFrame {

	private JPanel contentPane;

	public Choice1(String s) {
		setTitle("\u0395\u03C0\u03B9\u03BB\u03BF\u03B3\u03AE \u0394\u03B9\u03B1\u03C7\u03B5\u03B9\u03C1\u03B9\u03C3\u03C4\u03AE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 272, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u039A\u03B1\u03C4\u03AC\u03C3\u03C4\u03B1\u03C3\u03B7 \u039F\u03B4\u03B7\u03B3\u03CE\u03BD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Workers frame1 = new Workers();
					frame1.setVisible(true);
					
					
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
		button.setBounds(10, 31, 235, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u039A\u03B1\u03C4\u03B1\u03C3\u03C4\u03B1\u03C3\u03B7 \u03A6\u03BF\u03C1\u03C4\u03B7\u03B3\u03CE\u03BD");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Vehicle frame = new Vehicle();
					frame.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button_1.setBounds(10, 65, 235, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u03A3\u03C4\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03B1 \u0395\u03C0\u03B9\u03C7\u03B5\u03B9\u03C1\u03B7\u03C3\u03B7\u03C2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Statistics frame1 = new Statistics();
					frame1.setVisible(true);
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
		button_2.setBounds(10, 99, 235, 23);
		contentPane.add(button_2);
		
		JLabel lblNewLabel = new JLabel("'Εχετε συνδεθεί ως: "+s);
		lblNewLabel.setBackground(new Color(51, 102, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 235, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Window) getRootPane().getParent()).dispose();
				JOptionPane.showMessageDialog(Choice1.this, "Αποσύνδεση απο το Σύστημα");
				
			}
		});
		btnLogOut.setBounds(10, 146, 159, 23);
		contentPane.add(btnLogOut);
	}
}
