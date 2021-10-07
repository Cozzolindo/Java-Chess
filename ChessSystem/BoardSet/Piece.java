package BoardSet;

public abstract class Piece {
    
    protected Position position;
    private Board board;
    public abstract boolean[][] possibleMoves();


    public Piece( Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return this.board;
    }

    public boolean possibleMoves(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean haveMoves(){
        boolean[][] mat = possibleMoves();
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat.length; j++){
                if(mat[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

}
