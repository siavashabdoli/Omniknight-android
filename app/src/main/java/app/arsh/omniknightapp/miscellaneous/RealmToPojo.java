package app.arsh.omniknightapp.miscellaneous;

import app.arsh.omniknightapp.model.entity.Country;
import app.arsh.omniknightapp.model.repo.local.entity.DBCountry;
import io.realm.Realm;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arash on 10/24/16.
 */

public class RealmToPojo {

    public static Country dbCountryToCountry(DBCountry dbCountry){
        Country country = new Country();
        country.setAlpha2Code(dbCountry.getAlpha2Code());
        country.setAlpha3Code(dbCountry.getAlpha3Code());
        country.setArea(dbCountry.getArea());
        country.setCapital(dbCountry.getCapital());
        List<String> currencies = new ArrayList<>();
        currencies.add(dbCountry.getCurrencies());
        country.setCurrencies(currencies);
        country.setDemonym(dbCountry.getDemonym());
        country.setGini(dbCountry.getGini());
        List<String> lang = new ArrayList<>();
        lang.add(dbCountry.getLanguages());
        country.setLanguages(lang);
        country.setName(dbCountry.getName());
        country.setNativeName(dbCountry.getNativeName());
        country.setNumericCode(dbCountry.getNumericCode());
        country.setPopulation(dbCountry.getPopulation());
        country.setRegion(dbCountry.getRegion());

        return country;
    }

    public static DBCountry createAndConvertCountryToCountry(Realm realm, Country country){
        DBCountry dbCountry = realm.createObject(DBCountry.class, country.getName());
        dbCountry.setAlpha2Code(country.getAlpha2Code());
        dbCountry.setAlpha3Code(country.getAlpha3Code());
        dbCountry.setArea(country.getArea());
        dbCountry.setCapital(country.getCapital());
        String currencies = country.getCurrencies().get(0);
        dbCountry.setCurrencies(currencies);
        country.setDemonym(country.getDemonym());
        country.setGini(country.getGini());
        String lang = country.getLanguages().get(0);
        dbCountry.setLanguages(lang);
        dbCountry.setNativeName(country.getNativeName());
        dbCountry.setNumericCode(country.getNumericCode());
        dbCountry.setPopulation(country.getPopulation());
        dbCountry.setRegion(country.getRegion());

        return dbCountry;
    }

}
