public class CinemaTimeMain {
    public static void main(String[] args) {
        CinemaTimeManager manager = new CinemaTimeManager();
        try {
            manager.addMovie("Dhurandhar", "3:00");
            manager.addMovie("Kashmir Files", "2:05");
            manager.addMovie("Kerela Files", "2:15");
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nAll Movies:");
        manager.displayAllMovies();
        System.out.println("\nSearch Results:");
        manager.searchMovie("Dhur");
        System.out.println("\nPrintable Report:");
        String[] report = manager.generateReport();
        for (String entry : report) {
            System.out.println(entry);
        }
    }
}