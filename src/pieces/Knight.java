package pieces;

import java.util.ArrayList;

import application.Main;
import application.PieceName;
import application.Position;
import application.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


/**
 * Knight Class represents both black and white knights of chess board
 * 
 * @author RAJAN
 *
 */
public class Knight extends Piece{
	
	/**
	 * 
	 * @param color Color of the piece
	 */
	public Knight(Color color) {
		this.color = color;
		if(color == Color.BLACK) {
			this.pieceName = PieceName.BlackKnight;
			this.image = new ImageView(new Image("/pieces/Black_Knight.png"));
		}
		else {
			this.pieceName = PieceName.WhiteKnight;
			this.image = new ImageView(new Image("/pieces/White_Knight.png"));
		}
	}
	
	@Override
	public ArrayList<Position> move(Position current) {
		
		ArrayList<Position> positions = new ArrayList<Position>();
		
		int x = current.getX();
		int y = current.getY();
		Tile temp;
		int i = 0;
		
		if(this.pieceName == PieceName.WhiteKnight)
			i = 1;
		
		//8 possible moves for a knight
			
		//First move
		x = x - 1;
		y = y - 2;
		if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			temp = Main.tile[x][y];
			if(i == 0) {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
			else {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
		}
		
		x = current.getX();
		y = current.getY();
		
		//Second Move
		x = x - 2;
		y = y - 1;
		if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			temp = Main.tile[x][y];
			if(i == 0) {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
			else {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
		}
		
		x = current.getX();
		y = current.getY();
		
		//Third Move
		x = x - 2;
		y = y - 1;
		if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			temp = Main.tile[x][y];
			if(i == 0) {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
			else {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
		}
		
		x = current.getX();
		y = current.getY();
		
		//Fourth Move
		x = x - 1;
		y = y + 2;
		if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			temp = Main.tile[x][y];
			if(i == 0) {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
			else {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
		}
		
		x = current.getX();
		y = current.getY();
		
		//Fifth Move
		x = x + 1;
		y = y - 2;
		if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			temp = Main.tile[x][y];
			if(i == 0) {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
			else {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
		}
		
		x = current.getX();
		y = current.getY();
		
		//Sixth Move
		x = x + 2;
		y = y - 1;
		if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			temp = Main.tile[x][y];
			if(i == 0) {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
			else {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
		}
		
		x = current.getX();
		y = current.getY();
		
		//Seventh Move
		x = x + 2;
		y = y + 1;
		if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			temp = Main.tile[x][y];
			if(i == 0) {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
			else {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
		}
		
		x = current.getX();
		y = current.getY();
		
		//Eighth Move
		x = x + 1;
		y = y + 2;
		if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			temp = Main.tile[x][y];
			if(i == 0) {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
			else {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK)
					positions.add(new Position(x, y));
				if(temp.getPiece() == null) {
					positions.add(new Position(x, y));
				}
			}
		}
	
		
		return positions;
	}
}