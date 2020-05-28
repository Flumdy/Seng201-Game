package displays;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSlider;

import main.GameEnviroment;
import supers.SpaceShip;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * Select the number of days (between 3 and 10) you wish to play through. <br>
 * The number of days determines how many ship parts will need to be found. <br>
 * The number of ship parts is 2/3 the number of days.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class SelectDays {

	private JFrame frmHowManyDays;
	public GameEnviroment game;
	public int numInt;

	/**
	 * Create the game object and initialize SelectDays window.
	 */
	public SelectDays() {
		game = new GameEnviroment();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHowManyDays = new JFrame();
		frmHowManyDays.setTitle("How Many Day Would You Like Your Adventure To Last?");
		frmHowManyDays.setBounds(100, 100, 630, 192);
		frmHowManyDays.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHowManyDays.getContentPane().setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(264, 38, 91, 38);
		frmHowManyDays.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("OKAY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int number = Integer.parseInt((String) comboBox.getSelectedItem());
				game.setGameDays(number);
				System.out.println(game.getGameDays());
				ShipAndCrew shipAndCrew = new ShipAndCrew(game);
				shipAndCrew.getFrmSelectCrew().setVisible(true);
				frmHowManyDays.dispose();
			}
		});
		btnNewButton.setBounds(250, 106, 120, 25);
		frmHowManyDays.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SelectDays.class.getResource("/displays/sprites/space.jpg")));
		lblNewLabel.setBounds(0, -22, 657, 216);
		frmHowManyDays.getContentPane().add(lblNewLabel);
	}

	/**
	 * 
	 */
	public JFrame getFrmHowManyDay() {
		return frmHowManyDays;
	}

	/**
	 * 
	 * @param frmHowManyDay
	 */
	public void setFrmHowManyDay(JFrame frmHowManyDay) {
		this.frmHowManyDays = frmHowManyDay;
	}

	/**
	 * 
	 */
	public GameEnviroment getGame() {
		return game;
	}

	/**
	 * 
	 * @param game
	 */
	public void setGame(GameEnviroment game) {
		this.game = game;
	}
}
