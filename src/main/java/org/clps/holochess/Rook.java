package org.clps.holochess;

import org.clps.holochess.enumeration.PieceColorEnum;

import javax.swing.ImageIcon;
import java.util.ArrayList;
// -------------------------------------------------------------------------
/**
 * Represents a Rook game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Rook
    extends ChessGamePiece{
    // private ArrayList<String> possibleMoves;
    // ----------------------------------------------------------
    /**
     * Create a new Rook object.
     *
     * @param board
     *            the board to create the rook on
     * @param row
     *            the row to create the rook on
     * @param col
     *            the column to create the rook on
     * @param color
     *            either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Rook( ChessGameBoard board, int row, int col, PieceColorEnum color ){
        super( board, row, col, color );
    }
    /**
     * Calculates the possible moves for this Rook.
     * @param board the board to check on
     * @return ArrayList<String> the list of moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves( ChessGameBoard board ){
        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll( calculateNorthMoves( board, 8 ) );
        allMoves.addAll( calculateSouthMoves( board, 8 ) );
        allMoves.addAll( calculateWestMoves( board, 8 ) );
        allMoves.addAll( calculateEastMoves( board, 8 ) );
        return allMoves;
    }
}
