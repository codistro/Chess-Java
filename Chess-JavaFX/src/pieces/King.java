package pieces;

import java.util.ArrayList;

import application.Main;
import application.PieceName;
import application.Position;
import application.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class King extends Piece{
	
	public King(Color color) {
		this.color = color;
		if(color == Color.BLACK) {
			this.pieceName = PieceName.BlackKing;
			this.image = new ImageView(new Image("/pieces/Black_King.png"));
		}
		else {
			this.pieceName = PieceName.WhiteKing;
			this.image = new ImageView(new Image("/pieces/White_King.png"));
		}
	}
	
	@Override
	public ArrayList<Position> move(Position current) {
		ArrayList<Position> positions = new ArrayList<Position>();
		
		int x = current.getX();
		int y = current.getY();
		Tile temp;
		int i = 0;
		
		if(this.pieceName == PieceName.WhiteKing)
			i = 1;
		
		//8 possible moves for a King
		
		//First move
		x = x - 1;
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
		
		//Second Move
		x = x + 1;
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
		
		//Third Move
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
		
		//Fifth Move
		x = x - 1;
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
		x = x + 1;
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
		x = x - 1;
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
		return positions;
	}
}