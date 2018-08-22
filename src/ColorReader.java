import java.awt.image.BufferedImage;

public class ColorReader {
	BufferedImage maze;
	ColorReader(BufferedImage maze) {
		this.maze = maze;
	}
	
	ColorData[] readColors(){
		
		int mazeWidth = maze.getWidth();
		int mazeHeight = maze.getHeight();
		
		ColorData[] colorData = new ColorData[mazeWidth * mazeHeight];
		
		
		for(int x = 0; x < mazeWidth; x++) {
			System.out.println("0");
			for(int y = 0; y < mazeHeight; y++) {
				System.out.println("1");
				colorData[x + mazeWidth * y].setClr(maze.getRGB(x, y));
				colorData[x + mazeWidth * y].setRed((colorData[x + mazeWidth * y].getClr() & 0x00ff0000) >> 16);
				colorData[x + mazeWidth * y].setGreen((colorData[x + mazeWidth * y].getClr() & 0x0000ff00) >> 8);
				colorData[x + mazeWidth * y].setBlue(colorData[x + mazeWidth * y].getClr() & 0x000000ff);
			}
		}
		
		return colorData;
	}
}
