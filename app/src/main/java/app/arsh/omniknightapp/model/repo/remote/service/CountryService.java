package app.arsh.omniknightapp.model.repo.remote.service;

import app.arsh.omniknightapp.model.repo.local.entity.Country;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by arash on 10/18/16.
 */

public interface CountryService {

    @GET("all")
    Call<List<Country>> countryList();

    @GET("name/{name}")
    Call<List<Country>> countryDetail(@Path("name") String countryName,
        @Query("fullText") boolean fullText);

}
