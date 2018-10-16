/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author rueln
 */
public class RatingRegister {

    private Map<Film, List<Rating>> ratings = new HashMap<Film, List<Rating>>();
    private Map<Person, HashMap<Film, Rating>> personalRatings = new HashMap<Person, HashMap<Film, Rating>>();

    public RatingRegister() {
    }

    public void addRating(Film film, Rating rating) {
        if (!ratings.containsKey(film)) {
            ratings.put(film, new ArrayList<Rating>());
        }

        ratings.get(film).add(rating);
    }

    public List<Rating> getRatings(Film film) {
        return ratings.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return ratings;
    }

    public void addRating(Person person, Film film, Rating rating) {
        if (!personalRatings.containsKey(person)) {
            HashMap<Film, Rating> personalRating = new HashMap<Film, Rating>();
            personalRatings.put(person, personalRating);
        }

        personalRatings.get(person).put(film, rating);
        addRating(film, rating);

    }

    public Rating getRating(Person person, Film film) {

        if (personalRatings.get(person) == null) {
            return Rating.NOT_WATCHED;
        }

        if (personalRatings.get(person).isEmpty()) {
            return Rating.NOT_WATCHED;
        }

        if (personalRatings.get(person).get(film) == null) {
            return Rating.NOT_WATCHED;
        }

        return personalRatings.get(person).get(film);
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {        
        //had to add this if statement to fix error in testing
        if (!personalRatings.containsKey(person)) {
            HashMap<Film, Rating> personalRating = new HashMap<Film, Rating>();
            personalRatings.put(person, personalRating);
        }

        return personalRatings.get(person);
    }

    public List<Person> reviewers() {
        List<Person> reviewers = new ArrayList<Person>();

        for (Person person : personalRatings.keySet()) {
            reviewers.add(person);
        }

        return reviewers;
    }

}
