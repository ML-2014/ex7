package Employees;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

public class Choice2 extends JFrame {

	private JPanel contentPane;

	public Choice2(String s) {
		setTitle("\u0395\u03C0\u03B9\u03BB\u03BF\u03B3\u03AD\u03C2 \u03A5\u03C0\u03B1\u03BB\u03BB\u03AE\u03BB\u03C9\u03BD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 272, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u039A\u03B1\u03C4\u03AC\u03C3\u03C4\u03B1\u03C3\u03B7 \u039F\u03B4\u03B7\u03B3\u03CE\u03BD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Workers frame1 = new Workers();
					frame1.setVisible(true);
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 45, 235, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u039A\u03B1\u03C4\u03AC\u03C3\u03C4\u03B1\u03C3\u03B7 \u039F\u03C7\u03B7\u03BC\u03AC\u03C4\u03C9\u03BD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Vehicle frame = new Vehicle();
					frame.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(10, 79, 235, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("'Εχετε συνδεθεί ως: "+s);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 235, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Window) getRootPane().getParent()).dispose();
				JOptionPane.showMessageDialog(Choice2.this, "Αποσύνδεση απο το Σύστημα");
			}
		});
		btnLogOut.setBounds(10, 147, 159, 23);
		contentPane.add(btnLogOut);
		
		JButton btnNewButton_2 = new JButton("\u0391\u03BD\u03B5\u03C6\u03BF\u03B4\u03B9\u03B1\u03C3\u03BC\u03BF\u03AF");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fill frame = new Fill();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(10, 113, 235, 23);
		contentPane.add(btnNewButton_2);
	}

}
