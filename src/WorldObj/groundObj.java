package WorldObj;

import java.awt.Color;
import java.awt.Graphics;

public class groundObj extends Object
{
	
	public groundObj(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		Box = new CollisionBox(x, y, width, height);
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.drawRect(x, y, width, height);
		g.fillRect(x, y, width, height);
		Box.draw(g);
	}
	
/******************************************************************************/	
	
	
}
