import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import com.mysql.jdbc.PreparedStatement;


public class Admin_list extends JFrame {

	private JPanel contentPane;
	private JTable admintable;
	java.sql.Connection connection = null;
	private JTextArea textArea_update;
	private JLabel lblUsername;
	private JLabel lblFirstName;
	private JLabel lblMiddleName;
	private JLabel lblLastName;
	private JLabel label_firstname;
	private JLabel label_middlename;
	private JLabel label_lastname;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JComboBox comboBox_username;
	String output;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_list frame = new Admin_list();
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
	public void showadmin() {
		try{
			String query = "select `Username` , `First name`, `Middle name`, `Last name` from login_table";
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			admintable.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public void fillComboBox2() {
		try{
		comboBox_username.removeAllItems();
		String query = "select * from login_table";
		PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			comboBox_username.addItem(rs.getString("Username"));
			
		}
	} catch(Exception exc) {
		exc.printStackTrace();
	}
	}
	
	public void initialize() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("loginicon.png")));
	}
	
	public Admin_list() {
		super("Administrator's list");
		initialize();
		connection = SQLdriver3.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 943, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 908, 141);
		contentPane.add(scrollPane);
		
		admintable = new JTable();
		admintable.setForeground(Color.DARK_GRAY);
		scrollPane.setViewportView(admintable);
		admintable.setModel(new DefaultTableModel(
			new Object[][] {
				{"aivan", "Jan", "Vieva", "Maristela"},
				{"jbdmaristela", "Jenny", "Beatrix", "Maristela"},
				{"niclabios", "Nolf", "Ivan", "Labios"},
			},
			new String[] {
				"Username", "First name", "Middle name", "Last name"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		admintable.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(15, 159, 898, 334);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textArea_update = new JTextArea();
		textArea_update.setEditable(false);
		textArea_update.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea_update.setBounds(457, 13, 429, 297);
		panel.add(textArea_update);
		
		comboBox_username = new JComboBox();
		comboBox_username.setBounds(10, 52, 200, 29);
		comboBox_username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String query = "select * from login_table where `Username`=?";
				PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
				pst.setString(1,  (String) comboBox_username.getSelectedItem());
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()){
					passwordField.setText(rs.getString("Password"));
					label_firstname.setText(rs.getString("First name"));
					label_middlename.setText(rs.getString("Middle name"));
					label_lastname.setText(rs.getString("Last name"));
				}
			} catch(Exception exc) {
				exc.printStackTrace();
			}
			}
		});
		panel.add(comboBox_username);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 6, 200, 35);
		panel.add(lblUsername);
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblFirstName = new JLabel("First name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setForeground(Color.DARK_GRAY);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstName.setBounds(10, 100, 200, 35);
		panel.add(lblFirstName);
		
		lblMiddleName = new JLabel("Middle name:");
		lblMiddleName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiddleName.setForeground(Color.DARK_GRAY);
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiddleName.setBounds(10, 159, 200, 35);
		panel.add(lblMiddleName);
		
		lblLastName = new JLabel("Last name:");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setForeground(Color.DARK_GRAY);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(10, 212, 200, 35);
		panel.add(lblLastName);
		
		label_firstname = new JLabel("NULL");
		label_firstname.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_firstname.setHorizontalAlignment(SwingConstants.CENTER);
		label_firstname.setBounds(172, 92, 200, 50);
		panel.add(label_firstname);
		
		label_middlename = new JLabel("NULL");
		label_middlename.setHorizontalAlignment(SwingConstants.CENTER);
		label_middlename.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_middlename.setBounds(172, 148, 200, 50);
		panel.add(label_middlename);
		
		label_lastname = new JLabel("NULL");
		label_lastname.setHorizontalAlignment(SwingConstants.CENTER);
		label_lastname.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_lastname.setBounds(172, 202, 200, 50);
		panel.add(label_lastname);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(270, 6, 168, 35);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBounds(270, 51, 168, 29);
		panel.add(passwordField);
		
		JButton btndelete = new JButton("DELETE");
		btndelete.setForeground(Color.DARK_GRAY);
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btndelete.setBounds(130, 265, 168, 41);
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?");
				
				if (confirm == JOptionPane.CANCEL_OPTION) {
					return;
				}
				
				if (confirm == JOptionPane.YES_OPTION) { 
				try{
					
					String query2 = " Delete from login_table where `Username` ='" + comboBox_username.getSelectedItem() + " ' ";
					java.sql.PreparedStatement pst2 = connection.prepareStatement(query2);
					
					pst2.execute();
					
					
					JOptionPane.showMessageDialog(null,  "Customer has been deleted PERMANENTLY");
					
					output = "Username " + comboBox_username.getSelectedItem() + " has been deleted. \n";
					textArea_update.append(output);

					
					pst2.close();
					comboBox_username.removeItemAt(comboBox_username.getSelectedIndex());
					showadmin();
				} catch (Exception exc) {
					exc.printStackTrace();
					JOptionPane.showMessageDialog(null, "Select a Username in JComboBox Again. Remember not to Change Values.");
				}
				
			
			} else if (confirm == JOptionPane.NO_OPTION) {
				return;
			}
			}	
		});
		
		 
		
		panel.add(btndelete);
		
		
		JTableHeader adminHeader = admintable.getTableHeader();
		adminHeader.setForeground(new Color(0).DARK_GRAY);
	    adminHeader.setBackground(new Color(0).LIGHT_GRAY);
	    adminHeader.setFont(new Font("Tahoma" , Font.BOLD, 15));
	    
	    fillComboBox2();
	    showadmin();
	}
}
