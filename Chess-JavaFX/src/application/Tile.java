package application;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import pieces.Pawn;
import pieces.Piece;

public class Tile {
	
	private StackPane root;
	private Piece piece;
	private Position position;
	private Rectangle rectangle;
	
	
	//Tile Constructor
	public Tile(Piece piece, Position position) {
		
		this.root = new StackPane();
		this.piece =  piece;
		this.position = position;

		
		Background bg;
		int x = position.getX() + position.getY();
		if(x % 2 == 0) {
			bg = new Background(new BackgroundFill(Color.BLUE,
					new CornerRadii(0), new Insets(0)));
		}
		else {
			bg = new Background(new BackgroundFill(Color.WHITE,
					new CornerRadii(0), new Insets(0)));
		}
		root.setMaxHeight(60);
		root.setMaxWidth(60);
		rectangle = new Rectangle(60, 60);
		rectangle.setFill(Color.TRANSPARENT);
	    root.setBackground(bg);
	    rectangle.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
        		if(Main.clickFlag == 0) firstClick();
            	else secondClick();
            }
        });
	}
	
	//first click of the player logic - if valid piece show possible moves else do nothing
	public void firstClick() {
		if(Main.player == 0) {
			if(piece == null || piece.getColor() == Color.WHITE)
				return;
			Main.possiblePositions = piece.move(position);
        	highlightTile(Main.possiblePositions);
        	Main.prevPosition = this.position;
        	Main.prevPiece = this.piece;
        	Main.clickFlag = 1;
		}else {
			if(piece == null || piece.getColor() == Color.BLACK)
				return;
			Main.possiblePositions = piece.move(position);
        	highlightTile(Main.possiblePositions);
        	Main.prevPosition = this.position;
        	Main.prevPiece = this.piece;
        	Main.clickFlag = 1;
		}
	}
	
	//second click logic - if clicked on possible move make a move else clear the tile
	public void secondClick() {
		if(Main.player == 0) {
			if(piece != null && piece.getColor() == Color.BLACK)
				firstClick();	
			for(Position p : Main.possiblePositions) {
				if(this.position.equals(p)) {
					int x = p.getX();
					int y = p.getY();
					Main.tile[x][y].setPiece(Main.prevPiece);
					x = Main.prevPosition.getX();
					y = Main.prevPosition.getY();
					Main.tile[x][y].removePiece();
					Main.clickFlag = 0;
					Main.player = 1;
					clearHighlightTile();
					if(Main.prevPiece.getPieceName() == PieceName.BlackPawn) {
						Pawn pawn = (Pawn) this.piece;
						pawn.count = 1;
 					}
				}
			}
			if(piece == null || piece.getColor() == Color.WHITE) {
				clearHighlightTile();
				Main.clickFlag = 0;
				return;
			}	
		}else {
			if(piece != null && piece.getColor() == Color.WHITE)
				firstClick();
			for(Position p : Main.possiblePositions) {
				if(this.position.equals(p)) {
					int x = p.getX();
					int y = p.getY();
					Main.tile[x][y].setPiece(Main.prevPiece);
					x = Main.prevPosition.getX();
					y = Main.prevPosition.getY();
					Main.tile[x][y].removePiece();
					Main.clickFlag = 0;
					Main.player = 0;
					clearHighlightTile();
					if(Main.prevPiece.getPieceName() == PieceName.WhitePawn) {
						Pawn pawn = (Pawn) this.piece;
						pawn.count = 1;
 					}
				}
			}
			if(piece == null || piece.getColor() == Color.BLACK) {
				clearHighlightTile();
				Main.clickFlag = 0;
				return;
			}
		}
	}
	
	
	//Getting the node for each tile
	public Node getNode() {
		if(piece != null)
			root.getChildren().addAll(piece.getImage(),rectangle);
		else
			root.getChildren().add(rectangle);
		return root;
	}
	
	
	//Highlighting the current tile on mouse click
	public void highlightTile() {
		clearHighlightTile();
		rectangle.setStrokeType(StrokeType.INSIDE);
		rectangle.setStrokeWidth(2.0);
		rectangle.setStroke(Color.RED);
	}
	
	//Highlighting all the tiles of possible moves
	public void highlightTile(ArrayList<Position> positions) {
		highlightTile();
		for(Position p : positions) {
			for(int i = 0;i < 8;i++) {
				for(int j = 0;j < 8;j++) {
					Rectangle rect = Main.tile[i][j].rectangle;
					if(p.getX() == i && p.getY() == j){
						rect.setStrokeType(StrokeType.INSIDE);
						rect.setStrokeWidth(2.0);
						rect.setStroke(Color.RED);
					}
				}
			}
		}
	}
	
	
	//clearing the highlight of the tile
	public void clearHighlightTile() {
		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 8;j++) {
				Rectangle rect = Main.tile[i][j].rectangle;
				if(rect.getStrokeType() == StrokeType.INSIDE){
					rect.setStrokeType(StrokeType.INSIDE);
					rect.setStroke(Color.TRANSPARENT);
				}
			}
		}
	}
	
	//getting the piece
	public Piece getPiece() {
		return this.piece;
	}
	
	
	//if tile is occupied by a piece
	public boolean isOccupied() {
		return piece != null;
	}
	
	//setting the piece to tile
	public void setPiece(Piece piece) {
		root.getChildren().clear();
		this.piece = piece;
		root.getChildren().addAll(piece.getImage(),rectangle);
	}	
	
	//removing the piece from the tile
	public void removePiece() {
		root.getChildren().clear();
		this.piece = null;
		root.getChildren().add(rectangle);
	}
	
}