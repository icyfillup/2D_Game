package WorldObj;

import java.awt.Color;
import java.awt.Graphics;

public class groundObj
{
	private int x;
	private int y;
	private int width;
	private int height;
	
	public groundObj(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.GREEN);
//		g.drawRect(x, y, width, height);
		g.fillRect(x, y, width, height);
	}
}
