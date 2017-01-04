package app.arsh.omniknightapp.model.repo.local;

import app.arsh.omniknightapp.miscellaneous.RealmToPojo;
import app.arsh.omniknightapp.model.entity.Country;
import app.arsh.omniknightapp.model.repo.local.entity.DBCountry;
import io.realm.Realm;
import io.realm.RealmResults;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arash on 10/24/16.
 */

public class LocalCountryService {

    public List<Country> getLocalCountries(Realm realm){
        List<DBCountry> dbResult = realm.where(DBCountry.class).findAll();
        List<Country> convertedResult = new ArrayList<>();
        for (DBCountry country: dbResult){
            convertedResult.add(RealmToPojo.dbCountryToCountry(country));
        }

        return convertedResult;
    }

    public Country getSpecificCountry(Realm realm, Country country){
        DBCountry dbResult = realm
                .where(DBCountry.class)
                .equalTo("name", country.getName())
                .findFirst();
        if (dbResult == null) return null;
        else return RealmToPojo.dbCountryToCountry(dbResult);
    }

    public void addLocalCountry(Realm realm, Country country){
        realm.beginTransaction();
        RealmToPojo.createAndConvertCountryToCountry(realm, country);
        realm.commitTransaction();
    }

    public void removeCountry(Realm realm, Country country){
        final RealmResults<DBCountry> results = realm.
                where(DBCountry.class).
                equalTo("name", country.getName()).
                findAll();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                results.deleteFirstFromRealm();
            }
        });

    }

}
