import java.awt.image.BufferedImage;

public class ColorData {

	ColorData(int clr, int red, int green, int blue){
		this.clr = clr;
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	int clr = 0;
	int red = 0;
	int green = 0;
	int blue = 0;
	

	public int getClr() {
		return clr;
	}
	public void setClr(int clr) {
		this.clr = clr;
	}
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = red;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	public int getBlue() {
		return blue;
	}
	public void setBlue(int blue) {
		this.blue = blue;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blue;
		result = prime * result + clr;
		result = prime * result + green;
		result = prime * result + red;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorData other = (ColorData) obj;
		if (blue != other.blue)
			return false;
		if (clr != other.clr)
			return false;
		if (green != other.green)
			return false;
		if (red != other.red)
			return false;
		return true;
	}
	
	
}
