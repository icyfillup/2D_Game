package WorldObj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class CollisionBox 
{
	private int disFromOrigin = 4;
	private int x;
	private int y;
	private int width;
	private int height;
	private Rectangle R_Box;
	
	public CollisionBox(int x, int y, int width, int height)
	{
		R_Box = new Rectangle(x - (disFromOrigin), y - (disFromOrigin), width + (disFromOrigin * 2), height + (disFromOrigin * 2));
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void setCoordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
		R_Box.setLocation(this.x - disFromOrigin, this.y - disFromOrigin);
	}

	public Rectangle getR_Box()
	{
		R_Box.setLocation(this.x - disFromOrigin, this.y - disFromOrigin);
		return R_Box;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.drawRect(R_Box.x, R_Box.y, R_Box.width, R_Box.height);
	}

	public boolean isCollidingWith(CollisionBox thatC_Box) { return this.getR_Box().intersects(thatC_Box.getR_Box()); }

	public boolean isBelowOf(CollisionBox that)
	{
		boolean thisTop_thatBottom = this.y > (that.y + that.height);
		boolean thisBottom_thatTop = (this.y + this.height) > that.y;
		
		return thisTop_thatBottom && thisBottom_thatTop;
	}

	public boolean isOnTopOf(CollisionBox that)
	{	
		boolean thisTop_thatBottom = this.y < (that.y + that.height);
		boolean thisBottom_thatTop = (this.y + this.height) < that.y;
		
		return thisTop_thatBottom && thisBottom_thatTop;
	}

	public boolean isOnTheRightOf(CollisionBox that)
	{
		boolean thisLeft_thatRight = this.x > (that.x + that.width);
		boolean thisRight_thatLeft = (this.x + this.width) > that.x;
		
		return thisLeft_thatRight && thisRight_thatLeft;
	}

	public boolean isOnTheLeftOf(CollisionBox that)
	{
		boolean thisLeft_thatRight = this.x < (that.x + that.width);
		boolean thisRight_thatLeft = (this.x + this.width) < that.x;
		
		return thisLeft_thatRight && thisRight_thatLeft;
	}
	
/*********************************************************************************/	
	
}
