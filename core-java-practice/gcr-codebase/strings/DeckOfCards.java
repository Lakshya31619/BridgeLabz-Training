import java.util.Scanner;
public class DeckOfCards {
    public static void main(String[] args) {
        //Suits and ranks
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        //Initialize the deck
        String[] deck = initialize(suits, ranks);
        //Shuffle the deck
        shuffle(deck);
        //Input
        Scanner sc = new Scanner(System.in);
        //Number of players
        int x = sc.nextInt();
        //Number of cards
        int n = sc.nextInt();
        // Distribute cards
        String[][] players = distribute(deck, n, x);
        // Print players and their cards
        printPlayers(players);
    }
    //Function to initialize the deck of cards
    public static String[] initialize(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }
    //Function to shuffle the deck
    public static void shuffle(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            // Swap cards
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }
    //Function to distribute cards to players
    public static String[][] distribute(String[] deck, int n, int x) {
        if (n % x != 0) {
            System.out.println("Cannot evenly distribute " + n + " cards among " + x + " players.");
            return null;
        }
        int cardsPerPlayer = n / x;
        String[][] players = new String[x][cardsPerPlayer];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[i * cardsPerPlayer + j];
            }
        }
        return players;
    }
    //Function to print players cards
    public static void printPlayers(String[][] players) {
        if (players == null) return;
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (String card : players[i]) {
                System.out.println("  " + card);
            }
            System.out.println();
        }
    }
}