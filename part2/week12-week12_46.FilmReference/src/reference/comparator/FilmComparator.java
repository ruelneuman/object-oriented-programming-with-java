/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author rueln
 */
public class FilmComparator implements Comparator<Film> {

    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compare(Film film1, Film film2) {
        return Double.compare(averageRating(film2), averageRating(film1));
    }

    private double averageRating(Film film) {
        List<Rating> ratingList;

        if (ratings.containsKey(film)) {
            ratingList = ratings.get(film);
        } else {
            return 0.0;
        }

        double sum = 0.0;

        for (Rating rating : ratingList) {
            sum += rating.getValue();
        }

        return (double) sum / ratingList.size();
    }

}
