import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Login_window extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	java.sql.Connection connection=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_window frame = new Login_window();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
public void close() {
		WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
}
	
public void initialize() {
	this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("loginicon.png")));
}
	/**
	 * Create the frame.
	 */
	public Login_window() {
		super("Login");
		initialize();
		connection = SQLdriver3.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 371);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGoldenNatureFarm = new JLabel("Golden Nature Farm");
		lblGoldenNatureFarm.setForeground(Color.DARK_GRAY);
		lblGoldenNatureFarm.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblGoldenNatureFarm.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoldenNatureFarm.setBounds(138, 36, 336, 51);
		contentPane.add(lblGoldenNatureFarm);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(222, 131, 132, 32);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(222, 194, 132, 32);
		contentPane.add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.BOLD, 15));
		usernameField.setBounds(366, 134, 205, 32);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBounds(366, 197, 205, 32);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					String query = "select * from login_table where Username = ? and Password = ? ";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, usernameField.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()) {
						count = count+1;
					}
					if (count ==1) {
						JOptionPane.showMessageDialog(null, "You have been Login Successfully!");
						close();
						Welcome_window w = new Welcome_window();
						w.setVisible(true);
					}	
						else {
							JOptionPane.showMessageDialog(null, "Username or password is incorrect. Please try again.");
						}
						
					
					} catch (Exception exc) {
						exc.printStackTrace();
					}
			}
		});
					
		
			
			usernameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					String query = "select * from login_table where Username = ? and Password = ? ";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, usernameField.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()) {
						count = count+1;
					}
					if (count ==1) {
						JOptionPane.showMessageDialog(null, "You have been Login Successfully!");
						close();
						Welcome_window w = new Welcome_window();
						w.setVisible(true);
					}	
						else {
							JOptionPane.showMessageDialog(null, "Username and password is incorrect. Please try again.");
						}
						
					
					} catch (Exception exc) {
						exc.printStackTrace();
					}
			}
			});
			

				
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					String query = "select * from login_table where Username = ? and Password = ? ";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, usernameField.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()) {
						count = count+1;
					}
					if (count ==1) {
						JOptionPane.showMessageDialog(null, "You have Login Successfully!");
						close();
						Welcome_window w = new Welcome_window();
						w.setVisible(true);
					}	
						else {
							JOptionPane.showMessageDialog(null, "Username and password is incorrect. Please try again.");
						}
						
					
					} catch (Exception exc) {
						exc.printStackTrace();
					}
			}
			});
		
		
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(232, 260, 144, 51);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("person-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(23, 36, 254, 255);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("egg-flat.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(347, 36, 265, 256);
		contentPane.add(lblNewLabel_1);
		
	}
	
	}

