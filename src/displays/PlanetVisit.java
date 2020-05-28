package displays;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Window which displays information on what was found on a planet after <br>
 * the 'search' action is taken. <br>
 * Displays planet name, what was found, and what happened.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class PlanetVisit {

	private JFrame frmPlanetName;
	private String message;

	/**
	 * Create the application.
	 * 
	 * @param messagePass Name of the planet to be passed into a label.
	 */
	public PlanetVisit(String messagePass) {
		this.message = messagePass;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmPlanetName(new JFrame());
		getFrmPlanetName().setTitle("Planet Name");
		getFrmPlanetName().setBounds(100, 100, 450, 300);
		getFrmPlanetName().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmPlanetName().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("You went to ____. Found ___. ___ happened.");
		lblNewLabel.setBounds(12, 0, 426, 192);
		getFrmPlanetName().getContentPane().add(lblNewLabel);
		lblNewLabel.setText(this.message);
		
		JButton btnOkay = new JButton("OKAY");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getFrmPlanetName().dispose();
			}
		});
		btnOkay.setBounds(161, 221, 114, 25);
		getFrmPlanetName().getContentPane().add(btnOkay);
	}

	/**
	 * 
	 */
	public JFrame getFrmPlanetName() {
		return frmPlanetName;
	}

	/**
	 * 
	 * @param frmPlanetName
	 */
	public void setFrmPlanetName(JFrame frmPlanetName) {
		this.frmPlanetName = frmPlanetName;
	}

}
