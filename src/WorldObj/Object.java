package WorldObj;

import java.awt.Graphics;

import Game.BoardSettings;

public abstract class Object extends Thread implements BoardSettings
{
	protected int x;
	protected int y;
	
	public int getX() { return x; }
	
	public int getY() { return y; }
	
	public abstract void draw(Graphics g);
	
}
