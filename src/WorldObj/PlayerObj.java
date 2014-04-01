package WorldObj;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Game.BackGround;

public class PlayerObj extends Object
{
/************************Variables*******************************************/
	
	private final int speed = 3;
	private int xVel = 0;
	private int yVel = 0;
	
	private int Left_xVel = 0;
	private int Right_xVel = 0;
	private int Up_yVel = 0;
	private int Down_yVel = 0;
	
	private boolean isUp;
	private boolean isDown;
	private boolean isLeft;
	private boolean isRight;
	
	private boolean collidedTop;
	private boolean collidedBelow;
	private boolean collidedTheLeft;
	private boolean collidedTheRight;
	
	private ArrayList<Object> collidedObj;
	
/************************Constructor*****************************************/
	
	public PlayerObj(int x, int y, int width, int height, BackGround backGround) 
	{
		super(x, y, width, height, backGround);
		init();
	}
	
/**************************Initiate Methods**********************************/	

	private void init()
	{
		initCollidingObj();
		initMovement();
	}
	
	private void initCollidingObj() { collidedObj = new ArrayList<Object>(); }

	private void initMovement() 
	{
		this.isUp = false;
		this.isDown = false;
		this.isLeft = false;
		this.isRight = false;
		
		setCollisionMovementToFalse();
	}

/**************************Paint and Draw Methods****************************/	
	
	public void draw(Graphics g)
	{
		C_Box.draw(g);
		g.setColor(Color.RED);
		g.drawOval(x, y, width, height);
		g.fillOval(x, y, width, height);
	}

/**************************Thread*********************************************/	
	
	public void run() { UpdateLoop.start(); }
	
	public void update() 
	{
//		System.out.println("Amount of Objects at the moment: " + collidedObj.size());
		detectingCollision();
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
		xVel = Left_xVel + Right_xVel;
		yVel = Up_yVel + Down_yVel;
		
		x += xVel;
		y += yVel;
	}
	
	private void movement()
	{
		if(!collidedTop) { moveUp(); } else { Up_yVel = 0;}
		if(!collidedTheRight) { moveRight(); } else { Right_xVel = 0;}
		if(!collidedTheLeft) { moveLeft(); } else { Left_xVel = 0;}
		if(!collidedBelow) { moveDown(); } else { Down_yVel = 0;}
		stay();
//		setCollisionBox();
	}

	private void moveUp() { if(isUp) Up_yVel = -speed; }
	
	private void moveDown() { if(isDown) Down_yVel = speed; }
	
	private void moveLeft() { if(isLeft) Left_xVel = -speed; }
	
	private void moveRight() { if(isRight) Right_xVel = speed; }
	
	private void stay()
	{
		if(!isUp) Up_yVel = 0;
		if(!isDown) Down_yVel = 0;
		if(!isLeft) Left_xVel = 0;
		if(!isRight) Right_xVel = 0;
	}
	
//	private void stay_Vert() { yVel = 0; }
//	
//	private void stay_Hori() { xVel = 0; }

/****************************Collision Detection Related Methods***********************/
	
	private void setCollisionMovementToFalse() 
	{
		this.collidedTop = false;
		this.collidedBelow = false;
		this.collidedTheLeft = false;
		this.collidedTheRight = false;
	}
	
	private void C_BoxDetecting()
	{
		collidedObj.clear();
		for(groundObj Obj: getPlatform()) { if(this.collide(Obj)) collidedObj.add(Obj); }
	}
	
	private void detectingCollision()
	{
		C_BoxDetecting();
		setCollisionMovementToFalse();
		if(!collidedObj.isEmpty()) collisionDetected(); 
	}

	private void collisionDetected()
	{
		for(Object Obj: collidedObj)
		{	
//			if(collidedTop(Obj)) System.out.println("(" + x + ", " + y + ") " + "collidedTop: " + collidedTop(Obj));
//			if(collidedBelow(Obj)) System.out.println("(" + x + ", " + y + ") " + "collidedBelow: " + collidedBelow(Obj));
//			if(collidedTheLeft(Obj)) System.out.println("(" + x + ", " + y + ") " + "collidedTheLeft: " + collidedTheLeft(Obj));
//			if(collidedTheRight(Obj)) System.out.println("(" + x + ", " + y + ") " + "collidedTheRight: " + collidedTheRight(Obj));
			
			if(collidedTop(Obj)) collidedTop = true;
			if(collidedBelow(Obj)) collidedBelow = true;
			if(collidedTheLeft(Obj)) collidedTheLeft = true;
			if(collidedTheRight(Obj)) collidedTheRight = true;
		}
		
	}
	
//	private void setCollisionBox() { C_Box.setCoordinate(x, y); }
	
/******************************************************************************/	
}
