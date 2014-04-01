package WorldObj;

import java.awt.Color;
import java.awt.Graphics;

import Game.BackGround;

public class groundObj extends Object
{
	
	public groundObj(int x, int y, int width, int height, BackGround backGround)
	{ super(x, y, width, height, backGround); }
	
	public void draw(Graphics g)
	{
		C_Box.draw(g);
		g.setColor(Color.GREEN);
		g.drawRect(x, y, width, height);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void update()
	{
		// TODO Auto-generated method stub	
	}

/******************************************************************************/	
	
}
