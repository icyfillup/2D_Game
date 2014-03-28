package WorldObj;

import java.awt.Graphics;

import Game.BoardSettings;

public abstract class Object extends Thread implements BoardSettings
{
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected CollisionBox Box;
	
	public int getX() { return x; }
	
	public int getY() { return y; }
	
	public abstract void draw(Graphics g);
	
	public CollisionBox getCollisionBox() { return Box; }
	
/***********************************************************************************/	
}
