import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	
private static final long serialVersionUID = -4701693684670803303L;
	
	
	public Window(String title, int width, int height, Game game) {
		
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
//	public class Panel extends JPanel {
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//
//		public void paintComponent(Graphics g) {
//			ImageLoader imageLoader = new ImageLoader();
//			Image img = imageLoader.loadImage("C:\\Users\\Matthew\\Desktop\\Repo\\Mazer\\terriblephoto.jpg");
//			
//			g.drawImage(img, 0, 0, null);
//		}
//	}

	
}


//null;
//
//try {
//	img = ImageIO.read(new File("C:\\Users\\Matthew\\Desktop\\Repo\\Mazer\\terriblephoto.jpg"));
//	System.out.println(new File("terriblephoto.jpg").getCanonicalPath());
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}