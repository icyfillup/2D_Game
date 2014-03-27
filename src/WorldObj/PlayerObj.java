package WorldObj;

import java.awt.Color;
import java.awt.Graphics;

public class PlayerObj extends Object
{

	private int width;
	private int height;
	
	public PlayerObj(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawOval(x, y, width, height);
		g.fillOval(x, y, width, height);
	}

	public void run() 
	{
		System.out.println("player should be coded to move here");
	}
	
}
