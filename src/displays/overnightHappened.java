package displays;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.GameEnviroment;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 *
 */
public class overnightHappened extends JFrame {

	private JFrame frmOvernight;
	private String message;
	private GameEnviroment game;
	/**
	 * Create the frame.
	 */
	public overnightHappened(String messagePass, GameEnviroment game) {
		this.message = messagePass;
		this.game = game;
		initialize();
	}

	private void initialize() {
		frmOvernight = new JFrame();
		frmOvernight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOvernight.setBounds(100, 100, 450, 300);
		frmOvernight.getContentPane().setLayout(null);
		frmOvernight.setTitle("Overnight");
		
		JLabel lblInfo = new JLabel("info");
		lblInfo.setBounds(10, 0, 428, 191);
		lblInfo.setText(this.message);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(0, 195, 438, 65);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(game.getSpaceShip().getShields() <= 0 || game.getSpaceShip().getCrewList().size() <= 0) {
					GameOver gameOver = new GameOver(game);
					gameOver.getFrmGameOver().setVisible(true);
					frmOvernight.dispose();
				}else {
					frmOvernight.dispose();
				}
			}
		});
		frmOvernight.getContentPane().add(btnOk);
		frmOvernight.getContentPane().add(lblInfo);
	}

	public JFrame getFrmOvernight() {
		return frmOvernight;
	}

	public void setFrmOvernight(JFrame frmOvernight) {
		this.frmOvernight = frmOvernight;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
