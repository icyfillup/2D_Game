package Game;

import javax.swing.JFrame;

public class Game extends JFrame
{

	public Game(String name)
	{
		super(name);
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Game game = new Game("2D Game");

	}

}
