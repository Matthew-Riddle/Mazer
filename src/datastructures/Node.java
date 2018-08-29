package datastructures;

public class Node {
	
	Node parent;
	int x;
	int y;
	
	
	public Node(int x, int y) {
		this.parent = null;
		this.x = x;
		this.y = y;
	}
	
	public Node(int x, int y, Node parent) {
		this.parent = parent;
		this.x = x;
		this.y = y;
	}


	public Node getParent() {
		return parent;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	
}
