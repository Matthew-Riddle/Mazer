import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public static final int WIDTH = 1920, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	
	ImageLoader imageLoader = new ImageLoader();
	
	Image img = imageLoader.loadImage("C:\\Users\\Matthew\\Desktop\\Repo\\Mazer\\terriblephoto.jpg");
	Image newImage = img;
	int scalex = 1;
	int scaley= 1;
	
	public Game() {
		new Window("MAZER", HEIGHT, WIDTH, this);
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
				update();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		//ImageLoader imageLoader = new ImageLoader();
		
		Graphics g = bs.getDrawGraphics();
		
		
		//Image img = imageLoader.loadImage("C:\\Users\\Matthew\\Desktop\\Repo\\Mazer\\terriblephoto.jpg");
		
		
		
		g.drawImage(newImage, 0, 0, null);
		
		g.dispose();
		bs.show();
	}
	
	private void update() {
		
		scalex += 1;
		scaley += 1;
		newImage = img.getScaledInstance(scalex, scaley, Image.SCALE_DEFAULT);
		
	}

}
