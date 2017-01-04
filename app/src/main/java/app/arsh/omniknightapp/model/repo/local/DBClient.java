package app.arsh.omniknightapp.model.repo.local;

import android.content.Context;
import app.arsh.omniknightapp.model.entity.Country;
import io.realm.Realm;
import java.util.List;

/**
 * Created by arash on 10/24/16.
 */

public class DBClient {

    private final Realm realm;

    public DBClient(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public List<Country> getAvailableCountries(){
        return new LocalCountryService().getLocalCountries(realm);
    }

    public Country getSpecificCounty(Country country){
        return new LocalCountryService().getSpecificCountry(realm, country);
    }

    public void addNewCountry(Country country){
        new LocalCountryService().addLocalCountry(realm, country);
    }

    public void removeCountry(Country country){
        new LocalCountryService().removeCountry(realm, country);
    }

}
