package io.github.kareiku.jacfai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private static final int DEFAULT_ROW_COUNT = 6;
    private static final int DEFAULT_COLUMN_COUNT = 7;

    private final Piece[][] board;

    public Board() {
        this(DEFAULT_ROW_COUNT, DEFAULT_COLUMN_COUNT);
    }

    private Board(int rowCount, int columnCount) {
        this.board = new Piece[rowCount][columnCount];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, Piece.NONE));
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i <= DEFAULT_ROW_COUNT && j >= 0 && j <= DEFAULT_COLUMN_COUNT;
    }

    private boolean isEmpty(int i, int j) throws ArrayIndexOutOfBoundsException {
        assert this.isValid(i, j);
        return this.board[i][j] == Piece.NONE;
    }

    private void place(int i, int j, Piece piece) {
        assert this.isValid(i, j);

        this.board[i][j] = piece;
    }

    public List<Board> expansion() {
        List<Board> boards = new ArrayList<>();

        for (int i = 0; i < this.board[0].length; i++) {
            Board board = this.copyOf();
            
        }

        return boards;
    }

    private Board copyOf() {
        Board board = new Board();
        for (int i = 0; i < this.board.length; i++) {
            System.arraycopy(this.board[i], 0, board.board[i], 0, this.board[0].length);
        }
        return board;
    }
}
