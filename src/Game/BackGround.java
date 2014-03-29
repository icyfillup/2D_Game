package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.JPanel;

import WorldObj.PlayerObj;
import WorldObj.groundObj;

public class BackGround extends JPanel implements BoardSettings, Runnable, KeyListener
{
/************************Variables*******************************************/	
	
	private ArrayList<groundObj> platform;
	private PlayerObj player;
	private Timer RefreshTimer;
	
/************************Constructor*****************************************/
	
	public BackGround()
	{
		init();
		repaint();
	}
	
/************************Initiate Methods************************************/	
	
	private void init()
	{
		initWindowSetting();
		initGround();
		initPlayer();
		initTimer();
	}

	private void initWindowSetting() 
	{
		setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));
		setFocusable(true);
		requestFocus(true);
	}

	private void initTimer() { RefreshTimer = new Timer(refreshRate/FPS, new RefreshRate()); }

	private void initPlayer() { player = new PlayerObj(0, 0, GRID_SIZE, GRID_SIZE, this); }

	private void initGround()
	{
		platform = new ArrayList<groundObj>();
		platform.add(new groundObj(0, GRID_SIZE * (B_ROW - 2), GRID_SIZE * 5, GRID_SIZE, this));
	}

/************************Paint and Draw Methods******************************/	
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(Color.YELLOW);
		draw(g);
		
		
	}

	private void draw(Graphics g)
	{
		drawGrid(g);
		drawPlatform(g);
		drawPlayer(g);
	}

	private void drawPlayer(Graphics g) { player.draw(g); }

	private void drawPlatform(Graphics g) { for(groundObj G: platform) G.draw(g); }

	private void drawGrid(Graphics g)
	{
		for(int i = 1; i <= B_COL; i++)
		{
			g.drawLine(i * GRID_SIZE, 0, i * GRID_SIZE, B_ROW * GRID_SIZE);
		}
		
		for(int i = 1; i <= B_ROW; i++)
		{
			g.drawLine(0, i * GRID_SIZE, B_COL * GRID_SIZE, i * GRID_SIZE);
		}
	}

/************************Getter Methods**************************************/

	public ArrayList<groundObj> getPlatform() { return platform; }
	
	public PlayerObj getPlayer() { return player; }

/************************Setter Methods**************************************/	
	
	
/************************Collision Detection*********************************/	
	
	
	
/************************Classes*********************************************/
	
	class RefreshRate implements ActionListener
	{
		public void actionPerformed(ActionEvent e) { repaint(); }	
	}
	
/*************************Thread*********************************************/	
	
	@Override
	public void run()
	{
		startRefreshTimer();
		startPlayer();
	}

	private void startPlayer()
	{
//		System.out.println(running);
		player.start();
	}

	private void startRefreshTimer() { RefreshTimer.start(); }
	
	public void addNotify()
	{		
		super.addNotify();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		System.out.print("AddNotifyExecuted!");	
	}

/*************************Listener*****************************************/	
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		boolean isUp = (key == KeyEvent.VK_W);
		boolean isDown = (key == KeyEvent.VK_S);
		boolean isLeft = (key == KeyEvent.VK_A);
		boolean isRight = (key == KeyEvent.VK_D);
		
		
		if(isUp) { player.isUp(isUp); }
		
		if(isDown) { player.isDown(isDown); }
		
		if(isLeft) { player.isLeft(isLeft); }
		
		if(isRight) { player.isRight(isRight); }
		
//		System.out.println("1. " + (char) key);
		e.consume();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		boolean isUp = (key == KeyEvent.VK_W);
		boolean isDown = (key == KeyEvent.VK_S);
		boolean isLeft = (key == KeyEvent.VK_A);
		boolean isRight = (key == KeyEvent.VK_D);
		
		if(isUp) { player.isUp(!isUp); }
		
		if(isDown) { player.isDown(!isDown); }
		
		if(isLeft) { player.isLeft(!isLeft); }
		
		if(isRight) { player.isRight(!isRight); }
		
//		System.out.println("2. " + (char) key);
		e.consume();
	}
	
}
