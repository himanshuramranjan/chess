package model.pieces;

import enums.Color;

public class Queen extends Piece {

    public Queen(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean isValidMove(int destRow, int destCol) {
        int rowDiff = Math.abs(destRow - row);
        int colDiff = Math.abs(destCol - col);
        return isValidSelection(destRow, destCol) && ((rowDiff == colDiff) || (row == destRow || col == destCol));
    }
}
