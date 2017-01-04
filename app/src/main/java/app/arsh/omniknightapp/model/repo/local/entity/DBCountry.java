package app.arsh.omniknightapp.model.repo.local.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DBCountry extends RealmObject {

    @PrimaryKey
    private String name;
    private String alpha2Code;
    private String alpha3Code;
    private String capital;
    private String relevance;
    private String region;
    private String subregion;
    private Integer population;
    private String demonym;
    private Double area;
    private Double gini;
    private String nativeName;
    private String numericCode;
    private String currencies;
    private String languages;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public DBCountry withName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @return
     * The alpha2Code
     */
    public String getAlpha2Code() {
        return alpha2Code;
    }

    /**
     *
     * @param alpha2Code
     * The alpha2Code
     */
    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public DBCountry withAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
        return this;
    }

    /**
     *
     * @return
     * The alpha3Code
     */
    public String getAlpha3Code() {
        return alpha3Code;
    }

    /**
     *
     * @param alpha3Code
     * The alpha3Code
     */
    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public DBCountry withAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
        return this;
    }

    /**
     *
     * @return
     * The capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     *
     * @param capital
     * The capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    public DBCountry withCapital(String capital) {
        this.capital = capital;
        return this;
    }

    /**
     *
     * @return
     * The relevance
     */
    public String getRelevance() {
        return relevance;
    }

    /**
     *
     * @param relevance
     * The relevance
     */
    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public DBCountry withRelevance(String relevance) {
        this.relevance = relevance;
        return this;
    }

    /**
     *
     * @return
     * The region
     */
    public String getRegion() {
        return region;
    }

    /**
     *
     * @param region
     * The region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    public DBCountry withRegion(String region) {
        this.region = region;
        return this;
    }

    /**
     *
     * @return
     * The subregion
     */
    public String getSubregion() {
        return subregion;
    }

    /**
     *
     * @param subregion
     * The subregion
     */
    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public DBCountry withSubregion(String subregion) {
        this.subregion = subregion;
        return this;
    }

    /**
     *
     * @return
     * The population
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     *
     * @param population
     * The population
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

    public DBCountry withPopulation(Integer population) {
        this.population = population;
        return this;
    }

    /**
     *
     * @return
     * The demonym
     */
    public String getDemonym() {
        return demonym;
    }

    /**
     *
     * @param demonym
     * The demonym
     */
    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public DBCountry withDemonym(String demonym) {
        this.demonym = demonym;
        return this;
    }

    /**
     *
     * @return
     * The area
     */
    public Double getArea() {
        return area;
    }

    /**
     *
     * @param area
     * The area
     */
    public void setArea(Double area) {
        this.area = area;
    }

    public DBCountry withArea(Double area) {
        this.area = area;
        return this;
    }

    /**
     *
     * @return
     * The gini
     */
    public Double getGini() {
        return gini;
    }

    /**
     *
     * @param gini
     * The gini
     */
    public void setGini(Double gini) {
        this.gini = gini;
    }

    public DBCountry withGini(Double gini) {
        this.gini = gini;
        return this;
    }

    /**
     *
     * @return
     * The nativeName
     */
    public String getNativeName() {
        return nativeName;
    }

    /**
     *
     * @param nativeName
     * The nativeName
     */
    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public DBCountry withNativeName(String nativeName) {
        this.nativeName = nativeName;
        return this;
    }

    /**
     *
     * @return
     * The numericCode
     */
    public String getNumericCode() {
        return numericCode;
    }

    /**
     *
     * @param numericCode
     * The numericCode
     */
    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public DBCountry withNumericCode(String numericCode) {
        this.numericCode = numericCode;
        return this;
    }

    /**
     *
     * @return
     * The currencies
     */
    public String getCurrencies() {
        return currencies;
    }

    /**
     *
     * @param currencies
     * The currencies
     */
    public void setCurrencies(String currencies) {
        this.currencies = currencies;
    }


    /**
     *
     * @return
     * The languages
     */
    public String getLanguages() {
        return languages;
    }

    /**
     *
     * @param languages
     * The languages
     */
    public void setLanguages(String languages) {
        this.languages = languages;
    }

}