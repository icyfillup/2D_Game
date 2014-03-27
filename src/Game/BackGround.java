package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BackGround extends JPanel implements BoardSettings
{
	public BackGround()
	{
		setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));
		setFocusable(true);
		requestFocus(true);
		repaint();
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(Color.YELLOW);
		drawGrid(g);
		
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
}
