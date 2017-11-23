package application;

import java.util.ArrayList;

import application.PieceName;
import application.Position;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public abstract class Piece {
	
	PieceName pieceName;
	ImageView image;
	Color color;
	public abstract ArrayList<Position> move();
}
