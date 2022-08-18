package org.clps.holochess;

import org.clps.holochess.enumeration.PieceColorEnum;

import java.util.ArrayList;
// import java.awt.Color;
// -------------------------------------------------------------------------
/**
 * Represents a Queen game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Queen
    extends ChessGamePiece{
    // ----------------------------------------------------------
    /**
     * Create a new Queen object.
     *
     * @param board
     *            the board the queen is on
     * @param row
     *            the row location of the queen
     * @param col
     *            the column location of the queen
     * @param color
     *            either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Queen( ChessGameBoard board, int row, int col, PieceColorEnum color ){
        super( board, row, col, color );
    }
    /**
     * Calculates the possible moves for this Queen.
     * @param board the board to check on
     * @return ArrayList<String> the list of moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves( ChessGameBoard board ){
        ArrayList<String> allMoves = new ArrayList<>();
        allMoves.addAll( calculateNorthEastMoves( board, 8 ) );
        allMoves.addAll( calculateNorthWestMoves( board, 8 ) );
        allMoves.addAll( calculateSouthWestMoves( board, 8 ) );
        allMoves.addAll( calculateSouthEastMoves( board, 8 ) );
        allMoves.addAll( calculateNorthMoves( board, 8 ) );
        allMoves.addAll( calculateSouthMoves( board, 8 ) );
        allMoves.addAll( calculateWestMoves( board, 8 ) );
        allMoves.addAll( calculateEastMoves( board, 8 ) );
        return allMoves;
    }
}
