import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.mysql.jdbc.PreparedStatement;
import javax.swing.ScrollPaneConstants;


public class inventory_bin extends JFrame {

	private JPanel contentPane;
	private JTable inventorybintable;
	java.sql.Connection connection = null;
	private JPanel panel;
	private JComboBox comboBox;
	private JLabel label_smalltrayin;
	private JLabel label_mediumtrayin;
	private JLabel label_largetrayin;
	private JLabel label_extralargetrayin;
	private JLabel label_jumbotrayin;
	private JLabel label_monthtotal;
	private JLabel label_daytotal;
	private JLabel label_yeartotal;
	private JLabel label_traytotal;
	private JLabel label_eggtotal;
	private JLabel label_defecttotal;
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
	public void fillComboBox2() {
		try{
		comboBox.removeAllItems();
		String query = "select * from deletedinventory";
		PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			comboBox.addItem(rs.getString("Inventory No."));
			
		}
	} catch(Exception exc) {
		exc.printStackTrace();
	}
		}
	public void showdeletedinventory() {
		try{
			String query = "select * from deletedinventory";
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			inventorybintable.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public void initialize() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("deleteinvent.png")));
	}
	public inventory_bin() {
		super("Inventory bin");
		initialize();
		connection = SQLdriver3.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1415, 619);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(5, 5, 1386, 207);
		contentPane.add(scrollPane);
		
		inventorybintable = new JTable();
		inventorybintable.setForeground(Color.DARK_GRAY);
		scrollPane.setViewportView(inventorybintable);
		inventorybintable.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(7), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(667), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(1), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(2017), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(2), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(1998), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(9), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(12345), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(14), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(66345), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(10), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(345345), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(13), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(34), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(15), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(3423423), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(14), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(66390), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(19), new Integer(1530), new Integer(51), new Integer(0), "January", new Integer(1), new Integer(345345), new Integer(34), new Integer(5), new Integer(7), new Integer(0), new Integer(5)},
				{new Integer(19), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(54343), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(19), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(66332), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
			},
			new String[] {
				"Inventory No.", "Total No. of Eggs", "Total No. of Trays", "Total No. of Defects", "Month", "Day", "Year", "Small (Tray)", "Medium (Tray)", "Large (Tray)", "Extra Large (Tray)", "Jumbo (Tray)"
			}
		));
		inventorybintable.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(5, 225, 1386, 334);
		contentPane.add(panel);
		panel.setLayout(null);
		Image img2 = new ImageIcon(this.getClass().getResource("inventory-Management.png")).getImage();
		contentPane.setLayout(null);
		
		JLabel lblSmall = new JLabel("Small (Tray):");
		lblSmall.setForeground(Color.DARK_GRAY);
		lblSmall.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSmall.setHorizontalAlignment(SwingConstants.CENTER);
		lblSmall.setBounds(37, 13, 155, 36);
		panel.add(lblSmall);
		
		JLabel lblMediumtray = new JLabel("Medium (Tray):");
		lblMediumtray.setHorizontalAlignment(SwingConstants.CENTER);
		lblMediumtray.setForeground(Color.DARK_GRAY);
		lblMediumtray.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMediumtray.setBounds(37, 62, 155, 36);
		panel.add(lblMediumtray);
		
		JLabel lblLargetray = new JLabel("Large (Tray):");
		lblLargetray.setHorizontalAlignment(SwingConstants.CENTER);
		lblLargetray.setForeground(Color.DARK_GRAY);
		lblLargetray.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLargetray.setBounds(37, 111, 155, 36);
		panel.add(lblLargetray);
		
		JLabel lblExtraLargetray = new JLabel("Extra Large (Tray):");
		lblExtraLargetray.setHorizontalAlignment(SwingConstants.CENTER);
		lblExtraLargetray.setForeground(Color.DARK_GRAY);
		lblExtraLargetray.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExtraLargetray.setBounds(37, 160, 155, 36);
		panel.add(lblExtraLargetray);
		
		JLabel lblJumbotray = new JLabel("Jumbo (Tray):");
		lblJumbotray.setHorizontalAlignment(SwingConstants.CENTER);
		lblJumbotray.setForeground(Color.DARK_GRAY);
		lblJumbotray.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblJumbotray.setBounds(37, 205, 155, 36);
		panel.add(lblJumbotray);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setForeground(Color.DARK_GRAY);
		lblMonth.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMonth.setBounds(480, 17, 172, 36);
		panel.add(lblMonth);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay.setForeground(Color.DARK_GRAY);
		lblDay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDay.setBounds(480, 62, 172, 36);
		panel.add(lblDay);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setForeground(Color.DARK_GRAY);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYear.setBounds(480, 111, 172, 36);
		panel.add(lblYear);
		
		JLabel lblTotalNoOf = new JLabel("Total No. of Trays:");
		lblTotalNoOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalNoOf.setForeground(Color.DARK_GRAY);
		lblTotalNoOf.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalNoOf.setBounds(413, 268, 172, 36);
		panel.add(lblTotalNoOf);
		
		JLabel lblTotalNoOf_1 = new JLabel("Total No. of Eggs:");
		lblTotalNoOf_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalNoOf_1.setForeground(Color.DARK_GRAY);
		lblTotalNoOf_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalNoOf_1.setBounds(413, 219, 172, 36);
		panel.add(lblTotalNoOf_1);
		
		JLabel lblTotalNoOf_2 = new JLabel("Total No. of Defects:");
		lblTotalNoOf_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalNoOf_2.setForeground(Color.DARK_GRAY);
		lblTotalNoOf_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalNoOf_2.setBounds(413, 160, 172, 36);
		panel.add(lblTotalNoOf_2);
		
		JLabel lblInventoryNo = new JLabel("Inventory No.");
		lblInventoryNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventoryNo.setForeground(Color.DARK_GRAY);
		lblInventoryNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInventoryNo.setBounds(1122, 33, 200, 36);
		panel.add(lblInventoryNo);
		
		comboBox = new JComboBox();
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setBounds(1122, 93, 200, 36);
		panel.add(comboBox);
		
		label_smalltrayin = new JLabel("0");
		label_smalltrayin.setHorizontalAlignment(SwingConstants.CENTER);
		label_smalltrayin.setForeground(Color.DARK_GRAY);
		label_smalltrayin.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_smalltrayin.setBounds(195, 13, 155, 36);
		panel.add(label_smalltrayin);
		
		label_mediumtrayin = new JLabel("0");
		label_mediumtrayin.setHorizontalAlignment(SwingConstants.CENTER);
		label_mediumtrayin.setForeground(Color.DARK_GRAY);
		label_mediumtrayin.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_mediumtrayin.setBounds(195, 62, 155, 36);
		panel.add(label_mediumtrayin);
		
		label_largetrayin = new JLabel("0");
		label_largetrayin.setHorizontalAlignment(SwingConstants.CENTER);
		label_largetrayin.setForeground(Color.DARK_GRAY);
		label_largetrayin.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_largetrayin.setBounds(195, 111, 155, 36);
		panel.add(label_largetrayin);
		
		label_extralargetrayin = new JLabel("0");
		label_extralargetrayin.setHorizontalAlignment(SwingConstants.CENTER);
		label_extralargetrayin.setForeground(Color.DARK_GRAY);
		label_extralargetrayin.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_extralargetrayin.setBounds(195, 160, 155, 36);
		panel.add(label_extralargetrayin);
		
		label_jumbotrayin = new JLabel("0");
		label_jumbotrayin.setHorizontalAlignment(SwingConstants.CENTER);
		label_jumbotrayin.setForeground(Color.DARK_GRAY);
		label_jumbotrayin.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_jumbotrayin.setBounds(195, 209, 155, 36);
		panel.add(label_jumbotrayin);
		
		label_monthtotal = new JLabel("0");
		label_monthtotal.setHorizontalAlignment(SwingConstants.CENTER);
		label_monthtotal.setForeground(Color.DARK_GRAY);
		label_monthtotal.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_monthtotal.setBounds(664, 13, 155, 36);
		panel.add(label_monthtotal);
		
		label_daytotal = new JLabel("0");
		label_daytotal.setHorizontalAlignment(SwingConstants.CENTER);
		label_daytotal.setForeground(Color.DARK_GRAY);
		label_daytotal.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_daytotal.setBounds(664, 58, 155, 36);
		panel.add(label_daytotal);
		
		label_yeartotal = new JLabel("0");
		label_yeartotal.setHorizontalAlignment(SwingConstants.CENTER);
		label_yeartotal.setForeground(Color.DARK_GRAY);
		label_yeartotal.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_yeartotal.setBounds(664, 111, 155, 36);
		panel.add(label_yeartotal);
		
		label_traytotal = new JLabel("0");
		label_traytotal.setHorizontalAlignment(SwingConstants.CENTER);
		label_traytotal.setForeground(Color.DARK_GRAY);
		label_traytotal.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_traytotal.setBounds(664, 264, 155, 36);
		panel.add(label_traytotal);
		
		label_eggtotal = new JLabel("0");
		label_eggtotal.setHorizontalAlignment(SwingConstants.CENTER);
		label_eggtotal.setForeground(Color.DARK_GRAY);
		label_eggtotal.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_eggtotal.setBounds(664, 215, 155, 36);
		panel.add(label_eggtotal);
		
		label_defecttotal = new JLabel("0");
		label_defecttotal.setHorizontalAlignment(SwingConstants.CENTER);
		label_defecttotal.setForeground(Color.DARK_GRAY);
		label_defecttotal.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_defecttotal.setBounds(664, 160, 155, 36);
		panel.add(label_defecttotal);
		
		JButton btndeletetotal = new JButton("Delete");
		btndeletetotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query2 = " Delete from deletedinventory where `Inventory No.` ='" + comboBox.getSelectedItem() + " ' ";
					java.sql.PreparedStatement pst2 = connection.prepareStatement(query2);
					
					pst2.execute();
					
					JOptionPane.showMessageDialog(null,  "Inventory deleted PERMANENTLY!" );
					
					
					
					pst2.close();
					
					label_smalltrayin.setText("0");
					label_mediumtrayin.setText("0");
					label_largetrayin.setText("0");
					label_extralargetrayin.setText("0");
					label_jumbotrayin.setText("0");
					
					label_monthtotal.setText("0");
					label_daytotal.setText("0");
					label_yeartotal.setText("0");
					
					label_eggtotal.setText("0");
					label_defecttotal.setText("0");
					label_traytotal.setText("0");
				} catch (Exception exc) {
					exc.printStackTrace();
				}
				showdeletedinventory();
				fillComboBox2();
			}
		});
		btndeletetotal.setForeground(Color.DARK_GRAY);
		btndeletetotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		btndeletetotal.setBounds(1122, 173, 200, 46);
		panel.add(btndeletetotal);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(891, 24, 172, 172);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(img2));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(12, 13, 867, 308);
		panel.add(panel_1);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String query = "select * from deletedinventory where `Inventory No.`=?";
				PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
				pst.setString(1,  (String) comboBox.getSelectedItem());
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()){
					label_smalltrayin.setText(rs.getString("Small (Tray)"));
					label_mediumtrayin.setText(rs.getString("Medium (Tray)"));
					label_largetrayin.setText(rs.getString("Large (Tray)"));
					label_extralargetrayin.setText(rs.getString("Extra Large (Tray)"));
					label_jumbotrayin.setText(rs.getString("Jumbo (Tray)"));
					label_eggtotal.setText(rs.getString("Total No. of Eggs"));
					label_traytotal.setText(rs.getString("Total No. of Trays"));
					label_defecttotal.setText(rs.getString("Total No. of Defects"));
					label_monthtotal.setText(rs.getString("Month"));
					label_daytotal.setText(rs.getString("Day"));
					label_yeartotal.setText(rs.getString("Year"));
					
				}
			} catch(Exception exc) {
				exc.printStackTrace();
			}

			}
		});
		
		showdeletedinventory();
		
		JTableHeader adminHeader = inventorybintable.getTableHeader();
		adminHeader.setForeground(new Color(0).DARK_GRAY);
	    adminHeader.setBackground(new Color(0).LIGHT_GRAY);
	    adminHeader.setFont(new Font("Tahoma" , Font.BOLD, 15));
	    
	    fillComboBox2();
	}
}

