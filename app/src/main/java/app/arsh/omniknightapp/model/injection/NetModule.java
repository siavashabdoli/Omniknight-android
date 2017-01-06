package app.arsh.omniknightapp.model.injection;

import app.arsh.omniknightapp.model.repo.remote.RESTClient;
import dagger.Module;
import dagger.Provides;

/**
 * Created by arash on 1/5/17.
 */

@Module
public class NetModule {

  @Provides RESTClient provideRestClient() {
    return new RESTClient();
  }

}
