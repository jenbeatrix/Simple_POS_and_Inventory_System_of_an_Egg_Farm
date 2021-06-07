import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class confirm_window2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_user;
	private JPasswordField passwordField;
	java.sql.Connection connection = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					confirm_window frame = new confirm_window();
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
	
	public void close() {
		WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
}
	public void initialize() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("confirmicon.png")));
	}
	public confirm_window2() {
		super("Confirm user");
		initialize();
		connection = SQLdriver3.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 296);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(12, 13, 561, 223);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(208, 34, 134, 25);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(208, 86, 134, 25);
		panel.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(20, 13, 176, 157);
		panel.add(lblNewLabel);
		Image img2 = new ImageIcon(this.getClass().getResource("person-icon.png")).getImage();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(img2));
		
		
		textField_user = new JTextField();
		textField_user.setForeground(Color.DARK_GRAY);
		textField_user.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_user.setBounds(379, 33, 155, 32);
		textField_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					String query = "select * from login_table where Username = ? and Password = ? ";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField_user.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()) {
						count = count+1;
					}
					if (count ==1) {
						JOptionPane.showMessageDialog(null, "Account Confirmed!");
						close();
						customer_bin w = new customer_bin();
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
		panel.add(textField_user);
		textField_user.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(379, 85, 155, 32);
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					String query = "select * from login_table where Username = ? and Password = ? ";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField_user.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()) {
						count = count+1;
					}
					if (count ==1) {
						JOptionPane.showMessageDialog(null, "Account Confirmed!");
						close();
						customer_bin w = new customer_bin();
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
		panel.add(passwordField);
		
		JButton btnconfirm = new JButton("Confirm");
		btnconfirm.setForeground(Color.DARK_GRAY);
		btnconfirm.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnconfirm.setBounds(280, 147, 164, 41);
		btnconfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					String query = "select * from login_table where Username = ? and Password = ? ";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField_user.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()) {
						count = count+1;
					}
					if (count ==1) {
						JOptionPane.showMessageDialog(null, "Account Confirmed!");
						close();
						customer_bin w = new customer_bin();
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
		panel.add(btnconfirm);
	}
}
