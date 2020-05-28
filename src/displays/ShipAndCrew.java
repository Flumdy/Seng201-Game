//Finn we need to have a new text that changes according to errors, i.e no ship name/ not enough crew ect

package displays;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.GameEnviroment;
import supers.CrewMember;
import supers.SpaceShip;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 * Window that allows player to name their ship and select crew members (between 2 and 4) <br>
 * and their names.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class ShipAndCrew {

	private JFrame frmSelectCrew;
	private JTextField textField_ship;
	private JLabel lblNewLabel_scout;
	private JLabel lblNewLabel_cpt;
	private JLabel lblNewLabel_eng;
	private JLabel lblNewLabel_chef;
	private JLabel lblNewLabel_med;
	private JLabel lblNewLabel_security;
	private JButton newScoutButton;
	private JButton newCptButton;
	private JButton newEngButton;
	private JButton newChefButton;
	private JButton newMedButton;
	private JButton newSecurityButton;
	private JLabel lblName_scout;
	private JLabel lblName_cpt;
	private JLabel lblName_eng;
	private JLabel lblName_chef;
	private JLabel lblName_med;
	private JLabel lblName_security;
	private JTextField textField_scout;
	private JTextField textField_cpt;
	private JTextField textField_eng;
	private JTextField textField_chef;
	private JTextField textField_med;
	private JTextField textField_security;
	private JButton btnPlay;
	private GameEnviroment game;
	private boolean hasSpaceShip = false;
	private String lblInfoStr = "";
	private JPanel ship_name_panel;
	private JPanel panel_cpt;
	private JPanel panel_med;
	private JPanel panel_eng;
	private JPanel panel_security;
	private JPanel panel_scout;
	private JPanel panel_chef;
	private JPanel panel_19;
	private JLabel lblShipAndCrew;
	private JLabel lblShipAndCrew_1;
	private JPanel panel_20;
	private JLabel lblShipAndCrew_2;
	private JPanel ship_and_crew_panel;
	private JLabel lblBackground;
	
	/**
	 * Create the application.
	 * 
	 * @param passedGame Game object to be 
	 */
	public ShipAndCrew(GameEnviroment passedGame) {
		game = passedGame;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmSelectCrew(new JFrame());
		getFrmSelectCrew().setTitle("Select Crew And Name Your Ship");
		getFrmSelectCrew().setBounds(100, 100, 928, 774);
		getFrmSelectCrew().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmSelectCrew().getContentPane().setLayout(null);
		
		final JLabel lblInfo = new JLabel("info");
		lblInfo.setBounds(524, 7, 159, 143);
		frmSelectCrew.getContentPane().add(lblInfo);
		lblInfo.setText(lblInfoStr);
		
		JButton btnDone = new JButton("OKAY");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_ship.getText().equals("")) {
					lblInfo.setText("Need a SpaceShip Name");
				}else {
				SpaceShip spaceShip = new SpaceShip(textField_ship.getText());
				game.setSpaceShip(spaceShip);
				hasSpaceShip = true;
				lblInfoStr = game.getSpaceShip().getName() + "<br/>";
				lblInfo.setText("<html>" + lblInfoStr + "</html>");
				}
			}
		});
		btnDone.setBounds(282, 46, 114, 25);
		getFrmSelectCrew().getContentPane().add(btnDone);
		
		lblNewLabel_scout = new JLabel("Scout");
		lblNewLabel_scout.setBounds(63, 142, 61, 50);
		getFrmSelectCrew().getContentPane().add(lblNewLabel_scout);
		
		lblNewLabel_cpt = new JLabel("Captain");
		lblNewLabel_cpt.setBounds(424, 160, 66, 15);
		getFrmSelectCrew().getContentPane().add(lblNewLabel_cpt);
		
		lblNewLabel_eng = new JLabel("Engineer");
		lblNewLabel_eng.setBounds(749, 160, 79, 15);
		getFrmSelectCrew().getContentPane().add(lblNewLabel_eng);
		
		lblNewLabel_chef = new JLabel("Chef");
		lblNewLabel_chef.setBounds(63, 451, 66, 15);
		getFrmSelectCrew().getContentPane().add(lblNewLabel_chef);
		
		lblNewLabel_med = new JLabel("Medic");
		lblNewLabel_med.setBounds(439, 451, 66, 15);
		getFrmSelectCrew().getContentPane().add(lblNewLabel_med);
		
		lblNewLabel_security = new JLabel("Security");
		lblNewLabel_security.setBounds(762, 451, 66, 15);
		getFrmSelectCrew().getContentPane().add(lblNewLabel_security);
		
		newScoutButton = new JButton("Add To Crew");
		newScoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(game.getCrewMemeberCount() <= 3 && textField_scout.getText() != null && hasSpaceShip) {
					CrewMember crewMember = new CrewMember(textField_scout.getText(), "Scout");
					game.getSpaceShip().crewList.add(crewMember);
					game.setCrewMemeberCount(game.getCrewMemeberCount() + 1);
					textField_scout.setText(null);
					System.out.println(game.getSpaceShip());
					lblInfoStr += crewMember.toString() + "<br/>";//
					lblInfo.setText("<html>" + lblInfoStr + "</html>");
				}
			}
		});
		newScoutButton.setBounds(29, 299, 142, 25);
		getFrmSelectCrew().getContentPane().add(newScoutButton);
		
		newCptButton = new JButton("Add To Crew");
		newCptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(game.getCrewMemeberCount() <= 3 && textField_cpt.getText() != null && hasSpaceShip) {
					CrewMember crewMember = new CrewMember(textField_cpt.getText(), "Captain");
					game.getSpaceShip().crewList.add(crewMember);
					game.setCrewMemeberCount(game.getCrewMemeberCount() + 1);
					textField_cpt.setText(null);
					System.out.println(game.getSpaceShip());
					lblInfoStr += crewMember.toString() + "<br/>";
					lblInfo.setText("<html>" + lblInfoStr + "</html>");
				}
			}
		});
		newCptButton.setBounds(395, 299, 140, 25);
		getFrmSelectCrew().getContentPane().add(newCptButton);
		
		newEngButton = new JButton("Add To Crew");
		newEngButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(game.getCrewMemeberCount() <= 3 && textField_eng.getText() != null && hasSpaceShip) {
					CrewMember crewMember = new CrewMember(textField_eng.getText(), "Engineer");
					game.getSpaceShip().crewList.add(crewMember);
					game.setCrewMemeberCount(game.getCrewMemeberCount() + 1);
					textField_eng.setText(null);
					System.out.println(game.getSpaceShip());
					lblInfoStr += crewMember.toString() + "<br/>";
					lblInfo.setText("<html>" + lblInfoStr + "</html>");
				}
			}
		});
		newEngButton.setBounds(732, 299, 136, 25);
		getFrmSelectCrew().getContentPane().add(newEngButton);
		
		newChefButton = new JButton("Add To Crew");
		newChefButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(game.getCrewMemeberCount() <= 3 && textField_chef.getText() != null && hasSpaceShip) {
					CrewMember crewMember = new CrewMember(textField_chef.getText(), "Chef");
					game.getSpaceShip().crewList.add(crewMember);
					game.setCrewMemeberCount(game.getCrewMemeberCount() + 1);
					textField_chef.setText(null);
					System.out.println(game.getSpaceShip());
					lblInfoStr += crewMember.toString() + "<br/>";
					lblInfo.setText("<html>" + lblInfoStr + "</html>");
				}
			}
		});
		newChefButton.setBounds(29, 601, 142, 25);
		getFrmSelectCrew().getContentPane().add(newChefButton);
		
		newMedButton = new JButton("Add To Crew");
		newMedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(game.getCrewMemeberCount() <= 3 && textField_med.getText() != null && hasSpaceShip) {
					CrewMember crewMember = new CrewMember(textField_med.getText(), "Medic");
					game.getSpaceShip().crewList.add(crewMember);
					game.setCrewMemeberCount(game.getCrewMemeberCount() + 1);
					textField_med.setText(null);
					System.out.println(game.getSpaceShip());
					lblInfoStr += crewMember.toString() + "<br/>";
					lblInfo.setText("<html>" + lblInfoStr + "</html>");
				}
			}
		});
		newMedButton.setBounds(395, 601, 147, 25);
		getFrmSelectCrew().getContentPane().add(newMedButton);
		
		newSecurityButton = new JButton("Add To Crew");
		newSecurityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(game.getCrewMemeberCount() <= 3 && textField_security.getText() != null && hasSpaceShip) {
					CrewMember crewMember = new CrewMember(textField_security.getText(), "Security");
					game.getSpaceShip().crewList.add(crewMember);
					game.setCrewMemeberCount(game.getCrewMemeberCount() + 1);
					textField_security.setText(null);
					System.out.println(game.getSpaceShip());
					lblInfoStr += crewMember.toString() + "<br/>";
					lblInfo.setText("<html>" + lblInfoStr + "</html>");
				}
			}
		});
		newSecurityButton.setBounds(732, 601, 136, 25);
		getFrmSelectCrew().getContentPane().add(newSecurityButton);
		
		lblName_scout = new JLabel("Name:");
		lblName_scout.setBounds(0, 179, 66, 15);
		getFrmSelectCrew().getContentPane().add(lblName_scout);
		
		lblName_cpt = new JLabel("Name:");
		lblName_cpt.setBounds(360, 179, 66, 15);
		getFrmSelectCrew().getContentPane().add(lblName_cpt);
		
		lblName_eng = new JLabel("Name:");
		lblName_eng.setBounds(685, 179, 66, 15);
		getFrmSelectCrew().getContentPane().add(lblName_eng);
		
		lblName_chef = new JLabel("Name:");
		lblName_chef.setBounds(0, 469, 66, 15);
		getFrmSelectCrew().getContentPane().add(lblName_chef);
		
		lblName_med = new JLabel("Name:");
		lblName_med.setBounds(369, 469, 66, 15);
		getFrmSelectCrew().getContentPane().add(lblName_med);
		
		lblName_security = new JLabel("Name:");
		lblName_security.setBounds(701, 469, 66, 15);
		getFrmSelectCrew().getContentPane().add(lblName_security);
		
		textField_scout = new JTextField();
		textField_scout.setBounds(62, 177, 124, 19);
		getFrmSelectCrew().getContentPane().add(textField_scout);
		textField_scout.setColumns(10);
		
		textField_cpt = new JTextField();
		textField_cpt.setBounds(418, 177, 124, 19);
		getFrmSelectCrew().getContentPane().add(textField_cpt);
		textField_cpt.setColumns(10);
		
		textField_eng = new JTextField();
		textField_eng.setBounds(744, 177, 124, 19);
		getFrmSelectCrew().getContentPane().add(textField_eng);
		textField_eng.setColumns(10);
		
		textField_chef = new JTextField();
		textField_chef.setBounds(62, 467, 124, 19);
		getFrmSelectCrew().getContentPane().add(textField_chef);
		textField_chef.setColumns(10);
		
		textField_med = new JTextField();
		textField_med.setBounds(424, 467, 124, 19);
		getFrmSelectCrew().getContentPane().add(textField_med);
		textField_med.setColumns(10);
		
		textField_security = new JTextField();
		textField_security.setBounds(762, 467, 124, 19);
		getFrmSelectCrew().getContentPane().add(textField_security);
		textField_security.setColumns(10);
		
		btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//need to pass the game back to the main function and initialise init
				if(game.getCrewMemeberCount() >= 2) {
					game.init(game);
					GameWindow gameWindow = new GameWindow(game);
					gameWindow.getFrmDayx().setVisible(true);
					frmSelectCrew.dispose();
				}
			}
		});
		btnPlay.setBounds(802, 7, 114, 25);
		getFrmSelectCrew().getContentPane().add(btnPlay);
		
		ship_name_panel = new JPanel();
		ship_name_panel.setBounds(63, 25, 207, 76);
		frmSelectCrew.getContentPane().add(ship_name_panel);
		
		JLabel lblShipName = new JLabel("Name Your Ship");
		ship_name_panel.add(lblShipName);
		
		textField_ship = new JTextField();
		ship_name_panel.add(textField_ship);
		textField_ship.setColumns(10);
		
		panel_cpt = new JPanel();
		panel_cpt.setBounds(360, 154, 201, 58);
		frmSelectCrew.getContentPane().add(panel_cpt);
		
		panel_med = new JPanel();
		panel_med.setBounds(369, 444, 200, 58);
		frmSelectCrew.getContentPane().add(panel_med);
		
		panel_eng = new JPanel();
		panel_eng.setBounds(685, 153, 201, 58);
		frmSelectCrew.getContentPane().add(panel_eng);
		
		panel_security = new JPanel();
		panel_security.setBounds(701, 444, 201, 58);
		frmSelectCrew.getContentPane().add(panel_security);
		
		panel_scout = new JPanel();
		panel_scout.setBounds(0, 154, 201, 58);
		frmSelectCrew.getContentPane().add(panel_scout);
		
		panel_chef = new JPanel();
		panel_chef.setBounds(0, 444, 201, 58);
		frmSelectCrew.getContentPane().add(panel_chef);
		
		ship_and_crew_panel = new JPanel();
		ship_and_crew_panel.setBounds(514, 8, 159, 134);
		frmSelectCrew.getContentPane().add(ship_and_crew_panel);
		
		lblShipAndCrew_2 = new JLabel("Ship And Crew:");
		ship_and_crew_panel.add(lblShipAndCrew_2);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(ShipAndCrew.class.getResource("/displays/sprites/space2.jpg")));
		lblBackground.setBounds(-33, -189, 1077, 935);
		frmSelectCrew.getContentPane().add(lblBackground);


	}

	/**
	 * 
	 */
	public JFrame getFrmSelectCrew() {
		return frmSelectCrew;
	}

	/**
	 * 
	 * @param frmSelectCrew
	 */
	public void setFrmSelectCrew(JFrame frmSelectCrew) {
		this.frmSelectCrew = frmSelectCrew;
	}
}
