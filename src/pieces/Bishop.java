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
 * Bishop Class represents both black and white bishops of chess board
 * 
 * @author RAJAN
 *
 */
public class Bishop extends Piece{

	/**
	 * 
	 * @param color Color of the piece
	 */
	public Bishop(Color color) {
		this.color = color;
		if(color == Color.BLACK) {
			this.pieceName = PieceName.BlackBishop;
			this.image = new ImageView(new Image("/pieces/Black_Bishop.png"));
		}
		else {
			this.pieceName = PieceName.WhiteBishop;
			this.image = new ImageView(new Image("/pieces/White_Bishop.png"));
		}
	}
	
	
	@Override
	public ArrayList<Position> move(Position current) {
		ArrayList<Position> positions = new ArrayList<Position>();
		
		int x = current.getX();
		int y = current.getY();
		Tile temp;
		int i = 0;
		
		if(this.pieceName == PieceName.WhiteBishop)
			i = 1;
		
		//right diagonal up
		x = x + 1;
		y = y - 1;
		while(x >= 0 && x <= 7 && y >= 0 && y <= 7 ) {
			temp = Main.tile[x][y];
			if(i == 0) {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK) {
					break;
				}
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE) {
					positions.add(new Position(x, y));
					break;
				}
				positions.add(new Position(x, y));
			}else {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE) {
					break;
				}
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK) {
					positions.add(new Position(x, y));
					break;
				}
				positions.add(new Position(x, y));
			}
			x++;
			y--;
		}
		
		x = current.getX();
		y = current.getY();
		//right diagonal down
		x = x - 1;
		y = y + 1;
		while(x >= 0 && x <= 7 && y >= 0 && y <= 7 ) {
			temp = Main.tile[x][y];
			if(i == 0) {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK) {
					break;
				}
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE) {
					positions.add(new Position(x, y));
					break;
				}
				positions.add(new Position(x, y));
			}else {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE) {
					break;
				}
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK) {
					positions.add(new Position(x, y));
					break;
				}
				positions.add(new Position(x, y));
			}
			x--;
			y++;
		}
		
		x = current.getX();
		y = current.getY();
		//left diagonal up
		x = x - 1;
		y = y - 1;
		while(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			temp = Main.tile[x][y];
			if(i == 0) {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK) {
					break;
				}
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE) {
					positions.add(new Position(x, y));
					break;
				}
				positions.add(new Position(x, y));
			}else {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE) {
					break;
				}
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK) {
					positions.add(new Position(x, y));
					break;
				}
				positions.add(new Position(x, y));
			}
			x--;
			y--;
		}
		
		x = current.getX();
		y = current.getY();
		//left diagonal down
		x = x + 1;
		y = y + 1;
		while(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			temp = Main.tile[x][y];
			if(i == 0) {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK) {
					break;
				}
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE) {
					positions.add(new Position(x, y));
					break;
				}
				positions.add(new Position(x, y));
			}else {
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE) {
					break;
				}
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK) {
					positions.add(new Position(x, y));
					break;
				}
				positions.add(new Position(x, y));
			}
			x++;
			y++;
		}
		return positions;
	}
	
}