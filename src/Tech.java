import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Tech {

    static CopyOnWriteArrayList<Movie> movieList = new CopyOnWriteArrayList<Movie>(LoadUnload.loadMoviesFromFile());
    static int index;
    
    
    public static void Start(){

        System.out.println("Welcome back, what are we up to today?\n");

        do{
        techPromps();

        switch(Idiotproofing.idiotResistnantInt()){

            case 1:
                removeMovie(movieList);
                break;
            
            case 2:
                addmovie(movieList);
                break;
            case 3:
                restock(movieList);
            }
        } while(true);
    }

private static void addmovie(CopyOnWriteArrayList<Movie> movieList){
    System.out.println("Enter the Tilte of the movie");
    String title = Idiotproofing.idiotResistnantString();
    
    System.out.println("Enter the lead actor");
    String actor = Idiotproofing.idiotResistnantString();
    
    System.out.println("Enter the genre");
    String genre = Idiotproofing.idiotResistnantString();
    
    System.out.println("Enter the year");
    int year = Idiotproofing.idiotResistnantInt();
    
    System.out.println("Enter the stock quantity");
    int quantity = Idiotproofing.idiotResistnantInt();

    Movie movie = new Movie(title, actor, genre, year, quantity);
    movieList.add(movie);

    System.out.println(movie + "has been added to the list");

    sortByTitle(movieList);  //sort save and exit
    LoadUnload.saveFile(movieList);
    System.exit(0);


}

private static void restock(CopyOnWriteArrayList<Movie> movieList){
    System.out.println("Enter number of movie to restock");
                    
    User.printMovieList();

    index = Idiotproofing.idiotResistnantInt() - 1;
    System.out.println("You entered " + movieList.get(index));
    System.out.println("How many are here now?");
    movieList.get(index).quantity = Idiotproofing.idiotResistnantInt();
    
    sortByTitle(movieList);  //sort save and exit
    LoadUnload.saveFile(movieList);
    System.exit(0);

}

private static void techPromps(){

    System.out.println("1: Remove an old movie.");
    System.out.println("2: Add a new movie.");
    System.out.println("3: Restock / change quantitys.");

}

public static void removeMovie(CopyOnWriteArrayList<Movie> movieList){
    System.out.println("enter number of movie to remove");
                    
    User.printMovieList();

    index = Idiotproofing.idiotResistnantInt() - 1;
    System.out.println("You entered " + movieList.get(index));
    System.out.println("Are you sure you want to delete this movie?\n1 = yes\n2 = no");

    if(Idiotproofing.idiotResistnantInt() == 1){
        movieList.remove(index);
        sortByTitle(movieList);
        LoadUnload.saveFile(movieList);
        System.exit(0);
    }
    else{
        System.exit(0);}
    

    
    }  
    
private static void sortByTitle(CopyOnWriteArrayList<Movie> movieList) {
    Collections.sort(movieList, Comparator.comparing(Movie::getTitle));
}
}