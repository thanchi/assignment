
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.*;
import java.io.File;

public class GamePanel extends JPanel{
	private Image image1;
	private BufferedImage bi;
	Graphics2D big;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	
	public GamePanel(){
		//image1 = new ImageIcon(getClass().getResource("pic1.jpg"));
		bi = new BufferedImage(400 , 600 , BufferedImage.TYPE_INT_ARGB);
		big = (Graphics2D) bi.getGraphics();
		//big.setBackground(Color.GRAY);
		try{
			File file = new File ("pic1.jpg");
			image1 = ImageIO.read(file);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void updateGameUI(GameReporter reporter){
		big.clearRect(0, 0, 400, 600);
		big.drawImage(image1, 0, 0, null);
		big.setColor(Color.WHITE);
		big.drawString(String.format("%08d", reporter.getScore()), 300, 20);
		for(Sprite s : sprites){
			s.draw(big);
		}
		repaint();
	}
	
	@Override
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi , null , 0 , 0);
	}
		
}