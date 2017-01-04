package app.arsh.omniknightapp.model.repo.local.entity;

import android.support.annotation.NonNull;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by arash on 1/4/17.
 */

@Entity(indexes = {
    @Index(value = "name, alpha2Code, alpha3Code, capital, relevance, region, subregion, population, demonym, area, nativeName, numericCode, currencies, languages", unique = true)
})
public class Country {

  @NonNull
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

  @Id
  private Long id;

  @Generated(hash = 800107562)
  public Country(@NonNull String name, String alpha2Code, String alpha3Code, String capital, String relevance, String region, String subregion, Integer population, String demonym,
          Double area, Double gini, String nativeName, String numericCode, String currencies, String languages, Long id) {
      this.name = name;
      this.alpha2Code = alpha2Code;
      this.alpha3Code = alpha3Code;
      this.capital = capital;
      this.relevance = relevance;
      this.region = region;
      this.subregion = subregion;
      this.population = population;
      this.demonym = demonym;
      this.area = area;
      this.gini = gini;
      this.nativeName = nativeName;
      this.numericCode = numericCode;
      this.currencies = currencies;
      this.languages = languages;
      this.id = id;
  }

  @Generated(hash = 668024697)
  public Country() {
  }

  public String getSubregion() {
    return subregion;
  }

  public void setSubregion(String subregion) {
    this.subregion = subregion;
  }

  public String getRelevance() {
    return relevance;
  }

  public void setRelevance(String relevance) {
    this.relevance = relevance;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public Integer getPopulation() {
    return population;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }

  public String getNumericCode() {
    return numericCode;
  }

  public void setNumericCode(String numericCode) {
    this.numericCode = numericCode;
  }

  public String getNativeName() {
    return nativeName;
  }

  public void setNativeName(String nativeName) {
    this.nativeName = nativeName;
  }

  @NonNull public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  public String getLanguages() {
    return languages;
  }

  public void setLanguages(String languages) {
    this.languages = languages;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getGini() {
    return gini;
  }

  public void setGini(Double gini) {
    this.gini = gini;
  }

  public String getDemonym() {
    return demonym;
  }

  public void setDemonym(String demonym) {
    this.demonym = demonym;
  }

  public String getCurrencies() {
    return currencies;
  }

  public void setCurrencies(String currencies) {
    this.currencies = currencies;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public Double getArea() {
    return area;
  }

  public void setArea(Double area) {
    this.area = area;
  }

  public String getAlpha3Code() {
    return alpha3Code;
  }

  public void setAlpha3Code(String alpha3Code) {
    this.alpha3Code = alpha3Code;
  }

  public String getAlpha2Code() {
    return alpha2Code;
  }

  public void setAlpha2Code(String alpha2Code) {
    this.alpha2Code = alpha2Code;
  }
}
