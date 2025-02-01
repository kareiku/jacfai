package io.github.kareiku.yacfai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private static final int DEFAULT_ROWS = 6;
    private static final int DEFAULT_COLUMNS = 7;

    private final int rows;
    private final int columns;
    private final Piece[][] board;

    public Board() {
        this(DEFAULT_ROWS, DEFAULT_COLUMNS);
    }

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new Piece[this.rows][this.columns];
        Arrays.stream(this.board).forEach(row -> Arrays.fill(row, Piece.NONE));
    }

    public Board(Piece[][] board) {
        this(board.length, board[0].length);
        for (int i = 0; i < this.rows; i++) {
            System.arraycopy(board[i], 0, this.board[i], 0, this.columns);
        }
    }

    private boolean isValid(int column) {
        return column >= 0 && column < this.columns;
    }

    private boolean isColumnFree(int column) {
        int i = 0;
        while (i < this.rows && this.board[i][column] != Piece.NONE) {
            i++;
        }
        return this.isValid(column) && i < this.rows;
    }

    public void place(int column, Piece piece) {
        if (this.isValid(column) && this.isColumnFree(column)) {
            int i = 0;
            while (this.board[i][column] != Piece.NONE) {
                i++;
            }
            this.board[i][column] = piece;
        }
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

    private String format(Piece[] row) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(row).forEach(builder::append);
        return builder.toString();
    }

    public String format() {
        StringBuilder builder = new StringBuilder();
        for (int i = this.board.length - 1; i >= 0; i--) {
            builder.append(this.format(this.board[i])).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
