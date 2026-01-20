import java.util.*;
class CinemaTimeManager {
    private List<String> movieTitles = new ArrayList<>();
    private List<String> showTimes = new ArrayList<>();
    // Add a movie with validation
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        showTimes.add(time);
    }
    // Search movie by keyword
    public void searchMovie(String keyword) {
        try {
            boolean found = false;
            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                    String output = String.format("Movie: %s | Time: %s", movieTitles.get(i), showTimes.get(i));
                    System.out.println(output);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No movie found with keyword: " + keyword);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Search index error occurred.");
        }
    }
    // Display all movies
    public void displayAllMovies() {
        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println(movieTitles.get(i) + " - " + showTimes.get(i));
        }
    }
    // Convert list to array for reports
    public String[] generateReport() {
        String[] report = new String[movieTitles.size()];

        for (int i = 0; i < movieTitles.size(); i++) {
            report[i] = movieTitles.get(i) + " @ " + showTimes.get(i);
        }
        return report;
    }
    // Time validation (HH:mm)
    private boolean isValidTime(String time) {
        try {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
        } catch (Exception e) {
            return false;
        }
    }
}