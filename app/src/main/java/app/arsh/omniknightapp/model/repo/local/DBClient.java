package app.arsh.omniknightapp.model.repo.local;

import android.app.Application;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.model.repo.local.entity.CountryDao;
import app.arsh.omniknightapp.model.repo.local.entity.DaoMaster;
import app.arsh.omniknightapp.model.repo.local.entity.DaoSession;
import org.greenrobot.greendao.database.Database;

/**
 * Created by arash on 10/24/16.
 */

public class DBClient {

    private final DaoSession daoSession;

    public DBClient(Application application) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(application, "weather-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public void addNewCountry(Country country) {
        CountryDao countryDao = daoSession.getCountryDao();
        countryDao.insert(country);
    }

    //public List<Country> getAvailableCountries(){
    //    return new LocalCountryService().getLocalCountries(realm);
    //}
    //
    //public Country getSpecificCounty(Country country){
    //    return new LocalCountryService().getSpecificCountry(realm, country);
    //}
    //
    //public void addNewCountry(Country country){
    //    new LocalCountryService().addLocalCountry(realm, country);
    //}
    //
    //public void removeCountry(Country country){
    //    new LocalCountryService().removeCountry(realm, country);
    //}

}
