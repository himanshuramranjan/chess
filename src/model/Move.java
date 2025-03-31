package model;

import model.pieces.Piece;

public class Move {
    private Piece piece;
    private int row;
    private int col;

    public Move(Piece piece, int row, int col) {
        this.piece = piece;
        this.row = row;
        this.col = col;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
