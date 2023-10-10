import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Movie {
    private String title;
    private int availableSeats;

    public Movie(String title, int availableSeats) {
        this.title = title;
        this.availableSeats = availableSeats;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int numSeats) {
        if (numSeats <= availableSeats) {
            availableSeats -= numSeats;
            System.out.println("Tickets booked successfully!");
        } else {
            System.out.println("Sorry, not enough seats available.");
        }
    }
}

public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();

        // Add some sample movies to the system
        movies.add(new Movie("Jailer 1", 50));
        movies.add(new Movie("Spider Man 2", 30));
        movies.add(new Movie("Mr.Robot 3", 20));

        while (true) {
            System.out.println("Welcome to Movie Ticket Booking System");
            System.out.println("1. List Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. Exit");
            System.out.print("Select an Option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listMovies(movies);
                    break;
                case 2:
                    bookTickets(movies, scanner);
                    break;
                case 3:
                    System.out.println("Thank you for using the Movie Ticket Booking System ! Have a Great Day ");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void listMovies(List<Movie> movies) {
        System.out.println("Available Movies:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i).getTitle() +
                    " (" + movies.get(i).getAvailableSeats() + " seats available)");
        }
    }

    private static void bookTickets(List<Movie> movies, Scanner scanner) {
        listMovies(movies);

        System.out.print("Enter the movie number to book tickets: ");
        int movieNumber = scanner.nextInt();

        if (movieNumber >= 1 && movieNumber <= movies.size()) {
            Movie selectedMovie = movies.get(movieNumber - 1);
            System.out.print("Enter the number of tickets to book: ");
            int numSeats = scanner.nextInt();

            selectedMovie.bookSeats(numSeats);
        } else {
            System.out.println("Invalid movie selection.");
        }
    }
}
