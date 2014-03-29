package WorldObj;

import java.awt.Color;
import java.awt.Graphics;

import Game.BackGround;

public class PlayerObj extends Object
{
/************************Variables*******************************************/
	
	private final int speed = 3;
	private int xVel = 0;
	private int yVel = 0;
	
	private boolean isUp;
	private boolean isDown;
	private boolean isLeft;
	private boolean isRight;
	
/************************Constructor*****************************************/
	
	public PlayerObj(int x, int y, int width, int height, BackGround backGround) 
	{
		super(x, y, width, height, backGround);
		init();
	}
	
/**************************Initiate Methods**********************************/	

	private void init()
	{
		initMovement();
	}
	
	private void initMovement() 
	{
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
	
	public void run() { UpdateLoop.start(); }
	
	public void update() 
	{
		movement();	
		changeInSpeed();
		detectingCollision();
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

/****************************Collision Detection Related Methods***********************/
	
	private boolean isC_BoxDetected()
	{ 
		for(groundObj Obj: getPlatform())
		{
			if(CollisionBox.collide(this.getC_Box(), Obj.getC_Box()))
				return true;
		}
		return false;
	}
	
	private void detectingCollision()
	{
		if(isC_BoxDetected()) System.out.println("Detected");
	}
	
//	private void setCollisionBox() { C_Box.setCoordinate(x, y); }
	
/******************************************************************************/	
}
