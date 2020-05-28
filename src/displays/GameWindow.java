//need a button to confirm action, and need to update stats when the crew memebr is changed in the combo box


//ERRORS:
//Next day bugs out with a index out of range error for some reason
//crew members need to be removed from drop down box / needs to be updated
//

package displays;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.GameEnviroment;
import supers.ConsumableItem;
import supers.CrewMember;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * Game Window which acts as the central hub of the game. All actions after the game begins are accessible through this display. <br>
 * Shop, moving to next day, all characters actions, selecting pilots, and moving to next planet.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 *
 */
public class GameWindow {

	private JFrame frmDayx;
	private GameEnviroment game;

	/**
	 * Create the application.
	 * 
	 * @param gamePassed Game object with which game information can be accessed.
	 */
	public GameWindow(GameEnviroment passedGame) {
		game = passedGame;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmDayx(new JFrame());
		getFrmDayx().setBounds(100, 100, 936, 773);
		getFrmDayx().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmDayx().getContentPane().setLayout(null);
		
		
		final JLabel lblNewLabel_3 = new JLabel("shipStats");
		lblNewLabel_3.setBounds(301, 625, 348, 76);
		frmDayx.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setText("<html>Shields: " + game.getSpaceShip().getShields() + "<br/>Ship Peices Found: " + game.getShipPiecesFound() + "/" + game.getShipPieces() + "<br/>Money: $" + game.getSpaceShip().getMoney());
		
		JLabel lblplanetImage = new JLabel("");
		lblplanetImage.setIcon(new ImageIcon(GameWindow.class.getResource("/displays/sprites/planet-opal.png")));
		lblplanetImage.setBounds(56, 35, 520, 412);
		getFrmDayx().getContentPane().add(lblplanetImage);
		
		JLabel lblPlanetNamew = new JLabel("Planet Name");
		lblPlanetNamew.setText(game.getCurrentPlanet().getName());
		lblPlanetNamew.setBounds(122, 12, 101, 15);
		getFrmDayx().getContentPane().add(lblPlanetNamew);
		
		JButton btnShop = new JButton("Crazy Cat Lady");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Shop shop = new Shop(game);
				shop.getFrmShippyShop().setVisible(true);
				frmDayx.dispose();
			}
		});
		btnShop.setBounds(47, 563, 154, 138);
		getFrmDayx().getContentPane().add(btnShop);
		
		JLabel lblCrewMembers = new JLabel("Crew Members");
		lblCrewMembers.setBounds(594, 12, 148, 15);
		getFrmDayx().getContentPane().add(lblCrewMembers);
		
		
		final JLabel lblDayX = new JLabel("Day x");
		lblDayX.setText("Day: " + Integer.toString(game.getCurrentDay()));
		lblDayX.setBounds(441, 0, 66, 15);
		frmDayx.getContentPane().add(lblDayX);
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(594, 28, 183, 24);
		getFrmDayx().getContentPane().add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(game.getSpaceShip().getCrewList().toArray()));
		
		final JLabel lblNewLabel_1 = new JLabel("Health, Hunger,Energy'");
		lblNewLabel_1.setBounds(695, 527, 183, 206);
		getFrmDayx().getContentPane().add(lblNewLabel_1);
		CrewMember tempCrewMember = (CrewMember) comboBox.getSelectedItem();
		//needs to be formatted and update on selection
		lblNewLabel_1.setText("<html>Health: " + game.getCurrentCrewMember().getHealth() + "<br/>" + "Hunger: "
		+ game.getCurrentCrewMember().getHunger() + "<br/>" + "Energy: " + game.getCurrentCrewMember().getTiredness() + "</html>");
		
		
		JLabel lblActions = new JLabel("Actions");
		lblActions.setBounds(594, 86, 66, 15);
		getFrmDayx().getContentPane().add(lblActions);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(594, 101, 183, 24);
		getFrmDayx().getContentPane().add(comboBox_1);
		//different option for piloting
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Search", "Sleep", "Repair", "Consume", "Pilot"}));
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(281, 590, 379, 24);
		frmDayx.getContentPane().add(comboBox_2);
		comboBox_2.setModel(new DefaultComboBoxModel(game.getSpaceShip().getInventory().toArray()));
		
		JLabel lblshipName = new JLabel("*Ship Name*");
		lblshipName.setBounds(368, 459, 108, 15);
		getFrmDayx().getContentPane().add(lblshipName);
		lblshipName.setText(game.getSpaceShip().name);
		
		JLabel lblCrazyCatLady = new JLabel("Crazy Cat Lady");
		lblCrazyCatLady.setBounds(69, 522, 154, 15);
		getFrmDayx().getContentPane().add(lblCrazyCatLady);
		
		final JLabel lblActionsLeft = new JLabel("Actions Left: ");
		lblActionsLeft.setBounds(629, 64, 148, 15);
		frmDayx.getContentPane().add(lblActionsLeft);
		lblActionsLeft.setText("Actions Left: " + game.getCurrentCrewMember().getActionsLeft());
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.setCurrentCrewMember((CrewMember) comboBox.getSelectedItem());
				lblNewLabel_1.setText("<html>Health: " + game.getCurrentCrewMember().getHealth() + "<br/>" + "Hunger: "
				+ game.getCurrentCrewMember().getHunger() + "<br/>" + "Energy: " + game.getCurrentCrewMember().getTiredness() + "</html>");
				lblActionsLeft.setText("Actions Left: " + game.getCurrentCrewMember().getActionsLeft());
				lblNewLabel_3.setText("<html>Shields: " + game.getSpaceShip().getShields() + "<br/>Ship Peices Found: " + game.getShipPiecesFound() + "/" + game.getShipPieces() + "<br/>Money: $" + game.getSpaceShip().getMoney());
			}
		});
		btnNewButton_1.setBounds(810, 28, 114, 25);
		frmDayx.getContentPane().add(btnNewButton_1);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tempAction = (String) comboBox_1.getSelectedItem();
				System.out.println(tempAction);
				game.setCurrentCrewMember((CrewMember) comboBox.getSelectedItem());
				if(tempAction.equals("Consume")) {
					game.useItem((ConsumableItem) comboBox_2.getSelectedItem(), game);
				}else if(tempAction.equals("Pilot")){
					Pilots pilots = new Pilots(game);
					pilots.getFrmSelectPilots().setVisible(true);
					frmDayx.dispose();
				}else {
					String tempMessage = game.charActions(tempAction, game);
					if(tempMessage.equals("won")) {
						GameWon gameWon = new GameWon(game);
						gameWon.getFrmCongratulations().setVisible(true);
						frmDayx.dispose();
					}else {
						System.out.println(tempMessage);
						PlanetVisit planetVisit = new PlanetVisit(tempMessage);
						planetVisit.getFrmPlanetName().setVisible(true);
					}
				}
				lblNewLabel_1.setText("<html>Health: " + game.getCurrentCrewMember().getHealth() + "<br/>" + "Hunger: "
						+ game.getCurrentCrewMember().getHunger() + "<br/>" + "Energy: " + game.getCurrentCrewMember().getTiredness() + "</html>");
				comboBox_2.setModel(new DefaultComboBoxModel(game.getSpaceShip().getInventory().toArray()));
				lblNewLabel_3.setText("<html>Shields: " + game.getSpaceShip().getShields() + "<br/>Ship Peices Found: " + game.getShipPiecesFound() + "/" + game.getShipPieces() + "<br/>Money: $" + game.getSpaceShip().getMoney());
				lblActionsLeft.setText("Actions Left: " + game.getCurrentCrewMember().getActionsLeft());
			}
		});
		btnConfirm.setBounds(810, 101, 114, 25);
		frmDayx.getContentPane().add(btnConfirm);
		
		JLabel lblNewLabel_2 = new JLabel("SHIP INVENTORY:");
		lblNewLabel_2.setBounds(368, 563, 176, 15);
		frmDayx.getContentPane().add(lblNewLabel_2);
		
		JButton btnNextDay = new JButton("Next Day!");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nextDay = game.nextDay(game);
				if(nextDay.equals("end")) {
					GameOver gameOver = new GameOver(game);
					gameOver.getFrmGameOver().setVisible(true);
					frmDayx.dispose();
				}else {
					overnightHappened OverNightPopUp = new overnightHappened(nextDay, game);
					OverNightPopUp.getFrmOvernight().setVisible(true);
					lblNewLabel_1.setText("<html>Health: " + game.getCurrentCrewMember().getHealth() + "<br/>" + "Hunger: "
							+ game.getCurrentCrewMember().getHunger() + "<br/>" + "Energy: " + game.getCurrentCrewMember().getTiredness() + "</html>");
					comboBox_2.setModel(new DefaultComboBoxModel(game.getSpaceShip().getInventory().toArray()));
					lblNewLabel_3.setText("<html>Shields: " + game.getSpaceShip().getShields() + "<br/>Ship Peices Found: " + game.getShipPiecesFound() + "/" + game.getShipPieces() + "<br/>Money: $" + game.getSpaceShip().getMoney());
					lblActionsLeft.setText("Actions Left: " + game.getCurrentCrewMember().getActionsLeft());
					comboBox.setModel(new DefaultComboBoxModel(game.getSpaceShip().getCrewList().toArray()));
					lblDayX.setText("Day: "+ Integer.toString(game.getCurrentDay()));
				}
			}
		});
		btnNextDay.setBounds(722, 285, 114, 25);
		frmDayx.getContentPane().add(btnNextDay);
		
		JLabel label = new JLabel("");
		label.setBounds(123, 326, 66, 15);
		frmDayx.getContentPane().add(label);
	}

	/**
	 * 
	 */
	public JFrame getFrmDayx() {
		return frmDayx;
	}

	/**
	 * 
	 * @param frmDayx
	 */
	public void setFrmDayx(JFrame frmDayx) {
		this.frmDayx = frmDayx;
	}
}
