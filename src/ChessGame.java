import enums.Color;
import exception.InvalidMoveException;
import model.Board;
import model.Move;
import model.Player;
import model.pieces.Piece;

import java.util.Scanner;

public class ChessGame {
    private static final ChessGame chessGame = new ChessGame();
    private final Player[] players;
    private final Board board;
    private int currentPlayer;

    private ChessGame() {
        this.board = Board.getInstance();
        this.players = new Player[] { new Player(Color.WHITE), new Player(Color.BLACK)};
        this.currentPlayer = 0;
    }

    public static ChessGame getInstance() { return chessGame; }

    public Player[] getPlayers() {
        return players;
    }

    public void start() {
        // Game loop
        while (!isGameOver()) {
            Player player = players[currentPlayer];
            System.out.println(player.getColor() + "'s turn.");

            // Get move from the player
            Move move = getPlayerMove(player);

            // Make the move on the board
            try {
                player.makeMove(move);
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
                System.out.println("Try again!");
                continue;
            }

            // Switch to the next player
            currentPlayer = (currentPlayer + 1) % 2;
        }

        // Display game result
        displayResult();
    }

    private boolean isGameOver() {
        return board.isCheckmate(players[0].getColor()) || board.isCheckmate(players[1].getColor()) ||
                board.isStalemate(players[0].getColor()) || board.isStalemate(players[1].getColor());
    }

    private Move getPlayerMove(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source row: ");
        int sourceRow = scanner.nextInt();
        System.out.print("Enter source column: ");
        int sourceCol = scanner.nextInt();
        System.out.print("Enter destination row: ");
        int destRow = scanner.nextInt();
        System.out.print("Enter destination column: ");
        int destCol = scanner.nextInt();

        Piece piece = board.getPiece(sourceRow, sourceCol);
        if (piece == null || piece.getColor() != player.getColor()) {
            throw new IllegalArgumentException("Invalid piece selection!");
        }

        return new Move(piece, destRow, destCol);
    }

    private void displayResult() {
        if (board.isCheckmate(Color.WHITE)) {
            System.out.println("Black wins by checkmate!");
        } else if (board.isCheckmate(Color.BLACK)) {
            System.out.println("White wins by checkmate!");
        } else if (board.isStalemate(Color.WHITE) || board.isStalemate(Color.BLACK)) {
            System.out.println("The game ends in a stalemate!");
        }
    }

}
