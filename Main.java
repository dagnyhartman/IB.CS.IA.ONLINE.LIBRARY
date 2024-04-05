import java.util.Scanner;
import java.util.Arrays;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner (System.in);
        Book[] books = new Book[100]; // Creates array for user inputted books, has a maximum of 100 books
        int bookAmt = 0; // Sets initial value of amount of books as zero
        String endWord = "exit"; // Sets "exit" as the word to end the program
        
        System.out.println("Welcome to your online library! Please input the title and genre of your books (minimum 5, maximum 100) to organize your books alphebetically and receive new book reccomendations.");
        
        while (true) // While the user is still inputting books
        {
            System.out.println("Enter the title of the book (type " + endWord + " to finish inputting books): "); // Asks user for title of book
            String title = scanner.nextLine(); // Creates object for title
            
            if (title.equalsIgnoreCase(endWord)) // If the user inputs the end phrase, ignoring upper/lowercase
            {
                break; // Ends program
            }
            
            System.out.println("Enter the genre of the book (r for romance, f for fantasy, t for thriller, and s for science fiction): "); // Asks user for genre of book and tells them the different options
            String genre = scanner.nextLine().toLowerCase();
            
            if (!isValidGenre(genre)) // Verfies that the user has inputted a valid value for genre
            {
                System.out.println("Invalid genre input. Please enter r for romance, f for fantasy, t for thriller, or s for science fiction. "); // If they have input an invalid value, print this message
                continue; // Loop continues
            }
            
            String allGenre = mapGenre(genre); // Maps the inputted genre values to genre names
            
            books[bookAmt] = new Book (title, allGenre); // Creates and adds book object to the array
            bookAmt++;
        }
        
        Arrays.sort(books, 0, bookAmt, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle())); // Organizes books alphabetically
            
        System.out.println("\nAlphabetical List Of Your Library: "); // Prints alphebetical list of books
        for (int i = 0; i < bookAmt; i++)
        {
            System.out.println(books[i].getTitle() + " - " + books[i].getGenre());
        }
            
        int[] genreCounter = new int[4]; // Array to store the counts of each genre
        for (int i = 0; i < bookAmt; i++)
        {
            switch (books[i].getGenre())
            {
                case "Romance": // works
                    genreCounter[0]++;
                    break;
                case "Thriller":
                    genreCounter[1]++;
                    break;
                case "Science Fiction": // GOOD
                    genreCounter[2]++;
                    break;
                case "Fantasy":
                    genreCounter[3]++;
                    break;
            }
        }
            
        int maxValue = 0; // Finds the most common genre
        int maxNum = 0;
        for (int i = 0; i < 4; i++)
        {
            if (genreCounter[i] > maxValue)
            {
                maxValue = genreCounter[i];
                maxNum = i;
            }
            else
            {
                break;
            }
        }
         
        System.out.println("\nHere are some reccomendations based on your most common genre- " + mapGenreBack(maxValue) + ": ");
        switch (maxNum) // Prints reccomendations based on the users most popular genre
        {
            case 0: // ROMANCE RECS- works
                System.out.println("Sense and Sensibility");
                System.out.println("Wuthering Heights");
                System.out.println("The Seven Husbands of Evelyn Hugo");
                System.out.println("Love and Other Words");
                break;
            case 1: // THRILLER RECS
                System.out.println("Murder on the Orient Express");
                System.out.println("The Silent Patient");
                System.out.println("Gone Girl");
                System.out.println("The Girl on the Train");
                break;
            case 2: // SCI FI RECS
                System.out.println("Pandora's Star");
                System.out.println("Planetfall");
                System.out.println("The Plot Against America");
                System.out.println("Red Rising");
                break;
            case 3: // FANTASY RECS
                System.out.println("The Hobbit");
                System.out.println("A Game of Thrones");
                System.out.println("The Lord of the Rings");
                System.out.println("The Little Prince");
                break;
            default:
                System.out.println("No reccomendations availible for your genres.");
        }
        
        scanner.close(); // Closes scanner
    }
        
    private static boolean isValidGenre(String genre) // Validates genre input
    {
        return genre.equals("r") || genre.equals("t") || genre.equals ("s") || genre.equals("f");
    } 
        
    private static String mapGenre (String genre) // Maps genre input to genre's full name
    {
        switch (genre)
        {
            case "r":// works
                return "Romance";
            case "t":
                return "Thriller";
            case "s":
                return "Science Fiction";
            case "f":
                return "Fantasy"; //thriller
            default:
                return "";
        }
    }
        
    private static String mapGenreBack (int index) // Maps genre index (case number) back to genre name
    {
        switch (index)
        {
            case 0:
                return "Romance";// works
            case 1:
                return "Thriller"; // switched romance and thriller
            case 2:
                return "Science Fiction";
            case 3:
                return "Fantasy"; //thriller 
            default:
                return "";
        }
    }
}