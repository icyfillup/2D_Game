package WorldObj;

import java.awt.Graphics;

public abstract class Object extends Thread
{
	protected int x;
	protected int y;
	
	public int getX() { return x; }
	
	public int getY() { return y; }
	
	public abstract void draw(Graphics g);
	
}
