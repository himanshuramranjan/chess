package model.pieces;

import enums.Color;

public class Rook extends Piece {

    public Rook(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean isValidMove(int destRow, int destCol) {
        return isValidSelection(destRow, destCol) && (row == destRow || col == destCol);
    }
}
