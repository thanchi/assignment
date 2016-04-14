
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.event.*;

public class GameEngine implements GameReporter{
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
	}
}
