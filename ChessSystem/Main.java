import BoardSet.Board;
import BoardSet.Position;

public class Main{
    public static void main(String[] args) {

        Position pos = new Position(3,5);
        System.out.println(pos);

        Board board = new Board(8,8);
        System.out.println(board);
    }
}