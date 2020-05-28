package displays;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.GameEnviroment;
import supers.ConsumableItem;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Window where players can spend their money to <br>
 * acquire various consumable items.
 * 
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class Shop {

	private JFrame frmShippyShop;
	private int cartCost = 0;
	/**
	 * Create the application.
	 * 
	 * @param gamePassed Game object with which game information can be accessed.
	 */
	public Shop(GameEnviroment gamePassed) {
		initialize(gamePassed);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param game Game object with which game information can be accessed.
	 */
	private void initialize(final GameEnviroment game) {
		frmShippyShop = new JFrame();
		frmShippyShop.setTitle("Shippy Shop");
		frmShippyShop.setBounds(100, 100, 566, 435);
		frmShippyShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShippyShop.getContentPane().setLayout(null);
		
		final JLabel lblWallet = new JLabel("Wallet");
		lblWallet.setBounds(128, 162, 66, 15);
		frmShippyShop.getContentPane().add(lblWallet);
		lblWallet.setText(Integer.toString(game.getSpaceShip().getMoney()));
		
		final JLabel lblcontents = new JLabel("*Contents*");
		lblcontents.setBounds(118, 326, 238, 69);
		frmShippyShop.getContentPane().add(lblcontents);
		lblcontents.setText(game.getShop().getCart().toString());
		
		final JLabel lblCart = new JLabel("Cart:");
		lblCart.setBounds(128, 289, 66, 25);
		frmShippyShop.getContentPane().add(lblCart);
		
		
		final JComboBox itemsComboBox = new JComboBox();
		itemsComboBox.setBounds(12, 189, 267, 24);
		frmShippyShop.getContentPane().add(itemsComboBox);
		itemsComboBox.setModel(new DefaultComboBoxModel(game.getShop().getInventory().toArray()));
		
		final JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(422, 178, 66, 25);
		frmShippyShop.getContentPane().add(lblCost);
		lblCost.setText("0");
		
		
		JButton btnLeave = new JButton("Leave");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if items in cart return them to inventory
				game.getShop().returnItems();
				lblcontents.setText(game.getShop().getCart().toString());
				cartCost = 0;
				lblCost.setText(Integer.toString(cartCost));
				GameWindow gameWindow = new GameWindow(game);
				gameWindow.getFrmDayx().setVisible(true);
				frmShippyShop.dispose();
			}
		});
		btnLeave.setBounds(374, 363, 114, 25);
		frmShippyShop.getContentPane().add(btnLeave);
		
		JButton btnAddToCart = new JButton("Add To Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cartCost += game.getShop().addToCart((ConsumableItem) itemsComboBox.getSelectedItem(), game, cartCost);
				lblCost.setText(Integer.toString(cartCost));
				itemsComboBox.setModel(new DefaultComboBoxModel(game.getShop().getInventory().toArray()));
				lblcontents.setText(game.getShop().getCart().toString());
				lblWallet.setText(Integer.toString(game.getSpaceShip().getMoney()));
				//add to text cart rep
			}
		});
		btnAddToCart.setBounds(118, 252, 114, 25);
		frmShippyShop.getContentPane().add(btnAddToCart);
		
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.getShop().checkOut(game);
				itemsComboBox.setModel(new DefaultComboBoxModel(game.getShop().getInventory().toArray()));
				lblcontents.setText(game.getShop().getCart().toString());
				lblCost.setText("0");
				lblWallet.setText(Integer.toString(game.getSpaceShip().getMoney()));
			}
		});
		btnPurchase.setBounds(374, 326, 114, 25);
		frmShippyShop.getContentPane().add(btnPurchase);
		
		JLabel lblWallet_1 = new JLabel("Wallet:");
		lblWallet_1.setBounds(72, 162, 66, 15);
		frmShippyShop.getContentPane().add(lblWallet_1);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Shop.class.getResource("/displays/sprites/shop.jpg")));
		lblBackground.setBounds(-81, 0, 647, 526);
		frmShippyShop.getContentPane().add(lblBackground);
		
		


	}

	/**
	 * 
	 */
	public JFrame getFrmShippyShop() {
		return frmShippyShop;
	}

	/**
	 * 
	 * @param frmShippyShop
	 */
	public void setFrmShippyShop(JFrame frmShippyShop) {
		this.frmShippyShop = frmShippyShop;
	}
}
