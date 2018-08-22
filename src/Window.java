import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Window extends JFrame {
	
private static final long serialVersionUID = -4701693684670803303L;
	
	
	public Window(String title, int width, int height, Game game) {
		
		JFrame frame = new JFrame(title);
		JPanel panel = new JPanel();
		JScrollPane pane = new JScrollPane(game);
		
//		panel.setPreferredSize(new Dimension(width, height));
//		panel.add(game);
		pane.setPreferredSize(new Dimension(width, height));
		//pane.add(frame);
		
//		pane.setPreferredSize(new Dimension(width, height));
//		frame.add(pane, BorderLayout.CENTER);
//		frame.revalidate();
//		
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.add(pane);
		frame.add(game);
		pane.revalidate();
		pane.repaint();
		frame.pack();
		frame.setVisible(true);
		
		game.start();
		
	}
}
