import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable{

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public static final int WIDTH = 1920, HEIGHT = WIDTH / 12 * 9, RATIO = WIDTH / HEIGHT;
	
	private Thread thread;
	private boolean running = false;
	
	ImageLoader imageLoader = new ImageLoader();
	
	public float scalarValue = .01f;
	

	Image img = imageLoader.loadImage("Deadbirds.png");
	Image newImage = img;
	int scalex = img.getWidth(null);
	int scaley= img.getHeight(null);
	
	float xScaleFactor = 1;
	float yScaleFactor = 1;
	
	BufferedImage originalImage = imageLoader.loadImage("Deadbirds.png");
	
	/*Original dimensions*/
	int oHeight = img.getHeight(null);
	int oWidth = img.getWidth(null);
	int ratio = oWidth / oHeight;
	
	
	
	
	
	boolean tooBig = false;
	boolean tooSmall = false;
	
	
	public Game() {
	
		new Window("MAZER", HEIGHT, WIDTH, this);
		new ScaleAction(this);
		
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				update(delta);
				delta--;
			}
			if(running)
				repaint();
			
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	protected void paintComponent(Graphics g) {
		
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		int newW = (int)(originalImage.getWidth() * xScaleFactor);
		int newH = (int)(originalImage.getHeight() * yScaleFactor);
		
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		
		g2.drawImage(originalImage, (int)(WIDTH - newW)/2 , (int)(HEIGHT - newH)/2, newW, newH, null);
		
		g2.dispose();
//		g.drawImage(newImage, 0, 0, null);
//		g.dispose();
		
	}
	
	
	private void update(double delta) {
		
//		if(scalex >= (int)(oWidth * 2) || scaley >= (int)(oHeight * 2)) {
//			tooBig = true;
//			scalex = (int)(oWidth * 2);
//			scaley = (int)(oHeight * 2);
//		}
//		if(scalex <= (int)(oWidth / 2) || scaley <= (int)(oHeight / 2)) {
//			tooSmall = true;
//			scalex = (int)(oWidth / 2);
//			scaley = (int)(oHeight / 2);
//		}
//		int nImgRatio = newImage.getWidth(null) / newImage.getHeight(null);
//		System.out.println("new Ratio:" + nImgRatio + " Old: " + ratio);
//		if(nImgRatio > ratio) {
//			tooSmall = true;
//			System.out.println("greater");
//			scalex += scalarValue;
//			scaley += scalarValue;
//			newImage = img.getScaledInstance(scalex, scaley, Image.SCALE_FAST);
//		}
//		else if(nImgRatio < ratio) {
//			tooBig = true;
//			scalex -= scalarValue;
//			scaley -= scalarValue;
//			newImage = img.getScaledInstance(scalex, scaley, Image.SCALE_FAST);
//			
//		}
//		else {
//			tooSmall = false;
//			tooBig = false;
//			System.out.println("in here");
////			scalex = (int)(scalex * delta);
////			scaley = (int)(scaley * delta);
//			
//		}
//
//		newImage = img.getScaledInstance(scalex, scaley, Image.SCALE_FAST);
		
		
		
	}

}
