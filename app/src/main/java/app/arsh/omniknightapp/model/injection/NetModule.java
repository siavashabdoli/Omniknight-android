package app.arsh.omniknightapp.model.injection;

import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.model.repo.remote.service.CountryService;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static app.arsh.omniknightapp.model.repo.remote.RESTClient.COUNTRY_SERVICE_BASE_URLL;

/**
 * Created by arash on 1/5/17.
 */

@Module
public class NetModule {

  @Provides
  @Singleton OkHttpClient getOkHttpClient() {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    builder.addInterceptor(logging);
    return builder.build();
  }

  @Provides
  @Singleton Retrofit getRetrofitInstance(OkHttpClient okHttpClient) {

    Retrofit.Builder retrofit = new Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(COUNTRY_SERVICE_BASE_URLL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    return retrofit.build();
  }

  @Provides
  Call<List<Country>> prodiveCountryList(Retrofit retrofit) {
    return retrofit
        .create(CountryService.class)
        .countryList();
  }
}
