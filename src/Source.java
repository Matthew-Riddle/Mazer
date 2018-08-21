import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Source {

	public static void main(String[] args) {
		
		/*
		 * Ok, so I want a Maze board with tiles that are based on pixels 1x1 or 4x4 
		 * Load in a jpg --
		 * Do a sweep over it to create all the paths and nodes
		 * Save that path as a map
		 * Use an algorithm on the map to determine the best path
		 * Recolor the tiles  where the path is*
		 * 
		 *Maze class
		 *Image Loader class
		 *Algorithm class 
		 */
		
		new Game();

	}

}
