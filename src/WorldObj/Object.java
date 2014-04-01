package WorldObj;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import Game.BackGround;
import Game.BoardSettings;

public abstract class Object extends Thread implements BoardSettings, ActionListener
{
/************************Variables*******************************************/
	
	protected Timer UpdateLoop;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected CollisionBox C_Box;
	protected BackGround backGround;
	
/************************Constructor*****************************************/
	
	public Object(int x, int y, int width, int height, BackGround backGround)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.backGround = backGround;
		
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
	
	public ArrayList<groundObj> getPlatform() { return backGround.getPlatform(); }
	
/**************************Paint and Draw Methods***************************/
	
	public abstract void draw(Graphics g);
	
/****************************CollsionBox Related Methods********************/

	public CollisionBox getC_Box() { return C_Box; }
	
	private void setCollisionBox() { C_Box.setCoordinate(x, y); }
	
	public boolean collide(Object checking) { return this.getC_Box().isCollidingWith(checking.getC_Box()); }
	
	public boolean collidedTop(Object that) { return this.getC_Box().isBelowOf(that.getC_Box()); }	
	
	public boolean collidedBelow(Object that) { return this.getC_Box().isOnTopOf(that.getC_Box()); }	
	
	public boolean collidedTheLeft(Object that) { return this.getC_Box().isOnTheRightOf(that.getC_Box()); }
	
	public boolean collidedTheRight(Object that) { return this.getC_Box().isOnTheLeftOf(that.getC_Box()); }	
	
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
