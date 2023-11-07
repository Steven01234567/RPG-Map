package movement;
import javax.swing.*;

public class Village extends JFrame {
	/**
	 * Field
	 */
	MovementGraphics MGraphics = new MovementGraphics("village.png", 0, 0, 0, 0, 225, 225);
	MovementDialogue MDialogue = MGraphics.MDialogue;
	/**
	 * Constructor
	 */
	public Village() {
		setName("EXAMPLE");
		setSize(500, 500);
		setResizable(false); //Set unresizable
		
		add(MDialogue);//Adds MovementDialogue object (MUST BE ADDED BEFORE MovementGraphics)
		MDialogue.setVisible(false);//Sets object visibility to false
		
		add(MGraphics);//Adds MovementGraphics object
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Village();
	}
}
