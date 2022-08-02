package org.clps.holochess;

import java.awt.*;
import javax.swing.*;

import org.clps.holochess.modules.AppModules;
import org.clps.holochess.modules.IChessGameLog;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.name.Named;
// -------------------------------------------------------------------------
/**
 * The main panel of the Chess game.
 * 
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */

public class ChessPanel
    extends JPanel{
	/* file, options and help sections */
    private ChessMenuBar    menuBar;
    /* render the grid of the chess */
    private ChessGameBoard  gameBoard;
    /* render the game log */
    private ChessGameLog gameLog;
    /* render the player one side */
    private ChessGraveyard  playerOneGraveyard;
    /* render the player two side */
    private ChessGraveyard  playerTwoGraveyard;
    /* contains the game logic */
    private ChessGameEngine gameEngine;
    // ----------------------------------------------------------
    /**
     * Create a new ChessPanel object.
     */
   
	@Inject
    public ChessPanel(@Named("GameLog") ChessGameLog gameLog, @Named("GameBoard") ChessGameBoard board){
        this.setLayout( new BorderLayout() );
        menuBar = new ChessMenuBar(); // instatiate menu bar
        gameBoard = board; // instatiate game board (state)
        this.gameLog = new ChessGameLog(); // instatiate game log
        playerOneGraveyard = new ChessGraveyard( "Player 1's graveyard" ); // create the one player side 
        playerTwoGraveyard = new ChessGraveyard( "Player 2's graveyard" ); // create the two player side
        this.add( menuBar, BorderLayout.NORTH ); /* set the position */
        this.add( gameBoard, BorderLayout.CENTER ); /* set the position */
        this.add( this.gameLog, BorderLayout.SOUTH ); /* set the position */
        this.add( playerOneGraveyard, BorderLayout.WEST ); /* set the position */
        this.add( playerTwoGraveyard, BorderLayout.EAST ); /* set the position */
        this.setPreferredSize( new Dimension( 800, 600 ) ); /* set the default dimensions */
        gameEngine = new ChessGameEngine(gameLog, board); // start the game
    }
    // ----------------------------------------------------------
    /**
     * Gets the logger object for use in other classes.
     * 
     * @return ChessGameLog the ChessGameLog object
     */
    public ChessGameLog getGameLog(){
        return gameLog;
    }
    // ----------------------------------------------------------
    /**
     * Gets the board object for use in other classes.
     * 
     * @return ChessGameBoard the ChessGameBoard object
     */
    public ChessGameBoard getGameBoard(){
        return gameBoard;
    }
    // ----------------------------------------------------------
    /**
     * Gets the game engine object for use in other classes
     * 
     * @return ChessGameEngine the ChessGameEngine object
     */
    public ChessGameEngine getGameEngine(){
        return gameEngine;
    }
    // ----------------------------------------------------------
    /**
     * Gets the appropriate graveyard object for use in other classes.
     * 
     * @param whichPlayer
     *            the number of the player (1 or 2)
     * @return ChessGraveyard the graveyard requested
     */
    public ChessGraveyard getGraveyard( int whichPlayer ){
        if ( whichPlayer == 1 ){
            return playerOneGraveyard;
        }
        else if ( whichPlayer == 2 ){
            return playerTwoGraveyard;
        }
        else
        {
            return null;
        }
    }
}
