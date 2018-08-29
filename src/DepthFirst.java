import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.synth.SynthSeparatorUI;

import colordata.ColorData;
import colordata.ColorReader;

public class DepthFirst {


	ImageLoader imageLoader = new ImageLoader();
	
	public DepthFirst() {
		//Load in a maze
		BufferedImage maze = imageLoader.loadImage("simplemaze.bmp");
		
		//Read the color data
		ColorReader colorReader = new ColorReader(maze);
		
		//Store the pixel data in an array of our datamodel ColorData.
		ColorData colorData[] = colorReader.readColors();
		
		//Create a new array that stores nodes we have visited
		boolean visited[] = new boolean[colorData.length];
		for(int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		
		/*TODO*/
		/*Scrap all this below. 
		 *Need to do 2 passes over the maze. The first pass will create all the nodes based on a few rules.
		 *The second pass will connect all the neighbors together.
		 *Need 4 methods, lookUp, lookRight, lookLeft, lookDown.
		 *They will be recursive loops that will keep going down a path til they hit a wall or a node.
		 *If they hit a node they will add that node to their list of neighbors in the proper position.
		 *Each node will have an array of size 4.
		 *Position 0 will be the top neighbors position, position 1 will be the right, and so on in a clockwise fashion.
		 *I could possibly just keep track of how many spaces there are between each neighbor and store that information
		 *which could be useful in finding the shortest path. Need to do more research.
		 *
		 *No need to create nodes. Those are just needed for djisktras. Instead just read everything as path, start, end, and wall. Then just do
		 *a depth first search.*/
		
		int mazeWidth = maze.getWidth();
		int mazeHeight = maze.getHeight();
		
		//First pass to create nodes
		for(int y = 0; y < mazeWidth; y++) {
			for(int x = 0; x < mazeHeight; x++) {
				int position = x + mazeWidth * y;
				int rowOffset = y * mazeWidth;
				int left = position - 1;
				int right = position + 1;
				int up = rowOffset - mazeWidth;
				int below = rowOffset + mazeWidth;
				
				//Redundant for no reason... will fix later
				int prev = left;
				int curr = position;
				int next = right;
				
				if(!colorData[curr].getIsBlack() && y == 0) {
					System.out.println("Start");
				}
				if(!colorData[curr].getIsBlack() && y == mazeHeight - 1) {
					System.out.println("End");
				}
				if(colorData[curr].getIsBlack()) {
					System.out.println("Wall");
				}
				
			}
			
		}
		
		
		
		
	}
	
	
	
	

}
