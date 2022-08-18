package org.clps.holochess.modules;


import java.util.logging.Logger;

import org.clps.holochess.ChessGameBoard;
import org.clps.holochess.ChessGameEngine;
import org.clps.holochess.ChessGameLog;

import com.google.inject.AbstractModule;

import com.google.inject.Scopes;


import com.google.inject.name.Names;

public class AppModules extends AbstractModule{
	static Logger logger;
	static {
		logger = Logger.getLogger("MyLog");
	}
	
   @Override
   public void configure() {
      bind(ChessGameLog.class)
      .annotatedWith(Names.named("GameLog"))
      .to(ChessGameLog.class).in(Scopes.SINGLETON);
      
      bind(ChessGameBoard.class)
      .annotatedWith(Names.named("GameBoard"))
      .to(ChessGameBoard.class).in(Scopes.SINGLETON);
      
      Class<?>[] classes = new Class[] {
    		  ChessGameLog.class,
    		  ChessGameBoard.class
      };
      
      try {
		bind(ChessGameEngine.class)
		  .annotatedWith(Names.named("GameEngine"))
		  .toConstructor(
			  ChessGameEngine.class.getConstructor(classes)
		  ).in(Scopes.SINGLETON);
	} catch (NoSuchMethodException | SecurityException e) {
		logger.info("Game Engine no se inicializado");
	}
   } 
}
