import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Game extends JPanel implements Runnable{

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public static final int WIDTH = 1920, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	
	ImageLoader imageLoader = new ImageLoader();
	

	Image img = imageLoader.loadImage("Deadbirds.png");
	Image newImage = img;
	int scalex = newImage.getWidth(null);
	int scaley= newImage.getHeight(null);
	
	int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
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
		
		g.drawImage(newImage, WIDTH/2 - newImage.getWidth(null)/2, HEIGHT/2 - newImage.getHeight(null)/2, null);
		g.dispose();
		
	}
	
	
	private void update(double delta) {
		
		if(scalex >= (int)(img.getWidth(null) * 2) || scaley >= (int)(img.getHeight(null) * 2)) {
			tooBig = true;
			scalex = (int)(img.getWidth(null) * 2);
			scaley = (int)(img.getHeight(null) * 2);
		}
		if(scalex <= (int)(img.getWidth(null) / 2) || scaley <= (int)(img.getHeight(null) / 2)) {
			tooSmall = true;
			scalex = (int)(img.getWidth(null) / 2);
			scaley = (int)(img.getHeight(null) / 2);
		}
		else {
			tooSmall = false;
			tooBig = false;
			
//			scalex = (int)(scalex * delta);
//			scaley = (int)(scaley * delta);
			newImage = img.getScaledInstance(scalex, scaley, Image.SCALE_FAST);
		}

		
		
	}

}
