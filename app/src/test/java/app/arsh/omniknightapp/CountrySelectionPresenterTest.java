package app.arsh.omniknightapp;

import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.model.repo.remote.service.CountryService;
import app.arsh.omniknightapp.presenter.CountrySelectionPresenter;
import app.arsh.omniknightapp.presenter.interfaces.CountrySelectionInterface;
import app.arsh.omniknightapp.view.activities.MainActivity;
import java.io.IOException;
import java.util.List;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.verify;

/**
 * Created by arash on 1/6/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class CountrySelectionPresenterTest {

  private CountrySelectionInterface listener;
  private MainActivity mainActivity;
  private CountrySelectionPresenter presenter;

  @Test
  public void showAndHideProgressViewTest() {
    listener = Mockito.mock(CountrySelectionInterface.class);
    mainActivity = Robolectric.setupActivity(MainActivity.class);
    presenter = new CountrySelectionPresenter(mainActivity, listener);

    presenter.onCreateViewFinished();
    verify(listener).showProgressBar();
  }

  @Test
  public void getCountriesTest() throws IOException {
    MockWebServer mockWebServer = new MockWebServer();

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(mockWebServer.url("http://restcountries.eu/rest/v1/").toString())
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    //Set a response for retrofit to handle. You can copy a sample
    //response from your server to simulate a correct result or an error.
    //MockResponse can also be customized with different parameters
    //to match your test needs
    mockWebServer.enqueue(new MockResponse().setBody("[\n"
        + "    {\n"
        + "        \"name\": \"Afghanistan\",\n"
        + "        \"topLevelDomain\": [\n"
        + "            \".af\"\n"
        + "        ],\n"
        + "        \"alpha2Code\": \"AF\",\n"
        + "        \"alpha3Code\": \"AFG\",\n"
        + "        \"callingCodes\": [\n"
        + "            \"93\"\n"
        + "        ],\n"
        + "        \"capital\": \"Kabul\",\n"
        + "        \"altSpellings\": [\n"
        + "            \"AF\",\n"
        + "            \"Afġānistān\"\n"
        + "        ],\n"
        + "        \"relevance\": \"0\",\n"
        + "        \"region\": \"Asia\",\n"
        + "        \"subregion\": \"Southern Asia\",\n"
        + "        \"translations\": {\n"
        + "            \"de\": \"Afghanistan\",\n"
        + "            \"es\": \"Afganistán\",\n"
        + "            \"fr\": \"Afghanistan\",\n"
        + "            \"ja\": \"アフガニスタン\",\n"
        + "            \"it\": \"Afghanistan\"\n"
        + "        },\n"
        + "        \"population\": 26023100,\n"
        + "        \"latlng\": [\n"
        + "            33,\n"
        + "            65\n"
        + "        ],\n"
        + "        \"demonym\": \"Afghan\",\n"
        + "        \"area\": 652230,\n"
        + "        \"gini\": 27.8,\n"
        + "        \"timezones\": [\n"
        + "            \"UTC+04:30\"\n"
        + "        ],\n"
        + "        \"borders\": [\n"
        + "            \"IRN\",\n"
        + "            \"PAK\",\n"
        + "            \"TKM\",\n"
        + "            \"UZB\",\n"
        + "            \"TJK\",\n"
        + "            \"CHN\"\n"
        + "        ],\n"
        + "        \"nativeName\": \"افغانستان\",\n"
        + "        \"numericCode\": \"004\",\n"
        + "        \"currencies\": [\n"
        + "            \"AFN\"\n"
        + "        ],\n"
        + "        \"languages\": [\n"
        + "            \"ps\",\n"
        + "            \"uz\",\n"
        + "            \"tk\"\n"
        + "        ]\n"
        + "    }]"));

    CountryService service = retrofit.create(CountryService.class);

    //With your service created you can now call its method that should
    //consume the MockResponse above. You can then use the desired
    //assertion to check if the result is as expected. For example:
    Call<List<Country>> call = service.countryList();
    assertTrue(call.execute() != null);

    //Finish web server
    mockWebServer.shutdown();
  }
}
