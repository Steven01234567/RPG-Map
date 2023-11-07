package movement;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * Class displaying Graphics for movement package
 * Steven Chen
 * 8/6/2021
 */
public class MovementGraphics extends JPanel {
	/**
	 * Field
	 */
	Image image;
	
	Toolkit kit = Toolkit.getDefaultToolkit();
	
	int imgX, imgY;
	int imageX=0, imageY=0; //dimensions of image to be shown
	int x = 225, y = 225; //dimensions Of the square -> set to 225 so it's exactly in the middle w a height and width of 50
	//(the frame is 500 by 500)
	
	MovementDialogue MDialogue;	

	int orX, orY; //Player Orientation
	
	ArrayList<Rectangle> obstacles = new ArrayList<Rectangle>();
	Rectangle player = new Rectangle(x, y, 50, 50);
	Rectangle decoy = player;
	
	/**
	 * Constructor
	 */
	public MovementGraphics(String img, int imgX, int imgY, int imageX, int imageY, int x, int y) {
		super();
		
		MDialogue = new MovementDialogue("Hi");
		MDialogue.setVisible(false);
		
		try {
		image = ImageIO.read(new File(img)).getScaledInstance(imgX, imgY, java.awt.Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.imgX = imgX;
		this.imgY = imgY;
		this.imageX = imageX;
		this.imageY = imageY;
		
		this.x = x;
		this.y = y;
		
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(new MovementControlsKey(this));
		
		obstacles.add(new Rectangle(550, 230, 220, 120));
		//obstacles.add(new Rectangle2D.Double(550, 350, 100, 100));
	}
	/**
	 * Graphics
	 */
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.BLACK);
		
		g2.fillRect(0, 0, 1400, 800);
		
		g2.setStroke(new BasicStroke(3f)); //just so the square is a bit more visible
		
		g2.drawImage(image, imageX, imageY, this); //draws background at coordinates imageX and image Y (top-left corner) and takes up
		//the entire JFrame
		
		g2.setColor(new Color(0, 125, 0, 175));
		
		for (Rectangle rect : obstacles) {
			g2.fill(rect);
		}
		
		//Draws rectangle
		g2.setColor(Color.BLACK);
		
		player.x = x;
		player.y = y;
		
		g2.draw(player);
	}
}
