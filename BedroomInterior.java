package movement;
import javax.swing.*;

public class BedroomInterior extends JFrame {
	/**
	 * Field
	 */
	MovementGraphics MGraphics = new MovementGraphics("bedroom interior2.png", 249, 299, 550, 225, 685, 375/*, new int[][] 
			{{2, 2, 2},
			{0, 2, 1},
			{0, 0, 0}}, 2, 1*/);
	MovementDialogue MDialogue = MGraphics.MDialogue;
	/**
	 * Constructor
	 */
	public BedroomInterior() {
		setName("EXAMPLE");
		//setSize(500, 500);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false); //Set unresizables
		
		add(MDialogue);//Adds MovementDialogue object (MUST BE ADDED BEFORE MovementGraphics)
		MDialogue.setVisible(false);//Sets object visibility to false
		
		add(MGraphics);//Adds MovementGraphics object
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BedroomInterior();
	}
}