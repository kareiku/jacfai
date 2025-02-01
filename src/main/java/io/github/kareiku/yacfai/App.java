package io.github.kareiku.yacfai;

public class App {
    public static void main(String[] args) {
        Board board = new Board(new Piece[][]{
                {Piece.RED, Piece.RED, Piece.BLUE},
                {Piece.BLUE, Piece.RED, Piece.RED},
                {Piece.NONE, Piece.BLUE, Piece.BLUE},
                {Piece.NONE, Piece.NONE, Piece.RED},
        });

        System.out.println(board.format());
    }
}
