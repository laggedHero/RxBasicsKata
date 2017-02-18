package org.sergiiz.rxkata;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.FutureTask;

import io.reactivex.Observable;
import io.reactivex.Single;

class CountriesServiceSolved implements CountriesService {

  @Override
  public Single<String> countryNameInCapitals(Country country) {
    return Single.just(country)
        .map(country1 -> country1.name)
        .map(name -> name.toUpperCase(Locale.US));
  }

  public Single<Integer> countCountries(List<Country> countries) {
    return Single.just(countries)
        .map(countries1 -> countries1.size());
  }

  public Observable<Long> listPopulationOfEachCountry(List<Country> countries) {
    return Observable.fromIterable(countries)
        .map(country -> country.population);
  }

  @Override
  public Observable<String> listNameOfEachCountry(List<Country> countries) {
    return Observable.fromIterable(countries)
        .map(country -> country.name);
  }

  @Override
  public Observable<Country> listOnly3rdAnd4thCountry(List<Country> countries) {
    return Observable.fromIterable(countries)
        .skip(2)
        .take(2);
  }

  @Override
  public Single<Boolean> isAllCountriesPopulationMoreThanOneMillion(List<Country> countries) {
    return Observable.fromIterable(countries)
        .all(country -> country.population > 1_000_000);
  }

    @Override
    public Observable<Country> listPopulationMoreThanOneMillion(List<Country> countries) {
        return null; // put your solution here
    }

    @Override
    public Observable<Country> listPopulationMoreThanOneMillionWithTimeoutFallbackToEmpty(final FutureTask<List<Country>> countriesFromNetwork) {
        return null; // put your solution here
    }

  @Override
  public Observable<String> getCurrencyUsdIfNotFound(String countryName, List<Country> countries) {
    return Observable.fromIterable(countries)
        .filter(country -> country.name.equals(countryName))
        .map(country -> country.currency)
        .defaultIfEmpty("USD");
  }

  @Override
  public Observable<Long> sumPopulationOfCountries(List<Country> countries) {
    return Observable.fromIterable(countries)
        .map(country -> country.population)
        .reduce((population1, population2) -> population1 + population2)
        .toObservable();
  }

    @Override
    public Single<Map<String, Long>> mapCountriesToNamePopulation(List<Country> countries) {
        return null; // put your solution here
    }

    @Override
    public Observable<Long> sumPopulationOfCountries(Observable<Country> countryObservable1,
                                                     Observable<Country> countryObservable2) {
        return null; // put your solution here
    }

    @Override
    public Single<Boolean> areEmittingSameSequences(Observable<Country> countryObservable1,
                                                    Observable<Country> countryObservable2) {
        return null; // put your solution here
    }
}
