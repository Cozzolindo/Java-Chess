package Chess;

import BoardSet.Piece;
import BoardSet.Board;

public class ChessPiece extends Piece{

    private Colors color;


    public ChessPiece(Board board, Colors color) {
        super(board);
        this.color = color;
    }


    public Colors getColor() {
        return this.color;
    }


    
}
