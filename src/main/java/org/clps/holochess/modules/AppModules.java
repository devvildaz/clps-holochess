package org.clps.holochess.modules;


import org.clps.holochess.ChessGameBoard;
import org.clps.holochess.ChessGameLog;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class AppModules extends AbstractModule{

   @Override
   public void configure() {
      binder().bind(ChessGameLog.class)
      .annotatedWith(Names.named("GameLog"))
      .toInstance(new ChessGameLog());
      
      binder().bind(ChessGameBoard.class)
      .annotatedWith(Names.named("GameBoard"))
      .toInstance(new ChessGameBoard());
      
   } 
}
