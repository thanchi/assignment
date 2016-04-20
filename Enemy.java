import java.awt.*;

public class Enemy extends Sprite{
	public static final int Y_TO_FADE = 400;
	
	private int step = 12;
	
	public Enemy(int x, int y){
		super(x, y, 5, 10);
	}
	
	@Override
	public void draw(Graphics2D g){
		
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
	
	public void proceed(){
		y += step;
	}
	
}