package colordata;
import java.awt.image.BufferedImage;

public class ColorReader {
	BufferedImage maze;
	public ColorReader(BufferedImage maze) {
		this.maze = maze;
	}
	
	public ColorData[] readColors(){
		
		int mazeWidth = maze.getWidth();
		int mazeHeight = maze.getHeight();
		
		ColorData[] colorData = new ColorData[mazeWidth * mazeHeight];
		
		for(int i = 0; i < mazeWidth * mazeHeight; i++) {
			colorData[i] = new ColorData(0,0,0,0);
		}
		
		System.out.println("mazeWidth: " + mazeWidth + " mazeHeight: " + mazeHeight);
		for(int y = 0; y < mazeWidth; y++) {
			for(int x = 0; x < mazeHeight; x++) {
				int position = x + mazeWidth * y;
				colorData[position].setClr(maze.getRGB(x, y));
				colorData[position].setRed((colorData[position].getClr() & 0x00ff0000) >> 16);
				colorData[position].setGreen((colorData[position].getClr() & 0x0000ff00) >> 8);
				colorData[position].setBlue(colorData[position].getClr() & 0x000000ff);
				if(colorData[position].getRed() == 0 && colorData[position].getBlue() == 0 && colorData[position].getGreen() == 0) {
					colorData[position].setIsBlack(true);
				}
				System.out.println("X: " + x + " Y: " + y + " Clr: " + colorData[position].getClr()
						+ " Red: " + colorData[position].getRed() + " Green: " + colorData[position].getGreen()
						+ " Blue: " + colorData[position].getBlue() + " Black: " + colorData[position].getIsBlack());
			}
		}
		
		return colorData;
	}
}
