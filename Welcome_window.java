import java.awt.BorderLayout;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.ScrollPane;
import java.awt.Point;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.GridLayout;
import javax.swing.JMenuItem;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
public class Welcome_window extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable Inventorytable;
	private JComboBox comboBox_accountnum;
	private JComboBox comboBox_invent;
	private JComboBox comboBox_receipt;
	private JComboBox comboBox_searchinvent;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		Date currentdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyy hh:mm:ss");
		sdf.format(currentdate);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome_window frame = new Welcome_window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
	}

	public void fillComboBox() {
		try{
		comboBox_accountnum.removeAllItems();
		String query = "select * from list_costumers";
		PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			comboBox_accountnum.addItem(rs.getString("Account No."));
		}
	} catch(Exception exc) {
		exc.printStackTrace();
	}
		}
	
	public void refreshcombobox() {
		
	}
	public void fillComboBox2() {
		try{
		comboBox_invent.removeAllItems();
		String query = "select * from egg_inventory";
		PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			comboBox_invent.addItem(rs.getString("Inventory No."));
			
		}
	} catch(Exception exc) {
		exc.printStackTrace();
	}
		}
	public void fillComboBox3() {
		try{
		comboBox_receipt.removeAllItems();
		String query = "select * from orders_costumers";
		PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			comboBox_receipt.addItem(rs.getString("Receipt No."));
			
		}
	} catch(Exception exc) {
		exc.printStackTrace();
	}
		}
	
	public void close() {
		WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
	}
	/**
	 * Create the frame.
	 */
	
	
	java.sql.Connection connection=null;
	private JTable customertable;
	private JTable tabletotalegginventory;
	private JTextField textField_totalnoeggs;
	private JTextField textField_totalnotrays;
	private JTextField textField_totalnodefects;
	private JTextField textField_firstname;
	private JTextField textField_middlename;
	private JTextField textField_lastname;
	private JTextField textField_contactnum;
	private JTextField textField_traytotalam;
	private JTextField textField_smalleggam;
	private JTextField textField_mediumeggam;
	private JTextField textField_largeeggam;
	private JTextField textField_extralargeeggam;
	private JTextField textField_jumboeggam;
	private JTextField textField_smalltrayin;
	private JTextField textField_mediumtrayin;
	private JTextField textField_largetrayin;
	private JTextField textField_extralargetrayin;
	private JTextField textField_jumbotrayin;
	private DecimalFormat two;
	private JTable customereggstable;
	private JTextField textField_smalltray;
	private JTextField textField_mediumtray;
	private JTextField textField_largetray;
	private JTextField textField_extralargetray;
	private JTextField textField_jumbotray;
	private JTextField textField_yeartotal;
	private JTextField textField_searchfirstname;
	private JTextField textField_searchmiddlename;
	private JTextField textField_searchlastname;
	int recieptno;
	int accountno;
	String stringreciept;
	String stringaccount;
	int inventoryno;
	String stringinvent;
	private JTextField textField_searchinvent;
	private JTextField textField_searchmonth;
	private JTextField textField_searchday;
	private JTextField textField_searchyear;
	
	public void showcustomers() {
		try{
			String query = "select * from list_costumers";
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			customertable.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public void showinventory() {
		try{
			String query = "select * from egg_inventory";
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tabletotalegginventory.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch(Exception e) {
		e.printStackTrace();
	}
	}
	public void showorders() {
		try{
			String query = "select `Receipt No.`, `Small (Tray)`, `Medium (Tray)`, `Large (Tray)`, `ExtraLarge (Tray)`, `Jumbo (Tray)` , `Tray Total Amount` from orders_costumers";
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			customereggstable.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public void initialize() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("eggicon.png")));
	}
	public Welcome_window() {
		super("Golden Nature Farm"); 
		initialize();
		connection = SQLdriver3.dbConnector();
		setForeground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1939, 833);
		final DecimalFormat two = new DecimalFormat("#,##0.00");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnFile = new JMenu("New");
		menuBar.add(mnFile);
		
		JMenu mnRegister = new JMenu("Register");
		mnFile.add(mnRegister);
		
		JMenuItem mntmNewAdministrator = new JMenuItem("New Administrator");
		mntmNewAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirm_window4 a = new confirm_window4();
				a.setVisible(true);
				
				
			}
		});
		mnRegister.add(mntmNewAdministrator);
		
		JMenu menuOptions = new JMenu("Options");
		menuBar.add(menuOptions);
		
		JMenuItem mntmSignOut = new JMenuItem("Sign Out");
		mntmSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
						int signout = JOptionPane.showConfirmDialog(null, "Do you really want to Sign out?" , "Signing out", JOptionPane.YES_NO_CANCEL_OPTION);
						
						if (signout == JOptionPane.CANCEL_OPTION) {
							return;
						}
						if (signout == JOptionPane.YES_OPTION) { 
							Login_window w = new Login_window();
							w.setVisible(true);
							close();
							
						}
						else if (signout == JOptionPane.NO_OPTION) {
							return;
						}
			
					
				}
			
		});
		menuOptions.add(mntmSignOut);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmListOfAdministrators = new JMenuItem("List of Administrators");
		mntmListOfAdministrators.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirm_window a = new confirm_window();
				a.setVisible(true);
			}
		});
		mnView.add(mntmListOfAdministrators);
		
		JMenuItem mntmCustomerBin = new JMenuItem("Customer Bin");
		mntmCustomerBin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirm_window2 c = new confirm_window2();
				c.setVisible(true);
				
			}
		});
		mnView.add(mntmCustomerBin);
		
		JMenuItem mntmInventoryBin = new JMenuItem("Inventory Bin");
		mntmInventoryBin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirm_window3 i = new confirm_window3();
				i.setVisible(true);
			}
		});
		mnView.add(mntmInventoryBin);
		
		JMenu mnNewMenu = new JMenu("Help");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Program instructions");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Help_window h = new Help_window();
				h.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane_inventorysystem = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_inventorysystem.setBackground(Color.LIGHT_GRAY);
		tabbedPane_inventorysystem.setBounds(12, 0, 1890, 747);
		contentPane.add(tabbedPane_inventorysystem);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setPreferredSize(new Dimension(0, 0));
		
		
		
		JTabbedPane systemtabbedPanepos = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_inventorysystem.addTab("Point of Sales System", null, systemtabbedPanepos, null);
		systemtabbedPanepos.setBackground(Color.LIGHT_GRAY);
				
				Panel panelcustomers = new Panel();
				systemtabbedPanepos.addTab("Customers' List", null, panelcustomers, null);
				panelcustomers.setBackground(Color.ORANGE);
				panelcustomers.setLayout(null);
				
			    
				JButton registercostumerbutton = new JButton("Register Customer");
				registercostumerbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
							Statement stmt = (Statement) connection.createStatement();
							String queryaccount = "Select * from list_costumers where`Account No.` IN (select max(`Account No.`) `Account No.` from list_costumers)";
							ResultSet rs = stmt.executeQuery(queryaccount);
							while (rs.next()) {
									accountno = (Integer.parseInt(rs.getString("Account No.")) + 1);
									stringaccount = String.valueOf(accountno);
							}
							String query = "INSERT INTO list_costumers( `Account No.` , `First name`, `Middle name`, `Last name` , `Contact No.`) VALUES (? ,? ,?, ? ,?)";
							java.sql.PreparedStatement pst = connection.prepareStatement(query);
							pst.setString(1, (String) stringaccount);
							pst.setString(2, textField_firstname.getText());
							pst.setString(3, textField_middlename.getText());
							pst.setString(4, textField_lastname.getText());
							pst.setString(5, textField_contactnum.getText());
			
							
							if (textField_lastname.getText().equals("") && textField_contactnum.getText().equals("") && textField_firstname.getText().equals("") && textField_middlename.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your First name, Middle name, Last name and Contact number.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if ( textField_contactnum.getText().equals("") && textField_firstname.getText().equals("") && textField_middlename.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your First name, Middle name and Contact number.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_lastname.getText().equals("") && textField_firstname.getText().equals("") && textField_middlename.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your First name, Last name and Middle name.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_lastname.getText().equals("") && textField_contactnum.getText().equals("") && textField_middlename.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your Last name , Middle name and Contact number","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_lastname.getText().equals("") && textField_contactnum.getText().equals("") && textField_firstname.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your First name, Last name and Contact number","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_firstname.getText().equals("") && textField_middlename.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your First and Middle name","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_firstname.getText().equals("") && textField_lastname.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your First and Last name","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_firstname.getText().equals("") && textField_contactnum.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your First name and Contact number","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_middlename.getText().equals("") && textField_lastname.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your Middle name and Last name","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_middlename.getText().equals("") && textField_contactnum.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your Middle name and Contact number","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_lastname.getText().equals("") && textField_contactnum.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your Last name and Contact number","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							
							if (textField_firstname.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your First name.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							if (textField_middlename.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your Middle name.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_lastname.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your Last name.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_contactnum.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Input your Contact number.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							
							pst.execute();
							showcustomers();
							fillComboBox();
							JOptionPane.showMessageDialog(null,  "Customer has been saved!");
							
							pst.close();
						} catch (Exception exc) {
							exc.printStackTrace();
						}

				
					}
					
				});
				registercostumerbutton.setForeground(Color.DARK_GRAY);
				registercostumerbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
				registercostumerbutton.setBounds(91, 548, 203, 25);
				panelcustomers.add(registercostumerbutton);
				
				JLabel lblTrayTotal = new JLabel("Tray Total Amount:");
				lblTrayTotal.setHorizontalAlignment(SwingConstants.CENTER);
				lblTrayTotal.setForeground(Color.DARK_GRAY);
				lblTrayTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblTrayTotal.setBounds(1569, 526, 141, 14);
				panelcustomers.add(lblTrayTotal);
				
				JLabel lblOrdersList = new JLabel("GOLDEN NATURE FARM ORDER'S LIST");
				lblOrdersList.setHorizontalAlignment(SwingConstants.CENTER);
				lblOrdersList.setForeground(Color.DARK_GRAY);
				lblOrdersList.setFont(new Font("Tahoma", Font.BOLD, 25));
				lblOrdersList.setBounds(1312, 260, 491, 42);
				panelcustomers.add(lblOrdersList);
				
				textField_traytotalam = new JTextField("0");
				textField_traytotalam.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_traytotalam.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				textField_traytotalam.setColumns(10);
				textField_traytotalam.setBounds(1722, 519, 120, 29);
				panelcustomers.add(textField_traytotalam);
				
				JLabel label_smalleggam = new JLabel("\u20B1");
				label_smalleggam.setHorizontalAlignment(SwingConstants.CENTER);
				label_smalleggam.setForeground(Color.DARK_GRAY);
				label_smalleggam.setFont(new Font("Tahoma", Font.BOLD, 15));
				label_smalleggam.setBounds(1634, 323, 76, 25);
				panelcustomers.add(label_smalleggam);
				
				JLabel label_mediumeggam = new JLabel("\u20B1");
				label_mediumeggam.setHorizontalAlignment(SwingConstants.CENTER);
				label_mediumeggam.setForeground(Color.DARK_GRAY);
				label_mediumeggam.setFont(new Font("Tahoma", Font.BOLD, 15));
				label_mediumeggam.setBounds(1634, 363, 76, 25);
				panelcustomers.add(label_mediumeggam);
				
				JLabel label_largeeggam = new JLabel("\u20B1");
				label_largeeggam.setHorizontalAlignment(SwingConstants.CENTER);
				label_largeeggam.setForeground(Color.DARK_GRAY);
				label_largeeggam.setFont(new Font("Tahoma", Font.BOLD, 15));
				label_largeeggam.setBounds(1634, 401, 76, 25);
				panelcustomers.add(label_largeeggam);
				
				JLabel label_extralargeam = new JLabel("\u20B1");
				label_extralargeam.setHorizontalAlignment(SwingConstants.CENTER);
				label_extralargeam.setForeground(Color.DARK_GRAY);
				label_extralargeam.setFont(new Font("Tahoma", Font.BOLD, 15));
				label_extralargeam.setBounds(1634, 439, 76, 25);
				panelcustomers.add(label_extralargeam);
				
				textField_smalleggam = new JTextField();
				textField_smalleggam.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_smalleggam.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				textField_smalleggam.setColumns(10);
				textField_smalleggam.setBounds(1722, 321, 120, 29);
				panelcustomers.add(textField_smalleggam);
				
				textField_mediumeggam = new JTextField();
				textField_mediumeggam.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_mediumeggam.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				textField_mediumeggam.setColumns(10);
				textField_mediumeggam.setBounds(1722, 361, 120, 29);
				panelcustomers.add(textField_mediumeggam);
				
				textField_largeeggam = new JTextField();
				textField_largeeggam.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_largeeggam.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				textField_largeeggam.setColumns(10);
				textField_largeeggam.setBounds(1722, 399, 120, 29);
				panelcustomers.add(textField_largeeggam);
				
				textField_extralargeeggam = new JTextField();
				textField_extralargeeggam.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_extralargeeggam.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				textField_extralargeeggam.setColumns(10);
				textField_extralargeeggam.setBounds(1722, 437, 120, 29);
				panelcustomers.add(textField_extralargeeggam);
				
				JButton buttoncustomercalc = new JButton("Calculate Total");
				buttoncustomercalc.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small, Medium, Large, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Medium, Large, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small,  Large, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("")  && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small, Medium, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("")  && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small, Medium, Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small, Medium, Large and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Medium, Large and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small, Large and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("") && textField_extralargetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small, Medium and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small, Medium and Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("")  && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Medium, Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_largetray.getText().equals("")  && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small, Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small, Medium and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumtray.getText().equals("")  && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Medium, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("")  && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small, Medium and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("")  && textField_extralargetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small, Medium and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Large, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_largetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small,  Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small,  Large and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Large, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumtray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Medium, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Medium, Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Medium, Large and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small and Medium tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_largetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small and Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_extralargetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Medium and Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumtray.getText().equals("") && textField_extralargetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Medium and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumtray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Medium and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Large and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_largetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalltray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Small tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumtray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Medium tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_largetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_extralargetray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_jumbotray.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total of Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						
						
						String smalltray = textField_smalltray.getText();
						double answer1 = Double.parseDouble(smalltray);
						double amount1 = answer1 * 142;
						String change = String.valueOf(two.format(amount1));
						textField_smalleggam.setText(change);
						
						String jumbotray = textField_jumbotray.getText();
						double answer5 = Double.parseDouble(jumbotray);
						double amount5 = answer5 * 180;
						String change5 = String.valueOf(two.format(amount5));
						textField_jumboeggam.setText(change5);
						
						String mediumtray = textField_mediumtray.getText();
						double answer2 = Double.parseDouble(mediumtray);
						double amount2 = answer2 * 153;
						String change2 = String.valueOf(two.format(amount2));
						textField_mediumeggam.setText(change2);
						
						String largetray = textField_largetray.getText();
						double answer3 = Double.parseDouble(largetray);
						double amount3 = answer3 * 167;
						String change3 = String.valueOf(two.format(amount3));
						textField_largeeggam.setText(change3);
						
						String extralargetray = textField_extralargetray.getText();
						double answer4 = Double.parseDouble(extralargetray);
						double amount4 = answer4 * 175;
						String change4 = String.valueOf(two.format(amount4));
						textField_extralargeeggam.setText(change4);
						
						if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium, Large, Extra Large and Jumbo tray amount is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Medium, Large, Extra Large and Jumbo tray  is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small,  Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("")  && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("")  && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("")  && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_largeeggam.getText().equals("")  && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumeggam.getText().equals("")  && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("")  && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("")  && textField_extralargeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small,  Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small,  Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumeggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small and Medium tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_largeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Small and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Medium and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_mediumeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_largeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Total amount of Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_smalleggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Cannot be resolve. Total of trays by size amount fields should not be empty.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						
						if (textField_mediumeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Cannot be resolve. Total of trays by size amount fields should not be empty.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_largeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Cannot be resolve. Total of trays by size amount fields should not be empty.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						if (textField_extralargeeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Cannot be resolve. Total of trays by size amount fields should not be empty.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						
						if (textField_jumboeggam.getText().equals("")) {
							JOptionPane.showMessageDialog(frame,"Cannot be resolve. Total of trays by size amount fields should not be empty.","Invalid Input", JOptionPane.ERROR_MESSAGE);
							return;
							
						}
						
						
						
						double amounttotal = amount1 + amount2 + amount3 + amount4 + amount5;
						String changetotal = String.valueOf(two.format(amounttotal));
						textField_traytotalam.setText(changetotal);
					
					}
				});
				buttoncustomercalc.setForeground(Color.DARK_GRAY);
				buttoncustomercalc.setFont(new Font("Tahoma", Font.BOLD, 15));
				buttoncustomercalc.setBounds(1630, 588, 203, 25);
				panelcustomers.add(buttoncustomercalc);
				
				JButton btnUpdateCustomer = new JButton("Update Customer");
				btnUpdateCustomer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
						
							String query = "Update `list_costumers` set `Account No.` = ' " +  comboBox_accountnum.getSelectedItem() +" ',`First name`='"+textField_firstname.getText() +"',`Middle name`='"+textField_middlename.getText()+"' ,`Last name`='"+textField_lastname.getText()+"',`Contact No.`='"+textField_contactnum.getText()+ 
									" ' where `Account No.` = ' " +  comboBox_accountnum.getSelectedItem()   + " ' ";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					
					if (textField_lastname.getText().equals("") && textField_contactnum.getText().equals("") && textField_firstname.getText().equals("") && textField_middlename.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your First name, Middle name, Last name and Contact number.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if ( textField_contactnum.getText().equals("") && textField_firstname.getText().equals("") && textField_middlename.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your First name, Middle name and Contact number.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_lastname.getText().equals("") && textField_firstname.getText().equals("") && textField_middlename.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your First name, Last name and Middle name.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_lastname.getText().equals("") && textField_contactnum.getText().equals("") && textField_middlename.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your Last name , Middle name and Contact number","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_lastname.getText().equals("") && textField_contactnum.getText().equals("") && textField_firstname.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your First name, Last name and Contact number","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_firstname.getText().equals("") && textField_middlename.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your First and Middle name","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_firstname.getText().equals("") && textField_lastname.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your First and Last name","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_firstname.getText().equals("") && textField_contactnum.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your First name and Contact number","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_middlename.getText().equals("") && textField_lastname.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your Middle name and Last name","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_middlename.getText().equals("") && textField_contactnum.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your Middle name and Contact number","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_lastname.getText().equals("") && textField_contactnum.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your Last name and Contact number","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					
					if (textField_firstname.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your First name.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					if (textField_middlename.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your Middle name.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_lastname.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your Last name.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_contactnum.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input your Contact number.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data at Account No. " +  comboBox_accountnum.getSelectedItem() + " has been Updated!");
					
					pst.close();
					
				} catch (Exception exc) {
					exc.printStackTrace();
				}
						showcustomers();
					}

				});

				btnUpdateCustomer.setForeground(Color.DARK_GRAY);
				btnUpdateCustomer.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnUpdateCustomer.setBounds(609, 548, 203, 25);
				panelcustomers.add(btnUpdateCustomer);
				Image img2 = new ImageIcon(this.getClass().getResource("person-icon.png")).getImage();
				
				JLabel labeljumbotray = new JLabel("\u20B1");
				labeljumbotray.setHorizontalAlignment(SwingConstants.CENTER);
				labeljumbotray.setForeground(Color.DARK_GRAY);
				labeljumbotray.setFont(new Font("Tahoma", Font.BOLD, 15));
				labeljumbotray.setBounds(1634, 477, 76, 25);
				panelcustomers.add(labeljumbotray);
				
				textField_jumboeggam = new JTextField();
				textField_jumboeggam.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				textField_jumboeggam.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_jumboeggam.setColumns(10);
				textField_jumboeggam.setBounds(1722, 479, 120, 29);
				panelcustomers.add(textField_jumboeggam);
				
				JButton btnClearOrdersList = new JButton("CLEAR ORDER'S LIST TEXTFIELDS");
				btnClearOrdersList.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						textField_smalltray.setText("0");
						textField_mediumtray.setText("0");
						textField_largetray.setText("0");
						textField_extralargetray.setText("0");
						textField_jumbotray.setText("0");
						
						textField_smalleggam.setText("");
						textField_mediumeggam.setText("");
						textField_largeeggam.setText("");
						textField_extralargeeggam.setText("");
						textField_jumboeggam.setText("");
						
						textField_traytotalam.setText("0");
					}
				});
				btnClearOrdersList.setForeground(Color.DARK_GRAY);
				btnClearOrdersList.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnClearOrdersList.setBounds(1479, 649, 354, 25);
				panelcustomers.add(btnClearOrdersList);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPane.setBounds(964, 13, 904, 205);
				panelcustomers.add(scrollPane);
				
				customereggstable = new JTable();
				customereggstable.setForeground(Color.DARK_GRAY);
				customereggstable.setFont(new Font("Tahoma", Font.BOLD, 15));
				customereggstable.setModel(new DefaultTableModel(
					new Object[][] {
						{new Long(2132L), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), "0"},
						{new Long(2133L), new Integer(1), new Integer(3), new Integer(4), new Integer(6), new Integer(0), new Integer(0), "2,040.00"},
						{new Long(2140L), new Integer(4), new Integer(0), new Integer(0), new Integer(0), new Integer(78), new Integer(0), "13,650.00"},
						{new Long(2141L), new Integer(5), new Integer(0), new Integer(0), new Integer(0), new Integer(78), new Integer(0), "13,650.00"},
						{new Long(2142L), new Integer(6), new Integer(0), new Integer(0), new Integer(0), new Integer(78), new Integer(0), "13,650.00"},
					},
					new String[] {
						"Customer ID", "Receipt No.", "Small (Tray)", "Medium (Tray)", "Large (Tray)", "ExtraLarge (Tray)", "Jumbo (Tray)", "Tray Total Amount"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				scrollPane.setViewportView(customereggstable);
				showorders();
				
				JTableHeader customerHeader1 = customereggstable.getTableHeader();
				customerHeader1.setForeground(new Color(0).DARK_GRAY);
			    customerHeader1.setBackground(new Color(0).LIGHT_GRAY);
			    customerHeader1.setFont(new Font("Tahoma" , Font.BOLD, 15));
				
				JButton btnAddToCart = new JButton("ADD TO CART");
				btnAddToCart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try { 
							
							Statement stmt = (Statement) connection.createStatement();
							String queryreciept = "Select * from orders_costumers where`Receipt No.` IN (select max(`Receipt No.`) `Receipt No.` from orders_costumers)";
							ResultSet rs = stmt.executeQuery(queryreciept);
							while (rs.next()) {
									recieptno = (Integer.parseInt(rs.getString("Receipt No.")) + 1);
									stringreciept = String.valueOf(recieptno);
							}
							
							String query = "INSERT INTO orders_costumers( `Receipt No.` , `Small (Tray)`, `Medium (Tray)`, `Large (Tray)` , `ExtraLarge (Tray)`, `Jumbo (Tray)`, `Small (Tray) Amount`, `Medium (Tray) Amount` , `Large (Tray) Amount`, `Extra Large (Tray) Amount`, `Jumbo (Tray) Amount`, `Tray Total Amount`) VALUES (?, ? ,? ,?, ?, ?, ?, ?, ?, ?, ?, ?)";
							java.sql.PreparedStatement pst = connection.prepareStatement(query);
							pst.setInt(1, recieptno);
							pst.setString(2, textField_smalltray.getText());
							pst.setString(3, textField_mediumtray.getText());
							pst.setString(4, textField_largetray.getText());
							pst.setString(5, textField_extralargetray.getText());
							pst.setString(6, textField_jumbotray.getText());
							pst.setString(7, textField_smalleggam.getText());
							pst.setString(8, textField_mediumeggam.getText());
							pst.setString(9, textField_largeeggam.getText());
							pst.setString(10, textField_extralargeeggam.getText());
							pst.setString(11, textField_jumboeggam.getText());
							pst.setString(12, textField_traytotalam.getText());
							
							
							if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small, Medium, Large, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Medium, Large, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small,  Large, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("")  && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small, Medium, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("")  && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small, Medium, Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small, Medium, Large and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Medium, Large and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small, Large and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("") && textField_extralargetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small, Medium and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small, Medium and Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("")  && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Medium, Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_largetray.getText().equals("")  && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small, Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small, Medium and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumtray.getText().equals("")  && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Medium, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("")  && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small, Medium and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("")  && textField_extralargetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small, Medium and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Large, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_largetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small,  Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small,  Large and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Large, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumtray.getText().equals("") && textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Medium, Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Medium, Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Medium, Large and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_mediumtray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small and Medium tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_largetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small and Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_extralargetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumtray.getText().equals("") && textField_largetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Medium and Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumtray.getText().equals("") && textField_extralargetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Medium and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumtray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Medium and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_largetray.getText().equals("") && textField_extralargetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Large and Extra Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_largetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_extralargetray.getText().equals("") && textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Extra Large and Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalltray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Small tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumtray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Medium tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_largetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_extralargetray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Large tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_jumbotray.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total of Jumbo tray/trays bought is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium, Large, Extra Large and Jumbo tray amount is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Medium, Large, Extra Large and Jumbo tray  is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small,  Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("")  && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("")  && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("")  && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_largeeggam.getText().equals("")  && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumeggam.getText().equals("")  && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("")  && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("")  && textField_extralargeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small, Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small,  Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small,  Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumeggam.getText().equals("") && textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_mediumeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small and Medium tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_largeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Small and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumeggam.getText().equals("") && textField_largeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Medium and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_mediumeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_largeeggam.getText().equals("") && textField_extralargeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_largeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_extralargeeggam.getText().equals("") && textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total amount of Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_smalleggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Cannot be resolve. Total of trays by size amount fields should not be empty.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							
							if (textField_mediumeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Cannot be resolve. Total of trays by size amount fields should not be empty.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_largeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Cannot be resolve. Total of trays by size amount fields should not be empty.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_extralargeeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Cannot be resolve. Total of trays by size amount fields should not be empty.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_jumboeggam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Cannot be resolve. Total of trays by size amount fields should not be empty.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
						
							
							if (textField_traytotalam.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"Total Tray amount is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							
							pst.execute();
							
							
							
							JOptionPane.showMessageDialog(null,  "Order has been saved!");
							
							pst.close();
							fillComboBox3();
							showorders();
							
							
							
						} catch(Exception exc) {
							exc.printStackTrace();
							
						} 
						
					}
					
				});
				showorders();
				btnAddToCart.setForeground(Color.DARK_GRAY);
				btnAddToCart.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnAddToCart.setBounds(1359, 588, 203, 25);
				panelcustomers.add(btnAddToCart);
				
				JPanel panelaccountno = new JPanel();
				panelaccountno.setBackground(SystemColor.activeCaption);
				panelaccountno.setBounds(0, 0, 952, 687);
				panelcustomers.add(panelaccountno);
				panelaccountno.setLayout(null);
				
				textField_contactnum = new JTextField();
				textField_contactnum.setBounds(303, 491, 354, 29);
				panelaccountno.add(textField_contactnum);
				textField_contactnum.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_contactnum.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				textField_contactnum.setColumns(10);
				
				textField_middlename = new JTextField();
				textField_middlename.setBounds(305, 384, 352, 29);
				panelaccountno.add(textField_middlename);
				textField_middlename.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_middlename.setColumns(10);
				textField_middlename.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				
				textField_firstname = new JTextField();
				textField_firstname.setBounds(303, 335, 354, 29);
				panelaccountno.add(textField_firstname);
				textField_firstname.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_firstname.setColumns(10);
				textField_firstname.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				
				
				JButton btnClearTextfieldsOf = new JButton("CLEAR TEXTFIELDS OF ACCOUNT INFO");
				btnClearTextfieldsOf.setBounds(262, 625, 395, 27);
				panelaccountno.add(btnClearTextfieldsOf);
				btnClearTextfieldsOf.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						textField_firstname.setText("");
						textField_middlename.setText("");
						textField_lastname.setText("");
						textField_contactnum.setText("");
					}
				});
				btnClearTextfieldsOf.setForeground(Color.DARK_GRAY);
				btnClearTextfieldsOf.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPane_1.setBounds(75, 13, 766, 207);
				panelaccountno.add(scrollPane_1);
				
					
				customertable = new JTable();
				customertable.setForeground(Color.DARK_GRAY);
				customertable.setFont(new Font("Tahoma", Font.BOLD, 15));
				customertable.setModel(new DefaultTableModel(
					new Object[][] {
						{new Long(26L), "gfgdfsd", "kjhlos", "vxknksww", "454545    "},
						{new Long(27L), "xxcvcasas", "kjhlosdfdf", "vxknk322", "454545   "},
						{new Long(28L), "xxcvcasas", "kjhlosdfdf", "vxknk322", "454545  "},
					},
					new String[] {
						"Account No.", "First name", "Middle name", "Last name", "Contact No."
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				scrollPane_1.setViewportView(customertable);
				Image img = new ImageIcon(this.getClass().getResource("Employee-Management.png")).getImage();
				showcustomers();
		
				
				JLabel lblFirstName = new JLabel("First Name");
				lblFirstName.setBounds(159, 329, 120, 41);
				panelaccountno.add(lblFirstName);
				lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
				lblFirstName.setForeground(Color.DARK_GRAY);
				lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblMiddleName = new JLabel("Middle Name");
				lblMiddleName.setBounds(159, 380, 130, 37);
				panelaccountno.add(lblMiddleName);
				lblMiddleName.setHorizontalAlignment(SwingConstants.CENTER);
				lblMiddleName.setForeground(Color.DARK_GRAY);
				lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblLastName = new JLabel("Last Name");
				lblLastName.setBounds(159, 439, 120, 29);
				panelaccountno.add(lblLastName);
				lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
				lblLastName.setForeground(Color.DARK_GRAY);
				lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblContactNumber = new JLabel("Contact Number");
				lblContactNumber.setBounds(149, 491, 130, 29);
				panelaccountno.add(lblContactNumber);
				lblContactNumber.setHorizontalAlignment(SwingConstants.CENTER);
				lblContactNumber.setForeground(Color.DARK_GRAY);
				lblContactNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				comboBox_accountnum = new JComboBox();
				comboBox_accountnum.setBounds(368, 283, 231, 25);
				panelaccountno.add(comboBox_accountnum);
		
				comboBox_accountnum.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
						String query = "select * from list_costumers where `Account No.`=?";
						PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
						pst.setString(1,  (String) comboBox_accountnum.getSelectedItem());
						ResultSet rs = pst.executeQuery();
						
						while(rs.next()){
							textField_firstname.setText(rs.getString("First name"));
							textField_middlename.setText(rs.getString("Middle name"));
							textField_lastname.setText(rs.getString("Last name"));
							textField_contactnum.setText(rs.getString("Contact No."));
						}
					} catch(Exception exc) {
						exc.printStackTrace();
					}
					}
				});
				comboBox_accountnum.setForeground(Color.DARK_GRAY);
				comboBox_accountnum.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel labeliconcustomer = new JLabel("");
				labeliconcustomer.setBounds(22, 233, 130, 137);
				panelaccountno.add(labeliconcustomer);
				labeliconcustomer.setIcon(new ImageIcon(img2));
				labeliconcustomer.setHorizontalAlignment(SwingConstants.CENTER);
				labeliconcustomer.setForeground(Color.DARK_GRAY);
				labeliconcustomer.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				textField_lastname = new JTextField();
				textField_lastname.setBounds(303, 439, 354, 29);
				panelaccountno.add(textField_lastname);
				textField_lastname.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_lastname.setColumns(10);
				textField_lastname.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(SystemColor.inactiveCaption);
				panel_1.setBounds(721, 283, 189, 208);
				panelaccountno.add(panel_1);
				
				JLabel lblSearchFirstName = new JLabel("Search First name");
				lblSearchFirstName.setForeground(Color.DARK_GRAY);
				lblSearchFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
				panel_1.add(lblSearchFirstName);
				
				textField_searchfirstname = new JTextField();
				textField_searchfirstname.setForeground(Color.DARK_GRAY);
				textField_searchfirstname.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_searchfirstname.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				textField_searchfirstname.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent arg0) {
						try { 
							String query = "select * from list_costumers where `First name` = ?";
							java.sql.PreparedStatement pst = connection.prepareStatement(query);
							pst.setString(1, textField_searchfirstname.getText());
							ResultSet rs = pst.executeQuery();
							
							customertable.setModel(DbUtils.resultSetToTableModel(rs));
						//	while(rs.next()) {
						//		
						//	}
							
						} catch (Exception exc) {
							exc.printStackTrace();
						
					}
					}
				});	
				panel_1.add(textField_searchfirstname);
				textField_searchfirstname.setColumns(10);
				
				JLabel lblSearchLastName = new JLabel("Search Middle name");
				lblSearchLastName.setForeground(Color.DARK_GRAY);
				lblSearchLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
				panel_1.add(lblSearchLastName);
				
				textField_searchmiddlename = new JTextField();
				textField_searchmiddlename.setForeground(Color.DARK_GRAY);
				textField_searchmiddlename.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_searchmiddlename.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				textField_searchmiddlename.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent arg0) {
						try { 
							String query = "select * from list_costumers where `Middle name` = ?";
							java.sql.PreparedStatement pst = connection.prepareStatement(query);
							pst.setString(1, textField_searchmiddlename.getText());
							ResultSet rs = pst.executeQuery();
							
							customertable.setModel(DbUtils.resultSetToTableModel(rs));
						//	while(rs.next()) {
						//		
						//	}
							
						} catch (Exception exc) {
							exc.printStackTrace();
						
					}
					}
				});	
				panel_1.add(textField_searchmiddlename);
				textField_searchmiddlename.setColumns(10);
				
				JLabel lblSearchLastName_1 = new JLabel("Search Last name");
				lblSearchLastName_1.setForeground(Color.DARK_GRAY);
				lblSearchLastName_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				panel_1.add(lblSearchLastName_1);
				
				textField_searchlastname = new JTextField();
				textField_searchlastname.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_searchlastname.setForeground(Color.DARK_GRAY);
				textField_searchlastname.setColumns(10);
				textField_searchlastname.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				textField_searchlastname.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent arg0) {
						try { 
							String query = "select * from list_costumers where `Last name` = ?";
							java.sql.PreparedStatement pst = connection.prepareStatement(query);
							pst.setString(1, textField_searchlastname.getText());
							ResultSet rs = pst.executeQuery();
							
							customertable.setModel(DbUtils.resultSetToTableModel(rs));
						//	while(rs.next()) {
						//		
						//	}
							
						} catch (Exception exc) {
							exc.printStackTrace();
						
					}
					}
				});	
				panel_1.add(textField_searchlastname);
				
				JButton btnLoadDatabase = new JButton("LOAD DATABASE");
				btnLoadDatabase.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						showcustomers();
					}
				});
				btnLoadDatabase.setForeground(Color.DARK_GRAY);
				btnLoadDatabase.setFont(new Font("Tahoma", Font.BOLD, 15));
				panel_1.add(btnLoadDatabase);
				
				JLabel lblGetValuesFrom = new JLabel("Get Values from Acc. No. HERE:");
				lblGetValuesFrom.setBounds(368, 233, 242, 41);
				panelaccountno.add(lblGetValuesFrom);
				lblGetValuesFrom.setHorizontalAlignment(SwingConstants.CENTER);
				lblGetValuesFrom.setForeground(Color.DARK_GRAY);
				lblGetValuesFrom.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JButton btnDeleteCustomer = new JButton("Send To Customer Bin");
				btnDeleteCustomer.setBounds(345, 549, 203, 25);
				panelaccountno.add(btnDeleteCustomer);
				btnDeleteCustomer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
							
							String query = "INSERT INTO deletedcustomer VALUES (? ,? ,?, ? , ?)";
							java.sql.PreparedStatement pst = connection.prepareStatement(query);
							pst.setString(1, (String) comboBox_accountnum.getSelectedItem());
							pst.setString(2, textField_firstname.getText());
							pst.setString(3, textField_middlename.getText());
							pst.setString(4, textField_lastname.getText());
							pst.setString(5, textField_contactnum.getText());
							
							if (textField_lastname.getText().equals("") && textField_contactnum.getText().equals("") && textField_firstname.getText().equals("") && textField_middlename.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on First name, Middle name, Last name and Contact number. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if ( textField_contactnum.getText().equals("") && textField_firstname.getText().equals("") && textField_middlename.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on First name, Middle name and Contact number. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_lastname.getText().equals("") && textField_firstname.getText().equals("") && textField_middlename.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on First name, Last name and Middle name. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_lastname.getText().equals("") && textField_contactnum.getText().equals("") && textField_middlename.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on Last name , Middle name and Contact number. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_lastname.getText().equals("") && textField_contactnum.getText().equals("") && textField_firstname.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on First name, Last name and Contact number. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_firstname.getText().equals("") && textField_middlename.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on First and Middle name. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_firstname.getText().equals("") && textField_lastname.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on First and Last name. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_firstname.getText().equals("") && textField_contactnum.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on First name and Contact number. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_middlename.getText().equals("") && textField_lastname.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on Middle name and Last name. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_middlename.getText().equals("") && textField_contactnum.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on Middle name and Contact number. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_lastname.getText().equals("") && textField_contactnum.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on Last name and Contact number. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							
							if (textField_firstname.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity First name. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							if (textField_middlename.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on Middle name. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_lastname.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on Last name. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							if (textField_contactnum.getText().equals("")) {
								JOptionPane.showMessageDialog(frame,"No entity on Contact number. Select an Account No. Again. DO NOT EDIT.","Invalid Input", JOptionPane.ERROR_MESSAGE);
								return;
								
							}
							
							
							int confirm = JOptionPane.showConfirmDialog(null, "Do you really want to transfer it to Customer bin?" , "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
							
							if (confirm == JOptionPane.CANCEL_OPTION) {
								return;
							}
							if (confirm == JOptionPane.YES_OPTION) { 
								pst.execute();
								
								String query2 = " Delete from list_costumers where `Account No.` ='" + comboBox_accountnum.getSelectedItem() + " ' ";
								java.sql.PreparedStatement pst2 = connection.prepareStatement(query2);
								
								pst2.execute();
								
								
								JOptionPane.showMessageDialog(null,  "Customer has been trasfered to Customer Bin!");
								
								
								pst.close();
								pst2.close();
								comboBox_accountnum.removeItemAt(comboBox_accountnum.getSelectedIndex());
								
							}
							else if (confirm == JOptionPane.NO_OPTION) {
								return;
							}
							
							
						} catch (Exception exc) {
							exc.printStackTrace();
						}
						
						showcustomers();
					}
					
				});
				
				btnDeleteCustomer.setForeground(Color.DARK_GRAY);
				btnDeleteCustomer.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBounds(408, 222, 594, 599);
				panelaccountno.add(lblNewLabel);
				lblNewLabel.setIcon(new ImageIcon(img));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel icon = new JLabel("");
				Image img3 = new ImageIcon(this.getClass().getResource("online_order.png")).getImage();
				icon.setIcon(new ImageIcon(img3));
				icon.setHorizontalAlignment(SwingConstants.CENTER);
				icon.setBounds(944, 217, 292, 240);
				panelcustomers.add(icon);
				
				JPanel panelfortrays = new JPanel();
				panelfortrays.setBackground(new Color(192, 192, 192));
				panelfortrays.setBounds(1237, 303, 385, 210);
				panelcustomers.add(panelfortrays);
				panelfortrays.setLayout(null);
				
				textField_smalltray = new JTextField("0");
				textField_smalltray.setBounds(237, 13, 136, 25);
				textField_smalltray.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_smalltray.setColumns(10);
				textField_smalltray.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				panelfortrays.add(textField_smalltray);
				
				textField_mediumtray = new JTextField("0");
				textField_mediumtray.setBounds(237, 58, 136, 25);
				textField_mediumtray.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_mediumtray.setColumns(10);
				textField_mediumtray.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				panelfortrays.add(textField_mediumtray);
				
				textField_largetray = new JTextField("0");
				textField_largetray.setBounds(237, 96, 136, 25);
				textField_largetray.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_largetray.setColumns(10);
				textField_largetray.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				panelfortrays.add(textField_largetray);
				
				textField_extralargetray = new JTextField("0");
				textField_extralargetray.setBounds(237, 134, 136, 25);
				textField_extralargetray.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_extralargetray.setColumns(10);
				textField_extralargetray.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				panelfortrays.add(textField_extralargetray);
				
				textField_jumbotray = new JTextField("0");
				textField_jumbotray.setBounds(237, 172, 136, 25);
				textField_jumbotray.setFont(new Font("Tahoma", Font.BOLD, 15));
				textField_jumbotray.setColumns(10);
				textField_jumbotray.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent arg0) {
						char c = arg0.getKeyChar();
						if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
							getToolkit().beep();
							arg0.consume();
						}
					}
				});
				panelfortrays.add(textField_jumbotray);
				
				JLabel lblSmalltray = new JLabel("Small (Tray)");
				lblSmalltray.setBounds(14, 20, 164, 25);
				panelfortrays.add(lblSmalltray);
				lblSmalltray.setHorizontalAlignment(SwingConstants.CENTER);
				lblSmalltray.setForeground(Color.DARK_GRAY);
				lblSmalltray.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblMediumtray = new JLabel("Medium (Tray)");
				lblMediumtray.setBounds(14, 58, 164, 25);
				panelfortrays.add(lblMediumtray);
				lblMediumtray.setHorizontalAlignment(SwingConstants.CENTER);
				lblMediumtray.setForeground(Color.DARK_GRAY);
				lblMediumtray.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblLargetray = new JLabel("Large (Tray)");
				lblLargetray.setBounds(14, 96, 164, 25);
				panelfortrays.add(lblLargetray);
				lblLargetray.setHorizontalAlignment(SwingConstants.CENTER);
				lblLargetray.setForeground(Color.DARK_GRAY);
				lblLargetray.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblExtraLargetray = new JLabel("Extra Large (Tray)");
				lblExtraLargetray.setBounds(14, 134, 164, 25);
				panelfortrays.add(lblExtraLargetray);
				lblExtraLargetray.setHorizontalAlignment(SwingConstants.CENTER);
				lblExtraLargetray.setForeground(Color.DARK_GRAY);
				lblExtraLargetray.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				JLabel lblJumbotray = new JLabel("Jumbo (Tray)");
				lblJumbotray.setBounds(14, 172, 164, 25);
				panelfortrays.add(lblJumbotray);
				lblJumbotray.setHorizontalAlignment(SwingConstants.CENTER);
				lblJumbotray.setForeground(Color.DARK_GRAY);
				lblJumbotray.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				comboBox_receipt = new JComboBox();
				comboBox_receipt.setForeground(Color.DARK_GRAY);
				comboBox_receipt.setFont(new Font("Tahoma", Font.BOLD, 15));
				comboBox_receipt.setBounds(1004, 512, 200, 28);
				comboBox_receipt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
						String query = "select * from orders_costumers where `Receipt No.`=?";
						PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
						pst.setString(1,  (String) comboBox_receipt.getSelectedItem());
						ResultSet rs = pst.executeQuery();
						
						while(rs.next()){
							textField_smalltray.setText(rs.getString("Small (Tray)"));
							textField_mediumtray.setText(rs.getString("Medium (Tray)"));
							textField_largetray.setText(rs.getString("Large (Tray)"));
							textField_extralargetray.setText(rs.getString("ExtraLarge (Tray)"));
							textField_jumbotray.setText(rs.getString("Jumbo (Tray)"));
							textField_traytotalam.setText(rs.getString("Tray Total Amount"));
						}
					} catch(Exception exc) {
						exc.printStackTrace();
					}
					}
				});
				panelcustomers.add(comboBox_receipt);
				
				JLabel lblRecieptNo = new JLabel("Reciept No.");
				lblRecieptNo.setHorizontalAlignment(SwingConstants.CENTER);
				lblRecieptNo.setForeground(Color.DARK_GRAY);
				lblRecieptNo.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblRecieptNo.setBounds(1032, 482, 141, 14);
				panelcustomers.add(lblRecieptNo);
				
				JButton btnDelete = new JButton("DELETE");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
							
							int confirm = JOptionPane.showConfirmDialog(null, "Do you really want to delete this receipt permanently?" , "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
							
							if (confirm == JOptionPane.CANCEL_OPTION) {
								return;
							}
							if (confirm == JOptionPane.YES_OPTION) { 
								String query2 = " Delete from orders_costumers where `Receipt No.` ='" + comboBox_receipt.getSelectedItem() + " ' ";
								java.sql.PreparedStatement pst2 = connection.prepareStatement(query2);
								
								pst2.execute();
								
								JOptionPane.showMessageDialog(null,  "Receipt deleted PERMANENTLY!" );
								
								
								
								pst2.close();
								
							}
							else if (confirm == JOptionPane.NO_OPTION) {
								return;
							}
							
							
							
						} catch (Exception exc) {
							exc.printStackTrace();
						}
						fillComboBox3();
						showorders();
					}
				});
				btnDelete.setForeground(Color.DARK_GRAY);
				btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnDelete.setBounds(1084, 588, 203, 25);
				panelcustomers.add(btnDelete);
				
				JButton btnPrintReceipt = new JButton("VIEW RECEIPT");
				btnPrintReceipt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						view_receipt v = new view_receipt();
						v.setVisible(true);
					}
				});
				btnPrintReceipt.setForeground(Color.DARK_GRAY);
				btnPrintReceipt.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnPrintReceipt.setBounds(1224, 649, 203, 25);
				panelcustomers.add(btnPrintReceipt);
				
				JTableHeader customerHeader = customertable.getTableHeader();
				customerHeader.setForeground(new Color(0).DARK_GRAY);
			    customerHeader.setBackground(new Color(0).LIGHT_GRAY);
			    customerHeader.setFont(new Font("Tahoma" , Font.BOLD, 15));
			    
				fillComboBox();
				
				JTabbedPane systemtabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane_inventorysystem.addTab("Inventory System", null, systemtabbedPane, null);
				systemtabbedPane.setBackground(Color.LIGHT_GRAY);
				
				Panel paneltotalegginventory = new Panel();
				paneltotalegginventory.setBackground(new Color(255, 160, 122));
				systemtabbedPane.addTab("Total Egg Inventory", null, paneltotalegginventory, null);
				paneltotalegginventory.setLayout(null);
				
				JScrollPane scrollPanetotalegginventory = new JScrollPane();
				scrollPanetotalegginventory.setBounds(12, 13, 1856, 181);
				paneltotalegginventory.add(scrollPanetotalegginventory);
				
				tabletotalegginventory = new JTable();
				tabletotalegginventory.setForeground(Color.DARK_GRAY);
				tabletotalegginventory.setFont(new Font("Tahoma", Font.BOLD, 15));
				tabletotalegginventory.setModel(new DefaultTableModel(
					new Object[][] {
						{new Long(3L), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(663), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
						{new Long(16L), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(45453), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
						{new Long(17L), new Integer(1380), new Integer(46), new Integer(0), "January", new Integer(1), new Integer(66390), new Integer(34), new Integer(5), new Integer(7), new Integer(0), new Integer(0)},
						{new Long(18L), new Integer(0), new Integer(0), new Integer(0), "January", new Integer(1), new Integer(54343), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
					},
					new String[] {
						"Inventory No.", "Total No. of Eggs", "Total No. of Trays", "Total No. of Defects", "Month", "Day", "Year", "Small (Tray)", "Medium (Tray)", "Large (Tray)", "Extra Large (Tray)", "Jumbo (Tray)"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false, false, false, false, false, false, true
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				tabletotalegginventory.setSurrendersFocusOnKeystroke(true);
				tabletotalegginventory.setFillsViewportHeight(true);
				tabletotalegginventory.setColumnSelectionAllowed(true);
				tabletotalegginventory.setCellSelectionEnabled(true);
				scrollPanetotalegginventory.setViewportView(tabletotalegginventory);
				 showinventory();
				 
				JTableHeader totalegginvenHeader = tabletotalegginventory.getTableHeader();
				totalegginvenHeader.setForeground(new Color(0).DARK_GRAY);
			    totalegginvenHeader.setBackground(new Color(0).LIGHT_GRAY);
			    totalegginvenHeader.setFont(new Font("Tahoma" , Font.BOLD, 15));
			   
		JLabel labeltotalnoeggs = new JLabel("Total No. of Eggs");
		labeltotalnoeggs.setHorizontalAlignment(SwingConstants.CENTER);
		labeltotalnoeggs.setForeground(Color.DARK_GRAY);
		labeltotalnoeggs.setFont(new Font("Tahoma", Font.BOLD, 15));
		labeltotalnoeggs.setBounds(328, 587, 135, 24);
		paneltotalegginventory.add(labeltotalnoeggs);
		
		JLabel labeltotalnotrays = new JLabel("Total No. of Trays");
		labeltotalnotrays.setHorizontalAlignment(SwingConstants.CENTER);
		labeltotalnotrays.setForeground(Color.DARK_GRAY);
		labeltotalnotrays.setFont(new Font("Tahoma", Font.BOLD, 15));
		labeltotalnotrays.setBounds(22, 592, 137, 24);
		paneltotalegginventory.add(labeltotalnotrays);
		
		JLabel labeltotalnodefects = new JLabel("Total No. of Defects");
		labeltotalnodefects.setHorizontalAlignment(SwingConstants.CENTER);
		labeltotalnodefects.setForeground(Color.DARK_GRAY);
		labeltotalnodefects.setFont(new Font("Tahoma", Font.BOLD, 15));
		labeltotalnodefects.setBounds(328, 533, 148, 19);
		paneltotalegginventory.add(labeltotalnodefects);
		
		JLabel labelmonthtotal = new JLabel("Month");
		labelmonthtotal.setHorizontalAlignment(SwingConstants.CENTER);
		labelmonthtotal.setForeground(Color.DARK_GRAY);
		labelmonthtotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelmonthtotal.setBounds(682, 327, 46, 14);
		paneltotalegginventory.add(labelmonthtotal);
		
		JLabel labeldaytotal = new JLabel("Day");
		labeldaytotal.setHorizontalAlignment(SwingConstants.CENTER);
		labeldaytotal.setForeground(Color.DARK_GRAY);
		labeldaytotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		labeldaytotal.setBounds(903, 327, 46, 14);
		paneltotalegginventory.add(labeldaytotal);
		
		JLabel labelyeartotal = new JLabel("Year");
		labelyeartotal.setHorizontalAlignment(SwingConstants.CENTER);
		labelyeartotal.setForeground(Color.DARK_GRAY);
		labelyeartotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelyeartotal.setBounds(1130, 327, 46, 14);
		paneltotalegginventory.add(labelyeartotal);
		
		textField_totalnoeggs = new JTextField("0");
		textField_totalnoeggs.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_totalnoeggs.setColumns(10);
		textField_totalnoeggs.setBounds(497, 587, 109, 29);
		paneltotalegginventory.add(textField_totalnoeggs);
		
		textField_totalnotrays = new JTextField("0");
		textField_totalnotrays.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_totalnotrays.setColumns(10);
		textField_totalnotrays.setBounds(171, 587, 109, 29);
		paneltotalegginventory.add(textField_totalnotrays);
		
		textField_totalnodefects = new JTextField("0");
		textField_totalnodefects.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_totalnodefects.setColumns(10);
		textField_totalnodefects.setBounds(497, 528, 109, 29);
		paneltotalegginventory.add(textField_totalnodefects);
		
		final JComboBox comboBox_monthtotal = new JComboBox();
		comboBox_monthtotal.setForeground(Color.DARK_GRAY);
		comboBox_monthtotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_monthtotal.setMaximumRowCount(10);
		comboBox_monthtotal.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_monthtotal.setBounds(747, 323, 116, 22);
		paneltotalegginventory.add(comboBox_monthtotal);
		
		final JComboBox comboBox_daytotal = new JComboBox();
		comboBox_daytotal.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_daytotal.setMaximumRowCount(10);
		comboBox_daytotal.setForeground(Color.DARK_GRAY);
		comboBox_daytotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_daytotal.setBounds(962, 323, 116, 22);
		paneltotalegginventory.add(comboBox_daytotal);
			
		
		JButton buttonaddtotal = new JButton("Add to inventory");
		buttonaddtotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Statement stmt = (Statement) connection.createStatement();
					String queryreciept = "Select * from egg_inventory where`Inventory No.` IN (select max(`Inventory No.`) `Inventory No.` from egg_inventory)";
					ResultSet rs = stmt.executeQuery(queryreciept);
					while (rs.next()) {
							inventoryno = (Integer.parseInt(rs.getString("Inventory No.")) + 1);
							stringinvent = String.valueOf(inventoryno);
					}
					String query = "INSERT INTO egg_inventory VALUES (? ,?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?)";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,  (String) stringinvent);
					pst.setString(2, textField_totalnoeggs.getText());
					pst.setString(3, textField_totalnotrays.getText());
					pst.setString(4, textField_totalnodefects.getText());
					pst.setString(5,  (String) comboBox_monthtotal.getSelectedItem());
					pst.setString(6,  (String) comboBox_daytotal.getSelectedItem());
					pst.setString(7, textField_yeartotal.getText());
					pst.setString(8, textField_smalltrayin.getText());
					pst.setString(9, textField_mediumtrayin.getText());
					pst.setString(10, textField_largetrayin.getText());
					pst.setString(11, textField_extralargetrayin.getText());
					pst.setString(12, textField_jumbotrayin.getText());
					
					if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium, Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("")  && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")  && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_mediumtrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_mediumtrayin.getText().equals("")  && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("")  && textField_extralargetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")  && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("")  && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small and Medium tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Medium and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_mediumtrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_mediumtrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_largetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_smalltrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Small tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_mediumtrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Medium tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_largetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_extralargetrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_jumbotrayin.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Total No. of Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_totalnoeggs.getText().equals("") && textField_totalnotrays.getText().equals("") && textField_totalnodefects.getText().equals("") && textField_yeartotal.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input total No. of eggs, trays and defects and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if ( textField_totalnotrays.getText().equals("") && textField_totalnodefects.getText().equals("") && textField_yeartotal.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input total No. of trays and defects and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_totalnoeggs.getText().equals("") && textField_totalnodefects.getText().equals("") && textField_yeartotal.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input total No. of eggs and defects and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_totalnoeggs.getText().equals("") && textField_totalnotrays.getText().equals("") && textField_yeartotal.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input total No. of eggs and trays and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_totalnoeggs.getText().equals("") && textField_totalnotrays.getText().equals("") && textField_totalnodefects.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input total No. of eggs, trays and defects.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_totalnoeggs.getText().equals("") && textField_totalnotrays.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input total No. of eggs and trays.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_totalnoeggs.getText().equals("") && textField_totalnodefects.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input total No. of eggs and defects.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_totalnoeggs.getText().equals("") && textField_yeartotal.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input total No. of eggs and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_totalnotrays.getText().equals("") && textField_totalnodefects.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input total No. of trays and defects.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_totalnotrays.getText().equals("") && textField_yeartotal.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input total No. of trays and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					if (textField_totalnodefects.getText().equals("") && textField_yeartotal.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input total No. of defects and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
					
					
					if (textField_totalnoeggs.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,"Input Total No. of eggs.","Invalid Input", JOptionPane.ERROR_MESSAGE);
						return;
						
					}
				
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,  "Inventory has been saved on " + comboBox_monthtotal.getSelectedItem() + " " + comboBox_daytotal.getSelectedItem() + ", " + textField_yeartotal.getText());
					fillComboBox2();
					showinventory();
					pst.close();
				} catch (Exception exc) {
					exc.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Please check if there are any mistake on your input.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					
					
				}
			}
		});
		
		buttonaddtotal.setForeground(Color.DARK_GRAY);
		buttonaddtotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonaddtotal.setBounds(683, 391, 235, 25);
		paneltotalegginventory.add(buttonaddtotal);
		
		JButton buttondeletetotal = new JButton("Send to Inventory Bin");
		buttondeletetotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "INSERT INTO deletedinventory VALUES (? ,?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?)";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,  (String) comboBox_invent.getSelectedItem());
					pst.setString(2, textField_totalnoeggs.getText());
					pst.setString(3, textField_totalnotrays.getText());
					pst.setString(4, textField_totalnodefects.getText());
					pst.setString(5,  (String) comboBox_monthtotal.getSelectedItem());
					pst.setString(6,  (String) comboBox_daytotal.getSelectedItem());
					pst.setString(7, textField_yeartotal.getText());
					pst.setString(8, textField_smalltrayin.getText());
					pst.setString(9, textField_mediumtrayin.getText());
					pst.setString(10, textField_largetrayin.getText());
					pst.setString(11, textField_extralargetrayin.getText());
					pst.setString(12, textField_jumbotrayin.getText());
				
					int confirm = JOptionPane.showConfirmDialog(null, "Do you really want to transfer it to Inventory bin?" , "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
					
					if (confirm == JOptionPane.CANCEL_OPTION) {
						return;
					}
					if (confirm == JOptionPane.YES_OPTION) { 
						pst.execute();
						
						String query2 = " Delete from egg_inventory where `Inventory No.` ='" + comboBox_invent.getSelectedItem() + " ' ";
						java.sql.PreparedStatement pst2 = connection.prepareStatement(query2);
						
						pst2.execute();
						
						JOptionPane.showMessageDialog(null,  "Inventory on date " + comboBox_monthtotal.getSelectedItem() + " " + comboBox_daytotal.getSelectedItem() + ", " + textField_yeartotal.getText() + " has been transfered to Inventory bin" );
						
						
						pst.close();
						
						pst2.close();
						
						
					}
					else if (confirm == JOptionPane.NO_OPTION) {
						return;
					}
					
				} catch (Exception exc) {
					exc.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Make sure when you choose an Inventory No. don't change the values. Choose an Inventory No. again before deleting.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					
				}
				showinventory();
				fillComboBox2();
			}
		});
		
		buttondeletetotal.setForeground(Color.DARK_GRAY);
		buttondeletetotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttondeletetotal.setBounds(1040, 444, 235, 25);
		paneltotalegginventory.add(buttondeletetotal);
		
		JLabel labelinventory = new JLabel("GOLDEN NATURE FARM'S INVENTORY LIST");
		labelinventory.setHorizontalAlignment(SwingConstants.CENTER);
		labelinventory.setForeground(Color.DARK_GRAY);
		labelinventory.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelinventory.setBounds(399, 199, 730, 42);
		paneltotalegginventory.add(labelinventory);
		
		JLabel lblinicon = new JLabel("");
		lblinicon.setHorizontalAlignment(SwingConstants.CENTER);
		Image img4 = new ImageIcon(this.getClass().getResource("inventory icon.png")).getImage();
		lblinicon.setIcon(new ImageIcon(img4));
		lblinicon.setBounds(318, 254, 270, 251);
		paneltotalegginventory.add(lblinicon);
		
		JButton btncalculatenumoftrays = new JButton("Calculate No. of Trays and Eggs");
		btncalculatenumoftrays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium, Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("")  && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")  && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("")  && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("")  && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")  && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("")  && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small and Medium tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_largetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_largetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				
				String smalltray = textField_smalltrayin.getText();
				int answer1 = Integer.parseInt(smalltray);
				
				String mediumtray = textField_mediumtrayin.getText();
				int answer2 = Integer.parseInt(mediumtray);
				
				String largetray = textField_largetrayin.getText();
				int answer3 = Integer.parseInt(largetray);
				
				String extralargetray = textField_extralargetrayin.getText();
				int answer4 = Integer.parseInt(extralargetray);
				
				String jumbotray = textField_jumbotrayin.getText();
				int answer5 = Integer.parseInt(jumbotray);
				
				int totaltrays = answer1 + answer2 + answer3 + answer4 +answer5;
				String changetotal = String.valueOf(totaltrays);
				textField_totalnotrays.setText(changetotal);
				
			String totaleggin = textField_totalnotrays.getText();
			int totaleggs = Integer.parseInt(totaleggin);
			int totaleggsure = totaleggs * 30;
			String changetotal2 = String.valueOf(totaleggsure);
			textField_totalnoeggs.setText(changetotal2);
			}
		});
		btncalculatenumoftrays.setForeground(Color.DARK_GRAY);
		btncalculatenumoftrays.setFont(new Font("Tahoma", Font.BOLD, 15));
		btncalculatenumoftrays.setBounds(202, 632, 293, 25);
		paneltotalegginventory.add(btncalculatenumoftrays);
		
		JLabel lblPleaseInputThe = new JLabel("PLEASE INPUT THE DATE YOU UPDATED THE INVENTORY");
		lblPleaseInputThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseInputThe.setForeground(Color.DARK_GRAY);
		lblPleaseInputThe.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPleaseInputThe.setBounds(741, 266, 499, 19);
		paneltotalegginventory.add(lblPleaseInputThe);
		
		JLabel labelbox = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("order.png")).getImage();
		labelbox.setIcon(new ImageIcon(img5));
		labelbox.setHorizontalAlignment(SwingConstants.CENTER);
		labelbox.setBounds(1344, 199, 506, 475);
		paneltotalegginventory.add(labelbox);
		
		JButton btnLoadDatabase_2 = new JButton("LOAD INVENTORY LIST DATABASE");
		btnLoadDatabase_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showinventory();
			}
		});
		btnLoadDatabase_2.setForeground(Color.DARK_GRAY);
		btnLoadDatabase_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLoadDatabase_2.setBounds(837, 632, 302, 25);
		paneltotalegginventory.add(btnLoadDatabase_2);
		
		JButton btnClearAllText = new JButton("CLEAR ALL TEXT FIELDS");
		btnClearAllText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_smalltrayin.setText("0");
				textField_mediumtrayin.setText("0");
				textField_largetrayin.setText("0");
				textField_extralargetrayin.setText("0");
				textField_jumbotrayin.setText("0");
				
				textField_totalnoeggs.setText("0");
				textField_totalnodefects.setText("0");
				textField_totalnotrays.setText("0");
				
				textField_yeartotal.setText("");
				
				
				
			}
		});
		btnClearAllText.setForeground(Color.DARK_GRAY);
		btnClearAllText.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClearAllText.setBounds(683, 444, 235, 25);
		paneltotalegginventory.add(btnClearAllText);
		
		textField_yeartotal = new JTextField();
		textField_yeartotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_yeartotal.setColumns(10);
		textField_yeartotal.setBounds(1188, 320, 109, 29);
		textField_yeartotal.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		paneltotalegginventory.add(textField_yeartotal);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		panel.setBounds(12, 328, 294, 251);
		paneltotalegginventory.add(panel);
		panel.setLayout(null);
		
		textField_smalltrayin = new JTextField("0");
		textField_smalltrayin.setBounds(160, 18, 109, 29);
		panel.add(textField_smalltrayin);
		textField_smalltrayin.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_smalltrayin.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		textField_smalltrayin.setColumns(10);
		
		JLabel lblSmalltray_1 = new JLabel("Small (Tray)");
		lblSmalltray_1.setBounds(0, 23, 148, 19);
		panel.add(lblSmalltray_1);
		lblSmalltray_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSmalltray_1.setForeground(Color.DARK_GRAY);
		lblSmalltray_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblLargetray_1 = new JLabel("Medium (Tray)");
		lblLargetray_1.setBounds(0, 66, 148, 19);
		panel.add(lblLargetray_1);
		lblLargetray_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLargetray_1.setForeground(Color.DARK_GRAY);
		lblLargetray_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblExtraLargetray_1 = new JLabel("Large (Tray)");
		lblExtraLargetray_1.setBounds(0, 112, 148, 19);
		panel.add(lblExtraLargetray_1);
		lblExtraLargetray_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblExtraLargetray_1.setForeground(Color.DARK_GRAY);
		lblExtraLargetray_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblExtraLargetray_2 = new JLabel("Extra Large (Tray)");
		lblExtraLargetray_2.setBounds(0, 157, 148, 19);
		panel.add(lblExtraLargetray_2);
		lblExtraLargetray_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblExtraLargetray_2.setForeground(Color.DARK_GRAY);
		lblExtraLargetray_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblJumbotray_1 = new JLabel("Jumbo (Tray)");
		lblJumbotray_1.setBounds(0, 206, 148, 19);
		panel.add(lblJumbotray_1);
		lblJumbotray_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJumbotray_1.setForeground(Color.DARK_GRAY);
		lblJumbotray_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textField_mediumtrayin = new JTextField("0");
		textField_mediumtrayin.setBounds(160, 61, 109, 29);
		panel.add(textField_mediumtrayin);
		textField_mediumtrayin.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_mediumtrayin.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		textField_mediumtrayin.setColumns(10);
		
		textField_largetrayin = new JTextField("0");
		textField_largetrayin.setBounds(160, 107, 109, 29);
		panel.add(textField_largetrayin);
		textField_largetrayin.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_largetrayin.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		textField_largetrayin.setColumns(10);
		
		textField_extralargetrayin = new JTextField("0");
		textField_extralargetrayin.setBounds(160, 152, 109, 29);
		panel.add(textField_extralargetrayin);
		textField_extralargetrayin.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_extralargetrayin.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		textField_extralargetrayin.setColumns(10);
		
		textField_jumbotrayin = new JTextField("0");
		textField_jumbotrayin.setBounds(160, 201, 109, 29);
		panel.add(textField_jumbotrayin);
		textField_jumbotrayin.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_jumbotrayin.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		textField_jumbotrayin.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 207, 280, 97);
		paneltotalegginventory.add(panel_2);
		panel_2.setLayout(null);
		
		comboBox_invent = new JComboBox();
		comboBox_invent.setBounds(36, 45, 211, 29);
		panel_2.add(comboBox_invent);
		comboBox_invent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String query = "select * from egg_inventory where `Inventory No.`=?";
				PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
				pst.setString(1,  (String) comboBox_invent.getSelectedItem());
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()){
					textField_smalltrayin.setText(rs.getString("Small (Tray)"));
					textField_mediumtrayin.setText(rs.getString("Medium (Tray)"));
					textField_largetrayin.setText(rs.getString("Large (Tray)"));
					textField_extralargetrayin.setText(rs.getString("Extra Large (Tray)"));
					textField_extralargetrayin.setText(rs.getString("Extra Large (Tray)"));
					textField_totalnoeggs.setText(rs.getString("Total No. of Eggs"));
					textField_totalnotrays.setText(rs.getString("Total No. of Trays"));
					textField_totalnodefects.setText(rs.getString("Total No. of Defects"));
					comboBox_monthtotal.setSelectedItem(rs.getString("Month"));
					comboBox_daytotal.setSelectedItem(rs.getString("Day"));
					textField_yeartotal.setText(rs.getString("Year"));
					
				}
			} catch(Exception exc) {
				exc.printStackTrace();
			}

			}
		});
		
		comboBox_invent.setForeground(Color.DARK_GRAY);
		comboBox_invent.setFont(new Font("Tahoma", Font.BOLD, 15));
		
	
			
			JLabel lblInventoryNo = new JLabel("INVENTORY NO.");
			lblInventoryNo.setBounds(36, 13, 211, 19);
			panel_2.add(lblInventoryNo);
			lblInventoryNo.setHorizontalAlignment(SwingConstants.CENTER);
			lblInventoryNo.setForeground(Color.DARK_GRAY);
			lblInventoryNo.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			JLabel lblSearchInventory = new JLabel("SEARCH INVENTORY");
			lblSearchInventory.setHorizontalAlignment(SwingConstants.CENTER);
			lblSearchInventory.setForeground(Color.DARK_GRAY);
			lblSearchInventory.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblSearchInventory.setBounds(762, 500, 434, 19);
			paneltotalegginventory.add(lblSearchInventory);
			
			JLabel label = new JLabel("INVENTORY NO.");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(Color.DARK_GRAY);
			label.setFont(new Font("Tahoma", Font.BOLD, 15));
			label.setBounds(692, 546, 171, 19);
			paneltotalegginventory.add(label);
			
			textField_searchinvent = new JTextField();
			textField_searchinvent.setFont(new Font("Tahoma", Font.BOLD, 15));
			textField_searchinvent.setColumns(10);
			textField_searchinvent.setBounds(722, 578, 109, 29);
			textField_searchinvent.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent arg0) {
					char c = arg0.getKeyChar();
					if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
						getToolkit().beep();
						arg0.consume();
					}
				}
			});
			textField_searchinvent.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0) {
					try { 
						String query = "select * from egg_inventory where `Inventory No.` = ?";
						java.sql.PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1, textField_searchinvent.getText());
						ResultSet rs = pst.executeQuery();
						
						tabletotalegginventory.setModel(DbUtils.resultSetToTableModel(rs));
					//	while(rs.next()) {
					//		
					//	}
						
					} catch (Exception exc) {
						exc.printStackTrace();
					
				}
				}
			});	
			paneltotalegginventory.add(textField_searchinvent);
			
			JLabel label_1 = new JLabel("Month");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setForeground(Color.DARK_GRAY);
			label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			label_1.setBounds(903, 548, 46, 14);
			paneltotalegginventory.add(label_1);
			
			JLabel label_2 = new JLabel("Day");
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setForeground(Color.DARK_GRAY);
			label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			label_2.setBounds(1051, 548, 46, 14);
			paneltotalegginventory.add(label_2);
			
			textField_searchmonth = new JTextField();
			textField_searchmonth.setFont(new Font("Tahoma", Font.BOLD, 15));
			textField_searchmonth.setColumns(10);
			textField_searchmonth.setBounds(876, 578, 109, 29);
			textField_searchmonth.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent arg0) {
					char c = arg0.getKeyChar();
					if (! (Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
						getToolkit().beep();
						arg0.consume();
					}
				}
			});
			textField_searchmonth.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0) {
					try { 
						String query = "select * from egg_inventory where `Month` = ?";
						java.sql.PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1, textField_searchmonth.getText());
						ResultSet rs = pst.executeQuery();
						
						tabletotalegginventory.setModel(DbUtils.resultSetToTableModel(rs));
					//	while(rs.next()) {
					//		
					//	}
						
					} catch (Exception exc) {
						exc.printStackTrace();
					
				}
				}
			});	
			paneltotalegginventory.add(textField_searchmonth);
			
			JLabel label_3 = new JLabel("Year");
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setForeground(Color.DARK_GRAY);
			label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
			label_3.setBounds(1194, 548, 46, 14);
			paneltotalegginventory.add(label_3);
			
			textField_searchday = new JTextField();
			textField_searchday.setFont(new Font("Tahoma", Font.BOLD, 15));
			textField_searchday.setColumns(10);
			textField_searchday.setBounds(1020, 578, 109, 29);
			textField_searchday.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent arg0) {
					char c = arg0.getKeyChar();
					if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
						getToolkit().beep();
						arg0.consume();
					}
				}
			});
			textField_searchday.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0) {
					try { 
						String query = "select * from egg_inventory where `Day` = ?";
						java.sql.PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1, textField_searchday.getText());
						ResultSet rs = pst.executeQuery();
						
						tabletotalegginventory.setModel(DbUtils.resultSetToTableModel(rs));
					//	while(rs.next()) {
					//		
					//	}
						
					} catch (Exception exc) {
						exc.printStackTrace();
					
				}
				}
			});	
			paneltotalegginventory.add(textField_searchday);
			
			textField_searchyear = new JTextField();
			textField_searchyear.setFont(new Font("Tahoma", Font.BOLD, 15));
			textField_searchyear.setColumns(10);
			textField_searchyear.setBounds(1166, 578, 109, 29);
			textField_searchyear.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent arg0) {
					char c = arg0.getKeyChar();
					if (! (Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))) {
						getToolkit().beep();
						arg0.consume();
					}
				}
			});
			textField_searchyear.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0) {
					try { 
						String query = "select * from egg_inventory where `Year` = ?";
						java.sql.PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1, textField_searchyear.getText());
						ResultSet rs = pst.executeQuery();
						
						tabletotalegginventory.setModel(DbUtils.resultSetToTableModel(rs));
					//	while(rs.next()) {
					//		
					//	}
						
					} catch (Exception exc) {
						exc.printStackTrace();
					
				}
				}
			});	
			paneltotalegginventory.add(textField_searchyear);
			
			JButton btnUpdateInventory = new JButton("Update inventory");
			btnUpdateInventory.setForeground(Color.DARK_GRAY);
			btnUpdateInventory.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnUpdateInventory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
					
						String query = "Update `egg_inventory` set `Inventory No.` = ' " +  comboBox_invent.getSelectedItem() +" ',`Total No. of Trays`='"+textField_totalnotrays.getText() +"',`Total No. of Eggs`='"+textField_totalnoeggs.getText()+"' ,`Total No. of Defects`='"+textField_totalnodefects.getText()+"',`Year`='"+textField_yeartotal.getText()+"',`Month`='"+comboBox_monthtotal.getSelectedItem()+"',`Day`='"+comboBox_daytotal.getSelectedItem()+ "',`Small (Tray)`='"+textField_smalltrayin.getText() + "',`Medium (Tray)`='"+textField_mediumtrayin.getText() + "',`Large (Tray)`='"+textField_largetrayin.getText() + "',`Extra Large (Tray)`='"+textField_extralargetrayin.getText() + "',`Jumbo (Tray)`='"+textField_jumbotrayin.getText() + 
								" ' where `Inventory No.` = ' " +  comboBox_invent.getSelectedItem()   + " ' ";
				java.sql.PreparedStatement pst = connection.prepareStatement(query);
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium, Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("")  && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")  && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Large, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("")  && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("")  && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")  && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("")  && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small, Medium and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_mediumtrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small and Medium tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_largetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_largetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium and Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_largetrayin.getText().equals("") && textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Large and Extra Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_largetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_extralargetrayin.getText().equals("") && textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Extra Large and Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_smalltrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Small tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_mediumtrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Medium tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_largetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_extralargetrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Large tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_jumbotrayin.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Total No. of Jumbo tray/trays is empty. State a value.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_totalnoeggs.getText().equals("") && textField_totalnotrays.getText().equals("") && textField_totalnodefects.getText().equals("") && textField_yeartotal.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Input total No. of eggs, trays and defects and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if ( textField_totalnotrays.getText().equals("") && textField_totalnodefects.getText().equals("") && textField_yeartotal.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Input total No. of trays and defects and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_totalnoeggs.getText().equals("") && textField_totalnodefects.getText().equals("") && textField_yeartotal.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Input total No. of eggs and defects and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_totalnoeggs.getText().equals("") && textField_totalnotrays.getText().equals("") && textField_yeartotal.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Input total No. of eggs and trays and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_totalnoeggs.getText().equals("") && textField_totalnotrays.getText().equals("") && textField_totalnodefects.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Input total No. of eggs, trays and defects.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_totalnoeggs.getText().equals("") && textField_totalnotrays.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Input total No. of eggs and trays.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_totalnoeggs.getText().equals("") && textField_totalnodefects.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Input total No. of eggs and defects.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_totalnoeggs.getText().equals("") && textField_yeartotal.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Input total No. of eggs and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_totalnotrays.getText().equals("") && textField_totalnodefects.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Input total No. of trays and defects.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_totalnotrays.getText().equals("") && textField_yeartotal.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Input total No. of trays and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				if (textField_totalnodefects.getText().equals("") && textField_yeartotal.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Input total No. of defects and year.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				
				if (textField_totalnoeggs.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,"Input Total No. of eggs.","Invalid Input", JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				pst.execute();
				
				JOptionPane.showMessageDialog(null, "Data at Inventory " +  comboBox_invent.getSelectedItem() + " has been Updated!");
				
				pst.close();
				
			} catch (Exception exc) {
				exc.printStackTrace();
			}
					showinventory();
				}

			});
			btnUpdateInventory.setBounds(1040, 392, 235, 25);
			
			
			paneltotalegginventory.add(btnUpdateInventory);
			
			

		fillComboBox2();
		fillComboBox3();
	}
}
