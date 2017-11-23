package application;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	@Override
	public boolean equals(Object obj) {
		Position position = (Position) obj;
		
		if(this.getX() == position.getX() && this.getY() == position.getY())
			return true;
		else
			return false;
	}
	
	
}
