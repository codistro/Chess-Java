package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import pieces.*;
import pieces.Piece;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	public static Tile tile[][] = new Tile[8][8];
	public static int player = 1;
	public static int clickFlag = 0;
	public static ArrayList<Position> possiblePositions = new ArrayList<>();
	public static Piece prevPiece;
	public static Position prevPosition;
	
	@Override
	public void start(Stage primaryStage) {

			GridPane root = new GridPane();
			
			Color black = Color.BLACK;
			Color white = Color.WHITE;
			
			//Declaring black Pieces;
			Bishop blackBishop1 = new Bishop(black);
			Bishop blackBishop2 = new Bishop(black); 
			King blackKing = new King(black);
			Knight blackKnight1 = new Knight(black);
			Knight blackKnight2 = new Knight(black);
			Pawn blackPawn[] = new Pawn[8];
				for(int i = 0;i < 8;i++)
					blackPawn[i] = new Pawn(black);
			Queen blackQueen = new Queen(black);
			Rook blackRook1 = new Rook(black);
			Rook blackRook2 = new Rook(black);
			
			//Declaring white pieces
			Bishop whiteBishop1 = new Bishop(white);
			Bishop whiteBishop2 = new Bishop(white); 
			King whiteKing = new King(white);
			Knight whiteKnight1 = new Knight(white);
			Knight whiteKnight2 = new Knight(white);
			Pawn whitePawn[] = new Pawn[8];
				for(int i = 0;i < 8;i++)
					whitePawn[i] = new Pawn(white);
			Queen whiteQueen = new Queen(white);
			Rook whiteRook1 = new Rook(white);
			Rook whiteRook2 = new Rook(white);
			
			
			//Adding Black pieces to the board
			tile[0][0] = new Tile(blackRook1,new Position(0,0));
			tile[7][0] = new Tile(blackRook2,new Position(7,0));
			tile[1][0] = new Tile(blackKnight1,new Position(1,0));
			tile[6][0] = new Tile(blackKnight2,new Position(6,0));
			tile[2][0] = new Tile(blackBishop1,new Position(2,0));
			tile[5][0] = new Tile(blackBishop2,new Position(5,0));
			tile[3][0] = new Tile(blackQueen,new Position(3, 0));
			tile[4][0] = new Tile(blackKing,new Position(4, 0));
			for(int i = 0; i < 8;i++)
				tile[i][1] = new Tile(blackPawn[i],new Position(i, 1));
			
			
			//Adding White pieces to the board
			tile[0][7] = new Tile(whiteRook1,new Position(0,7));
			tile[7][7] = new Tile(whiteRook2,new Position(7,7));
			tile[1][7] = new Tile(whiteKnight1,new Position(1,7));
			tile[6][7] = new Tile(whiteKnight2,new Position(6,7));
			tile[2][7] = new Tile(whiteBishop1,new Position(2,7));
			tile[5][7] = new Tile(whiteBishop2,new Position(5,7));
			tile[3][7] = new Tile(whiteQueen,new Position(3,7));
			tile[4][7] = new Tile(whiteKing,new Position(4,7));
			for(int i = 0; i < 8;i++)
				tile[i][6] = new Tile(whitePawn[i],new Position(i, 6));
			
		
			for(int i = 0;i < 8;i++) {
				for(int j = 0;j < 8;j++) {
					if(j >= 2 && j <= 5)
						tile[i][j] = new Tile(null, new Position(i,j));
					
					root.add(tile[i][j].getNode(), i, j);
				}
			}
			
			
			
			
			
			Scene scene = new Scene(root,470,470);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);;
			primaryStage.show();
			
	
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}