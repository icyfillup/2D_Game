package WorldObj;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Game.BoardSettings;

public abstract class Object extends Thread implements BoardSettings, ActionListener
{
	protected Timer UpdateLoop;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected CollisionBox C_Box;
	
	public Object(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		init();
	}

/**************************Initiate Methods*********************************/		
	
	private void init() 
	{
		initUpdateLoop();
		initCollisionBox();
	}

	private void initUpdateLoop() { this.UpdateLoop = new Timer(refreshRate/FPS, this); }
	
	private void initCollisionBox() { C_Box = new CollisionBox(x, y, width, height); }
	
/**************************Getters Methods**********************************/	
	
	public int getX() { return x; }
	
	public int getY() { return y; }
	
/**************************Paint and Draw Methods***************************/
	
	public abstract void draw(Graphics g);
	
/****************************CollsionBox Related Methods********************/

	public CollisionBox getCollisionBox() { return C_Box; }
	
	private void setCollisionBox() { C_Box.setCoordinate(x, y); }
	
/****************************Thread*****************************************/
	
	public abstract void update();
	
	public void actionPerformed(ActionEvent e) { GlobalObjectUpdate(); }

	private void GlobalObjectUpdate()
	{
		update();
		setCollisionBox();
	}
	
/***************************************************************************/	
}
