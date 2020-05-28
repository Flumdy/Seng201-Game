package displays;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import main.GameEnviroment;
import supers.CrewMember;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Pilot window where you can select a pilot and co-pilot in order <br>
 * to travel to a new planet.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class Pilots {

	private JFrame frmSelectPilots;

	/**
	 * Initialize Pilots window.
	 * 
	 * @param game Game object with which game information can be accessed.
	 */
	public Pilots(GameEnviroment game) {
		initialize(game);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param game Game object with which game information can be accessed.
	 */
	private void initialize(final GameEnviroment game) {
		frmSelectPilots = new JFrame();
		frmSelectPilots.setTitle("Select Pilots");
		frmSelectPilots.setBounds(100, 100, 450, 300);
		frmSelectPilots.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSelectPilots.getContentPane().setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(35, 61, 125, 24);
		frmSelectPilots.getContentPane().add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(game.getSpaceShip().getCrewList().toArray()));
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(258, 61, 125, 24);
		frmSelectPilots.getContentPane().add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(game.getSpaceShip().getCrewList().toArray()));
		
		JLabel lblPilot = new JLabel("Pilot");
		lblPilot.setBounds(80, 32, 66, 15);
		frmSelectPilots.getContentPane().add(lblPilot);
		
		JLabel lblCopilot = new JLabel("Co-Pilot");
		lblCopilot.setBounds(295, 32, 66, 15);
		frmSelectPilots.getContentPane().add(lblCopilot);
		
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(45, 97, 357, 86);
		frmSelectPilots.getContentPane().add(lblNewLabel);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrewMember pilot = (CrewMember) comboBox.getSelectedItem();
				CrewMember copilot = (CrewMember) comboBox_1.getSelectedItem();
				//get which crew member is in each box, and then
				if(pilot.equals(copilot)) {
					//change text to nah both are the same
					lblNewLabel.setText("Cant pilot by with only one crew member");
				}else if(pilot.actionsLeft <= 0) {
					//not enough actions
					lblNewLabel.setText("Pilot doesnt have enough moves");
				}else if(copilot.actionsLeft <= 0) {
					lblNewLabel.setText("Co-pilot doesnt have enough moves :(");
				}else {
					// we can go
					String retStr = game.pilot(pilot.getName(), copilot.getName(), game);
					GameWindow gameWindow = new GameWindow(game);
					gameWindow.getFrmDayx().setVisible(true);
					overnightHappened movedPlanet = new overnightHappened(retStr, game);
					//TODO fucking check if its blown up straight away and not when the next day button is pressed
					movedPlanet.getFrmOvernight().setVisible(true);
					movedPlanet.setAlwaysOnTop(true);
					frmSelectPilots.dispose();
				}
				//check they have moves and are not the same
				//then pilot and close
			}
		});
		btnGo.setBounds(150, 193, 114, 25);
		frmSelectPilots.getContentPane().add(btnGo);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameWindow gameWindow = new GameWindow(game);
				gameWindow.getFrmDayx().setVisible(true);
				frmSelectPilots.dispose();
			}
		});
		btnNewButton.setBounds(150, 230, 114, 25);
		frmSelectPilots.getContentPane().add(btnNewButton);
	}

	/**
	 * 
	 */
	public JFrame getFrmSelectPilots() {
		return frmSelectPilots;
	}

	/**
	 * 
	 * @param frmSelectPilots
	 */
	public void setFrmSelectPilots(JFrame frmSelectPilots) {
		this.frmSelectPilots = frmSelectPilots;
	}
}
