package pieces;

import java.util.ArrayList;

import application.PieceName;
import application.Position;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public abstract class Piece {
	
	PieceName pieceName;
	ImageView image;
	Color color;
	
	public abstract ArrayList<Position> move(Position position);
	
	public PieceName getPieceName() {
		return this.pieceName;
	}
	
	public ImageView getImage() {
		return image;
	}
	
	public Color getColor() {
		return this.color;
	}
}
