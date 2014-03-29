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
		C_Box = new CollisionBox(x, y, width, height);
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.drawRect(x, y, width, height);
		g.fillRect(x, y, width, height);
		C_Box.draw(g);
	}

	@Override
	public void update()
	{
		// TODO Auto-generated method stub	
	}

/******************************************************************************/	
	
	
}
