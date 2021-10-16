package Chess;

import BoardSet.Piece;
import BoardSet.Position;
import BoardSet.Board;

public abstract class ChessPiece extends Piece{

    private Colors color;


    public ChessPiece(Board board, Colors color) {
        super(board);
        this.color = color;
    }


    public Colors getColor() {
        return this.color;
    }

    protected boolean haveOpponent(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p!= null && p.getColor() != color;
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }
    
}
