
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class GameEngine implements KeyListener , GameReporter{
	GamePanel gp;
	private SpaceShip s;
	private Timer timer;
	private long score = 0;
	
	public GameEngine(GamePanel gp , SpaceShip s){
		this.gp = gp;
		this.s = s;
		gp.sprites.add(s);
		timer = new Timer(50 , new ActionListener(){
		    @Override
			public void actionPerformed(ActionEvent arg0){
				process();
			}
		});
		timer.setRepeats(true);
	}
		
	public void start(){
		timer.start();
	}
		
	public long getScore(){
		return score;
	}
		
	public void process(){
		gp.updateGameUI(this);
		Rectangle2D.Double sr = s.getRectangle();
		Rectangle2D.Double er;
	}
	
	void controlVehicle(KeyEvent e){
		switch (e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				s.move(-1 , 0);
				break;
			case KeyEvent.VK_RIGHT:
				s.move(1 , 0);
				break;
			case KeyEvent.VK_UP:
				s.move(0 , -1);
				break;
			case KeyEvent.VK_DOWN:
				s.move(0 , 1);
				break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		controlVehicle(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		
	}
	
	@Override
	public void keyTyped(KeyEvent e){
		
	}
}
