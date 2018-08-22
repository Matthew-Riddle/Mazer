import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Window extends JFrame {
	
private static final long serialVersionUID = -4701693684670803303L;
	
	
	public Window(String title, int width, int height, Game game) {
		
		JFrame frame = new JFrame();
		JScrollPane pane = new JScrollPane(game);
		
		pane.setPreferredSize(new Dimension(width, height));
		pane.setVerticalScrollBarPolicy(pane.VERTICAL_SCROLLBAR_ALWAYS);
		
		add(pane, BorderLayout.CENTER);
		
		setTitle(title);
		setPreferredSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
		setMinimumSize(new Dimension(width, height));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
		
		game.start();
		
	}
}
