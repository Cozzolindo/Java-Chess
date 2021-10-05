import BoardSet.Board;
import BoardSet.Position;
import Chess.ChessMatch;

public class Main{
    public static void main(String[] args) {

        ChessMatch chess = new ChessMatch();

        UI.printBoard(chess.getPieces());
    }
}