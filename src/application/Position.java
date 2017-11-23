package application;

/**
 * For Position purposes. Stores Position in form of (x,y) coordinates.
 * 
 * @author RAJAN
 *
 */
public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns the x coordinate of tile
	 * @return x coordinate of tile
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Returns the y coordinate of tile
	 * @return y coordinate of tile
	 */
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
