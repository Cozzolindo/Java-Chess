package Chess;

import java.util.ArrayList;
import java.util.List;

import BoardSet.Board;
import BoardSet.BoardException;
import BoardSet.Piece;
import BoardSet.Position;
import Chess.ChessPieces.King;
import Chess.ChessPieces.Rook;

public class ChessMatch {

    private Board board;
    private int turn;
    private Colors currentPlayer;
    private List<Piece> piecesOnBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public ChessMatch(){
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Colors.White;
        initialSetup();
    }

    public int getTurn(){
        return turn;
    }

    public Colors getCurrentPlayer(){
        return currentPlayer;
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

    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece movingPiece(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);

        if(capturedPiece != null){
            piecesOnBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
        return capturedPiece;
    }

    private void validateSourcePosition(Position position){
        if(!(board.havePiece(position))){
            throw new ChessException("There is no piece here.");
        }else if(currentPlayer != ((ChessPiece) board.piece(position)).getColor()){
            throw new ChessException("Chosen piece is not yours.");
        } else if(!(board.piece(position).haveMoves())){
            throw new ChessException("This chosen piece have no possible moves.");
        }
    }

    private void validateTargetPosition (Position source, Position target){
        if(!(board.piece(source).possibleMoves(target))){
            throw new ChessException("Chosen piece can't move to target position.");
        }
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, (new ChessPosition(column, row).toPosition()));
        piecesOnBoard.add(piece);
    }

    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == Colors.White) ? Colors.Black : Colors.White;
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
