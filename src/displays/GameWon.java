package displays;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import main.GameEnviroment;

import javax.swing.JPanel;
import java.awt.Color;

/**
 * Displays game won screen with information on how many days you lasted <br> 
 * and your final score. <br>
 * Then prompts player to either restart the game or exit it.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class GameWon {

	private JFrame frmCongratulations;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWon window = new GameWon(game);
					window.frmCongratulations.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	/**
	 * Create the application.
	 * @param game Game object that information about the current game can be accessed through.
	 */
	public GameWon(GameEnviroment game) {
		initialize(game);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param game Game object that information about the current game can be accessed through.
	 */
	private void initialize(GameEnviroment game) {
		frmCongratulations = new JFrame();
		frmCongratulations.setTitle("CONGRATULATIONS!");
		frmCongratulations.setBounds(100, 100, 450, 300);
		frmCongratulations.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCongratulations.getContentPane().setLayout(null);
		

		JButton btnRestart = new JButton("RESTART");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartScreen restart = new StartScreen();
				restart.getFrmTripInSpace().setVisible(true);
				frmCongratulations.dispose();
			}
		});
		btnRestart.setBounds(152, 167, 114, 25);
		frmCongratulations.getContentPane().add(btnRestart);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnClose.setBounds(152, 204, 114, 25);
		frmCongratulations.getContentPane().add(btnClose);
		
		JLabel lblGameInfo = new JLabel("<html>Well done! <br>You found all the parts and managed to repair the " + game.getSpaceShip().name + "." +
				"<br>Days in space: " + game.getCurrentDay() + 
				"<br>Score: " + game.getSpaceShip().name.length() * 34 +
				"<br>Would you like to try again?</html?");
		lblGameInfo.setBounds(67, 27, 301, 128);
		lblGameInfo.setBounds(67, 28, 301, 127);
		frmCongratulations.getContentPane().add(lblGameInfo);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 29, 328, 118);
		frmCongratulations.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GameWon.class.getResource("/displays/sprites/space2.jpg")));
		lblNewLabel.setBounds(-17, -15, 547, 324);
		frmCongratulations.getContentPane().add(lblNewLabel);
		
		
	}
	
	/**
	 * 
	 */
	public JFrame getFrmCongratulations() {
		return frmCongratulations;
	}

	/**
	 * 
	 * @param frmCongratulations
	 */
	public void setFrmCongratulations(JFrame frmCongratulations) {
		this.frmCongratulations = frmCongratulations;
	}

	/**
	 * 
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * 
	 * @param textField
	 */
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
