import java.util.Scanner;

import BoardSet.Board;
import BoardSet.Position;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class Main{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ChessMatch chess = new ChessMatch();

        while(true){
            UI.printBoard(chess.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.readChessPosition(scan);

            System.out.println();
            System.out.println("Target: ");
            ChessPosition target = UI.readChessPosition(scan);

            ChessPiece capturedPiece = chess.movingPiece(source, target);
        }
        
    }
}