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


/**
 * Represents the single cell of the Chess Board.
 * 
 * @author RAJAN
 *
 */
public class Tile {
	
	private StackPane root;
	private Piece piece;
	private Position position;
	private Rectangle rectangle;
	
	
	/**
	 * One and only constructor of the class.
	 * 
	 * @param piece Chess piece that is present in the Tile.
	 * @param position Position of the cell in the Chess board in form of (x,y) coordinates.
	 */
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
	
	/**
	 * When Player clicks for the first time on the any piece. Stores information about the piece.
	 */
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
	
	/**
	 * Initiates only after the first click, shows the possible moves of the piece.
	 */
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
	
	
	/**
	 * Getting the root node of each tile.
	 * 
	 * @return root node i.e. StackPane.
	 */
	public Node getNode() {
		if(piece != null)
			root.getChildren().addAll(piece.getImage(),rectangle);
		else
			root.getChildren().add(rectangle);
		return root;
	}
	
	
	/**
	 * Highlights the clicked tile if piece is not null.
	 */
	public void highlightTile() {
		clearHighlightTile();
		rectangle.setStrokeType(StrokeType.INSIDE);
		rectangle.setStrokeWidth(2.0);
		rectangle.setStroke(Color.RED);
	}
	
	/**
	 * Highlight all the possible cells for a piece to move.
	 * 
	 * @param positions ArrayList of Positions of all the possible moves.
	 */
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
	
	
	/**
	 * Clears all the highlighted tiles.
	 */
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
	
	/**
	 * Gets the piece of the tile.
	 * @return Piece is returned of the tile.
	 */
	public Piece getPiece() {
		return this.piece;
	}
	
	
	/**
	 * Sets a piece to the tile.
	 * @param piece Piece to set on the tile.
	 */
	public void setPiece(Piece piece) {
		root.getChildren().clear();
		this.piece = piece;
		root.getChildren().addAll(piece.getImage(),rectangle);
	}	
	
	/**
	 * Remove piece from the tile
	 */
	public void removePiece() {
		root.getChildren().clear();
		this.piece = null;
		root.getChildren().add(rectangle);
	}
	
}