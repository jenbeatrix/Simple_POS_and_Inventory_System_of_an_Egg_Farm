import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;


public class customer_bin extends JFrame {

	private JPanel contentPane;
	private JTable customerbintable;
	java.sql.Connection connection = null;
	private JComboBox comboBox;
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
	public void fillComboBox2() {
		try{
		comboBox.removeAllItems();
		String query = "select * from deletedcustomer";
		PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			comboBox.addItem(rs.getString("Account No."));
			
		}
	} catch(Exception exc) {
		exc.printStackTrace();
	}
		}
	/**
	 * Create the frame.
	 */
	
	public void showdeletedcustomer() {
		try{
			String query = "select * from deletedcustomer";
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			customerbintable.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public void initialize() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("user_customer.png")));
	}
	
	public customer_bin() {
		super("Customer bin");
		initialize();
		connection = SQLdriver3.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1129, 523);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 703, 458);
		contentPane.add(scrollPane);
		
		
		
		customerbintable = new JTable();
		customerbintable.setForeground(Color.DARK_GRAY);
		scrollPane.setViewportView(customerbintable);
		customerbintable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Account No.", "First name", "Middle name", "Last name", "Contact No."
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		showdeletedcustomer();
		customerbintable.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(720, 5, 379, 458);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAccountNo = new JLabel("Account No.");
		lblAccountNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountNo.setForeground(Color.DARK_GRAY);
		lblAccountNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAccountNo.setBounds(12, 19, 178, 16);
		panel.add(lblAccountNo);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setForeground(Color.DARK_GRAY);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstName.setBounds(29, 218, 178, 16);
		panel.add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setForeground(Color.DARK_GRAY);
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMiddleName.setBounds(29, 267, 178, 16);
		panel.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setForeground(Color.DARK_GRAY);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastName.setBounds(29, 316, 178, 16);
		panel.add(lblLastName);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setForeground(Color.DARK_GRAY);
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContactNo.setBounds(29, 367, 178, 16);
		panel.add(lblContactNo);
		
		final JLabel lblNull_3 = new JLabel("NULL");
		lblNull_3.setForeground(Color.DARK_GRAY);
		lblNull_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNull_3.setBounds(177, 209, 178, 31);
		panel.add(lblNull_3);
		
		final JLabel lblNull_2 = new JLabel("NULL");
		lblNull_2.setForeground(Color.DARK_GRAY);
		lblNull_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNull_2.setBounds(177, 258, 178, 31);
		panel.add(lblNull_2);
		
		final JLabel lblNull_1 = new JLabel("NULL");
		lblNull_1.setForeground(Color.DARK_GRAY);
		lblNull_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNull_1.setBounds(177, 307, 178, 31);
		panel.add(lblNull_1);
		
		final JLabel lblNull = new JLabel("NULL");
		lblNull.setForeground(Color.DARK_GRAY);
		lblNull.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNull.setBounds(177, 358, 178, 31);
		panel.add(lblNull);
		Image img2 = new ImageIcon(this.getClass().getResource("person-icon.png")).getImage();
		contentPane.setLayout(null);
				
				comboBox = new JComboBox();
				comboBox.setBounds(181, 15, 186, 25);
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
						String query = "select * from deletedcustomer where `Account No.`=?";
						PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
						pst.setString(1,  (String) comboBox.getSelectedItem());
						ResultSet rs = pst.executeQuery();
						
						while(rs.next()){
							lblNull_3.setText(rs.getString("First name"));
							lblNull_2.setText(rs.getString("Middle name"));
							lblNull_1.setText(rs.getString("Last name"));
							lblNull.setText(rs.getString("Contact No."));
						}
					} catch(Exception exc) {
						exc.printStackTrace();
					}
					}
				});
				comboBox.setForeground(Color.DARK_GRAY);
				comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
				panel.add(comboBox);
				
				JButton btndelete = new JButton("DELETE");
				btndelete.setForeground(Color.DARK_GRAY);
				btndelete.setFont(new Font("Tahoma", Font.BOLD, 15));
				btndelete.setBounds(106, 420, 186, 25);
				btndelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
							
							String query2 = " Delete from deletedcustomer where `Account No.` ='" + comboBox.getSelectedItem() + " ' ";
							java.sql.PreparedStatement pst2 = connection.prepareStatement(query2);
							
							pst2.execute();
							
							
							JOptionPane.showMessageDialog(null,  "Customer has been deleted PERMANENTLY");
							
							pst2.close();
							comboBox.removeItemAt(comboBox.getSelectedIndex());
							
							lblNull_3.setText("");
							lblNull_2.setText("");
							lblNull_1.setText("");
							lblNull.setText("");
							
							
						} catch (Exception exc) {
							exc.printStackTrace();
						}
						
						showdeletedcustomer();
					}
					
				});
				panel.add(btndelete);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBounds(116, 48, 176, 157);
				panel.add(lblNewLabel);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setIcon(new ImageIcon(img2));
				
				
				
		
		
		JTableHeader adminHeader = customerbintable.getTableHeader();
		adminHeader.setForeground(new Color(0).DARK_GRAY);
	    adminHeader.setBackground(new Color(0).LIGHT_GRAY);
	    adminHeader.setFont(new Font("Tahoma" , Font.BOLD, 15));
	    
	    fillComboBox2();
	}
}
