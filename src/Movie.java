import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Movie implements Serializable {   

    public Movie(){
        title = "null";
        actor = "null";
        genre = "null";
        year = 0;
        quantity = 0;
    }

    public Movie(String titleIn, String actorIn, String genreIn, int yearIn, int quantityIn){
        this.title = titleIn;
        this.actor = actorIn;
        this.genre = genreIn;
        this.year = yearIn;
        this.quantity = quantityIn;
        
    }
        
    static String titleSearch;
    static int numOfindexToRemove;
    protected String title;
    protected String actor;
    protected String genre;
    protected int year;
    protected int quantity;
    protected String stringQuantity;
    static int searchHits;
    static Scanner UserInput = new Scanner(System.in);

    public String toString(){
        return "[" + title + ", " + actor + ", " + genre + ", " + year + "," + quantity + "]";
    }

    public  String getTitle(){
        return title;
    }
    
    public String getActor(){
        return actor;
    }
    public String getGenre(){
        return genre;
    }
    public int getYear(){
        return year;
    }
    public int getQuantity(){
        return quantity;
    }
    
    public static ArrayList<Movie> sortTitleAtoZ(CopyOnWriteArrayList<Movie> movieList){
        ArrayList<Movie> AtoZmovieList = new ArrayList<Movie>(movieList);
        AtoZmovieList.sort(Comparator.comparing(Movie::getTitle));
        return AtoZmovieList;
    }
}