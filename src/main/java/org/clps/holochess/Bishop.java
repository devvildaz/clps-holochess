package org.clps.holochess;

import org.clps.holochess.enumeration.PieceColorEnum;

import java.util.ArrayList;
// -------------------------------------------------------------------------
/**
 * Class to represent the Bishop piece.
 * 
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Bishop extends ChessGamePiece{
    /**
     * Creates a new Bishop object.
     * 
     * @param board
     *            board the board to create the bishop on
     * @param row
     *            row location of the Bishop
     * @param col
     *            col location of the Bishop
     * @param color
     *            either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Bishop( ChessGameBoard board, int row, int col, PieceColorEnum color ){
        super( board, row, col, color );
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
        allMoves.addAll( calculateNorthEastMoves( board, 8 ) );
        allMoves.addAll( calculateNorthWestMoves( board, 8 ) );
        allMoves.addAll( calculateSouthEastMoves( board, 8 ) );
        allMoves.addAll( calculateSouthWestMoves( board, 8 ) );
        return allMoves;
    }
}
