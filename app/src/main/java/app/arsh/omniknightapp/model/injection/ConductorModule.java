package app.arsh.omniknightapp.model.injection;

import app.arsh.omniknightapp.model.conductor.Conductor;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by arash on 1/31/17.
 */

@Module
public class ConductorModule {

  @Provides
  @Singleton Conductor getConductor() {
    return Conductor.getInstance();
  }
}
