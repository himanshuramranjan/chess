package model.pieces;

import enums.Color;
import model.Board;

public class Pawn extends Piece {
    public Pawn(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean isValidMove(int destRow, int destCol) {
        int rowDiff = destRow - row;
        int colDiff = Math.abs(destCol - col);
        boolean isValidMove;

        if (color == Color.WHITE) {
            isValidMove = (rowDiff == 1 && colDiff == 0) ||
                    (row == 1 && rowDiff == 2 && colDiff == 0) ||
                    (rowDiff == 1 && colDiff == 1 && Board.getInstance().getPiece(destRow, destCol) != null);
        } else {
            isValidMove = (rowDiff == -1 && colDiff == 0) ||
                    (row == 6 && rowDiff == -2 && colDiff == 0) ||
                    (rowDiff == -1 && colDiff == 1 && Board.getInstance().getPiece(destRow, destCol) != null);
        }
        return isValidSelection(destRow, destCol) && isValidMove;
    }
}
