package pieces;

import java.util.ArrayList;

import application.Main;
import application.PieceName;
import application.Position;
import application.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Queen extends Piece{
	public Queen(Color color) {
		this.color = color;
		if(color == Color.BLACK) {
			this.pieceName = PieceName.BlackQueen;
			this.image = new ImageView(new Image("/pieces/Black_Queen.png"));
		}
		else {
			this.pieceName = PieceName.WhiteQueen;
			this.image = new ImageView(new Image("/pieces/White_Queen.png"));
		}
	}
	
	@Override
	public ArrayList<Position> move(Position current) {
		ArrayList<Position> positions = new ArrayList<Position>();
		
		int x = current.getX();
		int y = current.getY();
		Tile temp;
		int i = 0;
		
		if(this.pieceName == PieceName.WhiteQueen)
			i = 1;
		
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
		
		x = current.getX();
		y = current.getY();
		
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