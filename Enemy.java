import java.awt.*;

public class Enemy extends Sprite{
	public static final int Y_TO_FADE = 400;
	public static final int Y_TO_DIE = 600;
	private double step = (Math.random()*12)+1;;
	private boolean alive = true;
	
	public Enemy(int x, int y){
		super(x, y, 5, 10);
	}
	
	@Override
	public void draw(Graphics2D g){
	if(y < Y_TO_FADE)
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		else{
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 
					(float)(Y_TO_DIE - y)/(Y_TO_DIE - Y_TO_FADE)));
		}
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
	
	public void proceed(){
		y += step;
		if(y > Y_TO_DIE){
			alive = false;
		}
	}
	
	public boolean isAlive(){
		return alive;
	}
}