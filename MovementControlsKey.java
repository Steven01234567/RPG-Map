package movement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
/**
 * Class handling all Key Controls for movement package
 * Steven Chen
 * 8/6/2021
 */
public class MovementControlsKey extends KeyAdapter {
	/**
	 * Field
	 */
	 MovementGraphics mg;
	/**
	 * Constructor
	 */
	public MovementControlsKey(MovementGraphics mg) {
		this.mg = mg;
	}
	
	@Override //Not used
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		//Talk/End conversation
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (mg.MDialogue.isVisible()) 
				mg.MDialogue.setVisible(false);//Visible -> Invisible
			else 
				mg.MDialogue.setVisible(true);//Invisible -> Visible
		}
		
		else {
			if(e.getKeyCode() == KeyEvent.VK_W) {  //moving up
				mg.orX = 0;
				mg.orY = -1;

							/*if(mg.imageY<0) { //checks that the Y-image location of the image is >0 (so there's still parts of the image to show)
								if(mg.y==225) { 
							//checks if the square is at the middle of the screen (this is important bc when the square reaches the bottom
							//of the image, i coded so the square can continue moving down even tho there is no more image
							//as such, when u then decide to move back up, i first make the code wait until the square is at the middle again
							//before i start changing the image again
							//this is the same concept for the others
						
						
									mg.imageY+=50;	//i change the coordinate of the image if the square is at the middle
								}
								else { //if the square is not at the middle, i'll change the coordinates of the square first
									mg.y-=50;
								}
							}
							else { //idk why it only works with y-25 but it is like this -> if the image is at it's max then i move the box instead
						//move the box
								mg.y-=50;
							}
							mg.repaint();
							updateLocation();*/
			}
			//same concept as above is applied for the next 3
			
			//moves down
			if(e.getKeyCode() == KeyEvent.VK_S) { 
				mg.orX = 0;
				mg.orY = 1;
							/*if(mg.imageY-500>-1150) { //checks if there's anything left of the image to show
					
								if(mg.y==225) { //determines if the rect is at the middle of the screen (u can remove this if-else and only
							//keep the imageY-=5 here and then you can see what happens
							//if you do decide to check, move the rectangle to the top of the screen (click 'a') and then try clicking the 's' key
							//you'll see that the rectangle is still 'stuck' at the top but the background is moving
							//thus, i try to first make the program wait until the rectangle is in the middle again b4 moving the background
									mg.imageY-=50;	
								}
								else {
									mg.y+=50;
								}
							}
							else if(mg.y+90<=500) {
								mg.y+=50;
							}
							mg.repaint();
							updateLocation();*/
			}
			
			//moves left
			if(e.getKeyCode() == KeyEvent.VK_A) { 
				mg.orX = -1;
				mg.orY = 0;
			}
			
			//Move right
			if(e.getKeyCode() == KeyEvent.VK_D) {
				mg.orX = 1;
				mg.orY = 0;
			}
			
			if (!mg.MDialogue.isVisible()) {
				if (!checkBorder()) {
					if (checkFront()) {
						movePlayer();
					}
				}
				mg.repaint();
			}	
		}
	}
		

	@Override //Not used
	public void keyReleased(KeyEvent e) { 
		
	}
	/**
	 * Checks if player is moving past a border
	 * Returns true if at a border and false if not
	 */
	public boolean checkBorder() {
		if (mg.y == 0 && mg.orY == -1)
			return true;
		else if (mg.y+50 == 750 && mg.orY == 1)
			return true;
		else if (mg.x == 0 && mg.orX == -1)
			return true;
		else if (mg.x+50 == 1350 && mg.orX == 1)
			return true;
		else
			return false;
	}
	/**
	 * Checks if location in front of player is open space
	 * Returns true if location is open space and false if not
	 */
	public boolean checkFront() {
		mg.decoy = mg.player;
		mg.decoy.x += mg.orX;
		mg.decoy.y += mg.orY;
		for (Rectangle rect : mg.obstacles) {
			if (mg.decoy.intersects(rect))
				return false;
		}
		return true;
	}
	/**
	 * Executes movement of the player
	 */
	public void movePlayer() {
		if (mg.orY != 0) {
			if (mg.orY == -1) {
				if(mg.imageY < 0 && mg.y == 350)
					mg.imageY += 5;
				else
					mg.y -= 5;
			}
		
			else {
				if(mg.imageY-750 > -mg.imgY && mg.y == 350)
					mg.imageY -= 5;
				else
					mg.y += 5;
			}
		}
		
		else {
			if (mg.orX == -1) {
				if (mg.imageX < 0 && mg.x == 650)
					mg.imageX += 5;
				else 
					mg.x -= 5;
			}
			
			else {
				if (mg.imageX-1350 > -mg.imgX && mg.x == 650)
					mg.imageX -= 5;
				else
					mg.x += 5;
			}
		}
	}
}
