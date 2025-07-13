package model;


import enums.Color;
import exception.InvalidMoveException;
import model.pieces.Piece;

public class Player {
    private final Color color;

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void makeMove(Move move) {
        Piece piece = move.getPiece();
        Board board = Board.getInstance();

        int destRow = move.getRow();
        int destCol = move.getCol();

        if (piece.isValidMove(destRow, destCol) || board.getBoard()[destRow][destCol] != null) {
            int sourceRow = piece.getRow();
            int sourceCol = piece.getCol();

            board.setPiece(sourceRow, sourceCol, null);
            board.setPiece(destRow, destCol, piece);
            piece.setPosition(destRow, destCol);
        } else {
            throw new InvalidMoveException("Invalid move!");
        }
    }
}
