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
		
		for(int i = 0; i < mazeWidth * mazeHeight; i++) {
			colorData[i] = new ColorData(0,0,0,0);
		}
		
		System.out.println("mazeWidth: " + mazeWidth + " mazeHeight: " + mazeHeight);
		for(int y = 0; y < mazeWidth; y++) {
			for(int x = 0; x < mazeHeight; x++) {
				colorData[x + mazeWidth * y].setClr(maze.getRGB(x, y));
				colorData[x + mazeWidth * y].setRed((colorData[x + mazeWidth * y].getClr() & 0x00ff0000) >> 16);
				colorData[x + mazeWidth * y].setGreen((colorData[x + mazeWidth * y].getClr() & 0x0000ff00) >> 8);
				colorData[x + mazeWidth * y].setBlue(colorData[x + mazeWidth * y].getClr() & 0x000000ff);
				System.out.println("X: " + x + " Y: " + y + " Clr: " + colorData[x + mazeWidth * y].getClr()
						+ " Red: " + colorData[x + mazeWidth * y].getRed() + " Green: " + colorData[x + mazeWidth * y].getGreen()
						+ " Blue: " + colorData[x + mazeWidth * y].getBlue());
			}
		}
		
		return colorData;
	}
}
