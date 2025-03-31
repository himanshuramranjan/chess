package model.pieces;

import enums.Color;

public class King extends Piece{
    public King(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean isValidMove(int destRow, int destCol) {
        super.isValidSelection(destRow, destCol);
        int rowDiff = Math.abs(destRow - row);
        int colDiff = Math.abs(destCol - col);
        return (rowDiff <= 1 && colDiff <= 1);
    }
}
