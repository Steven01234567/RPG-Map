package movement;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 * Class displaying dialogue for movement package
 * Steven Chen
 * 8/6/2021
 */
public class MovementDialogue extends JLabel {
	/**
	 * Field
	 */
	JLabel dialogue;
	/**
	 * Constructor
	 */
	public MovementDialogue(String dialogue) {
		super(dialogue, SwingConstants.CENTER);
		//setLayout(null);
		//this.dialogue = new JLabel(dialogue);
		setOpaque(true);
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		setBounds(0, 360, 500, 100);
		setVisible(true);
	}
}
