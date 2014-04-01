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
	
	private boolean isUp;
	private boolean isDown;
	private boolean isLeft;
	private boolean isRight;
	
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

	private void moveUp() { if(isUp) yVel = -speed; }
	
	private void moveDown() { if(isDown) yVel = speed; }
	
	private void moveLeft() { if(isLeft) xVel = -speed; }
	
	private void moveRight() { if(isRight) xVel = speed; }
	
	private void stay()
	{
		if(!isUp && !isDown) stay_Vert();
		if(!isLeft && !isRight) stay_Hori();
	}
	
	private void stay_Vert() { yVel = 0; }
	
	private void stay_Hori() { xVel = 0; }

/****************************Collision Detection Related Methods***********************/
	
	private void C_BoxDetecting()
	{
		collidedObj.clear();
		for(groundObj Obj: getPlatform()) { if(this.collide(Obj)) collidedObj.add(Obj); }
	}
	
	private void detectingCollision()
	{
		C_BoxDetecting();
		if(!collidedObj.isEmpty()) { collisionDetected(); }
	}

	private void collisionDetected()
	{
		for(Object Obj: collidedObj)
		{
//			System.out.println("(" + x + ", " + y + ") " + "collidedTop: " + collidedTop(Obj) + " (" + Obj.x + ", " +Obj. y + ")");
//			System.out.println("(" + x + ", " + y + ") " + "collidedBelow: " + collidedBelow(Obj) + " (" + Obj.x + ", " +Obj. y + ")");
//			System.out.println("(" + x + ", " + y + ") " + "collidedTheLeft: " + collidedTheLeft(Obj) + " (" + Obj.x + ", " +Obj. y + ")");
//			System.out.println("(" + x + ", " + y + ") " + "collidedTheRight: " + collidedTheRight(Obj) + " (" + Obj.x + ", " +Obj. y + ")");
//			System.out.println();
			
			if(collidedTop(Obj)) System.out.println("collidedTop: " + collidedTop(Obj));
			if(collidedBelow(Obj)) System.out.println("collidedBelow: " + collidedBelow(Obj));
			if(collidedTheLeft(Obj)) System.out.println("collidedTheLeft: " + collidedTheLeft(Obj));
			if(collidedTheRight(Obj)) System.out.println("collidedTheRight: " + collidedTheRight(Obj));
		}
		
	}
	
//	private void setCollisionBox() { C_Box.setCoordinate(x, y); }
	
/******************************************************************************/	
}
