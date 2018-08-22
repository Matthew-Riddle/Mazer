import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class Game {


	ImageLoader imageLoader = new ImageLoader();
	
	public Game() {
		//Load in a maze
		BufferedImage maze = imageLoader.loadImage("simplemaze.bmp");
		
		ColorReader colorReader = new ColorReader(maze);
		
		colorReader.readColors();
		
		
	}
	
	
	
	

}
