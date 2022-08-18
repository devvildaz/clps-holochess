package org.clps.holochess;

import org.clps.holochess.enumeration.PieceColorEnum;

import java.util.ArrayList;
// -------------------------------------------------------------------------
/**
 * Represents a King game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class King
    extends ChessGamePiece{
    // ----------------------------------------------------------
    /**
     * Create a new King object.
     *
     * @param board
     *            the board to create the king on
     * @param row
     *            the row to create the king on
     * @param col
     *            the column to create the king on
     * @param color
     *            either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public King( ChessGameBoard board, int row, int col, PieceColorEnum color ){
        super( board, row, col, color, false );
    }
    /**
     * Calculates the possible moves for this piece. These are ALL the possible
     * moves, including illegal (but at the same time valid) moves.
     *
     * @param board
     *            the game board to calculate moves on
     * @return ArrayList<String> the moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves( ChessGameBoard board ){
        ArrayList<String> allMoves = new ArrayList<>();
        allMoves.addAll( calculateNorthEastMoves( board, 1 ) );
        allMoves.addAll( calculateNorthWestMoves( board, 1 ) );
        allMoves.addAll( calculateSouthWestMoves( board, 1 ) );
        allMoves.addAll( calculateSouthEastMoves( board, 1 ) );
        allMoves.addAll( calculateNorthMoves( board, 1 ) );
        allMoves.addAll( calculateSouthMoves( board, 1 ) );
        allMoves.addAll( calculateWestMoves( board, 1 ) );
        allMoves.addAll( calculateEastMoves( board, 1 ) );
        return allMoves;
    }
    /**
     * Determines if this King is checked.
     *
     * @param board
     *            the board to check on
     * @return true if checked, false if not checked
     */
    public boolean isChecked( ChessGameBoard board ){
        return !getCurrentAttackers( board ).isEmpty();
    }
}
