package WorldObj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class PlayerObj extends Object implements ActionListener
{
	
	private final int speed = 2;
	private int xVel = 0;
	private int yVel = 0;
	
	private int width;
	private int height;
	
	private Timer movementTimer;
	
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
		this.movementTimer = new Timer(refreshRate/FPS, this);
		
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
	}

/**************************Thread*********************************************/	
	
	public void run() 
	{
		movementTimer.start();
	}
	
/************************Setter Methods**************************************/	
	
	public void isUp(boolean isUp) { this.isUp = isUp; }
	
	public void isDown(boolean isDown) { this.isDown = isDown; }
	
	public void isLeft(boolean isLeft) { this.isLeft = isLeft; }
	
	public void isRight(boolean isRight) { this.isRight = isRight; }

/**************************Movement********************************************/
	
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		movement();
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
	}

	
	
}
