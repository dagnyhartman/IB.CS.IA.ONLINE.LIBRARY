public class Book
{
    private String title; // Title of each book
    private String genre; // Genre of each book
        public Book (String title, String genre) { // Constructor: initializes book with title and genre
            this.title = title;
            this.genre = genre;
        }
    
        public String getTitle() { // Getter method: gets title of the user inputted book
            return title;
        }
    
        public String getGenre() { // Getter method: gets genre of the user inputted book
            return genre;
        }
    
}