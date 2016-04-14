
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class main{
	public static void main(String[] args){
		JFrame frame = new JFrame("Space War");
		frame.setSize(400 , 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		SpaceShip s = new SpaceShip(180 , 550 , 50 , 50);
		GamePanel gp = new GamePanel();
		GameEngine ge = new GameEngine(gp , s);
	
		frame.getContentPane().add(gp, BorderLayout.CENTER);
		ge.start();
		frame.setVisible(true);
	}
}

