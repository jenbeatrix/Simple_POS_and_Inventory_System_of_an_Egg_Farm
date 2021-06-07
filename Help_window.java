import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Label;


public class Help_window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help_window frame = new Help_window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initialize() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon-help-128.png")));
	}
		/**
	 * Create the frame.
	 */
	public Help_window() {
		super("Help");
		initialize();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 852, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image img2 = new ImageIcon(this.getClass().getResource("help.png")).getImage();
		contentPane.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(0, 79, 231, 212);
		contentPane.add(lblNewLabel);
		
		JLabel lblInstructionsInUsing = new JLabel("INSTRUCTIONS IN USING THE PROGRAM:");
		lblInstructionsInUsing.setForeground(Color.DARK_GRAY);
		lblInstructionsInUsing.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblInstructionsInUsing.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructionsInUsing.setBounds(37, 13, 552, 53);
		contentPane.add(lblInstructionsInUsing);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setText("Help Item\r\n\r\nHow to register as new administrator?\r\n1.\tOne can register only by an approval of an old /existing administrator in the program. A confirm user window will pop up and an existing administrator must log in to verify.\r\n2.\tNow, you can input new username, password etc.\r\n3.\tClick the register button.\r\n\r\nHow to save customers?\r\n1.\tFill in the values needed. (First name, Middle name, Last name and Contact number) \r\n2.\tClick the Register button. After that, a customer will be given an assigned Account number automatically then updates on the combo box.\r\n\r\nHow to update customer info?\r\n1.\tChoose an account number in the combo box.\r\n2.\tAfter choosing, the text fields will be filled with the values according to its assigned account number.\r\n3.\tNow, you can change values you would want to change.\r\n4.\tClick Update customer button.\r\n\r\nHow to delete customer?\r\n1.\tChoose an account number in the combo box.\r\n2.\tClick Send to Customer bin. (This does not permanently delete customer info but just transfers itself into the customer bin.\r\n\r\nWhere do I find the customer bin, inventory bin and list of administrators?\r\n1.\tYou can find it in the view menu.\r\n\r\nHow to search customers?\r\n1.\tOn the sides of the text fields of values needed for the account info, there you will see Search first name, middle name and last name. Search customers on any of the search text fields.\r\n2.\tClick Load Database button below to load all values inside the table. \r\n\r\nHow to Order?\r\n1.\tFirst, input the number of egg tray by sizes the customer wishes to buy.\r\n2.\tClick Calculate total button to calculate the total amount.\r\n3.\tClick Add to Cart button to save data.\r\n\r\nHow to View Full Receipt?\r\n1.\tClick the View Receipt.\r\n2.\tChoose a Receipt No. inside the combo box you would want to view.\r\n\r\nHow to delete orders?\r\n1.\tChoose a Receipt number on the combo box.\r\n2.\tClick the delete button to delete an order permanently.\r\n\r\nHow to Clear text fields instantly?\r\n1.\tTo delete full text fields instantly, just click clear text fields button.\r\nHow to add an inventory?\r\n1.\tFill the values needed to save an inventory.\r\n2.\tClick the add to inventory button.\r\n\r\nHow to Calculate No. of Trays and Eggs?\r\n1.\tFill the number of trays by sizes added to inventory.\r\n2.\tClick the Calculate No. of Trays and Eggs button and then the program will instantly calculate the total no. of eggs and trays released.\r\n\r\nHow to update inventory?\r\n1.\tChoose an assigned Inventory no. inside the combo box.\r\n2.\tChange the values you wish to change.\r\n3.\tClick the Update inventory button.\r\n\r\nHow to delete inventory?\r\n1.\tChoose an assigned Inventory no. inside the combo box.\r\n2.\tClick Send to Inventory bin to delete an inventory. The program does not delete the inventory permanently but sends it instead to the inventory bin.\r\n\r\nHow to Search an inventory?\r\n1.\tJust Choose what text field would you like to search on the table with. (Inventory No. text field, Month, day and year text fields)\r\n2.\tAfter searching click Load database again to lead full values inside the table.\r\n\r\nHow to Delete an inventory Permanently?\r\n1.\tGo to View menu and click Inventory bin.\r\n2.\tOnly Administrators can delete inventories permanently.\r\n3.\tChoose an Inventory No. you wish to delete. (Remember, Inventory No. should not duplicate in the inventory bin delete by choosing in the combo box. It would be much better that after deleting an inventory, if you would really wish to delete it permanently, just do so immediately.)\r\n4.\tClick the delete button.\r\n\r\nHow to Delete a customer Permanently?\r\n1.\tGo to View menu and click Customer bin.\r\n2.\tOnly Administrators can delete customers permanently.\r\n3.\tChoose an Account No. you wish to delete by choosing in the combo box. (Remember, Account No. should not duplicate in the customer bin. It would be much better that after deleting an inventory, if you would really wish to delete it permanently, just do so immediately.) \r\n4.\tClick the Delete button.\r\n\r\nHow to Delete an administrator?\r\n1.\tGo to View menu and click List of administrators.\r\n2.\tOnly Administrators can delete existing administrators.\r\n3.\tChoose an administrator you wish to delete by choosing in the combo box.\r\n4.\tClick the Delete button.\r\n\r\n How to sign out?\r\n1.\tGo to Options menu and click Sign out.\r\n2.\tA dialog will pop up and will confirm if you would really wish to log out or not.\r\n\r\n");
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textArea.setBounds(239, 79, 572, 302);
		contentPane.add(textArea);
		
		
	}
}
