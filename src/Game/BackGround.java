package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import WorldObj.groundObj;

public class BackGround extends JPanel implements BoardSettings
{
/************************Variables*******************************************/	
	
	private ArrayList<groundObj> platform;
	
	
/************************Constructor*****************************************/	
	
	public BackGround()
	{
		setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));
		setFocusable(true);
		requestFocus(true);

//		System.out.println(getSize().height);
		init();
		repaint();
	}
	
/************************Initiate Methods************************************/	
	
	private void init()
	{
		initGround();
	}

	private void initGround()
	{
		platform = new ArrayList<groundObj>();
		platform.add(new groundObj(0, GRID_SIZE * (B_ROW - 2), GRID_SIZE * 5, GRID_SIZE));
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
	}

	private void drawPlatform(Graphics g)
	{
		for(groundObj G: platform) 
		{
			G.draw(g);
		}	
	}

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

}
