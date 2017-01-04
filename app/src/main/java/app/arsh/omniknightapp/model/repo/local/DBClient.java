package app.arsh.omniknightapp.model.repo.local;

import android.app.Application;
import app.arsh.omniknightapp.R;
import app.arsh.omniknightapp.model.repo.local.entity.Country;
import app.arsh.omniknightapp.model.repo.local.entity.CountryDao;
import app.arsh.omniknightapp.model.repo.local.entity.DaoMaster;
import app.arsh.omniknightapp.model.repo.local.entity.DaoSession;
import java.util.List;
import org.greenrobot.greendao.database.Database;

;

/**
 * Created by arash on 10/24/16.
 */

public class DBClient {

    private final DaoSession daoSession;

    public DBClient(Application application) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(application, application.getString(
                    R.string.db_name));
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public void addNewCountry(Country country) {
        CountryDao countryDao = daoSession.getCountryDao();
        countryDao.insert(country);
    }

    public List<Country> getCountries() {
        return daoSession.getCountryDao().loadAll();
    }
}
