package pieces;

import java.util.ArrayList;

import application.PieceName;
import application.Position;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Abstract class to be extended by all the pieces
 * @author RAJAN
 *
 */
public abstract class Piece {
	
	PieceName pieceName;
	ImageView image;
	Color color;
	
	/**
	 * Generate all the possible moves of a piece
	 * 
	 * @param position current position of the piece on the chess board
	 * @return ArrayList for all possible moves
	 */
	public abstract ArrayList<Position> move(Position position);
	
	
	/**
	 * 
	 * @return Name of the piece
	 */
	public PieceName getPieceName() {
		return this.pieceName;
	}
	
	
	/**
	 * 
	 * @return image of the piece
	 */
	public ImageView getImage() {
		return image;
	}
	
	/**
	 * 
	 * @return Color of the piece
	 */
	public Color getColor() {
		return this.color;
	}
}
