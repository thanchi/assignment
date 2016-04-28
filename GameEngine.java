
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
	private double difficulty = 0.01;
	private double hFactor = 100000;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
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
	
	public void generateEnemy(){
		Enemy e = new Enemy((int)(Math.random() * 390), 30);
		gp.sprites.add(e);
		enemies.add(e);
	}
		
	public long getScore(){
		return score;
	}
		
	public void process(){
		 if(Math.random()/10 < difficulty){
            generateEnemy();
        }
		Iterator<Enemy> e_iter = enemies.iterator();
		while(e_iter.hasNext()){
			Enemy e = e_iter.next();
			e.proceed();
			if(!e.isAlive()){
                e_iter.remove();
                gp.sprites.remove(e);
                score += 100;
                if(((double)score/hFactor) >= difficulty){
                    difficulty+=0.005;
                    System.out.println("Harder!!!(Diff is" + difficulty + ")" );
        }
            }
		} 
		gp.updateGameUI(this);
		Rectangle2D.Double sr = s.getRectangle();
		Rectangle2D.Double er;
		for(Enemy e : enemies){
			er = e.getRectangle();
		}
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
			case KeyEvent.VK_H:
				if(difficulty <= 0.1 ){
					difficulty += 0.01;
					System.out.println("Difficulty : " + difficulty);
				}
				break;
			case KeyEvent.VK_L:
				if(difficulty >= 0.02 ){
					difficulty -= 0.01;
					System.out.println("Difficulty : " + difficulty);
				}
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
