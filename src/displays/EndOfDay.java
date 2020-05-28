package displays;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * Creates window after 'Next Day!' is selected in GameWindow. <br>
 * Displays end of day message along with any events that occurred over night.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class EndOfDay {

	private JFrame frmNightTime;

	/**
	 * Launch the application.
	 * 
	 * @param args A string containing any command line arguments.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndOfDay window = new EndOfDay();
					window.frmNightTime.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initiate the application.
	 */
	public EndOfDay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNightTime = new JFrame();
		frmNightTime.setTitle("Night Time");
		frmNightTime.setBounds(100, 100, 450, 300);
		frmNightTime.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNightTime.getContentPane().setLayout(null);
		
		JLabel lblInfoLabel = new JLabel("The crew sleeps. Overnight _____________________");
		lblInfoLabel.setBounds(12, 0, 438, 206);
		frmNightTime.getContentPane().add(lblInfoLabel);
		
		JButton btnOkay = new JButton("OKAY");
		btnOkay.setBounds(153, 224, 114, 25);
		frmNightTime.getContentPane().add(btnOkay);
	}

}
