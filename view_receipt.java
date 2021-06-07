import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class view_receipt extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	java.sql.Connection connection = null;
	private JLabel lblNull, lblNull_1, lblNull_2, lblNull_3, lblNull_4, lblNull_5, lblNull_6, lblNull_7, lblNull_8, lblNull_9, lblNull_10, lblNull_11, lblNull_12;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_receipt frame = new view_receipt();
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
		String query = "select * from orders_costumers";
		PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			comboBox.addItem(rs.getString("Receipt No."));
			
		}
	} catch(Exception exc) {
		exc.printStackTrace();
	}
	}
	/**
	 * Create the frame.
	 */
	public void initialize() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("receipt.png")));
	}
	
	public view_receipt() {
		super("View receipt");
		initialize();
		connection = SQLdriver3.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 772, 931);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(12, 275, 730, 558);
		contentPane.add(panel);
		panel.setLayout(null);
		Image img2 = new ImageIcon(this.getClass().getResource("moneyicon.png")).getImage();
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		comboBox.setBounds(12, 68, 152, 32);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String query = "select * from orders_costumers where `Receipt No.`=?";
				PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
				pst.setString(1,  (String) comboBox.getSelectedItem());
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()){
					lblNull.setText(rs.getString("Small (Tray)"));
					lblNull_1.setText(rs.getString("Medium (Tray)"));
					lblNull_2.setText(rs.getString("Large (Tray)"));
					lblNull_3.setText(rs.getString("ExtraLarge (Tray)"));
					lblNull_4.setText(rs.getString("Jumbo (Tray)"));
					lblNull_5.setText(rs.getString("Small (Tray) Amount"));
					lblNull_6.setText(rs.getString("Medium (Tray) Amount"));
					lblNull_7.setText(rs.getString("Large (Tray) Amount"));
					lblNull_8.setText(rs.getString("Extra Large (Tray) Amount"));
					lblNull_9.setText(rs.getString("Jumbo (Tray) Amount"));
					lblNull_11.setText(rs.getString("Tray Total Amount"));
					lblNull_12.setText(rs.getString("Customer ID"));
					
				}
			} catch(Exception exc) {
				exc.printStackTrace();
			}
			}
		});
		panel.add(comboBox);
		
		JLabel lblReceiptNo = new JLabel("Receipt No.");
		lblReceiptNo.setForeground(Color.DARK_GRAY);
		lblReceiptNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceiptNo.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblReceiptNo.setBounds(12, 13, 152, 25);
		panel.add(lblReceiptNo);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setForeground(Color.DARK_GRAY);
		lblQuantity.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblQuantity.setBounds(270, 101, 129, 25);
		panel.add(lblQuantity);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setForeground(Color.DARK_GRAY);
		lblTotalPrice.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblTotalPrice.setBounds(477, 101, 191, 25);
		panel.add(lblTotalPrice);
		
		JLabel lblSmall = new JLabel("Small (Tray)");
		lblSmall.setForeground(Color.DARK_GRAY);
		lblSmall.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblSmall.setBounds(12, 162, 193, 25);
		panel.add(lblSmall);
		
		JLabel lblMedium = new JLabel("Medium (Tray)");
		lblMedium.setForeground(Color.DARK_GRAY);
		lblMedium.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblMedium.setBounds(12, 214, 193, 25);
		panel.add(lblMedium);
		
		JLabel lblLarge = new JLabel("Large (Tray)");
		lblLarge.setForeground(Color.DARK_GRAY);
		lblLarge.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblLarge.setBounds(12, 270, 193, 25);
		panel.add(lblLarge);
		
		JLabel lblExtraLarge = new JLabel("Extra Large (Tray)");
		lblExtraLarge.setForeground(Color.DARK_GRAY);
		lblExtraLarge.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblExtraLarge.setBounds(12, 331, 226, 25);
		panel.add(lblExtraLarge);
		
		JLabel lblJumbo = new JLabel("Jumbo (Tray)");
		lblJumbo.setForeground(Color.DARK_GRAY);
		lblJumbo.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblJumbo.setBounds(12, 391, 193, 25);
		panel.add(lblJumbo);
		
		lblNull = new JLabel("NULL");
		lblNull.setForeground(Color.DARK_GRAY);
		lblNull.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNull.setBounds(270, 162, 193, 25);
		panel.add(lblNull);
		
		lblNull_1 = new JLabel("NULL");
		lblNull_1.setForeground(Color.DARK_GRAY);
		lblNull_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNull_1.setBounds(270, 214, 193, 25);
		panel.add(lblNull_1);
		
		lblNull_2 = new JLabel("NULL");
		lblNull_2.setForeground(Color.DARK_GRAY);
		lblNull_2.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNull_2.setBounds(270, 270, 193, 25);
		panel.add(lblNull_2);
		
		lblNull_3 = new JLabel("NULL");
		lblNull_3.setForeground(Color.DARK_GRAY);
		lblNull_3.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNull_3.setBounds(270, 331, 193, 25);
		panel.add(lblNull_3);
		
		lblNull_4 = new JLabel("NULL");
		lblNull_4.setForeground(Color.DARK_GRAY);
		lblNull_4.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNull_4.setBounds(270, 391, 193, 25);
		panel.add(lblNull_4);
		
		lblNull_5 = new JLabel("NULL");
		lblNull_5.setForeground(Color.DARK_GRAY);
		lblNull_5.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNull_5.setBounds(510, 162, 193, 25);
		panel.add(lblNull_5);
		
		lblNull_6 = new JLabel("NULL");
		lblNull_6.setForeground(Color.DARK_GRAY);
		lblNull_6.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNull_6.setBounds(510, 214, 193, 25);
		panel.add(lblNull_6);
		
		lblNull_7 = new JLabel("NULL");
		lblNull_7.setForeground(Color.DARK_GRAY);
		lblNull_7.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNull_7.setBounds(510, 270, 193, 25);
		panel.add(lblNull_7);
		
		lblNull_8 = new JLabel("NULL");
		lblNull_8.setForeground(Color.DARK_GRAY);
		lblNull_8.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNull_8.setBounds(510, 331, 193, 25);
		panel.add(lblNull_8);
		
		lblNull_9 = new JLabel("NULL");
		lblNull_9.setForeground(Color.DARK_GRAY);
		lblNull_9.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNull_9.setBounds(510, 391, 193, 25);
		panel.add(lblNull_9);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setForeground(Color.DARK_GRAY);
		lblTotal.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblTotal.setBounds(12, 447, 193, 25);
		panel.add(lblTotal);
		
		lblNull_10 = new JLabel("");
		lblNull_10.setForeground(Color.DARK_GRAY);
		lblNull_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNull_10.setBounds(217, 458, 193, 25);
		panel.add(lblNull_10);
		
		lblNull_11 = new JLabel("NULL");
		lblNull_11.setForeground(Color.DARK_GRAY);
		lblNull_11.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNull_11.setBounds(512, 458, 193, 25);
		panel.add(lblNull_11);
		
		JButton btnNewButton = new JButton("Calculate Total Quantity");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String smalltray = lblNull.getText();
				int answer1 = Integer.parseInt(smalltray);
				String change1 = String.valueOf(answer1);
	
				String mediumtray = lblNull_1.getText();
				int answer2 = Integer.parseInt(mediumtray);
				String change2 = String.valueOf(answer2);
				
				String largetray = lblNull_2.getText();
				int answer3 = Integer.parseInt(largetray);
				String change3 = String.valueOf(answer3);
	
				String extralargetray = lblNull_3.getText();
				int answer4 = Integer.parseInt(extralargetray);
				String change4 = String.valueOf(answer4);
				
				String jumbotray = lblNull_4.getText();
				int answer5 = Integer.parseInt(jumbotray);
				String change5 = String.valueOf(answer5);
				
				int total = answer1 + answer2 + answer3 +answer4 + answer5;
				String changetotal = String.valueOf(total);
				lblNull_10.setText(changetotal);
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		btnNewButton.setBounds(150, 496, 329, 25);
		panel.add(btnNewButton);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerId.setForeground(Color.DARK_GRAY);
		lblCustomerId.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblCustomerId.setBounds(313, 13, 150, 25);
		panel.add(lblCustomerId);
		
		lblNull_12 = new JLabel("NULL");
		lblNull_12.setForeground(Color.DARK_GRAY);
		lblNull_12.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNull_12.setBounds(490, 13, 213, 25);
		panel.add(lblNull_12);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(536, 846, 152, 25);
		contentPane.add(btnOk);
		btnOk.setForeground(Color.DARK_GRAY);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, 0, 248, 258);
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(img2));
		
		JTextArea txtrGoldenNatureFarm = new JTextArea();
		txtrGoldenNatureFarm.setEditable(false);
		txtrGoldenNatureFarm.setText("GOLDEN NATURE FARM RECEIPT\r\nLINGIG, SURIGAO DEL SUR, PHILIPPINES\r\n09155306843 - Kathleen Balbuena\r\n09126555181 - Phil Balbuena\r\n09501460109 - Sherryl Balbuena");
		txtrGoldenNatureFarm.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtrGoldenNatureFarm.setBounds(295, 13, 447, 227);
		contentPane.add(txtrGoldenNatureFarm);
		
		fillComboBox2();
	}
}
