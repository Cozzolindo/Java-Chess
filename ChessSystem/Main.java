import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import BoardSet.Board;
import BoardSet.Position;
import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class Main{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ChessMatch chess = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while(true){
            try{
                UI.clearScreen();   
                UI.printMatch(chess, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(scan);

                boolean[][] possibleMoves = chess.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chess.getPieces(), possibleMoves);
                System.out.println();
                System.out.println("Target: ");
                ChessPosition target = UI.readChessPosition(scan);

                ChessPiece capturedPiece = chess.movingPiece(source, target);
                if(capturedPiece != null){
                    captured.add(capturedPiece);
                }
            } catch(ChessException e){
                System.out.println(e.getMessage());
                scan.nextLine();
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }
        
    }
}