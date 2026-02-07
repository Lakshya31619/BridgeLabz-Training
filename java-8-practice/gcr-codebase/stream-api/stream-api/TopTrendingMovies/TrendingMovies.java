import java.util.*;
import java.util.stream.*;
public class TrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Movie A", 9.1, 2023),
                new Movie("Movie B", 8.7, 2022),
                new Movie("Movie C", 9.1, 2024),
                new Movie("Movie D", 8.9, 2023),
                new Movie("Movie E", 9.0, 2021),
                new Movie("Movie F", 8.5, 2024),
                new Movie("Movie G", 9.2, 2022)
        );
        List<Movie> top5TrendingMovies = movies.stream()
                .filter(movie -> movie.getRating() > 0)
                .sorted(
                        Comparator.comparing(Movie::getRating).reversed()
                                .thenComparing(Movie::getReleaseYear).reversed()
                )
                .limit(5)
                .collect(Collectors.toList());
        top5TrendingMovies.forEach(System.out::println);
    }
}