package Chess.ChessPieces;

import Chess.ChessPiece;
import Chess.Colors;
import BoardSet.Board;

public class Rook extends ChessPiece{
    


    public Rook(Board board, Colors color){
        super(board, color);
    }


    @Override
    public String toString() {
        return "R";
    }
    

}
