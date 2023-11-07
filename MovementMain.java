package movement;
import javax.swing.*;
/**
 * movement package main class
 * Steven Chen
 * 8/6/2021
 */
public class MovementMain extends JFrame {
	/**
	 * Field
	 */
	MovementGraphics MGraphics = new MovementGraphics("adventure_Example.png", 1650, 950, 0, 0, 50, 50);
	MovementDialogue MDialogue = MGraphics.MDialogue;
	/**
	 * Constructor
	 */
	public MovementMain() {
		setName("EXAMPLE");
		//setSize(500, 500);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setResizable(false); //Set unresizable
		
		add(MDialogue);//Adds MovementDialogue object (MUST BE ADDED BEFORE MovementGraphics)
		MDialogue.setVisible(false);//Sets object visibility to false
		
		add(MGraphics);//Adds MovementGraphics object
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MovementMain();
	}
}
