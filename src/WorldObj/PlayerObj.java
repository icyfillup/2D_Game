package WorldObj;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Timer;

public class PlayerObj extends Object
{
	
	private final int speed = 2;
	private int xVel = 0;
	private int yVel = 0;
	
	private boolean isUp;
	private boolean isDown;
	private boolean isLeft;
	private boolean isRight;
	
	public PlayerObj(int x, int y, int width, int height) 
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.UpdateLoop = new Timer(refreshRate/FPS, this);
		C_Box = new CollisionBox(x, y, width, height);
		
		this.isUp = false;
		this.isDown = false;
		this.isLeft = false;
		this.isRight = false;
	}

/**************************Paint and Draw Methods****************************/	
	
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.drawOval(x, y, width, height);
		g.fillOval(x, y, width, height);
		C_Box.draw(g);
	}

/**************************Thread*********************************************/	
	
	public void run() 
	{
		UpdateLoop.start();
	}
	
	public void update() 
	{
		movement();	
		changeInSpeed();
	}
	
/************************Setter Methods**************************************/	
	
	public void isUp(boolean isUp) { this.isUp = isUp; }
	
	public void isDown(boolean isDown) { this.isDown = isDown; }
	
	public void isLeft(boolean isLeft) { this.isLeft = isLeft; }
	
	public void isRight(boolean isRight) { this.isRight = isRight; }

/**************************Movement********************************************/
	
	private void changeInSpeed()
	{
		x += xVel;
		y += yVel;
	}
	
	private void movement()
	{
		moveUp();
		moveRight();
		moveLeft();
		moveDown();
		stay();
//		setCollisionBox();
	}

	private void moveUp() { if(isUp) yVel = -speed;}
	
	private void moveDown() { if(isDown) yVel = speed;}
	
	private void moveLeft() { if(isLeft) xVel = -speed;}
	
	private void moveRight() { if(isRight) xVel = speed;}
	
	private void stay()
	{
		if(!isUp && !isDown) stay_Vert();
		if(!isLeft && !isRight) stay_Hori();
	}
	
	private void stay_Vert() { yVel = 0; }
	
	private void stay_Hori() { xVel = 0; }

/****************************CollsionBox Related Methods***********************/	
	
//	private void setCollisionBox() { C_Box.setCoordinate(x, y); }
	
/******************************************************************************/	
}
