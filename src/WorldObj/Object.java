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
	
	
	public int getX() { return x; }
	
	public int getY() { return y; }
	
	public abstract void draw(Graphics g);
	
	public abstract void update();
	
	public CollisionBox getCollisionBox() { return C_Box; }
	
	private void setCollisionBox() { C_Box.setCoordinate(x, y); }
	
	public void actionPerformed(ActionEvent e)
	{
		GlobalObjectUpdate();
	}

	private void GlobalObjectUpdate()
	{
		update();
		setCollisionBox();
	}
	
/***********************************************************************************/	
}
