package model.pieces;

import enums.Color;

public abstract class Piece {
    protected final Color color;
    protected int row;
    protected int col;

    protected Piece(Color color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
    }

    public abstract boolean isValidMove(int row, int col);

    protected boolean isValidSelection(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public Color getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

