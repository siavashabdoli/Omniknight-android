package app.arsh.omniknightapp.model.repo.local;

import android.app.Application;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.model.repo.local.entity.CountryDao;
import app.arsh.omniknightapp.model.repo.local.entity.DaoMaster;
import app.arsh.omniknightapp.model.repo.local.entity.DaoSession;
import java.util.List;
import org.greenrobot.greendao.database.Database;
import rx.Observable;
import rx.Observer;

/**
 * Created by arash on 10/24/16.
 */

public class DBClient {

    private final DaoSession daoSession;
    private Observer<Country> countryChangeObserver;

    public void setCountryChangeObserver(Observer<Country> countryChangeObserver) {
        this.countryChangeObserver = countryChangeObserver;
    }

    public DBClient(Application application) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(application, application.getString(
                    R.string.db_name));
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public Boolean addNewCountry(Country country) {
        CountryDao countryDao = daoSession.getCountryDao();
        List<Country> inDB = daoSession.getCountryDao().queryBuilder()
            .where(CountryDao.Properties.Name.in(country.getName())).list();
        if (inDB.size() == 0) {
            countryDao.insert(country);
            Observable.just(country).subscribe(countryChangeObserver);
            return true;
        }else {
            return false;
        }
    }

    public Boolean removeCountry(Country country) {
        CountryDao countryDao = daoSession.getCountryDao();
        List<Country> inDB = daoSession.getCountryDao().queryBuilder()
            .where(CountryDao.Properties.Name.in(country.getName())).list();
        if (inDB.size() == 0) {
            countryDao.delete(inDB.get(0));
            return true;
        }else {
            return false;
        }
    }

    public void removeCountryList(List<Country> countries) {
        CountryDao countryDao = daoSession.getCountryDao();
        for (Country country: countries) {
            List<Country> inDB = daoSession.getCountryDao().queryBuilder()
                .where(CountryDao.Properties.Name.in(country.getName())).list();
            if (inDB.size() > 0) {
                countryDao.delete(inDB.get(0));
                if (countries.size() > 0) Observable.just(country).subscribe(countryChangeObserver);
            }
        }

    }

    public List<Country> getCountries() {
        return daoSession.getCountryDao().loadAll();
    }

    public void clearDataBase() {
        daoSession.getCountryDao().deleteAll();
    }
}
