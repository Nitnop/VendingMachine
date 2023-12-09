// replace populator class with read and write to txt file

//import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.*;


public class LoadUnload {
    private static String filePath = "save.txt";
    static Scanner stdIn = new Scanner(System.in);
    static Movie testObject;

    
    public static CopyOnWriteArrayList<Movie> loadMoviesFromFile() {
        
        CopyOnWriteArrayList<Movie> movieList = new CopyOnWriteArrayList<>();
    
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(","); // Assuming the data is comma-separated
                    if (data.length == 5) {
                        // Assuming the format is: Title, Actor, Genre, Year, Quantity
                        String title = data[0].trim();
                        String actor = data[1].trim();
                        String genre = data[2].trim();
                        int year = Integer.parseInt(data[3].trim());
                        int quantity = Integer.parseInt(data[4].trim());
    
                        Movie movie = new Movie(title, actor, genre, year, quantity);
                        movieList.add(movie);
                    }
                }
                System.out.println("Data read from " + filePath);
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
    
            return movieList;
        }

    
    public static void saveFile(CopyOnWriteArrayList<Movie> movieList){
        //System.out.println("Enter file name: ");

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Iterate through the ArrayList and write object details to the file
            for (Movie obj : movieList) {
                writer.println(obj.getTitle() + "," + obj.getActor() + "," + obj.getGenre() + "," + obj.getYear() + "," + obj.getQuantity()); // Customize this line to fit your object structure, Done
            }
            System.out.println("Data written to " + filePath);
        }
        catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}