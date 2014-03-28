package WorldObj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class CollisionBox 
{
	private int x;
	private int y;
	private int width;
	private int height;
	Rectangle Box;
	
	public CollisionBox(int x, int y, int width, int height)
	{
		Box = new Rectangle(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void setCoordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
		Box.setLocation(this.x, this.y);
	}

	public Rectangle getCollisionBox()
	{
		Box.setLocation(this.x, this.y);
		return Box;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.drawRect(x, y, width, height);
		g.fillRect(x, y, width, height);
	}

/*********************************************************************************/	
	
	
}
