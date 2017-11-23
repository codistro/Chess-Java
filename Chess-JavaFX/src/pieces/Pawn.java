package pieces;

import java.util.ArrayList;

import application.Main;
import application.PieceName;
import application.Position;
import application.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


public class Pawn extends Piece{
	
	public int count = 0;
	
	public Pawn(Color color) {
		this.color = color;
		if(color == Color.BLACK) {
			this.pieceName = PieceName.BlackPawn;
			this.image = new ImageView(new Image("/pieces/Black_Pawn.png"));
		}
		else {
			this.pieceName = PieceName.WhitePawn;
			this.image = new ImageView(new Image("/pieces/White_Pawn.png"));
		}
	}
	
	@Override
	public ArrayList<Position> move(Position current) {
		
		ArrayList<Position> positions = new ArrayList<Position>();
		
		int currX = current.getX();
		int currY = current.getY();
		
		//checking for opponent diagonal piece
		if(this.pieceName == PieceName.BlackPawn) {
			int x = currX - 1;
			int y = currY + 1;
			Tile temp;
			if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
				temp = Main.tile[x][y];
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE){
					positions.add(new Position(x, y));
				}
			}
			
			x = currX + 1;
			y = currY + 1;
			if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
				temp = Main.tile[x][y];
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.WHITE){
					positions.add(new Position(x, y));
				}
			}
		}
		else {
			int x = currX - 1;
			int y = currY - 1;
			Tile temp;
			
			if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
				temp = Main.tile[x][y];
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK){
					positions.add(new Position(x, y));
				}
			}
			
			x = currX + 1;
			y = currY - 1;
			
			if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
				temp = Main.tile[x][y];
				if(temp.getPiece() != null && temp.getPiece().getColor() == Color.BLACK){
					positions.add(new Position(x, y));
				}
			}
		}
		
		
		//Pawn moving for the first time - 2 steps
		if(count == 0) {
			int x, y;
			Tile temp;
			Boolean flag = false;
			if(this.pieceName == PieceName.BlackPawn) {
				x = currX;
				y = currY + 1;
				if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
					temp = Main.tile[x][y];
					if(temp.getPiece() == null)
						positions.add(new Position(x, y));
					else
						flag = true;
				}
				x = currX;
				y++;
				if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
					temp = Main.tile[x][y];
					if(temp.getPiece() == null && flag == false)
						positions.add(new Position(x, y));
				}
			}
			else {
				x = currX;
				y = currY - 1;
				if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
					temp = Main.tile[x][y];
					if(temp.getPiece() == null)
						positions.add(new Position(x, y));
					else
						flag = true;
				}
				x = currX;
				y--;
				if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
					temp = Main.tile[x][y];
					if(temp.getPiece() == null && flag == false)
						positions.add(new Position(x, y));
				}
			}
		}
		else {
			Tile temp;
			int x, y;
			if(this.pieceName == PieceName.BlackPawn) {
				x = currX;
				y = currY + 1;
				if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
					temp = Main.tile[x][y];
					if(temp.getPiece() == null)
						positions.add(new Position(x, y));
				}
				
			}else {
				x = currX;
				y = currY - 1;
				if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
					temp = Main.tile[x][y];
					if(temp.getPiece() == null)
						positions.add(new Position(x, y));
				}
			}
		}
		
		return positions;
	}
}
