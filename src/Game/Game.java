package Game;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame implements BoardSettings
{
	private BackGround board;
	JPanel buttonWindow;
	
	public Game(String name)
	{
		super(name);
		setSize(B_WIDTH, B_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupWindow();
		
	}
	
	private void setupWindow()
	{
		board = new BackGround();
		add(board, BorderLayout.CENTER);

//		setupButton();
//		add(buttonWindow, BorderLayout.SOUTH);
		
		setResizable(true);
		setVisible(true);
	}

	private void setupButton()
	{
		buttonWindow = new JPanel();		
		JButton button = new JButton("Button");
		button.setFocusable(false);
		buttonWindow.add(button);
	}
	

	public static void main(String[] args)
	{
		Game game = new Game("2D Game");

	}

}
