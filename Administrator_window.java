import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;


public class Administrator_window extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JTextField textField_password;
	private JTextField textField_firstname;
	private JTextField textField_middlename;
	private JTextField textField_lastname;

	/**
	 * Launch the application.
	 */
	
	public void close() {
		WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator_window frame = new Administrator_window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void initialize() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("add.png")));
	}
	/**
	 * Create the frame.
	 */
	java.sql.Connection connection=null;
	public Administrator_window() {
		super("New Administrator");
		initialize();
		connection = SQLdriver3.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 840, 548);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(12, 13, 798, 96);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRegisterAsNew = new JLabel("REGISTER AS NEW ADMINISTRATOR");
		lblRegisterAsNew.setForeground(Color.DARK_GRAY);
		lblRegisterAsNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterAsNew.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblRegisterAsNew.setBounds(43, 13, 703, 70);
		panel.add(lblRegisterAsNew);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(40, 154, 113, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(40, 215, 113, 34);
		contentPane.add(lblPassword);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setForeground(Color.DARK_GRAY);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFirstName.setBounds(40, 277, 145, 34);
		contentPane.add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle name:");
		lblMiddleName.setForeground(Color.DARK_GRAY);
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMiddleName.setBounds(40, 343, 145, 34);
		contentPane.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setForeground(Color.DARK_GRAY);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastName.setBounds(40, 406, 145, 34);
		contentPane.add(lblLastName);
		
		textField_username = new JTextField();
		textField_username.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_username.setBounds(230, 159, 186, 31);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		textField_password = new JPasswordField();
		textField_password.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_password.setColumns(10);
		textField_password.setBounds(230, 224, 186, 31);
		contentPane.add(textField_password);
		
		textField_firstname = new JTextField();
		textField_firstname.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_firstname.setColumns(10);
		textField_firstname.setBounds(230, 286, 186, 31);
		contentPane.add(textField_firstname);
		
		textField_middlename = new JTextField();
		textField_middlename.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_middlename.setColumns(10);
		textField_middlename.setBounds(230, 352, 186, 31);
		contentPane.add(textField_middlename);
		
		textField_lastname = new JTextField();
		textField_lastname.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_lastname.setColumns(10);
		textField_lastname.setBounds(230, 415, 186, 31);
		contentPane.add(textField_lastname);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("icon-1.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(390, 108, 386, 393);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					int confirm = JOptionPane.showConfirmDialog(null, "Username: " + textField_username.getText() + "\nPassword: " + textField_password.getText() + "\nFirst name: " + textField_firstname.getText() + "\nMiddle name: " + textField_middlename.getText() + "\nLast name: " + textField_lastname.getText() , "Confirmation of account", JOptionPane.YES_NO_CANCEL_OPTION);
					
					if (confirm == JOptionPane.CANCEL_OPTION) {
						return;
					}
					if (confirm == JOptionPane.YES_OPTION) { 
						try {
						String query = "INSERT INTO login_table(`Username`, `Password` , `First name`, `Middle name`, `Last name`) VALUES (? ,?, ? ,?, ?)";
						java.sql.PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1, textField_username.getText());
						pst.setString(2, textField_password.getText());
						pst.setString(3, textField_firstname.getText());
						pst.setString(4, textField_middlename.getText());
						pst.setString(5, textField_lastname.getText());
						
						if(textField_username.getText().equals("")) {
							JOptionPane.showMessageDialog(null,  "Input Username.");
						}
						
						if(textField_password.getText().equals("")) {
							JOptionPane.showMessageDialog(null,  "Input Password.");
						}
						
						if(textField_firstname.getText().equals("")) {
							JOptionPane.showMessageDialog(null,  "Input First name.");
						}
						
						if(textField_middlename.getText().equals("")) {
							JOptionPane.showMessageDialog(null,  "Input Middle name.");
						}
						
						if(textField_lastname.getText().equals("")) {
							JOptionPane.showMessageDialog(null,  "Input Last name.");
						}
						pst.execute();
						
						JOptionPane.showMessageDialog(null,  "You have registered successfully!");
						
						pst.close();
						
						
					} catch (Exception exc) {
						exc.printStackTrace();
						JOptionPane.showMessageDialog(null,  "Cannot duplicate Username");
					}
					}
					else if (confirm == JOptionPane.NO_OPTION) {
						return;
					}
					
					
					
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(197, 459, 181, 25);
		contentPane.add(btnNewButton);
	}
}



