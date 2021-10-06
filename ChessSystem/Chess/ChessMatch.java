package Chess;

import BoardSet.Board;
import BoardSet.Position;
import Chess.ChessPieces.King;
import Chess.ChessPieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch(){
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i = 0; i<board.getRows(); i++){
            for(int j = 0; j<board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, (new ChessPosition(column, row).toPosition()));
    }

    private void initialSetup(){
        
        placeNewPiece('e', 8, new King(board, Colors.Black));
        placeNewPiece('h', 8, new Rook(board, Colors.Black));
        placeNewPiece('a', 8, new Rook(board, Colors.Black));

        placeNewPiece('e', 1, new King(board, Colors.White));
        placeNewPiece('a', 1, new Rook(board, Colors.White));
        placeNewPiece('h', 1, new Rook(board, Colors.White));
    }
    
}
