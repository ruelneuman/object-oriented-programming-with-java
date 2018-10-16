/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author rueln
 */
public class Reference {

    private RatingRegister register;

    public Reference(RatingRegister register) {
        this.register = register;
    }

    public Film recommendFilm(Person person) {
        //  if person has seen no films, recommend top rated film
        if (register.getPersonalRatings(person).isEmpty()) {
            List<Film> films = new ArrayList<Film>(register.filmRatings().keySet());
            Collections.sort(films, new FilmComparator(register.filmRatings()));
            return films.get(0);
        }

        if (watchedAllFilms(person)) {
            return null;
        }

        Film recommendedFilm = null;

        Map<Film, Rating> similarPersonalRatings = register.getPersonalRatings(similarPerson(person));


        for (Map.Entry<Film, Rating> entry : similarPersonalRatings.entrySet()) {
            Film film = entry.getKey();
            Rating similarRating = entry.getValue();
            Rating rating = register.getRating(person, film);

            if (rating == null || rating == Rating.NOT_WATCHED) {
                if (recommendedFilm == null || similarRating.getValue() > similarPersonalRatings.get(recommendedFilm).getValue()) {
                    recommendedFilm = film;
                }
            }
        }

        //return null if the recommended film doesn't have a positive rating
        if (similarPersonalRatings.get(recommendedFilm).getValue() <= 0) {
            return null;
        }

        return recommendedFilm;
    }

    private Boolean watchedAllFilms(Person person) {
        for (Film film : register.filmRatings().keySet()) {
            if (!register.getPersonalRatings(person).containsKey(film)) {
                return false;
            }
        }
        return true;
    }

    private Person similarPerson(Person person) {
        Map.Entry<Person, Integer> maxEntry = null;

        for (Map.Entry<Person, Integer> entry : similarityMap(person).entrySet()) {
            if (maxEntry == null || (entry.getValue() > maxEntry.getValue())) {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }

    private Map<Person, Integer> similarityMap(Person person) {
        Map<Person, Integer> similarityMap = new HashMap<Person, Integer>();

        for (Person compared : register.reviewers()) {
            if (!compared.equals(person)) {
                similarityMap.put(compared, similarityValue(person, compared));
            }
        }
        return similarityMap;
    }

    private int similarityValue(Person person1, Person person2) {
        int similarityValue = 0;

        Map<Film, Rating> personalRatings1 = register.getPersonalRatings(person1);
        Map<Film, Rating> personalRatings2 = register.getPersonalRatings(person2);

        for (Map.Entry<Film, Rating> entry : personalRatings1.entrySet()) {
            Film film = entry.getKey();
            Rating rating1 = entry.getValue();
            Rating rating2 = personalRatings2.get(film);

            if (rating2 != null) {
                similarityValue += (rating1.getValue() * rating2.getValue());
            }
        }

        return similarityValue;
    }

}
