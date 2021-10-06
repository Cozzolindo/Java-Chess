package Chess.ChessPieces;

import Chess.ChessPiece;
import Chess.Colors;
import BoardSet.Board;

public class King extends ChessPiece {

    public King(Board board, Colors color){
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }
}
