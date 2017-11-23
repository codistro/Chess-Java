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
 * Rook Class represents both black and rooks pawns of chess board
 * 
 * @author RAJAN
 *
 */
public class Rook extends Piece{
	
	/**
	 * 
	 * @param color Color of the piece
	 */
	public Rook(Color color) {
		this.color = color;
		if(color == Color.BLACK) {
			this.pieceName = PieceName.BlackRook;
			this.image = new ImageView(new Image("/pieces/Black_Rook.png"));
		}
		else {
			this.pieceName = PieceName.WhiteRook;
			this.image = new ImageView(new Image("/pieces/White_Rook.png"));
		}
	}
	
	@Override
	public ArrayList<Position> move(Position current) {
		int x = current.getX();
		int y = current.getY();
		Tile temp;
		
		int i = 0;
		
		if(this.pieceName == PieceName.WhiteRook)
			i = 1;
		
		ArrayList<Position> positions = new ArrayList<Position>();
		
		x--;
		//Left movement logic
		while(x >= 0) {
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
		}
		
		x = current.getX();
		y = current.getY();
		x++;
		//right movement logic
		while(x <= 7) {
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
		}
		
		x = current.getX();
		y = current.getY();
		y--;
		//up movement logic
		while(y >= 0) {
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
			y--;
		}
		
		x = current.getX();
		y = current.getY();
		y++;
		//down movement logic
		while(y <= 7) {
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
			y++;
		}
				
		return positions;
	}
	
}
