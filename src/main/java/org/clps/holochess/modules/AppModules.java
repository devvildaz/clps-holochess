package org.clps.holochess.modules;


import org.clps.holochess.ChessGameBoard;
import org.clps.holochess.ChessGameEngine;
import org.clps.holochess.ChessGameLog;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class AppModules extends AbstractModule{

	
	
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
		// PORHACER Auto-generated catch block
		System.out.println('a');
	}
   } 
}
