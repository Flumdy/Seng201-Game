package displays;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import main.GameEnviroment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 * Displays game over screen with information on how many days you lasted, <br> 
 * how many ship parts were found, and your final score. <br>
 * Then prompts player to either restart the game or exit it.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class GameOver {

	private JFrame frmGameOver;
	private JTextField textField;

	/**
	 * Create the application.
	 * 
	 * @param game Game object with which game information can be accessed.
	 */
	public GameOver(GameEnviroment game) {
		initialize(game);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param game Game object with which game information can be accessed.
	 */
	private void initialize(final GameEnviroment game) {
		frmGameOver = new JFrame();
		frmGameOver.setTitle("GAME OVER!");
		frmGameOver.setBounds(100, 100, 450, 300);
		frmGameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameOver.getContentPane().setLayout(null);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartScreen restart = new StartScreen();
				restart.getFrmTripInSpace().setVisible(true);
				frmGameOver.dispose();
			}
		});
		btnRestart.setBounds(164, 173, 114, 25);
		frmGameOver.getContentPane().add(btnRestart);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnClose.setBounds(164, 210, 114, 25);
		frmGameOver.getContentPane().add(btnClose);
		
		JLabel lblEndGame = new JLabel("<html> Unfortunately you were not able to repair the " + game.getSpaceShip().name + "." +
					"<br>Days in space: " + game.getCurrentDay() + "<br>Parts collected: " + game.getShipPiecesFound() + "/" + game.getShipPieces() +
					"<br>Score: " + game.getSpaceShip().name.length() * 34 +
					"<br>Would you like to try again?</html?");
		lblEndGame.setBounds(79, 22, 297, 139);
		frmGameOver.getContentPane().add(lblEndGame);
		
		JPanel panel = new JPanel();
		panel.setBounds(71, 40, 319, 99);
		frmGameOver.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GameOver.class.getResource("/displays/sprites/space2.jpg")));
		lblNewLabel.setBounds(0, -15, 488, 309);
		frmGameOver.getContentPane().add(lblNewLabel);

	}
	
	/**
	 * Opens GameOver window.
	 */
	public JFrame getFrmGameOver() {
		return frmGameOver;
	}
	/**
	 * 
	 * @param frmGameOver
	 */
	public void setFrmGameOver(JFrame frmGameOver) {
		this.frmGameOver = frmGameOver;
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
