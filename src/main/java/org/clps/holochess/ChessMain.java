package org.clps.holochess;

import javax.swing.*;

import org.clps.holochess.modules.AppModules;

import com.google.inject.Guice;
import com.google.inject.Injector;

// -------------------------------------------------------------------------
/**
 * Shows the GUI for the Chess game.
 * 
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class ChessMain{
    // ----------------------------------------------------------
    /**
     * Creates the GUI for Chess.
     * 
     * @param args
     *            command line arguments, not used
     */
    public static void main( String[] args ){
    	/* Create new windows container */
        JFrame frame = new JFrame( "YetAnotherChessGame 1.0" );
        /* Set the close event */
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        /* Add chess panel for view the game */
        Injector injector = Guice.createInjector(new AppModules());
        ChessPanel panel = injector.getInstance(ChessPanel.class);
        frame.getContentPane().add(panel);
        /* resize the components of the frame */
        frame.pack();
        /* block the frame until trigger close event */
        frame.setVisible( true );
    }
}
