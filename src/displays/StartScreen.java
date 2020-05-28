package displays;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.GameEnviroment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Window simply displaying title of game and a start button. <br>
 * Once selected the game object is created and the game begins.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class StartScreen {

	private JFrame frmTripInSpace;
	/**
	 * Launch the application.
	 * 
	 * @param args A string containing any command line arguments.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen();
					window.getFrmTripInSpace().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmTripInSpace(new JFrame());
		getFrmTripInSpace().setTitle("A Trip In Space");
		getFrmTripInSpace().setBounds(100, 100, 678, 450);
		getFrmTripInSpace().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmTripInSpace().getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SelectDays selectDays = new SelectDays();
				selectDays.getFrmHowManyDay().setVisible(true);
				getFrmTripInSpace().dispose();
			}

		});
		btnStart.setBounds(277, 299, 114, 25);
		getFrmTripInSpace().getContentPane().add(btnStart);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(StartScreen.class.getResource("/displays/sprites/spaceship.jpeg")));
		lblImage.setBounds(-40, 0, 706, 524);
		getFrmTripInSpace().getContentPane().add(lblImage);
	}

	/**
	 * 
	 */
	public JFrame getFrmTripInSpace() {
		return frmTripInSpace;
	}

	/**
	 * 
	 * @param frmTripInSpace
	 */
	public void setFrmTripInSpace(JFrame frmTripInSpace) {
		this.frmTripInSpace = frmTripInSpace;
	}
}
